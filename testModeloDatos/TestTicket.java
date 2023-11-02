package testModeloDatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;

public class TestTicket {
	
	Ticket t;
	EscenarioTicketCasos1 esc1;
	EscenarioTicketCasos2 esc2;
	EscenarioTicketCasos3 esc3;
	static Agencia ag = Agencia.getInstance();
	
	
	@BeforeClass
    public static void setUpClass(){
        try {
            ag.setLimitesRemuneracion(2000, 4000);
        } catch (LimiteSuperiorRemuneracionInvalidaException | LimiteInferiorRemuneracionInvalidaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	@Before
	public void setUp() throws Exception {
		t = new Ticket("HOME_OFFICE",1000,"JORNADA_MEDIA","JUNIOR","EXP_MEDIA", "PRIMARIOS");
		esc1 = new EscenarioTicketCasos1();
		esc2 = new EscenarioTicketCasos2();
		esc3 = new EscenarioTicketCasos3();
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
	
	/*
	@Test
	public void testComparaciones11() {
		assertTrue("La comparacion de estudios no fue la esperada", esc1.getTicket().getComparacionEstudios(esc1.getTicket()) == 1.0);
		assertTrue("La comparacion de experiencia no fue la esperada", esc1.getTicket().getComparacionExperiencia(esc1.getTicket()) == 1.0);
		assertTrue("La comparacion de jornadas no fue la esperada", esc1.getTicket().getComparacionJornada(esc1.getTicket()) == 1.0);
		assertTrue("La comparacion de locaciones no fue la esperada", esc1.getTicket().getComparacionLocacion(esc1.getTicket()) == 1.0);
		assertTrue("La comparacion de puestos no fue la esperada", esc1.getTicket().getComparacionPuesto(esc1.getTicket()) == 1.0);
		assertTrue("La comparacion de remuneraciones no fue la esperada", esc1.getTicket().getComparacionRemuneracion(esc1.getTicket()) == 1.0);
	}
	
	@Test
	public void testComparaciones12() {
		assertTrue("La comparacion de estudios no fue la esperada", esc1.getTicket().getComparacionEstudios(esc2.getTicket()) == 1.5);
		assertTrue("La comparacion de experiencia no fue la esperada", esc1.getTicket().getComparacionExperiencia(esc2.getTicket()) == 1.5);
		assertTrue("La comparacion de jornadas no fue la esperada", esc1.getTicket().getComparacionJornada(esc2.getTicket()) == -0.5);
		assertTrue("La comparacion de locaciones no fue la esperada", esc1.getTicket().getComparacionLocacion(esc2.getTicket()) == -1.0);
		assertTrue("La comparacion de puestos no fue la esperada", esc1.getTicket().getComparacionPuesto(esc2.getTicket()) == -0.5);
		assertTrue("La comparacion de remuneraciones no fue la esperada", esc1.getTicket().getComparacionRemuneracion(esc2.getTicket()) == -0.5);
	}
	
	@Test
	public void testComparaciones13() {
		assertTrue("La comparacion de estudios no fue la esperada", esc1.getTicket().getComparacionEstudios(esc3.getTicket()) == 2.0);
		assertTrue("La comparacion de experiencia no fue la esperada", esc1.getTicket().getComparacionExperiencia(esc3.getTicket()) == 2.0);
		assertTrue("La comparacion de jornadas no fue la esperada", esc1.getTicket().getComparacionJornada(esc3.getTicket()) == -1.0);
		assertTrue("La comparacion de locaciones no fue la esperada", esc1.getTicket().getComparacionLocacion(esc3.getTicket()) == 1.0);
		assertTrue("La comparacion de puestos no fue la esperada", esc1.getTicket().getComparacionPuesto(esc3.getTicket()) == -1.0);
		assertTrue("La comparacion de remuneraciones no fue la esperada", esc1.getTicket().getComparacionRemuneracion(esc3.getTicket()) == -1.0);
	}
	
	@Test
	public void testComparaciones22() {
		assertTrue("La comparacion de estudios no fue la esperada", esc2.getTicket().getComparacionEstudios(esc2.getTicket()) == 1.0);
		assertTrue("La comparacion de experiencia no fue la esperada", esc2.getTicket().getComparacionExperiencia(esc2.getTicket()) == 1.0);
		assertTrue("La comparacion de jornadas no fue la esperada", esc2.getTicket().getComparacionJornada(esc2.getTicket()) == 1.0);
		assertTrue("La comparacion de locaciones no fue la esperada", esc2.getTicket().getComparacionLocacion(esc2.getTicket()) == 1.0);
		assertTrue("La comparacion de puestos no fue la esperada", esc2.getTicket().getComparacionPuesto(esc2.getTicket()) == 1.0);
		assertTrue("La comparacion de remuneraciones no fue la esperada", esc2.getTicket().getComparacionRemuneracion(esc2.getTicket()) == 1.0);
	}
	
	@Test
	public void testComparaciones23() {
		assertTrue("La comparacion de estudios no fue la esperada", esc2.getTicket().getComparacionEstudios(esc3.getTicket()) == 1.5);
		assertTrue("La comparacion de experiencia no fue la esperada", esc2.getTicket().getComparacionExperiencia(esc3.getTicket()) == 1.5);
		assertTrue("La comparacion de jornadas no fue la esperada", esc2.getTicket().getComparacionJornada(esc3.getTicket()) == -0.5);
		assertTrue("La comparacion de locaciones no fue la esperada", esc2.getTicket().getComparacionLocacion(esc3.getTicket()) == -1.0);
		assertTrue("La comparacion de puestos no fue la esperada", esc2.getTicket().getComparacionPuesto(esc3.getTicket()) == -0.5);
		assertTrue("La comparacion de remuneraciones no fue la esperada", esc2.getTicket().getComparacionRemuneracion(esc3.getTicket()) == -0.5);
	}
	
	@Test
	public void testComparaciones33() {
		assertTrue("La comparacion de estudios no fue la esperada", esc3.getTicket().getComparacionEstudios(esc3.getTicket()) == 1.0);
		assertTrue("La comparacion de experiencia no fue la esperada", esc3.getTicket().getComparacionExperiencia(esc3.getTicket()) == 1.0);
		assertTrue("La comparacion de jornadas no fue la esperada", esc3.getTicket().getComparacionJornada(esc3.getTicket()) == 1.0);
		assertTrue("La comparacion de locaciones no fue la esperada", esc3.getTicket().getComparacionLocacion(esc3.getTicket()) == 1.0);
		assertTrue("La comparacion de puestos no fue la esperada", esc3.getTicket().getComparacionPuesto(esc3.getTicket()) == 1.0);
		assertTrue("La comparacion de remuneraciones no fue la esperada", esc3.getTicket().getComparacionRemuneracion(esc3.getTicket()) == 1.0);
	}
	
	@Test
	public void testComparacionTotal() {
		assertTrue("La comparacion total no fue la esperada", esc1.getTicket().getComparacionTotal(esc3.getTicket()) == 2.0);
	}
	*/

}
