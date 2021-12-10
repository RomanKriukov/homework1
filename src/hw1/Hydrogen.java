package hw1;

import java.util.concurrent.Semaphore;

public class Hydrogen extends Thread{
    private String hydrogen = "H";
    public static volatile int count = 0;
    private final Semaphore sem;

    public Hydrogen(Semaphore sem) {
        this.sem = sem;
    }

    private void releaseHydrogen(){
        count++;
        Main.count += count;
        System.out.print(this.hydrogen);
    }

     public static void setCount(){
        count = 0;
    }

    @Override
    public void run(){
        try{
            while (count < 2){
                sem.acquire();
                releaseHydrogen();
                sem.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
