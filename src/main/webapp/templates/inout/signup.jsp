<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
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
    <h2>Sign Up</h2>
    <form action="/signup" method="post">
        <div>
            <input id="name" type="text" name="name" placeholder="Enter Name" required>
        </div>
        <div>
            <input id="age" type="number" name="age" placeholder="Enter Age" required>
        </div>
        <div>
            <input id="email" type="email" name="email" placeholder="Enter Email" required>
        </div>
        <div>
            <input id="password" type="password" name="password" placeholder="Enter Password" required>
        </div>
        <div>
            <button type="submit">Submit</button>
        </div>
        <a href="/signin">Sign in here</a>
    </form>
</div>
</body>
</html>
