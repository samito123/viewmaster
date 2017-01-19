package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Assinatura;
import controle.conexao.ControleFabricaDeConexao;


public class AssinaturasDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ArrayList<Assinatura> RetornaListaDeAssinaturas(ArrayList<Assinatura> assinaturas) 
			throws SQLException{
		
		Assinatura assinatura;
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_assinatura order by id_assinatura desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				assinatura = new Assinatura();
				assinatura.setId_assinatura(rs.getLong("id_assinatura"));
				assinatura.setTipo_assinatura(rs.getString("tipo_assinatura"));
				assinatura.setData_inicial_assinatura(rs.getString("data_inicial_assinatura"));
				assinatura.setData_final_assinatura(rs.getString("data_final_assinatura"));
				assinatura.setData_bloqueio_assinatura(rs.getString("data_bloqueio_assinatura"));
				assinaturas.add(assinatura);
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return assinaturas;
	}
	
}
