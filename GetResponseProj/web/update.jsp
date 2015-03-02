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
<%
String uname= (String)request.getAttribute("username"); 
%>
<form name=myform method="post"
	action="${pageContext.request.contextPath}/updateUser">
	<center>
		<table border="1" width="50%" cellpadding="7">
		<thead>
         </thead>
          <tbody>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="First_Name"
						value="<%=request.getAttribute("First_Name")%>" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="Last_Name"
						value="<%=request.getAttribute("Last_Name")%>" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="EMAIL"
						value="<%= request.getAttribute("EMAIL")%>" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="int" name="PHONE"
						value="<%=request.getAttribute("PHONE")%>" /></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="USERNAME"
						value="<%=request.getAttribute("USERNAME")%>" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="PASSWORD"
						value="<%=request.getAttribute("PASSWORD")%>" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="textarea" name="Address"
						value="<%= request.getAttribute("Address")%>" /></td>
				</tr>
				<tr>
					<td>Fax</td>
					<td><input type="integer" name="Fax"
						value="<%= request.getAttribute("Fax")%>" /></td>
				</tr>
				<tr>
					<input type="hidden" name="serviceType" value="admin" />
				</tr>
				<tr>
					<td><input type="submit" value="Save" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</tbody>

		</table>
	</center>

	
</form>
</html>
