package runners;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.booking.MoscowTripTest;
import tests.booking.OsloTripTest;
import tests.booking.ParisTripTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ParisTripTest.class, MoscowTripTest.class, OsloTripTest.class})
public class RunnerJunit {





}
