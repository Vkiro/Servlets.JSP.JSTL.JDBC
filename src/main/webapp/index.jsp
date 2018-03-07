<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>
    <link href="/css/loginstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login-page">
    <div class="form">
        <form action="findUser" class="login-form" method="post">
            <input type="text" placeholder="login" name="login" required/>
            <input type="password" placeholder="password" name="password" required/>
            <input type="submit" value="Log In" name="getit"/>
        </form>
        <form action="registration" class="login-form" method="post">
            <input type="submit" value="Registration" name="register"/>
        </form>
    </div>
</div>
</body>
</html>
