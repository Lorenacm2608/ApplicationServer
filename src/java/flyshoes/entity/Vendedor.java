/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.entity;

import java.io.Serializable;
import java.util.Set;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
 *
 * @author Moroni
 * Entidad Vendedor relacionado con gestiona Producto y maneja Reserva
 */
@Entity
@Table(name="Vendedor",schema="flyshoesdb")
@XmlRootElement
public class Vendedor extends Usuario implements Serializable {

    /*
    *Vendedor se relaciona con Reserva por OneToMany
    */
    @OneToMany( mappedBy="Vendedor")
    private Set<Reserva> reserva;
    
    /*
    *Vendedor se relaciona con Cliente por OneToMany
    */
    @OneToMany( mappedBy="vendedor")
    private Set<Cliente> cliente;
    
    /*
    *Vendedor se relaciona con Producto por ManyToMany
    */
    @ManyToMany( mappedBy="Vendedor")
    private Set<Producto> producto;
    
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

    public Vendedor(){
        
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
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

    @XmlTransient
    public Set<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(Set<Reserva> reserva) {
        this.reserva = reserva;
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
        return producto;
    }

    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "flyshoes.entity.Vendedor[ id=" + dni + " ]";
    }
    
}