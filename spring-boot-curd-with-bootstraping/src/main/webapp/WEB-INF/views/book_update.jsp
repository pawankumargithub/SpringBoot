<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>


<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Pawan Book Zone</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="deleteAll">Delete All</a></li>
				<li><a href="findall">All Book</a></li>
				<li><a href="regbook">Add New Book</a></li>
				<li class="active"><a href="getonebookform">Get One Book</a></li>
			</ul>
			
			<button class="btn btn-danger navbar-btn">Button</button>
		</div>
	</nav>
	
	

<form:form modelAttribute="cmd" action="update">

	<table align="center" bgcolor="cyan">


		<tr>

			<td>Id:</td>
			<td><form:input path="bookId" readonly="true" /></td>


		</tr>
		<tr>

			<td>Name:</td>
			<td><form:input path="bookName" /></td>


		</tr>
		<tr>

			<td>Price:</td>
			<td><form:input path="bookPrice" /></td>


		</tr>
		<tr>

			<td>Author:</td>
			<td><form:input path="bookAuthor" /></td>


		</tr>
		<tr>

			
			<td><input type="submit" value="update"></td>


		</tr>





	</table>

</form:form>
