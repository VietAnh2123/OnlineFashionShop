<%-- 
    Document   : productslist
    Created on : Mar 16, 2024, 2:27:23 AM
    Author     : AD
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <c:if test="${sessionScope.admin==null}">
        <jsp:forward page="adminlogin.jsp"></jsp:forward>
    </c:if>
    <jsp:include page="component/head.jsp"></jsp:include>
        <body>
        <jsp:include page="component/adminheader.jsp"></jsp:include>
            <div class="container">
                <h3 class="text-center text-primary mt-3">Danh Sách Sản Phẩm</h3>

                <table border="1" class="table mt-3">
                    <thead class="thead-dark">
                        <tr>
                            <th>Tên</th>
                            <th>Ảnh</th>
                            <th>Giá</th>
                            <th>Màu</th>
                            <th>Size</th>
                            <th>Số lượng</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.products}" var="p">
                    <form action="manage-update-product" method="POST">
                        <tr>
                            <td>${p.name}</td>
                            <td><img src="${p.images[0]}" width="50px" height="50px"></td>
                            <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${p.price}"/></td>

                            <td>${p.color}</td>
                            <td>${p.sizeName}</td>
                            <td>
                                <input type="number" value="${p.stock}" name="stock" class="form form-control"> 
                            </td>
                            <td>
                                <input type="hidden" name="sizeId" value="${p.sizeID}">
                                <input type="submit" value="Update" class="btn btn-warning">
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>

            <div>
                <nav aria-label="...">
                    <ul class="pagination pagination-sm">
                        <c:forEach var="i" begin="1" end="${numberPage}" step="1">
                            <li class="page-item ${requestScope.index==i?'disabled':''}" >
                                <a class="page-link" href="manage-products?index=${i}" >${i}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>
            </div>

            <c:if test="${not empty requestScope.productsOutOfStock}">    
                <h3 class="text-center text-primary mt-3 text-secondary">Sản Phẩm Hết Hàng</h3>
                <table border="1" class="table mt-3">
                    <thead class="thead-dark">
                        <tr>
                            <th>Tên</th>
                            <th>Ảnh</th>
                            <th>Giá</th>
                            <th>Màu</th>
                            <th>Size</th>
                            <th>Số lượng</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.productsOutOfStock}" var="p">
                        <form action="manage-update-product" method="POST">
                            <tr>
                                <td>${p.name}</td>
                                <td><img src="${p.images[0]}" width="50px" height="50px"></td>
                                <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${p.price}"/></td>

                                <td>${p.color}</td>
                                <td>${p.sizeName}</td>
                                <td>
                                    <input type="number" value="${p.stock<0?'0':p.stock}" name="stock" class="form form-control"> 
                                </td>
                                <td>
                                    <input type="hidden" name="sizeId" value="${p.sizeID}">
                                    <input type="submit" value="Update" class="btn btn-warning">
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <br>
            <br>
            <br>
        </div>

    </body>
    <jsp:include page="component/jsplugins.jsp"></jsp:include>
    <jsp:include page="component/adminfooter.jsp"></jsp:include>
</html>
