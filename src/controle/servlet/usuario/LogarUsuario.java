package controle.servlet.usuario;

import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Sessao;
import controle.conexao.ControleFabricaDeConexao;
import dao.UsuarioDAO;


public class LogarUsuario {

	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public LogarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		this.request = request;
		this.response = response;
		//VerificaLoginDiferenteDeNullOuVazio();
		LoginDeUsuario();
	}
	
	public void LoginDeUsuario() throws Exception{

		Connection conn = new ControleFabricaDeConexao().getConnection();
		conn.setAutoCommit(false);
		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			Sessao usuario = new UsuarioDAO(conn).BuscarUsuarioLogin(login, senha);
			if(usuario != null){
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
