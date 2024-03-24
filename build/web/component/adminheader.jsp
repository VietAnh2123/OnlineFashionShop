<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header class="header" style="background-color: lavender;">
    <!--                <div class="header__top">
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
                    </div>-->
    <div class="container">
        <div class="row" >
            <div class="col-lg-3 col-md-3">
                <div class="header__logo">
                    <a href="admindashboard.jsp"><img src="images/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <nav class="header__menu mobile-menu">
                    <ul>
                        <c:if test="${sessionScope.admin!= null}">
                            <li><a href="dashboard">Thống kê</a>
                            </li>
                            <li><a href="#">Cửa Hàng</a>
                                <ul class="dropdown">
                                    <li><a href="manage-products">Danh Sách Sản Phẩm</a></li>
                                    <li><a href="manage-orders">Danh Sách Đơn Hàng</a></li>
                                </ul></li>

                            <li><a href="#">Khách Hàng</a>
                                <ul class="dropdown">
                                    <li><a href="manage-customer">Danh Sách Khách Hàng</a></li>
                                </ul>
                                <!--                                <ul class="dropdown">
                                                                    <li><a href="userdetail.jsp">Thông tin</a></li>
                                                                    <li><a href="">Shop Details</a></li>
                                                                    <li><a href="./shopping-cart.html">Shopping Cart</a></li>
                                                                    <li><a href="./checkout.html">Check Out</a></li>
                                                                    <li><a href="customer?action=log-out">Đăng xuất</a></li>
                                                                </ul>-->
                            </li>

                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3 col-md-3">
                    <div class="header__logo">
                        <a href="admin?action=log-out" class="forgot"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-circle" viewBox="0 0 16 16">
                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                            <path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8"/>
                            </svg></a>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</header>
