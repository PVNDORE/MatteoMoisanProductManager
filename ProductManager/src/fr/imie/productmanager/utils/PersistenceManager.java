package fr.imie.productmanager.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	
	private static EntityManagerFactory myEmf;
	
	// Singleton
	public static EntityManagerFactory getEntityManagerFactory() {
		if(myEmf == null) {
			myEmf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
		}
		return myEmf;
	}
	
	public static void closeEmf() {
		if(myEmf != null && myEmf.isOpen()) {
			myEmf.close();
		}
	}
}
