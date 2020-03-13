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
import fr.imie.productmanager.entity.Category;
import fr.imie.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		Float price = Float.parseFloat(req.getParameter("price"));
		Long idCategory = Long.parseLong(req.getParameter("category"));
		
		Category myCategory = DaoFactory.getCategoryDao().findCategoryById(idCategory);
		
		Product myProduct = new Product(name, description, price);
		myProduct.setCategory(myCategory);	
		
		DaoFactory.getProductDao().saveProduct(myProduct);
						
		resp.sendRedirect("/ProductManager/showProduct?id="+myProduct.getId());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
						
		List<Category>myCategoryList = DaoFactory.getCategoryDao().getAllCategories();
		
		req.setAttribute("myCategoryList", myCategoryList);
		
		RequestDispatcher myRequestDispatcher = req.getRequestDispatcher("/jsp/auth/addProduct.jsp");
		
	    myRequestDispatcher.forward(req, resp);
	}
}
