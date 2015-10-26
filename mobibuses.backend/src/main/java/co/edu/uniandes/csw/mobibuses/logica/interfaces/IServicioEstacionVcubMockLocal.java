/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.logica.interfaces;

import co.edu.uniandes.csw.mobibuses.dto.EstacionVcub;
import co.edu.uniandes.csw.mobibuses.dto.Vcub;
import co.edu.uniandes.csw.mobibuses.excepciones.OperacionInvalidaException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author s.correa12
 */
@Local
public interface IServicioEstacionVcubMockLocal 
{
    public List<EstacionVcub> darEstacionesVcub();
    
    public List<Vcub> darVcubesEstacion(int IDestacion);
    
    public List<Vcub> darTodosVcub();
    
    public Vcub alquilarVcub(int IDestacion)throws OperacionInvalidaException;
    
    public Vcub liberarVcub(int IDestacion,int IDdevolver) throws OperacionInvalidaException;
    
    public void reducirVcubesTodas();
    
    public void reducirVcubesEspecifica(int IDestacion);
    
    public List<Vcub> darVcubesDisponiblesEstacion(int IDestacion);
    
    public List<Vcub> darVcubesOcupadosEstacion(int IDestacion);
    
    public List<Vcub> darVcubesNoDisponiblesEstacion(int IDestacion);
    
    public Vcub modificarPosVcub(int idVcub, double longitud, double latitud);
}