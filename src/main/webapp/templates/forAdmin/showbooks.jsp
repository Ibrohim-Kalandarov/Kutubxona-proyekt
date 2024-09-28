<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show Books</title>
    <style>

        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            font-family: Arial, sans-serif;
        }

        h2 {
            margin-top: 20px;
        }

        .add-book {
            text-align: center;
            margin-top: 10px;
            margin-bottom: 20px;
            color: #2E7D32;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 8px 12px;
            text-align: center;
            font-size: 14px;
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
            font-size: 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .update-btn {
            background-color: #008CBA;
            color: white;
        }

        .update-btn:hover {
            background-color: #007bb5;
        }


    </style>
</head>
<body>

<h2>Barcha Kitoblar</h2>

<div class="add-book">
    <form action="/addbook" method="get" style="display:inline;">
        <button type="submit">Add Book</button>
    </form>
</div>

<table>
    <tr>
        <th>Id</th>
        <th>Category</th>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Quantity</th>
        <th>ISBN</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.category.name}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.quantity}</td>
            <td>${book.isbn}</td>
            <td>
                <form action="/updatebook" method="get" style="display:inline;">
                    <input type="hidden" name="bookId" value="${book.id}">
                    <button type="submit" class="update-btn">Update</button>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
