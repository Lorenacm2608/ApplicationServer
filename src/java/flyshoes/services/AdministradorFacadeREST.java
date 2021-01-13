/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.services;

import flyshoes.entity.Administrador;
import flyshoes.entity.Proveedor;
import flyshoes.entity.Vendedor;
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
@Path("administrador")
public class AdministradorFacadeREST extends AbstractFacade<Administrador> {

    @PersistenceContext(unitName = "ApplicationServerPU")
    private EntityManager em;
    private Logger LOGGER = Logger.getLogger(AdministradorFacadeREST.class.getName());

    public AdministradorFacadeREST() {
        super(Administrador.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Administrador entity) {
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void edit(Administrador entity) {
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
    public Administrador find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     * Lista de todos los proveeedores ordenados por Empresa
     *
     * @return proveedores
     */
    @GET
    @Path("proveedores")
    @Produces({MediaType.APPLICATION_XML})
    public List<Proveedor> getProveedores() {
        List<Proveedor> proveedores = null;
        try {
            proveedores = new ArrayList<>(em.createNamedQuery("listaProveedores").getResultList());

        } catch (Exception e) {
            LOGGER.severe(" " + e.getMessage());
        }
        return proveedores;
    }

    /**
     * Lista de vendedores ordenados por login
     *
     * @return vendedores
     */
    @GET
    @Path("vendedores")
    @Produces({MediaType.APPLICATION_XML})
    public List<Vendedor> getVendedores() {
        List<Vendedor> vendedores = null;
        try {
            vendedores = new ArrayList<>(em.createNamedQuery("listaVendedores").getResultList());

        } catch (Exception e) {
            LOGGER.severe(" " + e.getMessage());
        }
        return vendedores;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
