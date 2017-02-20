package testes.unitarios.usuario.servlet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Usuario;

import org.junit.Test;
import org.mockito.Mockito;

import servlet.controle.usuario.ServletControleLoginDeUsuario;
import controle.conexao.ControleDeRetornoServidor;

public class ServletUsuarioTest extends Mockito{
	
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
		assertEquals(sucesso, true);
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
		assertEquals(sucesso, true);
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
					sucesso = true;
					break;
			}
		}catch(Exception e){
			sucesso = false;
		}
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
			System.out.println(e);
			sucesso = true;
		}
		assertEquals(sucesso, true);
	}
	
	private void GeraExcessao() throws Exception{
		throw new Exception("Erro: Blah! Blah! Blah!.");
	}
	
	/*private Usuario CriaUsuarioParaTeste(String nome ,String login, String senha){
		Usuario usuario = new Usuario();
		usuario.setNome_usuario(nome);
		usuario.setLogin_usuario(login);
		usuario.setSenha_usuario(senha);
		return usuario;
	}
	
	@Test
	public Usuario CriaObjetoUsuarioRequest_CampoNull(){
		Usuario usuario = new Usuario();
		if(request.getParameter("id") != null)
			usuario.setId_usuario(Long.parseLong(request.getParameter("id")));
		if(request.getParameter("nome") != null)
			usuario.setNome_usuario(request.getParameter("nome"));	
		if(request.getParameter("login") != null)
			usuario.setLogin_usuario(request.getParameter("login"));		
		if(request.getParameter("senha") != null)
			usuario.setSenha_usuario(request.getParameter("senha"));
		if(request.getParameter("email") != null)
			usuario.setEmail_usuario(request.getParameter("email"));
		if(request.getParameter("data_nascimento") != null)
			usuario.setData_nascimento_usuario(request.getParameter("data_nascimento").replaceAll("-", "/"));
		if(request.getParameter("pergunta_secreta") != null)
			usuario.setPergunta_secreta_usuario(request.getParameter("pergunta_secreta"));
		if(request.getParameter("resposta_pergunta_secreta") != null)
			usuario.setResposta_pergunta_secreta_usuario(request.getParameter("resposta_pergunta_secreta"));
		
		assertEquals(usuario.getNome_usuario(), "Luiz Samito"); 
		return usuario;
	}
	
	@Test 
	public void VerificaLoginDeAcessoRetornaUsuario_PassandoUsuarioExistente() throws SQLException{
		try {	
			usuario = CriaUsuarioParaTeste(null,"samito","123");
			
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_usuarios where login_usuario = ? "
					+ "and senha_usuario = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getLogin_usuario()); 
			ps.setString(2, usuario.getSenha_usuario()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setSenha_usuario(rs.getString("senha_usuario"));
				usuario.setEmail_usuario(rs.getString("email_usuario"));
				usuario.setData_nascimento_usuario(rs.getString("data_nascimento_usuario"));
				usuario.setPergunta_secreta_usuario(rs.getString("pergunta_secreta_usuario"));
				usuario.setResposta_pergunta_secreta_usuario(rs.getString("resposta_pergunta_secreta_usuario"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		assertEquals(usuario.getNome_usuario(), "Luiz Samito"); 
	}
	
	@Test 
	public void VerificaLoginDeAcessoRetornaUsuario_PassandoUsuarioNaoExistente() throws SQLException{
		try {	
			usuario = CriaUsuarioParaTeste(null,"abahxvjavxjhjax","123");
			
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_usuarios where login_usuario = ? "
					+ "and senha_usuario = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getLogin_usuario()); 
			ps.setString(2, usuario.getSenha_usuario()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setSenha_usuario(rs.getString("senha_usuario"));
				usuario.setEmail_usuario(rs.getString("email_usuario"));
				usuario.setData_nascimento_usuario(rs.getString("data_nascimento_usuario"));
				usuario.setPergunta_secreta_usuario(rs.getString("pergunta_secreta_usuario"));
				usuario.setResposta_pergunta_secreta_usuario(rs.getString("resposta_pergunta_secreta_usuario"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		assertEquals(usuario.getNome_usuario(), null); 
	}
	
	@Test
	public void VerificaLoginDeAcessoRetornaUsuario_UsuarioComCampoLoginVazio() throws SQLException{
		try {	
			usuario = CriaUsuarioParaTeste(null,"","123");
			
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_usuarios where login_usuario = ? "
					+ "and senha_usuario = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getLogin_usuario()); 
			ps.setString(2, usuario.getSenha_usuario()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setSenha_usuario(rs.getString("senha_usuario"));
				usuario.setEmail_usuario(rs.getString("email_usuario"));
				usuario.setData_nascimento_usuario(rs.getString("data_nascimento_usuario"));
				usuario.setPergunta_secreta_usuario(rs.getString("pergunta_secreta_usuario"));
				usuario.setResposta_pergunta_secreta_usuario(rs.getString("resposta_pergunta_secreta_usuario"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		assertEquals(usuario.getNome_usuario(), null); 
	}
	
	@Test
	public void VerificaLoginDeAcessoRetornaUsuario_UsuarioComCampoSenhaVazio() throws SQLException{
		try {	
			usuario = CriaUsuarioParaTeste(null,"samito","");
			
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_usuarios where login_usuario = ? "
					+ "and senha_usuario = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getLogin_usuario()); 
			ps.setString(2, usuario.getSenha_usuario()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setSenha_usuario(rs.getString("senha_usuario"));
				usuario.setEmail_usuario(rs.getString("email_usuario"));
				usuario.setData_nascimento_usuario(rs.getString("data_nascimento_usuario"));
				usuario.setPergunta_secreta_usuario(rs.getString("pergunta_secreta_usuario"));
				usuario.setResposta_pergunta_secreta_usuario(rs.getString("resposta_pergunta_secreta_usuario"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		assertEquals(usuario.getNome_usuario(), null); 
	}*/
	
	/*@Test
	public void VerificaRetornoDeUsuarioParaLogin() throws IOException, SQLException{
		usuario = CriaUsuarioParaTeste("aaa","samito","123");
		
		if(usuario.getNome_usuario() == null){
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}else{
			VerificaSeSessaoDoUsuarioExiste(usuario);
		}
	}*/
}
