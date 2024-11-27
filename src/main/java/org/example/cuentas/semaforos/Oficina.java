package org.example.cuentas.semaforos;

public class Oficina {
    public static void main(String[] args) {
        impresora imp = new impresora();
        for(int i=1;i<=6;i++){
            Empleado emp = new Empleado(imp,i);
            emp.start();
        }
    }
}
