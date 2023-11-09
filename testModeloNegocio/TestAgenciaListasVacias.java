package testModeloNegocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.ImposibleCrearEmpleadoException;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.NewRegisterException;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestAgenciaListasVacias {
	
	private Agencia a;
	private EscenarioAgenciaConListasVacias esc;
	
	
	@Before
	public void setUp() throws Exception {
		esc = new EscenarioAgenciaConListasVacias();
		a = Agencia.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	
	
	@Test
	public void testRegistroEmpleadoImposibleCrearEmpleadoException() {
		a.setEmpleados(esc.getEmpleados());
		try {
			a.registroEmpleado("Berni", null, "Bernardo", "223123456", "Porfilio", 22);
			fail("Debería lanzar ImposibleCrearEmpleadoException");
		} catch (ImposibleCrearEmpleadoException e) {
			
		} catch (NewRegisterException e) {
			fail("Debería lanzar ImposibleCrearEmpleadoException");
		}
	}

	@Test
	public void testRegistroEmpleadorImposibleCrearEmpleadorException1() {
		a.setEmpleadores(esc.getEmpleadores());
		try {
			a.registroEmpleador("Berni", "berni1234", "Bernardo", "223123456", "VERDULERIA", Constantes.FISICA);
			fail("Debería lanzar ImposibleCrearEmpleadorException");
		} catch (ImposibleCrearEmpleadorException e) {
			
		} catch (NewRegisterException e) {
			fail("Debería lanzar ImposibleCrearEmpleadorException");
		}
		
	}
	
	
	@Test
	public void testRegistroEmpleadorImposibleCrearEmpleadorException2() {
		a.setEmpleadores(esc.getEmpleadores());
		try {
			a.registroEmpleador("Berni", "berni1234", "Bernardo", "223123456", Constantes.SALUD, "FISICO");
			fail("Debería lanzar ImposibleCrearEmpleadorException");
		} catch (ImposibleCrearEmpleadorException e) {
			
		} catch (NewRegisterException e) {
			fail("Debería lanzar ImposibleCrearEmpleadorException");
		}
		
	}
	
	@Test
	public void testRegistroEmpleadorImposibleCrearEmpleadorException3() {
		a.setEmpleadores(esc.getEmpleadores());
		try {
			a.registroEmpleador("Berni", "berni1234", null, "223123456", Constantes.SALUD, Constantes.FISICA);
			fail("Debería lanzar ImposibleCrearEmpleadorException");
		} catch (ImposibleCrearEmpleadorException e) {
			
		} catch (NewRegisterException e) {
			fail("Debería lanzar ImposibleCrearEmpleadorException");
		}
		
	}
	
	@Test
	public void testRegistroEmpleadorListaVaciaExitoso() {
		a.setEmpleadores(esc.getEmpleadores());
		try {
			a.registroEmpleador("Berni", "berni1234", "Bernardo", "223123456", Constantes.SALUD, Constantes.FISICA);
		} catch (NewRegisterException | ImposibleCrearEmpleadorException e) {
			fail("No debería lanzar excepcion");
		}
		
	}
	
	@Test
	public void testRegistroEmpleadoListaVaciaExitoso() {
		a.setEmpleados(esc.getEmpleados());
		try {
			a.registroEmpleado("Berni", "berni1234", "Bernardo", "223123456", "Porfilio", 22);
		} catch (NewRegisterException | ImposibleCrearEmpleadoException e) {
			fail("No debería lanzar excepcion");
		}
	}
	
	
	@Test
	public void testGatillarRondaEstadoContratacionFalse() {
		
	}

}
