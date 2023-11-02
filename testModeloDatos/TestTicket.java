package testModeloDatos;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Ticket;

public class TestTicket {
	
	Ticket t;
	EscenarioTicketCasos1 esc1 = new EscenarioTicketCasos1();
	EscenarioTicketCasos2 esc2 = new EscenarioTicketCasos2();
	EscenarioTicketCasos3 esc3 = new EscenarioTicketCasos3();
	
	@Before
	public void setUp() throws Exception {
		t = new Ticket("HOME_OFFICE",1000,"JORNADA_MEDIA","JUNIOR","EXP_MEDIA", "PRIMARIOS");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		assertEquals("La locacion no es la esperada", "HOME_OFFICE", t.getLocacion());
		assertEquals("La remuneracion no es la esperada", 1000, t.getRemuneracion());
		assertEquals("La jornada no es la esperada", "JORNADA_MEDIA", t.getJornada());
		assertEquals("El puesto no es el esperado", "JUNIOR", t.getPuesto());
		assertEquals("La experiencia no es la esperada", "EXP_MEDIA", t.getExperiencia());
		assertEquals("Los estudios no son los esperados", "PRIMARIOS", t.getEstudios());
	}
	
	@Test
	public void testSetLocacion() {
		t.setLocacion("PRESENCIAL");
		assertEquals("La locacion no es la esperada", "PRESENCIAL", t.getLocacion());
	}
	
	@Test
	public void testSetRemuneracion() {
		t.setRemuneracion(2500);
		assertEquals("La remuneracion no es la esperada", 2500, t.getRemuneracion());
	}
	
	@Test
	public void testSetJornada() {
		t.setJornada("JORNADA_COMPLETA");
		assertEquals("La jornada no es la esperada", "JORNADA_COMPLETA", t.getJornada());
	}
	
	@Test
	public void testSetPuesto() {
		t.setPuesto("SENIOR");
		assertEquals("El puesto no es el esperado", "SENIOR", t.getPuesto());
	}
	
	@Test
	public void testSetExperiencia() {
		t.setExperiencia("EXP_MUCHA");
		assertEquals("La experiencia no es la esperada", "EXP_MUCHA", t.getExperiencia());
	}
	
	@Test
	public void testSetEstudios() {
		t.setEstudios("SECUNDARIOS");
		assertEquals("Los estudios no son los esperados", "SECUNDARIOS", t.getEstudios());
	}
	
	@Test
	public void testComparaciones11() {
		esc1.getTicket().getComparacionEstudios(esc1.getTicket());
		esc1.getTicket().getComparacionExperiencia(esc1.getTicket());
		esc1.getTicket().getComparacionJornada(esc1.getTicket());
		esc1.getTicket().getComparacionLocacion(esc1.getTicket());
		esc1.getTicket().getComparacionPuesto(esc1.getTicket());
		esc1.getTicket().getComparacionRemuneracion(esc1.getTicket());
	}
	
	@Test
	public void testComparaciones12() {
		
	}
	
	@Test
	public void testComparaciones13() {
		
	}
	
	@Test
	public void testComparaciones22() {
		
	}
	
	@Test
	public void testComparaciones23() {
		
	}
	
	@Test
	public void testComparaciones33() {
		
	}

}
