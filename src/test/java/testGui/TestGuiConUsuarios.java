package testGui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Robot;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;
import util.Mensajes;
import vista.PanelRegistro;
import vista.Ventana;

public class TestGuiConUsuarios {

	Robot robot;
	Controlador controlador;
	Ventana vent;
	FalsoOptionPane op = new FalsoOptionPane();
	Agencia a;
	
	public TestGuiConUsuarios() {
		controlador = new Controlador();
		vent = (Ventana) this.controlador.getVista();
		//vent = new Ventana(controlador);
		//controlador.setVista(vent);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void setUp() throws Exception {
		
		controlador.setMyOptionPane(op);
		a = Agencia.getInstance();
		a.registroEmpleado("Mati", "123456", "Matias", "Frangolini", "223123456", 21);
		a.registroEmpleador("Berni", "berni1234", "Bernardo", "223123456", Constantes.FISICA, Constantes.SALUD);
		robot.delay(TestUtils.getDelay());
	}

	@After
	public void tearDown() throws Exception {
		a.setEmpleadores(new HashMap<String, Empleador>());
		a.setEmpleados(new HashMap<String, EmpleadoPretenso>());
		this.vent.setVisible(false);
	}
	
	
	@Test
	public void testLoginExitoso() {
		
		robot.delay(TestUtils.getDelay());
		JTextField textoUsuario = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.NOMBRE_USUARIO);
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.PASSWORD);
		JButton botonLogin = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.LOGIN);
		
		//lleno los JTextField
        TestUtils.clickComponent(textoUsuario, robot);
        TestUtils.tipeaTexto("Mati", robot);
        TestUtils.clickComponent(textoPass, robot);
        TestUtils.tipeaTexto("123456", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(botonLogin, robot);
        assertTrue("No se llamó al método login", this.a.getTipoUsuario() == 0);
		
	}
	
	@Test
	public void testLoginUsuarioErroneo() {
		
		robot.delay(TestUtils.getDelay());
		JTextField textoUsuario = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.NOMBRE_USUARIO);
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.PASSWORD);
		JButton botonLogin = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.LOGIN);
		
		//lleno los JTextField
        TestUtils.clickComponent(textoUsuario, robot);
        TestUtils.tipeaTexto("MatiasFrangolini", robot);
        TestUtils.clickComponent(textoPass, robot);
        TestUtils.tipeaTexto("123456", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(botonLogin, robot);

        assertEquals("No se mostró el mensaje esperado", Mensajes.USUARIO_DESCONOCIDO.getValor(), op.getMensaje());
        
		
	}
	
	@Test
	public void testLoginPassErroneo() {
		
		robot.delay(TestUtils.getDelay());
		JTextField textoUsuario = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.NOMBRE_USUARIO);
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.PASSWORD);
		JButton botonLogin = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.LOGIN);
		
		//lleno los JTextField
        TestUtils.clickComponent(textoUsuario, robot);
        TestUtils.tipeaTexto("Mati", robot);
        TestUtils.clickComponent(textoPass, robot);
        TestUtils.tipeaTexto("654321", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(botonLogin, robot);

        assertEquals("No se mostró el mensaje esperado", Mensajes.PASS_ERRONEO.getValor(), op.getMensaje());
        
		
	}
	
	
	
	@Test
	public void testPasaAPanelRegistro() {
		
		robot.delay(TestUtils.getDelay());
		JPanel panelReg = new PanelRegistro(this.controlador);
		JButton botonRegistrar = (JButton) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.REGISTRAR);
		TestUtils.clickComponent(botonRegistrar, robot);
	//AVERIGUAR COMO CHECKEAR ESTO	assertEquals("No se cambio al panel registro", this.vent.getContentPane(),	panelReg);
	}
	

}
