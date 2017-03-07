package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


import modelos.Sessao;
import controle.modelos.ControleTratamentoMesAno;

public class UsuarioDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UsuarioDAO(Connection conn){
		this.conn = conn;
	}

	public Sessao BuscaUsuarioLogin(String login, String senha) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sessao usuario = null;
		try{
			String mesAtual = new ControleTratamentoMesAno().TrataMesCalendario(Calendar.getInstance().get(Calendar.MONTH));
			String anoAtual = ""+Calendar.getInstance().get(Calendar.YEAR); 
				
			String sql = "select id_usuario, nome_usuario, login_usuario, "
					+ "(select s.quantidade_sessoes "
					+ "from tb_usuarios as u "
					+ "left join tb_sessoes_usuario as s "
					+ "on u.id_usuario = s.id_usuario "
					+ "where login_usuario = ? "
					+ "and senha_usuario = ? "
					+ "and mes_sessao = ? "
					+ "and ano_sessao = ?) "
					+ "as quantidade_sessoes, "
					+ "(select us.data_hora_sessao "
					+ "from tb_usuarios as u "
					+ "left join tb_ultima_sessao_usuario as us "
					+ "on u.id_usuario = us.id_usuario "
					+ "where login_usuario = ?"
					+ "and senha_usuario = ?) "
					+ "as data_hora_sessao "				
					+ "from tb_usuarios "
					+ "where login_usuario = ? "
					+ "and senha_usuario = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, login); 
			ps.setString(2, senha); 
			ps.setString(3, mesAtual); 
			ps.setString(4, anoAtual); 
			ps.setString(5, login); 
			ps.setString(6, senha); 
			ps.setString(7, login); 
			ps.setString(8, senha);
			rs = ps.executeQuery(); 

			while (rs.next()) {
				usuario = new Sessao();
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setQuantidade_de_sessoes(rs.getInt(("quantidade_sessoes")));
			}
		}catch(Exception e){
			System.out.println("Erro: BuscaUsuarioLogin, "+e);
		}finally{
			rs.close();
			ps.close();
		}
		return usuario;
	} 
	
	/*public Usuario VerificaLoginDeAcessoRetornaUsuario(Usuario usuario) throws Exception{
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_usuarios where login_usuario = ? "
					+ "and senha_usuario = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getLogin_usuario()); 
			ps.setString(2, usuario.getSenha_usuario()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setSenha_usuario(rs.getString("senha_usuario"));
				usuario.setEmail_usuario(rs.getString("email_usuario"));
				usuario.setData_nascimento_usuario(rs.getString("data_nascimento_usuario"));
				usuario.setPergunta_secreta_usuario(rs.getString("pergunta_secreta_usuario"));
				usuario.setResposta_pergunta_secreta_usuario(rs.getString("resposta_pergunta_secreta_usuario"));
			}	
		}catch (Exception e) {
			throw new Exception("Erro: VerificaLoginDeAcessoRetornaUsuario, "+e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return usuario;
	}
	
	public Usuario VerificaEmailDataNascimentoRecuperaSenhaRetornaUsuario(Usuario usuario) throws SQLException{
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_usuarios where email_usuario = ? "
					+ "and data_nascimento_usuario = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getEmail_usuario()); 
			ps.setString(2, usuario.getData_nascimento_usuario()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setLogin_usuario(rs.getString("login_usuario"));
				usuario.setEmail_usuario(rs.getString("email_usuario"));
				usuario.setData_nascimento_usuario(rs.getString("data_nascimento_usuario"));
				usuario.setPergunta_secreta_usuario(rs.getString("pergunta_secreta_usuario"));
				usuario.setResposta_pergunta_secreta_usuario(rs.getString("resposta_pergunta_secreta_usuario"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return usuario;
	}
	
	public boolean AlteraSenhaUsuario(Usuario usuario) throws SQLException{
		boolean executouSQL = false;
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "update tb_usuarios "
					+ "set senha_usuario = ? "
					+ "where id_usuario = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getSenha_usuario()); 
			ps.setLong(2, usuario.getId_usuario()); 
			ps.execute(); 
			executouSQL = true;
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			ps.close();
			conn.close();
		}
		return executouSQL;
	}*/
	
	/*public ArrayList<Usuario> RetornaTudo(Usuario usuario) throws ServletException, SQLException{
		ArrayList<Usuario> usuarios = new ArrayList<>();
		try {	
			conn = new FabricaDeConexao().getConnection();
			String sql = "select * from tb_usuarios";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				Usuario a = new Usuario();
				a.setId_usuario(rs.getLong("id_usuario"));
				System.out.print(rs.getString("nome_usuario")+"-");
				a.setNome_usuario(rs.getString("nome_usuario"));
				//usuario.setLogin_usuario(request.getParameter("login"));
				//usuario.setSenha_usuario(request.getParameter("senha"));
				//usuario.setEmail_usuario(request.getParameter("email"));
				//usuario.setData_nascimento_usuario(request.getParameter("data_nascimento"));
				//usuario.setPergunta_secreta_usuario(request.getParameter("pergunta_secreta"));
				//usuario.setResposta_pergunta_secreta(request.getParameter("resposta_pergunta_secreta"));
				usuarios.add(a);
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return usuarios;
	}*/
}
