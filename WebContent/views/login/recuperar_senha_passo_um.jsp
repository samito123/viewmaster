<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="vmApp">
	<head>
		<meta charset="utf-8">
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
		<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
		<meta name="viewport" content="width=device-width">
		
		<title>Sistema de gest�o para o ramo �ptico</title>
		<%@include  file="importacoes_login/head_recupera_senha_importacoes.jsp" %>
		
	</head>
	<body ng-controller="login as lg">
		
		<%@include  file="../importacoes/loading.jsp" %>
		<%@include  file="../importacoes/modal_mensagens.jsp" %>
		
		<div class="container"> 
			<div class="content"> 
				
				<div class="content_recuperar_senha_explicacao"> 
					
						<button class="btn btn-primary box_step_play" ng-click="lg.step1()" disabled>
							1� Passo
						</button>
				
						<button class="btn btn-primary box-steps-off" disabled>
							2� Passo
						</button>
	
						<button class="btn btn-primary box-steps-off" disabled>
							3� Passo
						</button>
	
						<button class="btn btn-primary box-steps-off" disabled>
							4� Passo
						</button>
							
					<div class="box_descricao_step_one">
						
						<h3>
							Informativo
						</h3>
						
						<p>
							Esqueceu sua senha! Sem problemas, voc� pode gerar uma nova senha em alguns passos:
						</p>
						<ul>
							<li>
								Passo 1: Voc� j� est� nele, � apenas um informativo!
							</li>
							<li>
								Passo 2: Voc� vai precisar informar o seu email e sua data de nascimento!
							</li>
							<li>
								Passo 3: Escolha o m�todo de recupera��o de senha!
							</li>
							<li>
								Passo 4.1: (Pergunta secreta) Responda a pergunta secreta e finalize o procedimento, voc� recebera uma nova senha!
							</li>
							<li>
								Passo 4.2: (Email) Uma nova senha ser� enviada para o seu email!
							</li>
						</ul>
					</div>
		
					<button class="btn btn-primary botao_de_controle_de_fluxo_1" ng-click="lg.proximo()">
						Pr�ximo
					</button>
					<button class="btn btn-danger botao_de_controle_de_fluxo_2" ng-click="lg.cancel()">
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
		app.controller('login', ['$http',function($http){
			
			var acess = this;
			
			acess.cancel = function() {
				$("#loading").show();
				window.location.href="/viewmaster/public";
			};

			acess.proximo = function() {
				$("#loading").show();
				window.location.href="two";
			};
			
			$("#loading").hide();
		}]);	
	</script>
<!-- ANGULAR JS -->

</html>