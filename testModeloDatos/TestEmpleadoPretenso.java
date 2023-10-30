package testModeloDatos;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;

public class TestEmpleadoPretenso {
	
	EmpleadoPretenso e;
	
	@Before
	public void setUp() throws Exception {
		e = new EmpleadoPretenso("MatiF", "123456", "Matias", "2235825715", "Frangolini", 21);
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
		assertEquals("El apellido no es el esperado", "Frangolini", e.getApellido());
		assertEquals("La edad no es la esperada", 21, e.getEdad());
	}
	
	@Test
	public void testSetApellido() {
		e.setApellido("Porfilio");
		assertEquals("El apellido no es el esperado", "Porfilio", e.getApellido());
	}
	
	@Test
	public void testSetEdad() {
		e.setEdad(200);
		assertEquals("La edad no es la esperada", 200, e.getEdad());
	}
	
	@Test
	public void testSetUsername() {
		e.setUsserName("Bernip");
		assertEquals("El username no es el esperado", "Bernip", e.getUsserName());
	}
	
	@Test
	public void testSetPassword() {
		e.setPassword("111111");
		assertEquals("La password no es la esperada", "111111", e.getPassword());
	}
	
	@Test
	public void testSetRealName() {
		e.setRealName("Bernardo");
		assertEquals("El real name no es el esperado", "Bernardo", e.getRealName());
	}
	
	@Test
	public void testSetTelefono() {
		e.setTelefono("2235111111");
		assertEquals("El telefono no es el esperado", "2235111111", e.getTelefono());
	}
	

}
