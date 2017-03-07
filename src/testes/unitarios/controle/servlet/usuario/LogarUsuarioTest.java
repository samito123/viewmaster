package testes.unitarios.controle.servlet.usuario;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import controle.conexao.ControleFabricaDeConexao;
import modelos.Sessao;
import modelos.Usuario;
import dao.SessoesDeUsuarioDAO;
import dao.UsuarioDAO;

public class LogarUsuarioTest {

	/*@Test
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
	}*/
	
	/*@Test(expected=Exception.class)
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
		boolean sucesso;
		
		long quantidadeDeSessoes = dao.VerificaSeSessaoDoUsuarioExiste(usuario);
		if(quantidadeDeSessoes > 0){
			sucesso = true;
		}else{
			sucesso = false;
		}
		assertTrue(sucesso);
	}*/
	
	/*@Test
	public void VerificaSeSessaoDoUsuarioExiste_SessaoNãoExiste() throws Exception{		
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) 1);
		SessoesDeUsuarioDAO dao = mock(SessoesDeUsuarioDAO.class);
		when(dao.VerificaSeSessaoDoUsuarioExiste(usuario)).thenReturn((long) 0);
		boolean sucesso;
		
		long quantidadeDeSessoes = dao.VerificaSeSessaoDoUsuarioExiste(usuario);
		if(quantidadeDeSessoes > 0){
			sucesso = false;
		}else{
			sucesso = true;
		}
		assertTrue(sucesso);
	}
	
	@Test
	public void UpdateSessaoUsuario_TransacaoComSucesso() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) 1);
		long quantidadeDeSessoes = 1;
		SessoesDeUsuarioDAO dao = mock(SessoesDeUsuarioDAO.class);
		when(dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes)).thenReturn(1);
		
		int transacaoRealizada = dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes);
		assertEquals(transacaoRealizada, 1);
	}*/
	
	/*@Test
	public void UpdateSessaoUsuario_TransacaoComErro() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) 1);
		long quantidadeDeSessoes = 1;
		SessoesDeUsuarioDAO dao = mock(SessoesDeUsuarioDAO.class);
		when(dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes)).thenReturn(0);
		
		int transacaoRealizada = dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes);
		assertEquals(transacaoRealizada, 0);
	}
	
	@Test
	public void VerificaSeUpdateSessaoDeUsuarioOcorreuComSucesso_TransacaoComSucesso() throws SQLException{
		boolean sucesso;
		
		long transacaoRealizada = 1;
		if(transacaoRealizada == 1){
			sucesso = true;
		}else{
			sucesso = false;
		}
		assertTrue(sucesso);
	}*/
	
	/*@Test
	public void VerificaSeUpdateSessaoDeUsuarioOcorreuComSucesso_TransacaoComErro() throws SQLException{
		boolean sucesso;
		
		long transacaoRealizada = 0;
		if(transacaoRealizada == 1){
			sucesso = false;
		}else{
			sucesso = true;
		}
		assertTrue(sucesso);
	}*/
	
	@Test
	public void LoginDeUsuario_UsuarioExistente() throws Exception{
		boolean sucesso = false;
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("login")).thenReturn("testeLogin");
		when(request.getParameter("senha")).thenReturn("testeSenha");
		
