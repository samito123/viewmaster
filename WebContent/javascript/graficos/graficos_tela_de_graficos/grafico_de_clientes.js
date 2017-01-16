
function ConstroiGraficoDeClientes() {
	var randomnb = function(){ return Math.round(Math.random()*300)};
	var ano = "2017";
	
	var GraficoClientes = c3.generate({
	    bindto: '#GraficoClientes',
	    data: {
	        columns: [
	            [ano, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
				['%', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	        ],
	        types: {
	            'xxxx': 'bar',
	            '%': 'area-spline'			
	            // 'line', 'spline', 'step', 'area', 'area-step' are also available to stack
	        },
	        groups: [[ano, '%']]
	    },axis: {
	        x: {
	            type: 'category',
	            categories: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 
				'Out', 'Nov', 'Dez']
	        }
	    }
	});  
	setTimeout(function () {
	    GraficoClientes.load({
	        columns: [
	            [ano, randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), 
				randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb()],
	        ]
	    });
	}, 1000);
	setTimeout(function () {
	    GraficoClientes.load({
	        columns: [      
				['%', randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), 
				randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb()]
	        ]
	    });
	}, 2000);
};

