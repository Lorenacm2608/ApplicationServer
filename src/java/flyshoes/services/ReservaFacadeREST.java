package flyshoes.services;

import flyshoes.entity.Reserva;
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
 * 
 */
@Stateless
@Path("reserva")
public class ReservaFacadeREST extends AbstractFacade<Reserva> {

    @PersistenceContext(unitName = "ApplicationServerPU")
    private EntityManager em;

    public ReservaFacadeREST() {
        super(Reserva.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Reserva entity) {
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void edit( Reserva entity) {
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
    public Reserva find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     * Este método devuelve las reservas que han sido canceladas
     *
     * @return reservas
     */
    @GET
    @Path("findReservasCanceladas")
    @Produces({MediaType.APPLICATION_XML})
    public List<Reserva> findReservasCanceladas() {
        List<Reserva> reservas = new ArrayList(super.findReservasCanceladas());
        return reservas;
    }

    /**
     * Este método devuelve las reservas que han sido confirmadas
     *
     * @return reservas
     */
    @GET
    @Path("findReservasConfirmadas")
    @Produces({MediaType.APPLICATION_XML})
    public List<Reserva> findReservasConfirmadas() {
        List<Reserva> reservas = new ArrayList(super.findReservasConfirmadas());
        return reservas;
    }
    
    /**
     * Este método devuelve las reservas que han sido confirmadas
     *
     * @return reservas
     */
    @GET
    @Path("findReservas")
    @Produces({MediaType.APPLICATION_XML})
    public List<Reserva> findReservas() {
        List<Reserva> reservas = new ArrayList(super.findReservas());
        return reservas;
    }
    
    /**
     * Este método devuelve las reservas que han sido realizadas
     *
     * @return reservas
     */
    @GET
    @Path("findReservasRealizadas")
    @Produces({MediaType.APPLICATION_XML})
    public List<Reserva> findReservasRealizadas() {
        List<Reserva> reservas = new ArrayList(super.findReservasRealizadas());
        return reservas;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
