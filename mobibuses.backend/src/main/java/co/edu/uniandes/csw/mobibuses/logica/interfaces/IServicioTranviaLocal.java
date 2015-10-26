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
    
    public List<Tranvia> darTranvias();
    
    public void cambiarEstado(String id, int emergencia , int valor);
    
    public String generarReporte();
    
    public void cambiarCoord(String id , double co1 , double co2);
    
}
