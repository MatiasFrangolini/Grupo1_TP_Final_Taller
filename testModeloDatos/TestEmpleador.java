package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Empleador;
import modeloDatos.Ticket;

public class TestEmpleador {
	
	private Ticket ticket;
	
	@Before
	public void setUp() throws Exception {
		ticket = new Ticket("HOMEOFFICE",1000,"JORNADA_MEDIA","JUNIOR","EXP_MEDIA", "PRIMARIOS");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Empleador e = new Empleador("MatiF", "123456", "Matias", "2235825715", "COMERCIO_LOCAL", "FISICA");
		assertEquals("El username no es el esperado", "MatiF", e.getUsserName());
		assertEquals("La password no es la esperada", "123456", e.getPassword());
		assertEquals("El real name no es el esperado", "Matias", e.getRealName());
		assertEquals("El telefono no es el esperado", "2235825715", e.getTelefono());
		assertEquals("El rubro no es el esperado", "COMERCIO_LOCAL", e.getRubro());
		assertEquals("El tipo de persona no es el esperado", "FISICA", e.getTipoPersona());
	}
	
	public void testCalculaComisionSalud() {
		Empleador e = new Empleador("MatiF", "123456", "Matias", "2235825715", "SALUD", "FISICA");
		assertTrue("El cálculo de la comisión es incorrecto", 600.0  == e.calculaComision(ticket));
	}
	
	public void testCalculaComisionLocal() {
		Empleador e = new Empleador("MatiF", "123456", "Matias", "2235825715", "COMERCIO_LOCAL", "FISICA");
		assertTrue("El cálculo de la comisión es incorrecto", 700.0  == e.calculaComision(ticket));
	}

	public void testCalculaComisionInternacional() {
		Empleador e = new Empleador("MatiF", "123456", "Matias", "2235825715", "COMERCIO_INTERNACIONAL", "FISICA");
		assertTrue("El cálculo de la comisión es incorrecto", 800.0  == e.calculaComision(ticket));
	}

}
