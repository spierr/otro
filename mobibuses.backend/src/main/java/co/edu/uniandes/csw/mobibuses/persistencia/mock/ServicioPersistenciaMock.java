/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioPersistenciaMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.csw.mobibuses.persistencia.mock;


import co.edu.uniandes.csw.mobibuses.dto.EstacionVcub;

import co.edu.uniandes.csw.mobibuses.dto.Tranvia;
import co.edu.uniandes.csw.mobibuses.dto.Vcub;
import co.edu.uniandes.csw.mobibuses.dto.Mobibus;
import co.edu.uniandes.csw.mobibuses.dto.Ruta;
import co.edu.uniandes.csw.mobibuses.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioPersistenciaMockRemote;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * Implementación de los servicios de persistencia
 * @author Juan Sebastián Urrego
 */

public class ServicioPersistenciaMock implements IServicioPersistenciaMockRemote, IServicioPersistenciaMockLocal {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

   
   
    
    //lista de los tranvias
    
    private static ArrayList<Tranvia> tranvias;
    
    /**
     * Lista con los Vcubs
     */
    private static ArrayList<Vcub> vcubes;
    
     /**
     * Lista con los Vcubs
     */
    private static ArrayList<Mobibus> mobibuses;
    
    /**
     * Lista de Estacion Vcub
     */
    private static ArrayList<EstacionVcub> estacionesVcub;
   
