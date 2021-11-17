<%--
  Created by IntelliJ IDEA.
  User: sagam
  Date: 12.11.2021
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SetupDate</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <br>
    <h4><a href="/jobs">Вернуться(Return)</a></h4>
    <br>
</div>

<div class="container">
    <form action="/jobs/context" method="post">
        <p>Name:   <input type="text" name="name"/></p>
        <p>Age:    <input type="text" name="age"/></p>
        <p>Gender:</p>
        <p><input type="radio" name="gender" value="Male"/> Male</p>
        <p><input type="radio" name="gender" value="Female"/> FeMale</p>
        <p><input type="radio" name="gender" value="Thing"/> Thing </p>
        <br>
        <p>Country:<select name="country">
            <option value="Ukraine">Ukraine</option><br>
            <option value="Russia">Russia</option><br>
            <option value="Belarus">Belarus</option><br>
        </select><p>
        <input type="submit" value="submit"/>
        <input type="reset" value="clear"/>
    </form>
</div>
</body>
</html>

