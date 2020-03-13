package fr.imie.productmanager.dao;

import fr.imie.productmanager.dao.jpa.JpaCategoryDao;
import fr.imie.productmanager.dao.jpa.JpaProductDao;

public class DaoFactory {
	
	private DaoFactory() {
		
	}
	
	public static CategoryDao getCategoryDao() {
		return new JpaCategoryDao();
	}
	
	public static ProductDao getProductDao() {
		return new JpaProductDao();
	}

}
