/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Lorena
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(flyshoes.services.AdministradorFacadeREST.class);
        resources.add(flyshoes.services.ClienteFacadeREST.class);
        resources.add(flyshoes.services.ProductoFacadeREST.class);
        resources.add(flyshoes.services.ProveedorFacadeREST.class);
        resources.add(flyshoes.services.ReservaFacadeREST.class);
        resources.add(flyshoes.services.UsuarioFacadeREST.class);
        resources.add(flyshoes.services.VendedorFacadeREST.class);
    }
    
}
