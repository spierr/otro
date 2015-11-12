/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.logica.interfaces;

import co.edu.uniandes.csw.mobibuses.dto.Mobibus;
import co.edu.uniandes.csw.mobibuses.excepciones.OperacionInvalidaException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pa.sarmiento10
 * @author sd.sarmiento3156
 */

@Local

public interface IServicioMobibusLocal {
    
    
    /**
     * interface
     * @param token
     * @return 
     */
    
    public List<Mobibus> darMobibuses(String token);
    
    /**
     * intercace
     * @return 
     */
    
     public List<Mobibus> darMobibuses1();
     
     /**
      * interface
      * @param cordenada1
      * @param cordenada2
      * @param token
      * @return 
      */
     
     public Mobibus darMobibusMasCercano(double cordenada1, double cordenada2, String token);
     
     /**
      * interface
      * @param cordenada1
      * @param cordenada2
      * @param token
      * @return 
      */
     
      public List<Mobibus> darMobibusMasCercanoBono(double cordenada1, double cordenada2, String token);
      
      
      /**
       * interface
       * @param id
       * @param token
       * @throws OperacionInvalidaException 
       */
     
      public void alquilarMobibus(int id,String token)  throws OperacionInvalidaException;
      
      
      /**
       * interface
       * @param id
       * @param token
       * @throws OperacionInvalidaException 
       */
      
      public void liberarMobibus(int id,String token) throws OperacionInvalidaException;
      
      /**
       * interface
       * @param idMobibus
       * @param pDist
       * @param ptiempo
       * @param token 
       */
      
      public void agregarRuta(int idMobibus, int pDist, int ptiempo,String token);
      
      /**
       * interface
       * @param idMobibus
       * @param idRuta
       * @param token 
       */
      
      public void eliminarRuta(int idMobibus, int idRuta,String token);
      
      /**
       * interface
       * @param id
       * @param token
       * @return 
       */
      
      public String darReporteRutas(int id,String token);
      
      
      /**
       * interface
       * @param id
       * @param longi
       * @param lat
       * @param token
       * @return 
       */
      
      public Mobibus cambiarPosicion(int id,double longi , double lat,String token);
      
      
      /**
       * interface
       * @param id
       * @param kilo
       * @param token
       * @return 
       */
      
      public Mobibus cambiarKilo(int id,double kilo,String token);
     
}
