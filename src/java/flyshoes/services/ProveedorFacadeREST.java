/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.services;

import flyshoes.entity.Proveedor;
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
 * @author 2dam
 */
@Stateless
@Path("proveedores")
public class ProveedorFacadeREST extends AbstractFacade<Proveedor> {

    @PersistenceContext(unitName = "ApplicationServerPU")
    private EntityManager em;

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
    public void edit( Proveedor entity) {
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


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
