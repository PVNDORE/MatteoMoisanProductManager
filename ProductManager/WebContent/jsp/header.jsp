<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
	<a href="/ProductManager/listProduct">List Product</a>	
	<c:choose>
	    <c:when test="${not empty sessionScope.username}">
	    	<a href="/ProductManager/auth/addProduct">Add Product</a>
			<a href="/ProductManager/auth/addCategory">Add Category</a>
			<a href="/ProductManager/logout">Logout</a>	
	    </c:when>
	    <c:otherwise>
	        <a href="/ProductManager/login">Login</a>
	    </c:otherwise>    
	</c:choose>		
</div>
<br>
<div>
	<c:choose>
	    <c:when test="${not empty sessionScope.username}">
			Welcome <c:out value="${sessionScope.username}" /> !
		</c:when>    
	</c:choose>	
</div>
<br>