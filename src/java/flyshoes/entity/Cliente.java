/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nadir
 * Entidad Cliente que representa a clientes. Este tiene el siguiente campo:
 * id_clientee. Este tiene relacion con Reserva y creando la tabla ReservaCliente.
 */
@Entity
@Table(name="client",schema="flyshoesdb")
@XmlRootElement
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cliente;



    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id) {
        this.id_cliente = id;
    }
   
    /*
    *Cualquier cambio(actualizar, quitar y insertar ) Cliente se produzca también debe producirse en cascada ReservaCliente
    */
    @OneToMany(mappedBy="clientes", cascade=CascadeType.ALL)
    private Set<ReservaCliente> reservaCliente;
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_cliente != null ? id_cliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id_cliente == null && other.id_cliente != null) || (this.id_cliente != null && !this.id_cliente.equals(other.id_cliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "flyshoes.entity.Cliente[ idCliente=" + id_cliente + " ]";
    }
    
}