<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
		tr:first-child{
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
			<td>FIRSTNAME</td><td>LASTNAME</td><td>EMAIL</td><td>CITY</td><td>State</td><td>STREET</td><td>ZIP</td>
		</tr>
			<tr>
			<td>${person.firstname}</td>
			<td>${person.lastname}</td>
			<td>${person.email}</td>
			<td>${person.address.city}</td>
			<td>${person.address.state}</td>
			<td>${person.address.street}</td>
			<td>${person.address.zip}</td>
			</tr>
	</table>
</body>
</html>