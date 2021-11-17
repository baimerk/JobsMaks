<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("gender", "Male");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <br>
    <h4><a href="/jobs">Return</a></h4>
    <br>
</div>
<div class="container">
    <p>Name: ${name}</p>
    <p>Age: ${age}</p>
    <p>Gender ${requestScope.gender}</p>
    <p>Country: ${applicationScope.country}</p>
</div>
</body>
</html>
