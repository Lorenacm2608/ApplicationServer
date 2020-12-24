package flyshoes.exception;

/**
 *
 * @author Lorena Cáceres Manuel
 */
public class AutenticacionFallidaException extends Exception  {
    /**
     * Excepcion de contraseña incorrecta
     */
    public AutenticacionFallidaException() {
        super("Contraseña incorrecta");
    }
   
}
