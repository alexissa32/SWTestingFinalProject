// SelectionSort.java
/*
 * EE422C Quiz 2 submission by
 *  Alex Issa
 *  api236
 *  16380
 *  Fall 2018
 */
import gov.nasa.jpf.vm.Verify;
import java.util.*;

public class SelectionSort {

	public int[] l;

	public SelectionSort(int[] l)
	{
		this.l = l;
	}
	
	/**
	 * Implementation of selection sort algorithm.
	 * 
	 * @param x The integer array to sort in place
	 */
	public void sort(int[] x) {		
		for (int i = 0; i < x.length - 1; i++) {
			
			// Assume i is index of smallest value in array
			int min = i;
			
			// Check all other values in array to find smallest value
			for (int j = i + 1; j < x.length - 1; j++) {       //INTENTIONAL BUG: Needs to check to < length, not < length - 1 (<= length - 1 works)
				if (x[j] < x[min]) {
					min = j;
				}
			}
			
			// Swap smallest value to its correct location
			swap(x, i, min);
		}
	}
	
	/**
	 * Swap two values in place
	 * 
	 * @param x The array of values
	 * @param a Index of first value in x
	 * @param b Index of second value in x
	 */
	private void swap(int[] x, int a, int b) { //Fixed the 2 bugs, cancelling itself out and XOR doesn't work if i and min are the same
		int change = x[a];
		x[a] = x[b];
		x[b] = change;
	}

	public static void main (String[] args){
		int size = Verify.getInt(0,10); // Create 11 lists, of sizes from 0 - 10
        int[] l = new int[size];
        for(int i = 0; i<size; i++) {
            l[i] = Verify.getInt(0,10);	// each element in the list can have a value from 0 - 10
        }

        SelectionSort list = new SelectionSort(l);
        int[] copy = list.l.clone();
        list.sort(list.l);
    	Arrays.sort(copy);
    	if(!Arrays.equals(copy, list.l)){
    		throw new java.lang.RuntimeException("List was not sorted properly");
    	}
        
	}
}