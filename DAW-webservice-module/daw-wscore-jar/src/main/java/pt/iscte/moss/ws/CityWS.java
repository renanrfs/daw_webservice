package pt.iscte.moss.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.iscte.moss.dao.PersistenceWSFactory;
import pt.iscte.moss.dao.entity.City;
import pt.iscte.moss.interfaces.ICityPersistence;

@Path("city")
public class CityWS implements ICityPersistence {

	@GET
	@Path("{countryId}")
	@Produces(MediaType.TEXT_XML)
	public List<City> getAllCities(@PathParam("countryId") int countryId) {
		return PersistenceWSFactory.getInstance().getAllCities(countryId);
	}

}
