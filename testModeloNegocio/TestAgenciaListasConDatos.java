package testModeloNegocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.ImposibleCrearEmpleadoException;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import modeloDatos.ClientePuntaje;
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
		esc = new EscenarioAgenciaConListasConDatos();
		a = Agencia.getInstance();
	}

	@After
	public void tearDown() throws Exception {
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
		EmpleadoPretenso empleado = new EmpleadoPretenso("MatiF", "123456", "Matias", "2235825715", "Frangolini", 21);
		Empleador empleador = new Empleador("MatiF", "123456", "Matias", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		empleador.setTicket(new Ticket(Constantes.INDISTINTO,5000, Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA, Constantes.TERCIARIOS));
		int oldSizeContrataciones = a.getContrataciones().size();
		int oldPuntajeEmpleador = empleador.getPuntaje();
		int oldPuntajeEmpleado = empleado.getPuntaje();

		try {
			a.registroEmpleado("MatiF", "123456", "Matias", "2235825715", "Frangolini", 21);
			a.registroEmpleador("MatiF", "123456", "Matias", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		} catch (NewRegisterException | ImposibleCrearEmpleadorException | ImposibleCrearEmpleadoException e) {
			//Nunca va a entrar aca
		}
		
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
		
	}

}
