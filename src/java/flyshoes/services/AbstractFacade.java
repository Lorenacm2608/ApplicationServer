/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.services;

import flyshoes.entity.Producto;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lorena
 */
public abstract class AbstractFacade<T> {

    private static final Logger LOG = Logger.getLogger(AbstractFacade.class.getName());
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Este método nos devuelve todos los productos en orden ascendente
     * dependiendo de su precio
     *
     * @return productos. Colección de productos
     */
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Set<Producto> findAllProductosAsc() { //IllegalArgumentException
        return (Set<Producto>) getEntityManager().createNamedQuery("findAllProductosAsc").getResultList();

    }

    /**
     * Este método nos devuelve todos los productos en orden descendente
     * dependiendo de su precio
     *
     * @return productos. Colección de productos
     */
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Set<Producto> findAllProductosDesc() {
        return (Set<Producto>) getEntityManager().createNamedQuery("findAllProductosDesc").getResultList();

    }

    /**
     * Este método nos permite buscar todos los productos los cuales tengan en
     * su descripción incluido 'Zapatillas'
     *
     * @return zapatillas. Colección de productos
     */
    /*
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Set<Producto> findAllZapatillas() {
        Set<Producto> zapatillas = null;
        try {
            zapatillas = new HashSet<>(em.createNamedQuery("findAllZapatillas").getResultList());
        } catch (Exception e) {
            LOG.severe(" " + e.getMessage());
            //Lanzamos la excepcion que hemos creado
        }
        return zapatillas;
    }
     */
    /**
     * Este método nos permite buscar todos los productos los cuales tengan en
     * su descripcion incluido 'Ropa'
     *
     * @return ropa. Colección de productos
     */
    /*
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Set<Producto> findAllRopa() {
        Set<Producto> ropa = null;
        try {
            ropa = new HashSet<>(em.createNamedQuery("findAllRopa").getResultList());
        } catch (Exception e) {
            LOG.severe(" " + e.getMessage());
            //Lanzamos la excepcion que hemos creado
        }
        return ropa;
    }
     */
}
