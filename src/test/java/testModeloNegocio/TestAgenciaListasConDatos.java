package testModeloNegocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.ImposibleCrearEmpleadoException;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.ImposibleModificarTicketsException;
import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import modeloDatos.Cliente;
import modeloDatos.ClientePuntaje;
import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestAgenciaListasConDatos {
	
	
	private Agencia a;
	private EscenarioAgenciaConListasConDatos esc;
	
	@Before
	public void setUp() throws Exception {
		this.esc = new EscenarioAgenciaConListasConDatos();
		this.a = Agencia.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		this.a.setCoincidencias(new ArrayList<Contratacion>());
		this.a.setContrataciones(new ArrayList<Contratacion>());
		this.a.setComisionesUsuarios(new HashMap<Cliente, Double>());
		this.a.setEmpleadores(new HashMap<String, Empleador>());
		this.a.setEmpleados(new HashMap<String, EmpleadoPretenso>());
	}
	
	
	
	@Test
	public void testGetInstance() {
		Agencia a2 = Agencia.getInstance();
		assertSame("Las instancias no coinciden", a, a2);
	}
	
	
	@Test
	public void testSetLimitesRemuneracionExitoso() {
		try {
			a.setLimitesRemuneracion(2000, 5000);
			assertEquals("El limite inferior de remuneracion no es el esperado", a.getLimiteInferior(), 2000);
			assertEquals("El limite superior de remuneracion no es el esperado", a.getLimiteSuperior(), 5000);
		} catch (LimiteSuperiorRemuneracionInvalidaException | LimiteInferiorRemuneracionInvalidaException e) {
			fail("No deberia lanzarse excepcion");
		}
	}
	
	@Test
	public void testSetLimitesRemuneracionExcepcionInferior() {
		try {
			a.setLimitesRemuneracion(-3000, 5000);
			fail("Debería lanzar LimiteInferiorRemuneracionInvalidaException");
		} catch (LimiteInferiorRemuneracionInvalidaException e) {
			
		} catch (LimiteSuperiorRemuneracionInvalidaException e) {
			fail("Debería lanzar LimiteInferiorRemuneracionInvalidaException");
		}
	}
	
	
	@Test
	public void testSetLimitesRemuneracionExcepcionSuperior() {
		try {
			a.setLimitesRemuneracion(2000, 1000);
			fail("Debería lanzar LimiteSuperiorRemuneracionInvalidaException");
		} catch (LimiteSuperiorRemuneracionInvalidaException e) {
			
		} catch (LimiteInferiorRemuneracionInvalidaException e) {
			fail("Debería lanzar LimiteSuperiorRemuneracionInvalidaException");
		}
	}
	
	
	@Test
	public void testMatch() {
		EmpleadoPretenso empleado = this.esc.getEmpleados().get("Mati");
		Empleador empleador = this.esc.getEmpleadores().get("Berni");
		
		int oldSizeContrataciones = a.getContrataciones().size();
		int oldPuntajeEmpleador = empleador.getPuntaje();
		int oldPuntajeEmpleado = empleado.getPuntaje();
		
		a.match(empleador, empleado);
		
		assertTrue("El puntaje del empleado no es el esperado", oldPuntajeEmpleado+10 == empleado.getPuntaje());
		assertTrue("El puntaje del empleador no es el esperado", oldPuntajeEmpleador+50 == empleador.getPuntaje());
		assertTrue("No se creó la contratacion", oldSizeContrataciones+1 == a.getContrataciones().size());
		assertEquals("El ticket debería ser nulo", null, empleado.getTicket());
		assertEquals("El ticket debería ser nulo", null, empleador.getTicket());
		
	}
	
	
	@Test
	public void testGeneraPostulantesEmpleador() {
		ClientePuntaje cp1;
		ClientePuntaje cp2;
		
		a.setEmpleadores(esc.getEmpleadores());
		a.setEmpleados(esc.getEmpleados());
		
		a.generaPostulantes();
		
		Empleador e = esc.getEmpleadores().get("Mati");
		Iterator<ClientePuntaje> it1 = e.getListaDePostulantes().iterator();
		Iterator<ClientePuntaje> it2 = e.getListaDePostulantes().iterator();
		it2.next();
		while (it2.hasNext()) {
			cp1 = it1.next();
			cp2 = it2.next();
			if (cp2.compareTo(cp1) < 0) {
				fail("La lista de postulantes del empleador no está ordenada");
			}
		}
		
	}
	
	@Test
	public void testGeneraPostulantesEmpleado() {
		ClientePuntaje cp1;
		ClientePuntaje cp2;
		
		a.setEmpleadores(esc.getEmpleadores());
		a.setEmpleados(esc.getEmpleados());
		
		a.generaPostulantes();
		
		assertTrue("No se generó la lista de postulantes del empleado", a.getEmpleados().get("Berni").getListaDePostulantes().size() > 0);
		assertTrue("No se generó la lista de postulantes del empleador", a.getEmpleadores().get("Berni").getListaDePostulantes().size() > 0);
		
		EmpleadoPretenso e = esc.getEmpleados().get("Mati");
		Iterator<ClientePuntaje> it1 = e.getListaDePostulantes().iterator();
		Iterator<ClientePuntaje> it2 = e.getListaDePostulantes().iterator();
		it2.next();
		while (it2.hasNext()) {
			cp1 = it1.next();
			cp2 = it2.next();
			if (cp2.compareTo(cp1) < 0) {
				fail("La lista de postulantes del empleado no está ordenada");
			}
		}
		
	}
	
	
	@Test
	public void testRegistroEmpleadoNewRegisterException() {
		a.setEmpleados(esc.getEmpleados());
		try {
			a.registroEmpleado("Berni", "berni1234", "Bernardo", "223123456", "Porfilio", 22);
			fail("Debería lanzar NewRegisterException");
		} catch (ImposibleCrearEmpleadoException e) {
			fail("Debería lanzar NewRegisterException");
		} catch (NewRegisterException e) {
			
		}
	}
	
	@Test
	public void testRegistroEmpleadorNewRegisterException() {
		a.setEmpleadores(esc.getEmpleadores());
		try {
			a.registroEmpleador("Berni", "berni1234", "Bernardo", "223123456",Constantes.SALUD, Constantes.FISICA);
			fail("Debería lanzar NewRegisterException");
		} catch (ImposibleCrearEmpleadorException e) {
			fail("Debería lanzar NewRegisterException");
		} catch (NewRegisterException e) {
			
		}
		
	}
	
	
	@Test
	public void testLoginExitoso() {
		a.setEmpleadores(esc.getEmpleadores());
		
		try {
			a.login("Berni", "berni1234");
		} catch (ContraException | NombreUsuarioException e) {
			fail("No deberia lanzar excepcion");
		}
	}
	
	@Test
	public void testLoginContraException() {
		a.setEmpleadores(esc.getEmpleadores());
		
		try {
			a.login("Berni", "mati1234");
			fail("Deberia lanzar ContraException");
		} catch (ContraException e) {
			
		} catch (NombreUsuarioException e) {
			fail("Deberia lanzar ContraException");
		}
	}
	
	
	@Test
	public void testLoginNombreUsuarioException() {
		a.setEmpleadores(esc.getEmpleadores());
		
		try {
			a.login("Mati", "berni1234");
			fail("Deberia lanzar NombreUsuarioException");
		} catch (ContraException e) {
			fail("Deberia lanzar NombreUsuarioException");
		} catch (NombreUsuarioException e) {
			
		}
	}
	
	@Test
	public void testCerrarSesion() {
		a.setEmpleadores(esc.getEmpleadores());
		try {
			a.login("Berni", "berni1234");
		} catch (ContraException | NombreUsuarioException e) {
			// Nunca entra aca
		}
		
		a.cerrarSesion();
		assertTrue("No se cerro correctamente la sesion", a.getTipoUsuario() == -1);
	}
	
	
	@Test
	public void testGatillarRondaEstadoContratacionTrue() {
		a.setEstadoContratacion(true);
		
		a.generaPostulantes();
		a.getEmpleadores().get("Mati").setPuntaje(50);
		
		a.gatillarRonda();
		
		assertEquals("No se eliminaron los postulantes del empleador", a.getEmpleadores().get("Mati").getListaDePostulantes(), null);
		assertEquals("No se eliminaron los postulantes del empleado", a.getEmpleados().get("Pedro").getListaDePostulantes(), null);
		assertTrue("Estado contratación debería pasar a ser falso", !(a.isEstadoContratacion()));
		assertTrue("No se aplico el castigo por no ser elegido en la ronda", this.a.getEmpleadores().get("Mati").getPuntaje() == 30);

	}
	
	
	@Test
	public void testGatillarRondaEstadoContratacionFalse() {
		a.setEstadoContratacion(false);
		
		a.getEmpleados().get("Pedro").setPuntaje(50);
		a.getEmpleados().get("Mati").setPuntaje(20);
		
		a.gatillarRonda();
		
		assertTrue("No se generaron los postulantes del empleador", a.getEmpleadores().get("Mati").getListaDePostulantes().size() > 0);
		assertTrue("No se generaron los postulantes del empleado", a.getEmpleados().get("Pedro").getListaDePostulantes().size() > 0);
		assertTrue("Estado contratación debería pasar a ser true", a.isEstadoContratacion());
		assertTrue("No se aplico el premio al empleador", this.a.getEmpleadores().get("Fran").getPuntaje() == 10);
		assertTrue("No se aplico el premio al empleado", this.a.getEmpleados().get("Pedro").getPuntaje() == 60);
		assertTrue("No se aplico el castigo al empleado", this.a.getEmpleados().get("Mati").getPuntaje() == 15);

	}
	
	
	@Test
	public void testCalculaPremiosCastigosAsignacionesTestPremios() {
		a.getEmpleados().get("Pedro").setPuntaje(50);
		a.getEmpleadores().get("Fran").setPuntaje(20);
		a.generaPostulantes();
		a.calculaPremiosCastigosAsignaciones();
		
		//Empleado Pedro deberia tener puntaje = 60 (+10)
		//Empleado Mati deberia tener puntaje = -5 (-5) 
		//Empleado Berni deberia tener puntaje = -5 (-5)
		
		//Empleador Pedro deberia tener puntaje = 0 (+0)
		//Empleador Fran deberia tener puntaje = 30 (+10), el resto 10 (+10)
		
		assertTrue("El puntaje del empleador no es correcto", a.getEmpleadores().get("Fran").getPuntaje() == 30);
		assertTrue("El puntaje del empleado no es correcto", a.getEmpleados().get("Pedro").getPuntaje() == 60);
		
		
	}
	
	
	@Test
	public void testCalculaPremiosCastigosAsignacionesTestCastigos() {
		
		a.getEmpleados().get("Mati").setPuntaje(20);
		
		a.generaPostulantes();
		a.calculaPremiosCastigosAsignaciones();
		
		assertTrue("El puntaje del empleado no es correcto", a.getEmpleados().get("Mati").getPuntaje() == 15);
		
		
	}
	
	
	@Test
	public void testCrearTicketEmpleado() {
		a.setEstadoContratacion(false);
		try {
			this.a.crearTicketEmpleado(Constantes.HOME_OFFICE, 5000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_MUCHA, Constantes.SECUNDARIOS, esc.getEmpleados().get("Mati"));
		} catch (ImposibleModificarTicketsException e) {
			fail("No deberia lanzar excepcion");
		}
	}
	
	@Test
	public void testCrearTicketEmpleadoException() {
		a.setEstadoContratacion(true);
		try {
			this.a.crearTicketEmpleado(Constantes.HOME_OFFICE, 5000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_MUCHA, Constantes.SECUNDARIOS, esc.getEmpleados().get("Mati"));
			fail("Deberia lanzar ImposibleModificarTicketsException");
		} catch (ImposibleModificarTicketsException e) {
			
		}
	}
	
	
	@Test
	public void testCrearTicketEmpleador() {
		a.setEstadoContratacion(false);
		try {
			this.a.crearTicketEmpleador(Constantes.HOME_OFFICE, 5000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_MUCHA, Constantes.SECUNDARIOS, esc.getEmpleadores().get("Mati"));
		} catch (ImposibleModificarTicketsException e) {
			fail("No deberia lanzar excepcion");
		}
	}
	
	@Test
	public void testCrearTicketEmpleadorException() {
		a.setEstadoContratacion(true);
		try {
			this.a.crearTicketEmpleador(Constantes.HOME_OFFICE, 5000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_MUCHA, Constantes.SECUNDARIOS, esc.getEmpleadores().get("Mati"));
			fail("Deberia lanzar ImposibleModificarTicketsException");
		} catch (ImposibleModificarTicketsException e) {
			
		}
	}
	
	
	@Test
	public void testEliminarTicket() {
		a.setEstadoContratacion(false);
		int oldPuntaje = a.getEmpleados().get("Berni").getPuntaje();
		try {
			a.login("Berni", "berni1234");
		} catch (ContraException | NombreUsuarioException e) {
		}
		
		try {
			a.eliminarTicket();
		} catch (ImposibleModificarTicketsException e) {
			fail("No deberia lanzar excepcion");
		}
		assertTrue("No se resto el puntaje por eliminar Ticket", oldPuntaje -1 == a.getEmpleados().get("Berni").getPuntaje());
		assertEquals("El ticket deberia haberse eliminado", a.getEmpleados().get("Berni").getTicket(), null);
	}
	
	
	@Test
	public void testEliminarTicketException() {
		a.setEstadoContratacion(true);
		try {
			a.login("Berni", "berni1234");
		} catch (ContraException | NombreUsuarioException e) {
		}
		Ticket tAux = a.getEmpleados().get("Berni").getTicket();
		try {
			a.eliminarTicket();
			fail("Deberia lanzar ImposibleModificarTicketsException");
		} catch (ImposibleModificarTicketsException e) {
		}
		assertEquals("El ticket no deberia haberse eliminado", a.getEmpleados().get("Berni").getTicket(), tAux);
	}
	
	

}
