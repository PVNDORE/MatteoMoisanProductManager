package fr.imie.productmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet( urlPatterns = "/cheaper")
public class CheaperProductsServlet extends HttpServlet {
	
	private EntityManagerFactory myEmf;
	
	@Override
	public void init() throws ServletException {
		myEmf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager myEm = myEmf.createEntityManager();
		
		Query myQuery = myEm.createQuery("SELECT product FROM Product AS product WHERE product.price<100");
		
		List<Product>myProductListUnder100 = myQuery.getResultList();
		
		req.setAttribute("myProductList", myProductListUnder100);
		
		req.getRequestDispatcher("/jsp/listProduct.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {
		if (myEmf != null && myEmf.isOpen()) {
			myEmf.close();
		}
	}

}
