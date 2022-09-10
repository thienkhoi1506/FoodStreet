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
    <c:url value="/admin/products/create" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">${errMsg}</div>
    </c:if>
    <form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" path="name" class="form-control" id="name" placeholder="name" name="name" />
            <label for="name">Ten san pham</label>
            <form:errors path="name" element="div" cssClass="invalid-feedback"></form:errors>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="number" path="price" class="form-control" id="price" placeholder="price" name="price" />
            <label for="name">Gia san pham</label>
            <form:errors path="price" element="div" cssClass="invalid-feedback"></form:errors>
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
            <form:button type="submit"
                         class="btn btn-primary btn-lg btn-block">Submit</form:button>
        </div>
    </form:form>
</div>


