package hw1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static volatile int count = 0;

    public static void main(String[] args) {
        String input  = "OOHHOHHHHOHH";

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        int i = 0;
        while(i < getQuantityOfMolecules(input)){
            if(count == 0) {
                new Thread(new Hydrogen(cyclicBarrier)).start();
                new Thread(new Oxygen(cyclicBarrier)).start();
                new Thread(new Hydrogen(cyclicBarrier)).start();

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                i++;
            }
            if(!cyclicBarrier.isBroken()){
                count = 0;
                System.out.println();
                cyclicBarrier.reset();
            }
        }
    }

    public static int getQuantityOfMolecules(String input){
        int oxygenCounter = 0;
        int hydrogenCounter = 0;

        for(String val : input.split("")){
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
