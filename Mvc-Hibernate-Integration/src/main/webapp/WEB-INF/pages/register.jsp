<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">Employee Registration</h1>
	<hr>
	<form action="save" method="post">
		<div align="center">

			ID:<input type="text" name="empId"> <br> NAME:<input
				type="text" name="empName"> <br> SALARY:<input
				type="text" name="empSal"> <br> ADDRESS:<input
				type="text" name="empAddr"> <br> <input type="submit"
				value="register"><br>
			<hr>

		</div>

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