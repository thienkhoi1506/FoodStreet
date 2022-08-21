<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="<c:url value="/resource/js/main.js" />"></script>
<h1 class="bg-info rounded text-white">Home Page</h1>
<c:if test="${products.size() == 0}">
    <p>
        <strong>Khong co san pham nao!!!</strong>
    </p>
</c:if>

<div class="row">
    <c:forEach items="${products}" var="p">
        <div class="col-md-3 col-xs-12" style="padding:10px;">
            <div class="card">
                <img class="card-img-top" src="${p.image}" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title">${p.name}</h4>
                    <p class="card-text">
                            ${p.price} VND
                    </p>
                    <a href="#" class="btn btn-primary" onclick="addToCart(${p.id},'${p.name}',${p.price})">Đặt hàng</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
