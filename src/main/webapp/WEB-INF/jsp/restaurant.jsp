<%--
  Created by IntelliJ IDEA.
  User: sieun
  Date: 9/10/2022
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="<c:url value="/resources/js/restaurant.js" />"></script>
<h1>Chào Bạn đến với cửa hàng Chúng tôi</h1>
<link
        href="<c:url value="/resources/css/Restaurant.css"/> "
        rel="stylesheet"
/>

<div class="row" >
<c:forEach items="${products}" var="p">
    <c:url var="updateLink" value="admin/products/edit/">
        <c:param name="productId" value="${p.id}"></c:param>
    </c:url>
    <div class="col-4">
        <div class="card">
            <img src="${p.image}" class="card-img-top img-fluid" width="50" height="100">
            <div class="card-body">
                <h5 class="card-title">${p.name}</h5>
                <p class="card-text">
                    <fmt:formatNumber value="${p.price}" maxFractionDigits="3" type="number"/> VND
                </p>
                <a href="<c:url value="/products/${p.id}"/> " class="btn btn-primary">Xem chi tiết</a>
                <a href="${updateLink}" class="btn btn-primary">Update</a>
                <a href="javascript:;" class="btn btn-danger" onclick="deleteProduct(${p.id})">Xóa</a>
                <a href="#" class="btn btn-primary" onclick="addToCart(${p.id},'${p.name}',${p.price})">Đặt hàng</a>
            </div>
        </div>
    </div>
    </div>
    <div class="col-md-4 col-xs-12" id="asd">
        <h4>Đánh giá</h4>
    </div>

</c:forEach>
</div>
