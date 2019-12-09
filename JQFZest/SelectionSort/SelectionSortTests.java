package SelectionSort;// SelectionSortTests.java
/*
 * EE422C Quiz 2 submission by
 *  Alex Issa
 *  api236
 *  16380
 *  Fall 2018
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

import org.junit.runner.RunWith;
import com.pholser.junit.quickcheck.*;
import com.pholser.junit.quickcheck.generator.*;
import edu.berkeley.cs.jqf.fuzz.*;

@RunWith(JQF.class)
public class SelectionSortTests 
{
	@Fuzz
    public void testSelectionSort(@From(SortGenerator.class) SelectionSort l) 
    {    
    	int[] copy = l.l.clone();
    	Arrays.sort(copy);
    	l.sort(l.l);
        assertArrayEquals(copy, l.l); //Expected, actuals
    }
}
