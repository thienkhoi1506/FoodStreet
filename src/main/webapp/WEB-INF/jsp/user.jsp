<%--
  Created by IntelliJ IDEA.
  User: sieun
  Date: 9/6/2022
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <table class="table align-middle mb-0 bg-white">
        <thead class="bg-light">
        <tr>
            <th>Name</th>
            <th>Username</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>
                    <div class="d-flex align-items-center">
                        <img
                                src="${u.avatarUrl}"
                                alt=""
                                style="width: 45px; height: 45px"
                                class="rounded-circle"
                        />
                        <div class="ms-3">
                            <p class="fw-bold mb-1">${u.lastName}</p>
                            <p class="text-muted mb-0">${u.emailAddress}</p>
                        </div>
                    </div>
                </td>
                <td>
                    <p class="fw-normal mb-1">${u.username}</p>
                </td>
                <td>
                    <span class="badge badge-success rounded-pill d-inline">${u.role}</span>
                </td>
                <td>
                    <a href="#" type="button" class="btn btn-link btn-sm btn-rounded">
                        Edit
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
