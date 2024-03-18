<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="SaveEmployee" method="post">
		<table>
			<tr>
				<td><label>Enter Employee ID:</label></td>
				<td><input type="number" placeholder="Employee ID" name="employeeId"></td>
			</tr>
			<tr>
				<td><label>Enter Employee Name:</label></td>
				<td><input type="text" placeholder="Employee Name" name="employeeName"></td>
			</tr>
			<tr>
				<td><label>Enter Employee Email:</label></td>
				<td><input type="email" placeholder="Employee Email" name="employeeEmail"></td>
			</tr>
			<tr>
				<td><label>Enter Employee Address:</label></td>
				<td><input type="text" placeholder="Employee Address" name="employeeAddress"></td>
			</tr>
			<tr>
				<td><label>Enter Employee Salary:</label></td>
				<td><input type="number" placeholder="Employee Salary" name="employeeSalary"></td>
			</tr>
		</table>
		<input type="submit" value="Save">
	</form>

</body>
</html>