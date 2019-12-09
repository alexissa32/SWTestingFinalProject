// SelectionSortTests.java
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

	/**
	@Before
	public void setUp() throws Exception {	
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	//Tests a normal, unsorted array, avg. case scenario
	@Test
	public void test1() 
	{
		int x[] = {1, 5, 7, 6, 3};
		SelectionSort.sort(x);
		int y[] = {1,3,5,6,7};
		
		Assert.assertArrayEquals(x, y);
	}
	
	//Tests an already sorted array, best case scenario
	@Test
	public void test2() 
	{
		int x[] = {1, 3, 5, 6, 7};
		SelectionSort.sort(x);
		int y[] = {1,3,5,6,7};
		
		Assert.assertArrayEquals(x, y);
	}
	
	//Tests reversed array, worst case scenario
	@Test
	public void test3() 
	{
		int x[] = {7, 6, 5, 3, 1};
		SelectionSort.sort(x);
		int y[] = {1,3,5,6,7};
		
		Assert.assertArrayEquals(x, y);
	}
	
	//Test with negative numbers
	@Test
	public void test4() 
	{
		int x[] = {1, 5, 7, 6, 8, 1000, 25, 368, 11, -4, 3};
		SelectionSort.sort(x);
		int y[] = {-4,1,3,5,6,7,8,11,25,368,1000};
		
		Assert.assertArrayEquals(x, y);
	}
	
	//Test with 0 as a number
	@Test
	public void test5() 
	{
		int x[] = {1, 5, 0, 7, 6, 3};
		SelectionSort.sort(x);
		int y[] = {0,1,3,5,6,7};
		
		Assert.assertArrayEquals(x, y);
	}
	
	//Test with repeating numbers
	@Test
	public void test6() 
	{
		int x[] = {1, 1, 5, 7, 6, 8, 8, 3, -4, 0};
		SelectionSort.sort(x);
		int y[] = {-4,0,1,1,3,5,6,7,8,8};
		
		Assert.assertArrayEquals(x, y);
	}
	*/
}
