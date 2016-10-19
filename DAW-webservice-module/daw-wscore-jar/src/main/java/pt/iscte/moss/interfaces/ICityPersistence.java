package pt.iscte.moss.interfaces;

import java.util.List;

import pt.iscte.moss.dao.entity.City;

public interface ICityPersistence {

	public List<City> getAllCities(int countryId);
}
