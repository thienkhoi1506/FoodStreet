<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html" language="java" pageEncoding="utf-8" %>

<head>
    <!-- Font Awesome -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <!-- MDB -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.4.0/mdb.min.css"
            rel="stylesheet"
    />
</head>
<body>
<div class="container">
    <nav class="navbar">
        <a class="navbar-brand" href="/"><img class="logo"
                src="https://res.cloudinary.com/dxhhatnr2/image/upload/v1658998150/streetfood_gbpcjd.svg" width="150"
                height="80"></a>
        <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Địa điểm, món ăn..." aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search<i class="fa-solid fa-magnifying-glass"></i></button>
        </form>
    </nav>
</div>
<!-- MDB -->
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.4.0/mdb.min.js"
></script>
</body>


