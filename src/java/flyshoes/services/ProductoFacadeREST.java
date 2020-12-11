package flyshoes.services;

import flyshoes.entity.Producto;
import java.util.ArrayList;
import java.util.List;
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
@Stateless
@Path("productos")
public class ProductoFacadeREST extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "ApplicationServerPU")
    private EntityManager em;

    public ProductoFacadeREST() {
        super(Producto.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Producto entity) {
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void edit(Producto entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

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
    @Path("findAllProductosAsc")
    @Produces({MediaType.APPLICATION_XML})
    public List<Producto> findAllProductosAsc() {
        List<Producto> productos = new ArrayList<>(super.findAllProductosAsc());
        return productos;
    }

    /**
     * Este método nos devuelve todos los productos en orden descendente
     * dependiendo de su precio
     *
     * @return productos. Colección de productos
     */
    @GET
    @Path("findAllProductoDesc")
    @Produces({MediaType.APPLICATION_XML})
    public List<Producto> findAllProductosDesc() {
        List<Producto> productos = new ArrayList<>(super.findAllProductosDesc());
        return productos;

    }

    /**
     * Este método nos permite buscar todos los productos los cuales tengan en
     * su descripción incluido 'Zapatillas'
     *
     * @return zapatillas. Colección de productos
     */
    @GET
    @Path("findAllZapatillas")
    @Produces({MediaType.APPLICATION_XML})
    public List<Producto> findAllZapatillas() {
        List<Producto> zapatillas = new ArrayList<>(super.findAllZapatillas());
        return zapatillas;
    }

    /**
     * Este método nos permite buscar todos los productos los cuales tengan en
     * su descripcion incluido 'Ropa'
     *
     * @return ropa. Colección de productos
     */
    @GET
    @Path("findAllRopa")
    @Produces({MediaType.APPLICATION_XML})
    public List<Producto> findAllRopa() {
        List<Producto> ropa = new ArrayList<>(super.findAllRopa());
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
