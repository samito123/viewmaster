package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sessao extends Usuario{
	
	private long id_sessao;
	private int dia_sessao;
	private int mes_sessao;
	private int ano_sessao;
	private int quantidade_de_sessoes;
	
	public long getId_sessao() {
		return id_sessao;
	}
	public void setId_sessao(long id_sessao) {
		this.id_sessao = id_sessao;
	}
	public int getDia_sessao() {
		return dia_sessao;
	}
	public void setDia_sessao(int dia_sessao) {
		this.dia_sessao = dia_sessao;
	}
	public int getMes_sessao() {
		return mes_sessao;
	}
	public void setMes_sessao(int mes_sessao) {
		this.mes_sessao = mes_sessao;
	}
	public int getAno_sessao() {
		return ano_sessao;
	}
	public void setAno_sessao(int ano_sessao) {
		this.ano_sessao = ano_sessao;
	}
	public int getQuantidade_de_sessoes() {
		return quantidade_de_sessoes;
	}
	public void setQuantidade_de_sessoes(int quantidade_de_sessoes) {
		this.quantidade_de_sessoes = quantidade_de_sessoes;
	}
	
}
