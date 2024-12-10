<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista Kotów</title>
</head>
<body>
    <h1>Lista Kotów</h1>

    <c:if test="${not empty cats}">
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Imię</th>
                    <th>Waga</th>
                    <th>Właściciel</th>
                    <th>Data Urodzenia</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cat" items="${cats}">
                    <tr>
                        <td>*****</td>
                        <td>${cat.name}</td>
                        <td>${cat.weight}</td>
                        <td>${cat.nameofMentor}</td>
                        <td><fmt:formatDate value="${cat.dateBirth}" pattern="dd.MM.yyyy" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty cats}">
        <p>Brak kotów w bazie.</p>
    </c:if>
</body>
</html>
