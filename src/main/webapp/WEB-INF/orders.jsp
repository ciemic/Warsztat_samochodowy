<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="fragments/front.jsp"/>

    <title>Car service - Orders</title>
</head>
<body>

<c:import url="fragments/header.jsp"/>

<br>
<h3 style="margin-left: 5%">Current orders</h3>
<table class="table table-hover" style="width: 90%; margin-right: 5%; margin-left: 5%">
    <thead>
    <tr>
        <th scope="col" style="width: 5%">#Id</th>
        <th scope="col" style="width: 5%">Order status</th>
        <th scope="col" style="width: 80%">Problem description</th>
        <th scope="col" style="width: 10%">Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
        <tr>
            <th scope="row" style="width: 5%">${order.id}</th>
            <th scope="row" style="width: 15%">
                <c:choose>
                    <c:when test="${order.statusId==1}">In service</c:when>
                    <c:when test="${order.statusId==2}">Accepted costs</c:when>
                    <c:when test="${order.statusId==3}">Maintenance activities in progress</c:when>
                    <c:when test="${order.statusId==4}">Ready for collection</c:when>
                    <c:otherwise>Error</c:otherwise>
                </c:choose>
            </th>
            <td style="width: 70%">${order.problemDescription}</td>
            <td style="width: 10%"><a href="/order?id=${order.id}" class="btn btn-primary">Select</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<c:import url="fragments/footer.jsp"/>
</body>
</html>
