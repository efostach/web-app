<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Menu</title>--%>
<%--    <style><%@include file="/WEB-INF/css/style.css"%></style>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <h1>Menu:</h1>--%>
<%--    <p>1. Crete <strong>Project</strong></p>--%>
<%--    <p>2. Complete <strong>Project</strong></p>--%>
<%--    <p>3. Show All <strong>Projects</strong></p>--%>
<%--    <p>4. Find <strong>Project</strong></p>--%>

<%--    <p>5. Create <strong>Employee</strong></p>--%>
<%--    <p>6. Update <strong>Employee</strong></p>--%>
<%--    <p>7. Show All <strong>Employees</strong></p>--%>
<%--    <p>8. Find <strong>Employee</strong></p>--%>

<%--    <p>9. Create <strong>Team</strong></p>--%>
<%--    <p>10. Update <strong>Team</strong></p>--%>
<%--    <p>11. Show All <strong>Teams</strong></p>--%>
<%--    <p>12. Find <strong>Team</strong></p>--%>

<%--    <p>13. Create <strong>Skill</strong></p>--%>
<%--    <p>14. Update <strong>Skill</strong></p>--%>
<%--    <p>15. Show All <strong>Skills</strong></p>--%>
<%--    <p>16. Find <strong>Skill</strong></p>--%>
<%--    <br/>--%>
<%--    Enter Action Number: <input type="text" name="specialty">--%>
<%--    <input type="submit" value="Submit"/>--%>
<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<!-- header -->
<div>
    <h1>Menu</h1>
</div>

<div>       <!-- content -->
    <div>    <!-- buttons holder -->
        <button onclick="location.href='/project/create'">Crete Project</button>
        </br>
        <button onclick="location.href='/project/update'">Complete Project</button>
    </div>
</div>
</body>
</html>