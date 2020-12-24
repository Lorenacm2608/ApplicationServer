package flyshoes.exception;

/**
 *
 * @author Lorena
 */
public class ReservaYaExisteException extends Exception {

    /**
     * Excepción que nos informa que la reserva registrada ya existe
     */
    public ReservaYaExisteException() {
        super("Esta reserva ya existe");
    }
}
