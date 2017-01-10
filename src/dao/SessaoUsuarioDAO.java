package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.Usuario;
import control.FabricaDeConexao;


public class SessaoUsuarioDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void SalvarSessaoUsuario(Usuario usuario) throws SQLException{
		try {	
			conn = new FabricaDeConexao().getConnection();
			String sql = "insert into tb_sessoes_usuario" + " "
					+ "(id_usuario, dia_sessao, mes_sessao, ano_sessao, horario_sessao)" + " "
					+ "values (?,?,?,?,?)"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, ""+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)); 
			ps.setString(3, TrataMesCalendar(Calendar.getInstance().get(Calendar.MONTH))); 
			ps.setString(4, ""+Calendar.getInstance().get(Calendar.YEAR)); 
			ps.setString(5, Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+Calendar.getInstance().get(Calendar.MINUTE)); 
			ps.execute(); 
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			ps.close();
			conn.close();
		}
	}
	
	private String TrataMesCalendar(int mes){
		String mesTratado = "";
		
		switch (mes) {
			case 0:
				mesTratado = "01";
			break;
	
			case 1:
				mesTratado = "02";
			break;
			
			case 2:
				mesTratado = "03";
			break;
			
			case 3:
				mesTratado = "04";
			break;
			
			case 4:
				mesTratado = "05";
			break;
			
			case 5:
				mesTratado = "06";
			break;
			
			case 6:
				mesTratado = "07";
			break;
			
			case 7:
				mesTratado = "08";
			break;
			
			case 8:
				mesTratado = "09";
			break;
			
			case 9:
				mesTratado = "10";
			break;
			
			case 10:
				mesTratado = "11";
			break;
			
			case 11:
				mesTratado = "12";
			break;
		}
		
		return mesTratado;
	}
	
}
