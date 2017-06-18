<%@ page import="com.todolist.servlet.LoginServlet" %>
<html>
<head>
    <title>Login page</title>
    <link href="/css/loginstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login-page">
    <div class="form">
        <form action="dispatcher" class="login-form" method="post">
            <input type="text" placeholder="login" name="login" required/>
            <input type="password" placeholder="password" name="password" required/>
            <input type="submit" value="Get it" name="getit"/>
        </form>
        <form action="registration" class="login-form" method="post">
            <input type="submit" value="Register" name="register"/>
        </form>
    </div>
</div>
</body>
</html>
