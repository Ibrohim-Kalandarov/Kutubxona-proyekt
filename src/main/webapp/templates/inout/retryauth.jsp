<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verify Your Email</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
        }

        .form-container h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .form-container input {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
        }

        .form-container button {
            width: 100%;
            padding: 12px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-container button:hover {
            background-color: #218838;
        }

        .form-container a {
            text-decoration: none;
            color: #007bff;
            margin-top: 15px;
            display: inline-block;
        }

        .form-container a:hover {
            color: #0056b3;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
            text-align: left;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Verify Your Email</h2>
    <form action="/retryauth" method="post">
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
