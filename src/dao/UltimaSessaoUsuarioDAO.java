package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import modelos.Usuario;
import controle.conexao.ControleFabricaDeConexao;
import controle.modelos.ControleTratamentoMesAno;


public class UltimaSessaoUsuarioDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean VerificaSeUltimaSessaoDoUsuarioExiste(Usuario usuario) throws SQLException{
		
		boolean sessaoExiste = false;
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_ultima_sessao_usuario where id_usuario = ? ";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			rs = ps.executeQuery(); 
			if (rs.first()) { 
				sessaoExiste = true;
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return sessaoExiste;
	}
	
	public void UpdateUltimaSessaoUsuario(Usuario usuario) throws SQLException{
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "update tb_ultima_sessao_usuario set " 
					+ "data_hora_sessao=? "
					+ "where id_usuario =?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"/"+
				new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))+"/"+
				Calendar.getInstance().get(Calendar.YEAR)+" "+
				Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+
				Calendar.getInstance().get(Calendar.MINUTE)); 
			ps.setLong(2, usuario.getId_usuario()); 
			ps.execute(); 
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			ps.close();
			conn.close();
		}
	}
	
	public void SalvarUltimaSessaoUsuario(Usuario usuario) throws SQLException{
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "insert into tb_ultima_sessao_usuario" 
					+ "(id_usuario, data_hora_sessao)"
					+ "values (?,?)"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"/"+
					new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH))+"/"+
					Calendar.getInstance().get(Calendar.YEAR)+" "+
					Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+
					Calendar.getInstance().get(Calendar.MINUTE)); 
			ps.execute(); 
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			ps.close();
			conn.close();
		}
	}
	
}
