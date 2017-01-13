package controle.modelos;

import java.util.ArrayList;

import modelos.Modulo;

public class ControleTratamentoModulo {
	
	public ArrayList<Modulo> ConstroiArrayDeModulos(){
		ArrayList<Modulo> modulos = new ArrayList<>();
		
		for(int modulo = 1; modulo < 8; modulo++){
			modulos.add(FormaModuloEspecificado(modulo));
		}
		return modulos;
	}
	
	private Modulo FormaModuloEspecificado(int valorModulo){
		Modulo modulo = new Modulo();
		
		switch (valorModulo) {
			case 1:
				modulo.setNome_modulo("Agenda");
			break;

			case 2:
				modulo.setNome_modulo("Clientes");
			break;
			
			case 3:
				modulo.setNome_modulo("Receitas");
			break;
			
			case 4:
				modulo.setNome_modulo("Produtos");
			break;
			
			case 5:
				modulo.setNome_modulo("Estoque");
			break;
			
			case 6:
				modulo.setNome_modulo("Vendas");
			break;
			
			case 7:
				modulo.setNome_modulo("Contas");
			break;
		}
		
		return modulo;
	}
	
}
