package fr.imie.productmanager.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.productmanager.entity.Category;
import fr.imie.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/basicInsert")
public class BasicInsertServlet extends HttpServlet {
	
	private EntityManagerFactory myEmf;
	
	@Override
	public void init() throws ServletException {		
		myEmf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product myProduct = new Product("The Witcher 3", "The Witcher 3 by CDPR", 35);
		
		Category myCategory = new Category("Videogames");
		myProduct.setCategory(myCategory);
		
		EntityManager myEm = myEmf.createEntityManager();
		
		EntityTransaction t = myEm.getTransaction();
		
		try {
			t.begin();
			// persist to DB
			myEm.persist(myCategory);
			myEm.persist(myProduct);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			myEm.close();
		}
		
		resp.getWriter().println("Product insert with id " + myProduct.getId());
	}
	
	@Override
	public void destroy() {
		if (myEmf != null && myEmf.isOpen()) {
			myEmf.close();
		}
	}	
}
