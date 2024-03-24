<%-- 
    Document   : success
    Created on : Dec 31, 2023, 6:51:35 PM
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
        <!--        <div class="container text-center mt-5">
                    <h1 class="">Bạn chưa <a class="text-warning" href="dangnhap.jsp">Đăng nhập</a> vào hệ thống! Vui lòng quay lại <a href="index.jsp">Trang chủ</a>.</h1>
                </div>-->
        <div class="container text-center mt-5">
            <h3>Chúc mừng bạn đăng ký tài khoản thành công !</h3>
            <a href="index" class="forgot">Trang chủ</a> | <a href="login.jsp" class="forgot">Đăng nhập ngay</a>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <jsp:include page="component/footer.jsp"></jsp:include>
        <jsp:include page="component/jsplugins.jsp"></jsp:include>
    </body>
    <script>
        setTimeout(function () {
            window.location = 'index';
        }, 5000);
    </script>
</html>
