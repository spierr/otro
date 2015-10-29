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
    

    public List<User> darUsers();
    
    public void registrarUsuario(User u);
    
    public void modificarUsuario(User u);
    
    public String login(User u);
    
}
