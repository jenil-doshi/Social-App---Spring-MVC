<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
		tr:nth-child(1){
			font-weight: bold;
			background-color: #C6C9C4;
		}
		tr:nth-child(3){
			font-weight: bold;
			background-color: #C6C9C4;
		}
		tr:nth-child(5){
			font-weight: bold;
			background-color: #C6C9C4;
		}
		td { 
		    padding: 10px;
		}
	</style>
</head>
<body>
<table>
		<tr>
			<td>ID</td><td>FIRSTNAME</td><td>LASTNAME</td><td>EMAIL</td><td>CITY</td><td>State</td><td>STREET</td><td>ZIP</td>
		</tr>
		<tr>
			<td>${person.id}</td>
			<td>${person.firstname}</td>
			<td>${person.lastname}</td>
			<td>${person.email}</td>
			<td>${person.address.city}</td>
			<td>${person.address.state}</td>
			<td>${person.address.street}</td>
			<td>${person.address.zip}</td>
		</tr>
		<tr>
			<td>Org-Name</td><td>Description</td><td>ORG-CITY</td><td>ORG-State</td><td>ORG-STREET</td><td>ORG-ZIP</td>
		</tr>
			<tr>
			<td>${person.org.name}</td>
			<td>${person.org.description}</td>
			<td>${person.org.address.city}</td>
			<td>${person.org.address.state}</td>
			<td>${person.org.address.street}</td>
			<td>${person.org.address.zip}</td>
		</tr>
		<tr>
			<td>ID1</td><td>ID2</td>
		</tr>
		<c:forEach items="${friends}" var="friends">
			<td>${friends.id}</td>
		</c:forEach>
	</table>
</body>
</html>