package psp02_ejer1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase representa un Productor que produce caracteres y los coloca en el búfer.
 */
public class Productor extends Thread {

    private final Bufer buffer;
    private final String letras = "abcdefghijklmnopqrstuvxyz";
    private int producidos;
    private final int maximo = 15;

    /**
     * Construye un objeto Productor asociado a un búfer.
     *
     * @param buffer El búfer en el cual se colocarán los caracteres producidos.
     */
    public Productor(Bufer buffer) {
        this.producidos = 0;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (producidos < maximo) {
            try {
                char c = letras.charAt((int) (Math.random() * letras.length()));
                buffer.producir(c);
                producidos++;
                System.out.println("Producido el CHAR " + c + " en el bufer");
                sleep((long) (Math.random() * 3000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
