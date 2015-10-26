/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.dto;

/**
 *
 * @author pa.sarmiento10
 * @author sd.sarmiento3156
 */
public class Ruta {
    
    private long id;
    
    private int distancia;
    
    private int tiempò;
    
    
    public Ruta(int pDistancia, int pTiempo, long pId)
    {
        distancia=pDistancia;
        
        tiempò=pTiempo;
        id=pId;
    }
    
    public int getDistancia()
    {
        return distancia;
    }
    
    public int getTiempo()
    {
        return tiempò;
    }
    
    public long getID()
    {
        return id;
    }
}
