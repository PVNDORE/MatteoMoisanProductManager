<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<jsp:include page="/jsp/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h1>Add Product</h1>
	<form action="/ProductManager/auth/addProduct" method="post">
  		<label for="name">Name</label><input type="text" name="name" id="name" Required>
  		<label for="description">Description</label><input type="text" name="description" id="description" >
  		<label for="price">Price</label><input type="number" name="price" id="price" Required>
  		<label for="category">Category</label>
  		<select name="category" id="category-select">
		    <option value="">--Please choose an option--</option>
		    <c:forEach items="${requestScope.myCategoryList}" var="myCategory">
		    	<option value="${myCategory.id}">${myCategory.name}</option>
		    </c:forEach>		    
		</select>
   		<input type="submit" value="Send">
	</form>
</body>
<jsp:include page="/jsp/footer.jsp" />
</html>