import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

import org.junit.runner.RunWith;
import com.pholser.junit.quickcheck.*;
import com.pholser.junit.quickcheck.generator.*;
import edu.berkeley.cs.jqf.fuzz.*;

@RunWith(JQF.class)
public class RacerTests
{
	@Fuzz
    public void testRacer(@From(RacerGenerator.class) Racer r) 
    {    
    	assertEquals(10, r.calc);
    	//int[] copy = l.l.clone();
    	//Arrays.sort(copy);
    	//l.sort(l.l);
        //assertArrayEquals(copy, l.l); //Expected, actuals
    }
}
