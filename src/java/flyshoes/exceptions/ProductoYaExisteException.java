/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.exceptions;

/**
 *
 * @author Lorena
 */
public class ProductoYaExisteException extends Exception {

    /**
     * Excepcion que nos informa que el producto no se ha
     * podido registrar porque ya existe
     */
    public ProductoYaExisteException() {
        super("El producto registrado ya existe");
    }
}
