<%-- 
    Document   : customerlist
    Created on : Mar 16, 2024, 1:50:02 AM
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
                <h3 class="text-center text-primary mt-3">Danh Sách Khách Hàng</h3>
                <table border="1" class="table mt-3">
                    <thead class="thead-dark">
                        <tr>
                            <th>Tên</th>
                            <th>Email</th>
                            <th>Số điện thoại</th>
                            <th>Địa chỉ</th>
                            <th>Giới tính</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.customers}" var="c">
                        <tr>
                            <td>${c.fullname}</td>
                            <td>${c.email}</td>
                            <td>${c.phoneNumber}</td>
                            <td>${c.address}</td>
                            <td>${c.gender}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <jsp:include page="component/adminfooter.jsp"></jsp:include>
</html>
