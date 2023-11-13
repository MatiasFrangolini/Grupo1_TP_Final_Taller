package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestTicketCasos3 {

	private EscenarioTicketCasos3 esc = new EscenarioTicketCasos3();
	private Ticket t;
	private Ticket t3;
	private Agencia a = Agencia.getInstance();

	@Before
	public void setUp() throws Exception {
		this.t = this.esc.getTicket();
		t3 = new Ticket(Constantes.INDISTINTO,5000, Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA, Constantes.TERCIARIOS);
		this.a.setLimitesRemuneracion(2000, 4000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComparacionEstudios33() {
		assertTrue("La comparacion de estudios no fue la esperada", this.t.getComparacionEstudios(t3) == 1.0);	
	}
	
	@Test
	public void testComparacionExperiencia33() {
		assertTrue("La comparacion de experiencia no fue la esperada", this.t.getComparacionExperiencia(t3) == 1.0);
	}
	
	@Test
	public void testComparacionJornada33() {
		assertTrue("La comparacion de jornadas no fue la esperada", this.t.getComparacionJornada(t3) == 1.0);
	}
	
	@Test
	public void testComparacionLocacion33() {
		assertTrue("La comparacion de locaciones no fue la esperada", this.t.getComparacionLocacion(t3) == 1.0);
	}
	
	@Test
	public void testComparacionPuesto33() {
		assertTrue("La comparacion de puestos no fue la esperada", this.t.getComparacionPuesto(t3) == 1.0);
	}
	
	@Test
	public void testComparacionRemuneracion33() {
		assertTrue("La comparacion de remuneraciones no fue la esperada", this.t.getComparacionRemuneracion(t3) == 1.0);
	}

}
