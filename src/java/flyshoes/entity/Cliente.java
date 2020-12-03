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
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * @author Nadir
 * Entidad Cliente que representa a clientes. Este tiene el siguiente campo:
 * id_clientee. Este tiene relacion con Reserva y creando la tabla ReservaCliente.
 */
@Entity
@Table(name="client",schema="flyshoesdb")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Cualquier cambio(actualizar, quitar y insertar ) Cliente se produzca también debe producirse en cascada ReservaCliente
     */
    @OneToMany(mappedBy="clientes", cascade=CascadeType.ALL)
    private Set<ReservaCliente> reservaCliente;
  
}