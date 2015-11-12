/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.servicios;

import co.edu.uniandes.csw.mobibuses.dto.EstacionVcub;
import co.edu.uniandes.csw.mobibuses.dto.Vcub;
import co.edu.uniandes.csw.mobibuses.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioEstacionVcubMockLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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
 * @author s.correa12
 */
@Path("/Estacion")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstacionVcubService 
{
    
    private static final String TOKEN ="token";

    @EJB
    private IServicioEstacionVcubMockLocal estacionesEjb;
    
    @GET
    @Path("estaciones/")
    public List<EstacionVcub> darEstaciones(@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        return estacionesEjb.darEstacionesVcub(token);
    }
     @GET
    @Path("vcubes/")
    public List<Vcub> darVcubes(@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        return estacionesEjb.darTodosVcub(token);
    }
    
    @PUT
    @Path("estacion/{id}/alquilar")
    public Vcub alquilarVcub(@PathParam("id") int id,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        try {
           return estacionesEjb.alquilarVcub(id,token);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(EstacionVcubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @PUT
    @Path("estacion/{id}/liberar/{idvcub}")
    public Vcub liberarVcub(@PathParam("id") int id, @PathParam("idvcub") int idvcub,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        try {
          return  estacionesEjb.liberarVcub(id, idvcub,token);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(EstacionVcubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     @GET
    @Path("vcubes/{id}")
    public List<Vcub> darVcubesEstacion(@PathParam("id") int idest,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        return estacionesEjb.darVcubesEstacion(idest,token);
    }
    
    @PUT
    @Path("estacion/{id}/reducir")
    public void reducirCapacidadEstacionEspecifica(@PathParam("id") int idest,@Context HttpHeaders headers)
    {
        String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        estacionesEjb.reducirVcubesEspecifica(idest,token);
    }
    
    @PUT
    @Path("estacion/reducir")
    public void reducirCapacidadEstaciones(@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        estacionesEjb.reducirVcubesTodas(token);
    }
     @GET
    @Path("vcubes/disponibles/{id}")
    public List<Vcub> darVcubesDisponiblesEstacion(@PathParam("id") int idest,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        return estacionesEjb.darVcubesDisponiblesEstacion(idest,token);
    }
    @GET
    @Path("vcubes/ocupados/{id}")
    public List<Vcub> darVcubesOcupadosEstacion(@PathParam("id") int idest,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        return estacionesEjb.darVcubesOcupadosEstacion(idest,token);
    }
    @GET
    @Path("vcubes/nodisponibles/{id}")
    public List<Vcub> darVcubesNoDisponiblesEstacion(@PathParam("id") int idest,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
        return estacionesEjb.darVcubesNoDisponiblesEstacion(idest,token);
    }
    
     @PUT
    @Path("vcub/{id}/{longitud}_{latitud}")
    public Vcub cambiarPosVcub(@PathParam("id") int idest,@PathParam("longitud")double longi,@PathParam("latitud") double lati,@Context HttpHeaders headers)
    {
         String token = "";
         try {
             token = headers.getRequestHeader(TOKEN ).get(0);
         } catch (Exception e) {
         }
       
        return estacionesEjb.modificarPosVcub(idest, longi, lati,token);
    }
}
