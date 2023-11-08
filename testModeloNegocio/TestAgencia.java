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

public class TestAgencia {
	
	Agencia a1;
	@Before
	public void setUp() throws Exception {
		a1 = Agencia.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		Agencia a2 = Agencia.getInstance();
		assertSame("Las instancias no coinciden", a1, a2);
	}
	
	@Test
	public void testSetLimitesRemuneracionExitoso() {
		try {
			a1.setLimitesRemuneracion(2000, 5000);
			assertEquals("El limite inferior de remuneracion no es el esperado", a1.getLimiteInferior(), 2000);
			assertEquals("El limite superior de remuneracion no es el esperado", a1.getLimiteSuperior(), 5000);
		} catch (LimiteSuperiorRemuneracionInvalidaException | LimiteInferiorRemuneracionInvalidaException e) {
			fail("No deberia lanzarse excepcion");
		}
	}
	
	@Test
	public void testSetLimitesRemuneracionExcepcionInferior() {
		try {
			a1.setLimitesRemuneracion(-3000, 5000);
			fail("Debería lanzar LimiteInferiorRemuneracionInvalidaException");
		} catch (LimiteInferiorRemuneracionInvalidaException e) {
			
		} catch (LimiteSuperiorRemuneracionInvalidaException e) {
			fail("No debería lanzarse esta excepcion");
		}
	}
	
	
	@Test
	public void testSetLimitesRemuneracionExcepcionSuperior() {
		try {
			a1.setLimitesRemuneracion(2000, 1000);
			fail("Debería lanzar LimiteSuperiorRemuneracionInvalidaException");
		} catch (LimiteSuperiorRemuneracionInvalidaException e) {
			
		} catch (LimiteInferiorRemuneracionInvalidaException e) {
			fail("No debería lanzarse esta excepcion");
		}
	}
	
	@Test
	public void testGatillarRondaVerdadero() {
		//a1.setEstadoContratacion(true);
		//a1.gatillarRonda();
		
	}
	
	@Test
	public void testGatillarRondaFalso() {
	
	}
	
	@Test
	public void testMatch() {
		EmpleadoPretenso empleado = new EmpleadoPretenso("MatiF", "123456", "Matias", "2235825715", "Frangolini", 21);
		Empleador empleador = new Empleador("MatiF", "123456", "Matias", "2235825715", "COMERCIO_LOCAL", "FISICA");
		empleador.setTicket(new Ticket("INDISTINTO",5000,"JORNADA_EXTENDIDA","MANAGMENT","EXP_MUCHA", "TERCIARIOS"));
		int oldSizeContrataciones = a1.getContrataciones().size();
		int oldPuntajeEmpleador = empleador.getPuntaje();
		int oldPuntajeEmpleado = empleado.getPuntaje();

		try {
			a1.registroEmpleado("MatiF", "123456", "Matias", "2235825715", "Frangolini", 21);
			a1.registroEmpleador("MatiF", "123456", "Matias", "2235825715", "COMERCIO_LOCAL", "FISICA");
		} catch (NewRegisterException | ImposibleCrearEmpleadorException | ImposibleCrearEmpleadoException e) {
			//Nunca va a entrar aca
		}
		
		a1.match(empleador, empleado);
		
		assertTrue("El puntaje del empleado no es el esperado", oldPuntajeEmpleado+10 == empleado.getPuntaje());
		assertTrue("El puntaje del empleador no es el esperado", oldPuntajeEmpleador+50 == empleador.getPuntaje());
		assertTrue("No se creó la contratacion", oldSizeContrataciones+1 == a1.getContrataciones().size());
		assertEquals("El ticket debería ser nulo", null, empleado.getTicket());
		assertEquals("El ticket debería ser nulo", null, empleador.getTicket());
		
	}
	
