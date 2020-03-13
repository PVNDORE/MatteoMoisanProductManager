<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:include page="/jsp/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
</head>
<body>
	<h1>Add Category</h1>
	<form action="/ProductManager/auth/addCategory" method="post">
  		<label for="category">Category</label>
  		<input type="text" name="category" id="category" Required>
   		<input type="submit" value="Send">
	</form>
</body>
<jsp:include page="/jsp/footer.jsp" />
</html>