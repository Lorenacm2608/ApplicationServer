package flyshoes.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entidad Cliente, hereda de Usuario, del cual tiene sus atributos.
 * Esta relacionada con Reserva (OneToMany) y Vendedor (ManyToOne).
 * @author Nadir
 */
@Entity
@Table(name="cliente", schema="flyshoesdb")
@XmlRootElement
public class Cliente extends Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    /*
    * Cliente se relación con reservas via OneToMany
    */
    @OneToMany(mappedBy="cliente",cascade=CascadeType.ALL,fetch=EAGER)
    private Set<Reserva> reservas;
    
    /*
    * Cliente se relación con reservas via ManyToOne
    */
    @ManyToOne
    private Vendedor vendedor;
    
    /**
     * 
     * @return reservas, retorna las reservas de un Cliente.
     */
    @XmlTransient
    public Set<Reserva> getReservas() {
        return reservas;
    }
    
    /**
     * 
     * @param reservas, Creamos las reservas de un Cliente.
     */
    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    /**
     * 
     * @return vendedor, retorna el vendedor de los Clientes.
    */
    @XmlTransient
    public Vendedor getVendedor() {
        return vendedor;
    }
    
    /**
     * 
     * @param vendedor, Creamos el vendedor de los Clientes.
     */
     public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
}