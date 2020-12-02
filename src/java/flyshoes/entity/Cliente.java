/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Nadir
 * Entidad Cliente relacionado con Reserva y creando la tabla ReservaCliente.
 */
@Entity
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;



    public Long getId() {
        return idCliente;
    }

    public void setId(Long idCliente) {
        this.idCliente = idCliente;
    }
   
    /*
    *Cualquier cambio(actualizar, quitar y insertar ) Cliente se produzca también debe producirse en cascada ReservaCliente
    */
    @OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
    private Set<ReservaCliente> reservaCliente;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "flyshoes.entity.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}