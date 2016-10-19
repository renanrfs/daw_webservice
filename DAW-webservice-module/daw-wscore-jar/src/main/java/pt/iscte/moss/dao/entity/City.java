package pt.iscte.moss.dao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "City.findByCountryId", query = "SELECT c FROM City c WHERE c.country.id = :countryId")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "id")
    private int id;

    @XmlElement(name = "name")
    private String name;

    @ManyToOne
    @XmlElement(name = "country")
    private Country country;

    @XmlTransient
    @OneToMany(mappedBy = "city")
    private List<User> users;

    public City() {
    }

    public City(int id) {
	this.id = id;
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

    public Country getCountry() {
	return this.country;
    }

    public void setCountry(Country country) {
	this.country = country;
    }

    public List<User> getUsers() {
	return this.users;
    }

    public void setUsers(List<User> users) {
	this.users = users;
    }

    public User addUser(User user) {
	getUsers().add(user);
	user.setCity(this);

	return user;
    }

    public User removeUser(User user) {
	getUsers().remove(user);
	user.setCity(null);

	return user;
    }

}