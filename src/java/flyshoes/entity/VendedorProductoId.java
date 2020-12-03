package flyshoes.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Lorena Cáceres Manuel
 * 
 * En esta clase, se trata de una clase Embeddable por lo tanto en ella almacenamos los identificadores 
 * de las clases que forman la tabla de referencias cruzadas, tenemos el identificador 
 * vendedorId y el identificador productoId
 */
@Embeddable
public class VendedorProductoId implements Serializable {
    //Identificador del vendedor
    private Long vendedorId;
    //Identificador del producto
    private Long productoId;
    
    /**
     * 
     * @return vendedorId
     */
    public Long getVendedorId() {
        return vendedorId;
    }

    /**
     * 
     * @param vendedorId que se establece
     */
    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

    /**
     * 
     * @return productoId
     */
    public Long getProductoId() {
        return productoId;
    }

    /**
     * 
     * @param productoId que se establece
     */
    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }
    
    
}
