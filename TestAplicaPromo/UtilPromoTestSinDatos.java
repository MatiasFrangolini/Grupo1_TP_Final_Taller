package TestAplicaPromo;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bin.modeloNegocio.Agencia;
import testModeloNegocio.EscenarioAgenciaConListasVacias;

public class UtilPromoTestSinDatos {
	
	private modeloNegocio.Agencia a;
	private EscenarioAgenciaConListasVacias esc;

	@Before
	public void setUp() throws Exception {
		esc = new EscenarioAgenciaConListasVacias();
		a = Agencia.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAplicaPromocamino1() {
		
	}

}
