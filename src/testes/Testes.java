package testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.integracao.dao.SessoesDeUsuarioDAOTest;
import testes.integracao.dao.UltimaSessaoUsuarioDAOTest;
import testes.integracao.dao.UsuarioDAOTest;
import testes.unitarios.controle.servlet.ControleDeRetornoServletTest;
import testes.unitarios.controle.servlet.usuario.LogarUsuarioTest;
import testes.unitarios.controle.servlet.usuario.ServletUsuarioTest;

@RunWith(Suite.class)
@SuiteClasses({
	ServletUsuarioTest.class,
	LogarUsuarioTest.class,
	ControleDeRetornoServletTest.class,
	UsuarioDAOTest.class,
	SessoesDeUsuarioDAOTest.class,
	UltimaSessaoUsuarioDAOTest.class
})
public class Testes {

}
