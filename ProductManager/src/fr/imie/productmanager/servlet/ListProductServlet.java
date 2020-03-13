package fr.imie.productmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/listProduct")
public class ListProductServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> myProductList = DaoFactory.getProductDao().getAllProducts();
				
		req.setAttribute("myProductList", myProductList);
		
		RequestDispatcher myRequestDispatcher = req.getRequestDispatcher("/jsp/listProduct.jsp");
		
	    myRequestDispatcher.forward(req, resp);
	}

}
