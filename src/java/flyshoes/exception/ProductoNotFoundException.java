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
public class ProductoNotFoundException extends Exception {
    /**
     * Excepcion que nos informa que no se ha encontrado un producto
     */
    public ProductoNotFoundException() {
        super("Producto no encontrado");
    }
}
