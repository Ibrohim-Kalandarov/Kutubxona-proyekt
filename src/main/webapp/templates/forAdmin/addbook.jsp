<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a New Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-top: 50px;
        }

        form {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin: 10px 0;
            font-weight: bold;
        }

        input[type="text"], input[type="number"], select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 20px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h2>Add a New Book</h2>
<form action="/addbook" method="post">
    <label>Author: <input type="text" name="author" required></label><br>
    <label>ISBN: <input type="text" name="isbn" required></label><br>
    <label>Quantity: <input type="number" name="quantity" required></label><br>
    <label>Price: <input type="text" name="price" required></label><br>
    <label>Publisher: <input type="text" name="publisher" required></label><br>
    <label>Title: <input type="text" name="title" required></label><br>
    <label>Category:
        <select name="categoryId" required>
            <option value="">Select a Category</option>
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
    </label><br>
    <input type="submit" value="Add Book">
</form>
</body>
</html>
