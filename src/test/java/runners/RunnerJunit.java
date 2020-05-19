package runners;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.MoscowTripTest;
import tests.OsloTripTest;
import tests.ParisTripTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ParisTripTest.class, MoscowTripTest.class, OsloTripTest.class})
public class RunnerJunit {





}
