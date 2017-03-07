package controle.graficos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Ano;
import modelos.TipoDeProduto;

import com.google.gson.Gson;

import controle.servlet.CodificaUTF8;
import controle.servlet.ControleDeRetornoServlet;
import dao.GraficosDAO;

public class ControleGraficoTiposDeProdutosMaisVendidos {
	
	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public ControleGraficoTiposDeProdutosMaisVendidos(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void ConstroiArrayDeTiposDeProdutoParaGraficoDeTiposDeProdutosMaisVendidos(Ano ano) 
			throws IOException, SQLException{
		ArrayList<TipoDeProduto> tiposDeProdutos = new ArrayList<>();
		
		ConstroiDadosParaGraficoDeTiposDeProdutosMaisVendidos(tiposDeProdutos);
	}
	
	private void ConstroiDadosParaGraficoDeTiposDeProdutosMaisVendidos(ArrayList<TipoDeProduto> tiposDeProdutos) 
			throws SQLException, IOException{
		
		try {
			GraficosDAO dao = new GraficosDAO();
			tiposDeProdutos = dao.ConstroiDadosParaGraficoDeTiposDeProdutosMaisVendidos(tiposDeProdutos);
			RetornaDadosParaGraficoDeTiposDeProdutosMaisVendidos(tiposDeProdutos);
		} catch (Exception e) {
			new ControleDeRetornoServlet(request, response).RetornaErro();
		}
	}
	
	private void RetornaDadosParaGraficoDeTiposDeProdutosMaisVendidos
		(ArrayList<TipoDeProduto> tiposDeProdutos) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		for(int contador = 0; contador < tiposDeProdutos.size(); contador++){
			tiposDeProdutos.set(contador, 
					new CodificaUTF8().CodificaTipoProdutoUTF8(tiposDeProdutos.get(contador)));
		}
		out.write(gson.toJson(tiposDeProdutos));
	}
}
