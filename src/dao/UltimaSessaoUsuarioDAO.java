package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.Usuario;
import controle.auxiliares.DataControle;


public class UltimaSessaoUsuarioDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UltimaSessaoUsuarioDAO(Connection conn){
		this.conn = conn;
	}
	
	public int AtualizaUltimaSessaoUsuario(Usuario usuario) throws SQLException{
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
			conn.rollback();
			conn.close();
			System.out.print("Erro: AtualizaUltimaSessaoUsuario, "+e);
		}finally{
			ps.close();
		}
		return transacaoSucesso;
	}
	
	public int InsereUltimaSessaoUsuario(Usuario usuario) throws SQLException{
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
			conn.rollback();
			conn.close();
			System.out.print("Erro: InsereUltimaSessaoUsuario, "+e);
		}finally{
			ps.close();
		}
		return transacaoSucesso;
	}
	
}
