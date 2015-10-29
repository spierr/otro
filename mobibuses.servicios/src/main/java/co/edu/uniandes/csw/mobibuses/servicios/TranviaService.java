/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.servicios;


import co.edu.uniandes.csw.mobibuses.dto.Tranvia;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioTranviaLocal;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.PersistenceManager;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fj.ricaurte10
 */

@Path("/Tranvia")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class TranviaService {
    
   
    
     @EJB
    private IServicioTranviaLocal tranviaEjb;
    
    
     @GET
    @Path("tranvias/")
     
    public List<Tranvia> getTodosLosUsuarios(@Context HttpHeaders headers) 
    {    
       String token = headers.getRequestHeader("token").get(0);
       return tranviaEjb.darTranvias(token);
 
    }
    
    
    @PUT
    @Path("tranvias/cambiar/{id}/{emergencia}/{valor}")
    
    public void cambiarNiveleDeEmergencia(@PathParam("id")String id ,@PathParam("emergencia") int emergenci , @PathParam("valor")int valor, @Context HttpHeaders headers )
    {
         String token = headers.getRequestHeader("token").get(0);
         for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                int g= i+j;
        } 
        }
        tranviaEjb.cambiarEstado(id, emergenci, valor,token);
        
    }
    
    @GET
    @Path("tranvias/generarReportes")
    public String generarReporteDeTranvias( @Context HttpHeaders headers)
    {
         String token = headers.getRequestHeader("token").get(0);
        return tranviaEjb.generarReporte(token);
        
    }
    
    
      @PUT
    @Path("tranvias/cambiarCoor/{id}/{coordenada1}/{coordenada2}")
    public void cambiarCoordenadas(@PathParam("id") String id,@PathParam("coordenada1") double coordenada1,@PathParam("coordenada2")double coordenada2,@Context HttpHeaders headers)
    {
         String token = headers.getRequestHeader("token").get(0);
         tranviaEjb.cambiarCoord(id,coordenada1,coordenada2,token);

    }
    
    
    
}
