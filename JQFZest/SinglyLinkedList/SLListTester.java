package HW1;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

// import HW1.SLList.Node;

import org.junit.runner.RunWith;
import com.pholser.junit.quickcheck.*;
import com.pholser.junit.quickcheck.generator.*;
import edu.berkeley.cs.jqf.fuzz.*;

@RunWith(JQF.class)
public class SLListTester {

	@Fuzz
    public void testSLList(@From(SLListGenerator.class) SLList l) {
        assertTrue(l.repOk());
    }
}