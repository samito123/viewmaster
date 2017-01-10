package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import control.CodificaUTF8;
import dao.GraficosDAO;
import model.Ano;
import model.Mes;
import model.Usuario;


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
					ConstroiArrayDeAnosParaGraficoDeSessaoUsuario(CriaObjetoAnoRequest());
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
	
	private void ConstroiArrayDeAnosParaGraficoDeSessaoUsuario(Ano ano) throws IOException, SQLException{
		ArrayList<Ano> anos = new ArrayList<>();
		anos.add(ano);
		ConstroiDadosParaGraficoDeSessaoUsuarioAno(anos);
	}
	
	private void ConstroiDadosParaGraficoDeSessaoUsuarioAno(ArrayList<Ano> anos) throws SQLException, IOException{
		try {
			GraficosDAO dao = new GraficosDAO();
			anos.get(0).setMeses_do_ano(dao.ConstroiDadosParaGraficoDeSessaoDoUsuarioAno(anos.get(0)));
			System.out.println("Foi sim!");
			ConstroiDadosParaGraficoDeSessaoUsuarioPorcentagem(anos);
		} catch (Exception e) {
			RetornaErroContrucaoGrafico();
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
			RetornaErroContrucaoGrafico();
		}
	}
	
	private void RetornaDadosParaGraficoDeSessaoUsuario(ArrayList<Ano> anos) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		anos.set(0, new CodificaUTF8().CodificaAnoUTF8(anos.get(0)));
		anos.set(1, new CodificaUTF8().CodificaAnoUTF8(anos.get(1)));
		out.write(gson.toJson(anos));
	}
	
	private void RetornaErroContrucaoGrafico() throws IOException{
		PrintWriter out = response.getWriter();
		out.write("erro"); 
	}
}
