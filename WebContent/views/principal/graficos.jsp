<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="vmApp">
	<head>
		<meta charset="utf-8">
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
		<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
		<meta name="viewport" content="width=device-width">
		
		<title>Sistema de gestão para o ramo óptico</title>
		<%@include  file="importacoes_graficos/head_graficos_importacoes.jsp" %>
	
	</head>
	<body ng-controller="ViewMaster as vm">
		
		<%@include  file="../importacoes/loading.jsp" %>
		<%@include  file="../importacoes/modal_mensagens.jsp" %>
		
		<script type="text/javascript">
			if(sessionStorage.getItem("usuario_logado") != "Y"){
				window.location.assign("Login");
			}
		</script>
		
		<div class="container"> 
			<%@include  file="../importacoes/menu_de_opcoes_modulos.jsp" %>
			
			<div class="conteiner_grande">
			    <div class="caixa_com_borda_redonda">
			      	<div class="borda_branca">               
						
						<ul class="nav nav-tabs">
						  	<li class="active">
							  	<a data-toggle="tab" style="color:#536376" href="#sessaoTab1">
							  		Sessões
						  		</a>
				  			</li>
						  	<li>
						  		<a data-toggle="tab" style="color:#536376" href="#sessaoTab2">
						  			Legendas
					  			</a>
				  			</li>
						</ul>
						
						<div class="tab-content">
							<div id="sessaoTab1" class="tab-pane fade in active conteudo_de_corpo_da_caixa">	             
                 				<div class="titulo_da_caixa">
               						<h4>
				              			Sessões do usuário - {{vm.anoCorrente}}         		
						            </h4>
                 				</div>
                 				<div class="conteudo_de_corpo_da_caixa">
						            
		                           <div id="GraficoSessoes" class="caixa_de_grafico">                      	
	                               </div>
	                           							
	                          	</div>
	                          	<div class="rodape_da_caixa">
                 				</div>	              			
	                 		</div>
	                 		
	                 		<div id="sessaoTab2" class="tab-pane fade conteudo_de_corpo_da_caixa">
								<div class="titulo_da_caixa">
               						<h4>
				              			Sessões do usuário       		
						            </h4>
                 				</div>
                 				<div>
                 					<p>
								 		<span class="quadrado_azul_para_legenda">
								  		</span>
						  				Sessões no ano de {{vm.anoCorrente}}: {{vm.totalDeSessoesAnoCorrente}}.
								  	</p>	
									<p>
								 		<span class="quadrado_laranja_para_legenda">
								  		</span>
						  				Total de sessões do usuário: {{vm.totalDeSessoes}}.		
								  	</p>  	
			                   				  						  
							        <p>							        
						          		- Porcentagem correspondente ao ano de {{vm.anoCorrente}}: {{vm.porcentagemDoAnoCorrenteSessoes}}%.							          
						          	</p>				  					  					  	 						  	 													
	                          	</div>
	                          	<div class="rodape_da_caixa">
                  				</div>	
							</div>	             		
						</div>					       				
                   	</div>			               	
				</div>		
			</div>
			
			<div class="conteiner_medio_left">
			    <div class="caixa_com_borda_redonda">
			      	<div class="borda_branca">               
						
						<ul class="nav nav-tabs">
						  	<li class="active">
							  	<a data-toggle="tab" style="color:#536376" href="#moduloTab1">
							  		Modulos
						  		</a>
				  			</li>
						  	<li>
						  		<a data-toggle="tab" style="color:#536376" href="#moduloTab2">
						  			Legendas
					  			</a>
				  			</li>
						</ul>
						
						<div class="tab-content">
							<div id="moduloTab1" class="tab-pane fade in active conteudo_de_corpo_da_caixa">	             
                 				<div class="titulo_da_caixa">
               						<h4>
				              			Módulos mais usados         		
						            </h4>
                 				</div>
                 				<div class="conteudo_de_corpo_da_caixa">
						            
		                           <div id="GraficoModulos" class="caixa_de_grafico">       	
	                               </div>
	                           							
	                          	</div>
	                          	<div class="rodape_da_caixa">
                 				</div>	              			
	                 		</div>
	                 		
	                 		<div id="moduloTab2" class="tab-pane fade conteudo_de_corpo_da_caixa">
								<div class="titulo_da_caixa">
               						<h4>
				              			Módulos mais usados          		
						            </h4>
                 				</div>
                 				<div>
                 					<p>
								 		<span class="quadrado_azul_para_legenda">
								  		</span>
						  				Módulo agenda(qtd): {{vm.moduloAgendaQuantidade}}.
								  	</p>	
									<p>
								 		<span class="quadrado_laranja_para_legenda">
								  		</span>
						  				Módulo clientes(qtd): {{vm.moduloClientesQuantidade}}.		
								  	</p>
								  	<p>
								 		<span class="quadrado_verde_para_legenda">
								  		</span>
						  				Módulo receitas(qtd): {{vm.moduloReceitasQuantidade}}.		
								  	</p> 
								  	<p>
								 		<span class="quadrado_vermelho_para_legenda">
								  		</span>
						  				Módulo serviços(qtd): {{vm.moduloProdutosQuantidade}}.		
								  	</p>  
								  	<p>
								 		<span class="quadrado_roxo_para_legenda">
								  		</span>
						  				Módulo produtos(qtd): {{vm.moduloEstoqueQuantidade}}.		
								  	</p> 
								  	<p>
								 		<span class="quadrado_marrom_para_legenda">
								  		</span>
						  				Módulo vendas(qtd): {{vm.moduloVendasQuantidade}}.		
								  	</p>  
								  	<p>
								 		<span class="quadrado_rosa_para_legenda">
								  		</span>
						  				Módulo contas(qtd): {{vm.moduloContasQuantidade}}.		
								  	</p>      					  					  					  	 						  	 													
	                          	</div>
	                          	<div class="rodape_da_caixa">
                  				</div>	
							</div>	             		
						</div>					       				
                   	</div>			               	
				</div>		
			</div>
			
			<div class="conteiner_medio_left">
			    <div class="caixa_com_borda_redonda">
			      	<div class="borda_branca">               
						
						<ul class="nav nav-tabs">
						  	<li class="active">
							  	<a data-toggle="tab" style="color:#536376" href="#clientesTab1">
							  		Clientes
						  		</a>
				  			</li>
						  	<li>
						  		<a data-toggle="tab" style="color:#536376" href="#clientesTab2">
						  			Legendas
					  			</a>
				  			</li>
						</ul>
						
						<div class="tab-content">
							<div id="clientesTab1" class="tab-pane fade in active conteudo_de_corpo_da_caixa">	             
                 				<div class="titulo_da_caixa">
               						<h4>
				              			Clientes  		
						            </h4>
                 				</div>
                 				<div class="conteudo_de_corpo_da_caixa">
						            
		                           <div id="GraficoClientes" class="caixa_de_grafico">       	
	                               </div>
	                           							
	                          	</div>
	                          	<div class="rodape_da_caixa">
                 				</div>	              			
	                 		</div>
	                 		
	                 		<div id="clientesTab2" class="tab-pane fade conteudo_de_corpo_da_caixa">
								<div class="titulo_da_caixa">
               						<h4>
				              			Clientes      		
						            </h4>
                 				</div>
                 				<div>
                 					<p>
								 		<span class="quadrado_azul_para_legenda">
								  		</span>
						  				Sessões no ano de {{vm.anoCorrente}}: {{vm.totalDeClientesAnoCorrente}}.
								  	</p>	
									<p>
								 		<span class="quadrado_laranja_para_legenda">
								  		</span>
						  				Total de clientes geral: {{vm.totalDeClientes}}.		
								  	</p>  	
			                   				  						  
							        <p>							        
						          		- Porcentagem correspondente ao ano de {{vm.anoCorrente}}: {{vm.porcentagemDoAnoCorrenteClientes}}%.							          
						          	</p>				  					  					  	 						  	 													
	                          	</div>
	                          	<div class="rodape_da_caixa">
                  				</div>	
							</div>	             		
						</div>					       				
                   	</div>			               	
				</div>		
			</div>
			
			<div class="conteiner_medio_left">
			    <div class="caixa_com_borda_redonda">
			      	<div class="borda_branca">               
						
						<ul class="nav nav-tabs">
						  	<li class="active">
							  	<a data-toggle="tab" style="color:#536376" href="#receitasTab1">
							  		Receitas
						  		</a>
				  			</li>
						  	<li>
						  		<a data-toggle="tab" style="color:#536376" href="#receitasTab2">
						  			Legendas
					  			</a>
				  			</li>
						</ul>
						
						<div class="tab-content">
							<div id="receitasTab1" class="tab-pane fade in active conteudo_de_corpo_da_caixa">	             
                 				<div class="titulo_da_caixa">
               						<h4>
				              			Receitas  		
						            </h4>
                 				</div>
                 				<div class="conteudo_de_corpo_da_caixa">
						            
		                           <div id="GraficoReceitas" class="caixa_de_grafico">       	
	                               </div>
	                           							
	                          	</div>
	                          	<div class="rodape_da_caixa">
                 				</div>	              			
	                 		</div>
	                 		
	                 		<div id="receitasTab2" class="tab-pane fade conteudo_de_corpo_da_caixa">
								<div class="titulo_da_caixa">
               						<h4>
				              			Receitas      		
						            </h4>
                 				</div>
                 				<div>
                 					<p>
								 		<span class="quadrado_azul_para_legenda">
								  		</span>
						  				Receitas no ano de {{vm.anoCorrente}}: {{vm.totalDeReceitasAnoCorrente}}.
								  	</p>	
									<p>
								 		<span class="quadrado_laranja_para_legenda">
								  		</span>
						  				Total de receitas geral: {{vm.totalDeReceitas}}.		
								  	</p>  	
			                   				  						  
							        <p>							        
						          		- Porcentagem correspondente ao ano de {{vm.anoCorrente}}: {{vm.porcentagemDoAnoCorrenteReceitas}}%.							          
						          	</p>				  					  					  	 						  	 													
	                          	</div>
	                          	<div class="rodape_da_caixa">
                  				</div>	
							</div>	             		
						</div>					       				
                   	</div>			               	
				</div>		
			</div>
			
			<div class="conteiner_medio_left">
			    <div class="caixa_com_borda_redonda">
			      	<div class="borda_branca">               
						
						<ul class="nav nav-tabs">
						  	<li class="active">
							  	<a data-toggle="tab" style="color:#536376" href="#produtosTab1">
							  		Tipo de produto
						  		</a>
				  			</li>
						  	<li>
						  		<a data-toggle="tab" style="color:#536376" href="#produtosTab2">
						  			Legendas
					  			</a>
				  			</li>
						</ul>
						
						<div class="tab-content">
							<div id="produtosTab1" class="tab-pane fade in active conteudo_de_corpo_da_caixa">	             
                 				<div class="titulo_da_caixa">
               						<h4>
				              			Tipos de produtos mais vendidos  		
						            </h4>
                 				</div>
                 				<div class="conteudo_de_corpo_da_caixa">
						            
		                           <div id="GraficoDeTiposDeProdutosMaisVendidos" class="caixa_de_grafico">       	
	                               </div>
	                           							
	                          	</div>
	                          	<div class="rodape_da_caixa">
                 				</div>	              			
	                 		</div>
	                 		
	                 		<div id="produtosTab2" class="tab-pane fade conteudo_de_corpo_da_caixa">
								<div class="titulo_da_caixa">
               						<h4>
				              			Tipos de produtos mais vendidos  		
						            </h4>
                 				</div>
                 				<div>
                 					<p>
								 		<span class="quadrado_azul_para_legenda">
								  		</span>
						  				Armações(qtd): {{vm.vendasGeralArmacoes}}.
								  	</p>	
								  	<p>
								 		<span class="quadrado_laranja_para_legenda">
								  		</span>
						  				Lentes de contato(qtd): {{vm.vendasGeralLentesDeContato}}.
								  	</p>
								  	<p>
								 		<span class="quadrado_verde_para_legenda">
								  		</span>
						  				Relógios(qtd): {{vm.vendasGeralRelogios}}.
								  	</p>
								  	<p>
								 		<span class="quadrado_vermelho_para_legenda">
								  		</span>
						  				Ouro(qtd): {{vm.vendasGeralOuro}}.
								  	</p>
								  	<p>
								 		<span class="quadrado_roxo_para_legenda">
								  		</span>
						  				Outros(qtd): {{vm.vendasGeralOutros}}.
								  	</p>			  					  					  	 						  	 													
	                          	</div>
	                          	<div class="rodape_da_caixa">
                  				</div>	
							</div>	             		
						</div>					       				
                   	</div>			               	
				</div>		
			</div>
			
			<div class="conteiner_medio_left">
			    <div class="caixa_com_borda_redonda">
			      	<div class="borda_branca">               
						
						<ul class="nav nav-tabs">
						  	<li class="active">
							  	<a data-toggle="tab" style="color:#536376" href="#assinaturaTab1">
							  		Assinatura Atual
						  		</a>
				  			</li>
						  	<li>
						  		<a data-toggle="tab" style="color:#536376" href="#assinaturaTab2">
						  			Historico
					  			</a>
				  			</li>
						</ul>
						
						<div class="tab-content">
							<div id="assinaturaTab1" class="tab-pane fade in active conteudo_de_corpo_da_caixa">	             
                 				<div class="titulo_da_caixa">
               						<h4>
				              			Validade da assinatura   		
						            </h4>
                 				</div>
                 				<div class="conteudo_de_corpo_da_caixa">
						            
	                               <div>                               		                            	  
										<cite title="Source Title">
											<div>
	                              	   				Plano de assinatura: {{vm.planoDeAssinatura}}
	                              	   			</div>								
											<div>
	                               	   			Assinatura ativa:  {{vm.assinaturaAtiva}}
	                               	   		</div>
											<div>
	                               	   			Dt.inicial da assinatura: {{vm.dataInicialAssinatura}} 
	                               	   		</div>										
											<div>
	                               	   			Dt.final da assinatura: {{vm.dataFinalAssinatura}} 
	                               	   		</div>										
											<div>
												<a href="#">
													A assinatura pode ser 
													renovada a qualquer momento 
													nas configurações de assinatura
												</a>
											</div>
										</cite>											
	                               </div>
                              				
	                          	</div>
	                          	<div class="rodape_da_caixa">
                 				</div>	              			
	                 		</div>
	                 		
	                 		<div id="assinaturaTab2" class="tab-pane fade conteudo_de_corpo_da_caixa">
								<div class="titulo_da_caixa">
               						<h4>
				              			Historico de Assinaturas 		
						            </h4>
                 				</div>
                 				<div>
                 					<p>
								 		<span class="quadrado_azul_para_legenda">
								  		</span>
						  				Armações(qtd): {{vm.vendasGeralArmacoes}}.
								  	</p>	
								  	<p>
								 		<span class="quadrado_laranja_para_legenda">
								  		</span>
						  				Lentes de contato(qtd): {{vm.vendasGeralLentesDeContato}}.
								  	</p>
								  	<p>
								 		<span class="quadrado_verde_para_legenda">
								  		</span>
						  				Relógios(qtd): {{vm.vendasGeralRelogios}}.
								  	</p>
								  	<p>
								 		<span class="quadrado_vermelho_para_legenda">
								  		</span>
						  				Ouro(qtd): {{vm.vendasGeralOuro}}.
								  	</p>
								  	<p>
								 		<span class="quadrado_roxo_para_legenda">
								  		</span>
						  				Outros(qtd): {{vm.vendasGeralOutros}}.
								  	</p>			  					  					  	 						  	 													
	                          	</div>
	                          	<div class="rodape_da_caixa">
                  				</div>	
							</div>	             		
						</div>					       				
                   	</div>			               	
				</div>		
			</div>
							
		</div>	
	</body>
