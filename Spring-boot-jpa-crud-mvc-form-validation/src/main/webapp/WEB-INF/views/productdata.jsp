<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <form>
       
       
        <table bgcolor="gray" align="center" border="1">

		<tr bgcolor="orange">

			<th>ID</th>
			<th>NAME</th>
			<th>COST</th>
			<th>DISCOUNT</th>
			<th>GST</th>
			<th>VENDOR</th>
			<th>Action</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${ob}" var="list">
		<tr bgcolor="cyan">
		<td>${list.prodId}</td>
		<td>${list.prodName}</td>
		<td>${list.prodCost}</td>
		<td>${list.prodDis}</td>
		<td>${list.prodGst}</td>
		<td>${list.vendor}</td>
		<td bgcolor="red"><a href="delte?pid=${list.prodId}">DELETE</a></td>
		<td bgcolor="orange"><a href="update?pid=${list.prodId}">UPDATE	</a></td>
		</tr>
		
		</c:forEach>
	
	</table>
       
       </form>
       <a href="register.htm"><h1 style="color: red;text-align: center;">Add New Product</h1></a>
       	
</body>
</html>