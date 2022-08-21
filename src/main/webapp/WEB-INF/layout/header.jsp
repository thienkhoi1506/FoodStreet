<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html" language="java" pageEncoding="utf-8" %>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link href="https://cdnjs.com/libraries/font-awesome">
    <script src="<c:url value="/resource/js/main.js" />"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="/"><img
                src="https://res.cloudinary.com/dxhhatnr2/image/upload/v1658998028/streetfood_1_kcxzap.png" width="100"
                height="70"></a>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <c:forEach items="${categories}" var="c">
                    <c:url value="/" var="cUrl">
                        <c:param name="cateId" value="${c.id}" />
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${cUrl}">${c.name}</a>
                    </li>
                </c:forEach>
                <li class="nav-item">
                    <a href="<c:url value="/cart"  />" class="nav-link text-success">
                        <i class="fas fa-shopping-cart"></i>

                        <div id="cartCouter">${cartCouter}</div>
                    </a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Địa điểm, món ăn..." aria-label="Search">
                <button class="btn btn-outline-success" type="submit">&#128269;
                </button>
            </form>
        </div>

    </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
