<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Malumotlar</title>
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
        <form action="${pageContext.request.contextPath}/show-rents-J" method="get">
            <button type="submit">Jarima bilan tugatilgan ijaralar</button>
        </form>
    </div>
    <div class="button-row">
        <form action="${pageContext.request.contextPath}/showactiveusers" method="get">
            <button type="submit">Show Active Users</button>
        </form>
        <form action="${pageContext.request.contextPath}/showpassiveusers" method="get">
            <button type="submit">Show Passive Users</button>
        </form>
    </div>

    <div class="button-row">
        <form action="${pageContext.request.contextPath}/showactiverents" method="get">
            <button type="submit">Show Active Rents</button>
        </form>
        <form action="${pageContext.request.contextPath}/showpassiverents" method="get">
            <button type="submit">Show Passive Rents</button>
        </form>

    </div>

    <div class="button-row">
        <form action="${pageContext.request.contextPath}/show-rents-MU" method="get">
            <button type="submit">Muddati O'tayotgan Ijaralar</button>
        </form>
        <form action="${pageContext.request.contextPath}/show-buy-books-admin" method="get">
            <button type="submit">Sotib olingan kitoblar</button>
        </form>

    </div>

</div>
</body>
</html>
