<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Card Information</title>
    <style>
        table {
            width: 50%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #f4f4f4;
        }
        button {
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<table>
    <thead>
    <tr>
<%--        <th>Card ID</th>--%>
        <th>Card Name</th>
        <th>Card Number</th>
        <th>Balance</th>
        <th>Card Type</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
<%--        <td>${card.id}</td>--%>
        <td>${card.cardName}</td>
        <td>${card.cardNumber}</td>
        <td>${card.balance}</td>
        <td>${card.cardType}</td>
        <td>
            <form action="<c:url value='/add-amount'/>" method="get">
                <input type="hidden" name="cardId" value="${card.id}">
                <button type="submit">Add Amount</button>
            </form>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
