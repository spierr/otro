/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.logica.interfaces;

import co.edu.uniandes.csw.mobibuses.dto.Tranvia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fj.ricaurte10
 */

@Local

public interface IServicioTranviaLocal {
    
    
    /**
     * interface
     * @param token
     * @return 
     */
    
    public List<Tranvia> darTranvias(String token);
    
    /**
     * interface
     * @param id
     * @param emergencia
     * @param valor
     * @param token 
     */
    
    public void cambiarEstado(String id, int emergencia , int valor, String token);
    
    /**
     * interface
     * @param token
     * @return 
     */
    
    public String generarReporte(String token);
    
    /**
     * interface
     * @param id
     * @param co1
     * @param co2
     * @param token 
     */
    
    public void cambiarCoord(String id , double co1 , double co2, String token);
    
    /**
     * interface
     * @return 
     */
    
     public List<Tranvia> darTranvias1() ;
    
}
