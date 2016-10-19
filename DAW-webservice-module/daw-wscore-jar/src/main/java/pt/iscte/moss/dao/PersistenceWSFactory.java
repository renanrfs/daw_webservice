package pt.iscte.moss.dao;

/**
 * @author renan.souza
 * 
 */
public class PersistenceWSFactory {

	/**
	 * The PRT persistence instance.
	 */
	private static IPersistenceWS instance = null;

	/**
	 * Default constructor.
	 */
	private PersistenceWSFactory() {
	}

	/**
	 * Get the instance.
	 * 
	 * @return The instance.
	 */
	public static IPersistenceWS getInstance() {
		if (null == instance) {
			instance = new PersistenceWS();
		}
		return instance;
	}

}
