<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Persons</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
   User Name: <sec:authentication property="principal.username" />
		</sec:authorize>
	<form>
		<h1></h1>
		<a href="<c:url value="/logout" />">logout </a> <br> <br>
	
		<sec:authorize access="hasRole('ADMIN')">
			<a href="<c:url value="/products/" />">List Product</a>
			<br>
			<a href="<c:url value="/products/addProduct" />">Add Product</a>
			<br>
			<a href="<c:url value="/persons/" />">List Person</a>
			<br>
			<a href="<c:url value="/persons/addPerson" />">Add Person</a>
			<br>
			<a href="<c:url value="/orders/" />">List of Orders</a>
			<br>
		</sec:authorize>
		<sec:authorize access="hasRole('USER')">
			<a href="<c:url value="/orders/order" />">Place Order</a>
			<br>
		</sec:authorize>
	</form>



</body>
</html>