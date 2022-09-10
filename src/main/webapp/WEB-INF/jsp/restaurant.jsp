<%--
  Created by IntelliJ IDEA.
  User: chauloc
  Date: 8/23/22
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="<c:url value="/resource/js/main.js" />"></script>
<h1>Chào Bạn đến với cửa hàng Chúng tôi</h1>
<link
        href="<c:url value="/resource/Css/Restaurant.css"/> "
        rel="stylesheet"
/>
<div class="row" >
    <c:forEach items="${products}" var="p">
        <div class="col-md-4 col-xs-12" id="asd">
            <h4>Thông tin Món ăn/ đồ uống</h4>
            <h4>${p.product_Detail}</h4>

        </div>
        <div class="col-md-4 col-xs-12" id="asd">
                    <img class="card-img-top" src="${p.image}" alt="Card image">
                    <div class="card-body">
                        <h4 class="card-title">${p.name}</h4>
                        <p class="card-text">
                                ${p.price} VND
                        </p>
                        <a href="#" class="btn btn-primary" onclick="addToCart(${p.id},'${p.name}',${p.price})">Đặt hàng</a>
                    </div>
        </div>
        <div class="col-md-4 col-xs-12"  id="asd">
            <h4>Đánh giá</h4>
        </div>

    </c:forEach>
</div>

