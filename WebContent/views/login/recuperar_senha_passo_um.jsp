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
		<%@include  file="importacoes_login/head_recupera_senha_importacoes.jsp" %>
		
	</head>
	<body ng-controller="ViewMaster as vm">
		
		<%@include  file="../importacoes/loading.jsp" %>
		<%@include  file="../importacoes/modal_mensagens.jsp" %>
		
		<div class="container"> 
			<div class="content"> 
			
				<div class="caixa_recuperar_senha"> 
					
						<button class="btn caixa_play" disabled>
							1° Passo
						</button>
				
						<button class="btn caixa_off" disabled>
							2° Passo
						</button>
	
						<button class="btn caixa_off" disabled>
							3° Passo
						</button>
	
						<button class="btn caixa_off" disabled>
							4° Passo
						</button>
							
					<div class="caixa_de_descricao">
						
						<h3>
							Informativo
						</h3>
						
						<p>
							Esqueceu sua senha! Sem problemas, você pode gerar uma nova senha em alguns passos:
						</p>
						<ul>
							<li>
								Passo 1: Você já está nele, é apenas um informativo!
							</li>
							<li>
								Passo 2: Você vai precisar informar o seu email e sua data de nascimento!
							</li>
							<li>
								Passo 3: Escolha o método de recuperação de senha!
							</li>
							<li>
								Passo 4.1: (Pergunta secreta) Responda a pergunta secreta e finalize o procedimento, você recebera uma nova senha!
							</li>
							<li>
								Passo 4.2: (Email) Uma nova senha será enviada para o seu email!
							</li>
						</ul>
					</div>
		
					<button class="btn btn-primary botao_de_controle_de_fluxo_1" ng-click="vm.AvancarParaProximoPasso()">
						Próximo
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
		app.controller('ViewMaster', [function($http){
			
			var acess = this;
			
			acess.CancelarRecuperacaoDeSenha = function() {
				$("#loading").show();
				window.location.href="Login";
			};

			acess.AvancarParaProximoPasso = function() {
				$("#loading").show();
				window.location.href="RecuperarSenhaPassoDois";
			};
			
			$("#loading").hide();
		}]);	
	</script>
<!-- ANGULAR JS -->

</html>