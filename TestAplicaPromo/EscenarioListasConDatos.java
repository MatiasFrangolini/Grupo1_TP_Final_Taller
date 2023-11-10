package TestAplicaPromo;

import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import util.Constantes;

public class EscenarioListasConDatos {

	private HashMap<String, Empleador> empleadores = new HashMap<String, Empleador>();
	private HashMap<String, EmpleadoPretenso> empleados = new HashMap<String, EmpleadoPretenso>();
	private EmpleadoPretenso empleado;
	private Empleador empleador;

	
	{
		empleado = new EmpleadoPretenso("Fran", "123456", "Francisco", "2235825715", "Florio", 21);
		empleador = new Empleador("Mati", "123456", "Matias", "2235825715", Constantes.COMERCIO_LOCAL, Constantes.FISICA);
	}

	public HashMap<String, Empleador> getEmpleadores() {
		return empleadores;
	}

	public HashMap<String, EmpleadoPretenso> getEmpleados() {
		return empleados;
	}

	
	
	

}
