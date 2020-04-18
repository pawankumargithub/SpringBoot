<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

           <h1 style="color: red; text-align: center">Employee Registration Form</h1><br>
      
     <center>  <form action="save">
       
     
      <b> Enter Name: </b><input type="text" name="employeeName"><br>
      <b> Enter salary: </b><input type="text" name="employeeSal"><br>
       <b> Enter gender: </b><input type="text" name="employeeGen"><br>
      <b> Enter email: </b><input type="text" name="employeeMail"><br>
      <b> Enter deptNo: </b><input type="text" name="employeeDeptNo"><br>
       <b> Enter deptName: </b><input type="text" name="employeeDeptName"><br>
      <input type="submit" value="save">
       
       </form>
       </center>
</body>
</html>