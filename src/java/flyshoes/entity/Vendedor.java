package flyshoes.entity;

import java.io.Serializable;
import java.util.Set;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
 * Entidad Vendedor relacionado con gestiona Producto y maneja Reserva
 */
@Entity
@Table(name = "vendedor", schema = "flyshoesdb")
@XmlRootElement
public class Vendedor extends Usuario implements Serializable {

    /*
     * Vendedor se relaciona con Cliente por OneToMany
     */
    @OneToMany(mappedBy = "vendedor")
    private Set<Cliente> cliente;

    /*
    *Vendedor se relaciona con Producto por ManyToMany
     */
    @ManyToMany(fetch = EAGER, cascade = MERGE)
    @JoinTable(schema = "flyshoesdb", name = "vendedorProducto")
    private Set<Producto> productos;

    private static final long serialVersionUID = 1L;

    /*
    * Dni del vendedor
     */
    private Long dni;

    /*
    * Direccion del vendedor
     */
    private Long direccion;

    /*
    * Salario del vendedor
     */
    private Integer salario;

    /*
    * Tienda del vendedor
     */
    private Long tienda;

    public Vendedor() {

    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public Long getDireccion() {
        return direccion;
    }

    public void setDireccion(Long direccion) {
        this.direccion = direccion;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Long getTienda() {
        return tienda;
    }

    public void setTienda(Long tienda) {
        this.tienda = tienda;
    }

    @XmlTransient
    public Set<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(Set<Cliente> cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public Set<Producto> getProducto() {
        return productos;
    }

    public void setProducto(Set<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "flyshoes.entity.Vendedor[ id=" + dni + " ]";
    }

}