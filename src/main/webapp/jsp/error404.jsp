<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
</head>
<body>
<div class="container">
    <div>
        <h1> Error 500</h1>
        <h1 style="text-align: center"><c:out value="${error}"/></h1>
        <a href="/aimprosoft/">Return home page!</a>
    </div>
</div>
</body>
</html>