<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <title>Show Customers</title>
</head>
<body>
<h1>Show Customers</h1>
<%
    List<String> customers = (List<String>) request.getAttribute("customers");

    if (customers != null && !customers.isEmpty()) {
        out.println("<ui>");
        for (String s : customers) {
            out.println(s);
            out.println("</br>");
        }
        out.println("</ui>");
    } else out.println("<p>There are no customers yet!</p>");
    out.println("</br>");
%>
<button class="back-result" onclick="location.href='/'"><span>Back</span></button>
</body>
</html>

