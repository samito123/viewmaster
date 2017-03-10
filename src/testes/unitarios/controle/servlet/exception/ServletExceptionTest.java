package testes.unitarios.controle.servlet.exception;

import javax.servlet.http.HttpServletResponse;

import controle.servlet.ControleDeRetornoServlet;

public class ServletExceptionTest extends Exception {

	public ServletExceptionTest(String erro, String mensagemErro, HttpServletResponse response) {
		System.out.println("Test-"+erro);
	}
}
