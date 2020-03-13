package fr.imie.productmanager.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.productmanager.dao.CategoryDao;
import fr.imie.productmanager.entity.Category;
import fr.imie.productmanager.utils.PersistenceManager;

public class JpaCategoryDao implements CategoryDao {
	
	private EntityManagerFactory myEmf = PersistenceManager.getEntityManagerFactory();
		
	@Override
	public Category findCategoryById(Long id) {
		EntityManager myEm = myEmf.createEntityManager();
		
		Category myCategory = myEm.find(Category.class, id);
		
		return myCategory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		EntityManager myEm = myEmf.createEntityManager();
		
		Query myQuery = myEm.createQuery("SELECT category FROM Category AS category");
		
		return myQuery.getResultList();
	}

	@Override
	public void saveCategory(Category myCategory) {
		EntityManager myEm = myEmf.createEntityManager();
		
		EntityTransaction t = myEm.getTransaction();
		
		try {
			t.begin();
			// persist to DB
			myEm.persist(myCategory);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			myEm.close();
		}		
	}
}
