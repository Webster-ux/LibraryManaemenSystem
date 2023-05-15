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
		<div class="container">
	<H1>Books taken by this ${student_id }</H1>
<table class="table">
			<thead>
				<tr>

					
					 <th>Student ID</th>
            <th>Book ID</th>
					
				</tr>
			</thead>


			<tbody>

				<c:forEach items="${studentBooks}" var="book">
					<tr>

					  <td>${studentBook.id}</td>
                <td>${studentBook.book_id}</td>

					</tr>



				</c:forEach>


			</tbody>



		</table>
		<a href="addBookToStudent?id=${student_id }" class="btn btn-success">Add book</a>
		
		</div>
		




	

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>