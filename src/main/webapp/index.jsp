<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kutubxona</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('templates/images/library-background.jpg');
            background-size: cover;
            background-position: center;
        }

        header {
            background-color: rgba(51, 51, 51, 0.8);
            color: #fff;
            padding: 10px 0;
            text-align: center;
            position: relative;
        }

        nav {
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: rgba(68, 68, 68, 0.8);
            padding: 10px;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            display: flex;
        }

        nav ul li {
            margin-right: 20px;
        }

        nav ul li a {
            color: #fff;
            text-decoration: none;
        }

        nav ul li a:hover {
            text-decoration: underline;
        }

        .categories {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 20px;
            text-align: center;
            margin: 0 auto;
        }

        .categories ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .categories ul li {
            display: inline;
            margin-right: 20px;
        }

        .categories ul li a {
            text-decoration: none;
            color: #333;
        }

        .categories ul li a:hover {
            text-decoration: underline;
        }

        .search-container {
            position: relative;
            text-align: center;
            margin: 20px 0;
        }

        .search-bar {
            position: relative;
            display: inline-block;
            background-color: rgba(255, 255, 255, 0.9);
            padding: 20px;
            border-radius: 10px;
        }

        .search-bar input[type="text"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 300px;
        }

        .search-bar input[type="submit"] {
            padding: 10px 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #555;
            color: #fff;
            cursor: pointer;
        }

        .search-bar input[type="submit"]:hover {
            background-color: #666;
        }


        .main-image img {
            max-width: 80%;
            height: auto;
            border-radius: 10px;
        }

        main {
            padding: 20px;
            text-align: center;
        }

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/show-books">Kitoblarni ko'rsatish</a></li>
            <li><a href="/add-rent" methods="get">Ijaraga olish</a></li>
            <li><a href="/return-rent" methods="get">Ijarani qaytarish</a></li>
            <li><a href="/show-rent">Ijara tarixini ko'rsatish</a></li>
            <li><a href="/show-cart" methods="get">Savat</a></li>
            <li><a href="/show-buy" methods="get">Sotib olinganlarni ko'rsatish</a></li>
            <li><a href="/add-card" methods="get">Card Qo'shish</a></li>
        </ul>
    </nav>
</header>
<div class="categories">
    <h2>Kategoriyalar</h2>
    <ul>
        <li><a href="/category_school" methods="get">Maktab</a></li>
        <li><a href="/category_college" methods="get">Kollej</a></li>
        <li><a href="/category_university" methods="get">Universitet</a></li>
        <li><a href="/category_ilmiy" methods="get">Ilmiy</a></li>
        <li><a href="/category_badiiy" methods="get">Badiiy</a></li>
        <li><a href="/category_sarguzasht" methods="get">Sarguzasht</a></li>
        <li><a href="/category_fan" methods="get">Fan</a></li>
        <li><a href="/category_madaniyat" methods="get">Madaniyat</a></li>
        <li><a href="/category_sport" methods="get">Sport</a></li>
        <li><a href="/category_bolalar_adabiyoti" methods="get">Bolalar Adabiyoti</a></li>
    </ul>
</div>
<div class="search-container">
    <div class="search-background"></div>
    <form action="/search" method="get" class="search-bar">
        <input type="text" name="query" placeholder="Qidirish...">
        <input type="submit" value="Qidirish">
    </form>
</div>
<main>
    <section id="content">
    </section>
</main>
<footer>
    <p>&copy; 2024 Kutubxona. Barcha huquqlar himoyalangan.</p>
</footer>
</body>
</html>
