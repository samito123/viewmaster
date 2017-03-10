package testes.integracao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import modelos.Sessao;
import modelos.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import controle.auxiliares.DataControle;
import controle.conexao.ControleFabricaDeConexao;
import controle.modelos.ControleTratamentoMesAno;

public class SessoesDeUsuarioDAOTest {

	Connection conn;
	
	@Before
	public void ConstroiCenario() throws SQLException{
		try {
			conn = new ControleFabricaDeConexao().getConnection();
			conn.setAutoCommit(false);
			CenarioDeSessao();
		} catch (Exception e) {
			System.out.println(e);
		}	
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
			ps.setString(2, new DataControle().RetornaDiaAtualRepresentacaoNumerica()); 
			ps.setString(3, new DataControle().RetornaMesAtualRepresentacaoNumerica()); 
			ps.setString(4, new DataControle().RetornaAnoAtualRepresentacaoNumerica()); 
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
	public void AtualizaSessaoUsuario_UsuarioQuantidadeDeSessoesMaiorQueZero() throws SQLException {
		Sessao usuario = mock(Sessao.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
		when(usuario.getNome_usuario()).thenReturn("testeNome");
		when(usuario.getLogin_usuario()).thenReturn("testeLogin");
		when(usuario.getQuantidade_de_sessoes()).thenReturn(5);
		
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
			ps.setString(3, new DataControle().RetornaMesAtualRepresentacaoNumerica()); 
			ps.setString(4, new DataControle().RetornaAnoAtualRepresentacaoNumerica()); 
			transacaoRealizada = ps.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Erro: UpdateSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		assertEquals(transacaoRealizada, 1);
		//return transacaoRealizada;
	}
	
	@Test
	public void AtualizaSessaoUsuario_UsuarioQuantidadeDeSessoesZero() throws SQLException {
		Sessao usuario = mock(Sessao.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
		when(usuario.getNome_usuario()).thenReturn("testeNome");
		when(usuario.getLogin_usuario()).thenReturn("testeLogin");
		when(usuario.getQuantidade_de_sessoes()).thenReturn(0);
		
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
			ps.setString(3, new DataControle().RetornaMesAtualRepresentacaoNumerica()); 
			ps.setString(4, new DataControle().RetornaAnoAtualRepresentacaoNumerica()); 
			transacaoRealizada = ps.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Erro: UpdateSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		assertEquals(transacaoRealizada, 1);
		//return transacaoRealizada;
	}
	
	@Test
	public void AtualizaSessaoUsuario_UsuarioQuantidadeDeSessoesNull() throws SQLException {
		Sessao usuario = mock(Sessao.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
		when(usuario.getNome_usuario()).thenReturn("testeNome");
		when(usuario.getLogin_usuario()).thenReturn("testeLogin");
		when(usuario.getQuantidade_de_sessoes()).thenReturn(0);
		
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
			ps.setString(3, new DataControle().RetornaMesAtualRepresentacaoNumerica()); 
			ps.setString(4, new DataControle().RetornaAnoAtualRepresentacaoNumerica()); 
			transacaoRealizada = ps.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Erro: UpdateSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		assertEquals(transacaoRealizada, 1);
		//return transacaoRealizada;
	}
	
	@Test
	public void AtualizaSessaoUsuario_UsuarioNull() throws SQLException {
		Sessao usuario = null;
		
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
			ps.setString(3, new DataControle().RetornaMesAtualRepresentacaoNumerica()); 
			ps.setString(4, new DataControle().RetornaAnoAtualRepresentacaoNumerica()); 
			transacaoRealizada = ps.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Erro: UpdateSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		assertEquals(transacaoRealizada, 0);
		//return transacaoRealizada;
	}
	
	@Test
	public void InsereSessaoUsuario_PassandoUsuario() throws SQLException {
		Sessao usuario = mock(Sessao.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
		
		PreparedStatement ps = null;
		int transacaoRealizada = 0;
		try{
			
			String mesAtual = new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH));
			String anoAtual = ""+Calendar.getInstance().get(Calendar.YEAR); 
				
			String sql = "insert into tb_sessoes_usuario " 
					+ "(id_usuario, dia_sessao, mes_sessao, ano_sessao, quantidade_sessoes) "
					+ "values (?,?,?,?,?)"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, new DataControle().RetornaDiaAtualRepresentacaoNumerica()); 
			ps.setString(3, new DataControle().RetornaMesAtualRepresentacaoNumerica()); 
			ps.setString(4, new DataControle().RetornaAnoAtualRepresentacaoNumerica()); 
			ps.setLong(5, 1);  
			transacaoRealizada = ps.executeUpdate();
		}catch(Exception e){
			System.out.println("Erro: InsereSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		//return transacaoRealizada;
		assertEquals(transacaoRealizada, 1);
	}
	
	@Test
	public void InsereSessaoUsuario_PassandoUsuarioSemId() throws SQLException {
		Sessao usuario = mock(Sessao.class);
		
		PreparedStatement ps = null;
		int transacaoRealizada = 0;
		try{
			
			String mesAtual = new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH));
			String anoAtual = ""+Calendar.getInstance().get(Calendar.YEAR); 
				
			String sql = "insert into tb_sessoes_usuario " 
					+ "(id_usuario, dia_sessao, mes_sessao, ano_sessao, quantidade_sessoes) "
					+ "values (?,?,?,?,?)"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, new DataControle().RetornaDiaAtualRepresentacaoNumerica()); 
			ps.setString(3, new DataControle().RetornaMesAtualRepresentacaoNumerica()); 
			ps.setString(4, new DataControle().RetornaAnoAtualRepresentacaoNumerica()); 
			ps.setLong(5, 1); 
			transacaoRealizada = ps.executeUpdate();
		}catch(Exception e){
			System.out.println("Erro: InsereSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		//transacaoRealizada;
		assertEquals(transacaoRealizada, 1);
	}
	
	@Test
	public void InsereSessaoUsuario_PassandoUsuarioNull() throws SQLException {
		Sessao usuario = null;
		
		PreparedStatement ps = null;
		int transacaoRealizada = 0;
		try{
			
			String mesAtual = new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH));
			String anoAtual = ""+Calendar.getInstance().get(Calendar.YEAR); 
				
			String sql = "insert into tb_sessoes_usuario " 
					+ "(id_usuario, dia_sessao, mes_sessao, ano_sessao, quantidade_sessoes) "
					+ "values (?,?,?,?,?)"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, new DataControle().RetornaDiaAtualRepresentacaoNumerica()); 
			ps.setString(3, new DataControle().RetornaMesAtualRepresentacaoNumerica()); 
			ps.setString(4, new DataControle().RetornaAnoAtualRepresentacaoNumerica()); 
			ps.setLong(5, 1); 
			transacaoRealizada = ps.executeUpdate();
		}catch(Exception e){
			System.out.println("Erro: InsereSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		//transacaoRealizada;
		assertEquals(transacaoRealizada, 0);
	}
	
	/*@Before
	public void ConstroiCenarioDeSessaoDeUsuarioExistenteBancoDeDados() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
	
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try{
			conn = new ControleFabricaDeConexao().getConnection();
			conn.setAutoCommit(false);
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
	public void FechaCenarioDeUsuarioBancoDeDados() throws SQLException{
		conn.rollback();
		conn.close();
	}
	
	@Test
	public void VerificaSeSessaoDoUsuarioExiste_SessaoExistente() throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) 0);
	
		long quantidadeDeSessoes = 0;
		
		try {	
			
			//conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_sessoes_usuario where id_usuario = ? "
					+ "and mes_sessao = ? and ano_sessao = ?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))); 
			ps.setString(3, ""+Calendar.getInstance().get(Calendar.YEAR)); 
			rs = ps.executeQuery(); 
			if (rs.first()) { 
				quantidadeDeSessoes = rs.getLong(("quantidade_sessoes"));
			}	
		}catch (Exception e) {
			throw new Exception("Erro: VerificaSeSessaoDoUsuarioExiste, "+e);
		}finally{
			assertEquals(rs.getRow(), 1);
			rs.close();
			ps.close();
			//conn.close();
		}
	}
	
	@Test
	public void VerificaSeSessaoDoUsuarioExiste_SessaoNaoExistente() throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -2);
	
		long quantidadeDeSessoes = 0;
		
		try {	
			
			//conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_sessoes_usuario where id_usuario = ? "
					+ "and mes_sessao = ? and ano_sessao = ?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))); 
			ps.setString(3, ""+Calendar.getInstance().get(Calendar.YEAR)); 
			rs = ps.executeQuery(); 
			if (rs.first()) { 
				quantidadeDeSessoes = rs.getLong(("quantidade_sessoes"));
			}	
		}catch (Exception e) {
			throw new Exception("Erro: VerificaSeSessaoDoUsuarioExiste, "+e);
		}finally{
			assertEquals(rs.getRow(), 0);
			rs.close();
			ps.close();
			//conn.close();
		}
	}
	
	@Test(expected=Exception.class)
	public void VerificaSeSessaoDoUsuarioExiste_ErroSQL() throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -2);
		int trasacaoErro = 0;
		
		long quantidadeDeSessoes = 0;
		try {	
			//conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_xxx where id_usuario = ? "
					+ "and mes_sessao = ? and ano_sessao = ?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))); 
			ps.setString(3, ""+Calendar.getInstance().get(Calendar.YEAR)); 
			rs = ps.executeQuery(); 
			if (rs.first()) { 
				quantidadeDeSessoes = rs.getLong(("quantidade_sessoes"));
			}	
		}catch (Exception e) {
			trasacaoErro = 1;
			throw new Exception("Erro: VerificaSeSessaoDoUsuarioExiste, "+e);
		}finally{
			assertEquals(trasacaoErro, 1);
			rs.close();
			ps.close();
			//conn.close();
		}
	}
	
	@Test
	public void UpdateSessaoUsuario_TransacaoComSucesso() throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
	
		long quantidadeDeSessoes = 8;
		int transacaoRealizada = 0;
		try {	
			//conn = new ControleFabricaDeConexao().getConnection();
			String sql = "update tb_sessoes_usuario set " 
					+ "quantidade_sessoes=? "
					+ "where id_usuario=? and mes_sessao=? and ano_sessao=?"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, quantidadeDeSessoes+1); 
			ps.setLong(2, usuario.getId_usuario()); 
			ps.setString(3, new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))); 
			ps.setString(4, ""+Calendar.getInstance().get(Calendar.YEAR)); 
			transacaoRealizada = ps.executeUpdate();
			
		}catch (Exception e) {
			transacaoRealizada = 0;
			throw new Exception("Erro: UpdateSessaoUsuario, "+e);
		}finally{
			assertEquals(transacaoRealizada, 1);
			ps.close();
			//conn.close();	
		}
	}
	
	@Test
	public void UpdateSessaoUsuario_TransacaoSemSucesso() throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -2);
	
		long quantidadeDeSessoes = 8;
		int transacaoRealizada = 0;
		try {	
			//conn = new ControleFabricaDeConexao().getConnection();
			String sql = "update tb_sessoes_usuario set " 
					+ "quantidade_sessoes=? "
					+ "where id_usuario=? and mes_sessao=? and ano_sessao=?"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, quantidadeDeSessoes+1); 
			ps.setLong(2, usuario.getId_usuario()); 
			ps.setString(3, new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))); 
			ps.setString(4, ""+Calendar.getInstance().get(Calendar.YEAR)); 
			transacaoRealizada = ps.executeUpdate();
			
		}catch (Exception e) {
			transacaoRealizada = 0;
			throw new Exception("Erro: UpdateSessaoUsuario, "+e);
		}finally{
			assertEquals(transacaoRealizada, 0);
			ps.close();
			//conn.close();	
		}
	}
	
	@Test(expected=Exception.class)
	public void UpdateSessaoUsuario_ErroSQL() throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -2);
	
		long quantidadeDeSessoes = 8;
		int transacaoRealizada = 0;
		try {	
			//conn = new ControleFabricaDeConexao().getConnection();
			String sql = "update tb_xxx set " 
					+ "quantidade_sessoes=? "
					+ "where id_usuario=? and mes_sessao=? and ano_sessao=?"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, quantidadeDeSessoes+1); 
			ps.setLong(2, usuario.getId_usuario()); 
			ps.setString(3, new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))); 
			ps.setString(4, ""+Calendar.getInstance().get(Calendar.YEAR)); 
			transacaoRealizada = ps.executeUpdate();
			
		}catch (Exception e) {
			transacaoRealizada = 1;
			throw new Exception("Erro: UpdateSessaoUsuario, "+e);
		}finally{
			assertEquals(transacaoRealizada, 1);
			ps.close();
			//conn.close();	
		}
	}*/

}
