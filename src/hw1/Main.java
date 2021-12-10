package hw1;

import java.util.concurrent.Semaphore;

public class Main {

    public static volatile int count = 0;

    public static void main(String[] args) {
        Semaphore oxygen = new Semaphore(1);
        Semaphore hydrogen = new Semaphore(2);

        for(int i = 0;i < 10;){
            if(count < 3) {
                new Thread(new Hydrogen(hydrogen)).start();
                new Thread(new Oxygen(oxygen)).start();
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
