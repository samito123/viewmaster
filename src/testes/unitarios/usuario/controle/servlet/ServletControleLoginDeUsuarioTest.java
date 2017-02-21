package testes.unitarios.usuario.controle.servlet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import modelos.Usuario;
import dao.SessoesDeUsuarioDAO;
import dao.UsuarioDAO;

public class ServletControleLoginDeUsuarioTest {

	@Test
	public void VerificaLoginDiferenteDeNullOuVazio_ParametroString() throws Exception{
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("login")).thenReturn("xxxx");
		boolean sucesso;
		
		if(request.getParameter("login") != null && request.getParameter("login") != ""){
			sucesso = true;
		}else{
			sucesso = false;
			throw new Exception("Erro: login.request null ou vazio");
		}

		assertTrue(sucesso);
	}
	
	@Test(expected=Exception.class)
	public void VerificaLoginDiferenteDeNullOuVazio_ParametroStringVazia() throws Exception{
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("login")).thenReturn("");
		boolean sucesso;
		
		if(request.getParameter("login") != null && request.getParameter("login") != ""){
			sucesso = false;
		}else{
			sucesso = true;
			assertTrue(sucesso);
			throw new Exception("Erro: login.request null ou vazio");
		}
	}
	
	@Test(expected=Exception.class)
	public void VerificaLoginDiferenteDeNullOuVazio_ParametroNull() throws Exception{
		HttpServletRequest request = mock(HttpServletRequest.class);
		boolean sucesso;
		
		if(request.getParameter("login") != null && request.getParameter("login") != ""){
			sucesso = false;
		}else{
			sucesso = true;
			assertTrue(sucesso);
			throw new Exception("Erro: login.request null ou vazio");
		}
	}
	
	@Test
	public void VerificaSenhaDiferenteDeNull_ParametroString() throws Exception{
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("senha")).thenReturn("xxxx");
		boolean sucesso;
		
		if(request.getParameter("senha") != null && request.getParameter("senha") != ""){
			sucesso = true;
		}else{
			sucesso = false;
			throw new Exception("Erro: senha.request null ou vazio");
		}

		assertTrue(sucesso);
	}
	
	@Test(expected=Exception.class)
	public void VerificaSenhaDiferenteDeNull_ParametroStringVazio() throws Exception{
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("senha")).thenReturn("");
		boolean sucesso;
		
		if(request.getParameter("senha") != null && request.getParameter("senha") != ""){
			sucesso = false;
		}else{
			sucesso = true;
			assertTrue(sucesso);
			throw new Exception("Erro: senha.request null ou vazio");
		}
	}
	
	@Test(expected=Exception.class)
	public void VerificaSenhaDiferenteDeNull_ParametroNull() throws Exception{
		HttpServletRequest request = mock(HttpServletRequest.class);
		boolean sucesso;
		
		if(request.getParameter("senha") != null && request.getParameter("senha") != ""){
			sucesso = false;
		}else{
			sucesso = true;
			assertTrue(sucesso);
			throw new Exception("Erro: senha.request null ou vazio");
		}
	}
	
	@Test
	public void CriaUsuarioRequest(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("login")).thenReturn("xxxx");
		when(request.getParameter("senha")).thenReturn("1111");
		
		Usuario usuario = new Usuario();
		
		usuario.setLogin_usuario(request.getParameter("login"));
		usuario.setSenha_usuario(request.getParameter("senha"));
		assertEquals(usuario.getLogin_usuario(), "xxxx");
		assertEquals(usuario.getSenha_usuario(), "1111");
	}
	
	@Test
	public void RecuperaUsuarioDoBancoViaLoginSenha() throws Exception{
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
	public void VerificaUsuarioRetornado_RetornandoUsuarioGetNomeString() throws Exception{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getNome_usuario()).thenReturn("Luiz Samuel Pinheiro Lima");
		boolean sucesso = false;
		if(usuario.getNome_usuario() != null && usuario.getNome_usuario() != ""){
			sucesso = true;
		}else{
			throw new Exception("Erro: Usuario ou senha incorreto!");
		}
		assertTrue(sucesso);
	}
	
	@Test(expected=Exception.class)
	public void VerificaUsuarioRetornado_RetornandoUsuarioGetNomeNull() throws Exception{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getNome_usuario()).thenReturn(null);
		boolean sucesso = false;
		if(usuario.getNome_usuario() != null && usuario.getNome_usuario() != ""){
			
		}else{
			sucesso = true;
			assertTrue(sucesso);
			throw new Exception("Erro: Usuario ou senha incorreto!");
		}
	}
	
	@Test(expected=Exception.class)
	public void VerificaUsuarioRetornado_RetornandoUsuarioGetNomeStringVazia() throws Exception{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getNome_usuario()).thenReturn("");
		boolean sucesso = false;
		if(usuario.getNome_usuario() != null && usuario.getNome_usuario() != ""){
			
		}else{
			sucesso = true;
			assertTrue(sucesso);
			throw new Exception("Erro: Usuario ou senha incorreto!");
		}
	}
	
	@Test
	public void VerificaSeSessaoDoUsuarioExiste_SessaoExiste() throws Exception{		
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
	public void VerificaSeSessaoDoUsuarioExiste_SessaoNãoExiste() throws Exception{		
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
