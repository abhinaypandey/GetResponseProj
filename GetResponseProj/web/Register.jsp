<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="com.amgen.getResponse.*"%>
<script language="JavaScript" type="text/javascript">
	function validateform() {
		var fname = document.myform.First_Name;
		var lname = document.myform.Last_Name;
		var password = document.myform.PASSWORD;
		var email = document.myform.EMAIL;
		var phone = document.myform.PHONE;
		var address = document.myform.Address;
		var fax = document.myform.Fax;
		var uname = document.myform.USERNAME;

		if (fname.value == "" || fname.value == null) {
			window.alert("Please enter your first name.");
			fname.focus();
			return false;
		}

		if (lname.value == "" || lname.value == null) {
			window.alert("Please enter your last name.");
			lname.focus();
			return false;
		}

		if (email.value == "" || email.value == null) {
			window.alert("Please enter a valid e-mail address.");
			email.focus();
			return false;
		}
		if (email.value.indexOf("@", 0) < 0) {
			window.alert("Please enter a valid e-mail address.");
			email.focus();
			return false;
		}
		if (email.value.indexOf(".", 0) < 0) {
			window.alert("Please enter a valid e-mail address.");
			email.focus();
			return false;
		}

		if ((phone.value == "")) {
			window.alert("Please enter your telephone number.");
			phone.focus();
			return false;
		}
		if ((address.value == "")) {
			window.alert("Please enter your address.");
			address.focus();
			return false;
		}
		if ((fax.value == "")) {
			window.alert("Please enter your fax number.");
			fax.focus();
			return false;
		}

		if ((uname.value == "")) {
			window.alert("Please enter username.");
			uname.focus();
			return false;
		}

		if (password.length < 6 ) {
			window.alert("Password must be at least 6 characters long.");
			password.focus();
			return false;
		}

		if (password.value == null || password.value == "") {
			window.alert("Please enter password");
			password.focus();
			return false;
		}
		return true;
	}
</script>
<body>
	<form name=myform method="post"
		action="${pageContext.request.contextPath}/GetResponseDelegate"
		onsubmit="return validateform();">
		<center>
			<table border="1" width="50%" cellpadding="7">
				<thead>
					<tr>
						<th colspan="2">Enter Information Here</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>First Name</td>
						<td><input type="text" name="First_Name" value="" /></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="Last_Name" value="" /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="EMAIL" value="" /></td>
					</tr>
					<tr>
						<td>Phone</td>
						<td><input type=integer name="PHONE" value="" /></td>
					</tr>
					<tr>
						<td>User Name</td>
						<td><input type="text" name="USERNAME" value="" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="PASSWORD" value="" /></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="textarea" name="Address" value="" /></td>
					</tr>
					<tr>
						<td>Fax</td>
						<td><input type="integer" name="Fax" value="" /></td>
					</tr>
					<tr>
						<input type="hidden" name="serviceType" value="admin" />
					</tr>
					<tr>
						<td><input type="submit" value="Submit" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
					<tr>
						<td colspan="2">Already registered!! <a href="login.jsp">Login
								Here</a></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>