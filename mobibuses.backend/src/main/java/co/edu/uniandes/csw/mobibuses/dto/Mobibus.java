/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pa.sarmiento10
 */
public class Mobibus {
    
    private String nombre ;
    
    private long id;
    
    private double posicionLatitud ;
    
    private double posicionLongitud ;
    
    private double kilometraje;
    
    private boolean reservado;
    
    private String fechaReservacion;
    
     private static List<Ruta> rutas;

    public Mobibus(String nombreP1,double posicionLatitudP, double posicionLongitudP,double pKilometraje, String pFecha,long pID)
    {
     nombre=nombreP1;
     
     posicionLatitud=posicionLatitudP;
     
     posicionLongitud=posicionLongitudP;
     
     kilometraje=pKilometraje;
     
     reservado=false;
     
     fechaReservacion=pFecha;
     
     id=pID;
     
     rutas= new ArrayList<Ruta>();
    }

    
    /**
     * agrega una nueva ruta al mobibus
     * @param pRuta ruta nueva
     */
    
   public void agregarRuta(Ruta pRuta)
   {
       rutas.add(pRuta);
   }
   
   
   /**
    * eliminar una ruta al mobibud
    * @param pRuta ruta a eliminar
    */
   
   public void eliminarRuta(Ruta pRuta)
   {
       rutas.remove(pRuta);
   }
    
   
   
   /**
    * da todas las rutas de un mobibud
    * @return lista de rutas del mobibus
    */
   
   public List<Ruta> getRutas()
   {
       return rutas;
   }
   
   
   /**
    * da el nombre de un mobibud
    * @return nombre del mobibus
    */
   
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * da la latitud
     * @return latitud geografica
     */
    
    public double getposicionLatitud()
    {
        return posicionLatitud;
    }
    
    /**
     * da la longitud
     * @return longitud geografica
     */
    
    public double getposicionLongitud()
    {
        return posicionLongitud;
    } 
    
    /**
     * da el kilometraje del mobibus
     * @return kilometraje del mobibus
     */
    
    public double getKilometraje()
    {
        return kilometraje;
    }
    
    
    /**
     * da el id del mobidu
     * @return id del mobibus
     */
    
     public long getID()
    {
        return id;
    }
     
     
     /**
      * reporta si el mobibus esta reservado
      * @return true si el mobibus esta reservado, false de lo contrario
      */
    
    
    public boolean getReservado()
    {
        return reservado;
        
    }

    
    
    /**
     * da la fecha de reservacion de un mobibus
     * @return fecha de reservcion del mobibus
     */
    
    public String getFechaReservacion()
    {
        return fechaReservacion;
    }
    
    
    /**
     * modifica el nombre del mobibus
     * @param pNombre nombre nuevo del mobibus
     */

    public void setNombre(String pNombre)
    {
      nombre=pNombre;
    }
    
    
    /**
     * modifica la longitud del mobibus
     * @param pPos nueva longitud del mobibus
     */
    
    public void setPosicionLongitud(double pPos)
    {
       posicionLongitud=pPos;
    }
    
    
    /**
     * modifica latitud del mobibus
     * @param pPos nueva latitud del mobibus
     */
    
     public void setPosicionLatitud(double pPos)
    {
       posicionLatitud=pPos;
    }
    
     
     
     /**
      * modifica el kilometraje del mobibus
      * @param pKilometrajee nuevo kilometraje del mobibus
      */
     
    public void setKilometraje(double pKilometrajee)
    {
        kilometraje=pKilometrajee;
    }
    
    
    /**
     * cambia el estado de un mobibus a reservado o no
     * @param pReservado el nuevo estado del mobibus
     */
    
    public void setReservado(boolean pReservado)
    {
        reservado=pReservado;
        
    }
    
    
    
    /**
     * modifica la fecha de reservacion d eun mobibus
     * @param pFecha nueva fecha de reservacion
     */

    public void setFechaReservacion(String pFecha)
    {
     fechaReservacion=pFecha;
    }

    /**
     * reasigna id del mobibus
     * @param pID nuevo id del mobibus
     */
    
    public void setID(int pID)
    {
       id=pID;
    }

}
