package org.example.cuentas.mutiple;

public class ProgramaBuzonCartero {

    public static final int TOTAL_DUENIOS = 15;

    public static void main(String[] args) {

        Buzon buzon = new Buzon();
        Cartero carteroCorreos = new Cartero(buzon);

        Thread hiloCartero = new Thread(carteroCorreos);
        hiloCartero.setName("CARTERO");

        //Creo X hilos de dueños
        for (int numDuenio = 1; numDuenio <= TOTAL_DUENIOS; numDuenio++) {
            Thread hiloDuenio = new Thread(new Duenio(buzon));
            hiloDuenio.setName("DUEÑO_" + numDuenio);
            hiloDuenio.start();
        }

        hiloCartero.start();
    }
}
