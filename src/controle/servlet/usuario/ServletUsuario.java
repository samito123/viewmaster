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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.request = req;
		this.response = resp;
		
		try{
			String metodo = request.getParameter("metodo");
			switch (metodo) {
			case "LogarUsuario":	
				//new LogarUsuario(req, resp)
				break;
				
			default:
				new ControleDeRetornoServlet(request, response)
					.RetornaErro("Método não encontrado!");
				break;
			}
		}catch(Exception e){
			new ControleDeRetornoServlet(request, response)
				.RetornaErro("Erro: ServletUsuarioTest doPost, "+e);
			System.out.println("Erro: ServletUsuarioTest doPost, "+e);
		}
	}
}
