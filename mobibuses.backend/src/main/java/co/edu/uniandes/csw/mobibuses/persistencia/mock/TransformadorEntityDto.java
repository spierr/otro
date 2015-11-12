/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.persistencia.mock;

import co.edu.uniandes.csw.mobibuses.dto.EstacionVcub;
import co.edu.uniandes.csw.mobibuses.dto.Mobibus;
import co.edu.uniandes.csw.mobibuses.dto.Tranvia;
import co.edu.uniandes.csw.mobibuses.dto.User;
import co.edu.uniandes.csw.mobibuses.dto.Vcub;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author cf.brochero10
 */

public class TransformadorEntityDto {
    
    public static final TransformadorEntityDto t= new TransformadorEntityDto();
     public static final int NUMERO_ESTACIONES= 20;
 
    private TransformadorEntityDto () {
        
    }
     public static TransformadorEntityDto getInstance() {
 
        return t;
    }
 
 
    
    
    
    public void crearUsuarios(EntityManager entityManager)
    {
           
        UserEntity admin = new UserEntity();
        admin.setId(new Long(0));
        admin.setPassword(User.ADMIN);
        admin.setRol(User.ADMIN);
        admin.setToken(null);
        admin.setUsuario(User.ADMIN);
        UserEntity user = new UserEntity();
        user.setId(new Long(1));
        user.setPassword("pollitas");
        user.setRol(User.USERNAME);
        user.setToken(null);
        user.setUsuario(User.USERNAME);
        
        try {
                         
            entityManager.persist(admin);
            entityManager.persist(user);

        } catch (Exception exp) 
        {
             Logger.getLogger(TransformadorEntityDto.class.getName()).log(Level.SEVERE, null, exp);
        }
        
    }
    
    public void crearMobibibuses(EntityManager entityManager){
                   
             
            for(int i = 0 ; i<250 ; i++)            {
                
               double numero = (Math.random()*0.41)+4.43;
                
                double numero2=(Math.random()*(-0.213))-74.001;
                
            
                Mobibus m= new Mobibus("Mobibus"+i, numero, numero2, 56+i, "ss",i);
                
                MobiBusEntity mo= new MobiBusEntity();
                mo.setFechaReservacion(m.getFechaReservacion());
                mo.setId(mo.getId());
                mo.setNombre(m.getNombre());
                mo.setPosicionLatitud(m.getposicionLatitud());
                mo.setPosicionLongitud(m.getposicionLongitud());
                mo.setReservado(m.getReservado());
           
                
                      try {
                         
            entityManager.persist(mo);
           
                    
        } catch (Exception exp) {
             Logger.getLogger(TransformadorEntityDto.class.getName()).log(Level.SEVERE, null, exp);

        }
                  
            
           
                
             
                
            
            }
    }
    public void crearTranvias(EntityManager entityManager){
       
            
             for(int i = 0 ; i<250 ; i++)
            {
                int linea=(int)(Math.random()*3);
                
                String ruta="";
                
                if(linea==1)
                {
                    ruta="A";
                }
                if(linea==2)
                {
                    ruta="B";
                }
                if(linea==3 || linea==0){
                    ruta="C";
                }
                double numero=0;
                double numero2=0;
                double tiempoTrayecto=0;
                
                if(linea==1)
                {
                      numero=(Math.random()*0.41)+4.43;
                 numero2=0-74.068;
                 tiempoTrayecto=(Math.random()*2)+2;
                    
                }
                if(linea==2)
                {
                      numero=4.63;
                 numero2=(Math.random()*(-0.213))-74.001;
                  tiempoTrayecto=(Math.random()*1.5)+1.5;
                }
                if(linea==3 || linea==0){
                      numero=4.69;
                 numero2=(Math.random()*(-0.213))-74.001;
                  tiempoTrayecto=(Math.random()*1.5)+2;
                }
                
                
                double kilometraje ;
                
                
                kilometraje=Math.random()*10000+1000 ;
                
              String  nombreConductor="conductor"+i;
               
                Tranvia x = new Tranvia("tranvia", ruta, numero, numero2, 3, 3, 3, kilometraje,nombreConductor,tiempoTrayecto) ;
            
                TranviaEntity en=TransformadorEntityDto.getInstance().dtoAEntityTranvia(x);
                entityManager.persist(en);
          }
            Query q = entityManager.createQuery("SELECT u FROM TranviaEntity u");
            List<TranviaEntity> l = q.getResultList();
            for (TranviaEntity tranvia:l){
                tranvia.setNombre("tranvia"+tranvia.getId());
                entityManager.refresh(tranvia);
            }
        
    }
    public void crearVcubes(EntityManager entityManager){
        List  estacionesVcub =null;
        if(estacionesVcub==null)
        {
            estacionesVcub = new ArrayList<EstacionVcub>();
           
            for(int i = 0 ; i<NUMERO_ESTACIONES;i++)
            {
                double longitud = 0 ;
                double latitud = 0;
                
               EstacionVcub nueva = new EstacionVcub(i+1,longitud,latitud);
               estacionesVcub.add(nueva);
               
                     
                
                      try {
            entityManager.persist(TransformadorEntityDto.getInstance().dtoAEntityEstacionVcube(nueva));
                      
        } catch (Exception exp) {
             Logger.getLogger(TransformadorEntityDto.class.getName()).log(Level.SEVERE, null, exp);

        }
               
            }
        }
         List  vcubes= null; 
        if(vcubes==null)
        {
            vcubes = new ArrayList<Vcub>();
            int indiceEstacion = 0 ;
            int numeroMax = (int)(1+Math.random())*200;
            for(int b=0;b<4000;b++)
            {
                EstacionVcub est = (EstacionVcub) estacionesVcub.get(indiceEstacion);
                if(numeroMax==est.getVcubsEstacion().size())
                {
                    indiceEstacion++;
                    numeroMax = (int)(1+Math.random())*200;
                }
                if(indiceEstacion>=estacionesVcub.size())
                {
                    indiceEstacion = 0;
                    numeroMax = 700;
                }
                EstacionVcub actual = (EstacionVcub) estacionesVcub.get(indiceEstacion);
                Vcub nuevo = new Vcub(b+1,actual.getId());
                vcubes.add(nuevo);
                actual.getVcubsEstacion().add(nuevo);
                
                
                
                      try {
                          VcubEntity vce = TransformadorEntityDto.getInstance().dtoAEntityVcube(nuevo);
                          vce.setEstacionVcub(entityManager.find(EstacionVcubEntity.class,new Long(actual.getId())));
                          vce.setId(nuevo.getId());
            entityManager.persist(vce);
           
        } catch (Exception exp) {
             Logger.getLogger(TransformadorEntityDto.class.getName()).log(Level.SEVERE, null, exp);

            
        }
               
                               
            }
            
        }
    }
    
