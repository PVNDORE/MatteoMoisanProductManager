package fr.imie.productmanager.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.imie.productmanager.utils.PersistenceManager;

@WebListener
public class PersistenceAppListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("PersistenceAppListener - contextInitialized");
		PersistenceManager.getEntityManagerFactory();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("PersistenceAppListener - contextDestroyed");
		PersistenceManager.closeEmf();		
	}

}
