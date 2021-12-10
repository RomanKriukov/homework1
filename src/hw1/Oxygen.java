package hw1;

import java.util.concurrent.Semaphore;

public class Oxygen extends Thread{
    private String oxygen = "O";
    public static volatile int count = 0;
    private final Semaphore sem;

    public Oxygen(Semaphore sem) {
        this.sem = sem;
    }

    private void releaseOxygen(){
        count++;
        Main.count += count;
        System.out.print(this.oxygen);
    }

    public static void setCount(){
        count = 0;
    }

    @Override
    public void run(){
        try{
            while (count < 1){
                sem.acquire();
                releaseOxygen();
                sem.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
