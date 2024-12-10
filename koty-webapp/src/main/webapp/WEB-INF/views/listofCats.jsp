<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>List of cats</title>
</head>
<a href="addCat">Back to add cat</a><br />
<body>
    <h1>List of Cats</h1>

    <c:if test="${not empty cats}">
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Weight</th>
                    <th>Name of cat owner</th>
                    <th>Date of birth</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cat" items="${cats}">
                    <tr>
                      <td><a href="cat-${cat.id}">${cat.id}</a></td>
                        <td>${cat.name}</td>
                        <td>${cat.weight}</td>
                        <td>${cat.nameofMentor}</td>
                        <td><fmt:formatDate value="${cat.dateBirth}" pattern="yyyy.MM.dd" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty cats}">
        <p>No cats in the base.</p>
    </c:if>

</body>
</html>
