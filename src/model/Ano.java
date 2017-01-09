package model;

import java.util.ArrayList;

public class Ano {
	
	private Long id_de_busca;
	private String nome_do_ano;
	private ArrayList<Mes> meses_do_ano;
	
	public Ano(){
		Ano ano = new Ano();
		ano.setMeses_do_ano(ConstroiMesesDoAno());
	}
	
	public Long getId_de_busca() {
		return id_de_busca;
	}
	public void setId_de_busca(Long id_de_busca) {
		this.id_de_busca = id_de_busca;
	}
	public String getNome_do_ano() {
		return nome_do_ano;
	}
	public void setNome_do_ano(String nome_do_ano) {
		this.nome_do_ano = nome_do_ano;
	}
	public ArrayList<Mes> getMeses_do_ano() {
		return meses_do_ano;
	}
	public void setMeses_do_ano(ArrayList<Mes> meses_do_ano) {
		this.meses_do_ano = meses_do_ano;
	}

	private ArrayList<Mes> ConstroiMesesDoAno(){
		ArrayList<Mes> mesesDoAno = new ArrayList<>();
		
		for(int mesDoAno = 1; mesDoAno < 13; mesDoAno++){
			mesesDoAno.add(MesDoAno(mesDoAno));
		}
		return mesesDoAno;
	}
	
	private Mes MesDoAno(int mesDoAno){
		Mes mes = new Mes();
		
		switch (mesDoAno) {
			case 1:
				mes.setNome_do_mes("Janeiro");
				mes.setNumero_do_mes("01");
			break;

			case 2:
				mes.setNome_do_mes("Fevereiro");
				mes.setNumero_do_mes("02");
			break;
			
			case 3:
				mes.setNome_do_mes("Março");
				mes.setNumero_do_mes("03");
			break;
			
			case 4:
				mes.setNome_do_mes("Abril");
				mes.setNumero_do_mes("04");
			break;
			
			case 5:
				mes.setNome_do_mes("Maio");
				mes.setNumero_do_mes("05");
			break;
			
			case 6:
				mes.setNome_do_mes("Junho");
				mes.setNumero_do_mes("06");
			break;
			
			case 7:
				mes.setNome_do_mes("Julho");
				mes.setNumero_do_mes("07");
			break;
			
			case 8:
				mes.setNome_do_mes("Agosto");
				mes.setNumero_do_mes("08");
			break;
			
			case 9:
				mes.setNome_do_mes("Setembro");
				mes.setNumero_do_mes("09");
			break;
			
			case 10:
				mes.setNome_do_mes("Outubro");
				mes.setNumero_do_mes("10");
			break;
			
			case 11:
				mes.setNome_do_mes("Novembro");
				mes.setNumero_do_mes("11");
			break;
			
			case 12:
				mes.setNome_do_mes("Dezembro");
				mes.setNumero_do_mes("12");
			break;
		}
		
		return mes;
	}
	
}
