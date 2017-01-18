
function ConstroiGraficoDeModulos(modulos) {

	var width = screen.width;
	var qtd_letras_do_mes = 0;
	if (width <= 800){
		qtd_letras_do_mes = 1;
	}else{
		qtd_letras_do_mes = 3;
	}
	
	var GraficoModulos = c3.generate({
	    bindto: '#GraficoModulos',
	    data: {
	        columns: [
	            
	        ],
	        type: 'spline'
	    },axis: {
	        x: {
	            type: 'category',
	            categories: [modulos[0].ano.meses_do_ano[0].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         modulos[0].ano.meses_do_ano[1].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         modulos[0].ano.meses_do_ano[2].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         modulos[0].ano.meses_do_ano[3].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         modulos[0].ano.meses_do_ano[4].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         modulos[0].ano.meses_do_ano[5].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         modulos[0].ano.meses_do_ano[6].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         modulos[0].ano.meses_do_ano[7].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         modulos[0].ano.meses_do_ano[8].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         modulos[0].ano.meses_do_ano[9].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         modulos[0].ano.meses_do_ano[10].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         modulos[0].ano.meses_do_ano[11].nome_do_mes.substring(0, qtd_letras_do_mes)]
	        }
	    }
	});
	setTimeout(function () {
	    GraficoModulos.load({
	        columns: [
	            ['Agenda', modulos[0].ano.meses_do_ano[0].valor, modulos[0].ano.meses_do_ano[1].valor, 
     				modulos[0].ano.meses_do_ano[2].valor, modulos[0].ano.meses_do_ano[3].valor, 
     				modulos[0].ano.meses_do_ano[4].valor, modulos[0].ano.meses_do_ano[5].valor, 
     				modulos[0].ano.meses_do_ano[6].valor, modulos[0].ano.meses_do_ano[7].valor, 
     				modulos[0].ano.meses_do_ano[8].valor, modulos[0].ano.meses_do_ano[9].valor, 
     				modulos[0].ano.meses_do_ano[10].valor, modulos[0].ano.meses_do_ano[11].valor],
	            
     			['Clientes', modulos[1].ano.meses_do_ano[0].valor, modulos[1].ano.meses_do_ano[1].valor, 
	  				modulos[1].ano.meses_do_ano[2].valor, modulos[1].ano.meses_do_ano[3].valor, 
	 				modulos[1].ano.meses_do_ano[4].valor, modulos[1].ano.meses_do_ano[5].valor, 
	 				modulos[1].ano.meses_do_ano[6].valor, modulos[1].ano.meses_do_ano[7].valor, 
	 				modulos[1].ano.meses_do_ano[8].valor, modulos[1].ano.meses_do_ano[9].valor, 
	 				modulos[1].ano.meses_do_ano[10].valor, modulos[1].ano.meses_do_ano[11].valor],        
	            
	 			['Receitas', modulos[2].ano.meses_do_ano[0].valor, modulos[2].ano.meses_do_ano[1].valor, 
	  				modulos[2].ano.meses_do_ano[2].valor, modulos[2].ano.meses_do_ano[3].valor, 
	 				modulos[2].ano.meses_do_ano[4].valor, modulos[2].ano.meses_do_ano[5].valor, 
	 				modulos[2].ano.meses_do_ano[6].valor, modulos[2].ano.meses_do_ano[7].valor, 
	 				modulos[2].ano.meses_do_ano[8].valor, modulos[2].ano.meses_do_ano[9].valor, 
	 				modulos[2].ano.meses_do_ano[10].valor, modulos[2].ano.meses_do_ano[11].valor],
	        ]
	    });
	}, 500);

	setTimeout(function () {
	    GraficoModulos.load({
	        columns: [
	            ['Serviços', modulos[3].ano.meses_do_ano[0].valor, modulos[3].ano.meses_do_ano[1].valor, 
	  				modulos[3].ano.meses_do_ano[2].valor, modulos[3].ano.meses_do_ano[3].valor, 
	 				modulos[3].ano.meses_do_ano[4].valor, modulos[3].ano.meses_do_ano[5].valor, 
	 				modulos[3].ano.meses_do_ano[6].valor, modulos[3].ano.meses_do_ano[7].valor, 
	 				modulos[3].ano.meses_do_ano[8].valor, modulos[3].ano.meses_do_ano[9].valor, 
	 				modulos[3].ano.meses_do_ano[10].valor, modulos[3].ano.meses_do_ano[11].valor],
				
	            ['Produtos', modulos[4].ano.meses_do_ano[0].valor, modulos[4].ano.meses_do_ano[1].valor, 
	  				modulos[4].ano.meses_do_ano[2].valor, modulos[4].ano.meses_do_ano[3].valor, 
	 				modulos[4].ano.meses_do_ano[4].valor, modulos[4].ano.meses_do_ano[5].valor, 
	 				modulos[4].ano.meses_do_ano[6].valor, modulos[4].ano.meses_do_ano[7].valor, 
	 				modulos[4].ano.meses_do_ano[8].valor, modulos[4].ano.meses_do_ano[9].valor, 
	 				modulos[4].ano.meses_do_ano[10].valor, modulos[4].ano.meses_do_ano[11].valor],
				
	 			['Vendas', modulos[5].ano.meses_do_ano[0].valor, modulos[5].ano.meses_do_ano[1].valor, 
	  				modulos[5].ano.meses_do_ano[2].valor, modulos[5].ano.meses_do_ano[3].valor, 
	 				modulos[5].ano.meses_do_ano[4].valor, modulos[5].ano.meses_do_ano[5].valor, 
	 				modulos[5].ano.meses_do_ano[6].valor, modulos[5].ano.meses_do_ano[7].valor, 
	 				modulos[5].ano.meses_do_ano[8].valor, modulos[5].ano.meses_do_ano[9].valor, 
	 				modulos[5].ano.meses_do_ano[10].valor, modulos[5].ano.meses_do_ano[11].valor],
				
	 			['Contas', modulos[6].ano.meses_do_ano[0].valor, modulos[6].ano.meses_do_ano[1].valor, 
	  				modulos[6].ano.meses_do_ano[2].valor, modulos[6].ano.meses_do_ano[3].valor, 
	 				modulos[6].ano.meses_do_ano[4].valor, modulos[6].ano.meses_do_ano[5].valor, 
	 				modulos[6].ano.meses_do_ano[6].valor, modulos[6].ano.meses_do_ano[7].valor, 
	 				modulos[6].ano.meses_do_ano[8].valor, modulos[6].ano.meses_do_ano[9].valor, 
	 				modulos[6].ano.meses_do_ano[10].valor, modulos[6].ano.meses_do_ano[11].valor],
			]
	    });
	}, 1000);
};

