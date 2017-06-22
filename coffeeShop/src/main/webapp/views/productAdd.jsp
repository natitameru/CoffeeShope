<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products List</title>
<style type="text/css">
    .container {
        width: 500px;
    }
    .container input {
        width: 100%;    
    }
    </style>
</head>
<body style="font-size: 25px;">	
<div class="container">
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
		</div>>
</body>
</html>