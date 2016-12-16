package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UsuarioDAO;
import model.Usuario;

public class RecuperaSenha extends HttpServlet{
	
	static private HttpServletRequest request;
	static private HttpServletResponse response;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		request = req;
		response = resp;
		
		String metodo = request.getParameter("metodo");
	
		switch (metodo) {
			case "VerificacaoEmailDataDeNascimento":	
				try {
					VerificaEmailDataNascimentoRecuperaUsuarioOuEnviaMensagemDeErro(CriaObjetoUsuarioRequest());
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
		usuarioRequest.setData_nascimento_usuario(request.getParameter("data_nascimento").replaceAll("-", "/"));
		usuarioRequest.setPergunta_secreta_usuario(request.getParameter("pergunta_secreta"));
		usuarioRequest.setResposta_pergunta_secreta(request.getParameter("resposta_pergunta_secreta"));
		
		return usuarioRequest;
	}
	
	private void VerificaEmailDataNascimentoRecuperaUsuarioOuEnviaMensagemDeErro(Usuario usuario) 
			throws IOException, ServletException, SQLException{
		
		UsuarioDAO dao = new UsuarioDAO();
		usuario = dao.VerificaEmailDataNascimentoRecuperaSenhaRetornaUsuario(usuario);
		VerificaRetornoDeUsuarioParaRecuperacaoDeSenha(usuario);
	}

	private void VerificaRetornoDeUsuarioParaRecuperacaoDeSenha(Usuario usuario) throws IOException{
		if(usuario.getNome_usuario() == null){
			RetornaErroEmailOuDataDeNascimentoIncorreto();
		}else{
			RetornaUsuarioJsonRecuperadoViaEmailDataDeNascimento(usuario);
		}
	}
	
	private void RetornaErroEmailOuDataDeNascimentoIncorreto() throws IOException{
		PrintWriter out = response.getWriter();
		out.write("erro"); 
	}
	
	private void RetornaUsuarioJsonRecuperadoViaEmailDataDeNascimento(Usuario usuario) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(usuario)); 
	}
}
