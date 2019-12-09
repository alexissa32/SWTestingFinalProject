import java.util.*;
import static java.util.GregorianCalendar.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.runner.RunWith;
import com.pholser.junit.quickcheck.*;
import com.pholser.junit.quickcheck.generator.*;
import edu.berkeley.cs.jqf.fuzz.*;

@RunWith(JQF.class)
public class CalendarTest {

    @Fuzz
    public void testLeapYear(@From(CalendarGenerator.class) GregorianCalendar cal) {
        // Assume that the date is Feb 29
        assumeTrue(cal.get(MONTH) == FEBRUARY);
        assumeTrue(cal.get(DAY_OF_MONTH) == 29);

        // Under this assumption, validate leap year rules
        assertTrue(cal.get(YEAR) + " should be a leap year", CalendarLogic.isLeapYear(cal));
    }
    
}
