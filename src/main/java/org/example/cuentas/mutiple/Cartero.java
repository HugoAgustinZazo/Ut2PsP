package org.example.cuentas.mutiple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Cartero implements Runnable {

    public static final int MAX_CARTAS = 10;
    private static final Logger logger = LoggerFactory.getLogger(Cartero.class);
    public static final String FIN = "FIN";
    private Buzon buzon;

    public Cartero(Buzon buzon) {
        this.buzon = buzon;
    }

    @Override
    public void run() {

        List<String> cartas = new ArrayList<>();
        for (int numCarta = 1; numCarta <= MAX_CARTAS; numCarta++) {
            cartas.add(String.valueOf(numCarta));
        }

        cartas.add(FIN);

        for (String carta : cartas) {

            logger.info("Quiero enviar la carta: " + carta);
            buzon.ponerCarta(carta);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        logger.info("[El cartero termina su ejecucion]");

        buzon.terminarEnvio();

    }
}
