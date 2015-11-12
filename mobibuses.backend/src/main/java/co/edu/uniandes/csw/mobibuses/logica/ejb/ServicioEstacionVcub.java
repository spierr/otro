package co.edu.uniandes.csw.mobibuses.logica.ejb;
import co.edu.uniandes.csw.mobibuses.dto.EstacionVcub;
import co.edu.uniandes.csw.mobibuses.dto.Vcub;
import co.edu.uniandes.csw.mobibuses.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioEstacionVcubMockLocal;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.EstacionVcubEntity;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.PersistenceManager;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.TransformadorEntityDto;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.VcubEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author s.correa12
 */
@Stateless
@Local
public class ServicioEstacionVcub implements IServicioEstacionVcubMockLocal, Serializable{

    
       @PersistenceContext
    private EntityManager em;
       
       private static final String CTOKEN ="SELECT u FROM UserEntity u WHERE u.token ='";
     
       private static final String VCUBSQL = "SELECT v from VcubEntity v WHERE  v.estacionVcub.id = ";
       
       private static final String ADMINTOKENSQL ="SELECT u FROM UserEntity u WHERE u.rol='admin' and u.token ='";
    
    public ServicioEstacionVcub() {
        em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
         if(darTodosVcub1().isEmpty())
          TransformadorEntityDto.getInstance().crearVcubes(em);
    }
     
    
    /**
     * da las estaciones
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return la lista de las estaciones
     */
    
    @Override
    public List<EstacionVcub> darEstacionesVcub(String token)
    {
         /*Query qu = em.createQuery(CTOKEN+token+"'");
     if( qu.getResultList().isEmpty())
     {
         return new ArrayList();
     }
     else*/
     {
            Query q = em.createQuery("SELECT u from EstacionVcubEntity u");
            List<EstacionVcubEntity> estaciones = q.getResultList();
            List<EstacionVcub> dtos = new ArrayList();
            for (EstacionVcubEntity est : estaciones) {
                dtos.add(TransformadorEntityDto.getInstance().entityADtoEstacionVcube(est));
            }
            return dtos;
     }
    }

    
    
    /**
     * da los vcubes de una estacion
     * @param idestacion id de la estacion en la que se desean saber los vcubes
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return lista de vcubes de una estacion
     */
    
    @Override
    public List<Vcub> darVcubesEstacion(int idestacion, String token) {
         /*Query qu = em.createQuery(CTOKEN+token+"'");
     if( qu.getResultList().isEmpty())
     {
         return new ArrayList();
     }
     else*/
     {
        Query q = em.createQuery(VCUBSQL+idestacion);
        List<VcubEntity> vce =q.getResultList();
        List<Vcub> dtos = new ArrayList();
        for(VcubEntity vc : vce)
        {
            dtos.add(TransformadorEntityDto.getInstance().entityADtoVcube(vc));
        }
        return dtos;
     }
    }

    
    
    /**
     * da todos los vcubes
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return lista de todos los vcubes
     */
    
    @Override
    public List<Vcub> darTodosVcub(String token) 
    {
         /*Query qu = em.createQuery(CTOKEN+token+"'");
     if( qu.getResultList().isEmpty())
     {
         return new ArrayList();
     }
     else*/
     {
          Query q = em.createQuery("SELECT v from VcubEntity v" );
        List<VcubEntity> vce =q.getResultList();
        List<Vcub> dtos = new ArrayList();
        for(VcubEntity vc : vce)
        {
            dtos.add(TransformadorEntityDto.getInstance().entityADtoVcube(vc));
        }
        return dtos;
     }
    }
    
    
    
    /**
     * da todos los vcubes
     * @return la lista de todos los vcubes
     */
    
     @Override
    public List<Vcub> darTodosVcub1() {
          Query q = em.createQuery("SELECT v from VcubEntity v" );
        List<VcubEntity> vce =q.getResultList();
        List<Vcub> dtos = new ArrayList();
        for(VcubEntity vc : vce)
        {
            dtos.add(TransformadorEntityDto.getInstance().entityADtoVcube(vc));
        }
        return dtos;
    }
    
    
    /**
     * alquina un vcub deseado
     * @param idestacion id de la estacion en la que se desea alquilar
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return vcub que se fue alquilado en una estacion dada
     * @throws OperacionInvalidaException 
     */

