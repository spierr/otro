/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.logica.ejb;

import co.edu.uniandes.csw.mobibuses.dto.Tranvia;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioTranviaLocal;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.PersistenceManager;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.ServicioPersistenciaMock;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.TransformadorEntityDto;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.TranviaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fj.ricaurte10
 */

@Stateless
@Local
public class ServicioTranvia implements IServicioTranviaLocal, Serializable{

       @PersistenceContext
    private EntityManager em;
  
    public ServicioTranvia()
    {
        em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        if(darTranvias().size()==0)
          TransformadorEntityDto.getInstance().crearTranvias(em);
  
    }
    
    
    
    @Override
    
    
    public List<Tranvia> darTranvias() 
    {
    Query q = em.createQuery("SELECT u FROM TranviaEntity u");
     List<TranviaEntity> l = q.getResultList();
     ArrayList<Tranvia> ltr = new ArrayList();
     for(TranviaEntity te: l)
     {
         ltr.add(TransformadorEntityDto.getInstance().EntityADtoTranvia(te));
     }
     return ltr;
    
    }

    @Override
    public void cambiarEstado(String id, int emergencia, int valor) {
       
   TranviaEntity tranvia =em.find(TranviaEntity.class, id);
         
         //modifico el nivel de choque
        if(emergencia==1)
        {
            tranvia.setNivelChoque(valor);
            
        }
        
        //modifico el nivel de temperatura
        if(emergencia==2)
        {
            tranvia.setNivelTemperatura(valor);
        }
        
        // el boton de panico
        if(emergencia==3 || emergencia==0){
            
            tranvia.setNivelPanico(valor);
            
        }
        em.persist(tranvia);
    }

