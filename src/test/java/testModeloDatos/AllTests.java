package testModeloDatos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCliente.class, TestClientePuntaje.class, TestContratacion.class, TestEmpleadoPretenso.class,
		TestEmpleador.class, TestTicketCasos1.class, TestTicketCasos2.class, TestTicketCasos3.class })
public class AllTests {

}
