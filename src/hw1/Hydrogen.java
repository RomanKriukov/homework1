package hw1;

import java.util.concurrent.CyclicBarrier;

public class Hydrogen extends Thread{
    private final CyclicBarrier sem;

    public Hydrogen(CyclicBarrier sem) {
        this.sem = sem;
    }

    private void releaseHydrogen(){
        System.out.print("H");
    }

    @Override
    public void run(){
        try{
            Main.count++;
            releaseHydrogen();
            sem.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
