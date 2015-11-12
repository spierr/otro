/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.logica.interfaces;

import co.edu.uniandes.csw.mobibuses.dto.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author s.correa12
 */
@Local
public interface IServicioUserLocal {
    
/**
 * interface
 * @return 
 */
    public List<User> darUsers();
    
    
    /**
     * interface
     * @param u 
     */
    
    public void registrarUsuario(User u);
    
    /**
     * interface
     * @param u 
     */
    
    public void modificarUsuario(User u);
    
    /**
     * interface
     * @param u
     * @return 
     */
    
    public String login(User u);
    
}
