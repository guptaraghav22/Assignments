<%@page import="com.nagarro.training.model.BookAuthor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%if(request.getAttribute("error")!=null)
	{
	String a = (String)request.getAttribute("error");
	%>
<script >
		alert("<%=a%>");
		</script>
<%}
 %>
<link rel="stylesheet" href="style/AddBook.css">
</head>
<body>
<h1>Add Book Details</h1>
<form action="add" method="post" >

<div class="formElements">
<div class="spacer">
<label>Book Code</label>
</div>
<input type="text" name="bookCode">
</div>
<div class="formElements">
<div class="spacer">
<label>Book Name</label>
</div>
<input type= "text" name="bName"><br>
</div>
<div class="formElements">
<div class="spacer">
<label>Author</label>
</div>
<select id="authors" name="Author">
<%  List<BookAuthor> a = (List<BookAuthor>)request.getAttribute("author") ;
String date=(String)request.getAttribute("date");
for(BookAuthor author:a)
{
%>
<option value=<%=author.getAuthor() %>><%= author.getAuthor() %></option>
<% } %>
</select><br>
</div>
<div class="formElements">
<div class="spacer">
<label>Date</label>
</div>
<input type="text" name="date" value="<%=date %>" readonly>
</div>
<div class="formElements">
 <input type=submit value=add>
</div>
</form>
</body>
</html>