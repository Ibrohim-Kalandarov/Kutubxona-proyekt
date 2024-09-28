<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verify Your Email</title>
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
            text-align: center;
        }

        .form-container h2 {
            margin-bottom: 20px;
            color: #333;
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
            margin-top: 15px;
        }

        .form-container a:hover {
            color: #2980b9;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
            text-align: left;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Verify Your Email</h2>
    <form action="/auth" method="post">
        <input value="${email}" id="email" type="hidden" name="email">
        <div>
            <label for="code">Enter Verification Code</label>
            <input id="code" type="text" name="code" placeholder="Enter code" required>
        </div>
        <div>
            <button type="submit">Submit</button>
        </div>
        <div>
            <a href="/signin">Sign In</a>
        </div>
    </form>
</div>
</body>
</html>
