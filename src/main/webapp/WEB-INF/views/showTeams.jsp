<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <title>Show Teams</title>
</head>
<body>
<h1>Show Teams</h1>
<%
    List<String> teams = (List<String>) request.getAttribute("teams");

    if (teams != null && !teams.isEmpty()) {
        out.println("<ui>");
        for (String s : teams) {
            out.println(s);
            out.println("</br>");
        }
        out.println("</ui>");
    } else out.println("<p>There are no teams yet!</p>");
    out.println("</br>");
%>
<button class="back-result" onclick="location.href='/'"><span>Back</span></button>
</body>
</html>

