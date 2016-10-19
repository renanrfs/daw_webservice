package pt.iscte.moss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import pt.iscte.moss.dao.entity.City;
import pt.iscte.moss.dao.entity.Country;
import pt.iscte.moss.dao.entity.User;

/**
 * @author renan.souza
 * 
 */
public class PersistenceWS implements IPersistenceWS {

    /**
     * Persistence Unit
     */
    @PersistenceUnit(unitName = "moss-ws")
    private EntityManagerFactory emf;

    /**
     * Default constructor
     */
    public PersistenceWS() {
	emf = Persistence.createEntityManagerFactory("moss-ws");
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.iscte.moss.interfaces.IUserPersistence#getAllUsers()
     */
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
	EntityManager em = null;
	try {
	    em = emf.createEntityManager();
	    Query query = em.createNamedQuery("User.findAll");
	    return query.getResultList();

	} finally {
	    if (null != em) {
		em.close();
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.iscte.moss.interfaces.IUserPersistence#getUser(int)
     */
    public User getUser(int userId) {
	EntityManager em = null;
	try {
	    em = emf.createEntityManager();
	    Query query = em.createNamedQuery("User.findById");
	    query.setParameter("userId", userId);
	    User user = (User) query.getSingleResult();
	    return user;

	} finally {
	    if (null != em) {
		em.close();
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.iscte.moss.interfaces.IUserPersistence#createUser(pt.iscte.moss.dao
     * .entity.User)
     */
    public int createUser(User user) {
	EntityManager em = null;
	try {
	    em = emf.createEntityManager();
	    em.getTransaction().begin();
	    user = em.merge(user);
	    em.getTransaction().commit();

	    return user.getId();
	} catch (Exception e) {
	    em.getTransaction().rollback();
	    throw new RuntimeException(e);

	} finally {
	    if (null != em) {
		em.close();
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.iscte.moss.interfaces.IUserPersistence#updateUser(pt.iscte.moss.dao
     * .entity.User)
     */
    public boolean updateUser(User user) {
	EntityManager em = null;
	try {
	    em = emf.createEntityManager();
	    em.getTransaction().begin();
	    user = em.merge(user);
	    em.getTransaction().commit();

	    return true;
	} catch (Exception e) {
	    em.getTransaction().rollback();
	    throw new RuntimeException(e);

	} finally {
	    if (null != em) {
		em.close();
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.iscte.moss.interfaces.IUserPersistence#deleteUser(int)
     */
    public boolean deleteUser(int userId) {
	EntityManager em = null;
	try {
	    em = emf.createEntityManager();
	    User user = em.find(User.class, userId);

	    em.getTransaction().begin();
	    em.remove(user);
	    em.getTransaction().commit();

	    return true;
	} catch (Exception e) {
	    em.getTransaction().rollback();
	    throw new RuntimeException(e);

	} finally {
	    if (null != em) {
		em.close();
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.iscte.moss.interfaces.ICountryPersistence#getAllCountries()
     */
    @SuppressWarnings("unchecked")
    public List<Country> getAllCountries() {
	EntityManager em = null;
	try {
	    em = emf.createEntityManager();
	    Query query = em.createNamedQuery("Country.findAll");
	    return query.getResultList();

	} finally {
	    if (null != em) {
		em.close();
	    }
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.iscte.moss.interfaces.ICityPersistence#getAllCities(int)
     */
    @SuppressWarnings("unchecked")
    public List<City> getAllCities(int countryId) {
	EntityManager em = null;
	try {
	    em = emf.createEntityManager();
	    Query query = em.createNamedQuery("City.findByCountryId");
	    query.setParameter("countryId", countryId);
	    return query.getResultList();

	} finally {
	    if (null != em) {
		em.close();
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.presmon.content.provider.dao.IPresmonPersistence#destroy()
     */
    public void destroy() {
	if (null != emf) {
	    emf.close();
	}
    }
}
