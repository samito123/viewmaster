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

public class ControleGraficoReceitas {
	
	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public ControleGraficoReceitas(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void ConstroiArrayDeAnosParaGraficoDeReceitas(Ano ano) throws IOException, SQLException{
		ArrayList<Ano> anos = new ArrayList<>();
		anos.add(ano);
		ConstroiDadosParaGraficoDeReceitas(anos);
	}
	
	private void ConstroiDadosParaGraficoDeReceitas(ArrayList<Ano> anos) throws SQLException, IOException{
		try {
			GraficosDAO dao = new GraficosDAO();
			anos.get(0).setMeses_do_ano(dao.ConstroiDadosParaGraficoDeReceitasAno(anos.get(0)));
			SomaTotalDeReceitasAnoCorrente(anos);
		} catch (Exception e) {
			new ControleDeRetornoServlet(request, response).RetornaErro();
		}
	}
	
	private void SomaTotalDeReceitasAnoCorrente(ArrayList<Ano> anos) throws SQLException, IOException{
		try{
			int totalDeReceitas = 0;
			for(int mes = 0; mes < 12; mes++){
				totalDeReceitas += anos.get(0).getMeses_do_ano().get(mes).getValor();
			}
			anos.get(0).setValor(totalDeReceitas);
			ConstroiDadosParaGraficoDeReceitasPorcentagem(anos);
		}catch(Exception e){
			new ControleDeRetornoServlet(request, response).RetornaErro();
		}	
	}
	
	private void ConstroiDadosParaGraficoDeReceitasPorcentagem(ArrayList<Ano> anos) throws SQLException, IOException{
		try {
			Ano ano = new Ano();
			ano.setId_de_busca(anos.get(0).getId_de_busca());
			anos.add(ano);
			
			GraficosDAO dao = new GraficosDAO();
			anos.get(1).setMeses_do_ano(dao.ConstroiDadosParaGraficoDeReceitasPorcentagem(anos.get(1)));	
			SomaTotalDeReceitasPorcentagem(anos);
		} catch (Exception e) {
			new ControleDeRetornoServlet(request, response).RetornaErro();
		}
	}
	
	private void SomaTotalDeReceitasPorcentagem(ArrayList<Ano> anos) throws SQLException, IOException{
		try{
			int totalDeSessoesAno = 0;
			for(int mes = 0; mes < 12; mes++){
				totalDeSessoesAno += anos.get(1).getMeses_do_ano().get(mes).getValor();
			}
			anos.get(1).setValor(totalDeSessoesAno);
			RetornaDadosParaGraficoReceitas(anos);
		}catch(Exception e){
			new ControleDeRetornoServlet(request, response).RetornaErro();
		}	
	}
	
	private void RetornaDadosParaGraficoReceitas(ArrayList<Ano> anos) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		anos.set(0, new CodificaUTF8().CodificaAnoUTF8(anos.get(0)));
		anos.set(1, new CodificaUTF8().CodificaAnoUTF8(anos.get(1)));
		out.write(gson.toJson(anos));
	}
}
