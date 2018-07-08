<%--suppress XmlPathReference --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="fragments/front.jsp"/>


    <title>Title</title>
</head>
<body>

<c:import url="fragments/header.jsp"/>

<br>
<h3 style="margin-left: 5%">Current orders</h3>
<c:forEach var="map" items="${requestScope.ordersMap}">
    <table class="table table-hover" style="width: 90%; margin-right: 5%; margin-left: 5%">
        <thead>
        <tr>
            <th scope="col" style="width: 10%">#Id ${map.key.id}</th>
            <th scope="col" colspan="2" style="width: 90%">${map.key.name} ${map.key.surname}</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${map.value}">
            <tr>
                <th scope="row" style="width: 10%">${order.id}</th>
                <td style="width: 80%">${order.problemDescription}</td>
                <td style="width: 10%"><a href="/order?id=${order.id}" class="btn btn-primary">Details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:forEach>




<c:import url="fragments/footer.jsp"/>
</body>
</html>
