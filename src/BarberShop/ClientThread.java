package BarberShop;

import java.util.Random;

public class ClientThread extends Thread {
    int threadID = 0;
    boolean inOperation = false;
    Random rand = new Random();

    public ClientThread(int id) {
        threadID = id;
    }

    private void prepareForHaircut(Random rand) {
        waitInitialPeriod(rand);
        notifyOfReadiness();
    }

    private void notifyOfReadiness() {
        while (!inOperation) {
            BarberShop.waitingThreads[threadID] = 1;
        }
        System.out.println("Client thread " + threadID + " is entering haircut");
        BarberShop.waitingThreads[threadID] = 0;
        takeHaircut();
        System.out.println("Client thread " + threadID + " is leaving haircut");

    }

    private void takeHaircut() {
        for(int i = 0; i < 10; i++)
        while (inOperation) {
            System.out.println("Client thread " + threadID + " is in haircut");
        }
    }

    private void waitInitialPeriod(Random rand) {
        System.out.println("Client thread " + threadID + " is waiting some time");
        int initialWait = rand.nextInt(1000);
        for(int i = initialWait; i > 0; i--) {
            //wait a random amount of time
        }
    }

    public void setInOperation(boolean val) {
        inOperation = val;
    }

    public boolean getInOperation() {
        return inOperation;
    }

    public void run() {
        while(true) {
            prepareForHaircut(rand);
        }
    }

}
