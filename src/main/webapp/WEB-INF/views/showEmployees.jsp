<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <title>Show Employees</title>
</head>
<body>
<h1>Show Employees</h1>
<%
    List<String> employees = (List<String>) request.getAttribute("employees");

    if (employees != null && !employees.isEmpty()) {
        out.println("<ui>");
        for (String s : employees) {
            out.println(s);
            out.println("</br>");
        }
        out.println("</ui>");
    } else out.println("<p>There are no employees yet!</p>");
    out.println("</br>");
%>
<button class="back-result" onclick="location.href='/'"><span>Back</span></button>
</body>
</html>

