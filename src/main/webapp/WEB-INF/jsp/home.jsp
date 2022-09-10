<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
    <h1 class="bg-info rounded text-white">Home Page</h1>
    <div class="row">
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
        </c:forEach>

<%--        <c:forEach items="${restaurant}" var="r">--%>
<%--            <div class="col-4">--%>
<%--                <div class="card">--%>
<%--                    <img src="${r.avatar}" class="card-img-top img-fluid" width="50" height="100">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title">${p.name}</h5>--%>
<%--                     </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>

    </div>
    <ul class="pagination pagination-circle justify-content-center">
        <c:forEach begin="1" end="${Math.ceil(productCounter/pageSize)}" var="i">
            <c:url value="/" var="u">
                <c:param name="page" value="${i}"></c:param>
            </c:url>
            <li class="page-item">
                <a class="page-link" href="${u}">${i}</a>
            </li>
        </c:forEach>

<%--        <c:forEach begin="1" end="${Math.ceil(restaurant/pageSize)}" var="i">--%>
<%--            <c:url value="/" var="u">--%>
<%--                <c:param name="page" value="${i}"></c:param>--%>
<%--            </c:url>--%>
<%--            <li class="page-item">--%>
<%--                <a class="page-link" href="${u}">${i}</a>--%>
<%--            </li>--%>
<%--        </c:forEach>--%>
    </ul>
</div>
<script src="<c:url value="/resources/js/product.js" />"></script>
<script src="<c:url value="/resources/js/restaurant.js" />"></script>


