package org.example.cuentas;

import java.util.ArrayList;
import java.util.List;

public class SimulacionCompras {

    private final static int TOTAL_CLIENTES = 10;
    private final static int TOTAL_GASTOS_REALIZAR = 10000;

    public static void main(String[] args) throws InterruptedException {
        List<Cliente> clientes = new ArrayList<>();
        CuentaBancaria miCuenta = new CuentaBancaria();

        //Crear tantos clientes como me han dicho, y los guardo en una lista
        int numGastosARealizarCliente = TOTAL_GASTOS_REALIZAR / TOTAL_CLIENTES;

        for (int numCliente = 0; numCliente < TOTAL_CLIENTES; numCliente++) {
            Cliente cli = new Cliente(numGastosARealizarCliente, miCuenta);
            cli.setName("Cliente" + numCliente);
            clientes.add(cli);
        }

        //Arrancar todos los hilos de cliente
        for(Cliente cli : clientes){
            cli.start();
        }

        //Esperar a que terminen
        for(Cliente cli : clientes){
            cli.join();
        }

        //Consultar los gastos realizados en la cuenta bancaria
        System.out.printf("Programa terminado. La cuenta bancaria deberia tener %d \n", miCuenta.getGastos());

    }
}
