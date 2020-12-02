/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private Long reservaId; //Identificador de la reserva
    private Long clienteId; //Identificador del cliente

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "ReservaClienteId{" + "reservaId=" + reservaId + ", clienteId=" + clienteId + '}';
    }

}
