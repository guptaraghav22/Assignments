<%@page import="java.util.List"%>
<%@page import="com.nagarro.week4.controller.SearchController"%>
<%@page import="com.nagarro.week4.model.Tshirt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>T-shirt Search</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous" />

</head>
<body>

	<nav class="navbar sticky-top bg-primary">
		<div class="container">
			<a class="navbar">
				<h3 class="text-Center m-1 text-light">Find Your T-shirt</h3>
			</a>

		</div>
	</nav>


	<div class="p-2 bg-light border">

		<div>
			<div>
				<h4 class="p-2 bg-light border">Please enter the details here to search</h4>

				<form class="form" action="search" method="post">

					<div class="mb-1">
						<label for="exampleInputEmail1" class="form-label">Color </label>
						<input type="text" class="form-control" id="exampleInputEmail1"
							name="color" aria-describedby="emailHelp"
							placeholder="Enter Color">
					</div>
					<div class="mb-1">
						<label for="exampleInputPassword1" class="form-label">Size</label>
						<input type="text" class="form-control" name="size"
							placeholder="Size(ex:S,M,L)" id="exampleInputPassword1"
							list="sizeOptions">
						<datalist id="sizeOptions">
							<option value="S">
							<option value="M">
							<option value="L">
						</datalist>
					</div>

					<div class="mb-1">
						<label for="exampleInputPassword1" class="form-label">Gender</label>
						<input class="form-control" list="genderOptions"
							id="exampleInputPassword1" name="gender" placeholder="Size(M,F)">
						<datalist id="genderOptions">
							<option value="M">
							<option value="F">
						</datalist>
					</div>

					<div class="mb-1">
						<label for="exampleDataList" class="form-label">Preference</label>
						<input class="form-control" list="preferenceOptions"
							name="preference" id="exampleDataList"
							placeholder="Search for preference">
						<datalist id="preferenceOptions">
							<option value="Price">
							<option value="Rating">
							<option value="Both">
						</datalist>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>


				</form>
			</div>
		</div>
		<br>
		<%
		List<Tshirt> list = SearchController.getList();
		%>
		<%
		if (list.isEmpty()) {
		%>
		<h1 style="color: red">${notFound}</h1>
		<%
		}
		%>


		<div class="container">
			<table>
				<thead>

					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Size</th>
						<th>Color</th>
						<th>Gender</th>
						<th>Price</th>
						<th>Rating</th>
						<th>Availability</th>
					</tr>
				</thead>

				<%
				//List<TShirtDetails> list = SearchController.getList();
				for (Tshirt itr : list) {
				%>
				<tr>

					<td><%=itr.getId()%></td>
					<td><%=itr.getName()%></td>
					<td><%=itr.getSize()%></td>
					<td><%=itr.getColor()%></td>
					<td><%=itr.getGender()%></td>
					<td><%=itr.getPrice()%></td>
					<td><%=itr.getRating()%></td>
					<td><%=itr.getAvailability()%></td>

				</tr>
				<%
				}
				%>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>Total number of products found</td>
					<%
					if (list.size() == 0) {
					%>
					<td style="color: red;"><%=list.size()%></td>
					<%
					} else {
					%>
					<td style="color: green;"><%=list.size()%></td>
					<%
					}
					list.clear();
					%>
				</tr>
			</table>
		</div>


	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>


</html>