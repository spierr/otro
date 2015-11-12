/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.dto;

/**
 *
 * @author s.correa12
 */
public class Vcub {
    
    public static final  String OCUPADO = "OCUPADO";
    public  static final  String DISPONIBLE = "DISPONIBLE";
    public static final String NO_DISPONIBLE = "NO DISPONIBLE";
    
    private long id;
    
    
    private String ocupado;
    
    private long estacion;
    
    private double longitud;
    
    private double latitud;

    public Vcub(long id,long pEstacion) {
        this.id = id;
        ocupado=Vcub.DISPONIBLE;
        estacion = pEstacion;
        longitud = 0;
        latitud =0;
    }

    /**
     * da el id del vcub
     * @return  id del vcub
     */
    
    public long getId() {
        return id;
    }
    
    /**
     * informa estado del vcub
     * @return si esta disponible, no disponible o ocupado
     */

    public String isOcupado() {
        if(ocupado.equalsIgnoreCase(Vcub.DISPONIBLE))
        {
            return Vcub.DISPONIBLE;
        }
        else if(ocupado.equalsIgnoreCase(Vcub.NO_DISPONIBLE))
        {
            return Vcub.NO_DISPONIBLE;
        }
        else
        {
            return Vcub.OCUPADO;
        }
    }

    
    
    /**
     * define id del vcub
     * @param nueva id del vcub
     */
    
    public void setId(int id) {
        this.id = id;
    }
    
    
    /**
     * define si esta ocupado el vcub
     * @param ocupado estado del vcub(ocupado,disponible)
     */

    public void setOcupado(String ocupado) {
        this.ocupado = ocupado;
    }

    
    
    /**
     * da la estacion del vcub
     * @return estacion del vcub
     */
    
    public long getEstacion() {
        return estacion;
    }
    
    
    /**
     * define estacion del vcub
     * @param estacion nueva estacion del vcub
     */

    public void setEstacion(long estacion) {
        this.estacion = estacion;
    }
    
    /**
     * da la longitud del vcub
     * @return longitud geografic
     */

    public double getLongitud() {
        return longitud;
    }
    
    /**
     * define longitud geografica
     * @param longitud geografica
     */

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    
    
    /**
     * da la latidud del vcub
     * @return latitud  geografica
     */

    public double getLatitud() {
        return latitud;
    }
    
    
    /**
     * define la latitud del vcub
     * @param latitud geografica
     */

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    
    
}
