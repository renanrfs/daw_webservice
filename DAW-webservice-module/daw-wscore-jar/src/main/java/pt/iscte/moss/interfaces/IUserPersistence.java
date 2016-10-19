package pt.iscte.moss.interfaces;

import java.util.List;

import pt.iscte.moss.dao.entity.ResponseWS;
import pt.iscte.moss.dao.entity.User;

public interface IUserPersistence {

    public List<User> getAllUsers();

    public User getUser(int id);

    public ResponseWS createUser(String name, String username, String password,
	    String email, String site, int cityId);

    public ResponseWS updateUser(int id, String name, String username,
	    String password, String email, String site, int cityId);

    public ResponseWS deleteUser(int id);

}
