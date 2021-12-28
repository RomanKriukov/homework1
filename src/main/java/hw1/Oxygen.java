package hw1;

import java.util.concurrent.CyclicBarrier;

public class Oxygen extends Thread{
    private final CyclicBarrier sem;

    public Oxygen(CyclicBarrier sem) {
        this.sem = sem;
    }

    private void releaseOxygen(){
        System.out.print("O");
    }

    @Override
    public void run(){
        try{
            Main.count++;
            releaseOxygen();
            sem.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
