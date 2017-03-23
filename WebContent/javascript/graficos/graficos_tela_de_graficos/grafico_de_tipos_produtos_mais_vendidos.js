
/*function ConstroiGraficoDeTiposDeProdutosMaisVendidos(tipoDeProduto) {

	var randomnb = function(){ return Math.round(Math.random()*300)};
	var ano = '2017';
	
	var GraficoDeTiposDeProdutosMaisVendidos = c3.generate({
	    bindto: '#GraficoDeTiposDeProdutosMaisVendidos',
	    data: {
	        columns: [
	            ['Armações', 0],
	            ['Lentes de contato', 0],
				['Relógios', 0],
				['Ouro', 0],
				['Outros', 0]
	        ],
	        type : 'donut',
	        onclick: function (d, i) { console.log("onclick", d, i); },
	        onmouseover: function (d, i) { console.log("onmouseover", d, i); },
	        onmouseout: function (d, i) { console.log("onmouseout", d, i); }
	    },donut: {
	        //title: "Iris Petal Width"
	    }
	});  
	setTimeout(function () {
		GraficoDeTiposDeProdutosMaisVendidos.load({
	        columns: [
	            [tipoDeProduto[0].tipo_produto, tipoDeProduto[0].valor],
	            [tipoDeProduto[1].tipo_produto, tipoDeProduto[1].valor],
				[tipoDeProduto[2].tipo_produto, tipoDeProduto[2].valor],
				[tipoDeProduto[3].tipo_produto, tipoDeProduto[3].valor],
				[tipoDeProduto[4].tipo_produto, tipoDeProduto[4].valor]
	        ]
	    });
	}, 500);
};*/

function ConstroiGraficoDeTiposDeProdutosMaisVendidos(tipoDeProduto) {

	var randomnb = function(){ return Math.round(Math.random()*300)};
	var ano = '2017';
	
	var GraficoDeTiposDeProdutosMaisVendidos = c3.generate({
	    bindto: '#GraficoDeTiposDeProdutosMaisVendidos',
	    data: {
	        columns: [
	            ['Armações', 0],
	            ['Lentes de contato', 0],
				['Relógios', 0],
				['Ouro', 0],
				['Outros', 0]
	        ],
	        type : 'donut',
	        onclick: function (d, i) { console.log("onclick", d, i); },
	        onmouseover: function (d, i) { console.log("onmouseover", d, i); },
	        onmouseout: function (d, i) { console.log("onmouseout", d, i); }
	    },donut: {
	        //title: "Iris Petal Width"
	    }
	});  
	setTimeout(function () {
		GraficoDeTiposDeProdutosMaisVendidos.load({
	        columns: [
	            [randomnb(), randomnb()],
	            [randomnb(), randomnb()],
				[randomnb(), randomnb()],
				[randomnb(), randomnb()],
				[randomnb(), randomnb()]
	        ]
	    });
	}, 500);
};

