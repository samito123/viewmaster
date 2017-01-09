
    function ConstroiGraficoDeSessoesUsuario(id_usuario, ano, http, acess) {
		var randomnb = function(){ return Math.round(Math.random()*300)};
		    	
		var GraficoSessoes = c3.generate({
		    bindto: '#GraficoSessoes',
		    data: {
		        columns: [
		            [ano, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
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
		            categories: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 
					'Out', 'Nov', 'Dez']
		        }
		    }
		});  
		setTimeout(function () {
		    GraficoSessoes.load({
		        columns: [
		            [ano, randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), 
					randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb()],
		        ]
		    });
		}, 1000);
		setTimeout(function () {
		    GraficoSessoes.load({
		        columns: [      
					['%', randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), 
					randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb()]
		        ]
		    });
		}, 2000);
	};