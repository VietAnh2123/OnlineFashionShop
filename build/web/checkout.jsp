<%-- 
    Document   : shoppingcart
    Created on : Mar 6, 2024, 12:37:47 AM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <jsp:include page="component/head.jsp"></jsp:include>
        <body>
        <jsp:include page="component/header.jsp"></jsp:include>
        <jsp:include page="component/preloader.jsp"></jsp:include>
        <c:if test="${sessionScope.customer==null}">
            <jsp:forward page="login.jsp"></jsp:forward>
        </c:if>
        <c:if test="${sessionScope.customer!=null}">
            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-option">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="breadcrumb__text">
                                <h4>Thanh Toán</h4>
                                <div class="breadcrumb__links">
                                    <a href="./index.html">Trang Chủ</a>
                                    <a href="./shop.html">Cửa Hàng</a>
                                    <span>Thanh Thoán</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->
            <h2 class="text-center text-success mt-3">${requestScope.msg}</h2>
            <c:set value="${sessionScope.customer}" var="c"/>
            <!-- Shopping Cart Section Begin -->
            <section class="shopping-cart spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="shopping__cart__table">
                                <form action="check-out" method="POST">
                                    <div class="row">
                                        <div class="col-lg-8 col-md-6">
                                            <h4>Thông tin Khách Hàng</h4>
                                            <div class="checkout__input">
                                                <p>Họ Và Tên<span>*</span></p>
                                                <input type="text" name="fullName" required="" value="${c.fullname}">
                                            </div>
                                            <div class="checkout__input">
                                                <p>Địa Chỉ<span>*</span></p>
                                                <input type="text" name="address" required="" value="${c.address}">
                                            </div>
                                            <div class="row">
                                                <div class="col-lg-6">
                                                    <div class="checkout__input">
                                                        <p>Số điện thoại<span>*</span></p>
                                                        <input type="text" name="phoneNumber" required="" value="${c.phoneNumber}">
                                                    </div>
                                                </div>
                                                <div class="col-lg-6">
                                                    <div class="checkout__input">
                                                        <p>Email<span>*</span></p>
                                                        <input type="email" name="email" required="" value="${c.email}">
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="checkout__input">
                                                <p>Ghi chú<span></span></p>
                                                <input type="text" name="note">
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="continue__btn">
                                        <a href="get-products">Tiếp tục mua sắm</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="cart__total">
                                <h6>Đơn Hàng của bạn</h6>
                                <ul>
                                    <li>Số Tiền 
                                        <span>
                                            <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope.cart.getTotalMoney()}"/>
                                        </span>
                                    </li>
                                    <li>Phí vận chuyển (COD)
                                        <span>
                                            ${sessionScope.cart == null || sessionScope.size == 0 ? '0':'30,000'}
                                        </span>
                                    </li>
                                    <hr>
                                    <li>Tổng Tiền 
                                        <span>
                                            <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope.cart == null || sessionScope.size == 0?'0':sessionScope.cart.getTotalMoney()+30000}"/> VND
                                        </span>
                                    </li>
                                </ul>
                                <input type="submit" value="Thanh Toán" class="primary-btn btn-block">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Shopping Cart Section End -->

        </c:if>
        <jsp:include page="component/jsplugins.jsp"></jsp:include>
        <jsp:include page="component/footer.jsp"></jsp:include>
    </body>
</html>
