package testPersistencia;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import modeloNegocio.Agencia;

public class TestPersistenciaSinArchivo {
	
	Agencia a;
	
	@Before
	public void setUp() throws Exception {
		a = Agencia.getInstance();
		File arch = new File("Agencia.xml");
		if (arch.exists()) {
			arch.delete();
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrearArchivo() {
		try {
			try {
				a.setLimitesRemuneracion(1000, 3000);
			} catch (LimiteSuperiorRemuneracionInvalidaException | LimiteInferiorRemuneracionInvalidaException e) {
			}
			a.guardarAgencia("Agencia.xml");
			File arch = new File("Agencia.xml");
			assertTrue("Debería existir el archivo Agencia.xml", arch.exists());
		} catch (IOException e) {
			fail("No deberia lanzar excepcion");
		}
		
	}

}
