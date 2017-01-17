
function ConstroiGraficoDeTipoProdutoMaisVendido(ano) {

	var randomnb = function(){ return Math.round(Math.random()*300)};
	var ano = '2017';
	
	var GraficoProdutosEmEstoque = c3.generate({
	    bindto: '#GraficoProdutosEmEstoque',
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
		GraficoProdutosEmEstoque.load({
	        columns: [
	            ['Armações', randomnb()],
	            ['Lentes de contato', randomnb()],
				['Relógios', randomnb()],
				['Ouro', randomnb()],
				['Outros', randomnb()]
	        ]
	    });
	}, 1000);
};

