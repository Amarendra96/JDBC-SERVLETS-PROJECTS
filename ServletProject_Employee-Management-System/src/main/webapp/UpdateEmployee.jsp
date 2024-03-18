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

	<%ArrayList<Employee> employeeList = (ArrayList<Employee>)request.getAttribute("employee");%>
	<%Employee employee = employeeList.get(0);%>
	
	<form action="SaveUpdatedEmployee" method="post">
		<table>
			<tr>
				<td><label>Employee ID:</label></td>
				<td><input type="number" placeholder="Employee ID" value="<%=employee.getEmployeeId()%>" name="employeeId" readonly="true"></td>
			</tr>
			<tr>
				<td><label>Enter Employee Name:</label></td>
				<td><input type="text" placeholder="Employee Name" value="<%=employee.getEmployeeName()%>" name="employeeName"></td>
			</tr>
			<tr>
				<td><label>Enter Employee Email:</label></td>
				<td><input type="text" placeholder="Employee Email" value="<%=employee.getEmployeeEmail()%>" name="employeeEmail"></td>
			</tr>
			<tr>
				<td><label>Enter Employee Address:</label></td>
				<td><input type="text" placeholder="Employee Address" value="<%=employee.getEmployeeAddress()%>" name="employeeAddress"></td>
			</tr>
			<tr>
				<td><label>Enter Employee Salary:</label></td>
				<td><input type="number" placeholder="Employee Salary" value="<%=employee.getEmployeeSalary()%>" name="employeeSalary"></td>
			</tr>
		</table>
		<input type="submit" value="Update">
	</form>
	
</body>
</html>