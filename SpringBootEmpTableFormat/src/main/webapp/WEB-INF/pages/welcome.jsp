<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
               <a href="/"><h3>ADD NEW EMPLOYEE</h3>
<table border="1">
  <tr bgcolor="orange">
    <th>ID</th>
    <th>NAME</th>
     <th>SALARY</th>
    <th>GENDER</th>
     <th>EMAIL</th>
    <th>DEPTNO</th>
    <th>DEPTNAME</th>
 
  <c:forEach var="emplist" items="${emplist}">
  <tr bgcolor="red">
  
  
				<td>${emplist.employeeId}</td>
				<td>${emplist.employeeName}</td>
				<td>${emplist.employeeSal}</td> 
				<td>${emplist.employeeGen}</td>
				<td>${emplist.employeeMail}</td>
				<td>${emplist.employeeDeptNo}</td>
				<td>${emplist.employeeDeptName}</td>
  </tr>
  </c:forEach>
  
</table>
       <h1 style="color: red;text-align: center">Data Inserted</h1>
</body>
</html>