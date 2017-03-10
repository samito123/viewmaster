package testes.unitarios.controle.servlet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import controle.servlet.CodificaUTF8;

public class ControleDeRetornoServletTest{
	
	@Test
	public void RetornaSucesso_CasoDeSucesso() throws IOException{
		HttpServletResponse response = mock(HttpServletResponse.class);
		StringWriter stringWriter = new StringWriter();
		PrintWriter out = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(out);
		boolean sucesso = false;
		try{	
			out = response.getWriter();
			out.write("sucesso");	
			out.close();
			sucesso = true;
		}catch(Exception e){
			sucesso = false;
			System.out.println("Erro: Controle de retorno de sucesso do servidor, "+e);
		} 
		assertEquals(sucesso, true);
	}
	
	@Test
	public void RetornaSucesso_CasoDeErroImprimindoErro() throws IOException{
		HttpServletResponse response = mock(HttpServletResponse.class);
		StringWriter stringWriter = new StringWriter();
		PrintWriter out = new PrintWriter(stringWriter);
		//when(response.getWriter()).thenReturn(out);
		boolean sucesso = false;
		try{	
			out = response.getWriter();
			out.write("sucesso");	
			out.close();
			sucesso = false;
		}catch(Exception e){
			sucesso = true;
			System.out.println("Erro: Controle de retorno de sucesso do servidor, "+e);
		} 
		assertEquals(sucesso, true);
	}
	
	@Test
	public void RetornaErro_CasoDeSucesso() throws IOException{
		HttpServletResponse response = mock(HttpServletResponse.class);
		StringWriter stringWriter = new StringWriter();
		PrintWriter out = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(out);
		boolean sucesso = false;
		try{	
			out = response.getWriter();
			out.write("erro");	
			out.close();
			sucesso = true;
		}catch(Exception e){
			sucesso = false;
			System.out.println("Erro: Controle de retorno de erro do servidor, "+e);
		} 
		assertEquals(sucesso, true);
	}
	
	@Test
	public void RetornaErro_CasoDeErroImprimindoErro() throws IOException{
		HttpServletResponse response = mock(HttpServletResponse.class);
		StringWriter stringWriter = new StringWriter();
		PrintWriter out = new PrintWriter(stringWriter);
		//when(response.getWriter()).thenReturn(out);
		boolean sucesso = false;
		try{	
			out = response.getWriter();
			out.write("erro");	
			out.close();
			sucesso = false;
		}catch(Exception e){
			sucesso = true;
			System.out.println("Erro: Controle de retorno de erro do servidor, "+e);
		} 
		assertEquals(sucesso, true);
	}
	
	public ControleDeRetornoServletTest(){
		
	}
	
	public void RetornaErro(String erro){	
		System.out.println("Test-Erro: "+erro);	 
	}
	
}
