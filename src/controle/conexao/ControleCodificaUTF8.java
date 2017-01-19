package controle.conexao;

import java.io.UnsupportedEncodingException;

import modelos.Ano;
import modelos.Assinatura;
import modelos.TipoDeProduto;
import modelos.Usuario;

public class ControleCodificaUTF8 {

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
	
	public Assinatura CodificaAssinaturaUTF8(Assinatura assinatura) throws UnsupportedEncodingException{
		if(assinatura.getTipo_assinatura() != null)
			assinatura.setTipo_assinatura(CodificaStringUTF8(assinatura.getTipo_assinatura()));
		if(assinatura.getData_inicial_assinatura() != null)
			assinatura.setData_inicial_assinatura(CodificaStringUTF8(assinatura.getData_inicial_assinatura()));
		if(assinatura.getData_final_assinatura() != null)
			assinatura.setData_final_assinatura(CodificaStringUTF8(assinatura.getData_final_assinatura()));
		if(assinatura.getData_bloqueio_assinatura() != null)
			assinatura.setData_bloqueio_assinatura(CodificaStringUTF8(assinatura.getData_bloqueio_assinatura()));
		
		return assinatura;
	}
	
	public TipoDeProduto CodificaTipoProdutoUTF8(TipoDeProduto tipoDeProduto) throws UnsupportedEncodingException{
		if(tipoDeProduto.getTipo_produto() != null)
			tipoDeProduto.setTipo_produto(CodificaStringUTF8(tipoDeProduto.getTipo_produto()));	
		
		return tipoDeProduto;
	}
	
	public String CodificaStringUTF8(String string) throws UnsupportedEncodingException{
		return new String(string.getBytes("UTF-8"), "ISO-8859-1");
	}
}
