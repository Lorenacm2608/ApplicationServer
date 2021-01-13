/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.services;

import flyshoes.entity.Usuario;
import flyshoes.exceptions.AutenticacionFallidaException;
import flyshoes.seguridad.Seguridad;
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
@Path("usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "ApplicationServerPU")
    private EntityManager em;
    private Logger LOGGER = Logger.getLogger(UsuarioFacadeREST.class.getName());

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void edit(Usuario entity) {
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
    public Usuario find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Login del usuario 
     *
     * @param login
     * @return usuario
     */
    @GET
    @Path("usuarioByLogin/{login}/{pass}")
    @Produces({MediaType.APPLICATION_XML})
    public Usuario usuarioByLogin(@PathParam("login") String login,@PathParam("pass") String pass) throws AutenticacionFallidaException {
        Usuario usuario = null;

        
            System.out.println(pass);
           usuario = (Usuario) em.createNamedQuery("usuarioByLogin").setParameter("login", login).getSingleResult();
            System.out.println("Passn de la base de datos "+usuario.getPassword());
            System.out.println(Seguridad.desencriptarContrasenia(pass)+" y ahora");
            if (usuario.getPassword().toString().equals(Seguridad.desencriptarContrasenia(pass))) {
                System.out.println(Seguridad.desencriptarContrasenia(pass)+" ASI");
            } else {
                LOGGER.severe("Contraseña incorrecta ");
                System.out.println("3");
                throw new AutenticacionFallidaException();
            }
        
        return usuario;
    }

}
