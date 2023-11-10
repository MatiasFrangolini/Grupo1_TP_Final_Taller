package testModeloNegocio;

import java.util.HashMap;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
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
	//private EmpleadoPretenso empleado4;
	private Empleador empleador1;
	private Empleador empleador2;
	private Empleador empleador3;
	private Empleador empleador4;
	private Ticket t1;
	private Ticket t2;
	private Ticket t3;
	private Ticket t4;

	
	{
		a = Agencia.getInstance();

		empleado1 = new EmpleadoPretenso("Mati", "123456", "Matias", "2235825715", "Frangolini", 21);
		empleado2 = new EmpleadoPretenso("Berni", "berni1234", "Bernardo", "223123456", "Porfilio", 22);
		empleado3 = new EmpleadoPretenso("Pedro", "123456", "Pedro", "2235825715", "Iarritu", 21);
		//empleado4 = new EmpleadoPretenso("Fran", "123456", "Francisco", "2235825715", "Florio", 21);
		
		
		empleador1 = new Empleador("Mati", "123456", "Matias", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		empleador2 = new Empleador("Fran", "123456", "Francisco", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		empleador3 = new Empleador("Pedro", "123456", "Pedro", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
		empleador4 = new Empleador("Berni", "123456", "Bernardo", "223123456", Constantes.SALUD, Constantes.FISICA);
		
		t1 = new Ticket(Constantes.HOME_OFFICE, 1500, Constantes.JORNADA_COMPLETA, Constantes.SENIOR, Constantes.EXP_MEDIA, Constantes.SECUNDARIOS);
		t2 = new Ticket(Constantes.HOME_OFFICE, 2500, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.SECUNDARIOS);
		t3 = new Ticket(Constantes.INDISTINTO, 3500, Constantes.JORNADA_EXTENDIDA, Constantes.JUNIOR, Constantes.EXP_MUCHA, Constantes.PRIMARIOS);
		t4 = new Ticket(Constantes.PRESENCIAL, 4500, Constantes.JORNADA_MEDIA, Constantes.MANAGMENT, Constantes.EXP_MUCHA, Constantes.TERCIARIOS);
		
		empleado1.setTicket(t1);
		empleado2.setTicket(t4);
		empleado3.setTicket(t3);
		//empleado4.setTicket(t2);
		
		empleador1.setTicket(t3);
		empleador2.setTicket(t1);
		empleador3.setTicket(t2);
		empleador4.setTicket(t4);
		
		empleados.put("Mati", empleado1);
		empleados.put("Berni", empleado2);
		empleados.put("Pedro", empleado3);
		//empleados.put("Fran", empleado4);
		
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
