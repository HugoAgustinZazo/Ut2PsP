package org.example.cuentas.regiones;

public class CuentaBancaria {

    private int gastos = 0;

    public int getGastos() {
        return gastos;
    }

    public int incrementarGasto(){
        gastos++;
        return gastos;
    }
}
