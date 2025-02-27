<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add cat</title>
	</head>
	<body>
    		<a href="listofCats">Back to list of cats</a><br />
    		<form:form  method="POST" modelAttribute = "catDto">
    			<table border="1">
    				<tbody>
    					<tr>
    						<th>Name</th>
    						<td><form:input type="text" path="name" />
    						<c:if test="${pageContext.request.method=='POST'}">
    						<form:errors path="name" /></c:if></td>
    					</tr>
    					<tr>
    						<th>Date of birth</th>
    						<td><form:input type="text" path="dateofBirth" />
    						<c:if test="${pageContext.request.method=='POST'}"><form:errors path="dateofBirth" /></c:if></td>
    					</tr>
    					<tr>
    						<th>Weight</th>
    						<td><form:input type="text" path="weight" />
    						<c:if test="${pageContext.request.method=='POST'}"><form:errors path="weight" /></c:if></td>
    					</tr>
    					<tr>
    						<th>Name of cat owner</th>
    						<td><form:input type="text" path="nameofOwner" />
    						<c:if test="${pageContext.request.method=='POST'}"><form:errors path="nameofOwner" /></c:if></td>
    					</tr>
    					<tr>
    						<td colspan="2" align="right"><input type="submit" value="ADD!" /></td>
    					</tr>
    				</tbody>
    			</table>
    		</form:form>
    		<br />
    		<hr />
    	</body>
    </html>

