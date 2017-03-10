package controle.servlet.usuario;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.servlet.ControleDeRetornoServlet;
import modelos.Usuario;


public class ServletUsuario extends HttpServlet{
	
	static private HttpServletRequest request;
	static private HttpServletResponse response;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		
		this.request = req;
		this.response = resp;
		
		try{
			String metodo = request.getParameter("metodo");
			switch (metodo) {
			case "LogarUsuario":	
				new LogarUsuario(request, response);
				break;
				
			default:
				new ControleDeRetornoServlet(response)
					.RetornaErro("Método não encontrado!");
				break;
			}
		}catch(Exception e){
			
		}
	}
}
