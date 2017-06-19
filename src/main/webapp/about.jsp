<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Item</title>
    <link href="/css/aboutstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form">
    <form action="dispatcherNavBar" class="login-form" method="post">
        <input type="submit" name="about" value="About"/>
        <input type="submit" name="item" value="Item"/>
        <input type="submit" name="logout" value="Log out"/>
    </form>
</div>
<table align="center">
    <tr>
        <th>LOGIN</th>
        <th>FIRST NAME</th>
        <th>LAST NAME</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>
                ${user.getLogin()}
            </td>
            <td>
                ${user.getFirstName()}
            </td>
            <td>
                ${user.getLastName()}
            </td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>