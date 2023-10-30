package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Empleador;

public class TestEmpleador {

	@Before
	public void setUp() throws Exception {
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

}
