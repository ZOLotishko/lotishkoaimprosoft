<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
</head>
<body>
<h1 class="card-panel teal lighten-2" align="center">List Employee</h1>
<div class="card-panel">
    <h3  align="center">Department: <c:out value="${department_id}"/></h3>
</div>
<div class="container">
    <table class="striped">

        <thead>
        <div class="row">
            <th>ID:</th>
            <th>Name:</th>
            <th>Email:</th>
            <th>Born day:</th>
            <th>Salary</th>
            <th>id Dept:</th>
            <th>Delete:</th>
            <th>Edit:</th>

        </div>
        </thead>
        <tbody>
        <c:forEach var="emp" items="${emp}">
            <tr>
                <td><c:out value="${emp.id}" /></td>
                <td><c:out value="${emp.name}"></c:out>
                <td><c:out value="${emp.email}" /></td>
                <td><c:out value="${emp.date}" /></td>
                <td><c:out value="${emp.salary}"></c:out>
                <td><c:out value="${department_id}" /></td>

                <td><a  href="/aimprosoft/deleteEmployee?id=${emp.id}&department_id=${department_id}">Delete</a></td>
                <td><a  href="/aimprosoft/addEmployee?id=${emp.id}&department_id=${department_id}">Update</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input class="waves-effect waves-light btn" type=button onClick="location.href='/aimprosoft/addEmployee?department_id=<c:out value="${department_id}"/>'" value='Add Employee'>
    <input class="waves-effect waves-light btn right" type=button onClick="location.href='/aimprosoft/'" value='<--'>

</div>
</body>
</html>