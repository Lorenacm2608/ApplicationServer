/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Clase Administrador que hereda de Usuario, esta clase será la encargada de la
 * gestion de proveedores.
 *
 *
 * @author Fredy
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id_usuario")
@Table(name = "administrador", schema = "flyshoesdb")
@NamedQueries({
    @NamedQuery(name = "listaProveedores",
            query = "SELECT p FROM Proveedor p"
    )
    ,@NamedQuery(name = "listaVendedores",
            query = "SELECT v FROM Vendedor v  ORDER BY v.login "
    )
})

@XmlRootElement
public class Administrador extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    //Lista de Proveedores gestionados
    @OneToMany(mappedBy = "administrador", fetch = EAGER)
    private Set<Proveedor> proveedores;

    @OneToMany(mappedBy = "administrador", fetch = EAGER)
    private Set<Vendedor> vendedores;

    /**
     * Devuelve la lista de vendedores gestionados
     *
     * @return vendedores
     */
    public Set<Vendedor> getVendedores() {
        return vendedores;
    }

    /**
     * Inserta una lista de vendedores
     *
     * @param vendedores
     */
    public void setVendedores(Set<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    /**
     * Devuelve la lista de proveedores gestionados
     *
     * @return proveedores
     */
    public Set<Proveedor> getProveedores() {
        return proveedores;
    }

    /**
     * Inserta una lista de proveedores
     *
     * @param proveedores
     */
    public void setProveedores(Set<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

}
