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
    private String dni;

    /*
    * Direccion del vendedor
     */
    private String direccion;

    /*
    * Salario del vendedor
     */
    private Integer salario;

    /*
    * Tienda del vendedor
     */
    private String tienda;

    public Vendedor() {

    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
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