    public VcubEntity dtoAEntityVcube(Vcub dto)
     {
       VcubEntity en= new VcubEntity();
       en.setLatitud(dto.getLatitud());
       en.setLongitud(dto.getLongitud());
       en.setOcupado(dto.isOcupado());
       en.setId(dto.getId());
       return en;  
     }
    public EstacionVcubEntity dtoAEntityEstacionVcube(EstacionVcub dto)
     {
         EstacionVcubEntity en= new EstacionVcubEntity();
         en.setId(dto.getId());
         en.setLatitudEstacion(dto.getLatitudEstacion());
         en.setLongitudEstacion(dto.getLongitudEstacion());
         en.setPrestados(dto.getPrestados());
         List<Vcub> arr= dto.getVcubsEstacion();
         List<VcubEntity> arr1 = new ArrayList();
         for(Vcub vc : arr)
         {
             VcubEntity vce = dtoAEntityVcube(vc);
             arr1.add(vce);
         }
         Set<VcubEntity> set = new HashSet(arr1);
         en.setvCubs(set);
         return en;
     }
 
    public MobiBusEntity dtoAEntityMobibus(Mobibus dto)
     {
                MobiBusEntity mo= new MobiBusEntity();
                mo.setFechaReservacion(dto.getFechaReservacion());
                mo.setNombre(dto.getNombre());
                mo.setPosicionLatitud(dto.getposicionLatitud());
                mo.setPosicionLongitud(dto.getposicionLongitud());
                mo.setReservado(dto.getReservado());
                return mo;
           
     }
    public TranviaEntity dtoAEntityTranvia(Tranvia dto)
     {
                TranviaEntity tr = new TranviaEntity();
                tr.setKilometraje(dto.getKilometraje());
                tr.setLinea(dto.getLinea());
                tr.setNivelChoque(dto.getNivelChoque());
                tr.setNivelPanico(dto.getNivelPanico());
                tr.setNivelTemperatura(dto.getNivelTemparatura());
                tr.setNombre(dto.getNombre());
                tr.setNombreConductor(dto.getNombreConductor());
                tr.setPosicionLatitud(dto.getposicionLatitud());
                tr.setPosicionLongitud(dto.getposicionLongitud());
                tr.setTiempoTrayecto(dto.getTimepoPromedio());
                return tr;
     }
    
    
    public Vcub entityADtoVcube(VcubEntity entity)
     {
         Vcub dto = new Vcub(entity.getId(), entity.getEstacionVcub().getId());
         dto.setOcupado(entity.getOcupado());
         dto.setLatitud(entity.getLatitud());
         dto.setLongitud(entity.getLongitud());
         return dto;
     }
    public EstacionVcub entityADtoEstacionVcube(EstacionVcubEntity entity)
     {
         EstacionVcub dto = new EstacionVcub(entity.getId(), entity.getLongitudEstacion(), entity.getLatitudEstacion());
         dto.setPrestados(entity.getPrestados());
         Set<VcubEntity> set = entity.getvCubs();
         List<Vcub> arr = new ArrayList();
        for(VcubEntity vc : set)
        {
            Vcub n = entityADtoVcube(vc);
            arr.add(n);
        } 
         dto.setVcubsEstacion(arr);
         return dto;
         
     }
 
    public Mobibus entityADtoMobibus(MobiBusEntity entity)
     {
         return new Mobibus(entity.getNombre(), entity.getPosicionLatitud() , entity.getPosicionLongitud(), entity.getKilometraje(), entity.getFechaReservacion(), entity.getId());
         
     }
    public Tranvia entityADtoTranvia(TranviaEntity entity)
     {
         return new Tranvia(entity.getNombre(), entity.getLinea(), entity.getPosicionLatitud(), entity.getPosicionLongitud(), entity.getNivelChoque(), entity.getNivelTemperatura(), entity.getNivelPanico(), entity.getKilometraje(), entity.getNombreConductor(), entity.getTiempoTrayecto());
         
     }


    public User entityADtoUser(UserEntity te) {
        return new User( te.getId(), te.getUsuario(), te.getPassword(), te.getRol(), te.getToken());
        
    }
    
    public UserEntity etoAEntityUser (User dto)
     {
                UserEntity tr = new UserEntity();
                tr.setId(dto.getId());
                tr.setPassword(dto.getPassword());
                tr.setRol(dto.getRol());
                tr.setToken(dto.getToken());
                tr.setUsuario(dto.getUsuario());
                return tr;
     }
    
}
