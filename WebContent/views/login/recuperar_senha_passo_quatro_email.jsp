<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="vmApp">
	<head>
		<meta charset="utf-8">
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
		<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
		<meta name="viewport" content="width=device-width">
		
		<title>Sistema de gestão para o ramo óptico</title>
		<%@include  file="importacoes_login/head_recupera_senha_importacoes.jsp" %>
		
	</head>
	<body ng-controller="ViewMaster as vm">
		
		<%@include  file="../importacoes/loading.jsp" %>
		<%@include  file="../importacoes/modal_mensagens.jsp" %>
		
		<div class="container"> 
			<div class="content"> 
			
				<script type="text/javascript">
					if(sessionStorage.getItem("rc_step_4") != "Y"){
						window.location.assign("Login");
		    		}
					//sessionStorage.setItem("rc_step_4", "N");
				</script>
				
				<div class="caixa_recuperar_senha"> 
					
						<button class="btn caixa_ok" ng-click="vm.VoltarParaPassoUm()">
							1° Passo
						</button>
				
						<button class="btn caixa_ok" ng-click="vm.VoltarParaPassoDois()">
							2° Passo
						</button>
	
						<button class="btn caixa_ok" ng-click="vm.VoltarParaPassoTres()">
							3° Passo
						</button>
	
						<button class="btn caixa_play" disabled>
							4° Passo
						</button>
					
					<form ng-submit="vm.VerificacaoEmailDataDeNascimento()" name="form">		
						<div class="caixa_de_descricao">
						
							<h3>
								Confirmar envio
							</h3>
							
							<p style="margin: 50px 10px 50px 10px">Atenção usuário 
								{{vm.usuario}}, para confirmar o envio da nova senha para o email 
								{{vm.email}} clique em finalizar e aguarde!
							</p>	
							
						</div>
			
						<button class="btn btn-success botao_de_controle_de_fluxo_1" ng-click="vm.Finalizar()">
							Finalizar
						</button>
					</form>
					
					<button class="btn btn-primary botao_de_controle_de_fluxo_2" ng-click="vm.VoltarParaPassoUm()">
						Anterior
					</button>
					<button class="btn btn-danger botao_de_controle_de_fluxo_2" ng-click="vm.CancelarRecuperacaoDeSenha()">
						Cancelar
					</button>
					
				</div>
				
			</div>	
		</div>
			
	</body>
</html>

<!-- ANGULAR JS -->
	<script type="text/javascript">
		var app = angular.module('vmApp',[] )
		app.controller('ViewMaster', ['$http',function($http){
			
			var acess = this;
			
			acess.usuario = sessionStorage.getItem("login_usuario");
			acess.email = sessionStorage.getItem("email_usuario");
			
			acess.VoltarParaPassoUm = function() {
				$("#loading").show();
				window.location.href="RecuperarSenhaPassoUm";
			};
			
			acess.VoltarParaPassoDois = function() {
				$("#loading").show();
				window.location.href="RecuperarSenhaPassoDois";
			};
			
			acess.VoltarParaPassoTres = function() {
				$("#loading").show();
				window.location.href="RecuperarSenhaPassoTres";
			};	
			
			acess.CancelarRecuperacaoDeSenha = function() {
				$("#loading").show();
				window.location.href="Login";
			};
			
			acess.Finalizar = function(){
				$("#loading").show();
				var senha = "";
				for (i = 0; i < 8; i++) { 
					senha += Math.floor(Math.random() * 10);
				}
				
				var variaveis = "?metodo=EnviarNovaSenhaPorEmail&id="+sessionStorage.getItem("id_usuario")
				+"&senha="+senha
				+"&email="+sessionStorage.getItem("email_usuario")
				+"&login="+sessionStorage.getItem("login_usuario");
				
				$http.post('RecuperaSenha'+variaveis)
	            .success(function (data, status, headers, config) {		
	             console.log('Data:', data);		                		  
	            	if(data == "S"){
	            		$("#loading").hide();
	            	}else{
	            		$("#loading").hide();
	            	}      
	            })
		            .error(function (data, status, header, config) {	
		            	$("#loading").hide();
	            });	
			};
			

	        function MensagemDeErroModal(Mensagem) {
	        	acess.alertModal = 'alert-danger';
				acess.btnModal = 'btn-danger';
            	acess.modalHeader = 'Atenção:'; 
        		acess.modalBody = Mensagem;
        		acess.modalFooter = 'Fechar';
        		$("#modal").modal('show');
        		$("#loading").hide();
			}	
	        
			$("#loading").hide();
		}]);	
	</script>
<!-- ANGULAR JS -->

</html>