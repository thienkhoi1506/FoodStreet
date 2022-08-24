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
    <link
            href="<c:url value="/resources/css/header.css"/> "
            rel="stylesheet"
    />
    <script defer
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.4.0/mdb.min.js"
    ></script>
</head>
<body>
<!-- Navbar-->
<nav class="navbar navbar-expand-lg">
    <!-- Left elements -->
    <div class="col-2">
        <!-- Brand -->
        <a class="navbar-brand logo" href="#">
            <img
                    src="https://res.cloudinary.com/dxhhatnr2/image/upload/v1658998150/streetfood_gbpcjd.svg"
                    height="80"
                    width="150"
            />
        </a>

    </div>
    <!-- Left elements -->

    <!-- Center elements -->

    <!-- Search form -->
    <div class="col-8">
        <div class="input-group search-box">
            <div class="form-outline search-text">
                <input type="search" id="form1" class="form-control"/>
                <label class="form-label" for="form1"><i class="fas fa-search"></i> Search</label>
            </div>
        </div>
    </div>
    <!-- Center elements -->

    <!-- Right elements -->
    <div class="col-2">
        <a class="btn btn-link" href="<c:url value="/login" /> ">Login</a>
<%--        <button type="button" class="btn btn-link">--%>
<%--            Login--%>
<%--        </button>--%>
        <button type="button" class="btn btn-primary">
            Sign up
        </button>
    </div>
    <!-- Right elements -->
</nav>
<!-- Navbar -->

</body>


