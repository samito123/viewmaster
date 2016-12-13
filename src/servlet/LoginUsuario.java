package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginUsuario extends HttpServlet{
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String metodo = request.getParameter("metodo");
		switch (metodo) {
		
			case "VerificaLoginDoUsuario":
				VerificaLoginDoUsuario(request.getParameter("login"), request.getParameter("senha"));
			break;
		}
		
	}
	
	private void VerificaLoginDoUsuario(String login, String senha){
		PrintWriter out = response.getWriter();
		//out.write(senha); 
		
		
		
		
		
	}
}
