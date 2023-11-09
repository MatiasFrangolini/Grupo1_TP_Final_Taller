package testModeloNegocio;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import modeloDatos.EmpleadoPretenso;

public class EscenarioListaEmpleadosVacia {
	
	private HashMap<String, EmpleadoPretenso> empleados = new HashMap<String, EmpleadoPretenso>();
	
	public HashMap<String, EmpleadoPretenso> getEmpleados() {
		return empleados;
	}

}
