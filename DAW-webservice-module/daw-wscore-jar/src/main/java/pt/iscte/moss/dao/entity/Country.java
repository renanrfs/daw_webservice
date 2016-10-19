package pt.iscte.moss.dao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @XmlElement(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @XmlElement(name = "name")
    private String name;

    @XmlTransient
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<City> cities;

    public Country() {
    }

    public int getId() {
	return this.id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<City> getCities() {
	return this.cities;
    }

    public void setCities(List<City> cities) {
	this.cities = cities;
    }

    public City addCity(City city) {
	getCities().add(city);
	city.setCountry(this);

	return city;
    }

    public City removeCity(City city) {
	getCities().remove(city);
	city.setCountry(null);

	return city;
    }

}