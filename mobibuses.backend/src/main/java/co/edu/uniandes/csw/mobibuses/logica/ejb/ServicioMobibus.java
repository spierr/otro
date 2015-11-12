/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.logica.ejb;

import co.edu.uniandes.csw.mobibuses.dto.Mobibus;
import co.edu.uniandes.csw.mobibuses.dto.Ruta;
import co.edu.uniandes.csw.mobibuses.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioMobibusLocal;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.MobiBusEntity;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.PersistenceManager;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.RutaEntity;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.TransformadorEntityDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pa.sarmiento10
 * @author sd.sarmiento3156
 */
@Stateless
@Local
public class ServicioMobibus implements IServicioMobibusLocal, Serializable{
    
       @PersistenceContext
    private EntityManager em;

    public ServicioMobibus()
    {
        em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
      if(darMobibuses1().isEmpty())
          TransformadorEntityDto.getInstance().crearMobibibuses(em);
  
    }
    
    @Override
    public List<Mobibus> darMobibuses(String token) {
        Query qu = em.createQuery("SELECT u FROM UserEntity u WHERE u.token ='"+token+"'");
     if(qu.getResultList().isEmpty())
     {
         List<Mobibus> dtos = new ArrayList();
         return dtos;
     }
     else
     {
            Query q = em.createQuery("SELECT u from MobiBusEntity u");
            List<MobiBusEntity> tranvias = q.getResultList();
            List<Mobibus> dtos = new ArrayList();
            for (MobiBusEntity tranvia : tranvias) {
                dtos.add(TransformadorEntityDto.getInstance().EntityADtoMobibus(tranvia));
            }
            return dtos;
     }
    }
    
    
    
    
    @Override
    public Mobibus darMobibusMasCercano(double cordenada1, double cordenada2,String token) {
    
        Query qu = em.createQuery("SELECT u FROM UserEntity u WHERE u.token ='"+token+"'");
     if(qu.getResultList().isEmpty())
     {
         return null;
     }
     else
     {
        List<Mobibus> lista = darMobibuses1();
        
        Mobibus rta=null;
        
        double menorDistanciaEncontrada =10000000;
        
        for(Mobibus m:lista)
        {
           double latitud= m.getposicionLatitud();
           double longitud=m.getposicionLongitud();
           
           double distancia= Math.sqrt((cordenada1-latitud)*(cordenada1-latitud)+(cordenada2-longitud)*(cordenada2-longitud));
           
           if(distancia<menorDistanciaEncontrada)
           {
               menorDistanciaEncontrada=distancia;
               rta=m;
           }
            
            
        }
                
        return rta;
     }
    }

    @Override
    public void alquilarMobibus(int id,String token) throws OperacionInvalidaException {
//        Mobibus mb =(Mobibus) persistencia.findById(Mobibus.class, id);
//        if(mb.getReservado()==false)
//        {
//            mb.setReservado(true);
//        }
//        else
//        {
//            throw new OperacionInvalidaException("El Mobibus con id "+id+ " se encuentra reservado.");
//        }
    }

    @Override
    public void liberarMobibus(int id,String token) throws OperacionInvalidaException {
//         Mobibus mb =(Mobibus) persistencia.findById(Mobibus.class, id);
//        if(mb.getReservado()==true)
//        {
//            mb.setReservado(false);
//        }
//        else
//        {
//            throw new OperacionInvalidaException("El Mobibus con id "+id+ " se encuentra desocupado.");
//        }
    }

    
    @Override
    public void agregarRuta(int  pId, int pDist, int pTiempo,String token ) {
//   Mobibus mb =(Mobibus) persistencia.findById(Mobibus.class, pId);
//   int g=mb.getRutas().size();
//   Ruta ruta = new Ruta(pDist, pTiempo,g+1);
//        mb.agregarRuta(ruta);
    }
    

    @Override
    public String darReporteRutas(int pId,String token) {
       // Mobibus mb =(Mobibus) persistencia.findById(Mobibus.class, pId);
        Query qu = em.createQuery("SELECT u FROM UserEntity u WHERE u.token ='"+token+"'");
     if(qu.getResultList().isEmpty())
     {
         return null;
     }
     else
     {
        Mobibus mb =null;
        String x="";
        List<Ruta> rutas= mb.getRutas();
       for (int i = 0; i < rutas.size(); i++) {
            Ruta a=rutas.get(i);
           
            x+= "La ruta " + a.getID()+" tuvo una distancia de "+a.getDistancia()+ 
                    " y un tiempo de " + a.getTiempo()+"<p>";
            
        }
        return x;
     }
    }

