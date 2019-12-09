package DataRace;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

import org.junit.runner.RunWith;
import com.pholser.junit.quickcheck.*;
import com.pholser.junit.quickcheck.generator.*;
import edu.berkeley.cs.jqf.fuzz.*;

@RunWith(JQF.class)
public class RacerTest
{
    @Fuzz
    public void testRacer(@From(RacerGenerator.class) Racer r)
    {
        assertEquals(10, r.calc);
    }
}