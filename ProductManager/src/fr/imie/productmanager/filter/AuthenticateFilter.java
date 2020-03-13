package fr.imie.productmanager.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebFilter(urlPatterns="/auth/*")
public class AuthenticateFilter extends HttpFilter {
	
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpSession mySession = req.getSession();		
		String username = (String) mySession.getAttribute("username");
		
		if(username != null) {			
			chain.doFilter(req, resp);
		}else {
			resp.sendRedirect("/ProductManager/jsp/login.jsp");
		}		
	}
}
