package psp02_ejer1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase representa un Consumidor que consume caracteres del búfer.
 */
public class Consumidor extends Thread {

    private final Bufer buffer;
    private int consumidos;
    private final int maximo = 15;

    /**
     * Construye un objeto Consumidor asociado a un búfer.
     *
     * @param buffer El búfer desde el cual se consumirán los caracteres.
     */
    public Consumidor(Bufer buffer) {
        this.consumidos = 0;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (consumidos < maximo) {
            try {
                char c = buffer.consumir();
                consumidos++;
                System.out.println("Consumido el CHAR " + c + " del buffer");
                sleep((long) (Math.random() * 3000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
