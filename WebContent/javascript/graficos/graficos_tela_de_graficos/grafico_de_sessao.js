
/*function ConstroiGraficoDeSessoesUsuario(ano) {

	var width = screen.width;
	var qtd_letras_do_mes = 0;
	if (width <= 800){
		qtd_letras_do_mes = 1;
	}else{
		qtd_letras_do_mes = 3;
	}
	
	var GraficoSessoes = c3.generate({
	    bindto: '#GraficoSessoes',
	    data: {
	        columns: [
	            [ano[0].numero_do_ano, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
				['total', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	        ],
	        types: {
	            '2222': 'area-spline',
	            'total': 'area-spline'			
	            // 'line', 'spline', 'step', 'area', 'area-step' are also available to stack
	        },
	        groups: [['2222', 'total']]
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
	    GraficoSessoes.load({
	        columns: [
	            [ano[0].numero_do_ano, 
	             ano[0].meses_do_ano[0].Math.random(), ano[0].meses_do_ano[1].Math.random(), ano[0].meses_do_ano[2].Math.random(), 
	             ano[0].meses_do_ano[3].Math.random(), ano[0].meses_do_ano[4].Math.random(), ano[0].meses_do_ano[5].Math.random(), 
	             ano[0].meses_do_ano[6].Math.random(), ano[0].meses_do_ano[7].Math.random(), ano[0].meses_do_ano[8].Math.random(), 
	             ano[0].meses_do_ano[9].Math.random(), ano[0].meses_do_ano[10].Math.random(), ano[0].meses_do_ano[11].Math.random()],
	        ]
	    });
	}, 500);
	setTimeout(function () {
	    GraficoSessoes.load({
	        columns: [      
				['total', 
	             ano[1].meses_do_ano[0].Math.random(), ano[1].meses_do_ano[1].Math.random(), ano[1].meses_do_ano[2].Math.random(), 
	             ano[1].meses_do_ano[3].Math.random(), ano[1].meses_do_ano[4].Math.random(), ano[1].meses_do_ano[5].Math.random(), 
	             ano[1].meses_do_ano[6].Math.random(), ano[1].meses_do_ano[7].Math.random(), ano[1].meses_do_ano[8].Math.random(), 
	             ano[1].meses_do_ano[9].Math.random(), ano[1].meses_do_ano[10].Math.random(), ano[1].meses_do_ano[11].Math.random()]
	        ]
	    });
	}, 1000);
};*/

function ConstroiGraficoDeSessoesUsuario(ano) {

	var width = screen.width;
	var qtd_letras_do_mes = 0;
	if (width <= 800){
		qtd_letras_do_mes = 1;
	}else{
		qtd_letras_do_mes = 3;
	}
	
	var mes0 = "Janeiro";
	
	var GraficoSessoes = c3.generate({
	    bindto: '#GraficoSessoes',
	    data: {
	        columns: [
	            ["2017", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
				['total', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	        ],
	        types: {
	            '2222': 'area-spline',
	            'total': 'area-spline'			
	            // 'line', 'spline', 'step', 'area', 'area-step' are also available to stack
	        },
	        groups: [['2222', 'total']]
	    },axis: {
	        x: {
	            type: 'category',
	            categories: [mes0.substring(0, qtd_letras_do_mes), 
	                         mes0.substring(0, qtd_letras_do_mes), 
	                         mes0.substring(0, qtd_letras_do_mes), 
	                         mes0.substring(0, qtd_letras_do_mes), 
	                         mes0.substring(0, qtd_letras_do_mes), 
	                         mes0.substring(0, qtd_letras_do_mes), 
	                         mes0.substring(0, qtd_letras_do_mes), 
	                         mes0.substring(0, qtd_letras_do_mes), 
	                         mes0.substring(0, qtd_letras_do_mes), 
	                         mes0.substring(0, qtd_letras_do_mes), 
	                         mes0.substring(0, qtd_letras_do_mes), 
	                         mes0.substring(0, qtd_letras_do_mes)]
	        }
	    }
	});  
	setTimeout(function () {
	    GraficoSessoes.load({
	        columns: [
	            ["2017", 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random()],
	        ]
	    });
	}, 500);
	setTimeout(function () {
	    GraficoSessoes.load({
	        columns: [      
				['total', 
				 Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random(), 
	             Math.random(), Math.random(), Math.random()]
	        ]
	    });
	}, 1000);
};

