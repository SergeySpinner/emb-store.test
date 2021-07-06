<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Basket page</title>
    </head>
    <body>
        <table>
            <c:forEach items="${basket} , ${cringe}" var="item">
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.price}"/></td>
                    <td><c:out value="${item.prodInfo}"/></td>
                    <td><a href="deleteBasketItem?productId=${product.id}"> Delete this product</a> </td>
                </tr>
            </c:forEach>
        </table>
        <button onclick="window.location.href='/HillelProject_war_exploded/emb-store/profile';">Go to profile</button>
    </body>
</html>
