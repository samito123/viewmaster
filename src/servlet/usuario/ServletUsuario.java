package servlet.usuario;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.conexao.ControleDeRetornoServidor;
import controle.servlet.ServletControleLoginDeUsuario;
import modelos.Usuario;


public class ServletUsuario extends HttpServlet{
	
	static private HttpServletRequest request;
	static private HttpServletResponse response;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.request = req;
		this.response = resp;
		
		try{
			String metodo = request.getParameter("metodo");
			switch (metodo) {
			case "VerificaLoginDoUsuario":	
				ChamaVerificacaoDeLoginDoUsuario();
					//new ServletControleLoginDeUsuario(req, resp).
						//VerificaLoginRecuperaUsuarioOuEnviaMensagemDeErro(CriaObjetoUsuarioRequest());
				break;
				
				default:
					new ControleDeRetornoServidor(request, response).RetornaErro();
					break;
			}
		}catch(Exception e){
			new ControleDeRetornoServidor(request, response).RetornaErro();
			System.out.println(e);
		}
	}
	
	private void ChamaVerificacaoDeLoginDoUsuario(){
		
	}

	/*private Usuario CriaObjetoUsuarioRequest(){
		Usuario usuario = new Usuario();
		if(request.getParameter("id") != null)
			usuario.setId_usuario(Long.parseLong(request.getParameter("id")));
		if(request.getParameter("nome") != null)
			usuario.setNome_usuario(request.getParameter("nome"));	
		if(request.getParameter("login") != null)
			usuario.setLogin_usuario(request.getParameter("login"));		
		if(request.getParameter("senha") != null)
			usuario.setSenha_usuario(request.getParameter("senha"));
		if(request.getParameter("email") != null)
			usuario.setEmail_usuario(request.getParameter("email"));
		if(request.getParameter("data_nascimento") != null)
			usuario.setData_nascimento_usuario(request.getParameter("data_nascimento").replaceAll("-", "/"));
		if(request.getParameter("pergunta_secreta") != null)
			usuario.setPergunta_secreta_usuario(request.getParameter("pergunta_secreta"));
		if(request.getParameter("resposta_pergunta_secreta") != null)
			usuario.setResposta_pergunta_secreta_usuario(request.getParameter("resposta_pergunta_secreta"));
		
		return usuario;
	}*/
	
}
