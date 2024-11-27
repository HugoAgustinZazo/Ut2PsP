package org.example.cuentas.semaforos;
public class Empleado extends Thread {
    int numEmpleado;
    impresora impresora;



public Empleado(impresora imp,int numEmpleado){
    this.numEmpleado = numEmpleado;
    this.impresora = imp;
}
@Override
    public void run(){
    impresora.imprimir(numEmpleado);
}

}
