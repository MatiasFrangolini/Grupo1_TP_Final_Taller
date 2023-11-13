package testIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import excepciones.ImposibleCrearEmpleadoException;
import excepciones.NewRegisterException;
import modeloDatos.EmpleadoPretenso;
import modeloNegocio.Agencia;
import testGui.FalsoOptionPane;
import util.Mensajes;
import vista.Ventana;

public class TestIntegracion {
	
	Agencia a;
	Controlador controlador;
	
	
	@Before
	public void setUp() throws Exception {
		a = Agencia.getInstance();
		a.setEmpleados(new HashMap<String, EmpleadoPretenso>());
		controlador = new Controlador();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoginExitoso() {
		try {
			this.a.registroEmpleado("Mati", "loki123", "Matias", "Frangolini", "2235825715", 21);
		} catch (NewRegisterException | ImposibleCrearEmpleadoException e) {
		}
		Ventana ventana = mock(Ventana.class);
		when(ventana.getUsserName()).thenReturn("Mati");
		when(ventana.getPassword()).thenReturn("loki123");
		this.controlador.setVista(ventana);
		this.controlador.login();
		assertTrue("El usuario debería haber logueado", this.a.getTipoUsuario() == 0);
	}
	
	@Test
	public void testLoginContraException() {
		FalsoOptionPane op = new FalsoOptionPane();
		try {
			this.a.registroEmpleado("Mati", "loki123", "Matias", "Frangolini", "2235825715", 21);
		} catch (NewRegisterException | ImposibleCrearEmpleadoException e) {
		}
		Ventana ventana = mock(Ventana.class);
		when(ventana.getUsserName()).thenReturn("Mati");
		when(ventana.getPassword()).thenReturn("loki321");
		this.controlador.setVista(ventana);
		this.controlador.setMyOptionPane(op);
		this.controlador.login();
		assertEquals("Debería haber lanzado una excepción de contraseña incorrecta", Mensajes.PASS_ERRONEO.getValor(), op.getMensaje());
	}
	
	@Test
	public void testLoginUsuarioException() {
		FalsoOptionPane op = new FalsoOptionPane();
		try {
			this.a.registroEmpleado("Mati", "loki123", "Matias", "Frangolini", "2235825715", 21);
		} catch (NewRegisterException | ImposibleCrearEmpleadoException e) {
		}
		Ventana ventana = mock(Ventana.class);
		when(ventana.getUsserName()).thenReturn("MatiasF");
		when(ventana.getPassword()).thenReturn("loki123");
		this.controlador.setVista(ventana);
		this.controlador.setMyOptionPane(op);
		this.controlador.login();
		assertEquals("Debería haber lanzado una excepción de usuario inexistente", Mensajes.USUARIO_DESCONOCIDO.getValor(), op.getMensaje());
	}
	
	
	

}
