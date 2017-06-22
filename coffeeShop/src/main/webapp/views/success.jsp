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
</head>
<body>	
		 <a href="<c:url value="/logout" />">logout </a>	
		<br> 
		<br>		
		<h2>List of products</h2>
		<table>
		  <tr>
		  <td>Product ID</td>
		  <td>Product Name</td>
		  <td>Product Type</td>
		  <td>Price</td>
		  <td>Description</td>
		 
		  </tr>
		  
		   <c:forEach var="OrderedProducts" items="${OrderedProducts}"> 
		  
		  <tr>
		    <td>${OrderedProducts.id}</td>
            <td>${OrderedProducts.productName}</td>
            <td>${OrderedProducts.productType}</td>
            <td>${OrderedProducts.price}</td>
            <td>${OrderedProducts.description}</td>    
               
		  </tr>
		</c:forEach>
		</table>
		<br>
		Total price to pay :<p>${totalPayment}</p>
		<a href="<c:url value="/orders/pay" />"> pay </a>
		<a href="<c:url value="/home" />"> Back </a>
		
		
		
		
</body>
</html>