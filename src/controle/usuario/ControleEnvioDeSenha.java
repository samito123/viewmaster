package controle.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Email;
import modelos.Usuario;
import controle.conexao.ControleCodificaUTF8;
import controle.conexao.ControleDeRetornoServidor;
import dao.UsuarioDAO;

public class ControleEnvioDeSenha {

	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public ControleEnvioDeSenha(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void GerarNovaSenha(int emailOuPergunta, Usuario usuario) throws IOException, ServletException, SQLException{
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
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void AlterarSenhaUsuarioEmail(Usuario usuario) throws ServletException, SQLException, IOException{
		try {
			UsuarioDAO dao = new UsuarioDAO();
			boolean executouSQL = dao.AlteraSenhaUsuario(usuario);
			TrataErroAlterarSenhaEmailBancoDeDados(executouSQL);
		} catch (Exception e) {
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void TrataErroAlterarSenhaEmailBancoDeDados(boolean executouSQL) throws IOException{
		if(executouSQL == true){
			new ControleDeRetornoServidor(request, response).RetornaSucesso();
		}else{
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void EnviarNovaSenhaPorPerguntaSecreta(Usuario usuario) throws IOException{
		try {
			AlterarSenhaUsuarioPerguntaSecreta(usuario);
		} catch (Exception e) {
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void AlterarSenhaUsuarioPerguntaSecreta(Usuario usuario) throws ServletException, SQLException, IOException{
		try {
			UsuarioDAO dao = new UsuarioDAO();
			boolean executouSQL = dao.AlteraSenhaUsuario(usuario);
			TrataErroAlterarSenhaPerguntaSecretaBancoDeDados(executouSQL, usuario.getSenha_usuario());
		} catch (Exception e) {
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void TrataErroAlterarSenhaPerguntaSecretaBancoDeDados(boolean executouSQL, String novaSenha) throws IOException{
		if(executouSQL == true){
			RetornaNovaSenhaUsuario(novaSenha);
		}else{
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void RetornaNovaSenhaUsuario(String novaSenha) throws IOException{
		PrintWriter out = response.getWriter();
		out.write(new ControleCodificaUTF8().CodificaStringUTF8(novaSenha));
	}
}
