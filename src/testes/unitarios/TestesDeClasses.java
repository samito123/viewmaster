package testes.unitarios;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.unitarios.controle.conexao.ControleDeRetornoServidorTest;
import testes.unitarios.servlet.ServletUsuarioTest;

@RunWith(Suite.class)
@SuiteClasses({
	ServletUsuarioTest.class,
	ControleDeRetornoServidorTest.class
})
public class TestesDeClasses {
	
}
