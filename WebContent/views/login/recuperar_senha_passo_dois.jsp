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
					
						<button class="btn caixa_ok" ng-click="vm.VoltarParaPassoUm()">
							1° Passo
						</button>
				
						<button class="btn caixa_play" disabled>
							2° Passo
						</button>
	
						<button class="btn caixa_off" disabled>
							3° Passo
						</button>
	
						<button class="btn caixa_off" disabled>
							4° Passo
						</button>
					
					<form ng-submit="vm.VerificacaoEmailDataDeNascimento()" name="form">		
						<div class="caixa_de_descricao">
							<h3>
								Informe seus dados
							</h3>
							
							<div>
								<input class="input_para_passos"  type="email" placeholder="Email..." title="Email" 
								class="form-control" ng-model="vm.email" required/>
							</div>
							<div>
								<input class="input_para_passos" type="date" placeholder="Data de nascimento..." 
								title="Data de nascimento" class="form-control" ng-model="vm.dataNascimento" required>
							</div>
							
						</div>
			
						<button class="btn btn-primary botao_de_controle_de_fluxo_1" type="submit">
							Próximo
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
	<script type="text/javascript" charset="UTF-8">
		var app = angular.module('vmApp',[] )
		app.controller('ViewMaster', ['$http',function($http){
			
			var acess = this;
			
			acess.VoltarParaPassoUm = function() {
				$("#loading").show();
				window.location.href="RecuperarSenhaPassoUm";
			};
			
			acess.CancelarRecuperacaoDeSenha = function() {
				$("#loading").show();
				window.location.href="Login";
			};

			acess.VerificacaoEmailDataDeNascimento = function(){
				$("#loading").show();
				
				var DataFormatada = acess.dataNascimento.toLocaleDateString();
				DataFormatada = DataFormatada.replace('/', '-').replace('/', '-');

        		var variaveis = "?metodo=VerificacaoEmailDataDeNascimento&email="+acess.email
        				+"&data_nascimento="+DataFormatada;
        		
	            $http.post('RecuperaSenha'+variaveis)
		            .success(function (data, status, headers, config) {	
		            	console.log('Data:', data);
		            	if(data == "erro"){
		            		MensagemDeErroModal('Email informado não corresponde com data de nascimento informada!');
		            	}else{
		            		CriaSessaoDeRecuperacaoDeSenha(data);		    
		     			}        
	            })
		            .error(function (data, status, header, config) {	
		            	MensagemDeErroModal('Ocorreu um erro no servidor, tente novamente mais tarde!');
	            });
	        };
	       
	        function CriaSessaoDeRecuperacaoDeSenha(data) {
	        	sessionStorage.setItem("id_usuario", data.id_usuario);
        		sessionStorage.setItem("login_usuario", data.login_usuario);
        		sessionStorage.setItem("email_usuario", data.email_usuario);
        		sessionStorage.setItem("data_nascimento_usuario", data.data_nascimento_usuario);	
        		sessionStorage.setItem("pergunta_secreta_usuario", data.pergunta_secreta_usuario);
				sessionStorage.setItem("resposta_pergunta_secreta_usuario", data.resposta_pergunta_secreta_usuario);
        		sessionStorage.setItem("rc_step_3", "Y");
        		DirecionaFluxoParaPassoTres();
			}	
	        
	        function DirecionaFluxoParaPassoTres() {
	        	window.location.href="RecuperarSenhaPassoTres";
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