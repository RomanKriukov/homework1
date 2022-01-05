package hw1;

import java.util.concurrent.CyclicBarrier;

public class Oxygen extends Thread{
    private final CyclicBarrier cyclicBarrier;

    public Oxygen(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    private void releaseOxygen(){
        System.out.print("O");
    }

    @Override
    public void run(){
        try{
            Main.count++;
            releaseOxygen();
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
