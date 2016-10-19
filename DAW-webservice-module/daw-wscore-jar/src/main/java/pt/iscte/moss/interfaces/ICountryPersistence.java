package pt.iscte.moss.interfaces;

import java.util.List;

import pt.iscte.moss.dao.entity.Country;

public interface ICountryPersistence {

	public List<Country> getAllCountries();
}
