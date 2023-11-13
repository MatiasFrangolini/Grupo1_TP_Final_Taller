package testGui;

import static org.junit.Assert.assertTrue;

import java.awt.Component;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import modeloDatos.Cliente;
import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;
import vista.Ventana;

public class TestGuiConUsuariosAdmin {

	Robot robot;
	Controlador controlador;
	Ventana vent;
	FalsoOptionPane op = new FalsoOptionPane();
	Agencia a;
	ArrayList<ClientePuntaje> lista = new ArrayList<ClientePuntaje>();
	Cliente c = new Empleador("Berni","123123", "Bernardo", "226235478", Constantes.SALUD, Constantes.FISICA);

	@Before
	public void setUp() throws Exception {
		robot = new Robot();
		controlador = new Controlador();
		vent = (Ventana) this.controlador.getVista();
		controlador.setMyOptionPane(op);
		a = Agencia.getInstance();
		a.registroEmpleado("Mati","loki123", "Matias", "Frangolini", "226235478", 21);
		a.registroEmpleador("Berni","123123", "Bernardo", "226235478", Constantes.FISICA, Constantes.SALUD);
		lista.add(new ClientePuntaje(10, c));
		a.getEmpleados().get("Mati").setListaDePostulantes(lista);
		logueaAdmin();
		robot.delay(TestUtils.getDelay());
	}

	@After
	public void tearDown() throws Exception {
		a.setEmpleados(new HashMap<String,EmpleadoPretenso>());
		a.setEmpleadores(new HashMap<String,Empleador>());
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
	public void testBotonGatillar() {
		robot.delay(TestUtils.getDelay());
		a.setEstadoContratacion(false);
		JButton botonGatillar = (JButton) TestUtils.getComponentForName(vent, Constantes.GATILLAR);
		TestUtils.clickComponent(botonGatillar, robot);
		assertTrue("No se llamo al metodo gatillarRonda", a.isEstadoContratacion());
	}
	
	
	@Test
	public void testBotonCerrarSesion() {
		robot.delay(TestUtils.getDelay());
		a.setEstadoContratacion(false);
		JButton botonCerrarSesion = (JButton) TestUtils.getComponentForName(vent, Constantes.CERRARSESION);
		TestUtils.clickComponent(botonCerrarSesion, robot);
		assertTrue("No se llamo al metodo gatillarRonda", a.getTipoUsuario() == -1);
	}

}
