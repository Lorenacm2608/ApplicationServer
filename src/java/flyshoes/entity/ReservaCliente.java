package flyshoes.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lorena Cáceres Manuel
 * 
 * La clase ReservaCliente es la tabla de referencias cruzadas entre Reserva y Cliente,
 * en ella vemos que tiene el identificador de cliente y de reserva y un atributo de tipo
 * Timestamp que nos indicará la fecha de llegada de la reserva
 */
@Entity
@Table(name ="reservaCliente", schema ="flyshoesdb")
public class ReservaCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    //Indicamos que va a recibir un identificador de una clase Embeddable
    @EmbeddedId
    private ReservaClienteId idReservaCliente; //Identificador de tipo ReservaCliente, incluye clienteId y reservaId
    //Mapea el clienteId que se esta pasando con id_cliente
    @MapsId("clienteId")
    @ManyToOne
    private Long id_cliente;
    //Mapea el reservaId que se esta pasando con id_reserva
    @MapsId("reservaId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Long id_reserva;
    //Anotacion que define una fecha, le indicamos que es de tipo Timestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fecha_llegada;

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Timestamp getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(Timestamp fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public ReservaClienteId getIdReservaCliente() {
        return idReservaCliente;
    }

    public void setIdReservaCliente(ReservaClienteId idReservaCliente) {
        this.idReservaCliente = idReservaCliente;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservaCliente != null ? idReservaCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaCliente)) {
            return false;
        }
        ReservaCliente other = (ReservaCliente) object;
        if ((this.idReservaCliente == null && other.idReservaCliente != null) || (this.idReservaCliente != null && !this.idReservaCliente.equals(other.idReservaCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "flyshoes.entity.ReservaCliente[ id=" + idReservaCliente + " ]";
    }

}
