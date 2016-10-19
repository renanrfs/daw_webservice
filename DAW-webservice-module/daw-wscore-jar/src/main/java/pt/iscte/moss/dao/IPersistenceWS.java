package pt.iscte.moss.dao;

import java.util.List;

import pt.iscte.moss.dao.entity.User;
import pt.iscte.moss.interfaces.ICityPersistence;
import pt.iscte.moss.interfaces.ICountryPersistence;

/**
 * @author renan.souza
 * 
 */
public interface IPersistenceWS extends ICountryPersistence, ICityPersistence {

    public List<User> getAllUsers();

    public User getUser(int userId);

    public int createUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(int userId);
}
