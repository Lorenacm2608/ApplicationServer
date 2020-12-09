package flyshoes.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Lorena Cáceres Manuel
 * 
 * En esta clase, se trata de una clase Embeddable por lo tanto en ella almacenamos los identificadores 
 * de las clases que forman la tabla de referencias cruzadas, tenemos el identificador 
 * reservaId y el identificador clienteId
 */
@Embeddable
public class ReservaClienteId implements Serializable {

    //Identificador de la reserva
    private Long reservaId; 
    //Identificador del cliente
    private Long clienteId; 
    
    /**
     * 
     * @return reservaId
     */
    public Long getReservaId() {
        return reservaId;
    }

    /**
     * 
     * @param reservaId que se establece
     */
    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    /**
     * 
     * @return clienteId
     */
    public Long getClienteId() {
        return clienteId;
    }

    /**
     * 
     * @param clienteId que se establece
     */
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
