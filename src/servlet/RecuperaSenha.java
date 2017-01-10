package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;

import com.google.gson.Gson;

import control.CodificaUTF8;
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
				try {
					GerarNovaSenha(0, CriaObjetoUsuarioRequest());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
				
			case "EnviarNovaSenhaPorPerguntaSecreta":	
				try {
					GerarNovaSenha(1, CriaObjetoUsuarioRequest());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			break;
		}
	}
	
	private Usuario CriaObjetoUsuarioRequest(){
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
	}
	
	private void VerificaEmailDataNascimentoRecuperaUsuarioOuEnviaMensagemDeErro(Usuario usuario) 
			throws IOException, ServletException, SQLException{
		
		UsuarioDAO dao = new UsuarioDAO();
		usuario = dao.VerificaEmailDataNascimentoRecuperaSenhaRetornaUsuario(usuario);
		VerificaRetornoDeUsuarioParaRecuperacaoDeSenha(usuario);
	}

	private void VerificaRetornoDeUsuarioParaRecuperacaoDeSenha(Usuario usuario) throws IOException{
		if(usuario.getNome_usuario() == null){
			RetornaErroRecuperacaoSenha();
		}else{
			RetornaUsuarioJsonRecuperadoViaEmailDataDeNascimento(usuario);
		}
	}
	
	private void RetornaSucessoRecuperacaoSenha() throws IOException{
		PrintWriter out = response.getWriter();
		out.write("sucesso"); 
	}
	
	private void RetornaErroRecuperacaoSenha() throws IOException{
		PrintWriter out = response.getWriter();
		out.write("erro"); 
	}
	
	private void RetornaUsuarioJsonRecuperadoViaEmailDataDeNascimento(Usuario usuario) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(new CodificaUTF8().CodificaUsuarioUTF8(usuario)));
	}
	
	private String CodificaStringUTF8(String string) throws UnsupportedEncodingException{
		return new String(string.getBytes("UTF-8"), "ISO-8859-1");
	}
	
	private void GerarNovaSenha(int emailOuPergunta, Usuario usuario) throws IOException, ServletException, SQLException{
		int qtdeMaximaCaracteres = 8;
        String[] caracteres = { "a", "1", "b", "2", "4", "5", "6", "7", "8",
                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
                "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z" };
       
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < qtdeMaximaCaracteres; i++) {
            int posicao = (int) (Math.random() * caracteres.length);
            senha.append(caracteres[posicao]);
        }
        usuario.setSenha_usuario(senha.toString());
        EnviarNovaSenha(emailOuPergunta, usuario);
	}
	
	private void EnviarNovaSenha(int emailOuPergunta, Usuario usuario) throws IOException, ServletException, SQLException{
		if(emailOuPergunta == 0){
			EnviarNovaSenhaPorEmail(usuario);
		}else{
			EnviarNovaSenhaPorPerguntaSecreta(usuario);
		}
	}
	
	private void EnviarNovaSenhaPorEmail(Usuario usuario) throws IOException, ServletException, SQLException{
		Email email = new Email();
		
		try {
			email.EnviarEmail(usuario);
			AlterarSenhaUsuarioEmail(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			RetornaErroRecuperacaoSenha();
		}
	}
	
	private void AlterarSenhaUsuarioEmail(Usuario usuario) throws ServletException, SQLException, IOException{
		try {
			UsuarioDAO dao = new UsuarioDAO();
			boolean executouSQL = dao.AlteraSenhaUsuario(usuario);
			TrataErroAlterarSenhaEmailBancoDeDados(executouSQL);
		} catch (Exception e) {
			RetornaErroRecuperacaoSenha();
		}
	}
	
	private void TrataErroAlterarSenhaEmailBancoDeDados(boolean executouSQL) throws IOException{
		if(executouSQL == true){
			RetornaSucessoRecuperacaoSenha();
		}else{
			RetornaErroRecuperacaoSenha();
		}
	}
	
	private void EnviarNovaSenhaPorPerguntaSecreta(Usuario usuario) throws IOException{
		try {
			AlterarSenhaUsuarioPerguntaSecreta(usuario);
		} catch (Exception e) {
			RetornaErroRecuperacaoSenha();
		}
	}
	
	private void AlterarSenhaUsuarioPerguntaSecreta(Usuario usuario) throws ServletException, SQLException, IOException{
		try {
			UsuarioDAO dao = new UsuarioDAO();
			boolean executouSQL = dao.AlteraSenhaUsuario(usuario);
			TrataErroAlterarSenhaPerguntaSecretaBancoDeDados(executouSQL, usuario.getSenha_usuario());
		} catch (Exception e) {
			RetornaErroRecuperacaoSenha();
		}
	}
	
	private void TrataErroAlterarSenhaPerguntaSecretaBancoDeDados(boolean executouSQL, String novaSenha) throws IOException{
		if(executouSQL == true){
			RetornaNovaSenhaUsuario(novaSenha);
		}else{
			RetornaErroRecuperacaoSenha();
		}
	}
	
	private void RetornaNovaSenhaUsuario(String novaSenha) throws IOException{
		PrintWriter out = response.getWriter();
		out.write(CodificaStringUTF8(novaSenha));
	}
	
}