    @Override
    public void eliminarRuta(int idMobibus, int idRuta,String token) {
        Query qu = em.createQuery("SELECT u FROM UserEntity u WHERE u.token ='"+token+"'");
     if(qu.getResultList().isEmpty()==false)
     {
        RutaEntity r = em.find(RutaEntity.class, idRuta);
        em.remove(r);
     }
       
    }

    @Override
    public Mobibus cambiarPosicion(int id, double longi, double lat,String token) {
        Query qu = em.createQuery("SELECT u FROM UserEntity u WHERE u.token ='"+token+"'");
     if(qu.getResultList().isEmpty())
     {
         return null;
     }
     else
     {
        MobiBusEntity mb = em.find(MobiBusEntity.class, id);
        mb.setPosicionLatitud(lat);
        mb.setPosicionLongitud(longi);
        em.persist(mb);
        return TransformadorEntityDto.getInstance().EntityADtoMobibus(mb);
     }
    }

    @Override
    public Mobibus cambiarKilo(int id, double kilo,String token) {
        Query qu = em.createQuery("SELECT u FROM UserEntity u WHERE u.rol='admin' and  u.token ='"+token+"'");
     if(qu.getResultList().isEmpty())
     {
         return null;
     }
     else
     {
        MobiBusEntity mb = em.find(MobiBusEntity.class, id);
        mb.setKilometraje(kilo);
        em.persist(mb);
        return TransformadorEntityDto.getInstance().EntityADtoMobibus(mb);
     }
    }

    @Override
    public List<Mobibus> darMobibusMasCercanoBono(double cordenada1, double cordenada2, String token) {
       
        Query qu = em.createQuery("SELECT u FROM UserEntity u WHERE u.rol='admin' and u.token ='"+token+"'");
     if(qu.getResultList().isEmpty())
     {
         return new ArrayList();
     }
     else
     {
        List<Mobibus> dtos = new ArrayList();
        
         List<Mobibus> lista = darMobibuses1();
        
        Mobibus rta=null;
        
           Mobibus rta2=null;
           
              Mobibus rta3=null;
        
        double menorDistanciaEncontrada =10000000;
         double menorDistanciaEncontrada2 =10000000;
          double menorDistanciaEncontrada3 =10000000;
        
        
        
        for(Mobibus m:lista)
        {
           double latitud= m.getposicionLatitud();
           double longitud=m.getposicionLongitud();
           
           double distancia= Math.sqrt((cordenada1-latitud)*(cordenada1-latitud)+(cordenada2-longitud)*(cordenada2-longitud));
           
           if(distancia<menorDistanciaEncontrada ||distancia<menorDistanciaEncontrada2 || distancia<menorDistanciaEncontrada3)
           {
           
               if(menorDistanciaEncontrada>= menorDistanciaEncontrada2 && menorDistanciaEncontrada>= menorDistanciaEncontrada3)
               {
               menorDistanciaEncontrada=distancia;
               rta=m;
               }
               
               else if(menorDistanciaEncontrada2>= menorDistanciaEncontrada && menorDistanciaEncontrada2>= menorDistanciaEncontrada3)
               {
               menorDistanciaEncontrada2=distancia;
               rta2=m;
               }
               
               else if(menorDistanciaEncontrada3>= menorDistanciaEncontrada2 && menorDistanciaEncontrada3>= menorDistanciaEncontrada)
               {
               menorDistanciaEncontrada3=distancia;
               rta3=m;
               }
               
               
               
               
           }
           
          
            
           
            
        }
        
        dtos.add(rta);
         dtos.add(rta2);
          dtos.add(rta3);
        
                
        return dtos;
     }
        
        
        
        
        
    }

    @Override
    public List<Mobibus> darMobibuses1() {
        
        Query q = em.createQuery("SELECT u from MobiBusEntity u");
            List<MobiBusEntity> tranvias = q.getResultList();
            ArrayList<Mobibus> dtos = new ArrayList();
            for (MobiBusEntity tranvia : tranvias) {
                dtos.add(TransformadorEntityDto.getInstance().EntityADtoMobibus(tranvia));
            }
            return dtos;
    }

   
   
}
