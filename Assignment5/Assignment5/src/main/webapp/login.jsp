<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style/login.css">

</head>
<body>
<div id="parentDiv">
<div>
<h1>LOGIN</h1>
</div>
<div id="form">
<form action="login">
<div class="formElements">
<div class="spacer">
<label >
UserName:
</label>
</div>
<input type=text  name = user>
</div>
<div class="formElements">
<div class="spacer">
<label>
Password:
</label>
</div>
<input type=text name = pass>
</div>
<div class="formElements">
<input type=submit value= submit>
</div>
</form>
</div>
</div>

</body>
</html>