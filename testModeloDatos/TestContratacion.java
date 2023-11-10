package testModeloDatos;

import static org.junit.Assert.assertSame;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import util.Constantes;

public class TestContratacion {
	
	
	private Contratacion c;
	private EmpleadoPretenso empleado;
	private Empleador empleador;
	
	@Before
	public void setUp() throws Exception {
		empleador = new Empleador("MatiF", "123456", "Matias", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		empleado = new EmpleadoPretenso("MatiF", "123456", "Matias", "2235825715", "Frangolini", 21);
		c = new Contratacion(empleador, empleado);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		assertSame("El empleador no es el esperado", c.getEmpleador(), empleador);
		assertSame("El empleado pretenso no es el esperado", c.getEmpleado(), empleado);
	}
	
	
	@Test
	public void testSetEmpleado() {
		EmpleadoPretenso empleado = new EmpleadoPretenso("Bernip", "123456", "Bernardo", "2235825715", "Frangolini", 21);
		c.setEmpleado(empleado);
		assertSame("El empleado no es el esperado", c.getEmpleado(), empleado);
	}
	
	@Test
	public void testSetEmpleador() {
		Empleador empleador = new Empleador("Franflorio", "123456", "Francisco", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		c.setEmpleador(empleador);
		assertSame("El empleador no es el esperado", c.getEmpleador(), empleador);
	}
	
	@Test
	public void testSetFecha() {
		GregorianCalendar fecha = new GregorianCalendar();
		c.setFecha(fecha);
		assertSame("La fecha no es la esperada", fecha, c.getFecha());
	}

}
