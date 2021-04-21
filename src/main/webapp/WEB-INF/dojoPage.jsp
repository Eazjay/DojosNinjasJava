<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<title>Dojos And Ninjas</title>
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center">${dojo.name} Location Ninjas</h1>
		<table class="table table-striped border mt-5">
			<thead>
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojo.ninjas}" var="ninja">
					<tr>
						<td><c:out value="${ninja.firstName}"></c:out></td>
						<td><c:out value="${ninja.lastName}" /></td>
						<td><c:out value="${ninja.age}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>