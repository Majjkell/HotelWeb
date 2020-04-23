<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wybor Pokoju</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
    <c:forEach items="${rooms}" var="r">
        <section>
            Liczba osob: <c:out value="${r.num_of_ppl}"/> <br>
            Cena: <c:out value="${r.price}"/><br>
            Ocena Gosci: <c:out value="${r.rating}"/><br>
            Nr Pokoju: <C:out value="${r.number_of_room}"/><br>
            Pokoj konferencyjny: <c:out value="${r.conference_room}"/><br>
            Typ pokoju: <c:out value="${r.type_room}"/><br>
            Dodatkowe informacje: <c:out value="${r.add_info}"/><br>
            <a href="/reservation/${r.number_of_room}" class="rp">Rezerwuj</a>
        </section>
    </c:forEach>
</body>
</html>
