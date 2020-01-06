<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <title>Show Projects</title>
</head>
<body>
<h1>Show Projects</h1>
<%
    List<String> projects = (List<String>) request.getAttribute("projects");

    if (projects != null && !projects.isEmpty()) {
        out.println("<ui>");
        for (String s : projects) {
            out.println(s);
            out.println("</br>");
        }
        out.println("</ui>");
    } else out.println("<p>There are no projects yet!</p>");
    out.println("</br>");
%>
<button class="back-result" onclick="location.href='/'"><span>Back</span></button>
</body>
</html>

