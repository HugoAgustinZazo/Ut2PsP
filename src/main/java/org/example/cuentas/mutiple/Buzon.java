package org.example.cuentas.mutiple;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Buzon {

    private static final Logger logger = LoggerFactory.getLogger(Buzon.class);

    private String contenidoBuzon;

    private boolean buzonVacio = true;

    private boolean envioTerminado = false;

    public synchronized void ponerCarta(String cartaNueva) {

        logger.info("Intentando poner carta...");

        while(!buzonVacio){
            try {
                logger.info("Joder, el dueño es muy lento, a ver si recoge el correo...");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Por fin, han recogido la carta. Pongo una nueva");

        this.contenidoBuzon = cartaNueva;
        this.buzonVacio = false;
        notify();
    }

    public synchronized String recogerCorreo() {

        logger.info("Intentando recoger correo...");
        while (buzonVacio && !envioTerminado) {
            try {
                logger.info("Mierda, el buzón está vacío. Deberé esperar..");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Bien, ya hay correo!");

        this.buzonVacio = true; //cojo el correo y bajo la bandera
        notify();
        if(contenidoBuzon != null){
            String mensajeBuzon =new String(contenidoBuzon);
            contenidoBuzon = null;
            return mensajeBuzon;
        }else{
            return  contenidoBuzon;
        }
    }

    public synchronized void terminarEnvio(){
        this.envioTerminado = true;
        logger.info("-ENVIO TERMINADO-");
        notifyAll();
    }

    public synchronized boolean esTerminado(){
        return this.envioTerminado;
    }
}