	@Test
	public void testGeneraPostulantesEmpleador() {
		
		EscenarioGeneraPostulantes esc = new EscenarioGeneraPostulantes();
		a1.setEmpleadores(esc.getEmpleadores());
		a1.setEmpleados(esc.getEmpleados());
		
		a1.generaPostulantes();
		
		Empleador e = esc.getEmpleadores().get("Mati");
		Iterator<ClientePuntaje> it1 = e.getListaDePostulantes().iterator();
		Iterator<ClientePuntaje> it2 = e.getListaDePostulantes().iterator();
		it2.next();
		while (it1.hasNext()) {
			if (!(it2.next().compareTo(it1.next()) < 0)) {
				fail("La lista de postulantes del empleador no está ordenada");
			}
		}
		
	}
	
	@Test
	public void testGeneraPostulantesEmpleado() {
		
		EscenarioGeneraPostulantes esc = new EscenarioGeneraPostulantes();
		a1.setEmpleadores(esc.getEmpleadores());
		a1.setEmpleados(esc.getEmpleados());
		
		a1.generaPostulantes();
		
		EmpleadoPretenso e = esc.getEmpleados().get("Mati");
		Iterator<ClientePuntaje> it1 = e.getListaDePostulantes().iterator();
		Iterator<ClientePuntaje> it2 = e.getListaDePostulantes().iterator();
		it2.next();
		while (it1.hasNext()) {
			if (!(it2.next().compareTo(it1.next()) < 0)) {
				fail("La lista de postulantes del empleado no está ordenada");
			}
		}
		
	}
	
	@Test 
	public void testCrearTicketEmpleado() {
		
	}
	
	@Test
	public void testRegistroEmpleadoListaVaciaExitoso() {
		EscenarioListaEmpleadosVacia esc = new EscenarioListaEmpleadosVacia();
		a1.setEmpleados(esc.getEmpleados());
		try {
			a1.registroEmpleado("Berni", "berni1234", "Bernardo", "223123456", "Porfilio", 22);
		} catch (NewRegisterException | ImposibleCrearEmpleadoException e) {
			fail("No debería lanzar excepcion");
		}
	}
	
	
	@Test
	public void testRegistroEmpleadoImposibleCrearEmpleadoException() {
		EscenarioListaEmpleadosVacia esc = new EscenarioListaEmpleadosVacia();
		a1.setEmpleados(esc.getEmpleados());
		try {
			a1.registroEmpleado("Berni", null, "Bernardo", "223123456", "Porfilio", 22);
			fail("Debería lanzar excepcion");
		} catch (ImposibleCrearEmpleadoException e) {
			
		} catch (NewRegisterException e) {
			fail("No debería lanzarse esta excepcion");
		}
	}
	
	
	@Test
	public void testRegistroEmpleadoListaConEmpleado() {
		EscenarioListaEmpleadosConEmpleado esc = new EscenarioListaEmpleadosConEmpleado();
		a1.setEmpleados(esc.getEmpleados());
		try {
			a1.registroEmpleado("Berni", "berni1234", "Bernardo", "223123456", "Porfilio", 22);
			fail("Debería lanzar excepcion");
		} catch (ImposibleCrearEmpleadoException e) {
			fail("No debería lanzarse esta excepcion");
		} catch (NewRegisterException e) {
			
		}
	}
	
	
	@Test
	public void testRegistroEmpleadorListaVaciaExitoso() {
		EscenarioListaEmpleadoresVacia esc = new EscenarioListaEmpleadoresVacia();
		a1.setEmpleadores(esc.getEmpleadores());
		
		try {
			a1.registroEmpleador("Berni", "berni1234", "Bernardo", "223123456", "SALUD", "FISICA");
		} catch (NewRegisterException | ImposibleCrearEmpleadorException e) {
			fail("No debería lanzar excepcion");
		}
		
	}
	
