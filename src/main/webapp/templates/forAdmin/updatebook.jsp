<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h2 {
            text-align: center;
            color: #333;
            font-size: 24px;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        label {
            font-size: 14px;
            color: #666;
            display: block;
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="number"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        div {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>


<form action="/updatebook" method="post">
    <input type="hidden" name="id" value="${book.id}">

    <div>
        <label>Title</label>
        <input type="text" name="title" placeholder="title" value="${book.title}">
    </div>
    <div>
        <label>Author</label>
        <input type="text" name="author" placeholder="author" value="${book.author}">
    </div>
    <div>
        <label>Publisher</label>
        <input type="text" name="publisher" placeholder="publisher" value="${book.publisher}">
    </div>
    <div>
        <label>Quantity</label>
        <input type="number" name="quantity" placeholder="quantity" value="${book.quantity}">
    </div>
    <div>
        <label>Price</label>
        <input type="text" name="price" placeholder="price" value="${book.price}">
    </div>
    <div>
        <label>Isbn</label>
        <input type="text" name="isbn" placeholder="isbn" value="${book.isbn}">
    </div>
    <div>
        <label>Category:
            <select name="categoryId" required>
                <option value="">Select a Category</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </label><br>
    </div>

    <div>
        <button type="submit">Update</button>
    </div>
</form>
</body>
</html>
