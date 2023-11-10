package TestAplicaPromo;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloNegocio.Agencia;

public class TestUtilPromo {
	
	private Agencia a;
	private EscenarioListasConDatos escDatos;
	private EscenarioListasVacias escVacio;

	@Before
	public void setUp() throws Exception {
		a = Agencia.getInstance();
		escDatos = new EscenarioListasConDatos();
		escVacio = new EscenarioListasVacias();
	}

	@After
	public void tearDown() throws Exception {
	}


}
