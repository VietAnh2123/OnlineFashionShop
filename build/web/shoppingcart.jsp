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
        
        
            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-option">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="breadcrumb__text">
                                <h4>Giỏ Hàng</h4>
                                <div class="breadcrumb__links">
                                    <a href="./index.html">Trang Chủ</a>
                                    <a href="./shop.html">Cửa Hàng</a>
                                    <span>Giỏ Hàng</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Shopping Cart Section Begin -->
            <section class="shopping-cart spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="shopping__cart__table">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Sản phẩm</th>
                                            <th>Số lượng</th>
                                            <th>Giá</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="o" value="${sessionScope.cart}"/>
                                        <c:set var="q" value="0"/>
                                        <c:forEach items="${sessionScope.cart.items}" var="cart">
                                            <c:set var="t" value="${(q+1)}"/>                                
                                            <tr>
                                                <td class="product__cart__item">
                                                    <div class="product__cart__item__pic">
                                                        <img width="100px" height="100px" src="${cart.product.images[0]}" alt="">
                                                    </div>
                                                    <div class="product__cart__item__text">
                                                        <h6>${cart.product.name}</h6>
                                                        <h7>${cart.product.sizeName}</h7>
                                                    </div>
                                                </td>
                                                <td class="quantity__item">  <!--quantity__item-->
                                                    <div class="quantity"> <!--quantity-->
                                                        <div class=""> <!--pro-qty-2-->
                                                            ${cart.quantity}
                                                        </div>
                                                    </div>
                                                </td>

                                                <td class="cart__price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${cart.product.price}"/></td>
                                                <td class="cart__close"><a href="cart-process?productId=${cart.product.id}"><i class="fa fa-close"></i></a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
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
                                <h6>Thanh Toán</h6>
                                <ul>
                                    <!--                                    <li>Gi <span>$ 169.50</span></li>-->
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
                                        <form action="check-out" method="GET">
                                            <input type="submit" value="Thanh Toán" class="primary-btn btn-block">
                                        </form>
<!--                                <a href="#" class="primary-btn">Thanh Toán</a>-->
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Shopping Cart Section End -->

        <jsp:include page="component/jsplugins.jsp"></jsp:include>
        <jsp:include page="component/footer.jsp"></jsp:include>
    </body>
</html>
