/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.dto;

import java.util.ArrayList;
import java.util.Date;

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
    
     private static ArrayList<Ruta> rutas;

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

   public void agregarRuta(Ruta pRuta)
   {
       rutas.add(pRuta);
   }
   public void eliminarRuta(Ruta pRuta)
   {
       rutas.remove(pRuta);
   }
    
   public ArrayList<Ruta> getRutas()
   {
       return rutas;
   }
    public String getNombre()
    {
        return nombre;
    }
    
    public double getposicionLatitud()
    {
        return posicionLatitud;
    }
    
    public double getposicionLongitud()
    {
        return posicionLongitud;
    } 
    
    public double getKilometraje()
    {
        return kilometraje;
    }
    
     public long getID()
    {
        return id;
    }
    
    
    public boolean getReservado()
    {
        return reservado;
        
    }

    public String getFechaReservacion()
    {
        return fechaReservacion;
    }

    public void setNombre(String pNombre)
    {
      nombre=pNombre;
    }
    
    public void setPosicionLongitud(double pPos)
    {
       posicionLongitud=pPos;
    }
    
     public void setPosicionLatitud(double pPos)
    {
       posicionLatitud=pPos;
    }
    
    public void setKilometraje(double pKilometrajee)
    {
        kilometraje=pKilometrajee;
    }
    
    public void setReservado(boolean pReservado)
    {
        reservado=pReservado;
        
    }

    public void setFechaReservacion(String pFecha)
    {
     fechaReservacion=pFecha;
    }

    public void setID(int pID)
    {
       id=pID;
    }

}
