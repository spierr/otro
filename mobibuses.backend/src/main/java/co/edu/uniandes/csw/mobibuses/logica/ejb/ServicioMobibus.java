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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
       
       private static final String TOKEN ="SELECT u FROM UserEntity u WHERE u.token ='";

    public ServicioMobibus()
    {
        em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
      if(darMobibuses1().isEmpty())
          TransformadorEntityDto.getInstance().crearMobibibuses(em);
  
    }
    
  
    /**
     * metodo encargado de dar todo los mobibuses del sistema
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return una lista con todo los mobibuses del sistema
     */
    
    @Override
    public List<Mobibus> darMobibuses(String token) {
        /*Query qu = em.createQuery(TOKEN+token+"'");
     if(qu.getResultList().isEmpty())
     {
        return new ArrayList();
         
     }
     else*/
     {
            Query q = em.createQuery("SELECT u from MobiBusEntity u");
            List<MobiBusEntity> tranvias = q.getResultList();
            List<Mobibus> dtos = new ArrayList();
            for (MobiBusEntity tranvia : tranvias) {
                dtos.add(TransformadorEntityDto.getInstance().entityADtoMobibus(tranvia));
            }
            return dtos;
     }
    }
    
    
    /**
     * metodo encargado de dar el mobibus mas cercano a una posicion geografica
     * @param cordenada1 latitud geogrfica mas cercana deseada
     * @param cordenada2 longitud geografica mas cercana deseada
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return el mobibud mas cercano a la posicion geogrfica
     */
    
    @Override
    public Mobibus darMobibusMasCercano(double cordenada1, double cordenada2,String token) {
    
       /* Query qu = em.createQuery(TOKEN+token+"'");
     if(qu.getResultList().isEmpty())
     {
         return null;
     }
     else*/
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

    /**
     * metodo encargado de alquilar un mobibud
     * @param id el id del mobibus deseada para alquilar
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @throws OperacionInvalidaException 
     */
    
    
    @Override
    public void alquilarMobibus(int id,String token) throws OperacionInvalidaException {
    MobiBusEntity mb = em.find(MobiBusEntity.class, id);
        if(mb.isReservado())
        {
            mb.setReservado(true);
        }
        else
        {
            throw new OperacionInvalidaException("El Mobibus con id "+id+ " se encuentra reservado.");
        }
    }

    
    
    /**
     * libera un mobibus deseado
     * @param id id del mobibus deseado a librr
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @throws OperacionInvalidaException 
     */   
    
    @Override
    public void liberarMobibus(int id,String token) throws OperacionInvalidaException {
  MobiBusEntity mb = em.find(MobiBusEntity.class, id);
        if(mb.isReservado()==true)
        {
            mb.setReservado(false);
        }
        else
        {
            throw new OperacionInvalidaException("El Mobibus con id "+id+ " se encuentra desocupado.");
        }

    }

    
    
    
    
    /**
     * agrega una ruta a un mobibus
     * @param pId id del mobibus desedo 
     * @param pDist distancia de la ruta
     * @param pTiempo tiempo de la ruta
     * @param token  que garantiza autenticacion del usuario para usar el servicio
     */
    
    @Override
    public void agregarRuta(int  pId, int pDist, int pTiempo,String token ) {

  MobiBusEntity mb = em.find(MobiBusEntity.class, pId);
   long g=mb.getRutas().size();
   RutaEntity ruta = new RutaEntity();
   ruta.setDistancia(pDist);
   ruta.setTiempo(pTiempo);
   ruta.setId(g+1);
   
   
        mb.setRutas(ruta);
    }
    

    
    
    /**
     * da reporte de todas las rutas de un mobibus
     * @param pId del mobibus desedo
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return  un reporte de las rutas del mobibus
     */
    
    @Override
    public String darReporteRutas(int pId,String token) {
     MobiBusEntity mb = em.find(MobiBusEntity.class, pId);
        /*Query qu = em.createQuery(TOKEN+token+"'");
     if(qu.getResultList().isEmpty())
     {
         return null;
     }
     else*/
     {
       
        String x="";
        Set<RutaEntity> rutas= mb.getRutas();
       
        Iterator<RutaEntity>  recorrer = rutas.iterator();
        
        
       while(recorrer.hasNext()) {
            RutaEntity a=recorrer.next();
           
            x+= "La ruta " + a.getId()+" tuvo una distancia de "+a.getDistancia()+ 
                    " y un tiempo de " + a.getTiempo()+"<p>";
            
            
            
        }
        return x;
     }

    }

    
    
    /**
     * elimina la ruta de un mobibus
     * @param idMobibus id del mobibus al que se desea eliminar una ruta
     * @param idRuta id de la ruta que se desea eliminar
     * @param token  que garantiza autenticacion del usuario para usar el servicio
     */
    
    
    @Override
    public void eliminarRuta(int idMobibus, int idRuta,String token) {
       /* Query qu = em.createQuery(TOKEN+token+"'");
     if(!qu.getResultList().isEmpty())*/
     {
        RutaEntity r = em.find(RutaEntity.class, idRuta);
        em.remove(r);
     }
       
    }

    
    
    /**
     * cambiar una posicion
     * @param id del mobibus deseado a modificar
     * @param longi longitud geografica
     * @param lat latitud geografica
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return 
     */
    
    @Override
    public Mobibus cambiarPosicion(int id, double longi, double lat,String token) {
        /*Query qu = em.createQuery(TOKEN+token+"'");
     if(qu.getResultList().isEmpty())
     {
         return null;
     }
     else*/
     {
        MobiBusEntity mb = em.find(MobiBusEntity.class, id);
        mb.setPosicionLatitud(lat);
        mb.setPosicionLongitud(longi);
        em.persist(mb);
        return TransformadorEntityDto.getInstance().entityADtoMobibus(mb);
     }
    }

    
    
    /**
     * cambia el kilometraje de un mobibus
     * @param id del mobibud deseado a modificar
     * @param kilo kilometraje recorrido
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return el mobibus al que se modifico el kilometraje
     */
    
    @Override
    public Mobibus cambiarKilo(int id, double kilo,String token) {
        /*Query qu = em.createQuery("SELECT u FROM UserEntity u WHERE u.rol='admin' and  u.token ='"+token+"'");
     if(qu.getResultList().isEmpty())
     {
         return null;
     }
     else*/
     {
        MobiBusEntity mb = em.find(MobiBusEntity.class, id);
        mb.setKilometraje(kilo);
        em.persist(mb);
        return TransformadorEntityDto.getInstance().entityADtoMobibus(mb);
     }
    }

    
    
    
    /**
     * da los 3 mobibuses mas cercanos a una posicion geografica
     * @param cordenada1 latitud geografica
     * @param cordenada2 longitud geografica
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return una lista con los 3 mobibuses mas cercanos a una posicion geografica
     */
    
    @Override
    public List<Mobibus> darMobibusMasCercanoBono(double cordenada1, double cordenada2, String token) {
       
       /* Query qu = em.createQuery("SELECT u FROM UserEntity u WHERE u.rol='admin' and u.token ='"+token+"'");
     if(qu.getResultList().isEmpty())
     {
         return new ArrayList();
     }
     else*/
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

    
    
    /**
     * da los mobibuses del sistema
     * @return  la lista de los mobibuses
     */
    
    @Override
    public List<Mobibus> darMobibuses1() {
        
        Query q = em.createQuery("SELECT u from MobiBusEntity u");
            List<MobiBusEntity> tranvias = q.getResultList();
            List<Mobibus> dtos = new ArrayList();
            for (MobiBusEntity tranvia : tranvias) {
                dtos.add(TransformadorEntityDto.getInstance().entityADtoMobibus(tranvia));
            }
            return dtos;
    }

   
   
}
