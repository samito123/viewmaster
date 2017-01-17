
function ConstroiGraficoDeReceitas(ano) {

	var width = screen.width;
	var qtd_letras_do_mes = 0;
	if (width <= 550){
		qtd_letras_do_mes = 1;
	}else{
		qtd_letras_do_mes = 3;
	}
	
	var GraficoReceitas = c3.generate({
	    bindto: '#GraficoReceitas',
	    data: {
	        columns: [
	            [ano[0].numero_do_ano, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
				['total', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	        ],
	        types: {
	            'xxxx': 'area-step',
	            'total': 'bar'			
	            // 'line', 'spline', 'step', 'area', 'area-step' are also available to stack
	        },
	        groups: [[ano[0].numero_do_ano, 'total']]
	    },axis: {
	        x: {
	            type: 'category',
	            categories: [ano[0].meses_do_ano[0].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         ano[0].meses_do_ano[1].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         ano[0].meses_do_ano[2].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         ano[0].meses_do_ano[3].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         ano[0].meses_do_ano[4].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         ano[0].meses_do_ano[5].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         ano[0].meses_do_ano[6].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         ano[0].meses_do_ano[7].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         ano[0].meses_do_ano[8].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         ano[0].meses_do_ano[9].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         ano[0].meses_do_ano[10].nome_do_mes.substring(0, qtd_letras_do_mes), 
	                         ano[0].meses_do_ano[11].nome_do_mes.substring(0, qtd_letras_do_mes)]
	        }
	    }
	});  
	setTimeout(function () {
		GraficoReceitas.load({
	        columns: [
	            [ano[0].numero_do_ano, 
	             ano[0].meses_do_ano[0].valor, ano[0].meses_do_ano[1].valor, ano[0].meses_do_ano[2].valor, 
	             ano[0].meses_do_ano[3].valor, ano[0].meses_do_ano[4].valor, ano[0].meses_do_ano[5].valor, 
	             ano[0].meses_do_ano[6].valor, ano[0].meses_do_ano[7].valor, ano[0].meses_do_ano[8].valor, 
	             ano[0].meses_do_ano[9].valor, ano[0].meses_do_ano[10].valor, ano[0].meses_do_ano[11].valor],
	        ]
	    });
	}, 500);
	setTimeout(function () {
		GraficoReceitas.load({
	        columns: [      
				['total', ano[1].meses_do_ano[0].valor, ano[1].meses_do_ano[1].valor, ano[1].meses_do_ano[2].valor, 
	             ano[1].meses_do_ano[3].valor, ano[1].meses_do_ano[4].valor, ano[1].meses_do_ano[5].valor, 
	             ano[1].meses_do_ano[6].valor, ano[1].meses_do_ano[7].valor, ano[1].meses_do_ano[8].valor, 
	             ano[1].meses_do_ano[9].valor, ano[1].meses_do_ano[10].valor, ano[1].meses_do_ano[11].valor]
	        ]
	    });
	}, 1000);
};

