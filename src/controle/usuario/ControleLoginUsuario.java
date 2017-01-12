package controle.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Usuario;

import com.google.gson.Gson;

import controle.conexao.ControleDeRetornoServidor;
import dao.SessoesDeUsuarioDAO;
import dao.UltimaSessaoUsuarioDAO;
import dao.UsuarioDAO;

public class ControleLoginUsuario {

	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public ControleLoginUsuario(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void VerificaLoginRecuperaUsuarioOuEnviaMensagemDeErro(Usuario usuario) throws 
		ServletException, SQLException, IOException{
			UsuarioDAO dao = new UsuarioDAO();
			usuario = dao.VerificaLoginDeAcessoRetornaUsuario(usuario);
			VerificaRetornoDeUsuarioParaLogin(usuario);
	}
	
	private void VerificaRetornoDeUsuarioParaLogin(Usuario usuario) throws IOException, SQLException{
		if(usuario.getNome_usuario() == null){
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}else{
			VerificaSeSessaoDoUsuarioExiste(usuario);
		}
	}
	
	private void VerificaSeSessaoDoUsuarioExiste(Usuario usuario) throws SQLException, IOException{
		SessoesDeUsuarioDAO dao = new SessoesDeUsuarioDAO();
		long quantidadeDeSessoes = dao.VerificaSeSessaoDoUsuarioExiste(usuario);
		if(quantidadeDeSessoes > 0){
			UpdateSessaoUsuario(usuario, quantidadeDeSessoes);
		}else{
			SalvarSessaoUsuario(usuario);
		}
	}
	
	private void UpdateSessaoUsuario(Usuario usuario, Long quantidadeDeSessoes) throws SQLException, IOException{
		try{
			SessoesDeUsuarioDAO dao = new SessoesDeUsuarioDAO();
			dao.UpdateSessaoUsuario(usuario, quantidadeDeSessoes);
			VerificarUltimaSessaoUsuario(usuario);
		}catch(Exception e){
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void SalvarSessaoUsuario(Usuario usuario) throws SQLException, IOException{
		try{
			SessoesDeUsuarioDAO dao = new SessoesDeUsuarioDAO();
			dao.SalvarSessaoUsuario(usuario);
			RetornaUsuarioJsonRecuperadoViaLogin(usuario);
		}catch(Exception e){
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void VerificarUltimaSessaoUsuario(Usuario usuario) throws SQLException, IOException{
		UltimaSessaoUsuarioDAO dao =  new UltimaSessaoUsuarioDAO();
		if(dao.VerificaSeUltimaSessaoDoUsuarioExiste(usuario) == true){
			UpdateUltimaSessaoUsuario(usuario);
		}else{
			SalvarUltimaSessaoUsuario(usuario);
		}
	}
	
	private void UpdateUltimaSessaoUsuario(Usuario usuario) throws SQLException, IOException{
		try{
			UltimaSessaoUsuarioDAO dao =  new UltimaSessaoUsuarioDAO();
			dao.UpdateUltimaSessaoUsuario(usuario);
			RetornaUsuarioJsonRecuperadoViaLogin(usuario);
		}catch(Exception e){
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void SalvarUltimaSessaoUsuario(Usuario usuario) throws SQLException, IOException{
		try{
			UltimaSessaoUsuarioDAO dao =  new UltimaSessaoUsuarioDAO();
			dao.SalvarUltimaSessaoUsuario(usuario);
			RetornaUsuarioJsonRecuperadoViaLogin(usuario);
		}catch(Exception e){
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void RetornaUsuarioJsonRecuperadoViaLogin(Usuario usuario) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(usuario)); 
	}
}
