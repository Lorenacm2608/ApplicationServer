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
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Clase Administrador que hereda de Usuario, esta clase será la encargada de la
 * gestion de proveedores.
 *
 *
 * @author Fredy
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id_usuario")
@Table(name="administrador", schema="flyshoesdb")
public class Administrador extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    //Lista de Proveedores gestionados
    @OneToMany(mappedBy = "administrador", fetch = EAGER)
    private Set<Proveedor> proveedores;

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
     * @param lista de proveedores
     */
    public void setProveedores(Set<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

}
