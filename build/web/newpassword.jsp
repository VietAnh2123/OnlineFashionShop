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
                                <h4>Khách Hàng</h4>
                                <div class="breadcrumb__links">
                                    <span>Đổi mật khẩu</span>
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
                        <form action="confirmpass" method="POST" id="f1">
                            <input type="hidden" name="userName" value="${requestScope.userName}">
                        <div class="row">
                            <div class="col-lg-8 col-md-6">
                                <h4>Đổi mật khẩu</h4>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Mật Khẩu Mới<span>*</span></p>
                                            <input type="password" id="pass1" name="password" id="password" required="" placeholder="${requestScope.check == null?'Mật khẩu':'Mật khẩu mới'}">
                                        </div>
                                        <div class="checkout__input">
                                            <p>Nhập lại Mật Khẩu<span>*</span></p>
                                            <input type="password" id="pass2" name="confirmNewPassword" id="confirmPassword" onkeyup="kiemTraMatKhau()" required="" placeholder="${requestScope.check == null?'Xác nhận mật khẩu':'Xác nhận mật khẩu mới'}">
                                            <p><span id="msg">${requestScope.error}</span></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 mt-3">
                                <div class="">
                                    <button type="button" class="site-btn" onclick="checkPass()">Cập Nhật</button>
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

        function checkPass() {
            var a = document.getElementById("pass1").value;
            var b = document.getElementById("pass2").value;
            if (a == b) {
                document.getElementById("f1").submit();
            } else {
                document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
            }
        }
    </script>
</html>

