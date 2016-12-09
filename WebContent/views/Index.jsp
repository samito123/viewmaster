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
	<body ng-controller="login as lg">
		<!-- Loading -->
			<div id="loading" class="popup_loading" style="display: none;"> 
				<img src="imagens/gifs/loading.gif" class="img_loader"/>
			</div>
		<!-- Fim loading -->
		
		
		<!-- ANGULAR JS -->
		<script type="text/javascript">
			var app = angular.module('vmApp',[] )
				app.controller('login', ['$http',function($http){
					
				}]);
		</script>
	<!-- ANGULAR JS -->
	</body>
</html>