    @Override
    public Vcub alquilarVcub(int idestacion, String token) throws OperacionInvalidaException
    {
        /* Query qu = em.createQuery( ADMINTOKENSQL +token+"' ");
     if( qu.getResultList().isEmpty())
     {
         return null;
     }
     else*/
     {
        Long ide = new Long(idestacion);
        EstacionVcubEntity este = em.find(EstacionVcubEntity.class, ide);
        Vcub resp = null;
        List<VcubEntity> vcubes = em.createQuery(VCUBSQL+ide ).getResultList();
         for (VcubEntity actual : vcubes) {
             if(actual.getOcupado().equals(Vcub.DISPONIBLE))
             {
                 actual.setOcupado(Vcub.OCUPADO);
                 resp = TransformadorEntityDto.getInstance().entityADtoVcube(actual);
                 este.setPrestados(este.getPrestados()+1);
                 este.setvCubs(new HashSet(vcubes));
                 em.persist(actual);
                 em.persist(este);
                 break;
             }
         }
                 if(resp == null)
                 {
                     throw new OperacionInvalidaException("No hay vcubs disponibles en la estacion: "+ idestacion);
                 }
                 else if(resp!=null && este.getPrestados()==(int)(este.getvCubs().size()*(0.1)))
                 {
                     for (VcubEntity actual : vcubes) {
                         if(actual.getOcupado().equals(Vcub.NO_DISPONIBLE))
                         {
                             actual.setOcupado(Vcub.DISPONIBLE);
                             este.setvCubs(new HashSet(vcubes));
                             em.persist(actual);
                             em.persist(este);
                         }
                     }
                 }
                 return resp;
     } 
    }

    
    
    /**
     * libera un vcub
     * @param idestacion de la estacion en la cual se quiere liberar un vcub
     * @param iddevolver id de la estacion donde se va a devolver el vcub
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return el vcub el cual fue liberado
     * @throws OperacionInvalidaException 
     */
    
    
    @Override
    public Vcub liberarVcub(int idestacion,int iddevolver, String token) throws OperacionInvalidaException 
    {
        /* Query qu = em.createQuery( ADMINTOKENSQL +token+"'");
     if( qu.getResultList().isEmpty())
     {
         return null;
     }
     else*/
     {
        Long ide = new Long( idestacion);
        EstacionVcubEntity est = em.find(EstacionVcubEntity.class, ide);
        VcubEntity vcd = em.find(VcubEntity.class,new Long( iddevolver));
        EstacionVcubEntity estValquilo = em.find(EstacionVcubEntity.class,new Long( vcd.getEstacionVcub().getId()));
        
        Vcub devuelto =null;
        if(estValquilo.getId()==est.getId())
        {
            List<VcubEntity> vcubes = em.createQuery(VCUBSQL+est.getId() ).getResultList();
            for (VcubEntity vc : vcubes) {
                if(vc.getId()==vcd.getId())
                {
                    devuelto=TransformadorEntityDto.getInstance().entityADtoVcube(vc);
                    vc.setOcupado(Vcub.DISPONIBLE);
                    est.setPrestados(est.getPrestados()-1);
                    est.setvCubs(new HashSet(vcubes));
                    em.persist(vc);
                    em.persist(est);
                    break;
                }
            }
        }
        else
        {
            List<VcubEntity> nueva = em.createQuery(VCUBSQL+est.getId() ).getResultList();
            List<VcubEntity> vieja = em.createQuery(VCUBSQL+estValquilo.getId() ).getResultList();
            vieja.remove(vcd);
            vcd.setOcupado(Vcub.DISPONIBLE);
            vcd.setEstacionVcub(est);
            EstacionVcubEntity ant = em.find(EstacionVcubEntity.class,new Long(estValquilo.getId()));
            ant.setPrestados(ant.getPrestados()-1);
            nueva.add(vcd);
            devuelto = TransformadorEntityDto.getInstance().entityADtoVcube(vcd);
            est.setvCubs(new HashSet(nueva));
            estValquilo.setvCubs(new HashSet(vieja));
           em.persist(vcd);
           em.persist(est);
           em.persist(estValquilo);
        }
        if(devuelto == null)
        {
            throw new OperacionInvalidaException("No de devolvio");
        }
        return devuelto;
     }
    }

    
    
    /**
     * reduce el numero de vcubes a la estacion
     * @param token que garantiza autenticacion del usuario para usar el servicio
     */
    
    @Override
    public void reducirVcubesTodas( String token) {
        /* Query qu = em.createQuery( ADMINTOKENSQL +token+"'");
     if( !qu.getResultList().isEmpty())*/
     {
        Query q = em.createQuery("SELECT u from EstacionVcubEntity u");
            List<EstacionVcubEntity> estaciones = q.getResultList();
            reducirVcubsAuxiliar(estaciones);
     }
    }

    
    
    
    /**
     * reduce el numero de vcubes a una estacion especifica
     * @param idestacion id de la estacion a la que se quiere reducir los vcubes
     * @param token que garantiza autenticacion del usuario para usar el servicio
     */
    
    @Override
    public void reducirVcubesEspecifica(int idestacion, String token) {
   /*      Query qu = em.createQuery( ADMINTOKENSQL +token+"'");
     if( !qu.getResultList().isEmpty())*/
     {
         EstacionVcubEntity est = em.find(EstacionVcubEntity.class,new Long( idestacion));
                    int numero30 = (int) (est.getvCubs().size()*(0.3));
            int j = 0 ;
            int index = 0 ;
           List<VcubEntity> vcubes = em.createQuery(VCUBSQL+est.getId() ).getResultList();
            while(j<=numero30 && index<vcubes.size())
            {
                VcubEntity actual = vcubes.get(index);
                if(actual.getOcupado().equals(Vcub.DISPONIBLE))
                {
                    j++;
                    actual.setOcupado(Vcub.NO_DISPONIBLE);
                    em.persist(actual);
                }
                index++;
            }
            est.setvCubs(new HashSet(vcubes));
            em.persist(est);
     }
    }
    
    
    /**
     * da los vcubes disponibles de una estacion
     * @param idestacion id de la estacion donde se desean buscar los vcubes disponibles
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return lista de los vcubes disponibles
     */

