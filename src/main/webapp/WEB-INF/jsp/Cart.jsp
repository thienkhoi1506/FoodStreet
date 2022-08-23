<%--
  Created by IntelliJ IDEA.
  User: chauloc
  Date: 8/20/22
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<c:url value="/resource/js/main.js" />"></script>
<h1 class="bg-info rounded text-white">Giỏ Hàng</h1>

<c:if test="${carts1 == null}">
    <h4 class="text-danger"> Không có sản phẩm nào trong giỏ</h4>
</c:if>
<c:if test="${carts1 != null }">
    <table class="table">
        <tr>
            <th>Mã Sản phẩm</th>
            <th>Tên Sản phẩm</th>
            <th>Đơn gía</th>
            <th>Số lượng</th>
            <th></th>
        </tr>
        <c:forEach items="${carts1}" var="d">
            <tr >
                <td>${d.productId}</td>
                <td>${d.productName}</td>
                <td>${d.price}VNĐ</td>
                <td>
                    <div class="form-group">
                       <input type="number" value="${d.count}"
                              onblur="updateCart(this,${d.productId})" class="form-control" />
                    </div>
                </td>
                <td>
                    <input type="button" value="Xóa"
                           onclick="deleteCart(${d.productId},'${d.productName}')" class="btn btn-danger"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div><p>Tổng tiền bạn cần thanh toán : <span id="amountCart">${cartStats.amount}</span>VNĐ</p></div>
    <input type="button" value="Thanh toán" class="btn btn-danger"/>
</c:if>
