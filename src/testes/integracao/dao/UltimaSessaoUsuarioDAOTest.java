package testes.integracao.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelos.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controle.auxiliares.DataControle;
import controle.conexao.ControleFabricaDeConexao;

public class UltimaSessaoUsuarioDAOTest {

Connection conn;
	
	@Before
	public void ConstroiCenario() throws SQLException{
		try {
			conn = new ControleFabricaDeConexao().getConnection();
			conn.setAutoCommit(false);
			CenarioDeUltimaSessao();
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	private void CenarioDeUltimaSessao() throws Exception{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
	
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try{
			String sql = "insert into tb_ultima_sessao_usuario "
					+ "(id_ultima_sessao, id_usuario, data_hora_sessao) values"
					+ "(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, -1); 
			ps.setLong(2, usuario.getId_usuario()); 
			ps.setString(3, new DataControle().RetornaDataHoraAtualRepresentacaoNumerica()); 
			transacaoSucesso = ps.executeUpdate(); 
		}catch(Exception e){
			conn.rollback();
			conn.close();
			System.out.println("Erro: CenarioDeSessao, "+e);
		}finally{
			ps.close();
		}
	}
	
	@After
	public void FechaCenario() throws SQLException{
		conn.rollback();
		conn.close();
	}
	
	@Test
	public void AtualizaUltimaSessaoUsuario_UsuarioExistente() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
		
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try {	
		
			String sql = "update tb_ultima_sessao_usuario set " 
					+ "data_hora_sessao=? "
					+ "where id_usuario =?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, new DataControle().RetornaDataHoraAtualRepresentacaoNumerica()); 
			ps.setLong(2, usuario.getId_usuario()); 
			transacaoSucesso = ps.executeUpdate(); 
		}catch (Exception e) {
			//conn.rollback();
			//conn.close();
			System.out.println("Erro: AtualizaUltimaSessaoUsuario, "+e);
		}finally{
			ps.close();
		}
		assertEquals(transacaoSucesso, 1);
	}
	
	@Test
	public void AtualizaUltimaSessaoUsuario_UsuarioNaoExistente() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -2);
		
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try {	
		
			String sql = "update tb_ultima_sessao_usuario set " 
					+ "data_hora_sessao=? "
					+ "where id_usuario =?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, new DataControle().RetornaDataHoraAtualRepresentacaoNumerica()); 
			ps.setLong(2, usuario.getId_usuario()); 
			transacaoSucesso = ps.executeUpdate(); 
		}catch (Exception e) {
			//conn.rollback();
			//conn.close();
			System.out.println("Erro: AtualizaUltimaSessaoUsuario, "+e);
		}finally{
			ps.close();
		}
		assertEquals(transacaoSucesso, 0);
	}
	
	@Test
	public void AtualizaUltimaSessaoUsuario_ErroSQL() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -2);
		
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try {	
		
			String sql = "update tbs_ultima_sessao_usuario set " 
					+ "data_hora_sessao=? "
					+ "where id_usuario =?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, new DataControle().RetornaDataHoraAtualRepresentacaoNumerica()); 
			ps.setLong(2, usuario.getId_usuario()); 
			transacaoSucesso = ps.executeUpdate(); 
		}catch (Exception e) {
			//conn.rollback();
			//conn.close();
			System.out.println("Erro: AtualizaUltimaSessaoUsuario, "+e);
		}finally{
			ps.close();
		}
		assertEquals(transacaoSucesso, 0);
	}
	
	@Test
	public void InsereUltimaSessaoUsuario_UsuarioExistente() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -1);
		
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try {	
		
			String sql = "insert into tb_ultima_sessao_usuario" 
					+ "(id_usuario, data_hora_sessao)"
					+ "values (?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, new DataControle().RetornaDataHoraAtualRepresentacaoNumerica()); 
			transacaoSucesso = ps.executeUpdate(); 
		}catch (Exception e) {
			//conn.rollback();
			//conn.close();
			System.out.println("Erro: InsereUltimaSessaoUsuario, "+e);
		}finally{
			ps.close();
		}
		assertEquals(transacaoSucesso, 1);
	}
	
	@Test
	public void InsereUltimaSessaoUsuario_UsuarioNaoExistente() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -2);
		
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try {	
		
			String sql = "insert into tb_ultima_sessao_usuario" 
					+ "(id_usuario, data_hora_sessao)"
					+ "values (?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, new DataControle().RetornaDataHoraAtualRepresentacaoNumerica()); 
			transacaoSucesso = ps.executeUpdate(); 
		}catch (Exception e) {
			//conn.rollback();
			//conn.close();
			System.out.println("Erro: InsereUltimaSessaoUsuario, "+e);
		}finally{
			ps.close();
		}
		assertEquals(transacaoSucesso, 1);
	}
	
	@Test
	public void InsereUltimaSessaoUsuario_UsuarioErroSQL() throws SQLException{
		Usuario usuario = mock(Usuario.class);
		when(usuario.getId_usuario()).thenReturn((long) -2);
		
		PreparedStatement ps = null;
		int transacaoSucesso = 0;
		try {	
		
			String sql = "insert into tbs_ultima_sessao_usuario" 
					+ "(id_usuario, data_hora_sessao)"
					+ "values (?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, new DataControle().RetornaDataHoraAtualRepresentacaoNumerica()); 
			transacaoSucesso = ps.executeUpdate(); 
		}catch (Exception e) {
			//conn.rollback();
			//conn.close();
			System.out.println("Erro: InsereUltimaSessaoUsuario, "+e);
		}finally{
			ps.close();
		}
		assertEquals(transacaoSucesso, 0);
	}
}
