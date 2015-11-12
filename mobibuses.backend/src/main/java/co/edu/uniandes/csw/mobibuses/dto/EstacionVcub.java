package co.edu.uniandes.csw.mobibuses.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s.correa12
 */
public class EstacionVcub {
    
    private long id;
    
    private List<Vcub> vcubsEstacion;
    
    private double longitudEstacion;
    
    private double latitudEstacion;
    
    private int prestados;

    public EstacionVcub(long id, double longitudEstacion, double latitudEstacion) {
        this.id = id;
        this.longitudEstacion = longitudEstacion;
        this.latitudEstacion = latitudEstacion;
        vcubsEstacion = new ArrayList<Vcub>(); 
        prestados = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Vcub> getVcubsEstacion() {
        return vcubsEstacion;
    }

    public void setVcubsEstacion(List<Vcub> vcubsEstacion) {
        this.vcubsEstacion = vcubsEstacion;
    }

    public double getLongitudEstacion() {
        return longitudEstacion;
    }

    public void setLongitudEstacion(double longitudEstacion) {
        this.longitudEstacion = longitudEstacion;
    }

    public double getLatitudEstacion() {
        return latitudEstacion;
    }

    public void setLatitudEstacion(double latitudEstacion) {
        this.latitudEstacion = latitudEstacion;
    }

    public int getPrestados() {
        return prestados;
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }
 
    
}
