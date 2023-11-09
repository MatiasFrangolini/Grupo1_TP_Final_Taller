package testModeloNegocio;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import testModeloDatos.EscenarioTicketCasos1;
import testModeloDatos.EscenarioTicketCasos2;
import testModeloDatos.EscenarioTicketCasos3;

public class EscenarioGeneraPostulantes {
	
	
	HashMap<String, EmpleadoPretenso> empleados = new HashMap<String, EmpleadoPretenso>();
	HashMap<String, Empleador> empleadores = new HashMap<String, Empleador>();

	public EscenarioGeneraPostulantes() {
		EmpleadoPretenso empleado1 = new EmpleadoPretenso("Mati", "123456", "Matias", "2235825715", "Frangolini", 21);
		EmpleadoPretenso empleado2 = new EmpleadoPretenso("Fran", "123456", "Francisco", "2235825715", "Florio", 21);
		EmpleadoPretenso empleado3 = new EmpleadoPretenso("Pedro", "123456", "Pedro", "2235825715", "Iarritu", 21);
		EmpleadoPretenso empleado4 = new EmpleadoPretenso("Berni", "123456", "Bernardo", "2235825715", "Porfilio", 21);
		
		Empleador empleador1 = new Empleador("Mati", "123456", "Matias", "2235825715", "COMERCIO_LOCAL", "FISICA");
		Empleador empleador2 = new Empleador("Fran", "123456", "Francisco", "2235825715", "COMERCIO_LOCAL", "FISICA");
		Empleador empleador3 = new Empleador("Pedro", "123456", "Pedro", "2235825715", "COMERCIO_LOCAL", "FISICA");
		Empleador empleador4 = new Empleador("Berni", "123456", "Bernardo", "2235825715", "COMERCIO_LOCAL", "FISICA");
		
		EscenarioTicketCasos1 esc1 = new EscenarioTicketCasos1();
		EscenarioTicketCasos2 esc2 = new EscenarioTicketCasos2();
		EscenarioTicketCasos3 esc3 = new EscenarioTicketCasos3();
		
		empleado1.setTicket(esc1.getTicket());
		empleado2.setTicket(esc2.getTicket());
		empleado3.setTicket(esc3.getTicket());
		empleado4.setTicket(esc1.getTicket());
		
		empleador1.setTicket(esc3.getTicket());
		empleador2.setTicket(esc1.getTicket());
		empleador3.setTicket(esc2.getTicket());
		empleador4.setTicket(esc2.getTicket());
		
		empleado1.setPuntaje(50);
		empleado2.setPuntaje(500);
		empleado3.setPuntaje(150);
		empleado4.setPuntaje(25);
		
		empleador1.setPuntaje(5);
		empleador2.setPuntaje(125);
		empleador3.setPuntaje(70);
		empleador4.setPuntaje(30);
		
		empleados.put("Mati", empleado1);
		empleados.put("Fran", empleado2);
		empleados.put("Pedro", empleado3);
		empleados.put("Berni", empleado4);
		
		empleadores.put("Mati", empleador1);
		empleadores.put("Fran", empleador2);
		empleadores.put("Pedro", empleador3);
		empleadores.put("Berni", empleador4);
	}
	
	public HashMap<String, Empleador> getEmpleadores() {
		return empleadores;
	}
	
	public HashMap<String, EmpleadoPretenso> getEmpleados() {
		return empleados;
	}

}
