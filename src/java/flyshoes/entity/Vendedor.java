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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
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
    @OneToMany(mappedBy="Vendedor")
    private Set<Reserva> reserva;
    
    /*
    *Vendedor se relaciona con Producto por ManyToMany
    */
    @OneToMany(cascade = MERGE, mappedBy="vendedor")
    private Set<VendedorProducto> vendedorProducto;
    
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

    public Vendedor(){
        
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

    public Set<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(Set<Reserva> reserva) {
        this.reserva = reserva;
    }
    
    public Set<VendedorProducto> getVendedorProducto() {
        return vendedorProducto;
    }

    public void setVendedorProducto(Set<VendedorProducto> vendedorProducto) {
        this.vendedorProducto = vendedorProducto;
    }

    @Override
    public String toString() {
        return "flyshoes.entity.Vendedor[ id=" + dni + " ]";
    }
    
}
