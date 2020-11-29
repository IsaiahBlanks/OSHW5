package BarberShop;

import java.util.ArrayList;
import java.util.Random;

public class BarberThread extends Thread {
    ArrayList<Integer> availableIDs;
    ArrayList<ClientThread> clientThreads;
    boolean ready;
    Random rand;
    int barberID;

    public BarberThread(ArrayList<ClientThread> thread, int ID) {
        ready = true;
        rand = new Random();
        clientThreads = thread;
        barberID = ID;
    }

    private void waitForCustomers() {

        while (true) {
            //System.out.println("Barber " + barberID + " is waiting for customers");
            if (checkWhoIsAvailable() > 0) {
                pickACustomer();
            }

        }
    }

    private void pickACustomer() {
        //System.out.println("Barber " + barberID + " is picking a customer");
        int chosenID = availableIDs.get(rand.nextInt(availableIDs.size()));
        if (!clientThreads.get(chosenID).getInOperation()) {
            clientThreads.get(chosenID).setInOperation(true);
            doHaircut(chosenID);
        }
    }

    private void doHaircut(int chosenID) {
        ready = false;
        BarberShop.waitingThreads[chosenID] = 0;
        int lengthOfHaircut = rand.nextInt(5000) + 1000;
        for (int i = lengthOfHaircut; i > 0; i--) {
            //process Haircut
        }
        clientThreads.get(chosenID).setInOperation(false);
        ready = true;
    }

    private int checkWhoIsAvailable() {
        availableIDs = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            if(BarberShop.waitingThreads[i] == 1) {
                availableIDs.add(i);
            }
        }
        return availableIDs.size();
    }

    public void run() {
        waitForCustomers();
    }
}
