<%-- 
    Document   : register.jsp
    Created on : Mar 2, 2024, 3:11:38 PM
    Author     : AD
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="component/head.jsp"></jsp:include>
        <body>
        <jsp:include page="component/preloader.jsp"></jsp:include>
        <jsp:include page="component/header.jsp"></jsp:include>

            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-option">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="breadcrumb__text">
                                <h4>Đăng Nhập</h4>
                                <div class="breadcrumb__links">
                                    <span>Đăng Nhập</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <section class="checkout spad">
                <div class="container">
                    <div class="checkout__form">
                    <c:set var="cookie" value="${pageContext.request.cookies}"/>
                    <form action="customer" method="POST">
                        <div class="row">
                            <div class="col-lg-8 col-md-6">
                                <h4>Tài Khoản</h4>
                                <h5 style="color: green">${requestScope.success}</h5>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Tên Đăng Nhập<span>*</span></p>
                                            <input type="text" name="username" value="${cookie.cUser.value}">
                                        </div>
                                        <div class="checkout__input">
                                            <p>Mật Khẩu<span>*</span></p>
                                            <input type="password" name="password" id="password" value="${cookie.cPass.value}">
                                            <p><span id="msg">${requestScope.error}</span></p>
                                        </div>
                                        <div class="checkout__input__checkbox">
                                            <label for="remember">
                                                Ghi nhớ
                                                <input type="checkbox" id="remember" name="remember" value="ON" ${(cookie.cIsRemember!=null?'checked':'')}>
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                        <div class="">
                                            <p class=""><a href="forgot" class="forgot">Quên mật khẩu hả?</a></p>
                                        </div>
                                        <div class="mt-3">
                                            <input type="hidden" name="action" value="log-in">
                                            <button type="submit" class="site-btn">Đăng Nhập</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- Checkout Section End -->
        <section class="text-center">
            <div>
                <p>
                    <a href="adminlogin.jsp"  class="forgot">
                        Đăng nhập với Quản Trị Viên
                    </a>
                </p>
            </div>
        </section>


        <jsp:include page="component/footer.jsp"></jsp:include>
        <jsp:include page="component/jsplugins.jsp"></jsp:include>
    </body>
</html>

