/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.persistencia.mock;

import co.edu.uniandes.csw.mobibuses.dto.Vcub;
import java.io.Serializable;
import java.util.ArrayList;
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
public class EstacionVcubEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private double longitudEstacion;
    
    private double latitudEstacion;
    
    private int prestados;
    
    @OneToMany(cascade=ALL, mappedBy="estacionVcub")
    private Set<VcubEntity> vCubs;


    public Long getId() {
        return id;
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

    public Set<VcubEntity> getvCubs() {
        return vCubs;
    }

    public void setvCubs(Set<VcubEntity> vCubs) {
        this.vCubs = vCubs;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstacionVcubEntity)) {
            return false;
        }
        EstacionVcubEntity other = (EstacionVcubEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniandes.csw.mobibuses.persistencia.mock.EstacionVcub[ id=" + id + " ]";
    }
    
}
