package testModeloDatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;

public class TestEmpleadoPretenso {
	
	EmpleadoPretenso e;
	EscenarioTicketCasos1 esc1;
	EscenarioTicketCasos2 esc2;
	EscenarioTicketCasos3 esc3;
	
	@Before
	public void setUp() throws Exception {
		e = new EmpleadoPretenso("MatiF", "123456", "Matias", "2235825715", "Frangolini", 21);
		esc1 = new EscenarioTicketCasos1();
		esc2 = new EscenarioTicketCasos2();
		esc3 = new EscenarioTicketCasos3();
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
	
	@Test
	public void testCalculaComisionJunior() {
		ClientePuntaje cp = new ClientePuntaje(-1.0, e);  // Se pone puntaje negativo para que no influya en el cálculo de la comisión
		assertTrue("El cálculo de la comisión es incorrecto", 800.0  == e.calculaComision(esc1.getTicket()));
	}
	
	@Test
	public void testCalculaComisionSenior() {
		ClientePuntaje cp = new ClientePuntaje(-1.0, e); // Se pone puntaje negativo para que no influya en el cálculo de la comisión
		assertTrue("El cálculo de la comisión es incorrecto", 2700.0  == e.calculaComision(esc2.getTicket()));
	}
	
	@Test
	public void testCalculaComisionManagment() {
		ClientePuntaje cp = new ClientePuntaje(-1.0, e); // Se pone puntaje negativo para que no influya en el cálculo de la comisión
		assertTrue("El cálculo de la comisión es incorrecto", 5000.0  == e.calculaComision(esc3.getTicket()));
	}
	
	@Test
	public void testCalculaComisionJuniorPuntaje() {
		ClientePuntaje cp = new ClientePuntaje(10.0, e);
		assertTrue("El cálculo de la comisión es incorrecto", (800.0*0.9)  == e.calculaComision(esc1.getTicket()));
	}
	
	@Test
	public void testCalculaComisionSeniorPuntaje() {
		ClientePuntaje cp = new ClientePuntaje(10.0, e);
		assertTrue("El cálculo de la comisión es incorrecto", (2700.0*0.9)  == e.calculaComision(esc2.getTicket()));
	}
	
	@Test
	public void testCalculaComisionManagmentPuntaje() {
		ClientePuntaje cp = new ClientePuntaje(10.0, e);
		assertTrue("El cálculo de la comisión es incorrecto", (5000.0*0.9)  == e.calculaComision(esc3.getTicket()));
	}
	
	@Test
	public void testCalculaComisionJuniorPuntajeMaximo() {
		ClientePuntaje cp = new ClientePuntaje(100.0, e);
		assertTrue("El cálculo de la comisión es incorrecto", (800.0*0.5)  == e.calculaComision(esc1.getTicket()));
	}
	
	@Test
	public void testCalculaComisionSeniorPuntajeMaximo() {
		ClientePuntaje cp = new ClientePuntaje(100.0, e);
		assertTrue("El cálculo de la comisión es incorrecto", (2700.0*0.5)  == e.calculaComision(esc2.getTicket()));
	}
	
	@Test
	public void testCalculaComisionManagmentPuntajeMaximo() {
		ClientePuntaje cp = new ClientePuntaje(100.0, e);
		assertTrue("El cálculo de la comisión es incorrecto", (5000.0*0.5)  == e.calculaComision(esc3.getTicket()));
	}
	

}
