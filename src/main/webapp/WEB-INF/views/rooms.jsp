<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<section class="s2">Przykladowy typ pokoju z 'add_info' i zdj losowym dla danego typu      X Ilosc typow</section>
</body>
</html>
