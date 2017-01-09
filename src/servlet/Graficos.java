package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.GraficosDAO;
import model.Ano;
import model.Mes;


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
					CriaObjetoAnoRequest();
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;
			
		}
	}
	
	private String CriaObjetoAnoRequest(){

		System.out.println("foi");
		//Ano ano = new Ano();
		//if(request.getParameter("id_de_busca") != null)
			//ano.setId_de_busca(Long.parseLong(request.getParameter("id")));
		//if(request.getParameter("ano") != null)
			//ano.setNome_do_ano(request.getParameter("ano"));	
		
		//return ano;
		
		//System.out.println(ano.getMeses_do_ano().get(0).getNome_do_mes());
		return "erro";
	}
	
	private void RetornaDadosParaGraficoDeSessaoUsuario(Ano ano) throws SQLException{
		//ano.setMeses_do_ano(ConstroiMesesDoAno());
		GraficosDAO dao = new GraficosDAO();
		dao.ConstroiDadosParaGraficoDeSessaoDoUsuario(ano);
	}
	
}
