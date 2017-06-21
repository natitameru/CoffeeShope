<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products List</title>
</head>
<body>	
		<h1>Add a new product</h1>
		<a href="<c:url value="/logout" />"> LogOut </a> 
		<br> 
		
		<c:url var="addProductUrl" value="/products/productAdd"/>
		<form action="${addProductUrl}" method="post">
		
		<p>Product Name: <input type="text" name="productName" value="${product.productName}"></p>
		<p>Description:: <input type="text" name="description" value="${product.description}"></p>
		<p>Price $: <input type="text" name="price" value="${product.price}"></p>
		<p>Product Type: <input type="text" name="productType" value="${product.productType}"></p>
		<p> <input type="submit" value="Create Product"></p>
		
		</form>
 		
		
		
		
		
		<a href="<c:url value="/home" />"> Back </a>
		
</body>
</html>