<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WARNING</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .warning-container {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            width: 80%;
            max-width: 500px;
        }

        .warning-container h3 {
            color: #d9534f; /* Qizil rang */
            font-size: 18px;
            margin-bottom: 20px;
        }

        .warning-container a {
            color: #007bff; /* Ko'k rang */
            text-decoration: none;
            font-size: 16px;
        }

        .warning-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="warning-container">
    <h3><c:out value="${warning}" /></h3>
    <a href="${url}">Back</a>
</div>
</body>
</html>
