<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .button-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 10px;
        }

        .button-row {
            display: flex;
            gap: 10px;
        }

        button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="button-container">

    <div class="button-row">
        <form action="${pageContext.request.contextPath}/malumotlar" method="get">
            <button type="submit">Malumotlar</button>
        </form>

    </div>
    <div class="button-row">
        <form action="${pageContext.request.contextPath}/addrent" method="get">
            <button type="submit">Add Rent</button>
        </form>
        <form action="${pageContext.request.contextPath}/showrents" method="get">
            <button type="submit">Show Rents</button>
        </form>
    </div>

      <div class="button-row">
        <form action="${pageContext.request.contextPath}/showusers" method="get">
            <button type="submit">Show Users</button>
        </form>
        <form action="${pageContext.request.contextPath}/showbooks" method="get">
            <button type="submit">Show Books</button>
        </form>

    </div>

</div>
</body>
</html>
