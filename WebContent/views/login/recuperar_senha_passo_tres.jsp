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
					if(sessionStorage.getItem("rc_step_3") != "Y"){
						window.location.assign("Login");
		    		}
					sessionStorage.setItem("rc_step_3", "N");
				</script>
				
				<div class="caixa_recuperar_senha"> 
					
						<button class="btn caixa_ok" ng-click="vm.VoltarParaPassoUm()">
							1° Passo
						</button>
				
						<button class="btn caixa_ok" ng-click="vm.VoltarParaPassoDois()">
							2° Passo
						</button>
	
						<button class="btn caixa_play" disabled>
							3° Passo
						</button>
	
						<button class="btn caixa_off" disabled>
							4° Passo
						</button>
					
					<form ng-submit="vm.VerificacaoEmailDataDeNascimento()" name="form">		
						<div class="caixa_de_descricao">
						
							<h3>
								{{vm.usuario}}, selecione o método desejado
							</h3>
						
							<fieldset style="font-size: 0.8em;">
		                        <input type="radio" value="0" ng-model="vm.metodoSelecionado" style="margin: 10px 0 10px 10px;"/> Email<br />
		                        <input type="radio" value="1" ng-model="vm.metodoSelecionado" style="margin: 10px 0 30px 10px;"/> Pergunta secreta<br />
				        	</fieldset>	
							
						</div>
			
						<button class="btn btn-primary botao_de_controle_de_fluxo_1" ng-click="vm.RecuperaSenhaPorMetodoSelecionado()">
							Próximo
						</button>
					</form>
					
					<button class="btn btn-primary botao_de_controle_de_fluxo_2" ng-click="vm.VoltarParaPassoDois()">
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
			
			acess.VoltarParaPassoUm = function() {
				$("#loading").show();
				window.location.href="RecuperarSenhaPassoUm";
			};
			
			acess.VoltarParaPassoDois = function() {
				$("#loading").show();
				window.location.href="RecuperarSenhaPassoDois";
			};
			
			acess.CancelarRecuperacaoDeSenha = function() {
				$("#loading").show();
				window.location.href="Login";
			};
			
			acess.RecuperaSenhaPorMetodoSelecionado = function(){
				$("#loading").show();

				if(acess.metodoSelecionado == 0){
					RecuperaMensagemPorEmail();
				}else if(acess.metodoSelecionado == 1){
					RecuperaMensagemPorPerguntaSecreta();
				}else{
					MensagemDeErroModal('Nenhuma opção foi selecionada!');
				}		
	        };	
	        
	        function RecuperaMensagemPorEmail() {
	        	sessionStorage.setItem("rc_step_4", "Y");
				sessionStorage.setItem("rc_step_3", "Y");
         		window.location.href="TelaRecuperarSenhaPassoQuatroPorEmail";
			}	
	        
	        function RecuperaMensagemPorPerguntaSecreta() {
	        	sessionStorage.setItem("rc_step_4", "Y");	
				sessionStorage.setItem("rc_step_3", "Y");
				window.location.href="TelaRecuperarSenhaPassoQuatroPorPergunta";
			}	

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