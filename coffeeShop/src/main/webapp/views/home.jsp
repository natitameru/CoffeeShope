<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form>
	<h1>Admin Page</h1> <a href="<c:url value="/logout" />">logout </a>	
		
	  <br>
	  <br>
	 <sec:authorize access= "hasRole('ADMIN')">
	<a href="<c:url value="/products/" />">List Product</a> <br>
	<a href="<c:url value="/products/addProduct" />">Add Product</a> <br>
	<a href="<c:url value="/products/" />">List Person</a> <br>
	<a href="<c:url value="/products/addProduct" />">Add Person</a> <br>
	</sec:authorize>
	<sec:authorize access= "hasRole('USER')">
	<a href="<c:url value="/persons" />">List Person</a><br>	
	</sec:authorize>
		</form>
		
		
		
</body>
</html>