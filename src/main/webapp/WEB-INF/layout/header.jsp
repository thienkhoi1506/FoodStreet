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
        <a class="navbar-brand logo" href="<c:url value="/"/> ">
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
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <div class="col-2">
            <a class="btn btn-link" href="<c:url value="/login" /> "> Login </a>
            <a class="btn btn-primary" href="<c:url value="/register" />"> Register </a>
        </div>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div class="col-2">
            <!-- Avatar -->
            <div class="dropdown">
                <a
                        class="dropdown-toggle d-flex align-items-center hidden-arrow"
                        href="#"
                        id="navbarDropdownMenuAvatar"
                        role="button"
                        data-mdb-toggle="dropdown"
                        aria-expanded="false"
                >
                    <c:if test="${currentUser.avatarUrl != null}">
                        <img
                                src="${currentUser.avatarUrl}"
                                class="rounded-circle"
                                height="25"
                                loading="lazy"
                        />
                    </c:if>
                    <c:if test="${currentUser.avatarUrl == null}">
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </c:if>

        </a>
                <ul
                        class="dropdown-menu dropdown-menu-end"
                        aria-labelledby="navbarDropdownMenuAvatar"
                >
                    <li>
                        <a class="dropdown-item" href="#">My profile</a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Settings</a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
        </div>
    </c:if>
    <!-- Right elements -->
</nav>
<!-- Navbar -->

</body>


