
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<body>
	<h2>Sign Up Here</h2>

	<!--  <form  method="post" action="saveuser">
    FirstName:<input type="text" name="firstName" /> <br> 
    LastName:<input type="text" name="lastName" /> <br>
    Email:<input type="email" name="email" /> <br>
    Password:   <input type="password" name="password" /> <br>
   
    <input type="submit" value="signup" />
   </form> -->

	<s:form action="saveuser" method="post" modelAttribute="user">
    FirstName: <s:input path="firstName" />
		<s:errors path="firstName"></s:errors>
		<br>
		<br>
    
    LastName: <s:input path="lastName" />
		<s:errors path="lastName"></s:errors>
		<br>
		<br>
    Email: <s:input path="email" />
		<s:errors path="email"></s:errors>
		<br>
		<br>
    Password: <s:password path="password" />
		<s:errors path="password"></s:errors>
		<br>
		<br>
	gender: 
	    Male: <s:radiobutton path="gender" value="male" name="male"/>
		
     	Female:	<s:radiobutton path="gender" value="female" name="female"/>
		<s:errors path="gender"></s:errors>
		<br>
		<br>

		<input type="submit" value="signup" />
	</s:form>
</body>
</html>