    @Override
    public String generarReporte() {
    
    String rta="";
    
    List<Tranvia> lista =darTranvias();
    
    Tranvia conductorMasEFectivoA=null;
    Tranvia conductorMenosEFectivoA=null;
    double tiempoMenosEfectivoA=0;
    double tiempoMasEfectivoA=10000;
    
    
    Tranvia conductorMasEFectivoB=null;
    Tranvia conductorMenosEFectivoB=null;
    double tiempoMenosEfectivoB=0;
    double tiempoMasEfectivoB=10000;
    
    
        
    Tranvia conductorMasEFectivoC=null;
    Tranvia conductorMenosEFectivoC=null;
    double tiempoMenosEfectivoC=0;
    double tiempoMasEfectivoC=10000;
    
    int problemaTipoA=0;
    int problemaTipoB=0;
    int problemaTipoC=0;
    
    int problemasTemperatura=0 ;
    int problemasPanico=0;
    int problemasChoque=0;
    
    
    System.out.println("intenta el metodo");
    
    for(Tranvia tra:lista)
    {
         System.out.println("entra el for");
        
        rta+="El tiempo promedio del tranvia " + tra.getNombre()+ " es " + tra.getTimepoPromedio() +"<p>";
        
        //ruta A
        
        System.out.println("el nombre de la linea es "+ tra.getLinea());
        
        if(tra.getLinea().equals("A") && tra.getTimepoPromedio()<tiempoMasEfectivoA)
        {
            System.out.println("entro a A");
            tiempoMasEfectivoA=tra.getTimepoPromedio();
            conductorMasEFectivoA=tra;
            
        }
        if(tra.getLinea().equals("A") &&tra.getTimepoPromedio()>tiempoMenosEfectivoA)
        {
            tiempoMenosEfectivoA=tra.getTimepoPromedio();
            conductorMenosEFectivoA=tra;
        }
        
        
        //ruta B
        
         if(tra.getLinea().equals("B") && tra.getTimepoPromedio()<tiempoMasEfectivoB)
        {
            tiempoMasEfectivoB=tra.getTimepoPromedio();
            conductorMasEFectivoB=tra;
        }
        if(tra.getLinea().equals("B") &&tra.getTimepoPromedio()>tiempoMenosEfectivoB)
        {
            tiempoMenosEfectivoB=tra.getTimepoPromedio();
            conductorMenosEFectivoB=tra;
        }
        
         //ruta C
        
         if(tra.getLinea().equals("C") && tra.getTimepoPromedio()<tiempoMasEfectivoC)
        {
            tiempoMasEfectivoC=tra.getTimepoPromedio();
            conductorMasEFectivoC=tra;
        }
        if(tra.getLinea().equals("C") &&tra.getTimepoPromedio()>tiempoMenosEfectivoC)
        {
            tiempoMenosEfectivoC=tra.getTimepoPromedio();
            conductorMenosEFectivoC=tra;
        }
        
        if(tra.getLinea().equals("A"))
        {
            if(tra.getNivelChoque()>50){
                problemaTipoA++;
                problemasChoque++;
            }
            if(tra.getNivelPanico()>50){
                 problemaTipoA++;
                 problemasPanico++;
                 
            }
            if(tra.getNivelTemparatura()>50){
                 problemaTipoA++;
                 problemasTemperatura++;
            }
        }
        
        if(tra.getLinea().equals("B"))
        {
            if(tra.getNivelChoque()>50){
                problemaTipoB++;
                 problemasChoque++;
            }
            if(tra.getNivelPanico()>50){
                 problemaTipoB++;
                  problemasPanico++;
            }
            if(tra.getNivelTemparatura()>50){
                 problemaTipoB++;
                    problemasTemperatura++;
            }
        }
        
        if(tra.getLinea().equals("C"))
        {
            if(tra.getNivelChoque()>50){
                problemaTipoC++;
                 problemasChoque++;
            }
            if(tra.getNivelPanico()>50){
                 problemaTipoC++;
                  problemasPanico++;
            }
            if(tra.getNivelTemparatura()>50){
                 problemaTipoC++;
                    problemasTemperatura++;
            }
        }
        
        
    }
    rta+="El conductor mas efectivo es "+ conductorMasEFectivoA.getNombre() +" con el tranvia" + conductorMasEFectivoA.getNombre()+ " con un tiempo de " + conductorMasEFectivoA.getTimepoPromedio()+"<p>";
    
    rta+="El conductor menos efectivo es "+ conductorMenosEFectivoA.getNombre() +" con el tranvia" + conductorMenosEFectivoA.getNombre()+ " con un tiempo de " + conductorMenosEFectivoA.getTimepoPromedio()+"<p>";
    
    rta+="El conductor mas efectivo es "+ conductorMasEFectivoB.getNombre() +" con el tranvia" + conductorMasEFectivoB.getNombre()+ " con un tiempo de " + conductorMasEFectivoB.getTimepoPromedio()+"<p>";
    
    rta+="El conductor menos efectivo es "+ conductorMenosEFectivoB.getNombre() +" con el tranvia" + conductorMenosEFectivoB.getNombre()+ " con un tiempo de " + conductorMenosEFectivoB.getTimepoPromedio()+"<p>";
   
    
    rta+="El conductor mas efectivo es "+ conductorMasEFectivoC.getNombre() +" con el tranvia" + conductorMasEFectivoC.getNombre()+ " con un tiempo de " + conductorMasEFectivoC.getTimepoPromedio()+"<p>";
    
    rta+="El conductor menos efectivo es "+ conductorMenosEFectivoC.getNombre() +" con el tranvia" + conductorMenosEFectivoC.getNombre()+ " con un tiempo de " + conductorMenosEFectivoC.getTimepoPromedio()+"<p>";
   
    
   int maso =  Math.max(problemaTipoA, problemaTipoB);
   
   int mayorProblema = Math.max(maso, problemaTipoC);
   
   rta+="El trayecto A presenta "+ problemaTipoA +" problemas <p>" ;
   
    rta+="El trayecto A presenta "+ problemaTipoB +" problemas <p>" ;
    
     rta+="El trayecto A presenta "+ problemaTipoC +" problemas <p>" ;
     
      rta+="El trayecto que mas presenta problemas tiene "+ mayorProblema +" problemas <p>" ;
   
     int masoEmer =  Math.max(problemasChoque, problemasPanico);
   
   int mayorProblemaEmer = Math.max(masoEmer, problemasTemperatura);
      
   rta+="Ha habido  "+ problemasTemperatura +" emergencias por temperatura <p>" ;
   
    rta+="Ha habido  "+ problemasChoque +" emergencias por choque <p>" ;
    
     rta+="Ha habido  "+ problemasPanico +" emergencias por panico <p>" ;
     
     rta+="La emergencia mas concurrida ha sucedido "+mayorProblemaEmer + " veces" ;
     
     
     System.out.println(rta);
   
   
   
    return rta ;
    
    }

    @Override
    public void cambiarCoord(String id, double co1, double co2) {
       
        
          TranviaEntity tranvia =em.find(TranviaEntity.class, id);
         tranvia.setPosicionLatitud(co1);
           tranvia.setPosicionLongitud(co2);
        em.persist(tranvia);
        
        
    }

   
    
    
    
    
    
}
