package DataRace;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class RacerGenerator extends Generator<Racer> {

    public RacerGenerator() {
        super(Racer.class); // Register the type of objects that we can create
    }

    // This method is invoked to generate a single test case
    // @Override
    public Racer generate(SourceOfRandomness random, GenerationStatus __ignore__)
    {
        Racer racer = new Racer();
        Thread t = new Thread(racer);
        t.start();

        Racer.doSomething(1000);                   // (3)
        racer.calc = 420 / racer.d;               // (4)

        return racer;

        //int size = random.nextInt(10); // Create a random size for the list.
        //int[] l = new int[size];
        //for(int i = 0; i<size; i++) {
        //    l[i] = random.nextInt(100);
        //}
        //return new SelectionSort(l);   // Return the randomly generated SLList object
    }
}