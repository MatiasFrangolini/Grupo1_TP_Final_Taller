package testPersistencia;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import modeloDatos.EmpleadoPretenso;
import modeloNegocio.Agencia;
import persistencia.AgenciaDTO;
import persistencia.PersistenciaXML;
import persistencia.UtilPersistencia;

public class TestPersistenciaConArchivo {
	
Agencia a;
	
	@Before
	public void setUp() throws Exception {
		a = Agencia.getInstance();
		a.setLimitesRemuneracion(2000, 5000);
		a.setEmpleados(new HashMap<String,EmpleadoPretenso>());
		File arch = new File("Agencia.xml");
		PersistenciaXML pers = new PersistenciaXML();
		pers.abrirOutput("Agencia.xml");
		a.guardarAgencia("Agencia.xml");
		pers.cerrarOutput();
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testPersistenciaDatos() {
		Agencia ag2 = Agencia.getInstance();
		try {
			ag2.cargarAgencia("Agencia.xml");
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue("Los limites no son iguales", ag2.getLimiteInferior() == a.getLimiteInferior());
		assertTrue("Los limites no son iguales", ag2.getLimiteSuperior() == a.getLimiteSuperior());
		assertTrue("La lista debiera estar vacia", ag2.getEmpleados().size() == 0);
	}
	
	public void llenaLista(Agencia a) {
		EmpleadoPretenso empleado1 = new EmpleadoPretenso("Mati", "123456", "Matias", "2235825715", "Frangolini", 21);
		EmpleadoPretenso empleado2 = new EmpleadoPretenso("Fran", "123456", "Francisco", "2235825715", "Florio", 21);
		EmpleadoPretenso empleado3 = new EmpleadoPretenso("Pedro", "123456", "Pedro", "2235825715", "Iarritu", 21);
		EmpleadoPretenso empleado4 = new EmpleadoPretenso("Berni", "123456", "Bernardo", "2235825715", "Porfilio", 21);
		a.getEmpleados().put("Mati", empleado1);
		a.getEmpleados().put("Fran", empleado2);
		a.getEmpleados().put("Pedro", empleado3);
		a.getEmpleados().put("Berni", empleado4);
	}

	@Test
	public void testListaLlena() {
		Agencia a2 = a;
		this.llenaLista(a);
		try {
			a2.cargarAgencia("Agencia.xml");
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue("La listas deberian tener 4 empleados", a2.getEmpleados().size() == 4);
	}
}
