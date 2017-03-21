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
		<%@include  file="importacoes_login/head_login_importacoes.jsp" %>
		
	</head>
	<body ng-controller="ViewMaster as vm">
		
		<%@include  file="../importacoes/loading.jsp" %>
		<%@include  file="../importacoes/modal_mensagens.jsp" %>
		
		<div class="container"> 
			
			<script type="text/javascript">
				sessionStorage.clear();
			</script>
			
			<div class="box_login">			
				<img class="logo_imagem_box_login" 
				src="imagens/icones/menu/logo_ico_32dp.png"/>
					
				<p class=titulo_login_animacao>View Master</p>
				
				<hr width="98%"/>
				
				<div class="titulo_box_login">
					Entre com os seus dados corretamente para acessar o sistema			
				</div>
				
				<form ng-submit="vm.LogarUsuario()" name="form">		
					<input type="text" id="text" ng-model="vm.text" hidden="true">		
				
					<input type="text" id="login" style="margin: 15px 20% 15px 20%; width: 60%;" 
					placeholder="Digite seu login..." class="form-control" ng-model="vm.login" required maxlength="50">		
					
					<input  type="password" id="pass" style="margin: 15px 20% 15px 20%; width: 60%;" 
					placeholder="Digite sua senha..." class="form-control" ng-model="vm.pass" required maxlength="50">
					
					<div>
						<button type="submit" id="entrar" style="width: 30%; margin: 0 0 15px 0;" 
						class="btn btn-primary">Entrar</button>
					</div>
					
					<div>
						<a href="RecuperarSenhaPassoUm" ng-click="vm.loading()"> 
				 			Recuperar Senha	
					 	</a>
				 	</div>
				 				
				</form>		
			</div>
		
		</div>
			
	</body>
</html>

<!-- Animação letras -->
	<script type="text/javascript">
		$(function () {
			$('.titulo_login_animacao').textillate({      
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
		var app = angular.module('vmApp',[] )
		app.controller('ViewMaster', ['$http',function($http){
			
			var acess = this;

			acess.LogarUsuario = function(){
				$("#loading").show();
				var variaveis = "?metodo=LogarUsuario&login="+acess.login+"&senha="+acess.pass;
				$http.post('ServletUsuario'+variaveis)
	            .success(function (data, status, headers, config) {
	            	if(data.substring(0, 4) == "Erro"){
	            		MensagemDeErroModal(data.substring(6));
	            	}else{
	            		GuardarSessaoUsuario(data);
	            		//MensagemDeErroModal(data);
	            	}	    	
	            	GuardarSessaoUsuario(data);
            	}).error(function (data, status, header, config) {		            	
            		MensagemDeErroModal("Ocorreu um erro no servidor, erro: "+status);
            	});
			};
			
			function GuardarSessaoUsuario(usuario){
				sessionStorage.setItem("id_usuario_logado", usuario.id_usuario);
        		sessionStorage.setItem("usuario", usuario.nome_usuario);
        		sessionStorage.setItem("usuario_logado", "Y");
        		DirecionarFluxoParaTelaDeGraficos();
			};
			
			function DirecionarFluxoParaTelaDeGraficos(){
				window.location.assign("TelaPrincipal");
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

</html>