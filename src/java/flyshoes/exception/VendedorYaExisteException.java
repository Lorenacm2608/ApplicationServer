package flyshoes.exception;

/**
 *
 * @author Lorena
 */
public class VendedorYaExisteException extends Exception {

    /**
     * Excepcion que nos informa que el vendedor ya existe
     */
    public VendedorYaExisteException() {
        super("Vendedor ya existe");
    }
}
