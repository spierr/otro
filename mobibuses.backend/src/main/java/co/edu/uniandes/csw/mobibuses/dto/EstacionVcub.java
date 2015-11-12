package co.edu.uniandes.csw.mobibuses.dto;
import java.util.ArrayList;
import java.util.List;

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
    
    /**
     * da el id de la estacion vcub
     * @return el id de la estacion
     */
    
    public long getId() {
        return id;
    }
    
    
    /**
     * cambia el id de la estcion
     * @param id  nuevo id
     */
    
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * da los vcubes de una estacion
     * @return lista de los vcubes de una estacion
     */
    
    public List<Vcub> getVcubsEstacion() {
        return vcubsEstacion;
    }
    
    /**
     * asigna un vcub a una estacion
     * @param vcubsEstacion la lista de vcubes que se quiere agregar a la estacion
     */
    
    public void setVcubsEstacion(List<Vcub> vcubsEstacion) {
        this.vcubsEstacion = vcubsEstacion;
    }
    
    
    /**
     * da la longitud de la estacion
     * @return longitud geografica de la estacion
     */
    
    public double getLongitudEstacion() {
        return longitudEstacion;
    }
    
    
    
    /**
     * modifica la longitud de la estacion
     * @param longitudEstacion longitud geografica nueva de la estacion
     */
    
    public void setLongitudEstacion(double longitudEstacion) {
        this.longitudEstacion = longitudEstacion;
    }
    
    
    /**
     * da la latitud de una estacion
     * @return  la latitud de la estacion
     */
    
    
    public double getLatitudEstacion() {
        return latitudEstacion;
    }
    
    
    
    /**
     * modifica la latitud de la estacion
     * @param latitudEstacion  nueva latitud de la estacion
     */
    
    public void setLatitudEstacion(double latitudEstacion) {
        this.latitudEstacion = latitudEstacion;
    }
    
    
    
    /**
     * da los vcubes prestado de una estaicion
     * @return lista de los vcubes prestados de una estacion
     */
    
    public int getPrestados() {
        return prestados;
    }
    
    
    
    /**
     * modifica la cantidad de vcubes prestados
     * @param prestados nuevo numero de vcubes prestados
     */
    
    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }
    
    }
