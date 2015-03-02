<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<form name="frm" method="post"
		action="${pageContext.request.contextPath}/UserLogin">
		<center>
			<h1 style="color: blue">Welcome To Login-Page</h1>
			<b style="color: blue">Login Here</b><br>
			<table border="1" width="2" bgcolor="khaki" style="color: red">
				<tr>
					<td><b>Enter User Name: </b></td>
					<td><input type="text" name="USERNAME" value="" /></td>
				</tr>
				<tr>
					<td><b>Enter Password: </b></td>
					<td><input type="password" name="Password" value="" /></td>
				</tr>
				<tr>
					<input type="hidden" name="serviceType" value="admin" />
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</table>
		</center>
	</form>
</body>

</html>