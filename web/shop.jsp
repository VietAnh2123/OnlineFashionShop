<%-- 
    Document   : shop
    Created on : Mar 1, 2024, 11:44:07 PM
    Author     : AD
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <h4>Cửa Hàng</h4>
                                <div class="breadcrumb__links">
                                    <a href="index">Trang Chủ</a>
                                    <span>Cửa Hàng</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->
            <!-- Shop Section Begin -->
            <section class="shop spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="shop__sidebar">
                                <div class="shop__sidebar__search">
                                    <form action="get-products" method="GET">
                                        <input type="text" placeholder="Tìm Kiếm..." name="keyword" value="${param.keyword}">
                                    <button type="submit"><span class="icon_search"></span></button>
                                </form>
                            </div>
                            <div class="shop__sidebar__accordion">
                                <div class="accordion" id="accordionExample">
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseOne">Thể Loại</a>
                                        </div>
                                        <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__categories">
                                                    <ul class="nice-scroll">
                                                        <li><a href="get-products">Tất cả</a></li>
                                                            <jsp:useBean id="db" class="dao.CategoryDAO"></jsp:useBean>
                                                            <c:forEach items="${db.listCategory()}" var="c">
                                                            <li><a href="get-products?cId=${c.id}">${c.name}</a></li>
                                                            </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="shop__product__option">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="shop__product__option__left">
                                        <!--<p>Showing 1–12 of 126 results</p>-->
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="shop__product__option__right">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach items="${requestScope.productsList}" var="p">
                                <div class="col-lg-4 col-md-6 col-sm-6">
                                    <div class="product__item">
                                        <div class="product__item__pic set-bg"
                                             data-setbg="${p.images[0]}">
                                            <ul class="product__hover">
                                                </li>
                                                <li><a href="product-detail?pId=${p.id}"><img src="images/icon/search.png" alt=""></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__item__text">
                                            <h6>${p.name}</h6>
                                            <a href="product-detail?pId=${p.id}" class="add-cart">Xem sản phẩm</a>
                                            <h5><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${p.price}"/> VND</h5>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <!-- Paging -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="product__pagination">
                                    <c:forEach var="i" begin="1" end="${numberPage}" step="1">
                                        <a href="get-products?index=${i}&cId=${param.cId}&keyword=${param.keyword}" ${requestScope.index==i?'class=active':''}>${i}</a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shop Section End -->
        <jsp:include page="component/footer.jsp"></jsp:include>
        <jsp:include page="component/jsplugins.jsp"></jsp:include>
    </body>
</html>