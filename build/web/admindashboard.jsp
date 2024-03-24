<%-- 
    Document   : admindashboard
    Created on : Mar 16, 2024, 12:18:37 AM
    Author     : AD
--%>

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
                <h2 class="text-center mt-3">Xin Chào Quản Trị Viên ${sessionScope.admin.getUsername()}</h2>
            <div class="map mt-3">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.60994153052!2d106.80730807586922!3d10.841132857995166!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752731176b07b1%3A0xb752b24b379bae5e!2sFPT%20University%20HCMC!5e0!3m2!1sen!2s!4v1703229023591!5m2!1sen!2s" height="500" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0">

                </iframe>
            </div>
        </div>
    </body>
    <br>
    <br>
    <br>
    <br>
    <br>

    <jsp:include page="component/adminfooter.jsp"></jsp:include>
</html>
