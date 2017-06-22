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
<title>List of orders</title>
</head>
<body style="font-size: 25px;">

	<a href="<c:url value="/logout" />"> LogOut </a>
	<br>
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


	<br>


	<a href="<c:url value="/orders/manage" />"> Back </a>




</body>
</html>