package controle.auxiliares;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import controle.modelos.ControleTratamentoMesAno;

public class DataControle {

	public String RetornaDataHoraAtualRepresentacaoNumerica(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}
	
	public String RetornaDiaAtualRepresentacaoNumerica(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date).substring(0,2); 
	}
	
	public String RetornaMesAtualRepresentacaoNumerica(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date).substring(3,5); 
	}
	
	public String RetornaAnoAtualRepresentacaoNumerica(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date).substring(6,10); 
	}
	
}
