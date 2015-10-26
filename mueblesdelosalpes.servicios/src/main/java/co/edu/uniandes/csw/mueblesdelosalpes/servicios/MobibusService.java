/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mobibus;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Ruta;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Tranvia;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioMobibusLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioTranviaLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    
     @EJB
    private IServicioMobibusLocal mobibusEjb;
    
    
     @GET
    @Path("mobibuses/")
     
    public List<Mobibus> getTodosLosUsuarios() {
        
      
       return mobibusEjb.darMobibuses();
 
    }
    
    @GET
    @Path("mobibuses/{coordenada1}/{coordenada2}")
    
    public Mobibus darMobiBusMasCercanoA(@PathParam("coordenada1") double coordenada1,@PathParam("coordenada2")double coordenada2)
    {
        
        return mobibusEjb.darMobibusMasCercano(coordenada1, coordenada2);
        
    }
    
    @PUT
    @Path("mobibuses/alquilar/{id}")
    public void alquilarMobibus(@PathParam("id") int id)
    {
        try {
            mobibusEjb.alquilarMobibus(id);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(MobibusService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @PUT
    @Path("mobibuses/liberar/{id}")
    public void liberarMobibus(@PathParam("id") int id)
    {
        try {
            mobibusEjb.liberarMobibus(id);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(MobibusService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @POST 
    @Path("mobibuses/agregarRuta/{id}/{distancia}/{tiempo}")
    public void agregarRuta(@PathParam("id") int id,@PathParam("distancia") int pDist,@PathParam("tiempo") int pTiempo)
    {
        mobibusEjb.agregarRuta(id, pDist, pTiempo); 
    }
    
    @PUT 
    @Path("mobibuses/eliminarRuta/{id}/{id2}")
    public void eliminarRuta(@PathParam("id") int idMobibus,@PathParam("id2") int idRuta)
    {
        mobibusEjb.eliminarRuta(idMobibus, idRuta); 
    }
    
    @GET
    @Path("mobibuses/reporteRutas/{id}")
    public String generarReporteRutas(@PathParam("id") int id)
    {
        
        return mobibusEjb.darReporteRutas(id);
        
    }
    
      @PUT
    @Path("mobibus/{id}/{longitud}_{latitud}")
      public Mobibus modificarPos(@PathParam("id") int idest,@PathParam("longitud")double longi,@PathParam("latitud") double lati){
          
            
         for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                System.out.println(i+j);
        } 
        }
          return mobibusEjb.cambiarPosicion(idest, longi, lati);
          
      }
      
        @PUT
    @Path("mobibus/{id}/{kilo}")
      public Mobibus modificarPos(@PathParam("id") int idest,@PathParam("kilo")double kilo){
          return mobibusEjb.cambiarKilo(idest, kilo);
      }
}
