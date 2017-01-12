package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Ano;
import modelos.Mes;
import controle.conexao.ControleFabricaDeConexao;


public class GraficosDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ArrayList<Mes> ConstroiDadosParaGraficoDeSessaoDoUsuarioAno(Ano ano) throws SQLException{
		
		ArrayList<Mes> mesesDoAno = ano.getMeses_do_ano();
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_sessoes_usuario where id_usuario = ? "
					+ "and ano_sessao = ?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, ano.getId_de_busca()); 
			ps.setString(2, ano.getNumero_do_ano()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				int mes = rs.getInt("mes_sessao") - 1;
				mesesDoAno.get(mes).setValor(mesesDoAno.get(mes).getValor() + rs.getInt("quantidade_sessoes"));
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
	
	public ArrayList<Mes> ConstroiDadosParaGraficoDeSessaoDoUsuarioPorcentagem(Ano ano) throws SQLException{
		
		ArrayList<Mes> mesesDoAno = ano.getMeses_do_ano();
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_sessoes_usuario where id_usuario = ? ";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, ano.getId_de_busca()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				int mes = rs.getInt("mes_sessao") - 1;
				mesesDoAno.get(mes).setValor(mesesDoAno.get(mes).getValor() + rs.getInt("quantidade_sessoes"));
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
