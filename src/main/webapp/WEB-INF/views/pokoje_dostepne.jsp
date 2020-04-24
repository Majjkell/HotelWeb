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
            <button style="cursor: default;" class="btn btn-secondary">Liczba osob:</button><button type="button" class="btn btn-success"><c:out value="${r.num_of_ppl}"/></button> <br>
            <button style="cursor: default;" class="btn btn-secondary">Cena:</button><button type="button" class="btn btn-success"><c:out value="${r.price}"/></button> <br>
            <button style="cursor: default;" class="btn btn-secondary">Ocena Gosci:</button><button type="button" class="btn btn-success"> <c:out value="${r.rating}"/></button><br>
            <button style="cursor: default;" class="btn btn-secondary">Nr Pokoju:</button><button type="button" class="btn btn-success"> <c:out value="${r.numberOfRoom}"/></button><br>
            <button style="cursor: default;" class="btn btn-secondary">Pokoj konferencyjny:</button><button type="button" class="btn btn-success"> <c:out value="${r.conference_room}"/></button><br>
            <button style="cursor: default;" class="btn btn-secondary">Typ pokoju:</button><button type="button" class="btn btn-success"> <c:out value="${r.type_room}"/></button><br>
            <button style="cursor: default;" class="btn btn-secondary">Dodatkowe informacje:</button><button type="button" class="btn btn-success"><c:out value="${r.add_info}"/></button><br>
            <a href="/reservation/${r.numberOfRoom}" class="rp">Rezerwuj</a>
        </section>
    </c:forEach>
</body>
</html>
