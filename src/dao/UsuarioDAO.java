package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import model.Usuario;
import control.FabricaDeConexao;


public class UsuarioDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Usuario VerificaLoginDeAcessoRetornaUsuario(Usuario usuario) throws ServletException, SQLException{
		try {	
			conn = new FabricaDeConexao().getConnection();
			String sql = "select * from tb_usuarios where login_usuario = ? "
					+ "and senha_usuario = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getLogin_usuario()); 
			ps.setString(2, usuario.getSenha_usuario()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				//usuario.setLogin_usuario(request.getParameter("login"));
				//usuario.setSenha_usuario(request.getParameter("senha"));
				//usuario.setEmail_usuario(request.getParameter("email"));
				//usuario.setData_nascimento_usuario(request.getParameter("data_nascimento"));
				//usuario.setPergunta_secreta_usuario(request.getParameter("pergunta_secreta"));
				//usuario.setResposta_pergunta_secreta(request.getParameter("resposta_pergunta_secreta"));
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
	
	
	public ArrayList<Usuario> RetornaTudo(Usuario usuario) throws ServletException, SQLException{
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
	}
}
