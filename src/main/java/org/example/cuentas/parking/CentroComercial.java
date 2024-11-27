package org.example.cuentas.parking;

import java.util.concurrent.Semaphore;

public class CentroComercial {
    public static final int NUM_COCHES=10;
    public static final int PLAZAS_PARKING=5;

    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(PLAZAS_PARKING);
        for(int i = 1;i<NUM_COCHES;i++){
            Coche coche = new Coche(semaforo,i,false);
            coche.setPriority(i);
            coche.start();
        }
    }
}
