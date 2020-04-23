<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wybor Pokoju</title>
</head>
<body>
    <c:forEach items="${rooms}" var="r">
        <section>
            Liczba osob: <c:out value="${r.num_of_ppl}"/> <br>
            Cena: <c:out value="${r.price}"/><br>
            Ocena Gosci: <c:out value="${r.rating}"/><br>
            Nr Pokoju: <C:out value="${r.number}"/><br>
            Pokoj konferencyjny: <c:out value="${r.conference_room}"/><br>
            Typ pokoju: <c:out value="${r.type_room}"/><br>
            Dodatkowe informacje: <c:out value="${r.add_info}"/><br>
            <a href="/reservation/${r.number}">Rezerwuj</a>
        </section>
    </c:forEach>
</body>
</html>
