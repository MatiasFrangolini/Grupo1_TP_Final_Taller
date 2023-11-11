package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Component;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
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
import util.Mensajes;
import vista.Ventana;

public class TestGuiConUsuariosCliente {

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
		lista.add(new ClientePuntaje(10, c));
		a.getEmpleados().get("Mati").setListaDePostulantes(lista);
		logueaEmpleado();
		robot.delay(TestUtils.getDelay());
		this.a.setEstadoContratacion(false);
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
	public void testSeleccionarCandidato() {
		 robot.delay(TestUtils.getDelay());
		 JButton botonSeleccionar = (JButton) TestUtils.getComponentForName(vent, Constantes.SELECCIONAR_CANDIDATO);
		 JList listaCandidatos = (JList) TestUtils.getComponentForName(vent, Constantes.LISTA_CANDIDATOS);
		 TestUtils.clickComponent(listaCandidatos, robot);
		 TestUtils.clickComponent(botonSeleccionar, robot);
		 assertEquals("No se llamó al método seleccionarCandidato", c, this.a.getEmpleados().get("Mati").getCandidato());
	}
	
	
	@Test
	public void testCrearTicket() {
		robot.delay(TestUtils.getDelay());
		JButton botonConfirmarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.CONFIRMARNUEVOTICKET);
		JTextField textfield = (JTextField) TestUtils.getComponentForName(vent, Constantes.TEXTFIELD_REMUNERACION);
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		TestUtils.clickComponent(textfield, robot);
		TestUtils.tipeaTexto("1000", robot);
		TestUtils.clickComponent(botonConfirmarTicket, robot);
		assertTrue("No se creo el ticket", this.a.getEmpleados().get("Mati").getTicket() != null);
		
	}
	
	@Test
	public void testCrearTicketExcepcion() {
		robot.delay(TestUtils.getDelay());
		this.a.setEstadoContratacion(true);
		JButton botonConfirmarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.CONFIRMARNUEVOTICKET);
		JTextField textfield = (JTextField) TestUtils.getComponentForName(vent, Constantes.TEXTFIELD_REMUNERACION);
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		TestUtils.clickComponent(textfield, robot);
		TestUtils.tipeaTexto("1000", robot);
		TestUtils.clickComponent(botonConfirmarTicket, robot);
		assertEquals("No se mostró el mensaje debido", Mensajes.ERROR_AGENCIA_EN_CONTRATACION.getValor(), op.getMensaje());
		
	}
	
	
	@Test
	public void testEliminarTicket() {
		robot.delay(TestUtils.getDelay());
		JButton botonConfirmarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.CONFIRMARNUEVOTICKET);
		JTextField textfield = (JTextField) TestUtils.getComponentForName(vent, Constantes.TEXTFIELD_REMUNERACION);
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		JButton botonEliminarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.ELIMINAR_TICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		TestUtils.clickComponent(textfield, robot);
		TestUtils.tipeaTexto("1000", robot);
		TestUtils.clickComponent(botonConfirmarTicket, robot);
		TestUtils.clickComponent(botonEliminarTicket, robot);
		assertTrue("No se eliminó el ticket", this.a.getEmpleados().get("Mati").getTicket() == null);
		
	}
	
	@Test
	public void testEliminarTicketExcepcion() {
		robot.delay(TestUtils.getDelay());
		JButton botonConfirmarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.CONFIRMARNUEVOTICKET);
		JTextField textfield = (JTextField) TestUtils.getComponentForName(vent, Constantes.TEXTFIELD_REMUNERACION);
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		JButton botonEliminarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.ELIMINAR_TICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		TestUtils.clickComponent(textfield, robot);
		TestUtils.tipeaTexto("1000", robot);
		TestUtils.clickComponent(botonConfirmarTicket, robot);
		this.a.setEstadoContratacion(true);
		TestUtils.clickComponent(botonEliminarTicket, robot);
		assertEquals("No se mostró el mensaje debido", Mensajes.ERROR_AGENCIA_EN_CONTRATACION.getValor(), op.getMensaje());
		
	}
	
	
	@Test
	public void testTextAreaTicketConTicket() {
		robot.delay(TestUtils.getDelay());
		JButton botonConfirmarTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.CONFIRMARNUEVOTICKET);
		JTextField textfield = (JTextField) TestUtils.getComponentForName(vent, Constantes.TEXTFIELD_REMUNERACION);
		JTextArea textAreaTicket= (JTextArea) TestUtils.getComponentForName(vent, Constantes.TEXT_AREA_TICKET);
		JButton botonNuevoTicket = (JButton) TestUtils.getComponentForName(vent, Constantes.NUEVOTICKET);
		TestUtils.clickComponent(botonNuevoTicket, robot);
		TestUtils.clickComponent(textfield, robot);
		TestUtils.tipeaTexto("1000", robot);
		TestUtils.clickComponent(botonConfirmarTicket, robot);
		assertEquals("El detalle del ticket no es correcto", textAreaTicket.getText(), this.a.getEmpleados().get("Mati").getTicket().toString());
	}
	
	@Test
	public void testTextAreaTicketSinTicket() {
		robot.delay(TestUtils.getDelay());
		JTextArea textAreaTicket= (JTextArea) TestUtils.getComponentForName(vent, Constantes.TEXT_AREA_TICKET);
		assertEquals("El detalle del ticket no es correcto", textAreaTicket.getText(), Mensajes.SIN_TICKET.getValor());
	}
	

}
