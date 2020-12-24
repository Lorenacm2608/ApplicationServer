package flyshoes.exception;

/**
 * Excepción que se lanza cuando ocurre algun problema a la hora de leer
 *
 * @author 2dam
 */
public class SelectException extends Exception {

    /**
     * Constructor vacio
     */
    public SelectException() {
    }

    /**
     * Constructor el cual recibe un mensaje detallado
     *
     * @param message
     */
    public SelectException(String message) {
        super(message);
    }
}
