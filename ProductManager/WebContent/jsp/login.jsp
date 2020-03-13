<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="/jsp/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="\ProductManager\login" method="post">
  		<label for="username">Username</label>
  		<input type="text" name="username" id="username" Required>
   		<input type="submit" value="Send">
	</form>
</body>
<jsp:include page="/jsp/footer.jsp" />
</html>