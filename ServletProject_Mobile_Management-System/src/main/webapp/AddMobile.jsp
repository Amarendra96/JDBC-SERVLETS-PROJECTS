<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddMobileServlet" method="post">
		<table>
			<tr>
				<td><label>Enter Mobile ID:</label></td>
				<td><input type="number" placeholder="Mobile ID" name="mobileId"></td>
			</tr>
			<tr>
				<td><label>Enter Mobile Model:</label></td>
				<td><input type="text" placeholder="Mobile Model" name="mobileModel"></td>
				<td><a href="updateMobile.jsp" > </a></td>
			</tr>
			<tr>
				<td><label>Enter Mobile Brand:</label></td>
				<td><input type="text" placeholder="Mobile Brand" name="mobileBrand"></td>
			</tr>
			<tr>
				<td><label>Enter Mobile Price</label></td>
				<td><input type="text" placeholder="Mobile Price" name="mobilePrice"></td>
			</tr>
		</table>
		<input type="submit" value="save">
	</form>

</body>
</html>