<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <title>Show Skills</title>
</head>
<body>
<h1>Show Skills</h1>
<%
    List<String> skills = (List<String>) request.getAttribute("skills");

    if (skills != null && !skills.isEmpty()) {
        out.println("<ui>");
        for (String s : skills) {
            out.println(s);
            out.println("</br>");
        }
        out.println("</ui>");
    } else out.println("<p>There are no skills yet!</p>");
    out.println("</br>");
%>
<button class="back-result" onclick="location.href='/'"><span>Back</span></button>
</body>
</html>

