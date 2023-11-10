package testPersistencia;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import persistencia.PersistenciaXML;

public class TestPersistenciaConArchivo {
	
	private Agencia a;
	private PersistenciaXML pers;
	
	
	@Before
	public void setUp() throws Exception {
		a = Agencia.getInstance();
		a.setLimitesRemuneracion(2000, 5000);
		a.setEmpleados(new HashMap<String, EmpleadoPretenso>());
		a.setEmpleadores(new HashMap<String, Empleador>());
		pers = new PersistenciaXML();
		
		a.setPersistencia(pers);
		a.guardarAgencia("Agencia.xml");
	}

	@After
	public void tearDown() throws Exception {
		
	}


	@Test
	public void testPersistenciaDatos() {
		try {
			a.cargarAgencia("Agencia.xml");
		} catch (ClassNotFoundException | IOException e) {
		}
		
		assertTrue("La lista debiera estar vacia", a.getEmpleados().size() == 0);
		assertTrue("El límite superior no es el esperado", a.getLimiteSuperior() == 5000);
		assertTrue("El límite inferior no es el esperado", a.getLimiteInferior() == 2000);
	}
	
}
