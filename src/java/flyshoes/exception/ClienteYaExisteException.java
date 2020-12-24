/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.exception;

/**
 *
 * @author Lorena
 */
public class ClienteYaExisteException extends Exception {

    /**
     * Excepcion que nos informa que el cliente ya existe
     */
    public ClienteYaExisteException() {
        super("Cliente ya existe");
    }
}
