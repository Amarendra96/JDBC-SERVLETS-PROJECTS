<%@page import="java.sql.ResultSet" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	ResultSet resultSet = (ResultSet) request.getAttribute("resultSet");
	%>
	<%
	resultSet.next();
	%>
	<from action="SaveUpdatedMobile" method="post">
	<table>
		<tr>
			<td><label>Enter Mobile ID:</label></td>
			<td><input type="number" value=<%=resultSet.getInt("mobileId")%>
				readonly="true" name="mobileId"></td>
		</tr>

		<tr>
			<td><label>Enter Mobile Model:</label></td>
			<td><input type="text"
				value=<%=resultSet.getInt("mobileModel")%> name="mobileModel"></td>
		</tr>

		<tr>
			<td><label>Enter Mobile Brand:</label></td>
			<td><input type="text"
				value=<%=resultSet.getDouble("mobileBrand")%> name="mobileBrand"></td>
		</tr>


	</table>
	<input type="submit" value="Save"> </from>
</body>
</html>