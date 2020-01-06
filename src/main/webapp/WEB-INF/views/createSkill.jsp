<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <title>Create Skill</title>
</head>
<body>
<h1>Create SKill</h1>
<%
    if (request.getAttribute("skill") != null) {
        out.println("<p>" + request.getAttribute("skill") + "</p>");
    }
%>
<form method="post">
    <label>Name<br/>
        <input type="text" name="name"><br/>
    </label>
    <button class="submit" type="submit"><span>Submit</span></button>
</form>
<button class="back" onclick="location.href='/'"><span>Back</span></button>
</body>
</html>