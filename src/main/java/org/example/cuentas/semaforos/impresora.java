package org.example.cuentas.semaforos;

import java.util.concurrent.Semaphore;

public class impresora {

    private final Semaphore semaforo = new Semaphore(2);

    public void imprimir(int numEmpleado) {
        System.out.println("Empleado "+numEmpleado+" Intentando imprimir");
        try {
            semaforo.acquire();
            System.out.println("Empleado "+numEmpleado+" esta imprimiendo");
            Thread.sleep(2000);
            semaforo.release();
        }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        System.out.println("Empleado "+numEmpleado+" ha terminado de imprimir");

    }
    }
