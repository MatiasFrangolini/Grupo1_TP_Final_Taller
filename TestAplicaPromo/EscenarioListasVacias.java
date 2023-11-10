package TestAplicaPromo;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import util.Constantes;

public class EscenarioListasVacias {

	private HashMap<String, Empleador> empleadores = new HashMap<String, Empleador>();
	private HashMap<String, EmpleadoPretenso> empleados = new HashMap<String, EmpleadoPretenso>();


	public HashMap<String, Empleador> getEmpleadores() {
		return empleadores;
	}

	public HashMap<String, EmpleadoPretenso> getEmpleados() {
		return empleados;
	}

}
