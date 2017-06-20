<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link href="/css/loginstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login-page">
    <div class="form">
        <form action="createUser" onsubmit="return validateForm(this)" class="login-form" method="post" name="form">
            <input type="text" placeholder="login" name="login" required/>
            <input type="password" placeholder="password" name="password" required/>
            <input type="password" placeholder="confirm" name="confirm" required/>
            <input type="text" placeholder="first name" name="firstName" required/>
            <input type="text" placeholder="last name" name="lastName" required/>
            <input type="submit" value="Registration" name="register" required/>
        </form>
    </div>
</div>

<script src="js/confirm.js"></script>
</body>
</html>
