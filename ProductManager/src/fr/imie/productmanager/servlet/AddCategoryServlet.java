package fr.imie.productmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.entity.Category;

@SuppressWarnings("serial")
@WebServlet( urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String categoryName = req.getParameter("category");
		
		Category myCategory = new Category(categoryName);
		
		DaoFactory.getCategoryDao().saveCategory(myCategory);
		
		resp.getWriter().println("Category insert with id " + myCategory.getId());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher myRequestDispatcher = req.getRequestDispatcher("/jsp/auth/addCategory.jsp");
		
	    myRequestDispatcher.forward(req, resp);		
	}
}
