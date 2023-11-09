package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Empleador;
import modeloDatos.Ticket;
import util.Constantes;

public class TestEmpleador {
	
	private Ticket ticket;
	private Empleador e;
	
	@Before
	public void setUp() throws Exception {
		ticket = new Ticket(Constantes.HOME_OFFICE,1000, Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA, Constantes.PRIMARIOS);
		e = new Empleador("MatiF", "123456", "Matias", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		assertEquals("El username no es el esperado", "MatiF", e.getUsserName());
		assertEquals("La password no es la esperada", "123456", e.getPassword());
		assertEquals("El real name no es el esperado", "Matias", e.getRealName());
		assertEquals("El telefono no es el esperado", "2235825715", e.getTelefono());
		assertEquals("El rubro no es el esperado", Constantes.COMERCIO_LOCAL, e.getRubro());
		assertEquals("El tipo de persona no es el esperado", Constantes.FISICA, e.getTipoPersona());
	}
	
	@Test
	public void testSetRubro() {
		e.setRubro(Constantes.SALUD);
		assertEquals("El rubro no es el esperado", Constantes.SALUD, e.getRubro());
	}
	
	@Test
	public void testSetTipoPersona() {
		e.setTipoPersona(Constantes.JURIDICA);
		assertEquals("El tipo de persona no es el esperado", Constantes.JURIDICA, e.getTipoPersona());
	}
	
	
	
	@Test
	public void testCalculaComisionSalud() {
		e = new Empleador("MatiF", "123456", "Matias", "2235825715", Constantes.SALUD, Constantes.FISICA); //Podrian ser nuevos escenarios, pero no nos parecio necesario al ser una sola linea
		assertTrue("El cálculo de la comisión es incorrecto", 600.0  == e.calculaComision(ticket));
	}
	@Test
	public void testCalculaComisionLocal() {
		e = new Empleador("MatiF", "123456", "Matias", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		assertTrue("El cálculo de la comisión es incorrecto", 700.0  == e.calculaComision(ticket));
	}
	@Test
	public void testCalculaComisionInternacional() {
		e = new Empleador("MatiF", "123456", "Matias", "2235825715", Constantes.COMERCIO_INTERNACIONAL, Constantes.FISICA);
		assertTrue("El cálculo de la comisión es incorrecto", 800.0  == e.calculaComision(ticket));
	}

}
