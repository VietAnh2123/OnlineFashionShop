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
                                    <span>Quên mật khẩu</span>
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

                        <div class="row">
                            <div class="col-lg-8 col-md-6">
                                <h4>Quên mật khẩu</h4>
                            <c:if test="${requestScope.check == null}">
                                <p>Khôi phục mật khẩu</p>
                            </c:if>
                            <c:if test="${requestScope.check != null}">
                                <c:if test="${requestScope.check == 'true' && !(requestScope.message == 'Mã xác nhận không đúng')}">
                                    <p style="color: green">${requestScope.message}</p>
                                </c:if>
                                <c:if test="${requestScope.check == 'false'}">
                                    <p style="color: red">${requestScope.message}</p>
                                </c:if>
                                <c:if test="${requestScope.check == 'true' && requestScope.message == 'Mã xác nhận không đúng'}">
                                    <p style="color: red">${requestScope.message}</p>
                                </c:if>
                            </c:if>
                            <div class="row">
                                <div class="col-lg-6">
                                    <form action="forgot" method="POST">
                                        <c:if test="${requestScope.check == null || requestScope.check == 'false'}">
                                            <div class="checkout__input">
                                                <p>Địa chỉ Email<span>*</span></p>
                                                <input type="email" name="email" value="">
                                            </div>
                                        </c:if>
                                        <c:if test="${requestScope.check == null || requestScope.check == 'false'}">
                                            <div class="mt-5">
                                                <input type="hidden" name="action" value="log-in">
                                                <button type="submit" class="site-btn">Lấy mã xác nhận</button>
                                            </div>
                                        </c:if>
                                    </form>
                                </div>
                            </div>
                            <c:if test="${requestScope.check != null && requestScope.check == 'true'}">
                                <form action="confirmresetcode" method="POST">
                                    <input name="email" value="${requestScope.email}" type="hidden">
                                    <div class="checkout__input">
                                        <p><span></span></p>
                                        <input type="text" name="resetcode" value="${requestScope.code}" required="" placeholder="Mã xác nhận" maxlength="6">
                                    </div>
                                        <c:if test="${requestScope.check != null && requestScope.check == 'true'}">
                                            <div class="">
                                                <button type="submit" class="site-btn">Xác Nhận</button>
                                            </div>
                                        </c:if>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Checkout Section End -->


        <jsp:include page="component/footer.jsp"></jsp:include>
        <jsp:include page="component/jsplugins.jsp"></jsp:include>
    </body>
</html>

