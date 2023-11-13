package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestTicketCasos2 {

	private EscenarioTicketCasos2 esc = new EscenarioTicketCasos2();
	private Ticket t;
	private Ticket t2;
	private Ticket t3;
	private Agencia a = Agencia.getInstance();

	@Before
	public void setUp() throws Exception {
		this.t = this.esc.getTicket();
		t2 = new Ticket(Constantes.PRESENCIAL,3000, Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA, Constantes.SECUNDARIOS);
		t3 = new Ticket(Constantes.INDISTINTO,5000, Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA, Constantes.TERCIARIOS);
		this.a.setLimitesRemuneracion(2000, 4000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComparacionEstudios22() {
		assertTrue("La comparacion de estudios no fue la esperada", this.t.getComparacionEstudios(t2) == 1.0);	
	}
	
	@Test
	public void testComparacionExperiencia22() {
		assertTrue("La comparacion de experiencia no fue la esperada", this.t.getComparacionExperiencia(t2) == 1.0);
	}
	
	@Test
	public void testComparacionJornada22() {
		assertTrue("La comparacion de jornadas no fue la esperada", this.t.getComparacionJornada(t2) == 1.0);
	}
	
	@Test
	public void testComparacionLocacion22() {
		assertTrue("La comparacion de locaciones no fue la esperada", this.t.getComparacionLocacion(t2) == 1.0);
	}
	
	@Test
	public void testComparacionPuesto22() {
		assertTrue("La comparacion de puestos no fue la esperada", this.t.getComparacionPuesto(t2) == 1.0);
	}
	
	@Test
	public void testComparacionRemuneracion22() {
		assertTrue("La comparacion de remuneraciones no fue la esperada", this.t.getComparacionRemuneracion(t2) == 1.0);
	}
	
	
	
	
	@Test
	public void testComparacionEstudios23() {
		assertTrue("La comparacion de estudios no fue la esperada", this.t.getComparacionEstudios(t3) == 1.5);	
	}
	
	@Test
	public void testComparacionExperiencia23() {
		assertTrue("La comparacion de experiencia no fue la esperada", this.t.getComparacionExperiencia(t3) == 1.5);
	}
	
	@Test
	public void testComparacionJornada23() {
		assertTrue("La comparacion de jornadas no fue la esperada", this.t.getComparacionJornada(t3) == -0.5);
	}
	
	@Test
	public void testComparacionLocacion23() {
		assertTrue("La comparacion de locaciones no fue la esperada", this.t.getComparacionLocacion(t3) == -1.0);
	}
	
	@Test
	public void testComparacionPuesto23() {
		assertTrue("La comparacion de puestos no fue la esperada", this.t.getComparacionPuesto(t3) == -0.5);
	}
	
	@Test
	public void testComparacionRemuneracion23() {
		assertTrue("La comparacion de remuneraciones no fue la esperada", this.t.getComparacionRemuneracion(t3) == -0.5);
	}

}
