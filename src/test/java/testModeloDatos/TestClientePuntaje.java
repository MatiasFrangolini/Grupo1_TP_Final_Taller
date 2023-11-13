package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Cliente;
import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;

public class TestClientePuntaje {
	
	Cliente c;

	@Before
	public void setUp() throws Exception {
		c = new EmpleadoPretenso("MatiF", "123456", "Matias", "2235825715", "Frangolini", 21);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		ClientePuntaje cp = new ClientePuntaje(500.0, c);
		assertTrue("El puntaje no es el esperado", 500.0 == cp.getPuntaje());
		assertSame("El cliente no es el que se esperaba", c, cp.getCliente());
	}
	
	
	@Test
	public void testSetPuntaje() {
		ClientePuntaje cp = new ClientePuntaje(500.0, c);
		cp.setPuntaje(100.0);
		assertTrue("El puntaje no es el esperado", 100.0 == cp.getPuntaje());
	}
	
	
	@Test
	public void testSetCliente() {
		ClientePuntaje cp = new ClientePuntaje(500.0, c);
		Cliente emp = new Empleador("MatiF", "123456", "Matias", "2235825715", "COMERCIO_LOCAL", "FISICA");
		cp.setCliente(emp);
		assertSame("El cliente no es el esperado", emp,cp.getCliente());
	}
	

}
