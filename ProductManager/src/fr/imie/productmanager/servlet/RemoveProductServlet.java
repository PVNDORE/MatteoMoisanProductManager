package fr.imie.productmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet( urlPatterns = "/auth/removeProduct")
public class RemoveProductServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		Product myProduct = DaoFactory.getProductDao().findProductById(id);
		
		DaoFactory.getProductDao().removeProduct(myProduct);
		
		RequestDispatcher myRequestDispatcher = req.getRequestDispatcher("/listProduct");
		
	    myRequestDispatcher.forward(req, resp);				
	}
}
