package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Ano;
import modelos.Assinatura;
import controle.assinaturas.ControleRecuperacaoDeAssinaturas;
import controle.graficos.ControleGraficoClientes;
import controle.graficos.ControleGraficoDeSessao;
import controle.graficos.ControleGraficoModulos;
import controle.graficos.ControleGraficoReceitas;
import controle.graficos.ControleGraficoTiposDeProdutosMaisVendidos;


public class ServletAssinaturas extends HttpServlet{
	
	static private HttpServletRequest request;
	static private HttpServletResponse response;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		request = req;
		response = resp;
		
		String metodo = request.getParameter("metodo");
		switch (metodo) {
			case "RecuperaListaDeAssinaturas":	
				try {
					new ControleRecuperacaoDeAssinaturas(req, resp).ConstroiArrayDeAssinaturas();
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;
		}
	}
	
	private Assinatura CriaObjetoAnoRequest() throws IOException{	
		Assinatura assinatura = new Assinatura();
		if(request.getParameter("id_de_busca") != null)
			assinatura.setId_assinatura(Long.parseLong(request.getParameter("id_de_busca")));
		if(request.getParameter("tipo_assinatura") != null)
			assinatura.setTipo_assinatura(request.getParameter("tipo_assinatura"));
		if(request.getParameter("data_inicial_assinatura") != null)
			assinatura.setData_inicial_assinatura(request.getParameter("data_inicial_assinatura"));
		if(request.getParameter("data_final_assinatura") != null)
			assinatura.setData_final_assinatura(request.getParameter("data_final_assinatura"));
		if(request.getParameter("data_bloqueio_assinatura") != null)
			assinatura.setData_bloqueio_assinatura(request.getParameter("data_bloqueio_assinatura"));
		return assinatura;
	}
	
}
