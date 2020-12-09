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
import javax.persistence.JoinTable;
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
    *Vendedor se relaciona con Cliente por OneToMany
    */
    @OneToMany( mappedBy="vendedor")
    private Set<Cliente> clientes;
    
    /*
    *Vendedor se relaciona con Producto por ManyToMany
    */
    @ManyToMany
    @JoinTable(name="VendedorProducto")
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

    public Vendedor(){
        
    }

    /*
     * Devuelve el valor de salario para Usuario
     * @return el valor de salario
     */
    public Integer getSalario() {
        return salario;
    }

    /*
     * Establece el valor de salario para Usuario
     * @param de salario del valor salario
     */
    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    /*
     * Devuelve el valor de dni para Usuario
     * @return el valor de dni
     */
    public String getDni() {
        return dni;
    }
    /*
     * Establece el valor de dni para Usuario
     * @param de dni del valor dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /*
     * Devuelve el valor de direccion para Usuario
     * @return el valor de direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /*
     * Establece el valor de direccion para Usuario
     * @param de direccion del valor direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /*
     * Devuelve el valor de tienda para Usuario
     * @return el valor de tienda
     */
    public String getTienda() {
        return tienda;
    }

    /*
     * Establece el valor de tienda para Usuario
     * @param de tienda del valor tienda
     */
    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
    
    /*
     * Devuelve el valor de cliente para Usuario
     * @return el valor de cliente
     */
    @XmlTransient
    public Set<Cliente> getCliente() {
        return clientes;
    }

    /*
     * Establece el valor de cliente para Usuario
     * @param de cliente del valor cliente
     */
    public void setCliente(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    /*
     * Devuelve el valor de producto para Usuario
     * @return el valor de producto
     */
    @XmlTransient
    public Set<Producto> getProducto() {
        return productos;
    }

    /*
     * Establece el valor de producto para Usuario
     * @param de producto del valor producto
     */
    public void setProducto(Set<Producto> producto) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "flyshoes.entity.Vendedor[ id=" + dni + " ]";
    }
    
}