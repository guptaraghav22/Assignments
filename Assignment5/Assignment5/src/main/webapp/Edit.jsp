<%@page import="com.nagarro.training.model.BookAuthor"%>
<%@page import="java.util.List"%>
<%@page import="com.nagarro.training.model.BooksModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%BooksModel b = (BooksModel)request.getAttribute("result"); %>
<link rel="stylesheet" href="style/AddBook.css">
</head>
<body>
<h1>EDIT PAGE</h1>
<form action="edit" method="post">
<div class="formElements">
<div class="spacer">
<label>Book Code</label>
</div>
<input type ="text" value=<%=b.getBookCode() %>  name="bookCode" ><br>
</div>
<div class="formElements">
<div class="spacer">
<label>Book Name</label>
</div>
<input type="text" value=<%=b.getbName()  %> name="bName"><br>
</div>
<div class="formElements">
<div class="spacer">
<label>Author</label>
</div>
<select id="authors" name="Author">

<%  List<BookAuthor> a = (List<BookAuthor>)request.getAttribute("author") ;
for(BookAuthor author:a)
{
%>
<option value=<%=b.getAuthor() %>><%= author.getAuthor() %></option>
<% } %>
</select><br>
</div>
<div class="formElements">
<div class="spacer">

<label>Date</label>
</div>
<input type="text" name="date" value="<%=b.getDate() %>" readonly>
</div>
<div class="formElements">

<input type="submit" value="edit">
</div>
</form>
</body>
</html>