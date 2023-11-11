package testPersistencia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestPersistenciaConArchivo.class, TestPersistenciaConArchivoLleno.class,
		TestPersistenciaSinArchivo.class })
public class AllTests {

}
