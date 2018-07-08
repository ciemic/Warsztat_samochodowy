<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="fragments/front.jsp"/>


    <title>Car service - customers</title>
</head>
<body>

<c:import url="fragments/header.jsp"/>



<br>
<h3 style="margin-left: 5%">Active orders</h3>
<table class="table table-hover" style="width: 90%; margin-right: 5%; margin-left: 5%">
    <thead>
    <tr>
        <th scope="col" style="width: 5%">#Id</th>
        <th scope="col" style="width: 5%">Name</th>
        <th scope="col" style="width: 80%">Surname</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <th scope="row" style="width: 5%">${customer.id}</th>
            <th scope="row" style="width: 5%">${customer.name}</th>
            <th scope="row" style="width: 15%">${customer.surname}</th>
            <td style="width: 10%"><a href="/customer?id=${customer.id}" class="btn btn-primary">Select</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>



<c:import url="fragments/footer.jsp"/>
</body>
</html>
