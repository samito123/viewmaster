
function ConstroiGraficoDeReceitas(ano) {

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
	
	var GraficoReceitas = c3.generate({
	    bindto: '#GraficoReceitas',
	    data: {
	        columns: [
	            ["2017", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
				['total', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	        ],
	        types: {
	            'xxxx': 'area-step',
	            'total': 'bar'			
	            // 'line', 'spline', 'step', 'area', 'area-step' are also available to stack
	        },
	        groups: [["2017", 'total']]
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
		GraficoReceitas.load({
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
		GraficoReceitas.load({
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

