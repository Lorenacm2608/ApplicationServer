/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
/*
@Entity
@DiscriminatorValue(value="C")
*/
@Entity
@Table(name="cliente", schema="reto6")
@PrimaryKeyJoinColumn(referencedColumnName="id")
@XmlRootElement
public class Cliente extends Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @OneToMany(mappedBy="cliente",cascade=CascadeType.ALL,fetch=EAGER)
    private Set<Reserva> reservas;

    @ManyToOne
    private Vendedor vendedor;
    
    @XmlTransient
    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }
    
}
