<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Active Rents</title>
    <style>
        /* Umumiy stil */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            font-family: 'Roboto', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        /* Tablitsa dizayni */
        table {
            width: 90%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px 20px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        /* Tugma dizayni */
        button {
            padding: 10px 20px;
            font-size: 14px;
            background-color: #2E7D32;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #1B5E20;
        }

        /* Maxsus formaning tugmasini o'ng tomonga joylashtirish */
        form {
            display: inline;
        }

        td:last-child {
            text-align: center;
        }
    </style>
</head>
<body>
<h2>Barcha Faol Ijaralar</h2>
<table>
    <tr>
        <th>Id</th>
        <th>User</th>
        <th>Category Name</th>
        <th>Book Name</th>
        <th>From Date</th>
        <th>To Date</th>
        <th>Active</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="rent" items="${rents}">
        <tr>
            <td>${rent.id}</td>
            <td>${rent.user.name}</td>
            <td>${rent.book.category.name}</td>
            <td>${rent.book.title}</td>
            <td>${rent.from_date}</td>
            <td>${rent.to_date}</td>
            <td>${rent.active ? 'active' : 'passive'}</td>
            <td>
                <form action="/return-rent" method="post">
                    <input type="hidden" name="id" value="${rent.id}">
                    <button type="submit">Return</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
