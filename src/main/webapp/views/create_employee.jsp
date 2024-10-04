<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/3/2024
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employees</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

</head>
<body class="create-page">
<h2>Create New Employee</h2>
<form class="create-form" action="employee?action=create" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone"><br>

    <label for="post">Post:</label>
    <input type="text" id="post" name="post"><br>

    <label for="department_id">Department ID:</label>
    <input type="number" id="department_id" name="department_id" required><br>

    <input type="submit" value="Create Employee" class="submit-btn">
</form>
</body>
</html>
