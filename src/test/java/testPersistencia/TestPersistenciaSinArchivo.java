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
import persistencia.PersistenciaXML;

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
			PersistenciaXML persistencia = new PersistenciaXML();
			persistencia.abrirOutput("Agencia.xml");
			a.guardarAgencia("Agencia.xml");
			File arch = new File("Agencia.xml");
			persistencia.cerrarOutput();
			assertTrue("Debería existir el archivo Agencia.xml", arch.exists());	
		} catch (IOException e) {
			fail("No deberia lanzar excepcion");
		}
		
	}
	
	
	@Test
	public void testDespersistirSinArchivo() {
		try {
			assertTrue("No se deberia haber cargado una agencia, no existe el archivo", !(a.cargarAgencia("Agencia.xml")));
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}	
}
