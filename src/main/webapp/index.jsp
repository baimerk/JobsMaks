<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MainPage</title>
    <link rel="stylesheet" href="resources/css/styles.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div id="StyleOne">
        <ul>

            <li class="l1"><a href="/jobs/pages/registration.jsp">Регистрация</a></li>

            <c:if test="${sessionScope.user !=null}">
                <li class="l2"><a href="/jobs/pages/logout.jsp">Logout(Выйти)</a></li>
            </c:if>
            <c:if test="${sessionScope.user !=null}">
                <li class="l3"><a href="#">Информация</a></li>
                <li class="l4"><a href="/jobs/pages/main_index.jsp">Список пользователей</a></li>
                <li class="l5"><a href="#">История</a></li></c:if>
        </ul>
    </div>
</div>
</body>
</html>