	@Test
	public void testRegistroEmpleadorImposibleCrearEmpleadorException1() {
		EscenarioListaEmpleadoresVacia esc = new EscenarioListaEmpleadoresVacia();
		a1.setEmpleadores(esc.getEmpleadores());
		try {
			a1.registroEmpleador("Berni", "berni1234", "Bernardo", "223123456", "SALUD", "FISICO");
		} catch (ImposibleCrearEmpleadorException e) {
			
		} catch (NewRegisterException e) {
			fail("No debería lanzar esta excepcion");
		}
		
	}
	
	@Test
	public void testRegistroEmpleadorImposibleCrearEmpleadorException2() {
		EscenarioListaEmpleadoresVacia esc = new EscenarioListaEmpleadoresVacia();
		a1.setEmpleadores(esc.getEmpleadores());
		try {
			a1.registroEmpleador("Berni", "berni1234", "Bernardo", "223123456", "VERDULERIA", "FISICA");
		} catch (ImposibleCrearEmpleadorException e) {
			
		} catch (NewRegisterException e) {
			fail("No debería lanzar esta excepcion");
		}
		
	}
	
	@Test
	public void testRegistroEmpleadorImposibleCrearEmpleadorException3() {
		EscenarioListaEmpleadoresVacia esc = new EscenarioListaEmpleadoresVacia();
		a1.setEmpleadores(esc.getEmpleadores());
		try {
			a1.registroEmpleador("Berni", "berni1234", null, "223123456", "SALUD", "FISICA");
		} catch (ImposibleCrearEmpleadorException e) {
			
		} catch (NewRegisterException e) {
			fail("No debería lanzar esta excepcion");
		}
		
	}
	
	@Test
	public void testRegistroEmpleadorNewRegisterException() {
		EscenarioListaEmpleadoresConEmpleador esc = new EscenarioListaEmpleadoresConEmpleador();
		a1.setEmpleadores(esc.getEmpleadores());
		try {
			a1.registroEmpleador("Berni", "berni1234", "Bernardo", "223123456", "SALUD", "FISICA");
		} catch (ImposibleCrearEmpleadorException e) {
			fail("No debería lanzar esta excepcion");
		} catch (NewRegisterException e) {
			
		}
		
	}
	
	@Test
	public void testLoginExitoso() {
		EscenarioListaEmpleadoresConEmpleador esc = new EscenarioListaEmpleadoresConEmpleador();
		a1.setEmpleadores(esc.getEmpleadores());
		
		try {
			a1.login("Berni", "berni1234");
		} catch (ContraException | NombreUsuarioException e) {
			fail("No deberia lanzar excepcion");
		}
	}
	
	@Test
	public void testLoginContraException() {
		EscenarioListaEmpleadoresConEmpleador esc = new EscenarioListaEmpleadoresConEmpleador();
		a1.setEmpleadores(esc.getEmpleadores());
		
		try {
			a1.login("Berni", "mati1234");
		} catch (ContraException e) {
			
		} catch (NombreUsuarioException e) {
			fail("No deberia lanzar esta excepcion");
		}
	}
	
	
	@Test
	public void testLoginNombreUsuarioException() {
		EscenarioListaEmpleadoresConEmpleador esc = new EscenarioListaEmpleadoresConEmpleador();
		a1.setEmpleadores(esc.getEmpleadores());
		
		try {
			a1.login("Mati", "berni1234");
		} catch (ContraException e) {
			fail("No deberia lanzar esta excepcion");
		} catch (NombreUsuarioException e) {
			
		}
	}
	
	@Test
	public void testCerrarSesion() {
		EscenarioListaEmpleadoresConEmpleador esc = new EscenarioListaEmpleadoresConEmpleador();
		a1.setEmpleadores(esc.getEmpleadores());
		try {
			a1.login("Berni", "berni1234");
		} catch (ContraException | NombreUsuarioException e) {
			// Nunca entra aca
		}
		
		a1.cerrarSesion();
		assertTrue("No se cerro correctamente la sesion", a1.getTipoUsuario() == -1);
	}

}
