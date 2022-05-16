<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Coupon</title>
</head>
<body>
<h1>Create your Coupon</h1>
<form action="coupons" method="post">
Coupon Code : <input type="text" name ="couponCode"/></br>
Discount    : <input type="text" name="discount"/></br>
Expiry Date : <input type="text" name="expiryDate"/></br>
<input type="hidden" name="action" value="create"/>
<input type="submit" value ="save"/>
</form>
</body>
</html>