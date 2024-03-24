<%-- 
    Document   : orderslist
    Created on : Mar 18, 2024, 12:37:00 AM
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
                <h3 class="text-center text-primary mt-3">Danh Sách Đơn Hàng</h3>
                <table border="1" class="table mt-3">
                    <thead class="thead-dark">
                        <tr>
                            <th>No.</th>
                            <th>Mã Khách Hàng</th>
                            <th>Địa chỉ</th>
                            <th>Ghi Chú</th>
                            <th>Giá</th>
                            <th>Ngày mua</th>
                            <th colspan="3" class="text-center">Tình Trạng</th>

                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.deliveringOrders}" var="o" varStatus="count">
                        <tr>
                            <td>${count.count}</td>
                            <td><a href="manage-customer-detail?customerID=${o.customer_id}" class="forgot">${o.customer_id}</a></td>
                            <td>${o.address}</td>
                            <td>${o.note}</td>
                            <td>
                                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.totalPrice}"/>
                            </td>
                            <td>  
                                <fmt:formatDate pattern = "dd-MM-yyyy" value = "${o.createDate}" />

                            </td>
                            <td class="text-muted">${o.status}</td>
                            <td>
                                <form action="update-orders" method="POST">
                                    <input type="hidden" name="oId" value="${o.id}">
                                    <input type="hidden" name="action" value="completed">
                                    <input type="submit" value="Đã giao" class="btn btn-success">
                                </form>
                                <br>
                                <form action="update-orders" method="POST">
                                    <input type="hidden" name="oId" value="${o.id}">
                                    <input type="hidden" name="action" value="cancel">
                                    <input type="submit" value="Đã hủy" class="btn btn-danger">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>

                    <c:forEach items="${requestScope.deliveredOrders}" var="o" varStatus="count">
                        <tr>
                            <td>${count.count}</td>
                            <td><a href="manage-customer-detail?customerID=${o.customer_id}" class="forgot">${o.customer_id}</a></td>
                            <td>${o.address}</td>
                            <td>${o.note}</td>
                            <td>
                                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.totalPrice}"/>
                            </td>
                            <td>
                                <fmt:formatDate pattern = "dd-MM-yyyy" value = "${o.createDate}" />
                            </td>
                            <td class="text-success">${o.status}</td>
                        </tr>
                    </c:forEach>

                    <c:forEach items="${requestScope.canceledOrders}" var="o" varStatus="count">
                        <tr>
                            <td>${count.count}</td>
                            <td><a href="manage-customer-detail?customerID=${o.customer_id}" class="forgot">${o.customer_id}</a></td>
                            <td>${o.address}</td>
                            <td>${o.note}</td>
                            <td>
                                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.totalPrice}"/>
                            </td>
                            <td>
                                <fmt:formatDate pattern = "dd-MM-yyyy" value = "${o.createDate}" />
                            </td>
                            <td class="text-danger">${o.status}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </body>
    <jsp:include page="component/adminfooter.jsp"></jsp:include>
</html>
