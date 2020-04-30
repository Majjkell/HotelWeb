<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body style="background-color: black;">
<c:forEach items="${myReservations}" var="reservation">
    <table class="table table-bordered">
        <tr>
            <th class="bg-info" colspan="2">DANE DOTYCZACE DANEJ REZERWACJI</th>
        </tr>
        <tr>
            <th class="bg-info" >Nr pokoju:</th>
            <td class="bg-info"><c:out value="${reservation.room.numberOfRoom}"/></td>
        </tr>
        <tr>
            <th class="bg-info">Liczba osob:</th>
            <td class="bg-info"><c:out value="${reservation.numOfPpl}"/></td>
        </tr>
        <tr>
            <th class="bg-info">Od kiedy:</th>
            <td class="bg-info"><c:out value="${reservation.dateFrom}"/></td>
        </tr>
        <tr>
            <th class="bg-info">Do Kiedy:</th>
            <td class="bg-info"><c:out value="${reservation.dateTo}"/></td>
        </tr>
        <tr>
            <th class="bg-info">Cena:</th>
            <td class="bg-info"><c:out value="${reservation.room.price}"/></td>
        </tr>
        <tr>
            <th class="bg-info">Dodatkowe informacje:</th>
            <td class="bg-info"><c:out value="${reservation.addInfo}"/></td>
        </tr>
        <tr>
            <th class="bg-info">Typ pokoju:</th>
            <td class="bg-info"><c:out value="${reservation.roomType}"/></td>
        </tr>
    </table>
</c:forEach>
<a href="/">Back To Home Page</a>
</body>
</html>
