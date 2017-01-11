
function ConstroiGraficoDeModulos(ano) {

	var randomnb = function(){ return Math.round(Math.random()*300)};
	
	var GraficoModulos = c3.generate({
	    bindto: '#GraficoModulos',
	    data: {
	        columns: [
	            
	        ],
	        type: 'spline'
	    },axis: {
	        x: {
	            type: 'category',
	            categories: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 
				'Out', 'Nov', 'Dez']
	        }
	    }
	});
	setTimeout(function () {
	    GraficoModulos.load({
	        columns: [
	            ['Agenda', randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb()],
	            ['Clientes', randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb()],
				['Receitas', randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb()],
	        ]
	    });
	}, 1000);

	setTimeout(function () {
	    GraficoModulos.load({
	        columns: [
	            ['Serviços', randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb()],
				['Produtos', randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb()],
			]
	    });
	}, 2000);
};

