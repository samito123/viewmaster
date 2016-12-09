<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head ng-app="vmApp">
		<meta charset="utf-8">
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
		<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
		<meta name="viewport" content="width=device-width">
		
		<title>Sistema de gestão para o ramo óptico</title>
	
		<%@include  file="login/imports/HeadLoginImports.jsp" %>
		
	</head>
	<body class="lalal" ng-controller="login as lg">
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
							@{{lg.modalHeader}}
						</h4>
					 </div>
					 <div class="modal-body">
						<div class='alert @{{lg.alertModal}}'>
							<ul>
								@{{lg.modalBody}}
							</ul>
						</div>
					 </div>
					 <div class="modal-footer">
					 	<button type='button' class='btn @{{lg.btnModal}}' ng-click="lg.voltarLogin()" data-dismiss='modal'>
					 		@{{lg.modalFooter}}
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
					<div style="text-align: center;" class="box_login">
						
						<img class="header-elemento-img" 
						src="imagens/icones/menu/logo_ico_32dp.png"/>
							
						<p class="animaTituloMenuFlash">View Master</p>
						
						<hr width="98%"/>
						
						<div class="espacamento">
							Entre com os seus dados corretamente para acessar o sistema			
						</div>
						
						<form ng-submit="lg.submit()" name="form">		
							<input type="text" style="margin: 15px 0 15px 0; width: 60%;" 
							placeholder="Digite seu login..." class="form-control" ng-model="lg.login" required maxlength="50">		
						</form>
						<!-- ><div class="content-login">	  
							
								<div class="box-login-elementos">
									<div class="spacing">
										Entre com os seus dados corretamente para acessar o sistema			
									</div>
									<form ng-submit="lg.submit()" name="form">		
										
										<input type="hidden" id="token" ng-model="lg.token" value="{{ csrf_token() }}">				
										<div>
											<input  type="text" style="margin: 15px 0 15px 0; width: 60%;" 
												 placeholder="Digite seu login..." class="form-control" ng-model="lg.login" required maxlength="50">
										</div>
										<div>
											<input  type="password" style="margin: 15px 0 15px 0; width: 60%;" 
												placeholder="Digite sua senha..." class="form-control" ng-model="lg.pass" required maxlength="50">
										</div>
			
										<div>							
											<button  type="submit" class="btn btn-primary">Entrar</button>							
										</div>
			
										<div class="spacing-a">
											<a href="usuario/recuperar/senha/step/one" ng-click="lg.loading()"> 
										 		Recuperar Senha	
										 	</a>		
										</div>	
			
									</form>	
								</div>
							</article>
					
						</div>
					</div> -->
					
				<!-- Fim Corpo -->		
			
			</div>
			
		</div>
			
	</body>
</html>

	<!-- Animação letras -->
		<script type="text/javascript">
		$("#loading").hide();
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
					
				}]);
		</script>
	<!-- ANGULAR JS -->
	</body>
</html>