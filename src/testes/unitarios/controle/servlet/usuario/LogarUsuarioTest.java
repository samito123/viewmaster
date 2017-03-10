package testes.unitarios.controle.servlet.usuario;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import testes.unitarios.controle.servlet.ControleDeRetornoServletTest;
import testes.unitarios.controle.servlet.exception.ServletExceptionTest;
import controle.auxiliares.DataControle;
import controle.conexao.ControleFabricaDeConexao;
import controle.servlet.ControleDeRetornoServlet;
import modelos.Sessao;
import modelos.Usuario;
import dao.SessoesDeUsuarioDAO;
import dao.UsuarioDAO;

public class LogarUsuarioTest {
	
	static private HttpServletRequest request;
	static private HttpServletResponse response;
	private Connection conn;

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
	
	private void ConstroiCenarioConnection() throws Exception{
		conn = new ControleFabricaDeConexao().getConnection();
		conn.setAutoCommit(false);
	}
	
	private Sessao ConstroiCenarioUsuario(String login, String senha) {
		Sessao usuario = mock(Sessao.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
		when(usuario.getNome_usuario()).thenReturn("testeNome");
		when(usuario.getLogin_usuario()).thenReturn("testeLogin");
		when(usuario.getQuantidade_de_sessoes()).thenReturn(5);
		return usuario;
	}
	
	private Sessao ConstroiCenarioUsuario() {
		Sessao usuario = mock(Sessao.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
		when(usuario.getNome_usuario()).thenReturn("testeNome");
		when(usuario.getLogin_usuario()).thenReturn("testeLogin");
		when(usuario.getQuantidade_de_sessoes()).thenReturn(5);
		when(usuario.getData_hora_sessao()).thenReturn("xx/xx/xxxx : xx:xx:xx");
		return usuario;
	}
	
	@Test
	public void ProcuraUsuarioPorParametrosDeLoginSenha_UsuarioExistente() throws Exception{
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("login")).thenReturn("xxxx");
		when(request.getParameter("senha")).thenReturn("xxxx");
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		ConstroiCenarioConnection();
		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			Sessao usuario = ConstroiCenarioUsuario(login, senha);
		} catch (Exception e) {
			assertTrue(false);
			conn.rollback();
			conn.close();
			throw new ServletExceptionTest("ProcuraUsuarioPorParametrosDeLoginSenha: "
					+e, "Ocorreu um erro no ServletUsuario!", response);
		}
	}
	
