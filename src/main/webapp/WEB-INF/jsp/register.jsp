<%--
  Created by IntelliJ IDEA.
  User: sieun
  Date: 8/28/2022
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="<c:url value="/resources/css/login.css"/> " rel="stylesheet"/>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<c:url value="/register/create" var="action"/>
<div class="container">
    <section class="">
        <div class="container">
            <div class="row d-flex justify-content-center align-items-center">
                <div class="login-form col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card shadow-2-strong" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">
                            <h3 class="mb-5">Create an account</h3>

                            <form:form method="post" action="${action}" modelAttribute="user"
                                       >

                                <div class="form-outline mb-4">
                                    <form:input type="text" id="form3Example1cg" class="form-control form-control-lg"
                                                path="lastName"/>
                                    <label class="form-label" for="form3Example1cg">Your Name</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <form:input type="text" id="form3Example3cg" class="form-control form-control-lg"
                                                path="username"/>
                                    <label class="form-label" for="form3Example3cg">User Name</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <form:input type="password" id="form3Example4cg"
                                                class="form-control form-control-lg" path="password"/>
                                    <label class="form-label" for="form3Example4cg">Password</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <form:input type="password" id="form3Example4cdg"
                                                class="form-control form-control-lg" path="confirmPassword"/>
                                    <label class="form-label" for="form3Example4cdg">Repeat your password</label>
                                </div>

                                <div class="form-check d-flex justify-content-center mb-5">
                                    <input class="form-check-input me-2" type="checkbox" value=""
                                           id="form2Example3cg"/>
                                    <label class="form-check-label" for="form2Example3cg">
                                        I agree all statements in <a href="#!" class="text-body"><u>Terms of
                                        service</u></a>
                                    </label>
                                </div>

                                <div class="d-flex justify-content-center">
                                    <form:button type="submit"
                                                 class="btn btn-primary btn-lg btn-block">Register</form:button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a
                                        href="<c:url value="/login"/>"
                                        class="fw-bold text-body"><u>Login
                                    here</u></a></p>

                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
