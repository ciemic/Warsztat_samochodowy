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
        Employee #Id ${customer.id}
    </div>
    <div class="card-body">
        <h5 class="card-title">Customer details</h5>
        <p class="card-text">
        <table class="table" style="width: 90%; margin-right: 5%; margin-left: 5%">
            <tbody>
            <td style="width: 10%"><a href="/customeredit?id=${customer.id}" class="btn btn-primary">Edit</a>
            <tr><td style="width: 30%">Name:</td><td style="width: 70%"> ${customer.name}</td></tr>
            <tr><td style="width: 30%">Surname:</td><td style="width: 70%">${customer.surname}</td></tr>
            <tr><td style="width: 30%">Address:</td><td style="width: 70%">${customer.address}</td></tr>
            <tr><td style="width: 30%">Phone:</td><td style="width: 70%">${customer.phone}</td></tr>
            <tr><td style="width: 30%">Email:</td><td style="width: 70%">${customer.email}</td></tr>
            <tr><td style="width: 30%">Birth date:</td><td style="width: 70%">${customer.birthDate}</tr>
            </tbody>
        </table>

        <h3 style="margin-left: 5%">Vehicles</h3>
        <table class="table table-hover" style="width: 90%; margin-right: 5%; margin-left: 5%">
            <thead>
            <tr>
                <th scope="col" style="width: 5%">#Id</th>
                <th scope="col" style="width: 25%">Vehicle Brand</th>
                <th scope="col" style="width: 25%">Vehicle Model</th>
                <th scope="col" style="width: 25%">Vehicle Registration Number</th>
                <th scope="col" style="width: 20%"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="vehicle" items="${vehicles}">
                <tr>
                    <th scope="row" style="width: 5%">${vehicle.id}</th>
                    <td style="width: 25%">${vehicle.brand}</td>
                    <td style="width: 25%">${vehicle.model}</td>
                    <td style="width: 25%">${vehicle.registrationNumber}</td>
                    <td style="width: 20%"><a href="/vehicle?id=${vehicle.id}" class="btn btn-primary">Select</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        </p>
        <button onclick="goBack()" class="btn btn-primary">Previous page</button>
    </div>
</div>

<c:import url="fragments/footer.jsp"/>

</body>
</html>
