/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public final static String ADMIN = "admin";
    
public final static String USER = "user";
    
   
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
 
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
}
