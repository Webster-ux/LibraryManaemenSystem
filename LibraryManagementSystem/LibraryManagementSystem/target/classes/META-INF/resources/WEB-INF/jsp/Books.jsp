<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet">

<meta charset="ISO-8859-1">
<title>All Students</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
<div class="collapse navbar-collapse">
			<ul class="navbar-nav">
			<h1><li class="nav-item"><a href="/" class="btn btn-outline-success	">Home</a></li></h1>			
					
			</ul>
			
		</div>
	<ul class="navbar-nav">
			<li class="nav-item" ><a href="/logout" class="btn btn-outline-success" >Logout</a></li>
		</ul>
	</nav>
	
	
	<div class="container">
<table class="table">
			<thead>
				<tr>

					<th>Id</th>
					<th>Title</th>
					<th>author</th>
					<th>publisher</th>
					<th>book available</th>
					
					
				</tr>
			</thead>


			<tbody>

				<c:forEach items="${allbooks}" var="book">
					<tr>

						<td>${book.book_id }</td>
						<td>${book.title }</td>
						<td>${book.author}</td>
						<td>${book.publisher}</td>
						<td>${book.no_of_available}</td>
						<td><a href="update-book?id=${book.book_id }"
							class="btn btn-warning">Update </a></td>
						
						<td><a href="delete-book?id=${book.book_id }"
							class="btn btn-warning">Delete </a></td>
					</tr>



				</c:forEach>


			</tbody>
<a href="addbook" class="btn btn-success">Add Book</a>


		</table>
		</div>

	

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

	<script
		src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
</body>
</html>