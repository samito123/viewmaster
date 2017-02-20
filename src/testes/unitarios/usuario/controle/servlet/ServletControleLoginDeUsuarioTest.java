package testes.unitarios.usuario.controle.servlet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controle.conexao.ControleDeRetornoServidor;
import controle.conexao.ControleFabricaDeConexao;
import controle.modelos.ControleTratamentoMesAno;
import modelos.Usuario;
import dao.SessoesDeUsuarioDAO;
import dao.UsuarioDAO;

public class ServletControleLoginDeUsuarioTest {

	@Test
	public void VerificaLoginDiferenteDeNullOuVazio_ParametroString(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("login")).thenReturn("xxxx");
		boolean sucesso;
		
		if(request.getParameter("login") != null && request.getParameter("login") != ""){
			sucesso = true;
		}else{
			sucesso = false;
			//new ControleDeRetornoServidor(request, response).RetornaErro();
		}

		assertEquals(sucesso, true);
	}
	
	@Test
	public void VerificaLoginDiferenteDeNullOuVazio_ParametroStringVazia(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("login")).thenReturn("");
		boolean sucesso;
		
		if(request.getParameter("login") != null && request.getParameter("login") != ""){
			sucesso = true;
		}else{
			sucesso = false;
			//new ControleDeRetornoServidor(request, response).RetornaErro();
		}

		assertEquals(sucesso, false);
	}
	
	@Test
	public void VerificaLoginDiferenteDeNullOuVazio_ParametroNull(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		boolean sucesso;
		
		if(request.getParameter("login") != null && request.getParameter("login") != ""){
			sucesso = true;
		}else{
			sucesso = false;
			//new ControleDeRetornoServidor(request, response).RetornaErro();
		}

		assertEquals(sucesso, false);
	}
	
	@Test
	public void VerificaSenhaDiferenteDeNull_ParametroString(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("senha")).thenReturn("xxxx");
		boolean sucesso;
		
		if(request.getParameter("senha") != null && request.getParameter("senha") != ""){
			sucesso = true;
		}else{
			sucesso = false;
			//new ControleDeRetornoServidor(request, response).RetornaErro();
		}

		assertEquals(sucesso, true);
	}
	
	@Test
	public void VerificaSenhaDiferenteDeNull_ParametroStringVazio(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("senha")).thenReturn("");
		boolean sucesso;
		
		if(request.getParameter("senha") != null && request.getParameter("senha") != ""){
			sucesso = true;
		}else{
			sucesso = false;
			//new ControleDeRetornoServidor(request, response).RetornaErro();
		}

		assertEquals(sucesso, false);
	}
	
	@Test
	public void VerificaSenhaDiferenteDeNull_ParametroNull(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		boolean sucesso;
		
		if(request.getParameter("senha") != null && request.getParameter("senha") != ""){
			sucesso = true;
		}else{
			sucesso = false;
			//new ControleDeRetornoServidor(request, response).RetornaErro();
		}

		assertEquals(sucesso, false);
	}
	
	@Test
	public void CriaUsuarioRequest_PassandoParametrosLoginSenha(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("login")).thenReturn("xxxx");
		when(request.getParameter("senha")).thenReturn("1111");
		
		Usuario usuario = new Usuario();
		
		usuario.setLogin_usuario(request.getParameter("login"));
		assertEquals(usuario.getLogin_usuario(), "xxxx");
		usuario.setSenha_usuario(request.getParameter("senha"));
		assertEquals(usuario.getSenha_usuario(), "1111");
	}
	
	@Test
	public void RecuperaUsuarioDoBancoViaLoginSenha() throws SQLException{
		Usuario usuarioRequest = mock(Usuario.class);
		when(usuarioRequest.getLogin_usuario()).thenReturn("xxxx");
		when(usuarioRequest.getSenha_usuario()).thenReturn("1111");
		
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) 1);
		when(usuario.getNome_usuario()).thenReturn("Luiz Samuel Pinheiro Lima");
		when(usuario.getLogin_usuario()).thenReturn("samito");
		when(usuario.getSenha_usuario()).thenReturn("123");
		when(usuario.getEmail_usuario()).thenReturn("123");
		when(usuario.getData_nascimento_usuario()).thenReturn("22/07/1988");
		when(usuario.getPergunta_secreta_usuario()).thenReturn("Onde nasceu?");
		when(usuario.getResposta_pergunta_secreta_usuario()).thenReturn("Fortaleza");
		
		UsuarioDAO dao = mock(UsuarioDAO.class);
		when(dao.VerificaLoginDeAcessoRetornaUsuario(usuarioRequest)).thenReturn(usuario);
		usuarioRequest = dao.VerificaLoginDeAcessoRetornaUsuario(usuarioRequest);
		
		assertEquals(usuarioRequest.getNome_usuario(), "Luiz Samuel Pinheiro Lima");
	}
	
	@Test
	public void VerificaUsuarioRetornado_RetornandoUsuarioGetNomeString(){
		Usuario usuario = mock(Usuario.class);
		when(usuario.getNome_usuario()).thenReturn("Luiz Samuel Pinheiro Lima");
		
		if(usuario.getNome_usuario() != null && usuario.getNome_usuario() != ""){
			assertEquals(usuario.getNome_usuario(), "Luiz Samuel Pinheiro Lima");
		}else{
			fail();
		}
	}
	
	@Test
	public void VerificaUsuarioRetornado_RetornandoUsuarioGetNomeStringVazia(){
		Usuario usuario = mock(Usuario.class);
		when(usuario.getNome_usuario()).thenReturn("");
		
		if(usuario.getNome_usuario() != null && usuario.getNome_usuario() != ""){
			fail();
		}else{
			assertEquals(usuario.getNome_usuario(), "");
		}
	}
	
	@Test
	public void VerificaUsuarioRetornado_RetornandoUsuarioGetNomeNull(){
		Usuario usuario = mock(Usuario.class);
		when(usuario.getNome_usuario()).thenReturn(null);
		
		if(usuario.getNome_usuario() != null && usuario.getNome_usuario() != ""){
			fail();
		}else{
			assertEquals(usuario.getNome_usuario(), null);
		}
	}
	
	@Test
	public void VerificaSeSessaoDoUsuarioExiste_SessaoExiste() throws SQLException{		
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) 1);
		
		SessoesDeUsuarioDAO dao = mock(SessoesDeUsuarioDAO.class);
		when(dao.VerificaSeSessaoDoUsuarioExiste(usuario)).thenReturn((long) 1);
		
		long quantidadeDeSessoes = dao.VerificaSeSessaoDoUsuarioExiste(usuario);
		if(quantidadeDeSessoes > 0){
			assertEquals(quantidadeDeSessoes, 1);
		}else{
			fail();
		}
	}
	
	@Test
	public void VerificaSeSessaoDoUsuarioExiste_SessaoNãoExiste() throws SQLException{		
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) 1);
		
		SessoesDeUsuarioDAO dao = mock(SessoesDeUsuarioDAO.class);
		when(dao.VerificaSeSessaoDoUsuarioExiste(usuario)).thenReturn((long) 0);
		
		long quantidadeDeSessoes = dao.VerificaSeSessaoDoUsuarioExiste(usuario);
		if(quantidadeDeSessoes > 0){
			fail();	
		}else{
			assertEquals(quantidadeDeSessoes, 0);
		}
	}
	
	@Test
	public void UpdateSessaoUsuario_TransacaoComSucesso() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) 1);
		long quantidadeDeSessoes = 1;
		
		SessoesDeUsuarioDAO dao = mock(SessoesDeUsuarioDAO.class);
		when(dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes)).thenReturn(1);
		
		dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes);
		assertEquals(dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes), 1);
	}
	
	@Test
	public void UpdateSessaoUsuario_TransacaoComErro() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) 1);
		long quantidadeDeSessoes = 1;
		
		SessoesDeUsuarioDAO dao = mock(SessoesDeUsuarioDAO.class);
		when(dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes)).thenReturn(0);
		
		dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes);
		assertEquals(dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes), 0);
	}
	
	@Test
	public void VerificaSeUpdateSessaoDeUsuarioOcorreuComSucesso_TransacaoComSucesso() throws SQLException{
		long transacaoRealizada = 1;
		if(transacaoRealizada == 1){
			assertEquals(transacaoRealizada, 1);
		}else{
			fail();
		}
	}
	
	@Test
	public void VerificaSeUpdateSessaoDeUsuarioOcorreuComSucesso_TransacaoComErro() throws SQLException{
		long transacaoRealizada = 0;
		if(transacaoRealizada == 1){
			fail();
		}else{
			assertEquals(transacaoRealizada, 0);
		}
	}
	
	/*@Test
	public void UpdateSessaoUsuario() throws Exception{
		int TransacaoRealizada = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs;
		try {		
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "update tb_sessoes_usuario set " 
					+ "quantidade_sessoes=? "
					+ "where id_usuario=? and mes_sessao=? and ano_sessao=?"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, 6); 
			ps.setLong(2, 40); 
			ps.setString(3, "02"); 
			ps.setString(4, "2016"); 
			TransacaoRealizada = ps.executeUpdate();
			
		}catch (Exception e) {
			TransacaoRealizada = 0;
			System.out.println("catch");
			throw new Exception("Erro ao persistir objeto.", e);
		}finally{
			ps.close();
			conn.close();
			//return transacaoRealizada;
			System.out.println(TransacaoRealizada);
			//if(TransacaoRealizada == 0)
			//	throw new Exception("Erro ao persistir objeto.");
		}
	}*/
	
}
