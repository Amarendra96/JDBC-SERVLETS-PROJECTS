<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%ResultSet resultSet = (ResultSet) request.getAttribute("resultSet");%>
	<%resultSet.next(); %>
	<form action="SaveUpdatedMobile" method="post">
		<table>
			<tr>
				<td><label>Enter Mobile ID:</label></td>
				<td><input type="number" value=<%=resultSet.getInt("mobileId")%> readonly="true" name="mobileId"></td>
			</tr>
			<tr>
				<td><label>Enter Mobile Model:</label></td>
				<td><input type="text" value=<%=resultSet.getString("mobileModel")%> name="mobileModel"></td>
			</tr>
			<tr>
				<td><label>Enter Mobile Brand:</label></td>
				<td><input type="text" value=<%=resultSet.getString("mobileBrand")%> name="mobileBrand"></td>
			</tr>
			<tr>
				<td><label>Enter Mobile Price:</label></td>
				<td><input type="text" value=<%=resultSet.getDouble("mobilePrice")%> name="mobilePrice"></td>
			</tr>
		</table>
		<input type="submit" value="Save">
	</form>
	

</body>
</html>