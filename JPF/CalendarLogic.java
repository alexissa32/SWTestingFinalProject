import java.util.GregorianCalendar;
import static java.util.GregorianCalendar.*;
import java.util.TimeZone;
import gov.nasa.jpf.vm.Verify;




/* Application logic */
public class CalendarLogic {
    // Returns true iff cal is in a leap year
    public static boolean isLeapYear(GregorianCalendar cal) {
        int year = cal.get(YEAR);
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    // Returns either of -1, 0, 1 depending on whether c1 is <, =, > than c2
    public static int compare(GregorianCalendar c1, GregorianCalendar c2) {
        int cmp;
        cmp = Integer.compare(c1.get(YEAR), c2.get(YEAR));
        if (cmp == 0) {
            cmp = Integer.compare(c1.get(MONTH), c2.get(MONTH));
            if (cmp == 0) {
                cmp = Integer.compare(c1.get(DAY_OF_MONTH), c2.get(DAY_OF_MONTH));
            }
        }
        return cmp;
    }

    public static void main (String[] args) throws ArithmeticException{
        GregorianCalendar cal = new GregorianCalendar();
        cal.setLenient(true); // This allows invalid dates to silently wrap (e.g. Apr 31 ==> May 1).

        cal.set(YEAR, Verify.getInt(1999,4000));
        cal.set(MONTH, Verify.getInt(1,12));
        cal.set(DAY_OF_MONTH, Verify.getInt(1,31)); 

    
        //cal.set(HOUR, Verify.getInt(0,24));
        //cal.set(MINUTE, Verify.getInt(0,60));
        //cal.set(SECOND, Verify.getInt(0,60));

        cal.set(HOUR, 1);
        cal.set(MINUTE, 1);
        cal.set(SECOND, 1);
        

        // Let's set a timezone
        // First, get supported timezone IDs (e.g. "America/Los_Angeles")
        String[] allTzIds = TimeZone.getAvailableIDs();

        // Next, choose one randomly from the array
        //int rand = Verify.getInt(0, allTzIds.length-1);
        String tzId = allTzIds[0];
        TimeZone tz = TimeZone.getTimeZone(tzId);

        // Assign it to the calendar
        cal.setTimeZone(tz);


        if(cal.get(MONTH) == FEBRUARY){
            if(cal.get(DAY_OF_MONTH) == 29){
                if(CalendarLogic.isLeapYear(cal) == false){
                    throw new ArithmeticException(
                    String.format("'%s' should be a leap year.",
                            cal.get(YEAR)));
                }
            }
        }

        Verify.ignoreIf(cal.get(MONTH) != FEBRUARY); //if this cond is true, jpf will backtrack (assume in jpf)
    }
}

