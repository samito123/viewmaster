<nav class="pushy pushy-left">
    <ul>
        <li class="pushy-link">
        	<a href="agenda">
        		<img width="20" class="simple-tooltip" 
		  		src="imagens/icones/menu/appointment_book_ico.png" 
		  		title="Nesse modulo é possível consultar, editar, excluir e adicionar agendamentos!"/> 
	  			Agenda
			</a>
		</li>
		<li class="pushy-link">
        	<a href="clientes">
        		<img width="20" class="simple-tooltip" 
		  		src="imagens/icones/menu/client_ico.png" 
		  		title="Nesse modulo é possível consultar, editar, excluir e adicionar clientes!"/> 
	  			Agenda
			</a>
		</li>
		<li class="pushy-link">
        	<a href="receitas">
        		<img width="20" class="simple-tooltip" 
		  		src="imagens/icones/menu/recipes_ico.png" 
		  		title="Nesse modulo é possível consultar, editar, excluir e adicionar receitas!"/> 
	  			Receitas
			</a>
		</li>
		<li class="pushy-link">
        	<a href="produtos">
        		<img width="20" class="simple-tooltip" 
		  		src="imagens/icones/menu/products_ico.png" 
		  		title="Nesse modulo é possível consultar, editar, excluir e adicionar produtos!"/> 
	  			Produtos
			</a>
		</li>
		<li class="pushy-link">
        	<a href="estoque">
        		<img width="20" class="simple-tooltip" 
		  		src="imagens/icones/menu/stock_ico.png" 
		  		title="Nesse modulo é possível consultar, dar entrada e saida nos produtos do estoque!"/> 
	  			Estoque
			</a>
		</li>
		<li class="pushy-link">
        	<a href="estoque">
        		<img width="20" class="simple-tooltip" 
		  		src="imagens/icones/menu/sales_ico.png" 
		  		title="Nesse modulo é possível consultar, editar, excluir e adicionar vendas!"/> 
	  			Vendas
			</a>
		</li>
		<li class="pushy-link">
        	<a href="contas">
        		<img width="20" class="simple-tooltip" 
		  		src="imagens/icones/menu/finances_ico.png" 
		  		title="Nesse modulo é possível consultar, adicionar e excluir contas a receber e contas a pagar!"/> 
	  			Contas
			</a>
		</li>
		<li class="pushy-link">
        	<a href="#">
        		<img width="20" class="simple-tooltip" 
		  		src="imagens/icones/menu/config_ico.png" 
		  		title="Nesse modulo é possível editar configurações pessoais do sistema!"/> 
	  			Configurações
			</a>
		</li>
		<li class="pushy-link">
        	<a href="Login">
        		<img width="20" class="simple-tooltip" 
		  		src="imagens/icones/menu/logout_ico.png" 
		  		title="Sair do sistema!"/> 
	  			Logout
			</a>
		</li>
    </ul>
</nav>
<!-- Site Overlay -->
<div class="site-overlay"></div>

<header>
	<div style="padding: 8px">	
				
		<button class="btn btn-primary menu-btn botao_de_menu">
			&#9776;
		</button>
		
		<p class="titulo_de_menu titulo_menu_animacao">
			 {{vm.tituloDoMenu}}
		</p>
		
		<a href="Login">
			<img width="30" src="imagens/icones/menu/logout_ico.png" title="Logout" />
	  	</a> 	
		<a>
			<img width="30" src="imagens/icones/menu/user_ico.png" title="{{vm.user}}" />
	  	</a> 	
	</div>
</header>

