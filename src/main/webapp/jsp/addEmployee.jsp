<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Employee</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
</head>
<body>
<center>
    <div>

    </div>
    <span>

    </span>
    <form method="POST" name='formEmployee' action="/aimprosoft/addEmployees">
        <h2 class="card-panel teal lighten-2" align="center">Add New Employee</h2>
        <div class="container">
            <div class="row">
                <div class="col s4 offset-s4">

                    <table class="striped">


                        <div>
                            <label ><h4>Employee ID: <c:out value="${emp.id}"/></h4></label>
                            <input type="hidden" name="id" value="<c:out value="${emp.id}"/>"/>
                        </div>
                        <div>
                            Name : <input type="text" name="name"  value="<c:out value="${param['name'] eq null ? emp.name : param['name']}"/>"/></br>
                            <span class="error" style="color: crimson">${error.get("name")}</span></br>
                        </div>
                        <div>
                            Email : <input type="text" name="email"  value="<c:out value="${param['email'] eq null ? emp.email : param['email']}"/>"/></br>
                            <span class="error" style="color: crimson">${error.get("email")}</span></br>
                        </div>
                        <div><fmt:formatDate value="${emp.date}" pattern="yyyy-MM-dd" var="formatedDate"/>
                            Date : (yyyy-MM-dd)<input type="date" name="date"  value="<c:out value="${param['date'] eq null ? emp.date : param['date']}"/>"/></br>
                            <span class="error" style="color: crimson">${error.get("date")}</span></br>
                        </div>

                        <div>
                            Salary : <input type="text" name="salary"  value="<c:out value="${param['salary'] eq null ? emp.salary : param['salary']}"/>"/></br>
                            <span class="error" style="color: crimson">${error.get("salary")}</span></br>
                        </div>

                    </table>

                        <span><input type="hidden" name="department_id"
                                     value="<c:out value="${param['department_id'] eq null ? id_dep : param['department_id']}"/>"/></span>

                    <span><input  class="waves-effect waves-light btn"  type="submit" value="Add Employee"></span>

                </div>
            </div>
        </div>
    </form>
</center>
</body>
</html>