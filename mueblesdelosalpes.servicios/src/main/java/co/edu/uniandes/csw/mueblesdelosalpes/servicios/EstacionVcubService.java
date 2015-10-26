/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.EstacionVcub;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vcub;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioEstacionVcubMockLocal;
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
    @EJB
    private IServicioEstacionVcubMockLocal estacionesEjb;
    
    @GET
    @Path("estaciones/")
    public List<EstacionVcub> darEstaciones()
    {
        return estacionesEjb.darEstacionesVcub();
    }
     @GET
    @Path("vcubes/")
    public List<Vcub> darVcubes()
    {
        return estacionesEjb.darTodosVcub();
    }
    
    @PUT
    @Path("estacion/{id}/alquilar")
    public Vcub alquilarVcub(@PathParam("id") int id)
    {
        try {
           return estacionesEjb.alquilarVcub(id);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(EstacionVcubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @PUT
    @Path("estacion/{id}/liberar/{idvcub}")
    public Vcub liberarVcub(@PathParam("id") int id, @PathParam("idvcub") int idvcub)
    {
        try {
          return  estacionesEjb.liberarVcub(id, idvcub);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(EstacionVcubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     @GET
    @Path("vcubes/{id}")
    public List<Vcub> darVcubesEstacion(@PathParam("id") int idest)
    {
        return estacionesEjb.darVcubesEstacion(idest);
    }
    
    @PUT
    @Path("estacion/{id}/reducir")
    public void reducirCapacidadEstacionEspecifica(@PathParam("id") int idest)
    {
        estacionesEjb.reducirVcubesEspecifica(idest);
    }
    
    @PUT
    @Path("estacion/reducir")
    public void reducirCapacidadEstaciones()
    {
        estacionesEjb.reducirVcubesTodas();
    }
     @GET
    @Path("vcubes/disponibles/{id}")
    public List<Vcub> darVcubesDisponiblesEstacion(@PathParam("id") int idest)
    {
        return estacionesEjb.darVcubesDisponiblesEstacion(idest);
    }
    @GET
    @Path("vcubes/ocupados/{id}")
    public List<Vcub> darVcubesOcupadosEstacion(@PathParam("id") int idest)
    {
        return estacionesEjb.darVcubesOcupadosEstacion(idest);
    }
    @GET
    @Path("vcubes/nodisponibles/{id}")
    public List<Vcub> darVcubesNoDisponiblesEstacion(@PathParam("id") int idest)
    {
        return estacionesEjb.darVcubesNoDisponiblesEstacion(idest);
    }
    
     @PUT
    @Path("vcub/{id}/{longitud}_{latitud}")
    public Vcub cambiarPosVcub(@PathParam("id") int idest,@PathParam("longitud")double longi,@PathParam("latitud") double lati)
    {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                int g= i+j;
        } 
        }
        return estacionesEjb.modificarPosVcub(idest, longi, lati);
    }
}
