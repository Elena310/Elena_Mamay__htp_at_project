package runners.junit;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import tests.booking.SelectionTripTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({SelectionTripTest.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RunnerJunit {





}
