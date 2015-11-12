/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.persistencia.mock;

/**
 *
 * @author cf.brochero10
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    private static final PersistenceManager singleton = new PersistenceManager();
    protected EntityManagerFactory emf;
 
    private PersistenceManager() {
        
    }
 
    
    public static PersistenceManager getInstance() {
 
        return singleton;
    }
 
 
    
    public EntityManagerFactory getEntityManagerFactory() {
 
        if (emf == null) {
            createEntityManagerFactory();
        }
        return emf;
    }
 
    public void closeEntityManagerFactory() {
 
        if (emf != null) {
            emf.close();
            emf = null;
            
        }
    }
 
    protected void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("pw", System.getProperties());
       
    }
}
