package testGui;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Robot;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlador.Controlador;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;
import util.Mensajes;
import vista.Ventana;

public class TestGuiConUsuariosRegistro {
	
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
		JButton botonRegistrar = (JButton) TestUtils.getComponentForName(vent, Constantes.REGISTRAR);
		TestUtils.clickComponent(botonRegistrar, robot);
		a = Agencia.getInstance();
		a.registroEmpleado("Berni", "manteca123", "Bernardo", "Porfilio" , "223123456", 22);
		a.registroEmpleador("Mati","loki123", "Matias", "226235478", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL);
		robot.delay(TestUtils.getDelay());
	}

	@After
	public void tearDown() throws Exception {
		a.setEmpleadores(new HashMap<String, Empleador>());
		a.setEmpleados(new HashMap<String, EmpleadoPretenso>());
		this.vent.setVisible(false);
	}
	

	@Test
	public void testRegistroEmpleadorExitoso() {
		int sizeanterior = a.getEmpleadores().size();
		robot.delay(TestUtils.getDelay());
		JTextField textoUserName = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_USSER_NAME);
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_PASSWORD);
		JTextField textoConfPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_CONFIRM_PASSWORD);
		JTextField textoRealName = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_REAL_NAME);
		JTextField textoTelefono = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_TELEFONO);
		JRadioButton radioempleador = (JRadioButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.EMPLEADOR);
		JButton botonRegistrar = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_BUTTON_REGISTRAR);
		TestUtils.clickComponent(radioempleador, robot);
		TestUtils.clickComponent(textoUserName, robot);
		TestUtils.tipeaTexto("berni1234", robot);
		TestUtils.clickComponent(textoPass, robot);
		TestUtils.tipeaTexto("milanga", robot);
		TestUtils.clickComponent(textoConfPass, robot);
		TestUtils.tipeaTexto("milanga", robot);
		TestUtils.clickComponent(textoRealName, robot);
		TestUtils.tipeaTexto("Bernardo", robot);
		TestUtils.clickComponent(textoTelefono, robot);
		TestUtils.tipeaTexto("2231234567", robot);
		TestUtils.clickComponent(botonRegistrar, robot);
		
		assertTrue("No se registro al empleador", a.getEmpleadores().size()==sizeanterior+1);
	}

	@Test
	public void testRegistroEmpleadoExitoso() {
		int sizeanterior = a.getEmpleados().size();
		robot.delay(TestUtils.getDelay());
		JTextField textoUserName = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_USSER_NAME);
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_PASSWORD);
		JTextField textoConfPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_CONFIRM_PASSWORD);
		JTextField textoRealName = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_REAL_NAME);
		JTextField textoTelefono = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_TELEFONO);
		JTextField textoApellido = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_APELLIDO);
		JTextField textoEdad = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_EDAD);
		JRadioButton radioempleado = (JRadioButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.EMPLEADO);
		JButton botonRegistrar = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_BUTTON_REGISTRAR);
		TestUtils.clickComponent(radioempleado, robot);
		TestUtils.clickComponent(textoUserName, robot);
		TestUtils.tipeaTexto("berni1234", robot);
		TestUtils.clickComponent(textoPass, robot);
		TestUtils.tipeaTexto("milanga", robot);
		TestUtils.clickComponent(textoConfPass, robot);
		TestUtils.tipeaTexto("milanga", robot);
		TestUtils.clickComponent(textoRealName, robot);
		TestUtils.tipeaTexto("Bernardo", robot);
		TestUtils.clickComponent(textoTelefono, robot);
		TestUtils.tipeaTexto("2231234567", robot);
		TestUtils.clickComponent(textoApellido, robot);
		TestUtils.tipeaTexto("Porfilio", robot);
		TestUtils.clickComponent(textoEdad, robot);
		TestUtils.tipeaTexto("22", robot);
		TestUtils.clickComponent(botonRegistrar, robot);
		robot.delay(TestUtils.getDelay());
		assertEquals("No se registro al empleado", a.getEmpleados().size()==sizeanterior+1);
	}
	
	@Test
	public void testRegistroEmpleadorRepetido() {
		robot.delay(TestUtils.getDelay());
		JTextField textoUserName = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_USSER_NAME);
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_PASSWORD);
		JTextField textoConfPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_CONFIRM_PASSWORD);
		JTextField textoRealName = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_REAL_NAME);
		JTextField textoTelefono = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_TELEFONO);
		JRadioButton radioempleador = (JRadioButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.EMPLEADOR);
		JButton botonRegistrar = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_BUTTON_REGISTRAR);
		TestUtils.clickComponent(radioempleador, robot);
		TestUtils.clickComponent(textoUserName, robot);
		TestUtils.tipeaTexto("Mati", robot);
		TestUtils.clickComponent(textoPass, robot);
		TestUtils.tipeaTexto("milanga", robot);
		TestUtils.clickComponent(textoConfPass, robot);
		TestUtils.tipeaTexto("milanga", robot);
		TestUtils.clickComponent(textoRealName, robot);
		TestUtils.tipeaTexto("Bernardo", robot);
		TestUtils.clickComponent(textoTelefono, robot);
		TestUtils.tipeaTexto("2231234567", robot);
		TestUtils.clickComponent(botonRegistrar, robot);
		robot.delay(TestUtils.getDelay());
		assertEquals("No se mostró el mensaje esperado", Mensajes.USUARIO_REPETIDO.getValor(), op.getMensaje());
	}
		
	@Test
	public void testRegistroEmpleadoRepetido() {
		robot.delay(TestUtils.getDelay());
		JTextField textoUserName = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_USSER_NAME);
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_PASSWORD);
		JTextField textoConfPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_CONFIRM_PASSWORD);
		JTextField textoRealName = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_REAL_NAME);
		JTextField textoTelefono = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_TELEFONO);
		JTextField textoApellido = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_APELLIDO);
		JTextField textoEdad = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_EDAD);
		JRadioButton radioempleado = (JRadioButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.EMPLEADO);
		JButton botonRegistrar = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_BUTTON_REGISTRAR);
		TestUtils.clickComponent(radioempleado, robot);
		TestUtils.clickComponent(textoUserName, robot);
		TestUtils.tipeaTexto("Berni", robot);
		TestUtils.clickComponent(textoPass, robot);
		TestUtils.tipeaTexto("milanga", robot);
		TestUtils.clickComponent(textoConfPass, robot);
		TestUtils.tipeaTexto("milanga", robot);
		TestUtils.clickComponent(textoRealName, robot);
		TestUtils.tipeaTexto("Bernardo", robot);
		TestUtils.clickComponent(textoTelefono, robot);
		TestUtils.tipeaTexto("2231234567", robot);
		TestUtils.clickComponent(textoApellido, robot);
		TestUtils.tipeaTexto("Porfilio", robot);
		TestUtils.clickComponent(textoEdad, robot);
		TestUtils.tipeaTexto("22", robot);
		TestUtils.clickComponent(botonRegistrar, robot);
		
		assertEquals("No se mostró el mensaje esperado", Mensajes.USUARIO_REPETIDO.getValor(), op.getMensaje());
	}	 
	
	@Test
	public void testPassDistintas() {
		robot.delay(TestUtils.getDelay());
		JTextField textoUserName = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_USSER_NAME);
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_PASSWORD);
		JTextField textoConfPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_CONFIRM_PASSWORD);
		JTextField textoRealName = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_REAL_NAME);
		JTextField textoTelefono = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_TELEFONO);
		JRadioButton radioempleador = (JRadioButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.EMPLEADOR);
		JButton botonRegistrar = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REG_BUTTON_REGISTRAR);
		TestUtils.clickComponent(radioempleador, robot);
		TestUtils.clickComponent(textoUserName, robot);
		TestUtils.tipeaTexto("berni1234", robot);
		TestUtils.clickComponent(textoPass, robot);
		TestUtils.tipeaTexto("milanga", robot);
		TestUtils.clickComponent(textoConfPass, robot);
		TestUtils.tipeaTexto("pizza", robot);
		TestUtils.clickComponent(textoRealName, robot);
		TestUtils.tipeaTexto("Bernardo", robot);
		TestUtils.clickComponent(textoTelefono, robot);
		TestUtils.tipeaTexto("2231234567", robot);
		TestUtils.clickComponent(botonRegistrar, robot);
		robot.delay(TestUtils.getDelay());
		assertEquals("No se mostró el mensaje esperado", Mensajes.PASS_NO_COINCIDE.getValor(), op.getMensaje());
	}
}
