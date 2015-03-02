package com.amgen.getResponse.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerService {
	/**
	 * instance variables
	 */
	private static final String PERSISTENCE_UNIT_NAME = "User";
	private static final String PERSISTENCE_UNIT_NAME_SUB = "Subscription";
	private static final String PERSISTENCE_UNIT_NAME_CAM = "Campaign";
	private static final String PERSISTENCE_UNIT_NAME_CH = "Channel";
	private static final String PERSISTENCE_UNIT_NAME_PRD = "Product";
	private static EntityManagerFactory emFactory;
	static Map<String, String> prop = new HashMap<String, String>();
	static ResourceBundle rb;
	
	public void createtables() throws Exception
	{
		
		System.out.println("initializing.......................................");
		Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,prop);
		Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME_SUB,prop);
		Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME_CAM,prop);
		Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME_CH,prop);
		Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME_PRD,prop);
		System.out.println("initialized.......................................");
		
	}

	/**
	 * method provides single entry access point for entityManager
	 * @return 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */

	public static EntityManager getEntityManager(int i) throws  SQLException{
		GetResponseLog log = GetResponseLoggerFactory.getLog("GetResponseLog.class");

		//PropertyConfigurator.configure("resources/log4j.properties");    
	    // final Handler log = GetResponseLog.getRootLogger();

		log.debug("the built-in DEBUG level");
		log.info("the built-in INFO level");
		log.warn("the built-in WARN level");
		log.error("the built-in ERROR level");
		log.fatal("the built-in FATAL level");
		
		log.info("My First Log"); 
		log.warn("Error");
		
		if( log.isDebugEnabled() ){
			log.debug("getEntityManager111111111().. ");
		}

		ResourceBundle rb = ResourceBundle.getBundle("getResponse.properties");

		String driver = rb.getString("db.driver"); 
		String url = rb.getString("db.url"); 
		String username = rb.getString("db.user"); 
		String password = rb.getString("db.password"); 

		prop.put("hibernate.connection.driver_class", driver);
		prop.put("hibernate.connection.url",url);
		prop.put("hibernate.connection.username",username);
		prop.put("hibernate.connection.password",password);

		if(emFactory ==  null)
		{
			switch(i)
			{
			case 0: emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,prop);
			case 1: emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME_SUB,prop);
			}
		} else{
			// use same instance of emFactory
		}
		log.info("getEntityManager().. ");

		return emFactory.createEntityManager();

	}
	
}
