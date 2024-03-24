<%-- 
    Document   : adminlogin
    Created on : Mar 14, 2024, 3:16:44 AM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="component/head.jsp"></jsp:include>
        <body>
        <jsp:include page="component/adminheader.jsp"></jsp:include>
            <a style="padding-left: 100px;" class="mt-3 forgot" href="login.jsp">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0z"/>
                <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708z"/>
                </svg>Khách hàng</a>
            <section class="checkout spad">
                <div class="container">

                    <div class="checkout__form">
                        <c:set var="cookie" value="${pageContext.request.cookies}"/>

                    <form action="admin" method="POST">

                        <div class="row">

                            <div class="col-lg-8 col-md-6">
                                <h4>Quản trị viên</h4>
                                <h5 style="color: green">${requestScope.success}</h5>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Tên Đăng Nhập<span>*</span></p>
                                            <input type="text" name="username" value="${cookie.adminUser.value}">
                                        </div>
                                        <div class="checkout__input">
                                            <p>Mật Khẩu<span>*</span></p>
                                            <input type="password" name="password" id="password" value="${cookie.adminPass.value}">
                                            <p><span id="msg">${requestScope.msg}</span></p>

                                        </div>
                                        <div class="checkout__input__checkbox">
                                            <label for="remember">
                                                Ghi nhớ
                                                <input type="checkbox" id="remember" name="remember" value="ON" ${(cookie.adminIsRemember!=null?'checked':'')}>
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                        <div class="mt-5">
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
    </body>
    <br>
    <br>
    <br>
    <br>
    <br>
    <jsp:include page="component/adminfooter.jsp"></jsp:include>
</html>
