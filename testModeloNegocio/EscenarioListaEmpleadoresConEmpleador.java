package testModeloNegocio;

import java.util.HashMap;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;

public class EscenarioListaEmpleadoresConEmpleador {
	
	private HashMap<String, Empleador> empleadores = new HashMap<String, Empleador>();
	
	public EscenarioListaEmpleadoresConEmpleador() {
		Empleador empleador = new Empleador("Berni", "berni1234", "Bernardo", "223123456", "SALUD", "FISICA");
		empleadores.put("Berni", empleador);
	}
	
	public HashMap<String, Empleador> getEmpleadores() {
		return empleadores;
	}

}
