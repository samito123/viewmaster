package modelos;

import java.util.ArrayList;

import controle.modelos.ControleTratamentoMesAno;

public class Ano {
	
	private Long id_de_busca;
	private String numero_do_ano;
	private int valor;
	private ArrayList<Mes> meses_do_ano;
	
	public Ano(){
		this.setMeses_do_ano(new ControleTratamentoMesAno().ConstroiMesesDoAno());
	}

	public Long getId_de_busca() {
		//aaa
		/*aaa*/
		
		return id_de_busca;
	}
	public void setId_de_busca(Long id_de_busca) {
		this.id_de_busca = id_de_busca;
	}
	
	public String getNumero_do_ano() {
		return numero_do_ano;
	}

	public void setNumero_do_ano(String numero_do_ano) {
		this.numero_do_ano = numero_do_ano;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public ArrayList<Mes> getMeses_do_ano() {
		return meses_do_ano;
	}
	public void setMeses_do_ano(ArrayList<Mes> meses_do_ano) {
		this.meses_do_ano = meses_do_ano;
	}
	
	
}
