package hw1;

import java.util.concurrent.CyclicBarrier;

public class Hydrogen extends Thread{
    public static volatile int count = 0;
    private final CyclicBarrier sem;

    public Hydrogen(CyclicBarrier sem) {
        this.sem = sem;
    }

    private void releaseHydrogen(){
        count++;
        Main.count += count;
        System.out.print("H");
    }

     public static void setCount(){
        count = 0;
    }

    @Override
    public void run(){
        try{
            if (count < 1){
                sem.await();
                releaseHydrogen();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
