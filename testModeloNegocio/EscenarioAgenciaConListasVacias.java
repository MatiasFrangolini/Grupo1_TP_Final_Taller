package testModeloNegocio;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;

public class EscenarioAgenciaConListasVacias {

	private Agencia a;
	private HashMap<String, EmpleadoPretenso> empleados = new HashMap<String, EmpleadoPretenso>();
	private HashMap<String, Empleador> empleadores = new HashMap<String, Empleador>();
	
	
	//EN ESTE ESCENARIO TAMBIEN SE UTILIZA ESTADO CONTRATACION = FALSE
	
	{
		a = Agencia.getInstance();
		a.setEmpleadores(empleadores);
		a.setEmpleados(empleados);
		a.setEstadoContratacion(false);
	}
	
	
	public HashMap<String, EmpleadoPretenso> getEmpleados() {
		return empleados;
	}



	public HashMap<String, Empleador> getEmpleadores() {
		return empleadores;
	}
	

}
