package org.example.cuentas;

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
            cuenta.incrementarGasto();
            gastosRealizados++;

        }

        System.out.printf("Hilo %s, el total de gastos realizados es %d \n", this.getName(), gastosRealizados);

    }
}
