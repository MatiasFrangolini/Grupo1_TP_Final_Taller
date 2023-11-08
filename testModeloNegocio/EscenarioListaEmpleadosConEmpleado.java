package testModeloNegocio;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import modeloDatos.EmpleadoPretenso;

public class EscenarioListaEmpleadosConEmpleado {
	
	private HashMap<String, EmpleadoPretenso> empleados = new HashMap<String, EmpleadoPretenso>();
	
	public EscenarioListaEmpleadosConEmpleado() {
		EmpleadoPretenso empleado = new EmpleadoPretenso("Berni", "123456", "Bernardo", "2235825715", "Porfilio", 21);
		empleados.put("Berni", empleado);
	}
	
	public HashMap<String, EmpleadoPretenso> getEmpleados() {
		return empleados;
	}

}
