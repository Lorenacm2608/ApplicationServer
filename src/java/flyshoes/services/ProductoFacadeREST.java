package flyshoes.services;

import flyshoes.entity.Producto;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lorena Cáceres Manuel
 */
@Stateless //Inyección de EJB 
@Path("flyshoes.entity.producto")
public class ProductoFacadeREST extends AbstractFacade<Producto> {

    private static final Logger LOG = Logger.getLogger(ProductoFacadeREST.class.getName());

    //Indicamos cual es la unidad de persistencia
    @PersistenceContext(unitName = "ApplicationServerPU")
    private EntityManager em;

    /**
     * Dentro del constructor hacemos llamada a AbstractFacade e indicamos la
     * clase abstracta en la que nos encontramos
     */
    public ProductoFacadeREST() {
        super(Producto.class);
    }

    /**
     * Este método nos permite insertar nuevos productos
     *
     * @param entity
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Producto entity) {
        super.create(entity);
    }

    /**
     * Este método nos permite editar uno de los productos
     *
     * @param entity
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void edit(Producto entity) {
        super.edit(entity);
    }

    /**
     * Este método nos permite eliminar un producto por su id
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    /**
     * Este método nos devuelve un producto el cual hemos buscado por su id
     *
     * @param id
     * @return producto
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Producto find(@PathParam("id") Long id) {
        return super.find(id);
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
        Set<Producto> productos = null;
        try {
            productos = new HashSet<>(em.createNamedQuery("findAllProductosAsc").getResultList());
        } catch (Exception e) {
            LOG.severe(" " + e.getMessage());
            //Lanzamos la excepcion que hemos creado
        }
        return productos;
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
        Set<Producto> productos = null;
        try {
            productos = new HashSet<>(em.createNamedQuery("findAllProductosDesc").getResultList());
        } catch (Exception e) {
            LOG.severe(" " + e.getMessage());
            //Lanzamos la excepcion que hemos creado
        }
        return productos;
    }

    /**
     * Este método nos permite buscar todos los productos los cuales tengan en
     * su descripción incluido 'Zapatillas'
     *
     * @return zapatillas. Colección de productos
     */
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

    /**
     * Este método nos permite buscar todos los productos los cuales tengan en
     * su descripcion incluido 'Ropa'
     *
     * @return ropa. Colección de productos
     */
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

    /**
     * Este método nos devuelve un entityManager
     *
     * @return em
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
