<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:include page="/jsp/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Product</title>
</head>
<body>
	<h1>Show Product</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Category</th>
			<th>Delete</th>
		</tr>
		<tr>
			<td>${requestScope.myProduct.id}</td>
			<td><a href="/ProductManager/showProduct?id=${requestScope.myProduct.id}">${requestScope.myProduct.name}</a></td>
			<td>${requestScope.myProduct.description}</td>
			<td>${requestScope.myProduct.price}</td>
			<td>${requestScope.myProduct.category.name}</td>
			<td>
				<form action="/ProductManager/auth/removeProduct" method="post">
					<input type="hidden" name="id" value="${requestScope.myProduct.id}" Required>
   					<input type="submit" value="Delete">
				</form>
			</td>
		</tr>
	</table>
</body>
<jsp:include page="/jsp/footer.jsp" />
</html>