<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List of cats</title>
	</head>
	<body>
		<a href="<c:url value="add" />">Add cat</a><br />
		<table border="1">
			<thead>
				<tr>
					<th>#</th>
					<th>Name of cat</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="cat" item="${cats}" varStatus = "status"
				<tr>
					<td>${status.index}</td>
					<td><a href="<c:url value="cat-${status.index}" />">${cat.name}</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<hr />
		</body>
</html>