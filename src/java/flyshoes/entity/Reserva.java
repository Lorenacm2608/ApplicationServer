/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Esta clase se ecncargará sobre la gestión de reservas
 *
 * @author Fredy
 */
@Entity
@Table(name = "reserva", schema = "flyshoesdb")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    //id de la reserva
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //lista de productos que contiene la reserva
    @OneToMany(mappedBy = "reserva", fetch = EAGER)
    private List<Producto> productos;
    //descripcion de la reserva
    private String descripcion;
    //estado de la reserva
    private EstadoReserva estado;
    //vendedor que gestiona la reserva
    @ManyToOne
    private Vendedor vendedor;
    //cliente dueño de la reserva
    @ManyToOne
    private Cliente cliente;

    /**
     * Devuelve el id de la reserva
     *
     * @return id
     */
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
     * Devuelve al vendedor que ha gestionado la reserva
     *
     * @return vendedor
     */
    public Vendedor getVendedor() {
        return vendedor;
    }

    /**
     * Inserta al vendedor de la reserva
     *
     * @param vendedor
     */

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * Devuelve la lista de productos que contiene la reserva
     *
     * @return productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Añade una lista de productos que contiene la reserva
     *
     * @param productos
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}
