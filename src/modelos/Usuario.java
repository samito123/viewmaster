package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
	
	private long id_usuario;
	private String nome_usuario;
	private String login_usuario;
	private String senha_usuario;
	private String email_usuario;
	private String data_nascimento_usuario;
	private String pergunta_secreta_usuario;
	private String resposta_pergunta_secreta_usuario;
	
	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getLogin_usuario() {
		return login_usuario;
	}
	public void setLogin_usuario(String login_usuario) {
		this.login_usuario = login_usuario;
	}
	public String getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getData_nascimento_usuario() {
		return data_nascimento_usuario;
	}
	public void setData_nascimento_usuario(String data_nascimento_usuario) {
		this.data_nascimento_usuario = data_nascimento_usuario;
	}
	public String getPergunta_secreta_usuario() {
		return pergunta_secreta_usuario;
	}
	public void setPergunta_secreta_usuario(String pergunta_secreta_usuario) {
		this.pergunta_secreta_usuario = pergunta_secreta_usuario;
	}
	public String getResposta_pergunta_secreta_usuario() {
		return resposta_pergunta_secreta_usuario;
	}
	public void setResposta_pergunta_secreta_usuario(
			String resposta_pergunta_secreta_usuario) {
		this.resposta_pergunta_secreta_usuario = resposta_pergunta_secreta_usuario;
	}
}
