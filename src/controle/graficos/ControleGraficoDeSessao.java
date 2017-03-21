package controle.graficos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Ano;

import com.google.gson.Gson;

import controle.servlet.CodificaUTF8;
import controle.servlet.ControleDeRetornoServlet;
import dao.GraficosDAO;

public class ControleGraficoDeSessao {
	
	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public ControleGraficoDeSessao(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void ConstroiArrayDeAnosParaGraficoDeSessaoUsuario(Ano ano) throws IOException, SQLException{
		ArrayList<Ano> anos = new ArrayList<>();
		anos.add(ano);
		ConstroiDadosParaGraficoDeSessaoUsuarioAno(anos);
	}
	
	private void ConstroiDadosParaGraficoDeSessaoUsuarioAno(ArrayList<Ano> anos) throws SQLException, IOException{
		try {
			GraficosDAO dao = new GraficosDAO();
			anos.get(0).setMeses_do_ano(dao.ConstroiDadosParaGraficoDeSessaoDoUsuarioAno(anos.get(0)));
			SomaTotalDeSessoesUsuarioAnoCorrente(anos);
		} catch (Exception e) {
			//new ControleDeRetornoServlet(request, response).RetornaErro();
		}
	}
	
	private void SomaTotalDeSessoesUsuarioAnoCorrente(ArrayList<Ano> anos) throws SQLException, IOException{
		try{
			int totalDeSessoesAno = 0;
			for(int mes = 0; mes < 12; mes++){
				totalDeSessoesAno += anos.get(0).getMeses_do_ano().get(mes).getValor();
			}
			anos.get(0).setValor(totalDeSessoesAno);
			ConstroiDadosParaGraficoDeSessaoUsuarioPorcentagem(anos);
		}catch(Exception e){
			//new ControleDeRetornoServlet(request, response).RetornaErro();
		}	
	}
	
	private void ConstroiDadosParaGraficoDeSessaoUsuarioPorcentagem(ArrayList<Ano> anos) throws SQLException, IOException{
		try {
			Ano ano = new Ano();
			ano.setId_de_busca(anos.get(0).getId_de_busca());
			anos.add(ano);
			
			GraficosDAO dao = new GraficosDAO();
			anos.get(1).setMeses_do_ano(dao.ConstroiDadosParaGraficoDeSessaoDoUsuarioPorcentagem(anos.get(1)));	
			SomaTotalDeSessoesUsuarioPorcentagem(anos);
		} catch (Exception e) {
			//new ControleDeRetornoServlet(request, response).RetornaErro();
		}
	}
	
	private void SomaTotalDeSessoesUsuarioPorcentagem(ArrayList<Ano> anos) throws SQLException, IOException{
		try{
			int totalDeSessoesAno = 0;
			for(int mes = 0; mes < 12; mes++){
				totalDeSessoesAno += anos.get(1).getMeses_do_ano().get(mes).getValor();
			}
			anos.get(1).setValor(totalDeSessoesAno);
			RetornaDadosParaGraficoDeSessaoUsuario(anos);
		}catch(Exception e){
			//new ControleDeRetornoServlet(request, response).RetornaErro();
		}	
	}
	
	private void RetornaDadosParaGraficoDeSessaoUsuario(ArrayList<Ano> anos) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		anos.set(0, new CodificaUTF8().CodificaAnoUTF8(anos.get(0)));
		anos.set(1, new CodificaUTF8().CodificaAnoUTF8(anos.get(1)));
		out.write(gson.toJson(anos));
	}
	
}
