<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Card</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f7f9fb;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: #ffffff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            width: 350px;
        }

        .form-container h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .form-container input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-container button:hover {
            background-color: #2980b9;
        }

        .form-container a {
            text-decoration: none;
            color: #3498db;
            display: block;
            text-align: center;
            margin-top: 15px;
        }

        .form-container a:hover {
            color: #2980b9;
        }

        .form-container label {
            display: none;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Add Card</h2>
    <form action="/add-card" method="post">
        <div>
            <input id="name" type="text" name="name" placeholder="Enter Card Name" required>
        </div>
        <div>
            <input id="balance" type="text" name="balance" placeholder="Enter Balance" required>
        </div>
        <div>
            <input id="number" type="text" name="number" placeholder="Enter Card Number" required>
        </div>

        <div>
            <button type="submit">Add</button>
        </div>

    </form>
</div>
</body>
</html>
