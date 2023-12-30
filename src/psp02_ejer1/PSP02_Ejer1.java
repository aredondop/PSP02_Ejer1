package psp02_ejer1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal que crea un búfer, un productor y un consumidor, y los inicia.
 */
public class PSP02_Ejer1 {

    /**
     * Método principal del programa.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        try {
            Bufer b = new Bufer(6);
            Productor p = new Productor(b);
            Consumidor c = new Consumidor(b);

            p.start();
            Thread.sleep(3000);
            c.start();

            p.join();
            c.join();
            System.out.println("==== FIN ====");
        } catch (InterruptedException ex) {
            Logger.getLogger(PSP02_Ejer1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
