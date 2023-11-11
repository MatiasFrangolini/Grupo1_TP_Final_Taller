package testGui;

import static org.junit.Assert.assertTrue;

import java.awt.Component;
import java.awt.Robot;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;
import vista.Ventana;

public class TestGuiEnabledDisabledCliente {

	Robot robot;
	Controlador controlador;
	Ventana vent;
	FalsoOptionPane op = new FalsoOptionPane();
	Agencia a;

	@Before
	public void setUp() throws Exception {
		robot = new Robot();
		controlador = new Controlador();
		vent = (Ventana) this.controlador.getVista();
		controlador.setMyOptionPane(op);
		a = Agencia.getInstance();
		a.registroEmpleado("Mati","loki123", "Matias", "Frangolini", "226235478", 21);
		logueaEmpleado();
		robot.delay(TestUtils.getDelay());
	}

	@After
	public void tearDown() throws Exception {
		a.setEmpleados(new HashMap<String,EmpleadoPretenso>());
	}
	
	public void logueaEmpleado() {
		JButton botonLogin = (JButton) TestUtils.getComponentForName(vent, Constantes.LOGIN);
		JTextField textoUsuario = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.NOMBRE_USUARIO);
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.PASSWORD);
		
		TestUtils.clickComponent(textoUsuario, robot);
        TestUtils.tipeaTexto("Mati", robot);
        TestUtils.clickComponent(textoPass, robot);
        TestUtils.tipeaTexto("loki123", robot);
        TestUtils.clickComponent(botonLogin, robot);
	}

	@Test
	public void testBotonConfirmarTicketDeshabilitado() {
		robot.delay(TestUtils.getDelay());
		JButton botonConfirmarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.CONFIRMARNUEVOTICKET);
		assertTrue("El boton para confirmar el nuevo ticket debería estar deshabilitado", !botonConfirmarTicket.isEnabled());
	}
	
	@Test
	public void testTextFieldRemuneracionDeshabilitado() {
		robot.delay(TestUtils.getDelay());
		JTextField textfield = (JTextField) TestUtils.getComponentForName(vent, Constantes.TEXTFIELD_REMUNERACION);
		assertTrue("El campo remuneracion debería estar deshabilitado", !textfield.isEnabled());
	}
	
	
	@Test
	public void testRadioBotonDeshabilitado() { // recortamos aca, solo testeamos uno
		robot.delay(TestUtils.getDelay());
		JRadioButton radiobutton = (JRadioButton) TestUtils.getComponentForName(vent, Constantes.HOME_OFFICE);
		assertTrue("El boton para confirmar el nuevo ticket debería estar habilitado", !radiobutton.isEnabled());
	}
	
	
	@Test
	public void testBotonConfirmarTicketDeshabilitadoRemuneracionNegativa() {
		robot.delay(TestUtils.getDelay());
		JButton botonConfirmarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.CONFIRMARNUEVOTICKET);
		JTextField textfield = (JTextField) TestUtils.getComponentForName(vent, Constantes.TEXTFIELD_REMUNERACION);
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		TestUtils.clickComponent(textfield, robot);
		TestUtils.tipeaTexto("-1000", robot);
		assertTrue("El boton para confirmar el nuevo ticket debería estar deshabilitado", !botonConfirmarTicket.isEnabled());
	}
	
	@Test
	public void testBotonConfirmarTicketHabilitado() {
		robot.delay(TestUtils.getDelay());
		JButton botonConfirmarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.CONFIRMARNUEVOTICKET);
		JTextField textfield = (JTextField) TestUtils.getComponentForName(vent, Constantes.TEXTFIELD_REMUNERACION);
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		TestUtils.clickComponent(textfield, robot);
		TestUtils.tipeaTexto("1000", robot);
		assertTrue("El boton para confirmar el nuevo ticket debería estar habilitado", botonConfirmarTicket.isEnabled());
	}
	
	@Test
	public void testTextFieldRemuneracionHabilitado() {
		robot.delay(TestUtils.getDelay());
		JTextField textfield = (JTextField) TestUtils.getComponentForName(vent, Constantes.TEXTFIELD_REMUNERACION);
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		assertTrue("El campo remuneracion debería estar deshabilitado", textfield.isEnabled());
	}
	
	
	@Test
	public void testRadioBotonHabilitado() { // recortamos aca, solo testeamos uno
		robot.delay(TestUtils.getDelay());
		JRadioButton radiobutton = (JRadioButton) TestUtils.getComponentForName(vent, Constantes.HOME_OFFICE);
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		assertTrue("El boton para confirmar el nuevo ticket debería estar habilitado", radiobutton.isEnabled());
	}
	
	@Test
	public void testNuevoTicketDeshabilitado() {
		robot.delay(TestUtils.getDelay());
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		assertTrue("El boton para crear ticket debería estar deshabilitado", !botonNuevoTicket.isEnabled());
	}
	
	
	@Test
	public void testConfirmarTicketClick() {
		robot.delay(TestUtils.getDelay());
		JButton botonConfirmarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.CONFIRMARNUEVOTICKET);
		JTextField textfield = (JTextField) TestUtils.getComponentForName(vent, Constantes.TEXTFIELD_REMUNERACION);
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		TestUtils.clickComponent(textfield, robot);
		TestUtils.tipeaTexto("1000", robot);
		TestUtils.clickComponent(botonConfirmarTicket, robot);
		assertTrue("El boton para confirmar el nuevo ticket debería estar deshabilitado", !botonConfirmarTicket.isEnabled());
		assertTrue("El boton para crear ticket debería estar habilitado", botonNuevoTicket.isEnabled());
	}
	
	@Test
	public void testBotonEliminarTicketDeshabilitado() {
		robot.delay(TestUtils.getDelay());
		JButton botonEliminarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.ELIMINAR_TICKET);
		assertTrue("El boton para eliminar ticket debería estar deshabilitado", !botonEliminarTicket.isEnabled());
	}
	
	
	@Test
	public void testBotonEliminarTicketHabilitado() {
		robot.delay(TestUtils.getDelay());
		JButton botonConfirmarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.CONFIRMARNUEVOTICKET);
		JTextField textfield = (JTextField) TestUtils.getComponentForName(vent, Constantes.TEXTFIELD_REMUNERACION);
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		TestUtils.clickComponent(textfield, robot);
		TestUtils.tipeaTexto("1000", robot);
		TestUtils.clickComponent(botonConfirmarTicket, robot);
		JButton botonEliminarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.ELIMINAR_TICKET);
		robot.delay(TestUtils.getDelay());
		assertTrue("El boton para eliminar ticket debería estar habilitado", botonEliminarTicket.isEnabled());
	}
	
	
	

}
