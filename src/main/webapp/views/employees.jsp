<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h2>Employees List</h2>
<form action="employee?action=search" method="get">
    <label for="keyword">Name:</label>
    <input type="text" id="keyword" name="keyword" placeholder="Search by name, email, post">
    <button type="submit" name="action" value="search">Search</button>
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Department</th>
        <th>Actions</th>
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

<a href="employee?action=create" class="create-btn">Create Employee</a>
</body>
</html>
