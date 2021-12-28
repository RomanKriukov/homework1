package hw1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static volatile int count = 0;

    public static void main(String[] args) {
        String[] input  = "OOHHOHHHHOHH".split("");

        CyclicBarrier water = new CyclicBarrier(4);

        int i = 0;
        while(i < moleculeCounter(input)){
            if(count == 0) {
                new Thread(new Hydrogen(water)).start();
                new Thread(new Oxygen(water)).start();
                new Thread(new Hydrogen(water)).start();

                try {
                    water.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                i++;
            }
            if(!water.isBroken()){
                count = 0;
                System.out.println();
                water.reset();
            }
        }
    }

    public static int moleculeCounter(String[] input){
        int oxygenCounter = 0;
        int hydrogenCounter = 0;

        for(String val : input){
            if(val.equals("O")){
                oxygenCounter++;
            }else{
                hydrogenCounter++;
            }
        }
        if(oxygenCounter * 2 <= hydrogenCounter){
            return oxygenCounter;
        }else{
            return hydrogenCounter / 2;
        }
    }
}
