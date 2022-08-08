<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search User</title>
</head>
<body>
<h2>Enter the firstName you want to search</h2>
    <form action="searchuser" method="post"> 
    <input type="text" value="firstName"/>
    <button type="submit" name="search" class="btn btn-primary">Search</button>

    </form>
</body>
</html>