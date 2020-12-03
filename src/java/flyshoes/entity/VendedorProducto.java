package flyshoes.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Lorena Cáceres Manuel
 *
 * La clase VendedorProducto es la tabla de referencias cruzadas entre Producto
 * y Vendedor, en ella vemos que tiene el identificador de vendedor y de
 * producto y un atributo de tipo Timestamp que nos indicará la fecha de alta
 * del producto
 */
@Entity
@Table(name = "vendedorProducto", schema = "flyshoesdb")
public class VendedorProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Indicamos que va a recibir un identificador de una clase Embeddable El
     * identificador de tipo VendedorProducto, incluye vendedorId y productoId
     */
    @EmbeddedId
    private VendedorProductoId idVendedorProducto;
    /**
     * @MapId. Mapea el clienteId que se esta pasando con id_vendedor (identificador del
     * vendedor)
     */
    @MapsId("vendedorId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Long id_vendedor;
    /**
     * Mapea el productoId que se esta pasando con id_producto (identificador
     * del producto)
     */
    @MapsId("productoId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Long id_producto;
    /**
     * Fecha de alta del producto
     */
    private Timestamp fechaAlta;

    /**
     *
     * @return idVendedorProducto
     */
    public VendedorProductoId getId() {
        return idVendedorProducto;
    }

    /**
     *
     * @param idVendedorProducto que se establece
     */
    public void setId(VendedorProductoId idVendedorProducto) {
        this.idVendedorProducto = idVendedorProducto;
    }

    /**
     *
     * @return id_vendedor
     */
    public Long getId_vendedor() {
        return id_vendedor;
    }

    /**
     *
     * @param id_vendedor que se establece
     */
    public void setId_vendedor(Long id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    /**
     *
     * @return id_producto
     */
    public Long getId_producto() {
        return id_producto;
    }

    /**
     *
     * @param id_producto que se establece
     */
    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    /**
     *
     * @return fechaAlta
     */
    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    /**
     *
     * @param fechaAlta que se establece
     */
    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * Representacion en forma de entero para un VendedorProducto
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendedorProducto != null ? idVendedorProducto.hashCode() : 0);
        return hash;
    }

    /**
     * Compara dos VendedorProducto. Este método considera que un VendedorProducto
     * es igual que otro si los identificadores tienen el mismo valor
     *
     * @param object El otro VendedorProducto que compararemos
     * @return true si son iguales
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof VendedorProducto)) {
            return false;
        }
        VendedorProducto other = (VendedorProducto) object;
        if ((this.idVendedorProducto == null && other.idVendedorProducto != null) || (this.idVendedorProducto != null && !this.idVendedorProducto.equals(other.idVendedorProducto))) {
            return false;
        }
        return true;
    }

    /**
     * Obtenemos una representacion en forma de String del VendedorProducto
     *
     * @return
     */
    @Override
    public String toString() {
        return "flyshoes.entity.VendedorProducto[ id=" + idVendedorProducto + " ]";
    }

}
