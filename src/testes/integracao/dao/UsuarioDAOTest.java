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
import java.util.Calendar;

import javax.servlet.ServletException;

import modelos.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controle.conexao.ControleFabricaDeConexao;
import controle.modelos.ControleTratamentoMesAno;

public class UsuarioDAOTest {
	
	Connection conn;
	
	@Before
	public void ConstroiCenario() throws SQLException{
		try {
			conn = new ControleFabricaDeConexao().getConnection();
			conn.setAutoCommit(false);
			CenarioDeUsuario();
			CenarioDeUsuario();
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	private void CenarioDeUsuario() throws SQLException{
		Usuario usuario = new Usuario("UsuarioTeste", "testeLogin", "testeSenha");
		
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try{
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
	
	private void CenarioDeSessao() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
	
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try{
			String sql = "insert into tb_sessoes_usuario "
					+ "(id_usuario, dia_sessao, mes_sessao,"
					+ "ano_sessao, horario_sessao, quantidade_sessoes) values"
					+ "(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, ""+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)); 
			ps.setString(3, new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))); 
			ps.setString(4, ""+Calendar.getInstance().get(Calendar.YEAR)); 
			ps.setString(5, Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+Calendar.getInstance().get(Calendar.MINUTE)); 
			ps.setInt(6, 5); 
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
	public void FechaCenario() throws SQLException{
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
	
	//TESTECRIASESSAO
	@Test
	public void LoginDeUsuario_UsuarioExistente() throws Exception{
		Usuario usuarioMock = mock(Usuario.class);
		when(usuarioMock.getLogin_usuario()).thenReturn("testeLogin");
		when(usuarioMock.getSenha_usuario()).thenReturn("testeSenha");
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Usuario usuario;
		int qtdErros = 0;
		try {
			String sql = "select * from tb_usuarios where login_usuario = ? "
				+ "and senha_usuario = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuarioMock.getLogin_usuario()); 
			ps.setString(2, usuarioMock.getSenha_usuario()); 
			rs = ps.executeQuery(); 
			
			usuario = new Usuario(rs);
			
			if(usuario.getNome_usuario() == null || usuario.getNome_usuario() == "")
				qtdErros +=1;
			
			
		} catch (Exception e) {
			throw new Exception("Erro: LoginDeUsuario, "+e);
		}finally{
			rs.close();
			ps.close();
		}
		assertEquals(usuario.getNome_usuario(), "UsuarioTeste");
	}
	
	private Usuario VerificaUsuarioExiste(String login, String senha){
		Usuario usuario = null;
		
		return usuario;
	}

}
