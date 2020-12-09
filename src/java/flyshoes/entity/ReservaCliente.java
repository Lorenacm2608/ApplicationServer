package flyshoes.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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
@XmlRootElement
public class ReservaCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Indicamos que va a recibir un identificador de una clase Embeddable
     * El identificador de tipo ReservaCliente, incluye clienteId y reservaId
     */ 
    @EmbeddedId
    private ReservaClienteId idReservaCliente; 
    /**
     * @MapaId. Mapea el clienteId que se esta pasando con id_cliente (identificador del cliente)
     */
    @MapsId("clienteId")
    @ManyToOne
    private Long id_cliente;
    /**
     * @MapaId. Mapea el reservaId que se esta pasando con id_reserva (identificador de la reserva)
     */
    @MapsId("reservaId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Long id_reserva;
    /**
     * Fecha de llegada del producto de la reserva 
     */
    private Timestamp fecha_llegada;

    /**
     * 
     * @return id_cliente
     */
    public Long getId_cliente() {
        return id_cliente;
    }

    /**
     * 
     * @param id_cliente que se establece
     */
    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * 
     * @return id_reserva
     */
    public Long getId_reserva() {
        return id_reserva;
    }

    /**
     * 
     * @param id_reserva que se establece
     */
    public void setId_reserva(Long id_reserva) {
        this.id_reserva = id_reserva;
    }

    /**
     * 
     * @return fecha_llegada
     */
    public Timestamp getFecha_llegada() {
        return fecha_llegada;
    }

    /**
     * 
     * @param fecha_llegada que se establece
     */
    public void setFecha_llegada(Timestamp fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    /**
     * 
     * @return idReservaCliente
     */
    public ReservaClienteId getIdReservaCliente() {
        return idReservaCliente;
    }

    /**
     * 
     * @param idReservaCliente que se establece
     */
    public void setIdReservaCliente(ReservaClienteId idReservaCliente) {
        this.idReservaCliente = idReservaCliente;
    }

 

    /**
     * Representacion en forma de entero para una ReservaCliente
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservaCliente != null ? idReservaCliente.hashCode() : 0);
        return hash;
    }

    /**
     * Compara dos ReservaCliente. Este método considera que una ReservaCliente es igual que otra
     * si los identificadores tienen el mismo valor
     * @param object La otra ReservaCliente que compararemos
     * @return true si son iguales
     */
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

    /**
     * Obtenemos una representacion en forma de String de la ReservaCliente
     * @return 
     */
    @Override
    public String toString() {
        return "flyshoes.entity.ReservaCliente[ id=" + idReservaCliente + " ]";
    }

}