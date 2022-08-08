<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Security Question</title>
</head>
<body>
<h2>Set Security Question And Answer</h2>

<form action="savequestionans" method="post">

   Question: <select name="question">
							<option value="Your pet name">Your pet name </option>
				    		<option value="Your first Bestfriend name"> Your first Bestfriend name</option>
				    		<option value="Your birthplace">Your birthplace</option>
				    </select>
				    <br><br>
		Answer : <input type="text" name="ans"><br><br>
		<input type="submit" value="Set"/> 

</form>
</body>
</html>