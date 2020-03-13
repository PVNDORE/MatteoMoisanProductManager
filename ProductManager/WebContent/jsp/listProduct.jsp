<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/jsp/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Product</title>
</head>
<body>
	<h1>List Product</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Category</th>
			<th>Delete</th>
		</tr>	
		<c:forEach items="${requestScope.myProductList}" var="myProduct">
			<tr>
				<td>${myProduct.id}</td>
				<td><a href="/ProductManager/showProduct?id=${myProduct.id}">${myProduct.name}</a></td>
				<td>${myProduct.description}</td>
				<td>${myProduct.price}</td>
				<td>${myProduct.category.name}</td>
				<td>
					<form action="/ProductManager/auth/removeProduct" method="post">
						<input type="hidden" name="id" value="${myProduct.id}" Required>
	   					<input type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
<jsp:include page="/jsp/footer.jsp" />
</html>