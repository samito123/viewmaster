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
		<%@include  file="importacoes_login/head_login_importacoes.jsp" %>
		
	</head>
	<body ng-controller="ViewMaster as vm">
		
		<%@include  file="../importacoes/loading.jsp" %>
		<%@include  file="../importacoes/modal_mensagens.jsp" %>
		
		<div class="container"> 
			<div class="content"> 
		
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
							<input type="text" style="margin: 15px 20% 15px 20%; width: 60%;" 
							placeholder="Digite seu login..." class="form-control" ng-model="vm.login" required maxlength="50">		
							
							<input  type="password" style="margin: 15px 20% 15px 20%; width: 60%;" 
							placeholder="Digite sua senha..." class="form-control" ng-model="vm.pass" required maxlength="50">
							
							<div>
								<button type="submit" style="width: 30%; margin: 0 0 15px 0;" 
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
		</div>
			
	</body>
</html>

<!-- Anima��o letras -->
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
<!-- Fim Anima��o letras -->
	
<!-- ANGULAR JS -->
	<script type="text/javascript">
		var app = angular.module('vmApp',[] )
		app.controller('ViewMaster', ['$http',function($http){
			
			var acess = this;
			
			acess.LogarUsuario = function(){
				$("#loading").show();
				
				var variaveis = "?metodo=VerificaLoginDoUsuario&login="+acess.login+"&senha="+acess.pass;
				
				$http.post('LogarUsuario'+variaveis)
		            .success(function (data, status, headers, config) {				  
		            	if(data == "erro"){
		            		acess.alertModal = 'alert-danger';
		            		acess.btnModal = 'btn-danger';
		            		acess.modalHeader = 'Aten��o:'; 
		            		acess.modalBody = 'Usu�rio ou senha est� incorreto!';
		            		acess.modalFooter = 'Fechar';
		            		$("#modal").modal('show');
		            		$("#loading").hide();
		            	}else{							
		            		sessionStorage.setItem("id", data.id_usuario);
		            		sessionStorage.setItem("user", data.nome_usuario);
		            		sessionStorage.setItem("user_log", "Y");
		            		window.location.assign("views/principal/graficos.jsp");
		            	}	    	
	            	}).error(function (data, status, header, config) {		            	
	            		acess.alertModal = 'alert-danger';
	            		acess.btnModal = 'btn-danger';
		            	acess.modalHeader = 'Aten��o:'; 
	            		acess.modalBody = 'Ocorreu um erro no servidor, tente novamente mais tarde!';
	            		acess.modalFooter = 'Fechar';
	            		$("#modal").modal('show');
	            		$("#loading").hide();
	            	});
			};
		}]);	
	</script>
<!-- ANGULAR JS -->

</html>