<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="fragments/front.jsp"/>

    <title>Title</title>
</head>
<body>
<c:import url="fragments/header.jsp"/>

<div class="card" style="margin-left: 5%; margin-right: 5%">
    <div class="card-header">
        Employee #Id ${employee.id}
    </div>
    <div class="card-body">
        <h5 class="card-title">Employee details</h5>
        <p class="card-text">
        <table class="table" style="width: 90%; margin-right: 5%; margin-left: 5%">
            <tbody>
            <td style="width: 10%"><a href="/employeeedit?id=${employee.id}" class="btn btn-primary">Edit</a>
            <tr><td style="width: 30%">Name:</td><td style="width: 70%"> ${employee.name}</td></tr>
            <tr><td style="width: 30%">Surname:</td><td style="width: 70%">${employee.surname}</td></tr>
            <tr><td style="width: 30%">Address:</td><td style="width: 70%">${employee.address}</td></tr>
            <tr><td style="width: 30%">Phone:</td><td style="width: 70%">${employee.phone}</td></tr>
            <tr><td style="width: 30%">Email:</td><td style="width: 70%">${employee.email}</td></tr>
            <tr><td style="width: 30%">Birth date:</td><td style="width: 70%">${employee.birthDate}</tr>
            <tr><td style="width: 30%">Hourly:</td><td style="width: 70%">${employee.hourly}</td></tr>
            <tr><td style="width: 30%">Note:</td><td style="width: 70%">${employee.note}</td></tr>
            <tr><td style="width: 10%"><a href="/employeeorders?id=${employee.id}&actual=false" class="btn btn-primary">all orders</a></td></tr>
            <tr><td style="width: 10%"><a href="/employeeorders?id=${employee.id}&actual=true" class="btn btn-primary">actual orders</a></td></tr>
            </tbody>
        </table>


        </p>
        <button onclick="goBack()" class="btn btn-primary">Previous page</button>
    </div>
</div>

<c:import url="fragments/footer.jsp"/>
</body>
</html>
