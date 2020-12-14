/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Esta clase se encargará de facilitarnos productos(ropa y zapatillas).
 *
 * @author Fredy
 */
@Entity
@Table(name = "proveedor", schema = "flyshoesdb")
@NamedQuery(name = "listaProductos",
        query = "SELECT p FROM Producto p WHERE p.proveedor.idProveedor =:id ORDER BY p.modelo ")

@XmlRootElement

public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id del proveedor
    private Long idProveedor;
    @NotNull
    private String nombre;
    //tipo de proveedor 
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoProducto tipo;
    //empresa a la que pertenece el proveedor
    @NotNull
    private String empresa;
    //correo del proveedor
    @NotNull
    private String email;
    //telefono del proveedor
    @NotNull
    private String telefono;
    //descripcion del proveedor
    private String descripcion;

    //administrador encargado del proveedor
    @ManyToOne
    private Administrador administrador;
    //lista de productos ofrecidos por el proveedor
    @OneToMany(mappedBy = "proveedor", fetch = EAGER)
    private Set<Producto> productos;

    /**
     * Retorna el administrador encargado
     *
     * @return administrador
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Añadir administrador
     *
     * @param administrador
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Devuelve lista de productos ofrecidas por el proveedor
     *
     * @return lista de productos
     */
    @XmlTransient
    public Set<Producto> getProductos() {
        return productos;
    }

    /**
     * Añade lista de productos ofrecidas por el proveedor
     *
     * @param productos
     */
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Devuelve el id del proveedor
     *
     * @return id
     */
    public Long getIdProveedor() {
        return idProveedor;
    }

    /**
     * Inserta el id del proveedor
     *
     * @param idProveedor
     */
    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * Devuelve el tipo de proveedor
     *
     * @return tipo
     */
    public TipoProducto getTipo() {
        return tipo;
    }

    /**
     * Inserta el tipo de proveedor
     *
     * @param tipo
     */
    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el nombre de la empresa ala que pertenece el proveedor
     *
     * @return empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Inserta el nombre de la empresa ala que pertenece el proveedor
     *
     * @param empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Devuelve el correo del proveedor
     *
     * @return correo
     */
    public String getEmail() {
        return email;
    }

    /**
     * Inserta el correo del proveedor
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuel el telefono del proveedor
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Inserta el telefono del proveedor
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve la descripcion del proveedor
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Inserta la descripcion del proveedor
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el nombre del proveedor
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Inserta el nombre del proveedor
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
