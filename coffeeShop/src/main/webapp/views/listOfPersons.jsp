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
<title>Persons List</title>
</head>
<body style="font-size: 20px;">	
		 <a href="<c:url value="/logout" />">logout </a>	
		<br> 
		<br>		
		
		<table>
		<tr>
				<td colspan="20" align="center"><h2>List of Person</h2></td>
			</tr>
		  <tr>
		  <td colspan="10">Person ID</td>
		  <td colspan="10">First Name</td>
		  <td colspan="10">Last Name</td>
		  <td colspan="10">Address</td>
		  <td colspan="10">Phone</td>
		 
		  </tr>
		  
		   <c:forEach var="person" items="${persons}"> 

		  <tr>
		    <td colspan="10">${person.id}</td>
            <td colspan="10">${person.firstName}</td>
            <td colspan="10">${person.lastName}</td>
            <td colspan="10">${person.address.city}${' '}${person.address.state}${' '}${person.address.country}${' '}${person.address.zipcode}
            </td >
            <td colspan="10">${person.phone}</td>    
            <sec:authorize access= "hasRole('ADMIN')">
            
            <td colspan="10">
             <c:url var="deletePerson" value="/persons/delete/${person.id}"/>
             <form action="${deletePerson}" method="post">
		      <button type="submit">Delete</button>
	         </form>
	         </td>
            </sec:authorize>      
		  </tr>
		</c:forEach>
		</table>
		<br>
		
		<a href="<c:url value="/home" />"> Back </a>
		
		
		
		
</body>
</html>