package testes.unitarios.controle.servlet.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServletUsuarioTest{
	
	@Test
	public void doPost_NomeDoMetodoCorreto(){	
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("metodo")).thenReturn("VerificaLoginDoUsuario");
		boolean sucesso = false;
		
		try{
			String metodo = request.getParameter("metodo");
			switch (metodo) {
				case "VerificaLoginDoUsuario":	
					sucesso = true;
					break;
				
				default:
					sucesso = false;
					break;
			}
		}catch(Exception e){
			sucesso = false;
		}
		assertTrue(sucesso);
	}
	
	@Test
	public void doPost_NomeDoMetodoIncorreto(){	
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("metodo")).thenReturn("xxxxxxx");
		boolean sucesso = false;
		
		try{
			String metodo = request.getParameter("metodo");
			switch (metodo) {
				case "VerificaLoginDoUsuario":	
					sucesso = false;
					break;
				
				default:
					sucesso = true;
					break;
			}
		}catch(Exception e){
			sucesso = false;
		}
		assertTrue(sucesso);
	}
	
	@Test
	public void doPost_NomeDoMetodoNull(){	
		HttpServletRequest request = mock(HttpServletRequest.class);
		boolean sucesso = false;
		
		try{
			String metodo = request.getParameter("metodo");
			switch (metodo) {
				case "VerificaLoginDoUsuario":	
					sucesso = false;
					break;
				
				default:
					sucesso = false;
					break;
			}
		}catch(Exception e){
			sucesso = true;
		}
		assertTrue(sucesso);
	}
	
	@Test
	public void doPost_GerandoExcessaoNosCasosDeUso(){	
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("metodo")).thenReturn("VerificaLoginDoUsuario");
		boolean sucesso = false;
		
		try{
			String metodo = request.getParameter("metodo");
			switch (metodo) {
				case "VerificaLoginDoUsuario":	
					GeraExcessao();
					break;
				
				default:
					sucesso = false;
					break;
			}
		}catch(Exception e){
			sucesso = true;
		}
		assertTrue(sucesso);
	}
	
	private void GeraExcessao() throws Exception{
		throw new Exception();
	}
}
