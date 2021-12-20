package hw1;

import java.util.concurrent.CyclicBarrier;

public class Oxygen extends Thread{
    public static volatile int count = 0;
    private final CyclicBarrier sem;

    public Oxygen(CyclicBarrier sem) {
        this.sem = sem;
    }

    private void releaseOxygen(){
        count++;
        Main.count += count;
        System.out.print("O");
    }

    public static void setCount(){
        count = 0;
    }

    @Override
    public void run(){
        try{
            if (count < 1){
                sem.await();
                releaseOxygen();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
