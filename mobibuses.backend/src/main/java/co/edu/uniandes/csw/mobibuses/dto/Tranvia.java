package co.edu.uniandes.csw.mobibuses.dto;

public class Tranvia {
    
    private long id ;
       private String nombre ;
        private String linea ;
        private double posicionLatitud ;
        private double posicionLongitud ;
        private int nivelChoque;
        private int nivelTemperatura;
        private int nivelPanico ;
        private double kilometraje;
        private String nombreConductor;
        private double tiempoTrayecto ;
        
       public Tranvia( String nombreP, String lenaPc,double posicionLatitudP, double posicionLongitudP,int nivelChoqueP,int nivelTemperaturaP, int nivelPanicoP , double kilometrajeP , String nombreConductorP,double tiempoTrayectoP)
    {
             nombre=nombreP;
          nombreConductor=nombreConductorP;
          linea=lenaPc;
          kilometraje=kilometrajeP;
          posicionLatitud=posicionLatitudP;
          posicionLongitud=posicionLongitudP;
          nivelChoque=nivelChoqueP;
          nivelTemperatura=nivelTemperaturaP;
          nivelPanico=nivelPanicoP;
          tiempoTrayecto=tiempoTrayectoP;      
    }
       
        public double getTimepoPromedio()
    {
        return tiempoTrayecto;
    }
        
        public void setTiempoProyecto(double x)
    {
        tiempoTrayecto=x;   
    }  
        
        public String getNombreConductor(){
    return nombreConductor;
    }
       
        public void setNombreConductor(String nombreConductorP)
    { 
        nombreConductor=nombreConductorP;
    }
    
        public String getNombre()
    {
        return nombre;
    }
   
        public long getID()
    {
        return id;
    }
        
        public double getKilometraje()
    {
        return kilometraje;
    }
       
        public void setKilometraje(double kilometrajeP)
    {
        kilometraje=kilometrajeP;
    } 
        
    public String getLinea()
    {
        return linea;
    }
    
        public double getposicionLatitud()
    {
        return posicionLatitud;
    }
        
        public double getposicionLongitud()
    {
        return posicionLongitud;
    } 
        
        public int getNivelChoque()
    {
        return nivelChoque;
    }
       
        public int getNivelPanico()
    {
        return nivelPanico;
    }
        
     public int getNivelTemparatura()
    {
        return nivelTemperatura;
    }
     
         public void setNombre(String pNombre)
    {
       nombre=pNombre;
    }
         
         public void setLinea(String pLinea)
    {
       linea=pLinea;
    }
         
    public void setPosicionLongitud(double pPos)
    {
       posicionLongitud=pPos;
    }
    
         public void setPosicionLatitud(double pPos)
    {
       posicionLatitud=pPos;
    }
         
         public void setNivelChoque(int pChoque)
    {
         nivelChoque=pChoque;
    }
         
         public void setNivelPanico(int pPanico)
    {
        nivelPanico=pPanico;
    }
         
     public void setNivelTemparatura(int pTemperatura)
    {
       nivelTemperatura=pTemperatura;
    }
   
}
