<%@page import="com.jsp.servlet.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	ArrayList<Employee> employeesList = (ArrayList<Employee>) request.getAttribute("employeesList");
	%>
	<table border="">
		<thead>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Email</th>
			<th>Employee Address</th>
			<th>Employee Salary</th>
			<th>Update</th>
			<th>Delete</th>
		</thead>
		<%
		for (Employee employee : employeesList) {
		%>
		<tr>
			<td><%=employee.getEmployeeId()%></td>
			<td><%=employee.getEmployeeName()%></td>
			<td><%=employee.getEmployeeEmail()%></td>
			<td><%=employee.getEmployeeAddress()%></td>
			<td><%=employee.getEmployeeSalary()%></td>
			<td><a
				href="UpdateEmployee?employeeId=<%=employee.getEmployeeId()%>">UPDATE</a></td>
			<td><a
				href="DeleteEmployee?employeeId=<%=employee.getEmployeeId()%>">DELETE</a></td>
		</tr>
		<%
	}
	%>
	</table>

</body>
</html>