package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Ano;
import controle.graficos.ControleGraficoClientes;
import controle.graficos.ControleGraficoDeSessao;
import controle.graficos.ControleGraficoModulos;
import controle.graficos.ControleGraficoReceitas;
import controle.graficos.ControleGraficoTiposDeProdutosMaisVendidos;


public class Graficos extends HttpServlet{
	
	static private HttpServletRequest request;
	static private HttpServletResponse response;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		request = req;
		response = resp;
		
		String metodo = request.getParameter("metodo");
		switch (metodo) {
			case "RecuperaDadosParaGraficoDeSessaoUsuario":	
				try {
					System.out.println("aaaaaaaaaaaa");
					new ControleGraficoDeSessao(req, resp).ConstroiArrayDeAnosParaGraficoDeSessaoUsuario(CriaObjetoAnoRequest());
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;
			
			case "RecuperaDadosParaGraficoDeModulos":	
				try {
					new ControleGraficoModulos(req, resp).ConstroiArrayDeModulosParaGraficoDeModulos();
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;
			
			case "RecuperaDadosParaGraficoDeClientes":	
				try {
					new ControleGraficoClientes(req, resp).ConstroiArrayDeAnosParaGraficoDeClientes(CriaObjetoAnoRequest());
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;
			
			case "RecuperaDadosParaGraficoDeReceitas":	
				try {
					new ControleGraficoReceitas(req, resp).ConstroiArrayDeAnosParaGraficoDeReceitas(CriaObjetoAnoRequest());
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;
			
			case "RecuperaDadosParaGraficoDeTiposDeProdutosMaisVendidos":	
				try {
					new ControleGraficoTiposDeProdutosMaisVendidos(req, resp).
						ConstroiArrayDeTiposDeProdutoParaGraficoDeTiposDeProdutosMaisVendidos(CriaObjetoAnoRequest());
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;
		}
	}
	
	private Ano CriaObjetoAnoRequest() throws IOException{	
		Ano ano = new Ano();
		if(request.getParameter("id_de_busca") != null)
			ano.setId_de_busca(Long.parseLong(request.getParameter("id_de_busca")));
		if(request.getParameter("ano") != null)
			ano.setNumero_do_ano(request.getParameter("ano"));
		return ano;
	}
	
}
