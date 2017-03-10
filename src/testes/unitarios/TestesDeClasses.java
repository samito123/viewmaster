package testes.unitarios;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.unitarios.controle.servlet.ControleDeRetornoServletTest;
import testes.unitarios.controle.servlet.usuario.LogarUsuarioTest;
import testes.unitarios.controle.servlet.usuario.ServletUsuarioTest;

@RunWith(Suite.class)
@SuiteClasses({
	ServletUsuarioTest.class,
	LogarUsuarioTest.class,
	ControleDeRetornoServletTest.class
})
public class TestesDeClasses {
	
}
