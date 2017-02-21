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
	
	public void RetornaSucesso(){
		try{
			PrintWriter out = response.getWriter();
			out.write("sucesso");
			out.close();
		}catch(Exception e){
			System.out.println("Erro: Controle de retorno de sucesso do servidor, "+e);
		} 
	}
	
	public void RetornaErro(){
		try{
			PrintWriter out = response.getWriter();
			out.write("erro");	
			out.close();
		}catch(Exception e){
			System.out.println("Erro: Controle de retorno de erro do servidor, "+e);
		} 
	}
}
