<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compose</title>
</head>
<body>
	<form action="sendEmail" method="post">
	<table>
		<tr>
			<td>To :</td>
			<td><input type ="text" name="to" value ="${email }"></td>
		</tr>
		<tr>
			<td>Subject :</td>
			<td><input type="text" name="sub"></td>
		</tr>
		<tr>
			<td>Compose :</td>
			<td><textarea rows="10" cols="50" name="emailBody"></textarea></td>
		</tr>
		</table>
		<input type="submit" value ="send">
	</form>
</body>
</html>