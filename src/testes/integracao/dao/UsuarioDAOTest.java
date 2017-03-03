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

import modelos.Sessao;
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
			CenarioDeSessao();
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	private void CenarioDeUsuario() throws SQLException{
		Usuario usuario = new Usuario();
		usuario.setNome_usuario("UsuarioTeste");
		usuario.setLogin_usuario("testeLogin");
		usuario.setSenha_usuario("testeSenha");
		
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try{
			String sql = "insert into tb_usuarios "
					+ "(id_usuario, nome_usuario, login_usuario, senha_usuario,"
					+ "email_usuario, data_nascimento_usuario, "
					+ "pergunta_secreta_usuario, resposta_pergunta_secreta_usuario) values"
					+ "(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, -1); 
			ps.setString(2, usuario.getNome_usuario()); 
			ps.setString(3, usuario.getLogin_usuario()); 
			ps.setString(4, usuario.getSenha_usuario()); 
			ps.setString(5, usuario.getEmail_usuario());
			ps.setString(6, usuario.getData_nascimento_usuario());
			ps.setString(7, usuario.getPergunta_secreta_usuario());
			ps.setString(8, usuario.getResposta_pergunta_secreta_usuario());
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
					+ "ano_sessao, quantidade_sessoes) values"
					+ "(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, ""+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)); 
			ps.setString(3, new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))); 
			ps.setString(4, ""+Calendar.getInstance().get(Calendar.YEAR)); 
			ps.setInt(5, 5); 
			transacaoSucesso = ps.executeUpdate(); 
		}catch(Exception e){
			System.out.println("Erro: CenarioDeSessao, "+e);
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
	
	/*@Test
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
	}*/
	
	//TESTECRIASESSAO
	@Test
	public void LoginDeUsuario_UsuarioExistente() throws Exception{
		String login = "testeLogin";
		String senha = "testeSenha";
		
		//conn = new ControleFabricaDeConexao().getConnection();
		//conn.setAutoCommit(false);
		try {
			
			Sessao usuario = BuscaUsuarioLogin(login, senha);
			assertEquals(usuario.getQuantidade_de_sessoes(), 5);
			if(usuario != null){
				TrataSessaoDeUsuario(usuario);
			}else{
				//RetornaErro
			}
		} catch (Exception e) {
			System.out.println("Erro: LoginDeUsuario, "+e);
		}finally{
			//conn.rollback();
			//conn.close();
		}
		
	}

	private Sessao BuscaUsuarioLogin(String login, String senha) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sessao usuario = null;
		
		try{
			String mesAtual = new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH));
			String anoAtual = ""+Calendar.getInstance().get(Calendar.YEAR); 
				
			String sql = "select id_usuario, nome_usuario, login_usuario, "
					+ "(select s.quantidade_sessoes "
					+ "from tb_usuarios as u "
					+ "left join tb_sessoes_usuario as s "
					+ "on u.id_usuario = s.id_usuario "
					+ "where login_usuario = ? "
					+ "and senha_usuario = ? "
					+ "and mes_sessao = ? "
					+ "and ano_sessao = ?) "
					+ "as quantidade_sessoes "
					+ "from tb_usuarios "
					+ "where login_usuario = ? "
					+ "and senha_usuario = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, login); 
			ps.setString(2, senha); 
			ps.setString(3, mesAtual); 
			ps.setString(4, anoAtual); 
			ps.setString(5, login); 
			ps.setString(6, senha); 
			rs = ps.executeQuery(); 

			while (rs.next()) {
				usuario = new Sessao();
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setQuantidade_de_sessoes(rs.getInt(("quantidade_sessoes")));
			}
		}catch(Exception e){
			
		}finally{
			rs.close();
			ps.close();
		}
		return usuario;
	}
	
	private void TrataSessaoDeUsuario(Sessao usuario) {
		// TODO Auto-generated method stub
		
	}
	
	/*private int VerificaSessaoUsuario(long idUsuario) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int quantidadeDeErros = 0;
		long quantidadeDeSessoes = 0;
		try{
			String mesAtual = new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH));
			String anoAtual = ""+Calendar.getInstance().get(Calendar.YEAR);
			String sql = "select * from tb_sessoes_usuario "
					+ "where id_usuario = "+idUsuario+" "
					+ "and mes_sessao = '"+mesAtual+"' "
					+ "and ano_sessao = '"+anoAtual+"' ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			if (rs.first()) { 
				quantidadeDeSessoes = rs.getLong(("quantidade_sessoes"));
				if(UpdateSessaoUsuario(idUsuario, quantidadeDeSessoes) == 0){
					quantidadeDeErros++;
				}
			}else{
				//CriaSessaoUsuario();
			}
		}catch(Exception e){
			System.out.println("erro: "+e);
		}finally{
			rs.close();
			ps.close();
		}
		System.out.println("ID: "+idUsuario);
		System.out.println("Quantidade de sessões: "+quantidadeDeSessoes);
		return quantidadeDeErros;
	}
	
	private int UpdateSessaoUsuario(long idUsuario, long quntidade) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		int sucesso = 0;
		try{
			String mesAtual = new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH));
			String anoAtual = ""+Calendar.getInstance().get(Calendar.YEAR);
			String sql = "update tb_sessoes_usuario "
					+ "set quantidade_sessoes = "
					+ "where id_usuario = "+idUsuario+" "
					+ "and mes_sessao = '"+mesAtual+"' "
					+ "and ano_sessao = '"+anoAtual+"' "; 
			ps = conn.prepareStatement(sql);
			sucesso = ps.executeUpdate(); 
		}catch(Exception e){
			System.out.println("Erro: UpdateSessaoUsuario, "+e);
		}finally{
			rs.close();
			ps.close();
		}
		return sucesso;
	}
	
	private void CriaSessaoUsuario(){
		
	}*/
	
	
}