		Connection conn = new ControleFabricaDeConexao().getConnection();
		conn.setAutoCommit(false);
		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			Sessao usuario = BuscaUsuarioLogin_UsuarioExistente(login, senha);
			if(usuario != null){
				sucesso = true;
				//TrataSessaoDeUsuario(usuario);
			}else{
				//RetornaErroParaUsuario("Usuario ou senha está incorreto!");
			}
		} catch (Exception e) {
			System.out.println("Erro: LoginDeUsuario, "+e);
		}finally{
			conn.rollback();
			conn.close();
		}
		assertTrue(sucesso);
	}
	
	private Sessao BuscaUsuarioLogin_UsuarioExistente(String login, String senha){
		Sessao usuario = mock(Sessao.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
		when(usuario.getNome_usuario()).thenReturn("testeNome");
		when(usuario.getLogin_usuario()).thenReturn(login);
		when(usuario.getQuantidade_de_sessoes()).thenReturn(5);
		return usuario;
	}
	
	@Test
	public void LoginDeUsuario_UsuarioNull() throws Exception{
		boolean sucesso = false;
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("login")).thenReturn("testeLogin");
		when(request.getParameter("senha")).thenReturn("testeSenha");
		
		Connection conn = new ControleFabricaDeConexao().getConnection();
		conn.setAutoCommit(false);
		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			Sessao usuario = BuscaUsuarioLogin_UsuarioNullLancandoExcecao(login, senha);
			if(usuario != null){
				//TrataSessaoDeUsuario(usuario);
			}else{
				sucesso = true;
				//RetornaErroParaUsuario("Usuario ou senha está incorreto!");
			}
		} catch (Exception e) {
			System.out.println("Erro: LoginDeUsuario, "+e);
		}finally{
			conn.rollback();
			conn.close();
		}
		assertTrue(sucesso);
	}
	
	@Test
	public void LoginDeUsuario_LancandoExcecao() throws Exception{
		boolean sucesso = false;
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("login")).thenReturn("testeLogin");
		when(request.getParameter("senha")).thenReturn("testeSenha");
		
		Connection conn = new ControleFabricaDeConexao().getConnection();
		conn.setAutoCommit(false);
		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			Sessao usuario = BuscaUsuarioLogin_UsuarioNullLancandoExcecao(login, senha);
			if(usuario != null){
				//TrataSessaoDeUsuario(usuario);
			}else{
				usuario.getAno_sessao();
				//RetornaErroParaUsuario("Usuario ou senha está incorreto!");
			}
		} catch (Exception e) {
			sucesso = true;
			System.out.println("Erro: LoginDeUsuario, "+e);
		}finally{
			conn.rollback();
			conn.close();
		}
		assertTrue(sucesso);
	}
	
	private Sessao BuscaUsuarioLogin_UsuarioNullLancandoExcecao(String login, String senha){
		Sessao usuario = null;
		return usuario;
	}
	
	@Test
	public void TrataSessaoDeUsuario_QuantidadeDeSessoesMaiorQueZero() throws SQLException {
		boolean sucesso = false;
		Sessao usuario = mock(Sessao.class);
		when(usuario.getQuantidade_de_sessoes()).thenReturn(5);
		
		int qtdErros = 0;
		if(usuario.getQuantidade_de_sessoes() > 0){
			sucesso = true;
			//qtdErros = AtualizaSessaoUsuario(usuario);
		}else{
			//qtdErros = InsereSessaoUsuario(usuario);
		}
		//ValidaSessaoUsuario(qtdErros);
		assertTrue(sucesso);
	}
	
	@Test
	public void TrataSessaoDeUsuario_QuantidadeDeSessoesZero() throws SQLException {
		boolean sucesso = false;
		Sessao usuario = mock(Sessao.class);
		when(usuario.getQuantidade_de_sessoes()).thenReturn(0);
		
		int qtdErros = 0;
		if(usuario.getQuantidade_de_sessoes() > 0){
			//qtdErros = AtualizaSessaoUsuario(usuario);
		}else{
			sucesso = true;
			//qtdErros = InsereSessaoUsuario(usuario);
		}
		//ValidaSessaoUsuario(qtdErros);
		assertTrue(sucesso);
	}
	
	@Test
	public void TrataSessaoDeUsuario_QuantidadeDeSessoesNull() throws SQLException {
		boolean sucesso = false;
		Sessao usuario = mock(Sessao.class);
		
		int qtdErros = 0;
		if(usuario.getQuantidade_de_sessoes() > 0){
			//qtdErros = AtualizaSessaoUsuario(usuario);
		}else{
			sucesso = true;
			//qtdErros = InsereSessaoUsuario(usuario);
		}
		//ValidaSessaoUsuario(qtdErros);
		assertTrue(sucesso);
	}

}
