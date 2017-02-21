package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.Usuario;
import controle.conexao.ControleFabricaDeConexao;


public class UsuarioDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Usuario VerificaLoginDeAcessoRetornaUsuario(Usuario usuario) throws Exception{
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
	}
	
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
