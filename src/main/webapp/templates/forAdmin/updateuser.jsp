<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 9/11/2024
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<h2>Update User</h2>
<form action="/updateuser" method="post">

    <input type="hidden" name="id" value="<c:out value="${user.getId()}" />">

    <div>
        <label>Enter Name</label>
        <input value="<c:out value='${user.getName()}'/>" type="text" name="name" placeholder="name">
    </div>
    <div>
        <label>Enter Email</label>
        <input value="<c:out value='${user.getEmail()}'/>" type="text" name="email" placeholder="email">
    </div>
    <div>
        <label>Enter Age</label>
        <input value="<c:out value='${user.getAge()}'/>" type="number" name="age" placeholder="age">
    </div>
    <div>
        <label>Enter Password</label>
        <input value="<c:out value='${user.getPassword()}'/>" type="text" name="password" placeholder="password">
    </div>
    <div>
        <label>Select Role</label>
        <select name="role">
            <option value="USER" <c:if test="${user.getRole() == 'USER'}">selected</c:if>>USER</option>
            <option value="ADMIN" <c:if test="${user.getRole() == 'ADMIN'}">selected</c:if>>ADMIN</option>
        </select>
    </div>

    <div>
        <button type="submit">Update</button>
    </div>
</form>
</body>
</html>
