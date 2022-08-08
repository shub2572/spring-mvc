<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add profile</title>
</head>
<body>
<h2>Add Profile File</h2>

<form action="saveprofiles" method="post" enctype="multipart/form-data">

Profile Picture: <input type="file" name="profile">
   <input type="submit" value="Upload Profile">

</form>
</body>
</html>