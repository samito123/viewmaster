package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sessao extends Usuario{
	
	private long id_sessao;
	private String dia_sessao;
	private String mes_sessao;
	private String ano_sessao;
	private int quantidade_de_sessoes;
	private String data_hora_sessao;
	
	public long getId_sessao() {
		return id_sessao;
	}
	public void setId_sessao(long id_sessao) {
		this.id_sessao = id_sessao;
	}
	public String getDia_sessao() {
		return dia_sessao;
	}
	public void setDia_sessao(String dia_sessao) {
		this.dia_sessao = dia_sessao;
	}
	public String getMes_sessao() {
		return mes_sessao;
	}
	public void setMes_sessao(String mes_sessao) {
		this.mes_sessao = mes_sessao;
	}
	public String getAno_sessao() {
		return ano_sessao;
	}
	public void setAno_sessao(String ano_sessao) {
		this.ano_sessao = ano_sessao;
	}
	public int getQuantidade_de_sessoes() {
		return quantidade_de_sessoes;
	}
	public void setQuantidade_de_sessoes(int quantidade_de_sessoes) {
		this.quantidade_de_sessoes = quantidade_de_sessoes;
	}
	public String getData_hora_sessao() {
		return data_hora_sessao;
	}
	public void setData_hora_sessao(String data_hora_sessao) {
		this.data_hora_sessao = data_hora_sessao;
	}
	
}
