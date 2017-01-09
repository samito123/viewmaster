package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Ano;
import model.Mes;
import model.Usuario;
import control.FabricaDeConexao;


public class GraficosDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ArrayList<Mes> ConstroiDadosParaGraficoDeSessaoDoUsuario(Ano ano) throws SQLException{
		
		ArrayList<Mes> mesesDoAno = new ArrayList<>();
		
		try {	
			conn = new FabricaDeConexao().getConnection();
			String sql = "select * from tb_sessoes_usuario where id_usuario = ? "
					+ "and ano_sessao = ?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, ano.getId_de_busca()); 
			ps.setString(2, ano.getNome_do_ano()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				for(int x = 1; x < 13; x++){
					if(mesesDoAno.get(x).getNumero_do_mes() == rs.getString("mes_sessao")){
						mesesDoAno.get(x).setValor(+1);
					}
				}
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return mesesDoAno;
	}

}
