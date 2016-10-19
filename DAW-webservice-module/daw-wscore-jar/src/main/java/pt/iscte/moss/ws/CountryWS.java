package pt.iscte.moss.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.iscte.moss.dao.PersistenceWSFactory;
import pt.iscte.moss.dao.entity.Country;
import pt.iscte.moss.interfaces.ICountryPersistence;

@Path("country")
public class CountryWS implements ICountryPersistence {

	@GET
	@Path("/getall")
	@Produces(MediaType.TEXT_XML)
	public List<Country> getAllCountries() {
		return PersistenceWSFactory.getInstance().getAllCountries();
	}

}
