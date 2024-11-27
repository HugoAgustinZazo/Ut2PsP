package org.example.cuentas.mutiple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Duenio implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(Duenio.class);

    private Buzon buzon;
    private List<String> mensajesRecibidos = new ArrayList<>();

    public Duenio(Buzon buzon) {
        this.buzon = buzon;
    }


    @Override
    public void run() {

        String cartaRecibida = "";

        do {
            cartaRecibida = buzon.recogerCorreo();
            logger.info("Recibí una carta! : " + cartaRecibida);
            mensajesRecibidos.add(cartaRecibida);

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } while (cartaRecibida != null && !cartaRecibida.equalsIgnoreCase(Cartero.FIN) && !buzon.esTerminado());

        //logger.info("[El dueño termina su ejecucion]");

        imprimirMensajesRecibidos();
    }

    private void imprimirMensajesRecibidos() {
        logger.info("Mensajes recibidos: " + this.mensajesRecibidos);
    }
}
