package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import modelos.Usuario;
import controle.conexao.ControleFabricaDeConexao;
import controle.modelos.ControleTratamentoMesAno;


public class SessoesDeUsuarioDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Long VerificaSeSessaoDoUsuarioExiste(Usuario usuario) throws SQLException{
		
		long quantidadeDeSessoes = 0;
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
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
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return quantidadeDeSessoes;
	}
	
	public int UpdateSessaoUsuario(Usuario usuario, long quantidadeDeSessoes) throws SQLException{
		int transacaoRealizada = 0;
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
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
		}finally{
			ps.close();
			conn.close();	
		}
		return transacaoRealizada;
	}
	
	public void SalvarSessaoUsuario(Usuario usuario) throws SQLException{
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "insert into tb_sessoes_usuario" 
					+ "(id_usuario, dia_sessao, mes_sessao, ano_sessao, horario_sessao, quantidade_sessoes)"
					+ "values (?,?,?,?,?,?)"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, ""+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)); 
			ps.setString(3, new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))); 
			ps.setString(4, ""+Calendar.getInstance().get(Calendar.YEAR)); 
			ps.setString(5, Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+Calendar.getInstance().get(Calendar.MINUTE)); 
			ps.setInt(6, 1); 
			ps.execute(); 
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			ps.close();
			conn.close();
		}
	}
	
}
