<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <title>Search Employee</title>
</head>
<body>
<h1>Search Employee</h1>
<%
    String msg = (String) request.getAttribute("warning_msg");
    if (msg == null) {
        if (request.getAttribute("employee") != null) {
            out.println("<p>" + request.getAttribute("employee") + "</p>");
        }
    } else out.println("<p>" + msg + "</p>");
%>
<form method="post">
    <label>Id<br/>
        <input type="text" name="id"><br/>
    </label>
    <button class="submit" type="submit"><span>Search</span></button>
</form>
<button class="back" onclick="location.href='/'"><span>Back</span></button>
</body>
</html>