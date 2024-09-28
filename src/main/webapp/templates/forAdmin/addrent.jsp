<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Rent</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .form-container {
            width: 80%;
            max-width: 400px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
        }

        .form-container h2 {
            font-size: 24px;
            color: #007bff;
            margin-bottom: 20px;
        }

        .form-container label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
            color: #555;
        }

        .form-container input[type="text"],
        .form-container input[type="date"] {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 20px;
            font-size: 16px;
        }

        .form-container button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 4px;
            font-size: 16px;
        }

        .form-container button:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Add Rent</h2>

    <form action="/addrent" method="post">
        <div>
            <label for="userId">User ID</label>
            <input type="text" id="userId" name="userId" placeholder="Enter User ID" required>
        </div>
        <div>
            <label for="bookId">Book ID</label>
            <input type="text" id="bookId" name="bookId" placeholder="Enter Book ID" required>
        </div>
        <div>
            <label for="toDate">To Date</label>
            <input type="date" id="toDate" name="toDate" required>
        </div>
        <button type="submit">Add</button>
    </form>
</div>
</body>
</html>
