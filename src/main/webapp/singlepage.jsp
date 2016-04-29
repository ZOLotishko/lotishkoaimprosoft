<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
    <link href="<c:url value="css/materialaze.css"/>" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.17/angular.min.js"></script>
    <script src="<c:url value=" js/materialize.js"/>"></script>
</head>
<body>

<%--<h1>Hello Fuck World</h1>--%>
<h1 class="card-panel teal lighten-2" align="center">List Department</h1>
<dir id="test"></dir>

<script src="<c:url value="js/myJavaScript.js"/>"></script>
<script type="application/text" id="addDep">

</script>
</body>
</html>
