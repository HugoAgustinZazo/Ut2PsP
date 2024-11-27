package org.example.cuentas.parking;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Coche extends Thread{
    private Semaphore semaforo;
    private int numCoche;
    boolean expulsado = false;

    public Coche(Semaphore semaforo, int numCoche, boolean expulsado) {
        this.semaforo = semaforo;
        this.numCoche = numCoche;
        this.expulsado = expulsado;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Coche "+numCoche+":Estoy dando vueltas");
                Random rd = new Random();
                int dormir = rd.nextInt(1,6);
                Thread.sleep(dormir*1000);
                System.out.println("Coche "+numCoche+":Intento entrar al parking");
                System.out.println("Hay "+(semaforo.getQueueLength())+" coches en cola");
                System.out.println("Hay "+(semaforo.availablePermits())+" tickets");
                if((semaforo.getQueueLength())<=5) {
                    semaforo.acquire();
                    System.out.println("Coche " + numCoche + ":He entrado al parking");
                    int dormir2 = rd.nextInt(1, 6);
                    Thread.sleep(dormir2 * 1000);
                    semaforo.release();
                    System.out.println("Coche " + numCoche + ":Sale del parking");
                }else {
                    System.out.println("El coche "+numCoche+" da otra vuelta hay mucha cola");
                }




            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    public Semaphore getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    public int getNumCoche() {
        return numCoche;
    }

    public void setNumCoche(int numCoche) {
        this.numCoche = numCoche;
    }

    public boolean isExpulsado() {
        return expulsado;
    }

    public void setExpulsado(boolean expulsado) {
        this.expulsado = expulsado;
    }
}
