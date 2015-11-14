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
			<td>NAME</td><td>DESCRIPTION</td><td>CITY</td><td>State</td><td>STREET</td><td>ZIP</td>
		</tr>
			<tr>
			<td>${org.name}</td>
			<td>${org.description}</td>
			<td>${org.address.city}</td>
			<td>${org.address.state}</td>
			<td>${org.address.street}</td>
			<td>${org.address.zip}</td>
			</tr>
	</table>
</body>
</html>