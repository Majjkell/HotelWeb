<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pokoje</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@ include file="nav.jsp" %>
<section class="s1">
<p>Dane szukanego pokoju</p>
    <form:form modelAttribute="reservation" action="/wybor_pokoju" method="POST">
        Liczba osob: <form:input type="number" path="num_of_ppl"/>
        Pobyt od: <form:input type="date" pattern="yyyy-MM-dd" path="date_from" />
        Pobyt do: <form:input type="date" pattern="yyyy-MM-dd" path="date_to"/>
        Typ pokoju: <form:select path="room_type" items="${type}"/>
        <input type="submit"value="Dalej">
    </form:form>




</section>
<%--    <c:forEach items="${rooms1}" var="rt">--%>
<%--        <section class="s2">--%>
<%--        <p class="num_of_ppl_t">Liczba osob: 2-4</p>--%>
<%--        <p class="type_room_t">Typ Pokoju: <c:out value="${rt.add_info}"/></p>--%>
<%--        <p class="price_t">Cena Pokoju Od: <c:out value="${rt.price}"/></p>--%>
<%--        </section>--%>
<%--    </c:forEach>--%>
<%@ include file="pokoje_dostepne.jsp" %>
</body>
</html>
