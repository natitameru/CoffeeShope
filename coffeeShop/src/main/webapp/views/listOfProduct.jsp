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
		  
		   <c:forEach var="product" items="${products}"> 
		  
		  <tr>
		    <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.productType}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>    
            <sec:authorize access= "hasRole('ADMIN')">
            
            <td><a href="/products/update">edit</a></td> 
            <td>
             <c:url var="deleteProduct" value="/products/delete/${product.id}"/>
             <form action="${deleteProduct}" method="post">
		      <button type="submit">Delete</button>
	         </form>
	         </td>
	         <td>
	         <sec:authorize access="hasRole('USER')">
			<c:url var="addTocart" value="/products/delete/${product.id}"/>
             <form action="${addTocart}" method="post">
		      <button type="submit">add to cart</button>
	         </form>
			<br>
		</sec:authorize>
	         </td>
            </sec:authorize>      
		  </tr>
		</c:forEach>
		</table>
		<br>
		
		<a href="<c:url value="/home" />"> Back </a>
		
		
		
		
</body>
</html>