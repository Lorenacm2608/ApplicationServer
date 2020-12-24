package flyshoes.exceptions;

/**
 *
 * @author Lorena
 */
public class ReservaNotFoundException extends Exception {

    /**
     * Excepción para informar que la reserva no se ha encontrado
     */
    public ReservaNotFoundException() {
        super("No se ha encontrado la reserva");
    }
}
