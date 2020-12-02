/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
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
    @ManyToMany(mappedBy="Vendedor")
    private Set<Producto> producto;
    
    private static final long serialVersionUID = 1L;
    /*
    *Id del vendedor
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private BigInteger id_vendedor;
    
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

    public Set<Producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }

    public BigInteger getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(BigInteger id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    /*
    * Implementacion del metodo Hashcode para la entidad
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_vendedor != null ? id_vendedor.hashCode() : 0);
        return hash;
    }

    /*
    * Este metodo compara 2 entidades Vendedor.
    * Esta implementacion compara el campo id
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.id_vendedor == null && other.id_vendedor != null) || (this.id_vendedor != null && !this.id_vendedor.equals(other.id_vendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "flyshoes.entity.Vendedor[ id=" + id_vendedor + " ]";
    }
    
}
