package HW1;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

// import HW1.SLList;

public class SLListGenerator extends Generator<SLList> {

    public SLListGenerator() {
        super(SLList.class); // Register the type of objects that we can create
    }

    // This method is invoked to generate a single test case
    // @Override
    public SLList generate(SourceOfRandomness random, GenerationStatus __ignore__) {
        // Initialize a SLList object
        SLList l = new SLList();
        int size = random.nextInt(10); // Create a random size for the list.
        for(int i = 0; i<size; i++) {
            l.add(random.nextBoolean());
        }
        return l;   // Return the randomly generated SLList object
    }
}
