/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.services;

import flyshoes.entity.Producto;
import flyshoes.entity.Proveedor;
import java.util.ArrayList;
import java.util.List;
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
 * @author 2dam
 */
@Stateless
@Path("proveedor")
public class ProveedorFacadeREST extends AbstractFacade<Proveedor> {

    @PersistenceContext(unitName = "ApplicationServerPU")
    private EntityManager em;
    private Logger LOGGER = Logger.getLogger(ProveedorFacadeREST.class.getName());

    public ProveedorFacadeREST() {
        super(Proveedor.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Proveedor entity) {
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void edit(Proveedor entity) {
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
    public Proveedor find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     * Lista de productos ofrecidos
     *
     * @param id del proveedor
     * @return productos
     */
    @GET
    @Path("getAllProveedores")
    @Produces({MediaType.APPLICATION_XML})
    public List<Proveedor> getAllProveedores() {
        List<Proveedor> listproveedores = null;
        try {
            listproveedores = new ArrayList<>(em.createNamedQuery("getAllProveedores").getResultList());
        } catch (Exception e) {
            LOGGER.severe(" " + e.getMessage());
        }
        return listproveedores;

    }

    /**
     * Lista de productos ofrecidos
     *
     * @param id del proveedor
     * @return productos
     */
    @GET
    @Path("producto/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Producto> getProductos(@PathParam("id") Long id) {
        List<Producto> productos = null;
        try {
            productos = new ArrayList<>(em.createNamedQuery("listaProductos").setParameter("id", id).getResultList());
        } catch (Exception e) {
            LOGGER.severe(" " + e.getMessage());
        }
        return productos;

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
