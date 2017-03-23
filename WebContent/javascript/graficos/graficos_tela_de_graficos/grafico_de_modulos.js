
/*function ConstroiGraficoDeModulos(modulos) {

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
};*/

function ConstroiGraficoDeModulos(modulos) {

	var width = screen.width;
	var qtd_letras_do_mes = 0;
	if (width <= 800){
		qtd_letras_do_mes = 1;
	}else{
		qtd_letras_do_mes = 3;
	}
	
	var mes0 = "Janeiro";
	var mes1 = "Fevereiro";
	var mes2 = "Março";
	var mes3 = "Abril";
	var mes4 = "Maio";
	var mes5 = "Junho";
	var mes6 = "Julho";
	var mes7 = "Agosto";
	var mes8 = "Setembro";
	var mes9 = "Outubro";
	var mes10 = "Novembro";
	var mes11= "Dezembro";
	
	var GraficoModulos = c3.generate({
	    bindto: '#GraficoModulos',
	    data: {
	        columns: [
	            
	        ],
	        type: 'spline'
	    },axis: {
	        x: {
	            type: 'category',
	            categories: [mes0.substring(0, qtd_letras_do_mes), 
	                         mes1.substring(0, qtd_letras_do_mes), 
	                         mes2.substring(0, qtd_letras_do_mes), 
	                         mes3.substring(0, qtd_letras_do_mes), 
	                         mes4.substring(0, qtd_letras_do_mes), 
	                         mes5.substring(0, qtd_letras_do_mes), 
	                         mes6.substring(0, qtd_letras_do_mes), 
	                         mes7.substring(0, qtd_letras_do_mes), 
	                         mes8.substring(0, qtd_letras_do_mes), 
	                         mes9.substring(0, qtd_letras_do_mes), 
	                         mes10.substring(0, qtd_letras_do_mes), 
	                         mes11.substring(0, qtd_letras_do_mes)]
	        }
	    }
	});
	setTimeout(function () {
	    GraficoModulos.load({
	        columns: [
	            ['Agenda', Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random()],
	            
     			['Clientes', Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random()],        
	            
	 			['Receitas', Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random()],
	        ]
	    });
	}, 500);

	setTimeout(function () {
	    GraficoModulos.load({
	        columns: [
	            ['Serviços', Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random()],
				
	            ['Produtos', Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random()],
				
	 			['Vendas', Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random()],
				
	 			['Contas', Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random()],
			]
	    });
	}, 1000);
};

