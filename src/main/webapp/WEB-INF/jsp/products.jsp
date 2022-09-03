<%--
  Created by IntelliJ IDEA.
  User: sieun
  Date: 8/12/2022
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-primary">QUAN LY SAN PHAM</h1>

<div class="container">
    <c:url value="/products" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">${errMsg}</div>
    </c:if>
    <form:form method="post" action="${action}" modelAttribute="products" enctype="multipart/form-data">
        <%--    <form:errors path="*" element="div" cssClass="alert alert-danger" />--%>
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" path="name" class="form-control" id="name" placeholder="name" name="name" />
            <label for="name">Ten san pham</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="number" path="price" class="form-control" id="price" placeholder="price" name="price" />
            <label for="name">Gia san pham</label>
        </div>
        <div class="form-floating">
            <form:select path="categoryByCategoryId" class="form-select" id="cate" name="cate">
                <c:forEach items="${categories}" var="c">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </form:select>
            <label for="cate" class="form-label">Danh muc san pham</label>
        </div>
        <div>
            <br>
            <form:input path="img" id="imgId" type="file" cssClass="form-control"></form:input>
        </div>
        <div>
            <br>
            <input type="submit" value="Them san pham" class="btn btn-primary" />
        </div>
    </form:form>

    <table class="table">
        <tr>
            <th></th>
            <th>Name</th>
            <th>Price</th>
            <th></th>
        </tr>
        <tbody id="myProd">

        </tbody>
    </table>
</div>

<%--<script defer src="<c:url value="/js/product.js"/>"></script>--%>


<%--<script src="<c:url value="/js/product.js" />"></script>--%>
<%--<script>--%>
<%--    <c:url value="/api/products" var="endpoint" />--%>
<%--    window.onload = function () {--%>
<%--        loadProducts('${endpoint}');--%>
<%--    }--%>
<%--</script>--%>