	@Test
	public void ProcuraUsuarioPorParametrosDeLoginSenha_UsuarioNull() throws Exception{
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("login")).thenReturn("xxxx");
		when(request.getParameter("senha")).thenReturn("xxxx");
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		ConstroiCenarioConnection();
		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			Sessao usuario = null;
		} catch (Exception e) {
			assertTrue(false);
			conn.rollback();
			conn.close();
			throw new ServletExceptionTest("ProcuraUsuarioPorParametrosDeLoginSenha: "
					+e, "Ocorreu um erro no ServletUsuario!", response);
		}
	}
	
	@Test(expected=Exception.class)
	public void ProcuraUsuarioPorParametrosDeLoginSenha_LancandoExcecao() throws Exception{
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		ConstroiCenarioConnection();
		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			Sessao usuario = null;
			assertTrue(false);
		} catch (Exception e) {
			conn.rollback();
			conn.close();
			throw new ServletExceptionTest("ProcuraUsuarioPorParametrosDeLoginSenha: "
					+e, "Ocorreu um erro no ServletUsuario!", response);
		}
	}
	
	@Test 
	public void ValidaProcuraUsuarioPorParametrosDeLoginSenha_UsuarioDiferenteDeNull() throws Exception{
		Sessao usuario = mock(Sessao.class);
		
		if(usuario != null){
		
		}else{
			assertTrue(false);
			conn.rollback();
			conn.close();
			new ControleDeRetornoServletTest()
				.RetornaErro("Os parametros informados estão incorretos!");
		}
	}
	
	@Test 
	public void ValidaProcuraUsuarioPorParametrosDeLoginSenha_UsuarioNull() throws Exception{
		Sessao usuario = null;
		ConstroiCenarioConnection();
		
		if(usuario != null){
			assertTrue(false);
		}else{
			conn.rollback();
			conn.close();
			new ControleDeRetornoServletTest()
				.RetornaErro("Os parametros informados estão incorretos!");
		}
	}
	
	@Test
	public void TrataSessaoDeUsuario_QuantidadeDeSessoesMaiorQueZero() throws SQLException {
		Sessao usuario = mock(Sessao.class);
		when(usuario.getQuantidade_de_sessoes()).thenReturn(5);
		
		int qtdErros = 0;
		if(usuario.getQuantidade_de_sessoes() > 0){
			qtdErros += 1;
		}else{
			assertTrue(false);
			qtdErros += 1;
		}
	}
	
	@Test
	public void TrataSessaoDeUsuario_QuantidadeDeSessoesZero() throws SQLException {
		Sessao usuario = mock(Sessao.class);
		when(usuario.getQuantidade_de_sessoes()).thenReturn(0);
		
		int qtdErros = 0;
		if(usuario.getQuantidade_de_sessoes() > 0){
			assertTrue(false);
			qtdErros += 1;
		}else{
			qtdErros += 1;
		}
	}
	
	@Test
	public void TrataSessaoDeUsuario_QuantidadeDeSessoesNull() throws SQLException {
		Sessao usuario = mock(Sessao.class);
		
		int qtdErros = 0;
		if(usuario.getQuantidade_de_sessoes() > 0){
			assertTrue(false);
			qtdErros += 1;
		}else{
			qtdErros += 1;
		}
	}

	@Test
	public void RetornaStatusDeTransacao_TransacaoRetornaValorUm(){
		int transacaoRealizada = 1;
		
		if(transacaoRealizada == 0){
			assertTrue(false);
		}else{
			
		}
	}
	
	@Test
	public void RetornaStatusDeTransacao_TransacaoRetornaValorZero(){
		int transacaoRealizada = 0;
		
		if(transacaoRealizada == 0){
			
		}else{
			assertTrue(false);
		}
	}
	
	/*Sessao usuario = mock(Sessao.class);
	when(usuario.getId_usuario()).thenReturn((long) -1);
	when(usuario.getData_hora_sessao()).thenReturn(new DataControle().RetornaDataHoraAtualRepresentacaoNumerica());*/
	
	@Test
	public void ValidaSessaoDeUsuario_QuantidadeDeErrosMaiorQueZero() throws Exception {
		ConstroiCenarioConnection();
		int qtdErros = 1;
		
		if(qtdErros == 0){
			assertTrue(false);
		}else{
			conn.rollback();
			conn.close();
			new ControleDeRetornoServletTest()
				.RetornaErro("ValidaSessaoDeUsuario, ocorreu um erro no servidor!");
		}
	}
	
	@Test
	public void ValidaSessaoDeUsuario_QuantidadeDeErrosZero() throws Exception{
		ConstroiCenarioConnection();
		int qtdErros = 0;
		
		if(qtdErros == 0){
			
		}else{
			assertTrue(false);
			conn.rollback();
			conn.close();
			new ControleDeRetornoServletTest()
				.RetornaErro("ValidaSessaoDeUsuario, ocorreu um erro no servidor!");
		}
	}
	
	@Test
	public void TrataUltimaSessaoUsuario_DataHoraSessaoDiferenteDeNullOuVazio() throws Exception{
		ConstroiCenarioConnection();
		Sessao usuario = ConstroiCenarioUsuario();
		
		if(usuario.getData_hora_sessao() != null && usuario.getData_hora_sessao() != ""){
			
		}else{
			assertTrue(false);
			conn.rollback();
			conn.close();
			new ControleDeRetornoServletTest()
				.RetornaErro("TrataUltimaSessaoUsuario, ocorreu um erro no servidor!");
		}
	}
	
	@Test
	public void TrataUltimaSessaoUsuario_DataHoraSessaoNull() throws Exception{
		ConstroiCenarioConnection();
		Sessao usuario = ConstroiCenarioUsuario();
		when(usuario.getData_hora_sessao()).thenReturn(null);

		if(usuario.getData_hora_sessao() != null && usuario.getData_hora_sessao() != ""){
			assertTrue(false);
		}else{
			conn.rollback();
			conn.close();
			new ControleDeRetornoServletTest()
				.RetornaErro("TrataUltimaSessaoUsuario, ocorreu um erro no servidor!");
		}
	}
	
	@Test
	public void TrataUltimaSessaoUsuario_DataHoraSessaoVazio() throws Exception{
		ConstroiCenarioConnection();
		Sessao usuario = ConstroiCenarioUsuario();
		when(usuario.getData_hora_sessao()).thenReturn("");
		
		if(usuario.getData_hora_sessao() != null && usuario.getData_hora_sessao() != ""){
			assertTrue(false);
		}else{
			conn.rollback();
			conn.close();
			new ControleDeRetornoServletTest()
				.RetornaErro("TrataUltimaSessaoUsuario, ocorreu um erro no servidor!");
		}
	}
	
	@Test
	public void ValidaLoginUsuario_QuantidadeDeErrosZero() throws SQLException {
		boolean sucesso = false;
		int qtdErros = 0;
		
		if(qtdErros > 0){
			//conn.rollback();
			//conn.close();
			//RetornaErroServlet();
		}else{
			sucesso = true;
			//conn.commit();
			//conn.close();
			//RetornaUsuarioServlet();
		}
		assertTrue(sucesso);
	}
	
	@Test
	public void ValidaLoginUsuario_QuantidadeDeErrosMaiorQueZero() throws SQLException {
		boolean sucesso = false;
		int qtdErros = 1;
		
		if(qtdErros > 0){
			sucesso = true;
			//conn.rollback();
			//conn.close();
		}else{
			//conn.commit();
			//conn.close();
		}
		assertTrue(sucesso);
	}
	
	/*private void RetornaUsuarioJsonRecuperadoViaLogin(Usuario usuario) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(usuario)); 
	}*/
}
