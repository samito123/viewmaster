package controle.graficos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Ano;

import com.google.gson.Gson;

import controle.conexao.ControleCodificaUTF8;
import controle.conexao.ControleDeRetornoServidor;
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
			ConstroiDadosParaGraficoDeSessaoUsuarioPorcentagem(anos);
		} catch (Exception e) {
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void ConstroiDadosParaGraficoDeSessaoUsuarioPorcentagem(ArrayList<Ano> anos) throws SQLException, IOException{
		try {
			Ano ano = new Ano();
			ano.setId_de_busca(anos.get(0).getId_de_busca());
			anos.add(ano);
			
			GraficosDAO dao = new GraficosDAO();
			anos.get(1).setMeses_do_ano(dao.ConstroiDadosParaGraficoDeSessaoDoUsuarioPorcentagem(anos.get(1)));	
			RetornaDadosParaGraficoDeSessaoUsuario(anos);
		} catch (Exception e) {
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void RetornaDadosParaGraficoDeSessaoUsuario(ArrayList<Ano> anos) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		anos.set(0, new ControleCodificaUTF8().CodificaAnoUTF8(anos.get(0)));
		anos.set(1, new ControleCodificaUTF8().CodificaAnoUTF8(anos.get(1)));
		out.write(gson.toJson(anos));
	}
	
}
