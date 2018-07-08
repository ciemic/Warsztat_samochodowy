<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="fragments/front.jsp"/>

    <title>Car service - employee list</title>
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
    <c:forEach var="employee" items="${employees}">
        <tr>
            <th scope="row" style="width: 5%">${employee.id}</th>
            <th scope="row" style="width: 5%">${employee.name}</th>
            <th scope="row" style="width: 15%">${employee.surname}</th>
            <td style="width: 10%"><a href="/employee?id=${employee.id}" class="btn btn-primary">Select</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>


<c:import url="fragments/footer.jsp"/>
</body>
</html>
