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
						  				Sessões no ano de {{vm.anoCorrente}}: {{vm.totalSessoesAnoCorrente}}.
								  	</p>	
									<p>
								 		<span class="quadrado_laranja_para_legenda">
								  		</span>
						  				Total de sessões do usuário: {{vm.totalSessoes}}.		
								  	</p>  	
			                   				  						  
							        <p>							        
						          		- Porcentagem correspondente ao ano de {{vm.anoCorrente}}: {{vm.porcentagemDoAnoCorrente}}%.							          
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
			
			<div class="conteiner_medio_right">
			    <div class="caixa_com_borda_redonda">
			      	<div class="borda_branca">               
						
						<ul class="nav nav-tabs">
						  	<li class="active">
							  	<a data-toggle="tab" style="color:#536376" href="#clientesTab1">
							  		Modulos
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
	    		acess.totalSessoes = ano[1].valor;
	    		acess.totalSessoesAnoCorrente = ano[0].valor;
	    		var total;
	    		total = parseFloat((acess.totalSessoesAnoCorrente*100)/acess.totalSessoes);
	    		acess.porcentagemDoAnoCorrente = parseFloat(total.toFixed(2));
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
		        	console.log(data);
		        	if(data ==  "erro"){
		        		MensagemDeErroModal("Ocorreu um erro no servidor, "+
	    				"não foi possível carregar gráfico de clientes!");
		        	}else{
		        		//ConstroiGraficoDeModulos(data);
			        	//SetLegendasParaGraficoDeModulos(data);
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