package DataRace;

import java.lang.*;

public class Racer implements Runnable
{
    int d = 42;
    int calc;

    public void run () {
        doSomething(1000);                   // (1)
        d = 0;                               // (2)
    }

    //public static void main (String[] args){
    //     Racer racer = new Racer();
    //     Thread t = new Thread(racer);
    //     t.start();
    //
    //     doSomething(1000);                   // (3)
    //     int c = 420 / racer.d;               // (4)
    //     System.out.println(c);
    //}

    static void doSomething (int n) {
        // not very interesting..
        try { Thread.sleep(n); } catch (InterruptedException ix) {}
    }
}