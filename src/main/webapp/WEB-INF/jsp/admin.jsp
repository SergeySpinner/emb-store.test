<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin profile</title>
</head>
    <body>
        <p>Id : ${user.id}</p>
        <p>Name : ${user.userName}</p>
        <p>Password : ${user.password}</p>

        <button onclick="window.location.href='/HillelProject/emb-store/shop-page';">Shop page</button>

        <button onclick="window.location.href='/HillelProject/emb-store/basket';">Basket page</button>

        <button onclick="window.location.href='/HillelProject/emb-store/logout';">Log out</button>
    </body>
</html>
