<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.amgen.getResponse.utility.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.amgen.getResponse.entity.campaign.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
		List<Subscription> s = campaignUtilityService.fetchDetails(2);
		
%>

<form method="get" action="">
<br><br><div style="">WELCOME User!</div><br><br>
            <table border="1" width="50%" cellpadding="7" >
                <thead>
                    <tr>
                        <th colspan="2">Your Subscriptions</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Products</td>
                        <td>Channels</td>
                    </tr>
						
                </tbody>
            </table>
            <div>
            	<p><input type="submit" value="Edit Subscription" /></p>
            </div>
        </form>
    </body>
</html>