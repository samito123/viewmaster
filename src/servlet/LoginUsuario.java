package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UsuarioDAO;
import model.Usuario;


public class LoginUsuario extends HttpServlet{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Usuario usuario;
	ArrayList<Usuario> usuarios;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		request = req;
		response = resp;
		usuario = CriaObjetoUsuarioRequest();
		
		String metodo = request.getParameter("metodo");
		switch (metodo) {
			case "VerificaLoginDoUsuario":	
				try {
					RecuperaUsuarioViaLogin();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
		}
	}
	
	private Usuario CriaObjetoUsuarioRequest(){
		Usuario usuarioRequest = new Usuario();
		usuarioRequest.setNome_usuario(request.getParameter("nome"));
		usuarioRequest.setLogin_usuario(request.getParameter("login"));
		usuarioRequest.setSenha_usuario(request.getParameter("senha"));
		usuarioRequest.setEmail_usuario(request.getParameter("email"));
		usuarioRequest.setData_nascimento_usuario(request.getParameter("data_nascimento"));
		usuarioRequest.setPergunta_secreta_usuario(request.getParameter("pergunta_secreta"));
		usuarioRequest.setResposta_pergunta_secreta(request.getParameter("resposta_pergunta_secreta"));
		
		return usuarioRequest;
	}
	
	private void RecuperaUsuarioViaLogin() throws ServletException, SQLException, IOException{
		UsuarioDAO dao = new UsuarioDAO();
		//usuario = dao.VerificaLoginDeAcesso(usuario);
		//VerificaRetornoUsuario();
		
		ArrayList<Usuario> usuarios = dao.RetornaTudo(usuario);
		Gson gson = new Gson();
		//System.out.print(gson.toJson(usuario));
		//gson.
	
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(usuarios)); 
	}
	
	private void VerificaRetornoUsuario() throws IOException{
		if(usuario.getNome_usuario() == null){
			RetornaErro();
		}else{
			RetornaUsuarioRecuperadoViaLogin();
		}
	}
	
	private void RetornaErro() throws IOException{
		PrintWriter out = response.getWriter();
		out.write("N"); 
	}
	
	private void RetornaUsuarioRecuperadoViaLogin() throws IOException{
		Gson gson = new Gson();
		//System.out.print(gson.toJson(usuario));
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(usuario)); 
	}
}
