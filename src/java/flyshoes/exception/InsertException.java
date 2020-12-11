package flyshoes.exception;

/**
 * Excepción que se lanza cuando ocurre algun problema a la hora de crear
 *
 * @author 2dam
 */
public class InsertException extends Exception {

    /**
     * Constructor vacio
     */
    public InsertException() {
    }

    /**
     * Constructor el cual recibe un mensaje detallado
     *
     * @param message
     */
    public InsertException(String message) {
        super(message);
    }
}
