/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.persistencia.mock;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author cf.brochero10
 */
@Entity
public class TranviaEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre ;
    
    private String linea ;
    
    private double posicionLatitud ;
    
    private double posicionLongitud ;
    
    private int nivelChoque;
    
    private int nivelTemperatura;
    
    private int nivelPanico ;
    
    private double kilometraje;
    
    private String nombreConductor;
    
    private double tiempoTrayecto ;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public double getPosicionLatitud() {
        return posicionLatitud;
    }

    public void setPosicionLatitud(double posicionLatitud) {
        this.posicionLatitud = posicionLatitud;
    }

    public double getPosicionLongitud() {
        return posicionLongitud;
    }

    public void setPosicionLongitud(double posicionLongitud) {
        this.posicionLongitud = posicionLongitud;
    }

    public int getNivelChoque() {
        return nivelChoque;
    }

    public void setNivelChoque(int nivelChoque) {
        this.nivelChoque = nivelChoque;
    }

    public int getNivelTemperatura() {
        return nivelTemperatura;
    }

    public void setNivelTemperatura(int nivelTemperatura) {
        this.nivelTemperatura = nivelTemperatura;
    }

    public int getNivelPanico() {
        return nivelPanico;
    }

    public void setNivelPanico(int nivelPanico) {
        this.nivelPanico = nivelPanico;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    public double getTiempoTrayecto() {
        return tiempoTrayecto;
    }

    public void setTiempoTrayecto(double tiempoTrayecto) {
        this.tiempoTrayecto = tiempoTrayecto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TranviaEntity)) {
            return false;
        }
        TranviaEntity other = (TranviaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.TranviaEntity[ id=" + id + " ]";
    }
    
}
