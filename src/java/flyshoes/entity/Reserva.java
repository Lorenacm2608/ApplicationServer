package flyshoes.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Esta clase se encargará sobre la gestión de reservas
 *
 * @author Fredy Vargas Flores
 */
@Entity
@Table(name = "reserva", schema = "flyshoesdb")
@NamedQueries({
    @NamedQuery(name = "findReservasCanceladas",
            query = "SELECT r FROM Reserva r WHERE r.estado ='CANCELADA'"
    )
    ,
    @NamedQuery(name = "findReservasConfirmadas",
            query = "SELECT r FROM Reserva r WHERE r.estado ='CONFIRMADA'"
    )
    ,
    @NamedQuery(name = "findReservasRealizadas",
            query = "SELECT r FROM Reserva r WHERE r.estado ='REALIZADA'"
    )

})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador de la reserva
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //producto contiene la reserva
    @ManyToOne
    public Producto producto;
    //descripcion de la reserva
    private String descripcion;
    //estado de la reserva
    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    //cliente  de la reserva
    @ManyToOne
    private Cliente cliente;
    //cantidad del producto
    @NotNull
    private Integer cantidad;
    //Fecha de reserva
    @NotNull
    private Timestamp fechaReserva;
    //Fecha de entrega prevista
    @NotNull
    private Timestamp fechaEntrega;

    /**
     * Devuelve la id de la reserva
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece la id de la reserva
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve la descripcion de la reserva
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Inserta la descripcion de la reserva
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el estado de la reserva
     *
     * @return estado
     */
    public EstadoReserva getEstado() {
        return estado;
    }

    /**
     * Inserta el estado de la reserva
     *
     * @param estado
     */
    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el cliente que ha realizado dicha reserva
     *
     * @return cliente
     */
    // @XmlTransient
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Añade al cliente de la reserva
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * devuelve del producto
     *
     * @return producto
     */
    // @XmlTransient
    public Producto getProducto() {
        return producto;
    }

    /**
     * inserta el producto a la reserva
     *
     * @param producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * devuelve la cantidad del producto
     *
     * @return cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * inserta la cantidad del producto
     *
     * @param cantidad
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * devuelve la fecha de la reserva
     *
     * @return fechaReserva
     */
    public Timestamp getFechaReserva() {
        return fechaReserva;
    }

    /**
     * inserta la fecha de reserva
     *
     * @param fechaReserva
     */
    public void setFechaReserva(Timestamp fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * devuelve la fecha de la entrega prevista
     *
     * @return fechaEntrega
     */
    public Timestamp getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * inserta la fecha de la entrega prevista
     *
     * @param fechaEntrega
     */
    public void setFechaEntrega(Timestamp fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

}
