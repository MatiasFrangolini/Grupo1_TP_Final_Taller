package test;

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
import modeloNegocio.Agencia;
import util.Constantes;
import vista.Ventana;

public class TestGuiEnabledDisabledAdmin {

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
		logueaAdmin();
		robot.delay(TestUtils.getDelay());
	}

	@After
	public void tearDown() throws Exception {
	}
	
	public void logueaAdmin() {
		JButton botonLogin = (JButton) TestUtils.getComponentForName(vent, Constantes.LOGIN);
		JTextField textoUsuario = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.NOMBRE_USUARIO);
		JTextField textoPass = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.PASSWORD);
		
		TestUtils.clickComponent(textoUsuario, robot);
        TestUtils.tipeaTexto("admin", robot);
        TestUtils.clickComponent(textoPass, robot);
        TestUtils.tipeaTexto("admin", robot);
        TestUtils.clickComponent(botonLogin, robot);
	}
	
	
	@Test
	public void testModificarValoresDeshabilitado1() {
		robot.delay(TestUtils.getDelay());
		JTextField textoLimInf = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.TEXTO_INFERIOR);
		JTextField textoLimSup = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.TEXTO_SUPERIOR);
		JButton botonCambiar = (JButton) TestUtils.getComponentForName(vent, Constantes.MODIFICAR_VALORES);
		
		TestUtils.clickComponent(textoLimInf, robot);
        TestUtils.tipeaTexto("2000", robot);
        TestUtils.clickComponent(textoLimSup, robot);
        TestUtils.tipeaTexto("500", robot);
        assertTrue("El boton de modificar valores deberia estar deshabilitado", !botonCambiar.isEnabled());
		
	}
	
	@Test
	public void testModificarValoresDeshabilitado2() {
		robot.delay(TestUtils.getDelay());
		JTextField textoLimInf = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.TEXTO_INFERIOR);
		JTextField textoLimSup = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.TEXTO_SUPERIOR);
		JButton botonCambiar = (JButton) TestUtils.getComponentForName(vent, Constantes.MODIFICAR_VALORES);
		
		TestUtils.clickComponent(textoLimInf, robot);
        TestUtils.tipeaTexto("-2000", robot);
        TestUtils.clickComponent(textoLimSup, robot);
        TestUtils.tipeaTexto("5000", robot);
        assertTrue("El boton de modificar valores deberia estar deshabilitado", !botonCambiar.isEnabled());
		
	}
	
	@Test
	public void testModificarValoresHabilitado() {
		robot.delay(TestUtils.getDelay());
		JTextField textoLimInf = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.TEXTO_INFERIOR);
		JTextField textoLimSup = (JTextField) TestUtils.getComponentForName((Component) this.controlador.getVista(), Constantes.TEXTO_SUPERIOR);
		JButton botonCambiar = (JButton) TestUtils.getComponentForName(vent, Constantes.MODIFICAR_VALORES);
		
		TestUtils.clickComponent(textoLimInf, robot);
        TestUtils.tipeaTexto("2000", robot);
        TestUtils.clickComponent(textoLimSup, robot);
        TestUtils.tipeaTexto("5000", robot);
        robot.delay(TestUtils.getDelay());
        assertTrue("El boton de modificar valores deberia estar habilitado", botonCambiar.isEnabled());
		
	}

}
