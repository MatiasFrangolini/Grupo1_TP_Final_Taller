package testGui;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestGuiConUsuarios.class, TestGuiConUsuariosAdmin.class, TestGuiConUsuariosCliente.class,
		TestGuiConUsuariosRegistro.class, TestGuiEnabledDisabled.class, TestGuiEnabledDisabledAdmin.class,
		TestGuiEnabledDisabledCliente.class, TestGuiEnabledDisabledRegistro.class })
public class AllTests {

}
