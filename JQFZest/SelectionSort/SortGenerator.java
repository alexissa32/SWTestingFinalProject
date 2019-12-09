package SelectionSort;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class SortGenerator extends Generator<SelectionSort> {

    public SortGenerator() {
         super(SelectionSort.class); // Register the type of objects that we can create
    }

    // This method is invoked to generate a single test case
    // @Override
    public SelectionSort generate(SourceOfRandomness random, GenerationStatus __ignore__) {
        int size = random.nextInt(10); // Create a random size for the list.
        int[] l = new int[size];
        for(int i = 0; i<size; i++) {
            l[i] = random.nextInt(100);
        }
        return new SelectionSort(l);   // Return the randomly generated SLList object
    }
}
