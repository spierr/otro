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
       
       /**
        * da el tiempo promedio de un tranvia
        * @return el tiempo promedio de un tranvia
        */
       
        public double getTimepoPromedio()
    {
        return tiempoTrayecto;
    }
        
        
        /**
         * modifica el tiempo promedio d eun tranvia
         * @param x nuevo tiempo promedio
         */
        
        public void setTiempoProyecto(double x)
    {
        tiempoTrayecto=x;   
    }  
        
       /**
        * da el nombre del conductor del tranvia
        * @return nombre del conductor del tranvia
        */ 
        
        public String getNombreConductor(){
    return nombreConductor;
    }
        
        
        /**
         * define el nombre del conductor del tranvia
         * @param nombreConductorP nombre del conductr del tranvia a asignar
         */
       
        public void setNombreConductor(String nombreConductorP)
    { 
        nombreConductor=nombreConductorP;
    }
    
        
        /**
         * da el nombre del tranvia
         * @return nombre del tranvia
         */
        
        public String getNombre()
    {
        return nombre;
    }
        
        
        /**
         * da el id del tranvia
         * @return  id del tranvia
         */
   
        public long getID()
    {
        return id;
    }
        
        
        /**
         * da el kilometraje del tranvia
         * @return kilometraje del tranvia
         */
        
        public double getKilometraje()
    {
        return kilometraje;
    }
        
        
        /**
         * modificar kilometraje del tranvia
         * @param kilometrajeP nuevo kilometraje del tranvia
         */
       
        public void setKilometraje(double kilometrajeP)
    {
        kilometraje=kilometrajeP;
    } 
        
        
        
        /**
         * da la linea a la que pertenece el tranvia
         * @return linea a la que pertenece el tranvia
         */
        
    public String getLinea()
    {
        return linea;
    }
    
    
    /**
     * da la latitud
     * @return latitud geografica 
     */
    
        public double getposicionLatitud()
    {
        return posicionLatitud;
    }
        
        
        /**
         * da la longitud
         * @return longitud geografica
         */
        
        public double getposicionLongitud()
    {
        return posicionLongitud;
    } 
        
        
        /**
         * da el nivel de choque
         * @return nivel de choque
         */
        
        public int getNivelChoque()
    {
        return nivelChoque;
    }
        
        /**
         * da el nivel de panico
         * @return nivel de panico
         */
       
        public int getNivelPanico()
    {
        return nivelPanico;
    }
        
        /**
         * da el nivel de temperatura
         * @return temperatura
         */
        
     public int getNivelTemparatura()
    {
        return nivelTemperatura;
    }
     
     /**
      * define el nombre del tranvia
      * @param pNombre nombre del tranvia
      */
     
         public void setNombre(String pNombre)
    {
       nombre=pNombre;
    }
         
         
         /**
          * define la linea a la que pertenece el tranvia
          * @param pLinea line del a la que pertenece el tranvia
          */
         
         public void setLinea(String pLinea)
    {
       linea=pLinea;
    }
         
         
         /**
          * define longitud
          * @param pPos longitud geografica
          */
         
    public void setPosicionLongitud(double pPos)
    {
       posicionLongitud=pPos;
    }
    
    
    /**
     * define latitud
     * @param pPos latitud geografica
     */
    
         public void setPosicionLatitud(double pPos)
    {
       posicionLatitud=pPos;
    }
         
         
         /**
          * define nivel de choque
          * @param pChoque nuevo nivel de choque
          */
         
         public void setNivelChoque(int pChoque)
    {
         nivelChoque=pChoque;
    }
         
         
         /**
          * define nivel de panico 
          * @param pPanico nuevo nivel de panico
          */
         
         public void setNivelPanico(int pPanico)
    {
        nivelPanico=pPanico;
    }
         
         
         /**
          * define nivel de temperatur
          * @param pTemperatura nueva temperatura
          */
         
     public void setNivelTemparatura(int pTemperatura)
    {
       nivelTemperatura=pTemperatura;
    }
   
}
