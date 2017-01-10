function ConstroiGraficoDeSessoesUsuario(ano) {
	
	var width = screen.width;
	var a = 0;
	if (width <= 500){
		a = 1;
	}else{
		a = 3;
	}
	
	var GraficoSessoes = c3.generate({
	    bindto: '#GraficoSessoes',
	    data: {
	        columns: [
	            [ano[0].numero_do_ano, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
				['%', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	        ],
	        types: {
	            '2222': 'area-spline',
	            '%': 'area-spline'			
	            // 'line', 'spline', 'step', 'area', 'area-step' are also available to stack
	        },
	        groups: [['2222', '%']]
	    },axis: {
	        x: {
	            type: 'category',
	            categories: [ano[0].meses_do_ano[0].nome_do_mes.substring(0, a), 
	                         ano[0].meses_do_ano[1].nome_do_mes.substring(0, a), 
	                         ano[0].meses_do_ano[2].nome_do_mes.substring(0, a), 
	                         ano[0].meses_do_ano[3].nome_do_mes.substring(0, a), 
	                         ano[0].meses_do_ano[4].nome_do_mes.substring(0, a), 
	                         ano[0].meses_do_ano[5].nome_do_mes.substring(0, a), 
	                         ano[0].meses_do_ano[6].nome_do_mes.substring(0, a), 
	                         ano[0].meses_do_ano[7].nome_do_mes.substring(0, a), 
	                         ano[0].meses_do_ano[8].nome_do_mes.substring(0, a), 
	                         ano[0].meses_do_ano[9].nome_do_mes.substring(0, a), 
	                         ano[0].meses_do_ano[10].nome_do_mes.substring(0, a), 
	                         ano[0].meses_do_ano[11].nome_do_mes.substring(0, a)]
	        }
	    }
	});  
	setTimeout(function () {
	    GraficoSessoes.load({
	        columns: [
	            [ano[0].numero_do_ano, 
	             ano[0].meses_do_ano[0].valor, ano[0].meses_do_ano[1].valor, ano[0].meses_do_ano[2].valor, 
	             ano[0].meses_do_ano[3].valor, ano[0].meses_do_ano[4].valor, ano[0].meses_do_ano[5].valor, 
	             ano[0].meses_do_ano[6].valor, ano[0].meses_do_ano[7].valor, ano[0].meses_do_ano[8].valor, 
	             ano[0].meses_do_ano[9].valor, ano[0].meses_do_ano[10].valor, ano[0].meses_do_ano[11].valor],
	        ]
	    });
	}, 1000);
	setTimeout(function () {
	    GraficoSessoes.load({
	        columns: [      
				['%', 
	             ano[1].meses_do_ano[0].valor, ano[1].meses_do_ano[1].valor, ano[1].meses_do_ano[2].valor, 
	             ano[1].meses_do_ano[3].valor, ano[1].meses_do_ano[4].valor, ano[1].meses_do_ano[5].valor, 
	             ano[1].meses_do_ano[6].valor, ano[1].meses_do_ano[7].valor, ano[1].meses_do_ano[8].valor, 
	             ano[1].meses_do_ano[9].valor, ano[1].meses_do_ano[10].valor, ano[1].meses_do_ano[11].valor]
	        ]
	    });
	}, 2000);
};

