package flyshoes.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name="findReservasCanceladas", query = "SELECT r FROM Reserva r WHERE r.estado='CANCELADA'"),
    @NamedQuery(name = "findReservasConfirmadas", query="SELECT r FROM Reserva r WHERE r.estado='CONFIRMADA'"),
    @NamedQuery(name ="findReservasRealizadas", query="SELECT r FROM Reserva r WHERE r.estado='REALIZADA'"),
  })
@IdClass(ReservaId.class)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    //id de la reserva
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
    //cliente dueño de la reserva
    @ManyToOne
    private Cliente cliente;
    //cantidad del producto
    private Integer cantidad;

    public Long getId() {
        return id;
    }

    /**
     * Inserta el id de la reserva
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
     * Devuelve el id de la reserva
     *
     * @return id
     */
}
