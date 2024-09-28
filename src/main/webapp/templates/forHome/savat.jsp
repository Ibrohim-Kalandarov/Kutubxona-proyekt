<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Barcha Kitoblar</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            margin: 0 auto;
            padding-top: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .book-item {
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
        }

        /* Chap tomonda kitob rasmi */
        .book-item img {
            width: 120px;
            height: auto;
        }

        /* O'rtada kitob haqida ma'lumot */
        .book-info {
            flex-grow: 1;
            text-align: center; /* O'rtaga keltirish */
        }

        .book-info h3 {
            font-size: 18px;
            color: #007bff;
            margin-bottom: 10px;
        }

        .book-info p {
            margin: 5px 0;
            color: #555;
        }

        /* O'ng tomonda tugmalar */
        .book-actions {
            display: flex;
            flex-direction: column;
            align-items: flex-start; /* Chap tomonga joylash */
            gap: 10px;
        }

        .book-actions button {
            background-color: #007bff;
            color: black;
            padding: 7px 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-size: 14px;
        }

        .book-actions button:hover {
            opacity: 0.9;
        }

        /* Tugmalar uchun ranglar */
        .book-actions .rent-btn {
            background-color: gold;
        }

        .book-actions .cart-btn {
            background-color: #007bff;
        }

        .book-actions .buy-btn {
            background-color:#28a745; /* yashil */
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Sizning Savatingizdagi Barcha Kitoblar</h2>

    <!-- Kitoblar ro'yxati -->
    <div class="book-list">
        <c:forEach var="book" items="${books}">
            <div class="book-item">
                <!-- Kitob rasmi chap tomonda -->
                <img src="img/${book.img}" alt="${book.title}">

                <!-- Kitob ma'lumotlari o'rtada -->
                <div class="book-info">
                    <h3>${book.title}</h3>
                    <p><strong>Author:</strong> ${book.author}</p>
                    <p><strong>ISBN:</strong> ${book.isbn}</p>
                    <p><strong>Publisher:</strong> ${book.publisher}</p>
                    <p><strong>Price:</strong> ${book.price}</p>
                </div>

                <!-- Tugmalar chap burchakda -->
                <div class="book-actions">
                    <form action="/add-rent" method="get">
                        <input type="hidden" name="bookId" value="${book.id}">
                        <button type="submit" class="rent-btn">Add Rent</button>
                    </form>

                    <form action="/deletetocart" method="post">
                        <input type="hidden" name="bookId" value="${book.id}">
                        <button type="submit" class="cart-btn">Delete to Cart</button>
                    </form>

                    <form action="/buybook" method="post">
                        <input type="hidden" name="bookId" value="${book.id}">
                        <button type="submit" class="buy-btn">Buy</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
