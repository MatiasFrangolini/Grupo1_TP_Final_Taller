package testModeloDatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestTicketCasos1 {
	
	private EscenarioTicketCasos1 esc = new EscenarioTicketCasos1();
	private Ticket t;
	private Ticket t1;
	private Ticket t2;
	private Ticket t3;
	private Agencia a = Agencia.getInstance();

	@Before
	public void setUp() throws Exception {
		this.t = this.esc.getTicket();
		t1 = new Ticket(Constantes.HOME_OFFICE,1000, Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA, Constantes.PRIMARIOS);
		t2 = new Ticket(Constantes.PRESENCIAL,3000, Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA, Constantes.SECUNDARIOS);
		t3 = new Ticket(Constantes.INDISTINTO,5000, Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA, Constantes.TERCIARIOS);
		this.a.setLimitesRemuneracion(2000, 4000);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testConstructor() {
		assertEquals("La locacion no es la esperada", Constantes.HOME_OFFICE, t.getLocacion());
		assertEquals("La remuneracion no es la esperada", 1000, t.getRemuneracion());
		assertEquals("La jornada no es la esperada", Constantes.JORNADA_MEDIA, t.getJornada());
		assertEquals("El puesto no es el esperado", Constantes.JUNIOR, t.getPuesto());
		assertEquals("La experiencia no es la esperada", Constantes.EXP_NADA, t.getExperiencia());
		assertEquals("Los estudios no son los esperados", Constantes.PRIMARIOS, t.getEstudios());
	}
	
	
	@Test
	public void testSetLocacion() {
		this.t.setLocacion(Constantes.PRESENCIAL);
		assertEquals("La locacion no es la esperada", Constantes.PRESENCIAL, t.getLocacion());
	}
	
	@Test
	public void testSetRemuneracion() {
		t.setRemuneracion(2500);
		assertEquals("La remuneracion no es la esperada", 2500, t.getRemuneracion());
	}
	
	@Test
	public void testSetJornada() {
		t.setJornada(Constantes.JORNADA_COMPLETA);
		assertEquals("La jornada no es la esperada", Constantes.JORNADA_COMPLETA, t.getJornada());
	}
	
	@Test
	public void testSetPuesto() {
		t.setPuesto(Constantes.SENIOR);
		assertEquals("El puesto no es el esperado", Constantes.SENIOR, t.getPuesto());
	}
	
	@Test
	public void testSetExperiencia() {
		t.setExperiencia(Constantes.EXP_MUCHA);
		assertEquals("La experiencia no es la esperada", Constantes.EXP_MUCHA, t.getExperiencia());
	}
	
	@Test
	public void testSetEstudios() {
		t.setEstudios(Constantes.SECUNDARIOS);
		assertEquals("Los estudios no son los esperados", Constantes.SECUNDARIOS, t.getEstudios());
	}
	
	
	
	
	@Test
	public void testComparacionEstudios11() {
		assertTrue("La comparacion de estudios no fue la esperada", this.t.getComparacionEstudios(t1) == 1.0);	
	}
	
	@Test
	public void testComparacionExperiencia11() {
		assertTrue("La comparacion de experiencia no fue la esperada", this.t.getComparacionExperiencia(t1) == 1.0);
	}
	
	@Test
	public void testComparacionJornada11() {
		assertTrue("La comparacion de jornadas no fue la esperada", this.t.getComparacionJornada(t1) == 1.0);
	}
	
	@Test
	public void testComparacionLocacion11() {
		assertTrue("La comparacion de locaciones no fue la esperada", this.t.getComparacionLocacion(t1) == 1.0);
	}
	
	@Test
	public void testComparacionPuesto11() {
		assertTrue("La comparacion de puestos no fue la esperada", this.t.getComparacionPuesto(t1) == 1.0);
	}
	
	@Test
	public void testComparacionRemuneracion11() {
		assertTrue("La comparacion de remuneraciones no fue la esperada", this.t.getComparacionRemuneracion(t1) == 1.0);
	}
	
	
	
	@Test
	public void testComparacionEstudios12() {
		assertTrue("La comparacion de estudios no fue la esperada", this.t.getComparacionEstudios(t2) == 1.5);	
	}
	
	@Test
	public void testComparacionExperiencia12() {
		assertTrue("La comparacion de experiencia no fue la esperada", this.t.getComparacionExperiencia(t2) == 1.5);
	}
	
	@Test
	public void testComparacionJornada12() {
		assertTrue("La comparacion de jornadas no fue la esperada", this.t.getComparacionJornada(t2) == -0.5);
	}
	
	@Test
	public void testComparacionLocacion12() {
		assertTrue("La comparacion de locaciones no fue la esperada", this.t.getComparacionLocacion(t2) == -1.0);
	}
	
	@Test
	public void testComparacionPuesto12() {
		assertTrue("La comparacion de puestos no fue la esperada", this.t.getComparacionPuesto(t2) == -0.5);
	}
	
	@Test
	public void testComparacionRemuneracion12() {
		assertTrue("La comparacion de remuneraciones no fue la esperada", this.t.getComparacionRemuneracion(t2) == -0.5);
	}
	
	
	
	
	@Test
	public void testComparacionEstudios13() {
		assertTrue("La comparacion de estudios no fue la esperada", this.t.getComparacionEstudios(t3) == 2.0);	
	}
	
	@Test
	public void testComparacionExperiencia13() {
		assertTrue("La comparacion de experiencia no fue la esperada", this.t.getComparacionExperiencia(t3) == 2.0);
	}
	
	@Test
	public void testComparacionJornada13() {
		assertTrue("La comparacion de jornadas no fue la esperada", this.t.getComparacionJornada(t3) == -1.0);
	}
	
	@Test
	public void testComparacionLocacion13() {
		assertTrue("La comparacion de locaciones no fue la esperada", this.t.getComparacionLocacion(t3) == 1.0);
	}
	
	@Test
	public void testComparacionPuesto13() {
		assertTrue("La comparacion de puestos no fue la esperada", this.t.getComparacionPuesto(t3) == -1.0);
	}
	
	@Test
	public void testComparacionRemuneracion13() {
		assertTrue("La comparacion de remuneraciones no fue la esperada", this.t.getComparacionRemuneracion(t3) == -1.0);
	}
	
	
	@Test
	public void testComparacionTotal() {
		assertTrue("La comparacion total no fue la esperada", this.t.getComparacionTotal(t3) == 2.0);
	}
	

}
