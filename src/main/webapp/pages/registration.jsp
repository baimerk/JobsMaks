<%--
  Created by IntelliJ IDEA.
  User: sagam
  Date: 12.11.2021
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/jobs/registration" method="post">
        <div class="row">
            <label class="form-label col-4">Name: <input class="form-control col-8" id="namelabel" name="name" type="text"/></label>
        </div>
        <br>
        <div class="row">
            <label class="form-label col-4">Last Name: <input class="form-control col-8" name="lastname" type="text"/></label>
        </div>
        <br>
        <div class="row">
            <label class="form-label col-4">Age: <input class="form-control col-8" name="age" type="text"/></label>
        </div>
        <br>
        <div class="row">
            <label class="form-label col-4">Login: <input class="form-control col-8" name="login" type="text"/></label>
        </div>
        <br>
        <div class="row">
            <label class="form-label col-4">Password: <input class="form-control col-8" name="password" type="password"/></label>
        </div>
        <br>
        <div class="row">
        <p class="col-2">Select Role: </p>
            <label>User <input name="role" type="radio" value="user" checked/></label>
            <label>Admin <input name="role" type="radio" value="admin"/></label>
        </div>

        <div class="col-auto">
            <input type="submit" class="btn btn-primary mb-3" value="registration"/>
            <input type="reset" class="btn btn-primary mb-3" value="clear"/>
        </div>
    </form>
</div>
</body>
</html>
