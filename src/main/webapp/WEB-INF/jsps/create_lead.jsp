<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
	<h1>Create Lead</h1>
	<form action="saveLead" method="post">
		<table>
			<tr>
				<td>First Name</td>
				<td>
					<input type = "text" name="firstName">
				</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>
					<input type = "text" name="lastName">
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<input type = "email" name="email">
				</td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td>
					<input type = "number" name="mobile">
				</td>
			</tr>
			<tr>
				<td>Source</td>
				<td>
					<select name="source">
					<option value="news paper">News Paper</option>
					<option value="tv commercials">TV Commercials</option>
					<option value="online">Online</option>
					<option value="seminar">Seminar</option>
					</select>
				</td>
			</tr>
		
		</table>
		
		
		<input type="submit" value="save">
	</form>
</body>
</html>