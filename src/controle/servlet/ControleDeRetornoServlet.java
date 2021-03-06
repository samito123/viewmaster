package controle.servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ControleDeRetornoServlet {
	
	static private HttpServletResponse response; 
	
	public ControleDeRetornoServlet(HttpServletResponse response){
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
	
	public void RetornaErro(String erro){
		try{
			PrintWriter out = response.getWriter();
			out.write("Erro: "+new CodificaUTF8().CodificaStringUTF8(erro));	
			out.close();
		}catch(Exception e){
			System.out.println("Erro: Controle de retorno de erro do servidor, "+e);
		} 
	}
}
