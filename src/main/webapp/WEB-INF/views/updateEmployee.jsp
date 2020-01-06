<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <title>Update Employee</title>
</head>
<body>
<h1>Update Employee</h1>
<form method="post">
    <label>Id<br/>
        <input type="text" name="id"><br/>
    </label>
    <label>First Name<br/>
        <input type="text" name="first_name"><br/>
    </label>
    <label>Last Name<br/>
        <input type="text" name="last_name"><br/>
    </label>
    <label>Specialty<br/>
        <input type="text" name="specialty"><br/>
    </label>
    <button class="submit" type="submit"><span>Update</span></button>
</form>
<button class="back" onclick="location.href='/'"><span>Back</span></button>
</body>
</html>