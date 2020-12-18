package flyshoes.services;

import flyshoes.entity.Producto;
import flyshoes.entity.Reserva;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author flyshoes
 * @param <T>
 * 
 */
public abstract class AbstractFacade<T> {

    private  Class<T> entityClass;

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
     * Implementa el método que nos muestra las reservas canceladas
     *
     * @return lista de reservas
     */
    public List<Reserva> findReservasCanceladas() {
        return (List<Reserva>) getEntityManager().createNamedQuery("findReservasCanceladas").getResultList();
    }

    /**
     * Implementa el método que nos muestra las reservas confirmadas
     *
     * @return lista de reservas
     */
    public List<Reserva> findReservasConfirmadas() {
        return (List<Reserva>) getEntityManager().createNamedQuery("findReservasConfirmadas").getResultList();
    }

    /**
     * Implementa el método que nos muestra las reservas realizadas
     *
     * @return lista de reservas
     */
    public List<Reserva> findReservasRealizadas() {
        return (List<Reserva>) getEntityManager().createNamedQuery("findReservasRealizadas").getResultList();
    }

    /**
     * Implementa el método que muestra los productos de manera ascendente según
     * el precio
     *
     * @return lista de productos
     */
    public List<Producto> findAllProductosAsc() {
        return (List<Producto>) getEntityManager().createNamedQuery("findAllProductosAsc").getResultList();

    }

    /**
     * Implementa el método que muestra los productos de manera descendente
     * según el precio
     *
     * @return lista de productos
     */
    public List<Producto> findAllProductosDesc() {
        return (List<Producto>) getEntityManager().createNamedQuery("findAllProductosDesc").getResultList();

    }

    /**
     * Implementa el método que nos muestra las zapatillas
     *
     * @return lista de productos
     */
    public List<Producto> findAllZapatillas() {
        return (List<Producto>) getEntityManager().createNamedQuery("findAllZapatillas").getResultList();
    }

    /**
     * Implementa el método nos muestra la ropa
     *
     * @return lista de productos
     */
    public List<Producto> findAllRopa() {
        return (List<Producto>) getEntityManager().createNamedQuery("findAllRopa").getResultList();
    }

}
