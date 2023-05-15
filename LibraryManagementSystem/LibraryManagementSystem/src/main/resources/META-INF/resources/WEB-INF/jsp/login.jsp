<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
	
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="btn btn-success" href="/bookslist">All books</a></li>
					
			</ul>
			&nbsp;&nbsp;&nbsp;
			<ul class="navbar-nav">
				
				<center>
				<li class="nav-item"><a class="btn btn-success" href="/borrow">Borrowed books</a></li>
				</center>
			
			</ul>
&nbsp;&nbsp;&nbsp;
			<ul class="navbar-nav">
				<li class="nav-item"><a class="btn btn-success" href="/studentslist">Students list</a></li>
			
			</ul>&nbsp;&nbsp;&nbsp;
			
		</div>
		<ul class="navbar-nav">
			<li class="nav-item" ><a href="/logout" class="btn btn-outline-success" >Logout</a></li>
		</ul>
	
	</nav>




	

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>