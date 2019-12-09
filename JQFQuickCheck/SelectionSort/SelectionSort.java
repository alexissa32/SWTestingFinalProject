// SelectionSort.java
/*
 * EE422C Quiz 2 submission by
 *  Alex Issa
 *  api236
 *  16380
 *  Fall 2018
 */

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
			for (int j = i + 1; j < x.length - 1; j++) {       //INTENTIONAL BUG: Needs to check to < length, not < length - 1
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
}