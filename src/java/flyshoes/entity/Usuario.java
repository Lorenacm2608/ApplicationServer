/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Moroni
 * Entidad Usuario relacionado con gestiona Proveedor
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="Usuario",schema="flyshoesdb")
@XmlRootElement
public class Usuario implements Serializable {

    /*
    *Usuario se relaciona con Proveedor por OneToMany
    */
    @OneToMany(mappedBy="Usuario")
    private Set<Proveedor> proveedor;
    
    private static final long serialVersionUID = 1L;
    
    /*
    *Id del usuario
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_usuario;
    
    /*
    * Login del usuario
    */
    private Long login;
    
    /*
    * Email del usuario
    */
    private Long email;
    
    /*
    * Nombre completo del usuario
    */
    private Long fullname;
    
    /*
    * Estado del usuario
    */
    private Enum status;
    
    /*
    * Privilegio del usuario
    */
    private Enum privilege;
    
    /*
    * Contraseña del usuario
    */
    private Long password;
    
    /*
    * Ultimo acceso del usuario
    */
    private Long lastAccess;
    
    /*
    * Ultimo cambio de contraseña del usuario
    */
    private Long lastPasswordChange;

    public Usuario(){
        
}
    
    public Long getLogin() {
        return login;
    }

    public void setLogin(Long login) {
        this.login = login;
    }

    public Long getEmail() {
        return email;
    }

    public void setEmail(Long email) {
        this.email = email;
    }

    public Long getFullname() {
        return fullname;
    }

    public void setFullname(Long fullname) {
        this.fullname = fullname;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Enum getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Enum privilege) {
        this.privilege = privilege;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public Long getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Long lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Long getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(Long lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public Set<Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(Set<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    /*
    * Implementacion del metodo Hashcode para la entidad
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_usuario != null ? id_usuario.hashCode() : 0);
        return hash;
    }

    /*
    * Este metodo compara 2 entidades Usuario.
    * Esta implementacion compara el campo id
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id_usuario == null && other.id_usuario != null) || (this.id_usuario != null && !this.id_usuario.equals(other.id_usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "flyshoes.entity.Usuario[ id=" + id_usuario + " ]";
    }
    
}
