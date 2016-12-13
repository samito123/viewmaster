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
	
		<%@include  file="login/imports/HeadLoginImports.jsp" %>
		
	</head>
	<body ng-controller="login as lg">
		<!-- Loading -->
			<div id="loading" class="popup_loading" style="display: none;"> 
				<img src="imagens/gifs/loading.gif" class="img_loader"/>
			</div>
		<!-- Fim loading -->
		
		<script>
			//Torna a div visível
			document.getElementById("loading").style.display = "block";
			$("#loading").hide();
		</script> 
		
		<!-- Modal -->
			<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
				   <div class="modal-content">
					 <div class="modal-header">
					 	<button type='button' class='close' data-dismiss='modal' aria-label='Close'>
					 		<span aria-hidden='true'>&times;</span>
				 		</button>
						<h4 class='modal-title' id='myModalLabel'>
							{{lg.modalHeader}}
						</h4>
					 </div>
					 <div class="modal-body">
						<div class='alert {{lg.alertModal}}'>
							<ul>
								{{lg.modalBody}}
							</ul>
						</div>
					 </div>
					 <div class="modal-footer">
					 	<button type='button' class='btn {{lg.btnModal}}' ng-click="lg.voltarLogin()" data-dismiss='modal'>
					 		{{lg.modalFooter}}
					 	</button>
					 </div>
				   </div>
				</div>
			</div>	
		<!-- Fim Modal -->
		
		<div class="container"> 
	
			<div class="content"> 
				<!-- Corpo -->
					<script type="text/javascript">
						//sessionStorage.removeItem('user_log');
						//sessionStorage.removeItem('rc_step_3');
						sessionStorage.clear();
					</script>
					<div class="box_login">
						
						<img class="header-elemento-img" 
						src="imagens/icones/menu/logo_ico_32dp.png"/>
							
						<p class="animaTituloMenuFlash">View Master</p>
						
						<hr width="98%"/>
						
						<div class="titulo_box_login">
							Entre com os seus dados corretamente para acessar o sistema			
						</div>
						
						<form ng-submit="lg.LogarUsuario()" name="form">		
							<input type="text" style="margin: 15px 20% 15px 20%; width: 60%;" 
							placeholder="Digite seu login..." class="form-control" ng-model="lg.login" required maxlength="50">		
							
							<input  type="password" style="margin: 15px 20% 15px 20%; width: 60%;" 
							placeholder="Digite sua senha..." class="form-control" ng-model="lg.pass" required maxlength="50">
							
							<div>
								<button type="submit" style="width: 30%; margin: 0 0 15px 0;" 
								class="btn btn-primary">Entrar</button>
							</div>
							
							<div>
								<a href="usuario/recuperar/senha/step/one" ng-click="lg.loading()"> 
						 			Recuperar Senha	
							 	</a>
						 	</div>
						 				
						</form>		
					</div>
				<!-- Fim Corpo -->		
			
			</div>
			
		</div>
			
	</body>
</html>

	<!-- Animação letras -->
		<script type="text/javascript">
			$(function () {
				$('.animaTituloMenuFlash').textillate({      
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
	
				//Fecha a tela de loading inicial
				$("#loading").hide();
			});
		</script>
	<!-- Fim Animação letras -->
		
	<!-- ANGULAR JS -->
		<script type="text/javascript">
			var app = angular.module('vmApp',[] )
			app.controller('login', ['$http',function($http){
				
				var acess = this;
				
				acess.LogarUsuario = function(){
					$("#loading").show();
					
					//var variaveis = '{"login_usuario":"'+acess.login+'","senha_usuario":"'+acess.pass+'"}'
					var variaveis = "?metodo=VerificaLoginDoUsuario&login="+acess.login+"&senha="+acess.pass;
					
					$http.post('LoginUsuario'+variaveis)
			            .success(function (data, status, headers, config) {				  
			            	console.log(data);
			            	if(data == "N"){
			            		console.log("msn erro");
			            		acess.alertModal = 'alert-danger';
			            		acess.btnModal = 'btn-danger';
			            		acess.modalHeader = 'Atenção:'; 
			            		acess.modalBody = 'Usuário ou senha está incorreto!';
			            		acess.modalFooter = 'Fechar';
			            		$("#modal").modal('show');
			            		$("#loading").hide();
			            	}else{	
			            		console.log("logar");
			            		$("#loading").hide();
			            		//sessionStorage.setItem("id", data.usuario[0].id_usuario);
			            		//sessionStorage.setItem("user", data.usuario[0].nome_usuario);
			            		//sessionStorage.setItem("user_log", "Y");
			            		//window.location.assign("principal");
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
				};
			}]);	
		</script>
	<!-- ANGULAR JS -->
	</body>
</html>