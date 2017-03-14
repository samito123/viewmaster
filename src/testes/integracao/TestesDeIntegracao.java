package testes.integracao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.integracao.dao.SessoesDeUsuarioDAOTest;
import testes.integracao.dao.UltimaSessaoUsuarioDAOTest;
import testes.integracao.dao.UsuarioDAOTest;

@RunWith(Suite.class)
@SuiteClasses({
	UsuarioDAOTest.class,
	SessoesDeUsuarioDAOTest.class,
	UltimaSessaoUsuarioDAOTest.class
})
public class TestesDeIntegracao {

}
