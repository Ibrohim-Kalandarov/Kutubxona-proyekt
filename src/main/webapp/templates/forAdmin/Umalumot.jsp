<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Passive Rents</title>
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
            background-color: #2E7D32;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #1B5E20;
        }
    </style>
</head>
<body>
<h2><c:out value="${malumot}"/></h2>
<table>
    <tr>
        <th>R id</th>
        <th>U id</th>
        <th>B id</th>
        <th>From Date</th>
        <th>To Date</th>
        <th>Present Date</th>
        <th>Day</th>
        <th>Jarima</th>
        <th>Active</th>
    </tr>
    <c:forEach var="rent" items="${rents}">
        <tr>
            <td>${rent.id}</td>
            <td>${rent.user.id}</td>
            <td>${rent.book.id}</td>
            <td>${rent.from_date}</td>
            <td>${rent.to_date}</td>
            <td><%= LocalDate.now() %></td>
            <td>${rent.jarima/20000}</td>
            <td>${rent.jarima}</td>
            <td>${rent.active}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
