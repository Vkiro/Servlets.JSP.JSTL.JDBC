<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update</title>
    <link href="/css/updatestyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="updateItem" method="post">
    <textarea required name=${item.getId()}>${item.getText()}</textarea>
    <input type="submit" name=${item.getId()} value="Update"/>
</form>
</body>
</html>
