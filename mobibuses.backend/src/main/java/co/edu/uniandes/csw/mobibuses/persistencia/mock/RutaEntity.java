/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.persistencia.mock;

import java.io.Serializable;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author cf.brochero10
 */
@Entity
public class RutaEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int distancia;
    
    private int tiempo;

    public void setId(Long id) {
        this.id = id;
    }
    
     @ManyToOne(cascade=ALL)
    private MobiBusEntity mobibus;

    public MobiBusEntity getMobibus() {
        return mobibus;
    }

    public void setMobibus(MobiBusEntity mobibus) {
        this.mobibus = mobibus;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiemp) {
        this.tiempo = tiemp;
    }

    public long getId() {
        return id;
    }

   @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

   @Override
    public boolean equals(Object object) {
        if (!(object instanceof RutaEntity)) {
            return false;
        }
        RutaEntity other = (RutaEntity) object;
        if (this.id==other.id) {
            return false;
        }
        return true;
    }

       @Override
    public String toString() {
        return "co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.RutaEntity[ id=" + id + " ]";
    }
    
}
