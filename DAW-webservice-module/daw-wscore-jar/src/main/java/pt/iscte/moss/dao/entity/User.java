package pt.iscte.moss.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :userId") })
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement(name = "id")
    private int id;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "password")
    private String password;

    @XmlElement(name = "site")
    private String site;

    @XmlElement(name = "username")
    private String username;

    @ManyToOne
    private City city;

    public User() {
    }

    public User(int id, String name, String username, String password,
	    String email, String site, City city) {
	this(name, username, password, email, site, city);
	this.id = id;
    }

    public User(String name, String username, String password, String email,
	    String site, City city) {
	this.email = email;
	this.name = name;
	this.password = password;
	this.site = site;
	this.username = username;
	this.city = city;
    }

    public int getId() {
	return this.id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getEmail() {
	return this.email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getSite() {
	return this.site;
    }

    public void setSite(String site) {
	this.site = site;
    }

    public String getUsername() {
	return this.username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public City getCity() {
	return this.city;
    }

    public void setCity(City city) {
	this.city = city;
    }

}