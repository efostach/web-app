<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <title>Create Employee</title>
</head>
<body>
<h1>Create Employee</h1>
<%
    String msg = (String) request.getAttribute("warning_msg");
    if (msg == null) {
        if (request.getAttribute("employee") != null) {
            out.println("<p>" + request.getAttribute("employee") + "</p>");
        }
    } else out.println("<p>" + msg + "</p>");
%>
<form method="post">
    <label>First Name<br/>
        <input type="text" name="first_name"><br/>
    </label>
    <label>Last Name<br/>
        <input type="text" name="last_name"><br/>
    </label>
    <label>Specialty<br/>
        <input type="text" name="specialty"><br/>
    </label>
    <label>Skill<br/>
        <input type="text" name="skill"><br/>
    </label>
    <button class="submit" type="submit"><span>Submit</span></button>
</form>
<button class="back" onclick="location.href='/'"><span>Back</span></button>
</body>
</html>