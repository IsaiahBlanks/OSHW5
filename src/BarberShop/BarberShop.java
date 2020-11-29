package BarberShop;

import java.util.ArrayList;

public class BarberShop {
    BarberThread barber1;
    BarberThread barber2;

    ArrayList<ClientThread> clientThreads = new ArrayList<>();
    public static int[] waitingThreads = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public BarberShop() {
        initializeThreads();
        startThreads();
    }

    private void startThreads() {
        barber1.start();
        barber2.start();
        for (ClientThread thread : clientThreads) {
            thread.start();
        }
    }

    public ArrayList<ClientThread> getClientThreads() {
        return clientThreads;
    }


    private void initializeThreads() {
        for(int i = 0; i < 10; i++) {
            clientThreads.add(new ClientThread(i));
        }
        barber1 = new BarberThread(clientThreads, 0);
        barber2 = new BarberThread(clientThreads, 1);
    }
}
