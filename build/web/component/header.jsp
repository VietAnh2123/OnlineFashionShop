<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Header Section Begin -->
<header class="header">
    <c:if test="${sessionScope.customer==null}">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="">
                        <div class="header__top__right">
                            <div class="header__top__links">
                                <a href="login.jsp">Đăng Nhập</a>
                                <a href="register.jsp">Đăng Ký</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="header__logo">
                    <a href="index"><img src="images/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <nav class="header__menu mobile-menu">
                    <ul>
                        <li class=""><a href="index">Trang Chủ</a></li>
                        <li><a href="get-products">Cửa Hàng</a></li>
                            <c:if test="${sessionScope.customer!=null}">
                            <li><a href="#">Khách Hàng</a>
                                <ul class="dropdown">
                                    <li><a href="userdetail.jsp">Thông tin</a></li>
                                    <!--<li><a href="">Shop Details</a></li>-->
                                    <!--<li><a href="./shopping-cart.html">Shopping Cart</a></li>-->
                                    <!--<li><a href="./checkout.html">Check Out</a></li>-->
                                    <li><a href="customer?action=log-out">Đăng xuất</a></li>
                                </ul>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 col-md-3">
                <div class="header__nav__option">
                    <a href="#" class="search-switch"><img src="images/icon/search.png" alt=""></a>
                    <!--                    <a href="#"><img src="images/icon/heart.png" alt=""></a>-->
                    <c:if test="${sessionScope.size == 0 || sessionScope.size == null}"> 
                        <a href="shoppingcart.jsp"><img src="images/icon/cart.png" alt=""><span>0</span></a>
                        </c:if>
                    <c:if test="${sessionScope.size != 0 && sessionScope.size != null}"> 
                    <a href="shoppingcart.jsp"><img src="images/icon/cart.png" alt=""><span>${sessionScope.size}</span></a>
                        </c:if>
                    <!--<div class="price">$0.00</div>-->
                </div>
            </div>
        </div>
        <div class="canvas__open"><i class="fa fa-bars"></i></div>
    </div>
</header>
<!-- Header Section End -->
