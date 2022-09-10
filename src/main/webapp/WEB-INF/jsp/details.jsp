<%--
  Created by IntelliJ IDEA.
  User: sieun
  Date: 9/4/2022
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<div class="row">
    <div class="col-md-5">
        <img src="${products.image}" alt="${products.name}" class="img-fluid" />
    </div>
    <div class="col-md-7">
        <h1>${products.name}</h1>
        <h3>${products.price} VND</h3>
    </div>
</div>