/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.services;

import flyshoes.emailService.EmailService;
import flyshoes.entity.Usuario;
import flyshoes.exceptions.AutenticacionFallidaException;
import flyshoes.exceptions.EmailNoExisteException;
import flyshoes.exceptions.EmailYaExisteException;
import flyshoes.exceptions.UsuarioNotFoundException;
import flyshoes.seguridad.Seguridad;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    public void create(Usuario usuario) {
        try {
            usuario.setPassword(Seguridad.cifradoSha(usuario.getPassword()));
            super.create(usuario);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "UsuarioFacadeREST: Excepción al crear usuario",
                    e.getMessage());

        }

    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void edit(Usuario usuario) {
        try {
            usuario.setPassword(Seguridad.cifradoSha(usuario.getPassword()));
            super.edit(usuario);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "UsuarioFacadeREST: Excepción al modificar usuario",
                    e.getMessage());
        }

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
    public Usuario usuarioByLogin(@PathParam("login") String login, @PathParam("pass") String pass) throws AutenticacionFallidaException, UsuarioNotFoundException {
        Usuario usuario = null;
        String passSha = Seguridad.cifradoSha(Seguridad.desencriptarContrasenia(pass));
        try {
            usuario = (Usuario) em.createNamedQuery("usuarioByLogin").setParameter("login", login).getSingleResult();
            if (!usuario.getPassword().equals(passSha)) {
                LOGGER.severe("Contraseña incorrecta ");
                throw new AutenticacionFallidaException();
            }
        } catch (NoResultException e) {
            LOGGER.log(Level.SEVERE, "UsuarioFacadeREST: Excepcion al buscar usuario por login",
                    e.getMessage());
            throw new UsuarioNotFoundException();

        }
        return usuario;
    }

    /**
     * Retorna usuario por login
     *
     * @param login
     * @return usuario
     */
    @GET
    @Path("UsuarioLogin/{login}")
    @Produces({MediaType.APPLICATION_XML})
    public Usuario usuarioLogin(@PathParam("login") String login) throws UsuarioNotFoundException {
        Usuario usuario = null;
        try {
            LOGGER.info("Buscando usuarrio por login.");
            usuario = (Usuario) em.createNamedQuery("usuarioByLogin").setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
            LOGGER.log(Level.SEVERE, "UsuarioFacadeREST: Excepcion al buscar usuario por login",
                    e.getMessage());
            throw new UsuarioNotFoundException();
        }

        return usuario;
    }
    /**
     * Consulta si el email ya se encuentra registrado
     * @param email
     * @return
     * @throws EmailNoExisteException 
     */

    @GET
    @Path("findEmail/{email}")
    @Produces({MediaType.APPLICATION_XML})
    public Usuario findEmail(@PathParam("email") String email) throws EmailNoExisteException {
        Usuario usuario = null;
        try {
            LOGGER.info("Buscando usuarrio por login.");
            usuario = (Usuario) em.createNamedQuery("findEmail").setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {
            LOGGER.log(Level.SEVERE, "UsuarioFacadeREST: Excepcion al buscar usuario por login",
                    e.getMessage());
            throw new EmailNoExisteException();
        }
        return usuario;
    }

    /**
     * Enviar código a la dirección de correo
     *
     * @param email
     * @param pass
     */
    @GET
    @Path("enviarMensajeEmail/{email}/{pass}")
    @Produces({MediaType.APPLICATION_XML})
    public void enviarMensajeEmail(@PathParam("email") String email, @PathParam("pass") String pass) {
        EmailService emailService = null;
        try {
            emailService = new EmailService();
            emailService.sendMail(Seguridad.desencriptarContrasenia(email), "FlyshoesSecurity ", "Código temporal: " + Seguridad.desencriptarContrasenia(pass));

        } catch (MessagingException e) {
            LOGGER.log(Level.SEVERE, "UsuarioFacadeREST: Excepcion al enviar el código",
                    e.getMessage());
        }

    }

}
