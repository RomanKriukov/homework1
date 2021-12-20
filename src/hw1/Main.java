package hw1;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static volatile int count = 0;

    public static void main(String[] args) {
        CyclicBarrier water = new CyclicBarrier(3);

        for(int i = 0;i < 20;){
            if(count == 0) {
                new Thread(new Hydrogen(water)).start();
                new Thread(new Hydrogen(water)).start();
                new Thread(new Oxygen(water)).start();
                i++;
            }
            if(count == 3){
                count = 0;
                System.out.println();
                water.reset();
            }
        }
    }
}
