
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<style>
    .inputarea{
        margin-left: 10px;
        width: 443px
    }
    .credentials{
        margin: 30px 170px ;
        width: 850px;
    }
    .heading{
        width: 100%;
        background: #6fa9c4;
        border: 1px solid #69cdfc;
    }
    .login-details{
        height: 170px;
        background: #b1d3ea;
        border: 1px solid #69cdfc;
    }
    .loginbtn{
        margin-left: 1020px;
    }
    .imp{
        margin-left: 252px;
        color: red;
    }
    .container{
        margin-top: 120px;

    }
</style>
<body>
<div class="container">
    <div class="heading">
        <h4>Log in </h4>
    </div>
    <div class="login-details">
        <form action="loginattempt" method="post">
            <div class="mt-1 pt-1 credentials"><label class="label">Username</label> <label class="imp">*</label> <input class="inputarea" type="text" name="username"></div>
            <div class="mt-1 pt-1 credentials"><label class="label">Password</label> <label class="imp">*</label> <input class="inputarea" type="password" name="userpassword"></div>
            <div class="submission heading">
                <input class="loginbtn" type="submit"  name="login" value="Login>">
            </div>
        </form>
    </div>
</div>

</body>
</html>
