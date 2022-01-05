package hw1;

import java.util.concurrent.CyclicBarrier;

public class Hydrogen extends Thread{
    private final CyclicBarrier cyclicBarrier;

    public Hydrogen(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    private void releaseHydrogen(){ System.out.print("H"); }

    @Override
    public void run(){
        try{
            Main.count++;
            releaseHydrogen();
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
