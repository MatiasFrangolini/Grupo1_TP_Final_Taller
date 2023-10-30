package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.*;

public class TestContratacion {
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Empleador empleador = new Empleador("MatiF", "123456", "Matias", "2235825715", "COMERCIO_LOCAL", "FISICA");
		EmpleadoPretenso empleado = new EmpleadoPretenso("MatiF", "123456", "Matias", "2235825715", "Frangolini", 21);
		Contratacion c = new Contratacion(empleador, empleado);
		assertSame("El empleador no es el esperado", c.getEmpleador(), empleador);
		assertSame("El empleado pretenso no es el esperado", c.getEmpleado(), empleado);
	}
	
	
	@Test
	public void testSetEmpleado() {
		Contratacion c1 = new Contratacion();
		EmpleadoPretenso empleado = new EmpleadoPretenso("Bernip", "123456", "Bernardo", "2235825715", "Frangolini", 21);
		c1.setEmpleado(empleado);
		assertSame("El empleado no es el esperado", c1.getEmpleado(), empleado);
	}
	
	@Test
	public void testSetEmpleador() {
		Contratacion c1 = new Contratacion();
		Empleador empleador = new Empleador("Franflorio", "123456", "Francisco", "2235825715", "COMERCIO_LOCAL", "FISICA");
		c1.setEmpleador(empleador);
		assertSame("El empleador no es el esperado", c1.getEmpleador(), empleador);
	}

}
