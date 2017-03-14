package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import modelos.Sessao;
import modelos.Usuario;
import controle.auxiliares.DataControle;
import controle.conexao.ControleFabricaDeConexao;
import controle.modelos.ControleTratamentoMesAno;


public class SessoesDeUsuarioDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public SessoesDeUsuarioDAO(Connection conn){
		this.conn = conn;
	}
	
	public int AtualizaSessaoUsuario(Sessao usuario) throws SQLException {
		int transacaoRealizada = 0;
		try{	
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
			conn.rollback();
			conn.close();
			System.out.println("Erro: AtualizaSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		return transacaoRealizada;
	}
	
	public int InsereSessaoUsuario(Sessao usuario) throws SQLException {
		PreparedStatement ps = null;
		int transacaoRealizada = 0;
		try{
				
			String sql = "insert into tb_sessoes_usuario " 
					+ "(id_usuario, mes_sessao, ano_sessao, quantidade_sessoes) "
					+ "values (?,?,?,?)"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, new DataControle().RetornaMesAtualRepresentacaoNumerica()); 
			ps.setString(3, new DataControle().RetornaAnoAtualRepresentacaoNumerica()); 
			ps.setInt(4, 1); 
			transacaoRealizada = ps.executeUpdate();
		}catch(Exception e){
			conn.rollback();
			conn.close();
			System.out.println("Erro: InsereSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		return transacaoRealizada;
	}
	
	/*public int InsereSessaoUsuario(Sessao usuario) throws SQLException {
		PreparedStatement ps = null;
		int transacaoRealizada = 0;
		try{
			
			String mesAtual = new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH));
			String anoAtual = ""+Calendar.getInstance().get(Calendar.YEAR); 
				
			String sql = "insert into tb_ultima_sessao_usuario " 
					+ "(id_usuario, data_hora_sessao) "
					+ "values (?, ?)"; 
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, usuario.getId_usuario()); 
			ps.setString(2, new DataControle().RetornaDataAtual()); 
			transacaoRealizada = ps.executeUpdate();
		}catch(Exception e){
			System.out.println("Erro: InsereSessaoUsuario, "+e);
		}finally{
			ps.close();	
		}
		return transacaoRealizada;
	}*/
	
	/*public Long VerificaSeSessaoDoUsuarioExiste(Usuario usuario) throws Exception{
		
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
			throw new Exception("Erro: VerificaSeSessaoDoUsuarioExiste, "+e);
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
	}*/
	
}
