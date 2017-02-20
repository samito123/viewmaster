package servlet.controle.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Usuario;

import com.google.gson.Gson;

import controle.conexao.ControleCodificaUTF8;
import controle.conexao.ControleDeRetornoServidor;
import dao.UsuarioDAO;

public class ControleVerificacaoEmailDataNacimento {

	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public ControleVerificacaoEmailDataNacimento(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void VerificaEmailDataNascimentoRecuperaUsuarioOuEnviaMensagemDeErro(Usuario usuario) 
			throws IOException, ServletException, SQLException{
		
		UsuarioDAO dao = new UsuarioDAO();
		usuario = dao.VerificaEmailDataNascimentoRecuperaSenhaRetornaUsuario(usuario);
		VerificaRetornoDeUsuarioParaRecuperacaoDeSenha(usuario);
	}

	private void VerificaRetornoDeUsuarioParaRecuperacaoDeSenha(Usuario usuario) throws IOException{
		if(usuario.getNome_usuario() == null){
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}else{
			RetornaUsuarioJsonRecuperadoViaEmailDataDeNascimento(usuario);
		}
	}
	
	private void RetornaUsuarioJsonRecuperadoViaEmailDataDeNascimento(Usuario usuario) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(new ControleCodificaUTF8().CodificaUsuarioUTF8(usuario)));
	}
}
