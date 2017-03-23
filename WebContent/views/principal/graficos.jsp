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
							<div id="sessaoTab1" class="tab-pane fade in active cor_de_fundo_do_corpo_da_caixa">	             
                 				<div class="conteudo_de_corpo_da_caixa">
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
	                 		</div>
	                 		
	                 		<div id="sessaoTab2" class="tab-pane fade cor_de_fundo_do_corpo_da_caixa">
								<div class="conteudo_de_corpo_da_caixa">
									<div class="titulo_da_caixa">
	               						<h4>
					              			Sessões do usuário       		
							            </h4>
	                 				</div>
	                 				<div>
	                 					<cite title="Source Title">
		                 					<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_azul_para_legenda">
										  		</span>
								  				Sessões no ano de {{vm.anoCorrente}}: {{vm.totalDeSessoesAnoCorrente}}.
										  	</div>	
											<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_laranja_para_legenda">
										  		</span>
								  				Total de sessões do usuário: {{vm.totalDeSessoes}}.		
										  	</div>  	
					                   				  						  
									        <div class="bloco_de_texto_de_corpo_da_caixa">							        
								          		- Porcentagem correspondente ao ano de 
								          		{{vm.anoCorrente}}: {{vm.porcentagemDoAnoCorrenteSessoes}}%.							          
								          	</div>
							          	</cite>				  					  					  	 						  	 													
		                          	</div>
		                          	<div class="rodape_da_caixa">
	                  				</div>	
                  				</div>
							</div>	             		
						</div>					       				
                   	</div>			               	
				</div>		
			</div>
			
			<div class="conteiner_medio">
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
							<div id="moduloTab1" class="tab-pane fade in active cor_de_fundo_do_corpo_da_caixa">	             
                 				<div class="conteudo_de_corpo_da_caixa">
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
	                 		</div>
	                 		
	                 		<div id="moduloTab2" class="tab-pane fade cor_de_fundo_do_corpo_da_caixa">
								<div class="conteudo_de_corpo_da_caixa">
									<div class="titulo_da_caixa">
	               						<h4>
					              			Módulos mais usados          		
							            </h4>
	                 				</div>
	                 				<div>
	                 					<cite title="Source Title">
		                 					<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_azul_para_legenda">
										  		</span>
								  				Módulo agenda(total): {{vm.moduloAgendaQuantidade}}.
										  	</div>	
											<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_laranja_para_legenda">
										  		</span>
								  				Módulo clientes(total): {{vm.moduloClientesQuantidade}}.		
										  	</div>
										  	<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_verde_para_legenda">
										  		</span>
								  				Módulo receitas(total): {{vm.moduloReceitasQuantidade}}.		
										  	</div> 
										  	<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_vermelho_para_legenda">
										  		</span>
								  				Módulo serviços(total): {{vm.moduloProdutosQuantidade}}.		
										  	</div>  
										  	<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_roxo_para_legenda">
										  		</span>
								  				Módulo produtos(total): {{vm.moduloEstoqueQuantidade}}.		
										  	</div> 
										  	<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_marrom_para_legenda">
										  		</span>
								  				Módulo vendas(total): {{vm.moduloVendasQuantidade}}.		
										  	</div>  
										  	<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_rosa_para_legenda">
										  		</span>
								  				Módulo contas(total): {{vm.moduloContasQuantidade}}.		
										  	</div>   
									  	</cite>   					  					  					  	 						  	 													
		                          	</div>
		                          	<div class="rodape_da_caixa">
	                  				</div>	
                  				</div>
							</div>	             		
						</div>					       				
                   	</div>			               	
				</div>		
			</div>
			
			<div class="conteiner_medio">
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
							<div id="clientesTab1" class="tab-pane fade in active cor_de_fundo_do_corpo_da_caixa">	             
                 				<div class="conteudo_de_corpo_da_caixa">
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
	                 		</div>
	                 		
	                 		<div id="clientesTab2" class="tab-pane fade cor_de_fundo_do_corpo_da_caixa">
								<div class="conteudo_de_corpo_da_caixa">
									<div class="titulo_da_caixa">
	               						<h4>
					              			Clientes      		
							            </h4>
	                 				</div>
	                 				<div>
	                 					<cite title="Source Title">
		                 					<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_azul_para_legenda">
										  		</span>
								  				Sessões no ano de {{vm.anoCorrente}}: {{vm.totalDeClientesAnoCorrente}}.
										  	</div>	
											<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_laranja_para_legenda">
										  		</span>
								  				Total de clientes geral: {{vm.totalDeClientes}}.		
										  	</div>  				                   				  						  
									        <div class="bloco_de_texto_de_corpo_da_caixa">							        
								          		- Porcentagem correspondente ao ano de {{vm.anoCorrente}}: {{vm.porcentagemDoAnoCorrenteClientes}}%.							          
								          	</div>	
							          	</cite>			  					  					  	 						  	 													
		                          	</div>
		                          	<div class="rodape_da_caixa">
	                  				</div>	
                  				</div>
							</div>	             		
						</div>					       				
                   	</div>			               	
				</div>		
			</div>
			
			<div class="conteiner_medio">
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
							<div id="receitasTab1" class="tab-pane fade in active cor_de_fundo_do_corpo_da_caixa">	             
                 				<div class="conteudo_de_corpo_da_caixa">
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
	                 		</div>
	                 		
	                 		<div id="receitasTab2" class="tab-pane fade cor_de_fundo_do_corpo_da_caixa">
								<div class="conteudo_de_corpo_da_caixa">
									<div class="titulo_da_caixa">
	               						<h4>
					              			Receitas      		
							            </h4>
	                 				</div>
	                 				<div>
	                 					<cite title="Source Title">
		                 					<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_azul_para_legenda">
										  		</span>
								  				Receitas no ano de {{vm.anoCorrente}}: {{vm.totalDeReceitasAnoCorrente}}.
										  	</div>	
											<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_laranja_para_legenda">
										  		</span>
								  				Total de receitas geral: {{vm.totalDeReceitas}}.		
										  	</div>  				                   				  						  
									        <div class="bloco_de_texto_de_corpo_da_caixa">							        
								          		- Porcentagem correspondente ao ano de {{vm.anoCorrente}}: {{vm.porcentagemDoAnoCorrenteReceitas}}%.							          
								          	</div>
							          	</cite>				  					  					  	 						  	 													
		                          	</div>
		                          	<div class="rodape_da_caixa">
	                  				</div>
                  				</div>	
							</div>	             		
						</div>					       				
                   	</div>			               	
				</div>		
			</div>
			
			<div class="conteiner_medio">
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
							<div id="produtosTab1" class="tab-pane fade in active cor_de_fundo_do_corpo_da_caixa">	             
                 				<div class="conteudo_de_corpo_da_caixa">
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
	                 		</div>
	                 		
	                 		<div id="produtosTab2" class="tab-pane fade cor_de_fundo_do_corpo_da_caixa">
								<div class="conteudo_de_corpo_da_caixa">
									<div class="titulo_da_caixa">
	               						<h4>
					              			Tipos de produtos mais vendidos  		
							            </h4>
	                 				</div>
	                 				<div>
	                 					<cite title="Source Title">
		                 					<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_azul_para_legenda">
										  		</span>
								  				Armações(qtd): {{vm.vendasGeralArmacoes}}.
										  	</div>	
										  	<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_laranja_para_legenda">
										  		</span>
								  				Lentes de contato(qtd): {{vm.vendasGeralLentesDeContato}}.
										  	</div>
										  	<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_verde_para_legenda">
										  		</span>
								  				Relógios(qtd): {{vm.vendasGeralRelogios}}.
										  	</div>
										  	<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_vermelho_para_legenda">
										  		</span>
								  				Ouro(qtd): {{vm.vendasGeralOuro}}.
										  	</div>
										  	<div class="bloco_de_texto_de_corpo_da_caixa">
										 		<span class="quadrado_roxo_para_legenda">
										  		</span>
								  				Outros(qtd): {{vm.vendasGeralOutros}}.
										  	</div>	
									  	</cite>		  					  					  	 						  	 													
		                          	</div>
		                          	<div class="rodape_da_caixa">
	                  				</div>	
                  				</div>
							</div>	             		
						</div>					       				
                   	</div>			               	
				</div>		
			</div>
			
			<div class="conteiner_medio">
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
							<div id="assinaturaTab1" class="tab-pane fade in active cor_de_fundo_do_corpo_da_caixa">	             
                 				<div class="conteudo_de_corpo_da_caixa">
	                 				<div class="titulo_da_caixa">
	               						<h4>
					              			Validade da assinatura   		
							            </h4>
	                 				</div>
	                 				<div class="conteudo_de_corpo_da_caixa">
							            
		                               <div>                               		                            	  
											<cite title="Source Title">										
		                 						<div class="bloco_de_texto_de_corpo_da_caixa">
	                              	   				Plano de assinatura: {{vm.planoDeAssinatura}}
	                              	   			</div>								
												<div class="bloco_de_texto_de_corpo_da_caixa">
		                               	   			Assinatura ativa:  {{vm.assinaturaAtiva}}
		                               	   		</div>
												<div class="bloco_de_texto_de_corpo_da_caixa">
		                               	   			Dt.inicial da assinatura: {{vm.dataInicialAssinatura}} 
		                               	   		</div>										
												<div class="bloco_de_texto_de_corpo_da_caixa">
		                               	   			Dt.final da assinatura: {{vm.dataFinalAssinatura}} 
		                               	   		</div>										
												<div class="bloco_de_texto_de_corpo_da_caixa">
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
	                 		</div>
	                 		
	                 		<div id="assinaturaTab2" class="tab-pane fade cor_de_fundo_do_corpo_da_caixa">
								<div class="conteudo_de_corpo_da_caixa">
									<div class="titulo_da_caixa">
	               						<h4>
					              			Historico de Assinaturas 		
							            </h4>
	                 				</div>
	                 				<div>
	                 					<p>
									 		<span class="quadrado_azul_para_legenda">
									  		</span>
							  				Armações(total): {{vm.vendasGeralArmacoes}}.
									  	</p>	
									  	<p>
									 		<span class="quadrado_laranja_para_legenda">
									  		</span>
							  				Lentes de contato(total): {{vm.vendasGeralLentesDeContato}}.
									  	</p>
									  	<p>
									 		<span class="quadrado_verde_para_legenda">
									  		</span>
							  				Relógios(total): {{vm.vendasGeralRelogios}}.
									  	</p>
									  	<p>
									 		<span class="quadrado_vermelho_para_legenda">
									  		</span>
							  				Ouro(total): {{vm.vendasGeralOuro}}.
									  	</p>
									  	<p>
									 		<span class="quadrado_roxo_para_legenda">
									  		</span>
							  				Outros(total): {{vm.vendasGeralOutros}}.
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
			//PlanoDeAssinatura();
	    	
	    	function GraficoDeSessaoUsuario() {
		    	var variaveis = "?metodo=RecuperaDadosParaGraficoDeSessaoUsuario&id_de_busca="+
		    			sessionStorage.getItem("id_usuario_logado")+"&ano="+anoDoSistema.getFullYear();
		    	
		    	$http.post('Graficos'+variaveis)
		        .success(function (data, status, headers, config) {	
		        	if(data ==  "erro"){
		        		MensagemDeErroModal("Ocorreu um erro no servidor, "+
	    				"não foi possível carregar gráfico de sessões!");
		        	}else{
		        		console.log(status);
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
	    		/*var variaveis = "?metodo=RecuperaDadosParaGraficoDeModulos&id_de_busca="+
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
		    	});*/
	    		ConstroiGraficoDeModulos("");
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
	    		/*var variaveis = "?metodo=RecuperaDadosParaGraficoDeClientes&id_de_busca="+	    		
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
		    	});*/
	    		ConstroiGraficoDeClientes("");
	    	};
	    	
	    	function SetLegendasParaGraficoDeClientes(ano){
	    		acess.totalDeClientes = ano[1].valor;
	    		acess.totalDeClientesAnoCorrente = ano[0].valor;
	    		var total;
	    		total = parseFloat((acess.totalDeClientesAnoCorrente*100)/acess.totalDeClientes);
	    		acess.porcentagemDoAnoCorrenteClientes = parseFloat(total.toFixed(2));
	    	}
	    	
	    	function GraficoDeReceitas() {
	    		/*var variaveis = "?metodo=RecuperaDadosParaGraficoDeReceitas&id_de_busca="+	    		
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
		    	});*/
	    		ConstroiGraficoDeReceitas("");
	    	};
	    	
	    	function SetLegendasParaGraficoDeReceitas(ano){
	    		acess.totalDeReceitas = ano[1].valor;
	    		acess.totalDeReceitasAnoCorrente = ano[0].valor;
	    		var total;
	    		total = parseFloat((acess.totalDeReceitasAnoCorrente*100)/acess.totalDeReceitas);
	    		acess.porcentagemDoAnoCorrenteReceitas = parseFloat(total.toFixed(2));
	    	}
	    	
	    	function GraficoDeTiposDeProdutosMaisVendidos() {
	    		/*var variaveis = "?metodo=RecuperaDadosParaGraficoDeTiposDeProdutosMaisVendidos&id_de_busca="+	    		
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
		    	});*/
	    		ConstroiGraficoDeTiposDeProdutosMaisVendidos("");
	    	};
	    	
	    	function SetLegendasParaGraficoDeDeTiposDeProdutosMaisVendidos(tipoDeProduto){
	    		acess.vendasGeralArmacoes = tipoDeProduto[0].valor;
	    		acess.vendasGeralLentesDeContato = tipoDeProduto[1].valor;
	    		acess.vendasGeralRelogios = tipoDeProduto[2].valor;
	    		acess.vendasGeralOuro = tipoDeProduto[3].valor;
	    		acess.vendasGeralOutros = tipoDeProduto[4].valor;
	    	}
	    	
	    	function PlanoDeAssinatura() {
	    		var variaveis = "?metodo=RecuperaListaDeAssinaturas";
    	
		    	$http.post('Assinaturas'+variaveis)
		        .success(function (data, status, headers, config) {	
		        	if(data ==  "erro"){
		        		MensagemDeErroModal("Ocorreu um erro no servidor, "+
	    				"não foi possível carregar gráfico de clientes!");
		        	}else{
		        		SetLegendasParaAssinaturaAtual(data);
			        	//SetLegendasParaGraficoDeDeTiposDeProdutosMaisVendidos(data);
		        	}	
		    	}).error(function (data, status, header, config) {		            	
		    		MensagemDeErroModal("Ocorreu um erro no servidor, "+
		    				"verifique sua conexão com a internet e tente novamente!");
		    	});
	    	};
	    	
	    	function SetLegendasParaAssinaturaAtual(assinaturas){
	    		acess.planoDeAssinatura = assinaturas[0].tipo_assinatura;
	    		VerificaAssinaturaAtiva(assinaturas[0].data_final_assinatura);
	    		acess.dataInicialAssinatura = assinaturas[0].data_inicial_assinatura;
	    		acess.dataFinalAssinatura = assinaturas[0].data_final_assinatura;
	    	}
	    	
	    	function VerificaAssinaturaAtiva(data){
	    		acess.assinaturaAtiva = "expirada";
	    	}
	    	
	    	var datainicial = document.getElementById('datainicial');
	    	var datafinal = document.getElementById('datafinal');

	    	function formatar(mascara, documento) {
	    	    var i = documento.value.length;
	    	    var saida = mascara.substring(0, 1);
	    	    var texto = mascara.substring(i);
	    	    if (texto.substring(0, 1) != saida) {
	    	        documento.value += texto.substring(0, 1);
	    	    }
	    	    verificar();
	    	}

	    	function gerarData(str) {
	    	    var partes = str.split("/");
	    	    return new Date(partes[2], partes[1] - 1, partes[0]);
	    	}

	    	function verificar() {
	    	    var inicio = datainicial.value;
	    	    var fim = datafinal.value;
	    	    if (inicio.length != 10 || fim.length != 10) return;

	    	    if (gerarData(fim) <= gerarData(inicio)) alert("A data inicial é maior que a data final");
	    	}
	    	
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