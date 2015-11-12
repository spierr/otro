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
    
    public List<Mobibus> darMobibuses(String token);
    
     public List<Mobibus> darMobibuses1();
     
     public Mobibus darMobibusMasCercano(double cordenada1, double cordenada2, String token);
     
      public List<Mobibus> darMobibusMasCercanoBono(double cordenada1, double cordenada2, String token);
     
      public void alquilarMobibus(int id,String token)  throws OperacionInvalidaException;
      
      public void liberarMobibus(int id,String token) throws OperacionInvalidaException;
      
      public void agregarRuta(int idMobibus, int pDist, int ptiempo,String token);
      
      public void eliminarRuta(int idMobibus, int idRuta,String token);
      
      public String darReporteRutas(int id,String token);
      
      public Mobibus cambiarPosicion(int id,double longi , double lat,String token);
      
      public Mobibus cambiarKilo(int id,double kilo,String token);
     
}
