package testes.integracao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import modelos.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import controle.conexao.ControleFabricaDeConexao;
import controle.modelos.ControleTratamentoMesAno;

public class SessoesDeUsuarioDAOTest {

	Connection conn;
	
	@Before
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
	}
}
