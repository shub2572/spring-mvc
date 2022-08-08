
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>

	<form method="post" action="loginAuth">

		Email:<input type="email" name="email" /> <br> Password: <input
			type="password" name="password" /> <br> <input type="submit"
			value="login" />
	</form>
	${msg}
</body>
</html>
