<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Coupon</title>
</head>
<body>
<h1>Find your Coupon</h1>
<form action="coupons" method="post">
Coupon Code : <input type="text" name ="couponCode"/></br>
<input type="hidden" name="action" value="find"/>

<input type="submit" value ="find"/>
</form>
</body>
</html>