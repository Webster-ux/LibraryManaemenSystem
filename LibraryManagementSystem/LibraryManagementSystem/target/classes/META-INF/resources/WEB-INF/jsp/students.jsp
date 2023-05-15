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

					<th>Student Id</th>
					<th>Name</th>
					<th>Course</th>
					<th>Branch</th>
				
					
				</tr>
			</thead>


			<tbody>

				<c:forEach items="${allstudents}" var="student">
					<tr>

						<td>${student.id }</td>
						<td>${student.name }</td>
						<td>${student.course}</td>
						<td>${student.branch}</td>
						
						<td><a href="bookstakenbystudent?id=${student.id }" class="btn btn-success">Books taken</a></td>
						

					</tr>



				</c:forEach>


			</tbody>


		</table>
		<a href="addstudent" class="btn btn-success">Add student</a>
		</div>

	


	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

	<script
		src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
</body>
</html>