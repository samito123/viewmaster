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
			if(sessionStorage.getItem("user_log") != "Y"){
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
						            
		                           <div id="GraficoSessoes" style="width:100%; 
                             			height:200px;">
	                              	
	                              </div>
	                           							
	                          	</div>
	                          	<div class="rodape_da_caixa">
                 				</div>	              			
	                 		</div>
	                 		
	                 		<div id="sessaoTab2" class="tab-pane fade conteudo_de_corpo_da_caixa">
								<div class="titulo_da_caixa">
               						<h4>
				              			Sessões do usuário - {{vm.anoCorrente}}        		
						            </h4>
                 				</div>
                 				<div>
						            
			                        <p>
		                 				<span style="font-size:18px;">
		                 					- Total de sessões: xxx	
		                 				</span>
		                 			</p>			
		                          	<p>
			                          	<span style="font-size:18px;">
			                          		- Sessões no ano de 2222: total clientes
			                          	</span>
		                          	</p>				  						  
							        <p>
							        	<span style="font-size:18px;">
						          			- Porcentagem correspondente(2222): totalclientes%
							          	</span>
						          	</p>				  
								 
								  	<div style="position: fixed; margin-top:5px; border-color: #1f77b4 #1f77b4 #f5f4e9 #1f77b4;" class="quadrado">
								  	</div>
								  	
								  	<p style="margin-left:15px;">
								  		 <span style="font-size:18px;">
								  	 		Sessões no ano de xxxx
							  	 		</span>
								  	</p>	

								  	<div style="position: fixed; margin-top:5px; border-color: #ff7f0e #ff7f0e #f5f4e9 #ff7f0e;" class="quadrado">
								  	</div>
 							 		<p style="margin-left:15px;">
	 							 		<span style="font-size:18px;">
	 							 			Porcentagem correspondente(2222)
 							 			</span>
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
			acess.user = sessionStorage.getItem("user");
			acess.tituloDoMenu = "Home";	
			
			var anoDoSistema = new Date();
			acess.anoCorrente = anoDoSistema.getFullYear();
			
			
			//var variaveis = "?metodo=RecuperaDadosParaGraficoDeSessaoUsuario&id_de_busca="+id_usuario+"&ano="+ano;
	    	var variaveis = "?metodo=RecuperaDadosParaGraficoDeSessaoUsuario&id_de_busca="+sessionStorage.getItem("id")+"&ano=2017";
	    	$http.post('Graficos'+variaveis)
		        .success(function (data, status, headers, config) {	
		        	console.log("Data: ", data);
		        	if(data == "erro"){
		        		acess.alertModal = 'alert-danger';
		        		acess.btnModal = 'btn-danger';
		        		acess.modalHeader = 'Atenção:'; 
		        		acess.modalBody = 'Usuário ou senha está incorreto!';
		        		acess.modalFooter = 'Fechar';
		        		$("#modal").modal('show');
		        		$("#loading").hide();
		        	}else{							
		        		acess.alertModal = 'alert-danger';
			    		acess.btnModal = 'btn-danger';
			        	acess.modalHeader = 'Atenção:'; 
			    		acess.modalBody = 'Ocorreu um erro no servidor, tente novamente mais tarde!';
			    		acess.modalFooter = 'Fechar';
			    		$("#modal").modal('show');
			    		$("#loading").hide();
		        	}	    	
		    	}).error(function (data, status, header, config) {		            	
		    		acess.alertModal = 'alert-danger';
		    		acess.btnModal = 'btn-danger';
		        	acess.modalHeader = 'Atenção:'; 
		    		acess.modalBody = 'Ocorreu um erro no servidor, tente novamente mais tarde!';
		    		acess.modalFooter = 'Fechar';
		    		$("#modal").modal('show');
		    		$("#loading").hide();
		    	});
	    	
			
			
			//ConstroiGraficoDeSessoesUsuario(sessionStorage.getItem("id"), acess.anoCorrente, $http, acess);
			
			
			
			
	            
			
		}]);
	</script>
<!-- ANGULAR JS -->

<!-- Gráficos -->
	<script type="text/javascript">
		
	</script>
	
	
<!-- Gráficos -->
