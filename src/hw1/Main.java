package hw1;

import java.util.concurrent.Semaphore;

public class Main {

    public static volatile int count = 0;

    public static void main(String[] args) {
        Semaphore water = new Semaphore(3);

        for(int i = 0;i < 20;){
            if(count < 3) {
                new Thread(new Hydrogen(water)).start();
                new Thread(new Oxygen(water)).start();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
            else{
                count = 0;
                Oxygen.setCount();
                Hydrogen.setCount();
                System.out.println();
            }
        }
    }
}
