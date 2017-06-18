<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Item</title>
    <link href="/css/itemstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<table align="center">
    <tr>
        <th>ITEM</th>
        <th>UPDATE</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${items}" var="item">
    <tr>
        <td>
            ${item.getText()}
        </td>
        <td>
            <form action="update" method="post">
                <input id="update" type="submit" value="Update" name="${item.getId()}"/>
            </form>
        </td>
        <td>
            <form action="deleteItem" method="post">
                <input id="delete" type="submit" value="Delete" name="${item.getId()}"/>
            </form>
        </td>

    </tr>
    </c:forEach>
</table>
<form action="addItem" method="post">
    <input type="text" name="item" required/>
    <div>
    <input type="submit" value="Add" name="add"/>
    </div>
</form>
</body>
</html>
