<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.amgen.getResponse.*"%>
<%@page import="com.amgen.getResponse.entity.userProfileManagement.*"%>
<%@page import="com.amgen.getResponse.utility.UtilityService"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
List<User> us= (List)request.getAttribute("user");
%>
	<table border="1">

		<thead>
			<tr>
				<td>User Name</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Password</td>
				<td>EMAIL</td>
				<td>FAX</td>
				<td>Phone</td>
				<td>Address</td>
			</tr>
		</thead>
		<% for(int i = 0 ; i < us.size();i++)
    	{
    	System.out.println(us.get(i).getUsername());
    	%>
		<tr>
			<td><%=us.get(i).getUsername()%></td>
			<td><%=us.get(i).getFirst_name() %></td>
			<td><%=us.get(i).getLast_name() %></td>
			<td><%= us.get(i).getPassword() %></td>
			<td><%= us.get(i).getEmail() %></td>
			<td><%= us.get(i).getFax() %></td>
			<td><%= us.get(i).getPhone()%></td>
			<td><%= us.get(i).getAddress() %></td>
		</tr>
		<% } %>
		<tbody></tbody>
	</table>
</body>
</html>