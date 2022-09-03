<%--
  Created by IntelliJ IDEA.
  User: sieun
  Date: 8/24/2022
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="<c:url value="/resources/css/login.css"/> " rel="stylesheet"/>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<c:url value="/login" var="action"/>
    <div class="container">
        <section class="">
            <div class="container">
                <div class="row d-flex justify-content-center align-items-center">
                    <div class="login-form col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card shadow-2-strong" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">

                                <h3 class="mb-5">Sign in</h3>
                                <form method="post" action="${action}">
                                    <div class="form-outline mb-4">
                                        <input type="text" id="typeEmailX-2" class="form-control form-control-lg"
                                               name="username"/>
                                        <label class="form-label" for="typeEmailX-2">User Name</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" id="typePasswordX-2" class="form-control form-control-lg"
                                               name="password"/>
                                        <label class="form-label" for="typePasswordX-2">Password</label>
                                    </div>

                                    <!-- Checkbox -->
                                    <div class="form-check d-flex justify-content-start mb-4">
                                        <input class="form-check-input" type="checkbox" value="" id="form1Example3"/>
                                        <label class="form-check-label" for="form1Example3"> Remember password </label>
                                    </div>

                                    <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>

                                    <hr class="my-4">

                                    <button class="btn btn-lg btn-block btn-primary" style="background-color: #dd4b39;"
                                            type="button"><i class="fab fa-google me-2"></i> Sign in with google
                                    </button>
                                    <button class="btn btn-lg btn-block btn-primary mb-2" style="background-color: #3b5998;"
                                            type="button"><i class="fab fa-facebook-f me-2"></i>Sign in with facebook
                                    </button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

