package testModeloNegocio;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import testModeloDatos.EscenarioTicketCasos1;
import testModeloDatos.EscenarioTicketCasos2;
import testModeloDatos.EscenarioTicketCasos3;
import util.Constantes;

public class EscenarioAgenciaConListasConDatos {
	
	private Agencia a;
	private HashMap<String, EmpleadoPretenso> empleados = new HashMap<String, EmpleadoPretenso>();
	private HashMap<String, Empleador> empleadores = new HashMap<String, Empleador>();
	private EmpleadoPretenso empleado1;
	private EmpleadoPretenso empleado2;
	private EmpleadoPretenso empleado3;
	private EmpleadoPretenso empleado4;
	private Empleador empleador1;
	private Empleador empleador2;
	private Empleador empleador3;
	private Empleador empleador4;
	private EscenarioTicketCasos1 esc1;
	private EscenarioTicketCasos2 esc2;
	private EscenarioTicketCasos3 esc3;
	
	//EN ESTE ESCENARIO TAMBIEN SE UTILIZA ESTADO CONTRATACION = TRUE
	
	{
		a = Agencia.getInstance();
		a.setEstadoContratacion(true);

		empleado1 = new EmpleadoPretenso("Mati", "123456", "Matias", "2235825715", "Frangolini", 21);
		empleado2 = new EmpleadoPretenso("Fran", "123456", "Francisco", "2235825715", "Florio", 21);
		empleado3 = new EmpleadoPretenso("Pedro", "123456", "Pedro", "2235825715", "Iarritu", 21);
		empleado4 = new EmpleadoPretenso("Berni", "berni1234", "Bernardo", "223123456", "Porfilio", 22);
		
		empleador1 = new Empleador("Mati", "123456", "Matias", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		empleador2 = new Empleador("Fran", "123456", "Francisco", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		empleador3 = new Empleador("Pedro", "123456", "Pedro", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		empleador4 = new Empleador("Berni", "berni1234", "Bernardo", "223123456", Constantes.SALUD, Constantes.FISICA);
		
		esc1 = new EscenarioTicketCasos1();
		esc2 = new EscenarioTicketCasos2();
		esc3 = new EscenarioTicketCasos3();
		
		empleado1.setTicket(esc1.getTicket());
		empleado2.setTicket(esc2.getTicket());
		empleado3.setTicket(esc3.getTicket());
		empleado4.setTicket(esc1.getTicket());
		
		empleador1.setTicket(esc3.getTicket());
		empleador2.setTicket(esc1.getTicket());
		empleador3.setTicket(esc2.getTicket());
		empleador4.setTicket(esc2.getTicket());
		
		empleados.put("Mati", empleado1);
		empleados.put("Fran", empleado2);
		empleados.put("Pedro", empleado3);
		empleados.put("Berni", empleado4);
		
		empleadores.put("Mati", empleador1);
		empleadores.put("Fran", empleador2);
		empleadores.put("Pedro", empleador3);
		empleadores.put("Berni", empleador4);
		
		a.setEmpleadores(empleadores);
		a.setEmpleados(empleados);
		
		
	}



	public HashMap<String, EmpleadoPretenso> getEmpleados() {
		return empleados;
	}



	public HashMap<String, Empleador> getEmpleadores() {
		return empleadores;
	}
	
	
	

	

}
