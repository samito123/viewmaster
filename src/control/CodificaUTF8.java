package control;

import java.io.UnsupportedEncodingException;

import model.Ano;
import model.Usuario;

public class CodificaUTF8 {

	public Usuario CodificaUsuarioUTF8(Usuario usuario) throws UnsupportedEncodingException{
		if(usuario.getNome_usuario() != null)
			usuario.setNome_usuario(CodificaStringUTF8(usuario.getNome_usuario()));	
		if(usuario.getLogin_usuario() != null)
			usuario.setLogin_usuario(CodificaStringUTF8(usuario.getLogin_usuario()));		
		if(usuario.getSenha_usuario() != null)
			usuario.setSenha_usuario(CodificaStringUTF8(usuario.getSenha_usuario()));
		if(usuario.getEmail_usuario() != null)
			usuario.setEmail_usuario(CodificaStringUTF8(usuario.getEmail_usuario()));
		if(usuario.getData_nascimento_usuario() != null)
			usuario.setData_nascimento_usuario(CodificaStringUTF8(usuario.getData_nascimento_usuario()));
		if(usuario.getPergunta_secreta_usuario() != null)
			usuario.setPergunta_secreta_usuario(CodificaStringUTF8(usuario.getPergunta_secreta_usuario()));
		if(usuario.getResposta_pergunta_secreta_usuario() != null)
			usuario.setResposta_pergunta_secreta_usuario(CodificaStringUTF8(usuario.getResposta_pergunta_secreta_usuario()));
		return usuario;
	}
	
	public Ano CodificaAnoUTF8(Ano ano) throws UnsupportedEncodingException{
		if(ano.getNumero_do_ano() != null)
			ano.setNumero_do_ano(CodificaStringUTF8(ano.getNumero_do_ano()));	
		if(ano.getMeses_do_ano() != null)
			for(int mesDoAno = 0; mesDoAno < 12; mesDoAno++){
				ano.getMeses_do_ano().get(mesDoAno).setNome_do_mes(
						CodificaStringUTF8(ano.getMeses_do_ano().get(mesDoAno).getNome_do_mes()));		
			}
		return ano;
	}
	
	private String CodificaStringUTF8(String string) throws UnsupportedEncodingException{
		return new String(string.getBytes("UTF-8"), "ISO-8859-1");
	}
}
