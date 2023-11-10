package testPersistencia;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import persistencia.PersistenciaXML;
import util.Constantes;

public class TestPersistenciaConArchivoLleno {
	
	
	private Agencia a;
	private PersistenciaXML pers;
	
	@Before
	public void setUp() throws Exception {
		a = Agencia.getInstance();
		a.setEmpleados(new HashMap<String, EmpleadoPretenso>());
		a.setEmpleadores(new HashMap<String, Empleador>());
		pers = new PersistenciaXML();
		this.llenaListas(a);
		a.setPersistencia(pers);
		a.guardarAgencia("Agencia.xml");
	}
	

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testPersistenciaListasLlenas() {
		try {
			a.cargarAgencia("Agencia.xml");
		} catch (ClassNotFoundException | IOException e) {
		}
		assertTrue("La lista de empleados deberia tener 4 empleados", a.getEmpleados().size() == 4);
		assertTrue("La lista de empleadores deberia tener 3 empleados", a.getEmpleadores().size() == 3);
	}
	
	
	public void llenaListas(Agencia a) {
		EmpleadoPretenso empleado1 = new EmpleadoPretenso("Mati", "123456", "Matias", "2235825715", "Frangolini", 21);
		EmpleadoPretenso empleado2 = new EmpleadoPretenso("Fran", "123456", "Francisco", "2235825715", "Florio", 21);
		EmpleadoPretenso empleado3 = new EmpleadoPretenso("Pedro", "123456", "Pedro", "2235825715", "Iarritu", 21);
		EmpleadoPretenso empleado4 = new EmpleadoPretenso("Berni", "123456", "Bernardo", "2235825715", "Porfilio", 21);
		
		Empleador empleador1 = new Empleador("Mati", "123456", "Matias", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		Empleador empleador2 = new Empleador("Fran", "123456", "Francisco", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		Empleador empleador3 = new Empleador("Pedro", "123456", "Pedro", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		
		a.getEmpleados().put("Mati", empleado1);
		a.getEmpleados().put("Fran", empleado2);
		a.getEmpleados().put("Pedro", empleado3);
		a.getEmpleados().put("Berni", empleado4);
		
		a.getEmpleadores().put("Mati", empleador1);
		a.getEmpleadores().put("Fran", empleador2);
		a.getEmpleadores().put("Pedro", empleador3);
	}

}
