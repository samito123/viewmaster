package controle.graficos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import modelos.Ano;
import controle.servlet.CodificaUTF8;
import controle.servlet.ControleDeRetornoServlet;
import dao.GraficosDAO;

public class ControleGraficoClientes {
	
	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public ControleGraficoClientes(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void ConstroiArrayDeAnosParaGraficoDeClientes(Ano ano) throws IOException, SQLException{
		ArrayList<Ano> anos = new ArrayList<>();
		anos.add(ano);
		ConstroiDadosParaGraficoDeClientes(anos);
	}
	
	private void ConstroiDadosParaGraficoDeClientes(ArrayList<Ano> anos) throws SQLException, IOException{
		try {
			GraficosDAO dao = new GraficosDAO();
			anos.get(0).setMeses_do_ano(dao.ConstroiDadosParaGraficoDeClientesAno(anos.get(0)));
			SomaTotalDeClientesAnoCorrente(anos);
		} catch (Exception e) {
			new ControleDeRetornoServlet(request, response).RetornaErro();
		}
	}
	
	private void SomaTotalDeClientesAnoCorrente(ArrayList<Ano> anos) throws SQLException, IOException{
		try{
			int totalDeClientes = 0;
			for(int mes = 0; mes < 12; mes++){
				totalDeClientes += anos.get(0).getMeses_do_ano().get(mes).getValor();
			}
			anos.get(0).setValor(totalDeClientes);
			ConstroiDadosParaGraficoDeClientesPorcentagem(anos);
		}catch(Exception e){
			new ControleDeRetornoServlet(request, response).RetornaErro();
		}	
	}
	
	private void ConstroiDadosParaGraficoDeClientesPorcentagem(ArrayList<Ano> anos) throws SQLException, IOException{
		try {
			Ano ano = new Ano();
			ano.setId_de_busca(anos.get(0).getId_de_busca());
			anos.add(ano);
			
			GraficosDAO dao = new GraficosDAO();
			anos.get(1).setMeses_do_ano(dao.ConstroiDadosParaGraficoDeClientesPorcentagem(anos.get(1)));	
			SomaTotalDeClientesPorcentagem(anos);
		} catch (Exception e) {
			new ControleDeRetornoServlet(request, response).RetornaErro();
		}
	}
	
	private void SomaTotalDeClientesPorcentagem(ArrayList<Ano> anos) throws SQLException, IOException{
		try{
			int totalDeSessoesAno = 0;
			for(int mes = 0; mes < 12; mes++){
				totalDeSessoesAno += anos.get(1).getMeses_do_ano().get(mes).getValor();
			}
			anos.get(1).setValor(totalDeSessoesAno);
			RetornaDadosParaGraficoDeClientes(anos);
		}catch(Exception e){
			new ControleDeRetornoServlet(request, response).RetornaErro();
		}	
	}
	
	private void RetornaDadosParaGraficoDeClientes(ArrayList<Ano> anos) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		anos.set(0, new CodificaUTF8().CodificaAnoUTF8(anos.get(0)));
		anos.set(1, new CodificaUTF8().CodificaAnoUTF8(anos.get(1)));
		out.write(gson.toJson(anos));
	}
}
