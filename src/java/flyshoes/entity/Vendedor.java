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

/**
 *
 * @author Lorena
 */
@Entity
public class Vendedor extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long login;
    private Long email;
    private Long fullName;
    private Long status;
    private Long privilege;
    private Long password;
    private Long lastAccess;
    private Long lastPasswordChange;
    private Long dni;
    private Long direccion;
    private Integer salario;

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

    public Long getFullName() {
        return fullName;
    }

    public void setFullName(Long fullName) {
        this.fullName = fullName;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Long privilege) {
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

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public Long getDireccion() {
        return direccion;
    }

    public void setDireccion(Long direccion) {
        this.direccion = direccion;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Long getTienda() {
        return tienda;
    }

    public void setTienda(Long tienda) {
        this.tienda = tienda;
    }
    private Long tienda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "flyshoes.entity.Vendedor[ id=" + id + " ]";
    }
    
}
