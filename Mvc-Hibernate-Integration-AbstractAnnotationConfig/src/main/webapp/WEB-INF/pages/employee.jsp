<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body bgcolor="#FFFFFF">
	<form action="save" method="post">
		<table align="center" width=40% width="100%" cellspacing="2"
			cellpadding="2" border="5">
			<tr>
				<td colspan="2" align="center" ><b>Employee Registration
						Form.</b></td>

			</tr>
			<tr>
				<td align="left" valign="top" width="41%">Employee Id<span
					style="color: red">*</span></td>

				<td width="57%"><input type="text" value="" name="empId"
					size="24"></td>
			</tr>
			<tr>
				<td align="left" valign="top" width="41%">Employee Name<span
					style="color: red">*</span></td>
				<td width="57%"><input type="text" value="" name="empName"
					size="24"></td>
			</tr>
			<tr>
				<td align="left" valign="top" width="41%">Employee Salary<span
					style="color: red">*</span></td>

				<td width="57%"><input type="text" value="" name="empSal"
					size="24"></td>
			</tr>
			<tr>
				<td align="left" valign="top" width="41%">Employee Address<span
					style="color: red">*</span></td>

				<td width="57%"><input type="text" value="" name="empAddr"
					size="24"></td>
			</tr>
			<tr>
				<td colspan="2">
					<p align="center">
						<input type="submit" value="  Submit" name="B4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="  Reset All   " name="B5">
				</td>
			</tr>

		</table>
	</form>
	<table border="1">


		<tr style="color: red">
			<th>ID</th>
			<th>NAME</th>
			<th>SAL</th>
			<th>ADDR</th>
			<th>ACTION</th>
		</tr>

		<c:forEach var="emp" items="${emplist}" varStatus="status">
			<tr style="color: maroon;">

				<td>${emp.empId}</td>
				<td>${emp.empName}</td>
				<td>${emp.empSal}</td>
				<td>${emp.empAddr}</td>

				<td><a href="">update</a></td>
				<td><a href="">delete</a></td>

			</tr>
		</c:forEach>
	</table>

</body>

</html>










