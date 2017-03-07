package testes.integracao.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		usuario.setNome_usuario("testeNome");
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
	
	@Test
	public void BuscaUsuarioLogin_UsuarioExistente() throws SQLException {
		String login = "testeLogin";
		String senha = "testeSenha";
		
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
					+ "as quantidade_sessoes, "
					+ "(select us.data_hora_sessao "
					+ "from tb_usuarios as u "
					+ "left join tb_ultima_sessao_usuario as us "
					+ "on u.id_usuario = us.id_usuario "
					+ "where login_usuario = ?"
					+ "and senha_usuario = ?) "
					+ "as data_hora_sessao "				
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
			ps.setString(7, login); 
			ps.setString(8, senha);
			rs = ps.executeQuery(); 

			while (rs.next()) {
				usuario = new Sessao();
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setQuantidade_de_sessoes(rs.getInt(("quantidade_sessoes")));
			}
		}catch(Exception e){
			System.out.println("Erro: BuscaUsuarioLogin, "+e);
		}finally{
			rs.close();
			ps.close();
		}
		assertEquals(usuario.getNome_usuario(), "testeNome");
		//return usuario;
	}
	
	@Test
	public void BuscaUsuarioLogin_UsuarioNaoExistente() throws SQLException {
		String login = "xxxxx";
		String senha = "xxxxx";
		
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
					+ "as quantidade_sessoes, "
					+ "(select us.data_hora_sessao "
					+ "from tb_usuarios as u "
					+ "left join tb_ultima_sessao_usuario as us "
					+ "on u.id_usuario = us.id_usuario "
					+ "where login_usuario = ?"
					+ "and senha_usuario = ?) "
					+ "as data_hora_sessao "				
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
			ps.setString(7, login); 
			ps.setString(8, senha);
			rs = ps.executeQuery(); 

			while (rs.next()) {
				usuario = new Sessao();
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setQuantidade_de_sessoes(rs.getInt(("quantidade_sessoes")));
			}
		}catch(Exception e){
			System.out.println("Erro: BuscaUsuarioLogin, "+e);
		}finally{
			rs.close();
			ps.close();
		}
		assertEquals(usuario, null);
		//return usuario;
	}
	
	@Test
	public void BuscaUsuarioLogin_LancandoExcecao() throws SQLException {
		boolean sucesso = false;
		String login = "xxxxx";
		String senha = "xxxxx";
		
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
					+ "as quantidade_sessoes, "
					+ "(select us.data_hora_sessao "
					+ "from tb_usuarios as u "
					+ "left join tb_ultima_sessao_usuario as us "
					+ "on u.id_usuario = us.id_usuario "
					+ "where login_usuario = ?"
					+ "and senha_usuario = ?) "
					+ "as data_hora_sessao "				
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
			ps.setString(7, login); 
			ps.setString(8, senha);
			rs = ps.executeQuery(); 

			while (rs.next()) {
				usuario = new Sessao();
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setQuantidade_de_sessoes(rs.getInt(("quantidade_sessoes")));
			}
			usuario.getAno_sessao();
		}catch(Exception e){
			sucesso = true;
			System.out.println("Erro: BuscaUsuarioLogin, "+e);
		}finally{
			rs.close();
			ps.close();
		}
		assertTrue(sucesso);
		//return usuario;
	}
	
	private void TrataSessaoDeUsuario(Sessao usuario) throws SQLException {
		int qtdErros = 0;
		if(usuario.getQuantidade_de_sessoes() > 0){
			qtdErros = AtualizaSessaoUsuario(usuario);
		}else{
			qtdErros = InsereSessaoUsuario(usuario);
		}
		ValidaSessaoUsuario(qtdErros);
	}

	private int AtualizaSessaoUsuario(Sessao usuario) throws SQLException {
		PreparedStatement ps = null;
		int transacaoRealizada = 0;
		try{
			
			String mesAtual = new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH));
			String anoAtual = ""+Calendar.getInstance().get(Calendar.YEAR); 
				
			String sql = "update tb_sessoes_usuario set " 
					+ "quantidade_sessoes=? "
					+ "where id_usuario=? and mes_sessao=? and ano_sessao=?";
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getQuantidade_de_sessoes()+1); 
			ps.setLong(2, usuario.getId_usuario()); 
			ps.setString(3, new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))); 
			ps.setString(4, ""+Calendar.getInstance().get(Calendar.YEAR)); 
			transacaoRealizada = ps.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Erro: UpdateSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		return RetornaErroAtualizaSessaoUsuario(transacaoRealizada);
	}
	
	private int RetornaErroAtualizaSessaoUsuario(int transacaoRealizada){
		if(transacaoRealizada != 1){
			return +1;
		}
		else{
			return +0;
		}
	}
	
	private int InsereSessaoUsuario(Sessao usuario) throws SQLException {
		PreparedStatement ps = null;
		int transacaoRealizada = 0;
		try{
			
			String mesAtual = new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH));
			String anoAtual = ""+Calendar.getInstance().get(Calendar.YEAR); 
				
			String sql = "insert into tb_ultima_sessao_usuario " 
					+ "(id_usuario, data_hora_sessao) "
					+ "values (?, ?)"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, RetornaDataAtual()); 
			transacaoRealizada = ps.executeUpdate();
		}catch(Exception e){
			System.out.println("Erro: InsereSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		return RetornaErroInsereSessaoUsuario(transacaoRealizada);
	}
	
	private String RetornaDataAtual(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}
	
	private int RetornaErroInsereSessaoUsuario(int transacaoRealizada){
		if(transacaoRealizada != 1){
			return +1;
		}
		else{
			return +0;
		}
	}
	
	private void ValidaSessaoUsuario(int qtdErros) throws SQLException {
		if(qtdErros > 0){
			//conn.rollback();
			//conn.close();
		}else{
			//conn.commit();
			//conn.close();
		}
	}
	
	private void RetornaErroParaUsuario() {
		// TODO Auto-generated method stub
		
	}
}