</html>

<script type="text/javascript" src="javascript/menu/pushy.min.js" charset="UTF-8"></script>

<!-- Animação letras -->
	<script type="text/javascript">
		$(function () {
			$('.titulo_menu_animacao').textillate({      
				// enable looping
				loop: false,
				initialDelay: 0,
				autoStart: true,
				in: {
					// set the effect name
					effect: 'flash',
					// set the delay factor applied to each consecutive character
					delayScale: 1.5,
					// set the delay between each character
					delay: 50,
					// set to true to animate all the characters at the same time
					sync: false,
					// randomize the character sequence 
					// (note that shuffle doesn't make sense with sync = true)
					shuffle: true,
					// reverse the character sequence 
					// (note that reverse doesn't make sense with sync = true)
					reverse: false,
					// callback that executes once the animation has finished
					callback: function () {}
				}, 
			// set the type of token to animate (available types: 'char' and 'word')
			type: 'char'
			});

			$("#loading").hide();
		});
	</script>
<!-- Fim Animação letras -->

<!-- ANGULAR JS -->
	<script type="text/javascript">
		var app = angular.module('vmApp',[] );
		app.controller('ViewMaster', ['$http',function($http){
			
			var acess = this;		
			acess.user = sessionStorage.getItem("usuario");
			acess.tituloDoMenu = "Home";	
			
			var anoDoSistema = new Date();
			acess.anoCorrente = anoDoSistema.getFullYear();
			
			GraficoDeSessaoUsuario();
			GraficoDeModulos();
			GraficoDeClientes();
			GraficoDeReceitas();
			GraficoDeTiposDeProdutosMaisVendidos();
	    	
	    	function GraficoDeSessaoUsuario() {
		    	var variaveis = "?metodo=RecuperaDadosParaGraficoDeSessaoUsuario&id_de_busca="+
		    			sessionStorage.getItem("id_usuario_logado")+"&ano="+anoDoSistema.getFullYear();
		    	
		    	$http.post('Graficos'+variaveis)
		        .success(function (data, status, headers, config) {	
		        	if(data ==  "erro"){
		        		MensagemDeErroModal("Ocorreu um erro no servidor, "+
	    				"não foi possível carregar gráfico de sessões!");
		        	}else{
		        		ConstroiGraficoDeSessoesUsuario(data);
		        		SetLegendasParaGraficoDeSessoesDoUsuario(data);
		        	}	
		    	}).error(function (data, status, header, config) {		            	
		    		MensagemDeErroModal("Ocorreu um erro, "+
		    				"verifique sua conexão com a internet e tente novamente!");
		    	});
	    	};
			
	    	function SetLegendasParaGraficoDeSessoesDoUsuario(ano){
	    		acess.totalDeSessoes = ano[1].valor;
	    		acess.totalDeSessoesAnoCorrente = ano[0].valor;
	    		var total;
	    		total = parseFloat((acess.totalDeSessoesAnoCorrente*100)/acess.totalDeSessoes);
	    		acess.porcentagemDoAnoCorrenteSessoes = parseFloat(total.toFixed(2));
	    	}
	    	
	    	function GraficoDeModulos() {
	    		var variaveis = "?metodo=RecuperaDadosParaGraficoDeModulos&id_de_busca="+
    			sessionStorage.getItem("id_usuario_logado")+"&ano="+anoDoSistema.getFullYear();
    	
		    	$http.post('Graficos'+variaveis)
		        .success(function (data, status, headers, config) {	
		        	if(data ==  "erro"){
		        		MensagemDeErroModal("Ocorreu um erro no servidor, "+
	    				"não foi possível carregar gráfico de modulos!");
		        	}else{
		        		ConstroiGraficoDeModulos(data);
			        	SetLegendasParaGraficoDeModulos(data);
		        	}	
		    	}).error(function (data, status, header, config) {		            	
		    		MensagemDeErroModal("Ocorreu um erro no servidor, "+
		    				"verifique sua conexão com a internet e tente novamente!");
		    	});
	    	};
	    	
	    	function SetLegendasParaGraficoDeModulos(modulos){
	    		acess.moduloAgendaQuantidade = modulos[0].ano.valor;
	    		acess.moduloClientesQuantidade = modulos[1].ano.valor;
	    		acess.moduloReceitasQuantidade = modulos[2].ano.valor;
	    		acess.moduloProdutosQuantidade = modulos[3].ano.valor;
	    		acess.moduloEstoqueQuantidade = modulos[4].ano.valor;
	    		acess.moduloVendasQuantidade = modulos[5].ano.valor;
	    		acess.moduloContasQuantidade = modulos[6].ano.valor;
	    	}
	    	
	    	function GraficoDeClientes() {
	    		var variaveis = "?metodo=RecuperaDadosParaGraficoDeClientes&id_de_busca="+	    		
    			sessionStorage.getItem("id_usuario_logado")+"&ano="+anoDoSistema.getFullYear();
    	
		    	$http.post('Graficos'+variaveis)
		        .success(function (data, status, headers, config) {	
		        	if(data ==  "erro"){
		        		MensagemDeErroModal("Ocorreu um erro no servidor, "+
	    				"não foi possível carregar gráfico de clientes!");
		        	}else{
		        		ConstroiGraficoDeClientes(data);
			        	SetLegendasParaGraficoDeClientes(data);
		        	}	
		    	}).error(function (data, status, header, config) {		            	
		    		MensagemDeErroModal("Ocorreu um erro no servidor, "+
		    				"verifique sua conexão com a internet e tente novamente!");
		    	});
	    	};
	    	
	    	function SetLegendasParaGraficoDeClientes(ano){
	    		acess.totalDeClientes = ano[1].valor;
	    		acess.totalDeClientesAnoCorrente = ano[0].valor;
	    		var total;
	    		total = parseFloat((acess.totalDeClientesAnoCorrente*100)/acess.totalDeClientes);
	    		acess.porcentagemDoAnoCorrenteClientes = parseFloat(total.toFixed(2));
	    	}
	    	
	    	function GraficoDeReceitas() {
	    		var variaveis = "?metodo=RecuperaDadosParaGraficoDeReceitas&id_de_busca="+	    		
    			sessionStorage.getItem("id_usuario_logado")+"&ano="+anoDoSistema.getFullYear();
    	
		    	$http.post('Graficos'+variaveis)
		        .success(function (data, status, headers, config) {	
		        	if(data ==  "erro"){
		        		MensagemDeErroModal("Ocorreu um erro no servidor, "+
	    				"não foi possível carregar gráfico de clientes!");
		        	}else{
		        		ConstroiGraficoDeReceitas(data);
			        	SetLegendasParaGraficoDeReceitas(data);
		        	}	
		    	}).error(function (data, status, header, config) {		            	
		    		MensagemDeErroModal("Ocorreu um erro no servidor, "+
		    				"verifique sua conexão com a internet e tente novamente!");
		    	});
	    	};
	    	
	    	function SetLegendasParaGraficoDeReceitas(ano){
	    		acess.totalDeReceitas = ano[1].valor;
	    		acess.totalDeReceitasAnoCorrente = ano[0].valor;
	    		var total;
	    		total = parseFloat((acess.totalDeReceitasAnoCorrente*100)/acess.totalDeReceitas);
	    		acess.porcentagemDoAnoCorrenteReceitas = parseFloat(total.toFixed(2));
	    	}
	    	
	    	function GraficoDeTiposDeProdutosMaisVendidos() {
	    		var variaveis = "?metodo=RecuperaDadosParaGraficoDeTiposDeProdutosMaisVendidos&id_de_busca="+	    		
    			sessionStorage.getItem("id_usuario_logado")+"&ano="+anoDoSistema.getFullYear();
    	
		    	$http.post('Graficos'+variaveis)
		        .success(function (data, status, headers, config) {	
		        	if(data ==  "erro"){
		        		MensagemDeErroModal("Ocorreu um erro no servidor, "+
	    				"não foi possível carregar gráfico de clientes!");
		        	}else{
		        		ConstroiGraficoDeTiposDeProdutosMaisVendidos(data);
			        	SetLegendasParaGraficoDeDeTiposDeProdutosMaisVendidos(data);
		        	}	
		    	}).error(function (data, status, header, config) {		            	
		    		MensagemDeErroModal("Ocorreu um erro no servidor, "+
		    				"verifique sua conexão com a internet e tente novamente!");
		    	});
	    	};
	    	
	    	function SetLegendasParaGraficoDeDeTiposDeProdutosMaisVendidos(tipoDeProduto){
	    		acess.vendasGeralArmacoes = tipoDeProduto[0].valor;
	    		acess.vendasGeralLentesDeContato = tipoDeProduto[1].valor;
	    		acess.vendasGeralRelogios = tipoDeProduto[2].valor;
	    		acess.vendasGeralOuro = tipoDeProduto[3].valor;
	    		acess.vendasGeralOutros = tipoDeProduto[4].valor;
	    		
	    		
	    		var total;
	    		total = parseFloat((acess.totalDeReceitasAnoCorrente*100)/acess.totalDeReceitas);
	    		acess.porcentagemDoAnoCorrenteReceitas = parseFloat(total.toFixed(2));
	    	}
	    	
	    	function PlanoDeAssinatura() {
	    		var variaveis = "?metodo=RecuperaDadosParaGraficoDeTiposDeProdutosMaisVendidos&id_de_busca="+	    		
    			sessionStorage.getItem("id_usuario_logado")+"&ano="+anoDoSistema.getFullYear();
    	
		    	$http.post('Graficos'+variaveis)
		        .success(function (data, status, headers, config) {	
		        	if(data ==  "erro"){
		        		MensagemDeErroModal("Ocorreu um erro no servidor, "+
	    				"não foi possível carregar gráfico de clientes!");
		        	}else{
		        		ConstroiGraficoDeTiposDeProdutosMaisVendidos(data);
			        	SetLegendasParaGraficoDeDeTiposDeProdutosMaisVendidos(data);
		        	}	
		    	}).error(function (data, status, header, config) {		            	
		    		MensagemDeErroModal("Ocorreu um erro no servidor, "+
		    				"verifique sua conexão com a internet e tente novamente!");
		    	});
	    	};
	    	
			function MensagemDeErroModal(mensagem){
				acess.alertModal = 'alert-danger';
	    		acess.btnModal = 'btn-danger';
	        	acess.modalHeader = 'Atenção:'; 
	    		acess.modalBody = mensagem;
	    		acess.modalFooter = 'Fechar';
	    		$("#modal").modal('show');
	    		$("#loading").hide();
			};
			
		}]);
	</script>
<!-- ANGULAR JS -->