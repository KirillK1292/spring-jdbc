<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>People list</title>
	</head>
	<body>
		<div>
			<a href="add">Add person</a>
		</div>
		<c:choose>
			<c:when test="${empty people}">
				<h4>No people</h4>
			</c:when>
			<c:otherwise>
				<table border=1>
					<thead>
						<tr>
							<th>ID</th><th>First name</th><th>Last name</th><th>Sex</th><th>Birthdate</th><th>Phone</th><th>Email</th><th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${people}" var="person">
							<tr>
								<td>${person.id}</td><td>${person.firstName}</td><td>${person.lastName}</td><td>${person.sex}</td><td>${person.birthdate}</td><td>${person.phone}</td><td>${person.email}</td><td><a href="edit-${person.id}">Edit</a>	<a href="delete/${person.id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</body>
</html>