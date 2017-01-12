package controle.modelos;

import java.util.ArrayList;

import modelos.Mes;

public class ControleTratamentoMesAno {
	
	public String TrataMesCalendario(int mes){
		String mesTratado = "";
		
		switch (mes) {
			case 0:
				mesTratado = "01";
			break;
	
			case 1:
				mesTratado = "02";
			break;
			
			case 2:
				mesTratado = "03";
			break;
			
			case 3:
				mesTratado = "04";
			break;
			
			case 4:
				mesTratado = "05";
			break;
			
			case 5:
				mesTratado = "06";
			break;
			
			case 6:
				mesTratado = "07";
			break;
			
			case 7:
				mesTratado = "08";
			break;
			
			case 8:
				mesTratado = "09";
			break;
			
			case 9:
				mesTratado = "10";
			break;
			
			case 10:
				mesTratado = "11";
			break;
			
			case 11:
				mesTratado = "12";
			break;
		}
		
		return mesTratado;
	}
	
	public ArrayList<Mes> ConstroiMesesDoAno(){
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
				mes.setNome_do_mes("Mar�o");
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
