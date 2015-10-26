/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.persistencia.mock;

import co.edu.uniandes.csw.mobibuses.persistencia.mock.EstacionVcubEntity;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.EstacionVcubEntity;
import co.edu.uniandes.csw.mobibuses.dto.EstacionVcub;
import co.edu.uniandes.csw.mobibuses.dto.Mobibus;
import co.edu.uniandes.csw.mobibuses.dto.Ruta;
import co.edu.uniandes.csw.mobibuses.dto.Tranvia;
import co.edu.uniandes.csw.mobibuses.dto.Vcub;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author cf.brochero10
 */

public class TransformadorEntityDto {
    
    public static final TransformadorEntityDto t= new TransformadorEntityDto();
     public final static int NUMERO_ESTACIONES= 20;
 
    
     public static TransformadorEntityDto getInstance() {
 
        return t;
    }
 
 
    private TransformadorEntityDto () {
        
    }
    
    
    
    public void crearMobibibuses(EntityManager entityManager){
                   
             System.out.println("Se ha iniciado el entity manager Cristian"+entityManager.toString());
             
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
           
          
            System.out.println("Se persistio correctamente mobibus");
           
        } catch (Exception t) {
            System.out.println("Se toteo "+t.getMessage());
     
            t.printStackTrace();
            
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
               
                Tranvia x = new Tranvia("tranvia"+(i), ruta, numero, numero2, 3, 3, 3, kilometraje,nombreConductor,tiempoTrayecto) ;
            
                
                    
                entityManager.persist(TransformadorEntityDto.getInstance().DtoAEntityTranvia(x));
                               
               
                
            
            
            
        }
        
    }
    public void crearVcubes(EntityManager entityManager){
        ArrayList  estacionesVcub =null;
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
            entityManager.persist(TransformadorEntityDto.getInstance().DtoAEntityEstacionVcube(nueva));
           
            System.out.println("Se persistio correctamente estacionmes");
           
        } catch (Exception t) {
            System.out.println("Se toteo "+t.getMessage());
     
            t.printStackTrace();
            
        }
               
            }
        }
         ArrayList  vcubes= null; 
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
                          VcubEntity vce = TransformadorEntityDto.getInstance().DtoAEntityVcube(nuevo);
                          vce.setEstacionVcub(entityManager.find(EstacionVcubEntity.class,new Long(actual.getId())));
                          vce.setId(nuevo.getId());
            entityManager.persist(vce);
            System.out.println("Se persistio correctamente vcub");
           
        } catch (Exception t) {
            System.out.println("Se toteo "+t.getMessage());
     
            t.printStackTrace();
            
        }
               
                               
            }
            
        }
    }
    
    public VcubEntity DtoAEntityVcube(Vcub dto)
     {
       VcubEntity en= new VcubEntity();
       en.setLatitud(dto.getLatitud());
       en.setLongitud(dto.getLongitud());
       en.setOcupado(dto.isOcupado());
       en.setId(dto.getId());
       return en;  
     }
    public EstacionVcubEntity DtoAEntityEstacionVcube(EstacionVcub dto)
     {
         EstacionVcubEntity en= new EstacionVcubEntity();
         en.setId(dto.getId());
         en.setLatitudEstacion(dto.getLatitudEstacion());
         en.setLongitudEstacion(dto.getLongitudEstacion());
         en.setPrestados(dto.getPrestados());
         ArrayList<Vcub> arr= dto.getVcubsEstacion();
         ArrayList<VcubEntity> arr1 = new ArrayList();
         for(Vcub vc : arr)
         {
             VcubEntity vce = DtoAEntityVcube(vc);
             arr1.add(vce);
         }
         Set<VcubEntity> set = new HashSet(arr1);
         en.setvCubs(set);
         return en;
     }
    public RutaEntity DtoAEntityRutaEntity(Ruta dto)
     {
         RutaEntity en = new RutaEntity();
         return en;
         
     }
    public MobiBusEntity DtoAEntityMobibus(Mobibus dto)
     {
                MobiBusEntity mo= new MobiBusEntity();
                mo.setFechaReservacion(dto.getFechaReservacion());
                mo.setNombre(dto.getNombre());
                mo.setPosicionLatitud(dto.getposicionLatitud());
                mo.setPosicionLongitud(dto.getposicionLongitud());
                mo.setReservado(dto.getReservado());
                return mo;
           
     }
    public TranviaEntity DtoAEntityTranvia(Tranvia dto)
     {
                TranviaEntity t = new TranviaEntity();
                t.setKilometraje(dto.getKilometraje());
                t.setLinea(dto.getLinea());
                t.setNivelChoque(dto.getNivelChoque());
                t.setNivelPanico(dto.getNivelPanico());
                t.setNivelTemperatura(dto.getNivelTemparatura());
                t.setNombre(dto.getNombre());
                t.setNombreConductor(dto.getNombreConductor());
                t.setPosicionLatitud(dto.getposicionLatitud());
                t.setPosicionLongitud(dto.getposicionLongitud());
                t.setTiempoTrayecto(dto.getTimepoPromedio());
                return t;
     }
    
    
    public Vcub EntityADtoVcube(VcubEntity entity)
     {
         Vcub dto = new Vcub(entity.getId(), entity.getEstacionVcub().getId());
         dto.setOcupado(entity.getOcupado());
         dto.setLatitud(entity.getLatitud());
         dto.setLongitud(entity.getLongitud());
         return dto;
     }
    public EstacionVcub EntityADtoEstacionVcube(EstacionVcubEntity entity)
     {
         EstacionVcub dto = new EstacionVcub(entity.getId(), entity.getLongitudEstacion(), entity.getLatitudEstacion());
         dto.setPrestados(entity.getPrestados());
         Set<VcubEntity> set = entity.getvCubs();
         ArrayList<Vcub> arr = new ArrayList();
        for(VcubEntity vc : set)
        {
            Vcub n = EntityADtoVcube(vc);
            arr.add(n);
        } 
         dto.setVcubsEstacion(arr);
         return dto;
         
     }
    public Ruta EntityADtoRutaEntity(RutaEntity entity)
     {
         Ruta dto = new Ruta(entity.getDistancia(), entity.getTiempo(), entity.getId());
         return dto;
     }
    public Mobibus EntityADtoMobibus(MobiBusEntity entity)
     {
         Mobibus dto = new Mobibus(entity.getNombre(), entity.getPosicionLatitud() , entity.getPosicionLongitud(), entity.getKilometraje(), entity.getFechaReservacion(), entity.getId());
         return dto;
     }
    public Tranvia EntityADtoTranvia(TranviaEntity entity)
     {
         Tranvia dto = new Tranvia(entity.getNombre(), entity.getLinea(), entity.getPosicionLatitud(), entity.getPosicionLongitud(), entity.getNivelChoque(), entity.getNivelTemperatura(), entity.getNivelPanico(), entity.getKilometraje(), entity.getNombreConductor(), entity.getTiempoTrayecto());
         return dto;
     }
    
}
