<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer profile</title>
</head>
    <body>
        <table>
            <td>
                <p>Id : ${user.id}</p>
                <p>Name : ${user.userName}</p>
                <p>Password : ${user.password}</p>

                <button onclick="window.location.href='/HillelProject/emb-store/logout';">Log out</button>
            </td>
            <td style="font-family: 'Arial Rounded MT Bold'; font-size: 25px">
                <p>Current temperature: ${currentTemp}</p>
                <p>Minimum: ${minimumTemp} Maximum: ${maximumTemp}</p>
                <p>Humidity: ${humidity}%</p>
            </td>
            <td>
                Your products:<br>
                <c:forEach items="${products}" var="product">
                    <c:out value="${product.id}"/>
                    <c:out value="${product.name}"/>
                    <c:out value="${product.price}"/>
                    <c:out value="${product.prodQuantity}"/>
                    <c:out value="${product.prodInfo}"/>
                    <br>
                </c:forEach>
            </td>

        </table>
    </body>
</html>
