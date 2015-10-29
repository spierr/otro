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
    public List<EstacionVcub> darEstacionesVcub( String token);
    
    
    public List<Vcub> darVcubesEstacion(int IDestacion, String token);
    
    public List<Vcub> darTodosVcub(String token);
    
    public List<Vcub> darTodosVcub1();
    
    public Vcub alquilarVcub(int IDestacion, String token)throws OperacionInvalidaException;
    
    public Vcub liberarVcub(int IDestacion,int IDdevolver, String token) throws OperacionInvalidaException;
    
    public void reducirVcubesTodas( String token);
    
    public void reducirVcubesEspecifica(int IDestacion, String token);
    
    public List<Vcub> darVcubesDisponiblesEstacion(int IDestacion, String token);
    
    public List<Vcub> darVcubesOcupadosEstacion(int IDestacion, String token);
    
    public List<Vcub> darVcubesNoDisponiblesEstacion(int IDestacion, String token);
    
    public Vcub modificarPosVcub(int idVcub, double longitud, double latitud, String token);
}