/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.services;

import flyshoes.entity.Proveedor;
import flyshoes.entity.Reserva;
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
 * @author Lorena
 */
@Stateless
@Path("vendedor")
public class VendedorFacadeREST extends AbstractFacade<Vendedor> {

    @PersistenceContext(unitName = "ApplicationServerPU")
    private EntityManager em;
    private Logger LOGGER = Logger.getLogger(VendedorFacadeREST.class.getName());

    public VendedorFacadeREST() {
        super(Vendedor.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Vendedor entity) {
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void edit(Vendedor entity) {
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
    public Vendedor find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Devuelve la lista completa de las reservas 
     *
     * @return lista reservas
     */
    @GET
    @Path("findAllReservas")
    @Produces({MediaType.APPLICATION_XML})
    public List<Reserva> findAllReservas() {
        List<Reserva> reservas = null;
        try {
            reservas = new ArrayList<>(em.createNamedQuery("findAllReservas").getResultList());
        } catch (Exception e) {
            LOGGER.severe(" " + e.getMessage());
        }
        return reservas;
    }

    /**
     * Devuelve la lista completa de vendedores
     *
     * @return lista reservas
     */
    @GET
    @Path("findAllVendedores")
    @Produces({MediaType.APPLICATION_XML})
    public List<Vendedor> findAllVendedores() {
        List<Vendedor> vendedores = null;
        try {
            vendedores = new ArrayList<>(em.createNamedQuery("findAllVendedores").getResultList());
        } catch (Exception e) {
            LOGGER.severe(" " + e.getMessage());
        }
        return vendedores;
    }

    /**
     * Lista de todos los proveeedores ordenados por Empresa
     *
     * @return proveedores
     */
    @GET
    @Path("listaProveedoresProducto")
    @Produces({MediaType.APPLICATION_XML})
    public List<Proveedor> getProveedoresProducto() {
        List<Proveedor> proveedores = null;
        try {
            proveedores = new ArrayList<>(em.createNamedQuery("listaProveedoresProducto").getResultList());

        } catch (Exception e) {
            LOGGER.severe(" " + e.getMessage());
        }
        return proveedores;
    }
}
