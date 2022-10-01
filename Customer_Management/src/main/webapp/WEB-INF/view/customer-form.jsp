<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Customer</title>
</head>
<body>
	<div class="container">

		<h3>Customer Directory</h3>
		<hr>

		<p class="h4 mb-4"> Enter the details of Customer</p>

		<form action="/Customer_Management/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />


			<div class="form-inline">
				<input type="text" name="first_name" value="${Customer.first_name}"
					class="form-control  mb-4 col-4" placeholder=" First Name">
			</div>


			<div class="form-inline">

				<input type="text" name="last_name" value="${Customer.last_name}"
					class="form-control mb-4 col-4" placeholder="Last Name">
			</div>


			<div class="form-inline">

				<input type="text" name="email_id" value="${Customer.email_id}"
					class="form-control mb-4 col-4" placeholder="Email_id">
			</div>


			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/Customer_Management/">Back to the home page</a>

	</div>

</body>
</html>