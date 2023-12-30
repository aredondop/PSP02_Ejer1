package psp02_ejer1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase implementa un búfer que permite la producción y el consumo de caracteres de forma sincronizada.
 * Utiliza un ArrayBlockingQueue para gestionar automáticamente la sincronización y el tamaño del búfer.
 */
public class Bufer {

    private ArrayBlockingQueue<Character> buffer;

    /**
     * Construye un objeto Bufer con el tamaño especificado.
     *
     * @param tamanio Tamaño del búfer.
     */
    public Bufer(int tamanio) {
        this.buffer = new ArrayBlockingQueue<>(tamanio);
    }

    /**
     * Método que consume un carácter del búfer.
     *
     * @return El carácter consumido.
     */
    public char consumir() {
        try {
            return buffer.take();
        } catch (InterruptedException ex) {
            Logger.getLogger(Bufer.class.getName()).log(Level.SEVERE, null, ex);
            return '\0';  // o manejar la excepción de otra manera
        }
    }

    /**
     * Método que produce un carácter y lo coloca en el búfer.
     *
     * @param c El carácter a producir.
     */
    public void producir(char c) {
        try {
            buffer.put(c);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bufer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
