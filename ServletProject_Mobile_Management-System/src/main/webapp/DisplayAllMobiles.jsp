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
	<%ResultSet resultSet = (ResultSet) request.getAttribute("resultSet");%>
	<table border="">
		<thead>
			<th>Mobile ID</th>
			<th>Mobile Model</th>
			<th>Mobile Brand</th>
			<th>Mobile Price</th>
			<th>Update</th>
			<th>Delete</th>
		</thead>
		<% while (resultSet.next()) {%>
		<tr>
			<td><%=resultSet.getInt("mobileId")%></td>
			<td><%=resultSet.getString("mobileModel")%></td>
			<td><%=resultSet.getString("mobileBrand")%></td>
			<td><%=resultSet.getDouble("mobilePrice")%></td>
			<td><a href=UpdateMobile?mobileId=
				<%=resultSet.getInt("mobileId")%>>UPDATE</a></td>
			<td><a href=DeleteMobile?mobileId=
				<%=resultSet.getInt("mobileId")%>>DELETE</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>