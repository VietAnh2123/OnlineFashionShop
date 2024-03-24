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
                                    <span>Cập nhật thông tin</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->
    <c:set value="${sessionScope.customer}" var="c"/>
            <section class="checkout spad">
                <div class="container">
                    <div class="checkout__form">
                        <form action="customer" method="POST">
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
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Giới Tính<span>*</span></p>
                                                <select name="gender" required="">
                                                    <option value="Nam" ${c.gender.equals("Nam")?'selected':''}>Nam</option>
                                                    <option value="Nữ" ${c.gender.equals("Nữ")?'selected':''}>Nữ</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                                    <p class="mt-3 text-success">${requestScope.msg}</p>
                                </div>
                                <div class="col-lg-6 col-md-6 mt-3">
                                    <div class="">
                                        <input type="hidden" name="action" value="change-info">
                                        <input type="hidden" name="cId" value="${c.id}">
                                        <button type="submit" class="site-btn">Cập Nhật</button>
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
</html>
