<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Department</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>--%>
</head>
<body>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
<h1 class="card-panel teal lighten-2" align="center">List Department</h1>

<div class="container">
    <table class="striped">
        <thead>
        <tr>
            <%--<div class="row">--%>
            <th>ID:</th>
            <th>Name:</th>
            <th>Edit:</th>
            <th>Delete:</th>
            <th>List Employee</th>
            <%--</div>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dep" items="${dep}">
            <tr>
                <td><c:out value="${dep.id}"/></td>
                <td><c:out value="${dep.name}"/></td>

                <td><a href="/aimprosoft/addDepartment?department_id=${dep.id}">Update</a></td>
                <td><a href="/aimprosoft/deleteDepartment?department_id=${dep.id}">Delete</a></td>
                <td><a href="/aimprosoft/listEmployees?department_id=${dep.id}">Show all employees</a></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form method="POST" action='addDepartment'>
        <input class="waves-effect waves-light btn" type="submit" value="Add Department">

    </form>
</div>
</body>
</html>