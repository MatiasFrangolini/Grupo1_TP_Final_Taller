package testAplicaPromo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Cliente;
import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;

public class TestUtilPromo {
	
	private Agencia a;
	private EscenarioListasConDatos escDatos;
	private EscenarioListasVacias escVacio;
	private UtilPromo promo = new UtilPromo();

	@Before
	public void setUp() throws Exception {
		a = Agencia.getInstance();
		escDatos = new EscenarioListasConDatos();
		escVacio = new EscenarioListasVacias();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCamino1() {
		Cliente c = promo.aplicaPromo(false, escVacio.getEmpleados(), escVacio.getEmpleadores());
		assertNull("El cliente beneficiado deberia ser nulo",c);
		
	}
	
	@Test
	public void testCamino4() {
		Cliente c = promo.aplicaPromo(false, escVacio.getEmpleados(), escDatos.getEmpleadores());
		assertEquals("El cliente beneficiado no es el correcto",c,escDatos.getEmpleadores().get("Mati"));
	}
	
	@Test
	public void testCamino5() {
		Cliente c=promo.aplicaPromo(true, escVacio.getEmpleados(), escVacio.getEmpleadores());
		assertNull("El cliente beneficiado deberia ser nulo",c);
	}
	
	@Test
	public void testCamino6() {
		Cliente c=promo.aplicaPromo(true,escVacio.getEmpleados(), escDatos.getEmpleadores());
		assertNull("El cliente beneficiado deberia ser nulo",c);
	}
	
	@Test
	public void testCamino7() {
		ArrayList<ClientePuntaje> lista = new ArrayList<ClientePuntaje>();
		lista.add(new ClientePuntaje(1,escDatos.getEmpleados().get("Fran")));
		HashMap<String, Empleador> empleadores= escDatos.getEmpleadores();
		empleadores.get("Mati").setPuntaje(4);
		empleadores.get("Mati").setListaDePostulantes(lista);
	
		Cliente c =promo.aplicaPromo(true, escVacio.getEmpleados(), empleadores);
		assertEquals("El cliente beneficiado no es el correcto",c,escDatos.getEmpleadores().get("Mati"));	
	}
	
	@Test
	public void testCamino8() {
		/*HashMap<String, EmpleadoPretenso> empleados = escDatos.getEmpleados();
		assertNull("La lista de postulantes deberia ser null",empleados.get("Fran").getListaDePostulantes());*/
		Cliente c=promo.aplicaPromo(true, escDatos.getEmpleados(), escVacio.getEmpleadores());
		assertEquals("El cliente beneficiado no es el correcto",c,escDatos.getEmpleados().get("Fran"));
	}
	
	@Test
	public void testCamino9() {
		ArrayList<ClientePuntaje> lista = new ArrayList<ClientePuntaje>();
		lista.add(new ClientePuntaje(10,escDatos.getEmpleadores().get("Mati")));
		HashMap<String, EmpleadoPretenso> empleados = escDatos.getEmpleados();
		empleados.get("Fran").setPuntaje(10);
		empleados.get("Fran").setListaDePostulantes(lista);
		
		Cliente c = promo.aplicaPromo(true, empleados, escVacio.getEmpleadores());
		assertEquals("El cliente beneficiado no es el correcto",c,escDatos.getEmpleados().get("Fran"));
		
	}
	}
