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
                                <h4>Đăng Ký Tài Khoản</h4>
                                <div class="breadcrumb__links">
                                    <span>Đăng Ký</span>
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
                        <form action="customer" method="POST">
                            <div class="row">
                                <div class="col-lg-8 col-md-6">
                                    <h4>Tài Khoản</h4>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Tên Đăng Nhập<span>*</span></p>
                                                <input type="text" name="username" required="">
                                            </div>
                                            <div class="checkout__input">
                                                <p>Mật Khẩu<span>*</span></p>
                                                <input type="password" name="password" id="password" required="">
                                            </div>
                                            <div class="checkout__input">
                                                <p>Nhập lại Mật Khẩu<span>*</span></p>
                                                <input type="password" name="confirmPassword" id="confirmPassword" onkeyup="kiemTraMatKhau()" required="">
                                                <p><span id="msg"></span></p>
                                            </div>
                                        </div>

                                    </div>
                                    <h4>Thông tin Khách Hàng</h4>
                                    <div class="checkout__input">
                                        <p>Họ Và Tên<span>*</span></p>
                                        <input type="text" name="fullName" required="" value="${param.fullName}">
                                    </div>
                                    <div class="checkout__input">
                                        <p>Địa Chỉ<span>*</span></p>
                                        <input type="text" name="address" required="" value="${param.address}">
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Số điện thoại<span>*</span></p>
                                                <input type="text" name="phoneNumber" required="" value="${param.phoneNumber}">
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Email<span>*</span></p>
                                                <input type="email" name="email" required="" value="${param.email}">
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Gender<span>*</span></p>
                                                <select name="gender" required="">
                                                    <option>---</option>
                                                    <option value="Nữ">Nữ</option>
                                                    <option value="Nam">Nam</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 mt-3">
                                    <div class="">
                                        <input type="hidden" name="action" value="register">
                                        <button type="submit" class="site-btn">Tạo Tài Khoản</button>
                                        <br>
                                        <p class="text-danger"><span>${requestScope.error}</span></p>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
            <!-- Checkout Section End -->


        <jsp:include page="component/footer.jsp"></jsp:include>
        <jsp:include page="component/jsplugins.jsp"></jsp:include>
    </body>
    <script>
        function kiemTraMatKhau() {
            password = document.getElementById("password").value;
            confirmPassword = document.getElementById("confirmPassword").value;

            if (password != confirmPassword) {
                document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
                return false;
            } else {
                document.getElementById("msg").innerHTML = "";
                return true;
            }
        }
    </script>
</html>
