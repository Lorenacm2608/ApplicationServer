package flyshoes.exception;

/**
 * Excepción que se lanza cuando ocurre algun problema a la hora de borrar
 *
 * @author 2dam
 */
public class DeleteException extends Exception {

    /**
     * Constructor vacio
     */
    public DeleteException() {
    }

    /**
     * Constructor el cual recibe un mensaje detallado
     *
     * @param message
     */
    public DeleteException(String message) {
        super(message);
    }

}
