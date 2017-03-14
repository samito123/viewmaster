package controle.servlet.usuario;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Sessao;
import controle.conexao.ControleFabricaDeConexao;
import controle.servlet.ControleDeRetornoServlet;
import controle.servlet.exception.ServletException;
import dao.SessoesDeUsuarioDAO;
import dao.UltimaSessaoUsuarioDAO;
import dao.UsuarioDAO;


public class LogarUsuario {

	static private HttpServletRequest request;
	static private HttpServletResponse response;
	Connection conn;
	
	public LogarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		this.request = request;
		this.response = response;
		ProcuraUsuarioPorParametrosDeLoginSenha();
	}
	
	private void ProcuraUsuarioPorParametrosDeLoginSenha() throws Exception{
		conn = new ControleFabricaDeConexao().getConnection();
		conn.setAutoCommit(false);
		Sessao usuario;
		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			usuario = new UsuarioDAO(conn).BuscaUsuarioLogin(login, senha);
		} catch (Exception e) {
			conn.rollback();
			conn.close();
			throw new ServletException("ProcuraUsuarioPorParametrosDeLoginSenha: "+e, "Ocorreu um erro no ServletUsuario!", response);
		}
		ValidaProcuraUsuarioPorParametrosDeLoginSenha(usuario);
	}
	
	private void ValidaProcuraUsuarioPorParametrosDeLoginSenha(Sessao usuario) throws Exception{
		if(usuario != null){
			TrataSessaoDeUsuario(usuario);
		}else{
			conn.rollback();
			conn.close();
			new ControleDeRetornoServlet(response)
			.RetornaErro("Os parametros informados estão incorretos!");
		}
	}
	
	private void TrataSessaoDeUsuario(Sessao usuario) throws Exception {
		int qtdErros = 0;
		if(usuario.getQuantidade_de_sessoes() > 0){
			qtdErros = RetornaStatusDeTransacao(new SessoesDeUsuarioDAO(conn)
				.AtualizaSessaoUsuario(usuario));
		}else{
			qtdErros = RetornaStatusDeTransacao(new SessoesDeUsuarioDAO(conn)
				.InsereSessaoUsuario(usuario));
		}
		ValidaSessaoDeUsuario(usuario, qtdErros);
	}
	
	private int RetornaStatusDeTransacao(int transacaoRealizada){
		if(transacaoRealizada == 0){
			return +1;
		}
		else{
			return +0;
		}
	}
	
	private void ValidaSessaoDeUsuario(Sessao usuario, int qtdErros) throws Exception {
		if(qtdErros == 0){
			TrataUltimaSessaoUsuario(usuario, qtdErros);
		}else{
			conn.rollback();
			conn.close();
			new ControleDeRetornoServlet(response)
			.RetornaErro("ValidaSessaoDeUsuario, ocorreu um erro no servidor!");
		}
	}
	
	
	private void TrataUltimaSessaoUsuario(Sessao usuario, int qtdErros) throws Exception {
		if(usuario.getData_hora_sessao() != null && usuario.getData_hora_sessao() != ""){
			qtdErros = RetornaStatusDeTransacao(new UltimaSessaoUsuarioDAO(conn).
					   AtualizaUltimaSessaoUsuario(usuario));
		}else{
			qtdErros = RetornaStatusDeTransacao(new UltimaSessaoUsuarioDAO(conn).
					   InsereUltimaSessaoUsuario(usuario));
		}
		ValidaLoginUsuario(usuario, qtdErros);
	}

	private void ValidaLoginUsuario(Sessao usuario, int qtdErros) throws Exception {
		if(qtdErros == 0){
			conn.commit();
			conn.close();
			new ControleDeRetornoServlet(response)
			.RetornaErro("lalala sucesso");	
		}else{
			conn.rollback();
			conn.close();
			new ControleDeRetornoServlet(response)
			.RetornaErro("ValidaLoginUsuario, ocorreu um erro no servidor!"+qtdErros);
		}
	}
	
	/*private void VerificaLoginDiferenteDeNullOuVazio() throws Exception{
		if(request.getParameter("login") != null && request.getParameter("login") != ""){
			VerificaSenhaDiferenteDeNull();
		}else{
			throw new Exception("Erro: login.request null ou vazio");
		}
	}
	
	private void VerificaSenhaDiferenteDeNull() throws Exception{
		if(request.getParameter("login") != null && request.getParameter("senha") != ""){
			CriaUsuarioRequest();
		}else{
			throw new Exception("Erro: senha.request null ou vazio");
		}
	}
	
	public void CriaUsuarioRequest() throws Exception{
		Usuario usuario = new Usuario();
		
		usuario.setLogin_usuario(request.getParameter("login"));		
		usuario.setSenha_usuario(request.getParameter("senha"));
		
		RecuperaUsuarioDoBancoViaLoginSenha(usuario);
	}
	
	private void RecuperaUsuarioDoBancoViaLoginSenha(Usuario usuario) throws Exception{
			UsuarioDAO dao = new UsuarioDAO();
			usuario = dao.VerificaLoginDeAcessoRetornaUsuario(usuario);
			VerificaUsuarioRetornado(usuario);
	}
	
	private void VerificaUsuarioRetornado(Usuario usuario) throws Exception{
		if(usuario.getNome_usuario() != null && usuario.getNome_usuario() != ""){
			VerificaSeSessaoDoUsuarioExiste(usuario);
		}else{
			throw new Exception("Erro: Usuario ou senha incorreto!");
		}
	}
	
	private void VerificaSeSessaoDoUsuarioExiste(Usuario usuario) throws Exception{
		SessoesDeUsuarioDAO dao = new SessoesDeUsuarioDAO();
		long quantidadeDeSessoes = dao.VerificaSeSessaoDoUsuarioExiste(usuario);
		if(quantidadeDeSessoes > 0){
			//UpdateSessaoUsuario(usuario, quantidadeDeSessoes);
		}else{
			SalvarSessaoUsuario(usuario);
		}
	}
	
	private void UpdateSessoesDeUsuario(Usuario usuario, long quantidadeDeSessoes) throws SQLException, IOException{
		SessoesDeUsuarioDAO dao = new SessoesDeUsuarioDAO();
		int transacaoRealizada = dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes);
		VerificaSeUpdateSessaoDeUsuarioOcorreuComSucesso(usuario, transacaoRealizada);
	}
	
	private void VerificaSeUpdateSessaoDeUsuarioOcorreuComSucesso(Usuario usuario, int transacaoRealizada) 
			throws SQLException, IOException{
		if(transacaoRealizada == 1){
			VerificarUltimaSessaoUsuario(usuario);
		}else{
			
		}
	}
	
	private void SalvarSessaoUsuario(Usuario usuario) throws SQLException, IOException{
		try{
			SessoesDeUsuarioDAO dao = new SessoesDeUsuarioDAO();
			dao.SalvarSessaoUsuario(usuario);
			RetornaUsuarioJsonRecuperadoViaLogin(usuario);
		}catch(Exception e){
			//new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void VerificarUltimaSessaoUsuario(Usuario usuario) throws SQLException, IOException{
		UltimaSessaoUsuarioDAO dao =  new UltimaSessaoUsuarioDAO();
		if(dao.VerificaSeUltimaSessaoDoUsuarioExiste(usuario) == true){
			UpdateUltimaSessaoUsuario(usuario);
		}else{
			SalvarUltimaSessaoUsuario(usuario);
		}
	}
	
	private void UpdateUltimaSessaoUsuario(Usuario usuario) throws SQLException, IOException{
		try{
			UltimaSessaoUsuarioDAO dao =  new UltimaSessaoUsuarioDAO();
			dao.UpdateUltimaSessaoUsuario(usuario);
			RetornaUsuarioJsonRecuperadoViaLogin(usuario);
		}catch(Exception e){
			//new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void SalvarUltimaSessaoUsuario(Usuario usuario) throws SQLException, IOException{
		try{
			UltimaSessaoUsuarioDAO dao =  new UltimaSessaoUsuarioDAO();
			dao.SalvarUltimaSessaoUsuario(usuario);
			RetornaUsuarioJsonRecuperadoViaLogin(usuario);
		}catch(Exception e){
			//new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void RetornaUsuarioJsonRecuperadoViaLogin(Usuario usuario) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(usuario)); 
	}*/
}
