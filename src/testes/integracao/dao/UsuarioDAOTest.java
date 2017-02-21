package testes.integracao.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import modelos.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controle.conexao.ControleFabricaDeConexao;

public class UsuarioDAOTest {
	
	Connection conn;
	
	@Before
	public void ConstroiCenarioDeUsuarioExistenteBancoDeDados() throws SQLException{
		Usuario usuario = new Usuario("UsuarioTeste", "testeLogin", "testeSenha");
		
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try{
			conn = new ControleFabricaDeConexao().getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into tb_usuarios "
					+ "(nome_usuario, login_usuario, senha_usuario,"
					+ "email_usuario, data_nascimento_usuario, "
					+ "pergunta_secreta_usuario, resposta_pergunta_secreta_usuario) values"
					+ "(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getNome_usuario()); 
			ps.setString(2, usuario.getLogin_usuario()); 
			ps.setString(3, usuario.getSenha_usuario()); 
			ps.setString(4, usuario.getEmail_usuario());
			ps.setString(5, usuario.getData_nascimento_usuario());
			ps.setString(6, usuario.getPergunta_secreta_usuario());
			ps.setString(7, usuario.getResposta_pergunta_secreta_usuario());
			transacaoSucesso = ps.executeUpdate(); 
		}catch(Exception e){
			System.out.println(e);
		}finally{
			ps.close();
			//System.out.println(transacaoSucesso);
		}
		//assertEquals(transacaoSucesso, 1);
	}
	
	@After
	public void FechaCenarioDeUsuarioBancoDeDados() throws SQLException{
		conn.rollback();
		conn.close();
	}
	
	@Test
	public void VerificaLoginSenhaDeAcessoRetornaUsuario_UsuarioExistente() throws Exception{
		Usuario usuarioMock = mock(Usuario.class);
		when(usuarioMock.getLogin_usuario()).thenReturn("testeLogin");
		when(usuarioMock.getSenha_usuario()).thenReturn("testeSenha");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = new Usuario();
		try {
			String sql = "select * from tb_usuarios where login_usuario = ? "
				+ "and senha_usuario = ?";
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuarioMock.getLogin_usuario()); 
			ps.setString(2, usuarioMock.getSenha_usuario()); 
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
		} catch (Exception e) {
			throw new Exception("Erro: VerificaLoginDeAcessoRetornaUsuario, "+e);
		}finally{
			rs.close();
			ps.close();
		}
		assertEquals(usuario.getNome_usuario(), "UsuarioTeste");
	}
	
	@Test
	public void VerificaLoginSenhaDeAcessoRetornaUsuario_UsuarioNaoExistente() throws Exception{
		Usuario usuarioMock = mock(Usuario.class);
		when(usuarioMock.getLogin_usuario()).thenReturn("xxxxxxxxx");
		when(usuarioMock.getSenha_usuario()).thenReturn("xxxxxxxxx");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			
			String sql = "select * from tb_usuarios where login_usuario = ? "
				+ "and senha_usuario = ?";
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuarioMock.getLogin_usuario()); 
			ps.setString(2, usuarioMock.getSenha_usuario()); 
			rs = ps.executeQuery(); 
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setSenha_usuario(rs.getString("senha_usuario"));
				usuario.setEmail_usuario(rs.getString("email_usuario"));
				usuario.setData_nascimento_usuario(rs.getString("data_nascimento_usuario"));
				usuario.setPergunta_secreta_usuario(rs.getString("pergunta_secreta_usuario"));
				usuario.setResposta_pergunta_secreta_usuario(rs.getString("resposta_pergunta_secreta_usuario"));
			}	
		} catch (Exception e) {
			throw new Exception("Erro: VerificaLoginDeAcessoRetornaUsuario, "+e);
		}finally{
			rs.close();
			ps.close();
		}
		assertNull(usuario);
	}

}
