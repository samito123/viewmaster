package controle.servlet.exception;

import javax.servlet.http.HttpServletResponse;

import controle.servlet.ControleDeRetornoServlet;

public class ServletException extends Exception {

	public ServletException(String erro, String mensagemErro, HttpServletResponse response) {
		System.out.println(erro);
		new ControleDeRetornoServlet(response)
		.RetornaErro("Erro: "+mensagemErro);
	}
}
