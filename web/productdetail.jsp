<%-- 
    Document   : productdetail
    Created on : Mar 2, 2024, 2:31:14 PM
    Author     : AD
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="component/head.jsp"></jsp:include>
        <body>
        <jsp:include page="component/header.jsp"></jsp:include>
            <!-- Shop Details Section Begin -->
            <section class="shop-details">
                <div class="product__details__pic">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="product__details__breadcrumb">
                                    <a href="index">Trang Chủ</a>
                                    <a href="get-products">Cửa Hàng</a>
                                    <span>Chi Tiết Sản Phẩm</span>
                                </div>
                            </div>
                        </div>
                    <c:set value="${requestScope.product}" var="p"/>
                    <div class="row">
                        <div class="col-lg-3 col-md-3">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">
                                        <div class="product__thumb__pic set-bg"
                                             data-setbg="${p.images[0]}">
                                        </div>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">
                                        <div class="product__thumb__pic set-bg"
                                             data-setbg="${p.images[1]}">
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-6 col-md-9">
                            <div class="tab-content">
                                <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                    <div class="product__details__pic__item">
                                        <img src="${p.images[0]}"
                                             alt="">
                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-2" role="tabpanel">
                                    <div class="product__details__pic__item">
                                        <img src="${p.images[1]}"
                                             alt="">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="product__details__content">
                <div class="container">
                    <div class="row d-flex justify-content-center">
                        <div class="col-lg-8">
                            <div class="product__details__text">
                                <h4>${p.name}</h4>
                                <!--<h3>$270.00 <span>70.00</span></h3>-->
                                <h3><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${p.price}"/> VND</h3>
                                <p>${p.description}</p>
                                <div class="product__details__option">
                                    <div class="product__details__option__size">
                                        <span>Size:</span>
                                        <form action="product-detail" method="GET">
                                            <input type="hidden" name="pId" value="${p.id}">
                                           
                                            <c:forEach items="${requestScope.sizeList}" var="size">
                                                <label for="${size.name}" ${sizeId==size.id?'class=active':''}>${size.name}
                                                    <input type="radio" id="${size.name}" name="sizeId" value="${size.id}" onchange="this.form.submit()">
                                                </label>
                                            </c:forEach>
                                        </form>

                                    </div>
                                </div>
                                <p class="text-success">${stock}</p>
                                <p class="text-danger">${msg}</p>
                                <form action="add-cart" method="POST">
                                    <div class="product__details__cart__option">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                <input type="number" value="1" name="quantity">
                                            </div>
                                        </div>
                                        <input name="pId" value="${p.id}" type="hidden">
                                        <input name="sizeId" value="${sizeId}" type="hidden">
                                        <input type="submit" value="Thêm vào giỏ" class="primary-btn">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shop Details Section End -->

        <!-- Related Section Begin -->
<!--        <section class="related spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h3 class="related-title">Sản Phẩm Liên Quan</h3>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${requestScope.relatedList}" var="r">
                        <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="${r.images[0]}">
                                    <ul class="product__hover">
                                        <li><a href="product-detail?pId=${r.id}"><img src="images/icon/search.png" alt=""></a></li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6>${r.name}</h6>
                                    <a href="product-detail?pId=${r.id}" class="add-cart">Xem sản phẩm</a>
                                    <h5><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${r.price}"/> VND</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>-->
        <!-- Related Section End -->
        <jsp:include page="component/footer.jsp"></jsp:include>
        <jsp:include page="component/jsplugins.jsp"></jsp:include>
    </body>
</html>
