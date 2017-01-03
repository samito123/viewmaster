package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;

import com.google.gson.Gson;

import dao.UsuarioDAO;
import model.Email;
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
			
			case "EnviarNovaSenhaPorEmail":	
				EnviarNovaSenhaPorEmail(CriaObjetoUsuarioRequest());
			break;
		}
	}
	
	private Usuario CriaObjetoUsuarioRequest(){
		Usuario usuario = new Usuario();
		if(request.getParameter("id") != null)
		usuario.setId_usuario(Long.parseLong(request.getParameter("id")));
		usuario.setNome_usuario(request.getParameter("nome"));	
		usuario.setLogin_usuario(request.getParameter("login"));		
		usuario.setSenha_usuario(request.getParameter("senha"));
		usuario.setEmail_usuario(request.getParameter("email"));
		if(request.getParameter("data_nascimento") != null)
		usuario.setData_nascimento_usuario(request.getParameter("data_nascimento").replaceAll("-", "/"));
		usuario.setPergunta_secreta_usuario(request.getParameter("pergunta_secreta"));
		usuario.setResposta_pergunta_secreta(request.getParameter("resposta_pergunta_secreta"));
		
		return usuario;
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
	
	private void EnviarNovaSenhaPorEmail(Usuario usuario) throws IOException{
		Email email = new Email();
		try {
			email.EnviarEmail(usuario);
			PrintWriter out = response.getWriter();
			out.write("S"+usuario.getId_usuario()); 
		} catch (EmailException e) {
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.write("erro"); 
		}
	}
	
	
}
