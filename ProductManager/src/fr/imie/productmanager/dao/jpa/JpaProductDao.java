package fr.imie.productmanager.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.productmanager.dao.ProductDao;
import fr.imie.productmanager.entity.Product;
import fr.imie.productmanager.utils.PersistenceManager;

public class JpaProductDao implements ProductDao {
	
	private EntityManagerFactory myEmf = PersistenceManager.getEntityManagerFactory();

	@Override
	public Product findProductById(Long id) {
		EntityManager myEm = myEmf.createEntityManager();
		
		Product myProduct = myEm.find(Product.class, id);
		
		return myProduct;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		EntityManager myEm = myEmf.createEntityManager();
		
		Query myQuery = myEm.createQuery("SELECT product FROM Product AS product");
		
		return myQuery.getResultList();
	}

	@Override
	public void saveProduct(Product myProduct) {
		EntityManager myEm = myEmf.createEntityManager();
		
		EntityTransaction t = myEm.getTransaction();
		
		try {
			t.begin();
			// persist to DB
			myEm.persist(myProduct);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			myEm.close();
		}		
	}

	@Override
	public void removeProduct(Product myProduct) {
		EntityManager myEm = myEmf.createEntityManager();
				
		EntityTransaction t = myEm.getTransaction();
		
		try {
			t.begin();
			myEm.remove(myEm.merge(myProduct));	
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			myEm.close();
		}				
	}
}
