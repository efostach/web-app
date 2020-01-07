<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <title>Create Customer</title>
</head>
<body>
<h1>Create Customer</h1>
<%
    String msg = (String) request.getAttribute("warning_msg");
    if (msg == null) {
        if (request.getAttribute("customer") != null) {
            out.println("<p>" + request.getAttribute("customer") + "</p>");
        }
    } else out.println("<p>" + msg + "</p>");
%>
<form method="post">
    <label>Name<br/>
        <input type="text" name="name"><br/>
    </label>
    <label>Project<br/>
        <input type="text" name="project"><br/>
    </label>
    <button class="submit" type="submit"><span>Submit</span></button>
</form>
<button class="back" onclick="location.href='/'"><span>Back</span></button>
</body>
</html>