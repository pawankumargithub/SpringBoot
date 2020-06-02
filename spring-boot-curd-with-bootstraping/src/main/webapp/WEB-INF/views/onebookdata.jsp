<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
<body>

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
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>PRICE</th>
					<th>AUTHOR</th>

				</tr>

			</thead>
			<tbody>
				<tr>
				
						<tr>
							<td>${cmd.bookId}</td>
							<td>${cmd.bookName}</td>
							<td>${cmd.bookPrice}</td>
							<td>${cmd.bookAuthor}</td>



							<td><a href="delete?pid=${cmd.bookId}"><button
										type="button" class="btn btn-danger">DELETE</button></a></td>
							<td><a href="showUpdate?pid=${cmd.bookId}"><button
										type="button" class="btn btn-success">UPDATE</button></a></td>


						</tr>
					
				</tr>

			</tbody>
		</table>
	</div>
	
</body>
</html>