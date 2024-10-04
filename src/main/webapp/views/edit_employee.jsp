<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/4/2024
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Employee</h1>

<form action="employee?action=update" method="post">
    <!-- Hidden field to pass employee ID -->
    <input type="hidden" name="id" value="${employee.id}">

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${employee.name}" required>
    <br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${employee.email}" required>
    <br>

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" value="${employee.phone}">
    <br>

    <label for="post">Post:</label>
    <input type="text" id="post" name="post" value="${employee.post}">
    <br>

    <label for="department_id">Department:</label>
    <input type="text" id="department_id" name="department_id" value="${employee.departement.id}" readonly>
    <br>

    <input type="submit" value="Update Employee">
</form>

<a href="/employee">Back to Employees List</a>
</body>
</html>
