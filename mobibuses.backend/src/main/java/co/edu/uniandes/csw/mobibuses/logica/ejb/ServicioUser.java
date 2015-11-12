/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mobibuses.logica.ejb;

import co.edu.uniandes.csw.mobibuses.dto.User;
import co.edu.uniandes.csw.mobibuses.logica.interfaces.IServicioUserLocal;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.PersistenceManager;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.TransformadorEntityDto;
import co.edu.uniandes.csw.mobibuses.persistencia.mock.UserEntity;
import java.io.Serializable;
import java.util.ArrayList;
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
public class ServicioUser implements IServicioUserLocal, Serializable
{
    @PersistenceContext
    private EntityManager em;

    public ServicioUser() 
    {
         em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        if(darUsers().isEmpty())
          TransformadorEntityDto.getInstance().crearUsuarios(em);
    }
    
    @Override
    public List<User> darUsers() {
        Query q = em.createQuery("SELECT u FROM UserEntity u");
     List<UserEntity> l = q.getResultList();
     List<User> ltr = new ArrayList();
     for(UserEntity te: l)
     {
         ltr.add(TransformadorEntityDto.getInstance().entityADtoUser(te));
     }
     return ltr;
    }

    @Override
    public void registrarUsuario(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarUsuario(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String login(User u) 
    {
        String token = null;
        UserEntity eu = em.find(UserEntity.class, u.getUsuario());
        if(eu!=null)
        {
            if(eu.getPassword().equals(u.getPassword()))
            {
                token = Integer.toHexString(u.hashCode());
                eu.setToken(token);
                em.persist(eu);
            }
            else
            {
                token = "Error";
                eu.setToken(token);
                em.persist(eu);
            }
        }
        else
            {
                token = "Error";
                eu.setToken(token);
                em.persist(eu);
            }
        return token;
    }
}
