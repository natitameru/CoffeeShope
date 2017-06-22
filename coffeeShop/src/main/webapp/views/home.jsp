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
<title>List of Persons</title>
</head>
<body  style="font-size: 20px;">
	<sec:authorize access="isAuthenticated()">
   User Name: <sec:authentication property="principal.username" />
		</sec:authorize>
	<form>
		<h1></h1>
		<a href="<c:url value="/logout" />">logout </a> <br> <br>
	
		<sec:authorize access="hasRole('ADMIN')">
			<a href="<c:url value="/products/" />">List Product    |</a>
		
			<a href="<c:url value="/products/addProduct" />">Add Product  |</a>
		
			<a href="<c:url value="/persons/" />">List Person   |</a>
		
			<a href="<c:url value="/persons/addPerson" />">Add Person   |</a>
		
			<a href="<c:url value="/orders/" />">List of Orders   |</a>
			
		</sec:authorize>
		<sec:authorize access="hasRole('USER')">
			<a href="<c:url value="/orders/order" />">Place Order</a>
			<br>
			<div >

		<table >
			<tr>
				<td colspan="10" align="center"><h2>List of Orders</h2></td>
			</tr>
			<tr>
				<td>User first Name</td>
				<td>User Last Name</td>
				<td>Order Date</td>
				<td>prodctName</td>
				<td>product Type</td>
				<td>Quanity</td>
				<td>product price</td>
			</tr>

			<c:forEach var="order" items="${orders}">
				<c:forEach var="orderLine" items="${order.orderLines}">

					<tr>
						<td align="center">${orderLine.order.person.firstName}</td>
						<td align="center">${orderLine.order.person.lastName}</td>
						<td align="center">${orderLine.order.orderDate}</td>

						<td align="center">${orderLine.product.productName}</td>
						<td align="center">${orderLine.product.productType}</td>
						<td align="center">${orderLine.quantity}</td>

						<td align="center">${orderLine.product.price}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
	</div>
		</sec:authorize>
	</form>



</body>
</html>