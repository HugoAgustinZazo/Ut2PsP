package org.example.cuentas.regiones;

public class Cliente extends Thread{

    private CuentaBancaria cuenta;
    private int gastosRealizados;
    private int gastosARealizar;

    public Cliente(int gastosARealizar, CuentaBancaria cuenta) {
        this.gastosARealizar = gastosARealizar;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {

        for (int numGasto = 0; numGasto < gastosARealizar; numGasto++) {

            synchronized (cuenta){
                System.out.println("ENTRO A LA SECCION SINCRONIZADA");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cuenta.incrementarGasto();
                System.out.println("SALGO DE LA SECCION SINCRONIZADA");
            }
            gastosRealizados++;

        }

        System.out.printf("Hilo %s, el total de gastos realizados es %d \n", this.getName(), gastosRealizados);

    }
}
