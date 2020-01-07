<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <title>Create Team</title>
</head>
<body>
<h1>Create Team</h1>
<%
    String msg = (String) request.getAttribute("warning_msg");
    if (msg == null) {
        if (request.getAttribute("team") != null) {
            out.println("<p>" + request.getAttribute("team") + "</p>");
        }
    } else out.println("<p>" + msg + "</p>");
%>
<form method="post">
    <label>Name<br/>
        <input type="text" name="name"><br/>
    </label>
    <label>Employee<br/>
        <input type="text" name="employee"><br/>
    </label>
    <button class="submit" type="submit"><span>Submit</span></button>
</form>
<button class="back" onclick="location.href='/'"><span>Back</span></button>
</body>
</html>