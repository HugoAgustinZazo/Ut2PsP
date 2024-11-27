package org.example.cuentas;

public class CuentaBancaria {

    private int gastos = 0;

    public int getGastos() {
        return gastos;
    }

    public synchronized int incrementarGasto(){
        System.out.println("ENTRO A LA SECCION CRITICA");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        gastos++;
        System.out.println("SALGO DE LA SECCION CRITICA");
        return gastos;
    }
}
