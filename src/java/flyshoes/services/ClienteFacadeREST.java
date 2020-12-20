/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.services;

import flyshoes.entity.Cliente;
import flyshoes.entity.Producto;
import flyshoes.entity.Reserva;
import flyshoes.entity.Usuario;
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
@Path("cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "ApplicationServerPU")
    private EntityManager em;
    private Logger LOGGER = Logger.getLogger(AdministradorFacadeREST.class.getName());
    
    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void edit( Cliente entity) {
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
    public Cliente find(@PathParam("id") Long id) {
        return super.find(id);
    }
    /**
     * Login cliente
     * @param login
     * @return cliente
     */
    @GET
    @Path("clienteByLogin/{login}")
    @Produces({MediaType.APPLICATION_XML})
    public Cliente clienteByLogin(@PathParam("login") String login) {
        Cliente cliente= null;
        try{
        cliente=(Cliente) em.createNamedQuery("clienteByLogin").setParameter("login", login).getSingleResult();
        } catch (Exception e) {
            LOGGER.severe(" " + e.getMessage());
        }
       return cliente;
    }
    
    
    /**
     * Metodo GET para recibir las reservas de un cliente: usa el metodo findReserva
     * @return Una lista de reservas de un Cliente.
     */
    @GET
    @Path("Reservas_cliente/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Reserva> findReserva(@PathParam("id") Long id) {
         List<Reserva> reservas = null;
        try {
            reservas = new ArrayList<>(em.createNamedQuery("findReserva").setParameter("id", id).getResultList());

        } catch (Exception e) {
            LOGGER.severe(" " + e.getMessage());
        }
        return reservas;
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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
