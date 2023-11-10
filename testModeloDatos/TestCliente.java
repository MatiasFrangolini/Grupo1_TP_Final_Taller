package testModeloDatos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Cliente;
import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import util.Constantes;

public class TestCliente {
	
	Cliente e;

	@Before
	public void setUp() throws Exception {
		e = new EmpleadoPretenso("MatiF", "123456", "Matias", "2235825715", "Frangolini", 21);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetPuntaje() {
		e.setPuntaje(500);
		assertEquals("El puntaje no es el esperado", 500, e.getPuntaje());
	}
	
	@Test
	public void testSetTicket() {
		Ticket t = new Ticket(Constantes.HOME_OFFICE,1000, Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA, Constantes.PRIMARIOS);
		e.setTicket(t);
		assertEquals("El ticket no es el esperado", t, e.getTicket());
	}
	
	@Test
	public void testSetCandidato() {
		Empleador emp = new Empleador("MatiF", "123456", "Matias", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		e.setCandidato(emp);
		assertEquals("El candidato no es el esperado", emp, e.getCandidato());
	}
	
	@Test
	public void testSetListaDePostulantes() {
		ArrayList<ClientePuntaje> lista = new ArrayList<ClientePuntaje>();
		e.setListaDePostulantes(lista);
		assertEquals("La lista de postulantes no es la esperada", lista, e.getListaDePostulantes());
	}

}
