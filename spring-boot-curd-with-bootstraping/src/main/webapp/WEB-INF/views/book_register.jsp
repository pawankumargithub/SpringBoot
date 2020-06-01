<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: blue">Book Entry Page</h1>
<html lang="en">
<head>
<title>book page</title>
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

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Pawan Book Zone</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="findall">All Book</a></li>
				<li><a href="regbook">Add New Book</a></li>
			</ul>
			<button class="btn btn-danger navbar-btn">Button</button>
		</div>
	</nav>
<html lang="en">
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
		<h2>Enter Book Details</h2>
		<form action="savebook" method="post">
		
			<div class="form-group">
				<label for="bookName">Book Name:</label> <input type="text"
					class="form-control" id="bookName" placeholder="Enter book name"
					name="bookName">
			</div>
			<div class="form-group">
				<label for="bookPrice">Price:</label> <input type="text"
					class="form-control" id="bookPrice" placeholder="Enter price"
					name="bookPrice">
			</div>
			<div class="form-group">
				<label for="bookAuthor">Author:</label> <input type="text"
					class="form-control" id="bookAuthor" placeholder="Enter Autor Name"
					name="bookAuthor">
			</div>

			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>

<h1> Book  saved having id: ${id}</h1>
</body>
</html>
    


