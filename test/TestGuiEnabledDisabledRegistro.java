package test;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import modeloNegocio.Agencia;
import util.Constantes;
import vista.Ventana;

public class TestGuiEnabledDisabledRegistro {
	
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
		robot.delay(TestUtils.getDelay());
	}

	@After
	public void tearDown() throws Exception {
	}

	//Al pulsar el botón REG_BUTTON_CANCELAR se vuelve al panel de Login

	@Test
	public void testEmpleadorConTodosLosDatos() {
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
		
		assertTrue("El boton deberia estar habilitado", botonRegistrar.isEnabled());
	}
	
	@Test
	public void testEmpleadoConTodosLosDatos() {
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
		
		assertTrue("El boton deberia estar habilitado", botonRegistrar.isEnabled());
	}
	
	@Test
	public void testEmpleadoSinDatosDerecha() {
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
		
		assertTrue("El boton deberia estar deshabilitado", !botonRegistrar.isEnabled());
	}
		
	@Test
	public void testEmpleadoConEdadNegativa() {
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
		TestUtils.tipeaTexto("-22", robot);
		
		assertTrue("El boton deberia estar deshabilitado", !botonRegistrar.isEnabled());
	}
	
	@Test
	public void testEmpleadorSinConfirmarPass() {
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
		TestUtils.clickComponent(textoRealName, robot);
		TestUtils.tipeaTexto("Bernardo", robot);
		TestUtils.clickComponent(textoTelefono, robot);
		TestUtils.tipeaTexto("2231234567", robot);
		
		assertTrue("El boton deberia estar deshabilitado", !botonRegistrar.isEnabled());
	}
	
	
}
