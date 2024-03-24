<%-- 
    Document   : index.jsp
    Created on : Mar 1, 2024, 10:47:19 PM
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
        <jsp:include page="component/slider.jsp"></jsp:include>
            <!-- Category -->
            <section class="blog spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <ul class="filter__controls">
                                <li class="">DANH MỤC SẢN PHẨM</li>
                            </ul>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                        <c:forEach items="${requestScope.categories}" var="c">
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="blog__item">
                                    <div class="blog__item__text">
                                        <span><img src="${c.img}"
                                                   alt=""></span>
                                        <h5>${c.name}</h5>
                                        <a href="get-products?cId=${c.id}">Xem Thêm</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
        </section>

        <!-- Products -->
        <section class="product spad mt-5">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <ul class="filter__controls">
                            <li data-filter=".new-arrivals">Sản Phẩm Mới</li>
                        </ul>
                    </div>
                </div>
                <div class="row product__filter">
                    <c:forEach items="${requestScope.newArrival}" var="newProduct">
                        <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
                            <div class="product__item">
                                <div class="product__item__pic set-bg"
                                     data-setbg="${newProduct.images[0]}">
                                    <span class="label">Mới</span>
                                    <ul class="product__hover">
                                        <li><a href="product-detail?pId=${newProduct.id}"><img src="images/icon/search.png" alt=""></a></li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6>${newProduct.name}</h6>
                                    <a href="product-detail?pId=${newProduct.id}" class="add-cart">+ Xem sản phẩm</a>
                                    <h5><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${newProduct.price}"/>VND</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <jsp:include page="component/footer.jsp"></jsp:include>
        <jsp:include page="component/jsplugins.jsp"></jsp:include>
    </body>
</html>
