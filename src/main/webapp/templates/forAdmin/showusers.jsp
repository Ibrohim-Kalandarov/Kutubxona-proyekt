<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All Users</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            font-family: Arial, sans-serif;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        table, th, td {
            border: none;
        }

        button {
            padding: 8px 16px;
            font-size: 14px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .update-btn {
            background-color: cornflowerblue;
            color: black;
        }

        .update-btn:hover {
            background-color: cornflowerblue;
        }

        /*!* Delete tugmasi uchun qizil rang *!*/
        /*.delete-btn {*/
        /*    background-color: #F44336;*/
        /*    color: white;*/
        /*}*/

        /*.delete-btn:hover {*/
        /*    background-color: #D32F2F;*/
        /*}*/
    </style>
</head>
<body>
<h2><c:out value="${malumot}" /></h2>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Age</th>
        <th>Active</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td>${user.active}</td>
            <td>${user.role}</td>
            <td>
                <form action="/updateuser" method="get" style="display:inline;">
                    <input type="hidden" name="email" value="${user.email}">
                    <button type="submit" class="update-btn">Update</button>
                </form>

<%--                <form action="/deleteuser" method="post" style="display:inline;">--%>
<%--                    <input type="hidden" name="id" value="${user.id}">--%>
<%--                    <button type="submit" class="delete-btn">Delete</button>--%>
<%--                </form>--%>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
