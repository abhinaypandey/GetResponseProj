<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String uname = (String) request.getAttribute("username");
		{
			out.println("<align=left><h1>Welcome  " + uname + " </h1>");
			session.setAttribute("username", uname);
		}
	%>

	<form name="frm" method="post"
		action="${pageContext.request.contextPath}/getUser">

		<br>
		<table>
			<tr>
				<td><input type="hidden" name="USERNAME" value="<%=uname%>" /></td>
			</tr>
			<tr>
				<input type="hidden" name="serviceType" value="admin" />
			</tr>
		</table>

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="Submit"
			value="Edit Profile"><br>
	</form>

	<form name="frm1" method="post"
		action="${pageContext.request.contextPath}/logout.jsp">

		<br>
		<table>
			<tr>
				<td><input type="hidden" name="USERNAME" value="<%=uname%>" /></td>
			</tr>
			<tr>
				<input type="hidden" name="serviceType" value="admin" />
			</tr>
		</table>

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="Submit"
			value="Logout"><br>
	</form>
</body>
<br>
<br>
<br>
</html>