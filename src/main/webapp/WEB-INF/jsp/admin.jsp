<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin profile</title>
</head>
    <body>
        <table>
            <td>
                <p>Id : ${user.id}</p>
                <p>Name : ${user.userName}</p>
                <p>Password : ${user.password}</p>
                <p>Role : ${user.role}</p>

                <button onclick="window.location.href='/HillelProject/emb-store/shop-page';">Shop page</button>

                <button onclick="window.location.href='/HillelProject/emb-store/basket';">Basket page</button>

                <button onclick="window.location.href='/HillelProject/emb-store/logout';">Log out</button>
            </td>
            <td style="font-family: 'Arial Rounded MT Bold'; font-size: 25px">
                <p>Current temperature: ${currentTemp}</p>
                <p>Minimum: ${minimumTemp} Maximum: ${maximumTemp}</p>
                <p>Humidity: ${humidity}%</p>
            </td>
        </table>

    </body>
</html>
