package pt.iscte.moss.ws;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.iscte.moss.dao.PersistenceWSFactory;
import pt.iscte.moss.dao.entity.City;
import pt.iscte.moss.dao.entity.ResponseWS;
import pt.iscte.moss.dao.entity.User;
import pt.iscte.moss.interfaces.IUserPersistence;

@Path("/user")
public class UserWS implements IUserPersistence {

    @GET
    @Path("/getall")
    @Produces(MediaType.TEXT_XML)
    public List<User> getAllUsers() {
	return PersistenceWSFactory.getInstance().getAllUsers();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.TEXT_XML)
    public User getUser(@PathParam("userId") int id) {
	return PersistenceWSFactory.getInstance().getUser(id);
    }

    @POST
    @Produces(MediaType.TEXT_XML)
    public ResponseWS createUser(@FormParam("name") String name,
	    @FormParam("username") String username,
	    @FormParam("password") String password,
	    @FormParam("email") String email, @FormParam("site") String site,
	    @FormParam("cityId") int cityId) {

	User user = new User(name, username, password, email, site, new City(
		cityId));
	int userId = PersistenceWSFactory.getInstance().createUser(user);
	return new ResponseWS(userId);
    }

    @PUT
    @Produces(MediaType.TEXT_XML)
    public ResponseWS updateUser(@FormParam("id") int id,
	    @FormParam("name") String name,
	    @FormParam("username") String username,
	    @FormParam("password") String password,
	    @FormParam("email") String email, @FormParam("site") String site,
	    @FormParam("cityId") int cityId) {

	User user = new User(id, name, username, password, email, site,
		new City(cityId));
	boolean isUpdate = PersistenceWSFactory.getInstance().updateUser(user);
	return new ResponseWS(isUpdate);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public ResponseWS deleteUser(@PathParam("id") int id) {
	boolean isDelete = PersistenceWSFactory.getInstance().deleteUser(id);
	return new ResponseWS(isDelete);
    }
}
