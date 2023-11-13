package testGui;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Robot;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestGuiEnabledDisabled {
	
	Robot robot;
	Controlador controlador;
	FalsoOptionPane op = new FalsoOptionPane();
	Agencia a;

	@Before
	public void setUp() throws Exception {
		robot = new Robot();
		controlador = new Controlador();
		controlador.setMyOptionPane(op);
		a = Agencia.getInstance();
		robot.delay(TestUtils.getDelay());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoginSoloUsuario() {
		
		robot.delay(TestUtils.getDelay());
		JTextField textoUsuario = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.NOMBRE_USUARIO);
		JButton botonLogin = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.LOGIN);
		
		//lleno los JTextField
        TestUtils.clickComponent(textoUsuario, robot);
        TestUtils.tipeaTexto("Mati", robot);
        robot.delay(TestUtils.getDelay());
        assertTrue("El boton Login deberia estar deshabilitado", !botonLogin.isEnabled());
		
	}
	
	
	@Test
	public void testLoginSoloPass() {
		
		robot.delay(TestUtils.getDelay());
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.PASSWORD);
		JButton botonLogin = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.LOGIN);
		
		//lleno los JTextField
        TestUtils.clickComponent(textoPass, robot);
        TestUtils.tipeaTexto("123456", robot);
        robot.delay(TestUtils.getDelay());
        assertTrue("El boton Login deberia estar deshabilitado", !botonLogin.isEnabled());
		
	}
	
	@Test
	public void testLoginHabilitado() {
		
		robot.delay(TestUtils.getDelay());
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.PASSWORD);
		JTextField textoUsuario = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.NOMBRE_USUARIO);
		JButton botonLogin = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.LOGIN);
		
		//lleno los JTextField
		TestUtils.clickComponent(textoUsuario, robot);
        TestUtils.tipeaTexto("Mati", robot);
        TestUtils.clickComponent(textoPass, robot);
        TestUtils.tipeaTexto("123456", robot);
        robot.delay(TestUtils.getDelay());
        assertTrue("El boton Login deberia estar habilitado", botonLogin.isEnabled());
		
	}

}