    @Override
    public List<Vcub> darVcubesDisponiblesEstacion(int idestacion, String token) {
        /* Query qu = em.createQuery(CTOKEN+token+"'");
     if( qu.getResultList().isEmpty())
     {
         return new ArrayList();
     }
     else*/
     {
        List<Vcub> sol = new ArrayList<Vcub>();
        List<Vcub> arr = darVcubesEstacion(idestacion, token);
        for (Vcub arr1 : arr)
        {
            if(arr1.isOcupado().equals(Vcub.DISPONIBLE))
            {
                sol.add(arr1);
            }
        }
        return sol;
     }
    }

    
    
    /**
     * da los vcubes ocupados de una estacion
     * @param idestacion id de la estacion donde se desea buscar los vcubes ocupados
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return la lista de los vcubes ocupados
     */
    
    @Override
    public List<Vcub> darVcubesOcupadosEstacion(int idestacion, String token)
    {
    /*     Query qu = em.createQuery(CTOKEN+token+"'");
     if( qu.getResultList().isEmpty())
     {
         return new ArrayList();
     }
     else*/
     {
        List<Vcub> sol = new ArrayList<Vcub>();
        List<Vcub> arr = darVcubesEstacion(idestacion,  token);
        for (Vcub arr1 : arr)
        {
            if(arr1.isOcupado().equals(Vcub.OCUPADO))
            {
                sol.add(arr1);
            }
        }
        return sol;
     }
    }
    
    
    /**
     * da los vcubes no disponibles de una estacion
     * @param idestacion id de la estacion donde se desea buscar los vcubes no disponibles
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return la lista de los vcubes no disponibles
     */

    @Override
    public List<Vcub> darVcubesNoDisponiblesEstacion(int idestacion, String token) {
       /*  Query qu = em.createQuery(CTOKEN+token+"'");
     if( qu.getResultList().isEmpty())
     {
         return new ArrayList();
     }
     else*/
     {

    List<Vcub> sol = new ArrayList<Vcub>();
        List<Vcub> arr = darVcubesEstacion(idestacion, token);
        for (Vcub arr1 : arr)
        {
            if(arr1.isOcupado().equals(Vcub.NO_DISPONIBLE))
            {
                sol.add(arr1);
            }
        }
        return sol;
     }
    }

    
    
    /**
     * modifica la posicion de un vcub
     * @param idVcub id del vcub a modificar
     * @param longitud longitud geografica
     * @param latitud latitud geografica
     * @param token que garantiza autenticacion del usuario para usar el servicio
     * @return  el vcub modificado
     */
    
    
    @Override
    public Vcub modificarPosVcub(int idVcub, double longitud, double latitud, String token) 
    {
        /*
         Query qu = em.createQuery( ADMINTOKENSQL +token+"'");
     if( qu.getResultList().isEmpty())
     {
         return null;
     }
     else*/
     {
        Long idvc = new Long(idVcub);
        VcubEntity vc = em.find(VcubEntity.class, idvc);
        EstacionVcubEntity evc = em.find(EstacionVcubEntity.class, new Long(vc.getEstacionVcub().getId()));
        List<VcubEntity> arr = em.createQuery(VCUBSQL+evc.getId() ).getResultList();
        Vcub r = null;
        for (VcubEntity arr1 : arr)
        {
            if(arr1.getId()==idVcub)
            {
                arr1.setLatitud(latitud);
                arr1.setLongitud(longitud);
                em.persist(arr1);
                evc.setvCubs(new HashSet(arr));
                em.persist(evc);
                r=TransformadorEntityDto.getInstance().entityADtoVcube(arr1);
                break;
            }
        }
        return r;
     }
    }

    
    /**
     * reduce la cantidad de vcubes en ciertas estaciones
     * @param estaciones lista de las estaciones donde se quieren reducir los vcubes
     */
    
    
    private void reducirVcubsAuxiliar(List<EstacionVcubEntity> estaciones) {

        for (EstacionVcubEntity est : estaciones) {
            int numero30 = (int) (est.getvCubs().size()*(0.3));
            int j = 0 ;
            int index = 0 ;
            List<VcubEntity> vcubes = em.createQuery(VCUBSQL+est.getId() ).getResultList();
            while(j<=numero30 && index<vcubes.size())
            {
                VcubEntity actual = vcubes.get(index);
                if(actual.getOcupado().equals(Vcub.DISPONIBLE))
                {
                    j++;
                    actual.setOcupado(Vcub.NO_DISPONIBLE);
                    em.persist(actual);
                }
                index++;
            }
            est.setvCubs(new HashSet(vcubes));
            em.persist(est);
        }
             
        }   
}
