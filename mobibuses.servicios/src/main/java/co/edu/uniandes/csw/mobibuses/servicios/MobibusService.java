/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.servicios;

import co.edu.uniandes.csw.mobibuses.dto.Mobibus;
import co.edu.uniandes.csw.mobibuses.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioMobibusLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax
        .ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author pa.sarmiento10
 */
@Path("/mobibus")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class MobibusService {
    
  private static final String TOKEN ="token";

     @EJB
    private IServicioMobibusLocal mobibusEjb;
    
    
     @GET
    @Path("mobibuses/")
     
    public List<Mobibus> getTodosLosUsuarios(@Context HttpHeaders headers) {
        String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
                   return mobibusEjb.darMobibuses(token );
 
    }
    
    @GET
    @Path("mobibuses/{coordenada1}/{coordenada2}")
    
    public Mobibus darMobiBusMasCercanoA(@PathParam("coordenada1") double coordenada1,@PathParam("coordenada2")double coordenada2,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        return mobibusEjb.darMobibusMasCercano(coordenada1, coordenada2,token );
        
    }
    
    
   
    
    
    @PUT
    @Path("mobibuses/alquilar/{id}")
    public void alquilarMobibus(@PathParam("id") int id,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        try {
            mobibusEjb.alquilarMobibus(id,token );
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(MobibusService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @PUT
    @Path("mobibuses/liberar/{id}")
    public void liberarMobibus(@PathParam("id") int id,@Context HttpHeaders headers)
    {
        String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        try {
            mobibusEjb.liberarMobibus(id,token );
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(MobibusService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @POST 
    @Path("mobibuses/agregarRuta/{id}/{distancia}/{tiempo}")
    public void agregarRuta(@PathParam("id") int id,@PathParam("distancia") int pDist,@PathParam("tiempo") int pTiempo,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        mobibusEjb.agregarRuta(id, pDist, pTiempo,token ); 
    }
    
    @PUT 
    @Path("mobibuses/eliminarRuta/{id}/{id2}")
    public void eliminarRuta(@PathParam("id") int idMobibus,@PathParam("id2") int idRuta,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        mobibusEjb.eliminarRuta(idMobibus, idRuta,token ); 
    }
    
    @GET
    @Path("mobibuses/reporteRutas/{id}")
    public String generarReporteRutas(@PathParam("id") int id,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        return mobibusEjb.darReporteRutas(id,token );
        
    }
    
      @PUT
    @Path("mobibus/{id}/{longitud}_{latitud}")
      public Mobibus modificarPos(@PathParam("id") int idest,@PathParam("longitud")double longi,@PathParam("latitud") double lati,@Context HttpHeaders headers){
          
           String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }  
         
          return mobibusEjb.cambiarPosicion(idest, longi, lati,token );
          
      }
      
        @PUT
    @Path("mobibus/{id}/{kilo}")
      public Mobibus modificarPos(@PathParam("id") int idest,@PathParam("kilo")double kilo,@Context HttpHeaders headers){
           String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
          return mobibusEjb.cambiarKilo(idest, kilo,token );
      }
      
      
        @GET
    @Path("mobibusesBon/{coordenada1}/{coordenada2}")
    
    public List<Mobibus> darMobiBusMasCercanoBono(@PathParam("coordenada1") double coordenada1,@PathParam("coordenada2")double coordenada2,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        return mobibusEjb.darMobibusMasCercanoBono(coordenada1, coordenada2,token );
        
    }
    
      
      
      
      
      
      
      
}
