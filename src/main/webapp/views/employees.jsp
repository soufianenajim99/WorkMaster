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
    <title>Employee List</title>
</head>
<body>
<h2>Employees List</h2>
<form action="employee" method="get">
    <input type="text" name="keyword" placeholder="Search by name, email, post">
    <button type="submit" name="action" value="search">Search</button>
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Department</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.phone}</td>
            <td>${employee.departement.name}</td>
            <td>
                <a href="employee?action=edit&id=${employee.id}">Edit</a>
                <a href="employee?action=delete&id=${employee.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="employee?action=create">Create Employee</a>
</body>
</html>
