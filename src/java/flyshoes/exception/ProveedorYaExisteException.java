package flyshoes.exception;

/**
 *
 * @author Lorena
 */
public class ProveedorYaExisteException extends Exception{
    /**
     * Excepcion que nos informa que el proveedor ya existe
     */
    public ProveedorYaExisteException(){
        super("El proveedor ya existe");
    }
}
