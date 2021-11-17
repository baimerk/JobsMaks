<%@ page import="com.example.jobs.config.Catalogue" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table users</title>
</head>
<body>
<div>
    <ul>
        <%
            Catalogue cataloque = (Catalogue) request.getAttribute("catalogue");

            for (String a : cataloque.getName()) {
                out.println("<li>");
                out.println(a);
                out.println("<ul>");
                for (String b : cataloque.getLastname(a)) {
                    out.println("<li>" + b + "</li>");
                    out.println("<ul>");
                    for (String c : cataloque.getLogin(a, b)) {
                        out.println("<p><a href=\"" + request.getContextPath() + "?entry=" + c + "\">" + c + "</a></p>");
                    }
                    out.println("</ul>");
                }
                out.println("</ul>");
                out.println("</li>");
            }
        %>
    </ul>
</div>
</body>
</html>
