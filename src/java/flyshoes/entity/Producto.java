package flyshoes.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lorena Cáceres Manuel
 *
 * Entidad producto está relacionada con la entidad Reserva, vendedor y
 * proveedor. Esta entidad tiene una identificador de producto, una descripción,
 * un precio y una imagen del producto.
 */
@Entity
@Table(name = "producto", schema = "flyshoesdb")
@XmlRootElement
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador del producto
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Descripcion del producto
     */
    private String descripcion;
    /**
     * Precio del producto
     */
    private Float precio;
    /**
     * Imagen del producto
     */
    @Lob
    private byte[] imagen;
    /**
     * Relación con la entidad Reserva
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Set<Reserva> reservas;
    /**
     * Relación con la entidad Proveedor
     */
    @ManyToOne
    private Proveedor proveedor;
    /**
     * Relación con la entidad Vendedor
     */
    @ManyToMany(mappedBy = "productos", cascade = CascadeType.ALL, fetch = EAGER)
    private Set<Vendedor> vendedores;

    /**
     *
     * @return imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     *
     * @param imagen que establecemos
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /**
     *
     * @return reseva
     */
    @XmlTransient
    public Set<Reserva> getReservas() {
        return reservas;
    }

    /**
     *
     * @param reserva que establecemos
     */
    public void setReservas(Set<Reserva> reserva) {
        this.reservas = reserva;
    }

    /**
     *
     * @return proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     *
     * @param proveedor que establecemos
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     *
     * @return vendedores, contiene los vendedores que han gestionado un
     * producto
     */
    @XmlTransient
    public Set<Vendedor> getVendedores() {
        return vendedores;
    }

    /**
     *
     * @param vendedores que establecemos
     */
    public void setVendedores(Set<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    /**
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion que estableceremos
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return precio
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio que estableceremos
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id que estableceremos
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Representacion en forma de entero para un producto
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara dos productos. Este método considera que un producto es igual que
     * otro si los identificadores tienen el mismo valor
     *
     * @param object El otro producto que compararemos
     * @return true si son iguales
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Obtenemos una representacion en forma de String del producto
     *
     * @return
     */
    @Override
    public String toString() {
        return "flyshoes.entity.Producto[ id=" + id + " ]";
    }

}
