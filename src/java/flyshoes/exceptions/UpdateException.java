package flyshoes.exceptions;

/**
 * Excepción que se lanza cuando ocurre algun problema a la hora de actualizar
 *
 * @author 2dam
 */
public class UpdateException extends Exception {

    /**
     * Constructor vacío
     */
    public UpdateException() {
    }

    /**
     * Constructor el cual recibe un mensaje detallado
     *
     * @param message
     */
    public UpdateException(String message) {
        super(message);
    }
}
