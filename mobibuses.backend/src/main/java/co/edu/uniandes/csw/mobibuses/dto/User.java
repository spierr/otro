package co.edu.uniandes.csw.mobibuses.dto;

/**
 *
 * @author s.correa12
 */
public class User {
    
    private long id;
    
    private String usuario;
    
    private String password;
    
    private String rol;
    
    private String token;
    
    public static final String ADMIN = "admin";
    
public static final String USERNAME = "user";
    
   
    public User()
    {
        
    }

    public User(long id, String usuario, String password, String rol, String token) {
      
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
        this.token = token;
    }
 
    
    /**
     * da el usuario
     * @return usuario
     */
    
    public String getUsuario() {
        return usuario;
    }
    
    /**
     * define el usuario
     * @param usuario nuevo usuario a definir
     */

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    /**
     * da la contraseña del usuario
     * @return contraseña del usuario
     */

    public String getPassword() {
        return password;
    }
    
    
    /**
     * define contraseña del usuario
     * @param password  constraseña del usuario
     */

    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * da el rol del usuario
     * @return  rol del usuario
     */

    public String getRol() {
        return rol;
    }
    
    /**
     * define el rol del usuario
     * @param rol rol del usuario
     */

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    /**
     *token  que garantiza autenticacion del usuario para usar el servicio
     * @return token
     */

    public String getToken() {
        return token;
    }

    /**
     * define token del usuario
     * @param token que garantiza autenticacion del usuario para usar el servicio
     */
    
    public void setToken(String token) {
        this.token = token;
    }
    
    
    /**
     * da el id del usurio
     * @return id del usuario
     */

    public long getId() {
        return id;
    }
    
    
    /**
     * define id del usuario
     * @param id nuevo id del usuario
     */

    public void setId(long id) {
        this.id = id;
    }
    
    
    
}
