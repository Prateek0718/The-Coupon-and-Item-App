<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Item</title>
</head>
<body>
<h1>Create your Item</h1>
<form action="items" method="post">
Name           : <input type="text" name ="name"/></br>
Description    : <input type="text" name="description"/></br>
Price 		   : <input type="text" name="price"/></br>
Coupon Code	   : <input type="text" name="couponCode"/></br>
<input type="submit" value ="save"/>
</form>
</body>
</html>