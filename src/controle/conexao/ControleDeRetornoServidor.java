package controle.conexao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControleDeRetornoServidor {
	
	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public ControleDeRetornoServidor(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void RetornaSucesso() throws IOException{
		PrintWriter out = response.getWriter();
		out.write("sucesso"); 
	}
	
	public void RetornaErro() throws IOException{
		PrintWriter out = response.getWriter();
		out.write("erro"); 
	}
}
