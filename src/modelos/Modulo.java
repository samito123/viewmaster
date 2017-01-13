package modelos;

import controle.modelos.ControleTratamentoMesAno;

public class Modulo {

	private String nome_modulo;
	private Ano ano;
	
	public Modulo(){
		this.ano = new Ano();
	}
	
	public String getNome_modulo() {
		return nome_modulo;
	}
	public void setNome_modulo(String nome_modulo) {
		this.nome_modulo = nome_modulo;
	}
	public Ano getAno() {
		return ano;
	}
	public void setAno(Ano ano) {
		this.ano = ano;
	}
	
}
