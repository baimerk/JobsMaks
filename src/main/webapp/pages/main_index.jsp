<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/css/styles.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Users</title>
</head>
<body>
<h2>Users</h2>
<p><a href='<c:url value="/create"/>'>Create new</a></p>
<table>
    <tr><th>id</th><th>Name</th><th>LastName</th><th>login</th><th>password</th><th>age</th><th></th></tr>
    <c:forEach var="user" items="${users}">
        <tr><td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.lastname}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.age}</td>
            <td>
                <a href='<c:url value="/edit?id=${user.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
</body>
</html>
