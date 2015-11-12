/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.persistencia.mock;

import java.io.Serializable;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author cf.brochero10
 */
@Entity
public class MobiBusEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre ;
    
    private double posicionLatitud ;
    
    private double posicionLongitud ;
    
    private double kilometraje;
    
    private boolean reservado;
    
    private String fechaReservacion;
    
    @OneToMany(cascade=ALL, mappedBy="mobibus")
    private Set<RutaEntity> rutas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }
    

    public Long getId() {
        return id;
    }

  
    public void setId(Long id) {
        this.id = id;
    }

    public Set<RutaEntity> getRutas() {
        return rutas;
    }

    public void setRutas(RutaEntity rutas) {
        this.rutas.add(rutas);
    }

    
  

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MobiBusEntity)) {
            return false;
        }
        MobiBusEntity other = (MobiBusEntity) object;
        if (this.id==other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniandes.csw.mobibuses.persistencia.mock.MobiBusEntity[ id=" + id + " ]";
    }
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
}
