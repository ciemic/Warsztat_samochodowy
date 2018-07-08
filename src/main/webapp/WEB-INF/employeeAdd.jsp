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
        Add new employee
    </div>
    <div class="card-body">
        <h5 class="card-title">Employee details</h5>
        <p class="card-text">
        <table class="table" style="width: 90%; margin-right: 5%; margin-left: 5%">
            <tbody>
            <form method="post" action="/employeeAdd">
                <input type="hidden" name="id" value="0" />
            <tr><td style="width: 30%">Name:</td><td style="width: 70%"> <input type="text" placeholder="name" name="name"/></td></tr>
            <tr><td style="width: 30%">Surname:</td><td style="width: 70%"><input type="text" placeholder="surname" name="surname"/></td></tr>
            <tr><td style="width: 30%">Address:</td><td style="width: 70%"><input type="text" placeholder="address" name="address"/></td></tr>
            <tr><td style="width: 30%">Phone:</td><td style="width: 70%"><input type="text" placeholder="phone" name="phone"/></td></tr>
            <tr><td style="width: 30%">Email:</td><td style="width: 70%"><input type="text" placeholder="email" name="email"/></td></tr>
            <tr><td style="width: 30%">Birth date:</td><td style="width: 70%"><input type="date" name="birthDate"/></tr>
            <tr><td style="width: 30%">Hourly:</td><td style="width: 70%"><input type="text" placeholder="hourly" name="hourly"/></td></tr>
            <tr><td style="width: 30%">Note:</td><td style="width: 70%"><input type="text" placeholder="note" name="note"/></td></tr>
            <tr><td style="width: 30%"> <input type="submit" value="add"></td></tr>
            </form>

            </tbody>
        </table>

        </p>
        <button onclick="goBack()" class="btn btn-primary">Previous page</button>
    </div>
</div>

<c:import url="fragments/footer.jsp"/>
</body>
</html>