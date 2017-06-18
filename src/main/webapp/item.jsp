<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Item</title>
    <link href="/css/itemstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
    <table>
        <tr>
            <th>ITEM</th>
            <th>DELETE</th>
            <th>UPDATE</th>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
                <td>
                    <c:out value="${item.getText()}" />
                </td>
                <td>
                    <form action="deleteItem" method="post">
                        <input type="submit" value="Delete" name="${item.getId()}"/>
                    </form>
                </td>
                <td>
                    <form action="updateItem" method="post">
                        <input type="submit" value="Update" name="${item.getId()}"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="addItem" method="post">
        <input type="text" name="item" required/>
        <input type="submit" value="Add" name="add"/>
    </form>
</body>
</html>