    @PersistenceContext(unitName = "pw")
    public EntityManager entityManager; 

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase. Inicializa los atributos.
     */
     @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
            System.out.println("Se ha iniciado el entity manager Cristian"+entityManager.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    public ServicioPersistenciaMock()
    {
 //        TransformadorEntityDto.getInstance().crearMobibibuses(entityManager);
 //       TransformadorEntityDto.getInstance().crearMobibibuses(entityManager);
        TransformadorEntityDto.getInstance().crearTranvias(entityManager);
        //TransformadorEntityDto.getInstance().crearVcubes(entityManager);   
                        
        
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     */
    @Override
    public void create(Object obj) throws OperacionInvalidaException
    {
        if(obj instanceof EstacionVcub)
        {
            entityManager.persist(TransformadorEntityDto.getInstance().DtoAEntityEstacionVcube((EstacionVcub)obj));
        }
        else if(obj instanceof Vcub)
        {
            entityManager.persist(TransformadorEntityDto.getInstance().DtoAEntityVcube((Vcub)obj));
        }
        else if(obj instanceof Mobibus)
        {
            entityManager.persist(TransformadorEntityDto.getInstance().DtoAEntityMobibus((Mobibus)obj));
        }
        else if(obj instanceof Tranvia)
        {
          entityManager.persist(TransformadorEntityDto.getInstance().DtoAEntityTranvia((Tranvia)obj));
        }
//        else if(obj instanceof Ruta)
//        {
//           entityManager.persist(TransformadorEntityDto.getInstance().DtoAEntityRuta((Ruta)obj));
//        }
       
    }

    /**
     * Permite modificar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    @Override
    public void update(Object obj)
    {
       
        if (obj instanceof Vcub)
        {
            entityManager.refresh((Vcub)obj);
          
        }
          
          else if(obj instanceof EstacionVcub)
        {
            entityManager.refresh((Vcub)obj);
        }
        
        else if (obj instanceof Mobibus)
        {
           entityManager.refresh((Vcub)obj);
        }
        else if (obj instanceof Tranvia)
        {
            entityManager.refresh((Vcub)obj);
        }
       
    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    @Override
    public void delete(Object obj) throws OperacionInvalidaException
    {
//        if (obj instanceof Ruta)
//        {
//            Vendedor vendedorABorrar = (Vendedor) obj;
//
//            for (int e = 0; e < vendedores.size(); e++)
//            {
//                Vendedor ven = (Vendedor) vendedores.get(e);
//                if (ven.getIdentificacion() == vendedorABorrar.getIdentificacion())
//                {
//                    vendedores.remove(e);
//                    break;
//                }
//            }
//
//        } 
//        else if (obj instanceof Mobibus)
//        {
//            Mueble mueble;
//            Mueble eliminar = (Mueble) obj;
//            for (int i = 0; i < muebles.size(); i++)
//            {
//                mueble = muebles.get(i);
//                if (eliminar.getReferencia() == mueble.getReferencia())
//                {
//                    muebles.remove(i);
//                    break;
//                }
//
//            }
//
//        } 
//        else if (obj instanceof Tranvia)
//        {
//            Usuario usuarioABorrar = (Usuario) obj;
//            for (RegistroVenta rv : registrosVentas)
//            {
//                if (rv.getComprador().getLogin().equals(usuarioABorrar.getLogin()))
//                {
//                    System.out.print("no borrado");
//                    throw new OperacionInvalidaException("El usuario ha realizado comprar y por lo tanto no puede ser eliminado del sistema.");
//                }
//            }
//            if (usuarioABorrar != null && usuarioABorrar.getLogin() != null)
//            {
//                for (int e = 0; e < usuarios.size(); e++)
//                {
//                    Usuario ven = (Usuario) usuarios.get(e);
//                    if (ven.getLogin().equals(usuarioABorrar.getLogin()))
//                    {
//                        usuarios.remove(e);
//                        System.out.print("borrado");
//                        break;
//                    }
//                }
//            }
//        }
//           else 
        if (obj instanceof Vcub)
        {
            Vcub eliminar = (Vcub) obj;
            Vcub vc;
            for (int i = 0; i < vcubes.size(); i++)
            {
                vc = vcubes.get(i);
                if (vc.getId() == eliminar.getId())
                {
                    vcubes.remove(i);
                    break;
                }
            }
        }
           else if (obj instanceof EstacionVcub)
        {
            EstacionVcub eliminar = (EstacionVcub) obj;
            EstacionVcub vc;
            for (int i = 0; i < estacionesVcub.size(); i++)
            {
                vc = estacionesVcub.get(i);
                if (vc.getId() == eliminar.getId())
                {
                    vcubes.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    @Override
    public List findAll(Class c)
    {
        
         System.out.println("Este es eol entity"+entityManager.toString());
        //TransformadorEntityDto.getInstance().crearMobibibuses(entityManager);
        TransformadorEntityDto.getInstance().crearTranvias(entityManager);
        //TransformadorEntityDto.getInstance().crearVcubes(entityManager);
        entityManager.clear();
            entityManager.close();
         if (c.equals(Tranvia.class))
        {
           
//            Query q = entityManager.createQuery("select u from TranviaEntity  ASC");
//            List<TranviaEntity> tranvias = q.getResultList();
//            ArrayList dtos = new ArrayList();
//            for (TranviaEntity tranvia : tranvias) {
//                dtos.add(TransformadorEntityDto.getInstance().EntityADtoTranvia(tranvia));
//            }
            return new ArrayList();
        
        } 
         if (c.equals(Mobibus.class))
        {

            
            
            return mobibuses;
        
        } 
       
        else if(c.equals(Vcub.class))
        {
            return vcubes;
        }
        else if(c.equals(EstacionVcub.class))
        {
            return estacionesVcub;
        }
        else if(c.equals(Ruta.class))
        {
            return estacionesVcub;
        }
        else
        {
            return null;
        }
    }

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    @Override
    public Object findById(Class c, Object id)
    {
        if(c.equals(Vcub.class)){
            for(Object v:findAll(c))
            {
                Vcub vc = (Vcub)v;
                if(vc.getId()==Integer.parseInt(id.toString()))
                {
                    return vc;
                }
            }
        }
         else if(c.equals(EstacionVcub.class)){
            for(Object v:findAll(c))
            {
                EstacionVcub vc = (EstacionVcub)v;
                if(vc.getId()==Integer.parseInt(id.toString()))
                {
                    return vc;
                }
            }
        }
        
        
         else if(c.equals(Tranvia.class)){
            for(Object v:findAll(c))
            {
                Tranvia tranvia = (Tranvia)v;
                if(tranvia.getNombre().equals(id.toString()))
                {
                    return tranvia; 
                }
            }
        }
        
        else if(c.equals(Mobibus.class)){
            for(Object v:findAll(c))
            {
                Mobibus mb = (Mobibus)v;
                if(mb.getID()==Integer.parseInt(id.toString()))
                {
                    return mb; 
                }
            }
        }
        return null;
    }
}
