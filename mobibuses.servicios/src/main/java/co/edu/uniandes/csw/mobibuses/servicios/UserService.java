/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.servicios;

import co.edu.uniandes.csw.mobibuses.dto.User;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioEstacionVcubMockLocal;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioUserLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author s.correa12
 */
@Path("/User")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserService 
{
    @EJB
    private IServicioUserLocal userEjb;
     
     @POST
     @Path("login/")
     public String login(User u)
     {
         return userEjb.login(u);
     }
     
     @GET
     @Path("users/")
     public List<User> darUsers()
     {
         return userEjb.darUsers();
     }
}
