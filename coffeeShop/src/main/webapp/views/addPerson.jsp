<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add person</title>
</head>
<body>	
		<h1>Add a new person</h1>
		<a href="<c:url value="/logout" />"> LogOut </a> 
		<br> 
		
		<c:url var="addPersonUrl" value="/persons/addPerson"/>
		<form action="${addPersonUrl}" method="post">
		
		<p>Enter user Name:<input type="text" name="userName" value="${userCredential.userName}"></p>
		<p>Enter Password:<input type="text" name="password" value="${userCredential.password}"></p>
		<p>First name:<input type="text" name="firstName" value="${person.firstName}"></p>
		<p>Last name:<input type="text" name="lastName" value="${person.lastName}"></p>
		<p>email: <input type="text" name="email" value="${person.email}"></p>
		<p>Phone: <input type="text" name="phone" value="${person.phone}"></p>
		<p>City: <input type="text" name="address.city" value="${person.address.city}"></p>
		<p>State: <input type="text" name="address.state" value="${person.address.state}"></p>
		<p>Country: <input type="text" name="address.country" value="${person.address.country}"></p>
	    <p>Zip Code: <input type="text" name="address.zipcode" value="${person.address.zipcode}">	 </p>  
		<p> <input type="submit" value="Create Person"></p>
		</form>
 		
		
		
		
		
		<a href="<c:url value="/home" />"> Back </a>
		
</body>
</html>