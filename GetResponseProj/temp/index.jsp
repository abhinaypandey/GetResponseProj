<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="frm3" method="post" action="Register.jsp">
		<br>
		<table align="center">
			<tr>
				<td><input type="submit" value="Add User" /></td>
			</tr>
			<tr>
				<input type="hidden" name="serviceType" value="admin" />
			</tr>
		</table>
	</form>
	<form name="frm" method="post"
		action="${pageContext.request.contextPath}/DisplayUser">
		<br>
		<table align="center">
			<tr>
				<td><input type="submit" value="Display User" /></td>
			</tr>
			<tr>
				<input type="hidden" name="serviceType" value="admin" />
			</tr>
		</table>
	</form>
	<form name="frm1" method="post" action="delete.jsp">
		<br>
		<table align="center">
			<tr>
				<td><input type="submit" value="Delete User" /></td>
			</tr>
			<tr>
				<input type="hidden" name="serviceType" value="admin" />
			</tr>
		</table>
		
	</form>
	<form name="frm1" method="post" action="${pageContext.request.contextPath}/createTables">
	<table align="center">
			<tr>
				<td><input type="submit" value="Create Tables" /></td>
			</tr>
			<tr>
				<input type="hidden" name="serviceType" value="admin" />
			</tr>
		</table>
		</form>
</body>
</html>