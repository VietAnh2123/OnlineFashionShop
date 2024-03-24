<%-- 
    Document   : error.jsp
    Created on : Mar 16, 2024, 2:37:07 AM
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
            <section class="error-area error-one">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-xxl-7 col-xl-8 col-lg-8">
                            <div class="error-content text-center">
                                <span class="error-404">404</span>
                                <h5 class="sub-title">Xin lỗi Không tìm thấy trang</h5>
                                <p class="text">
                                    Có một số vấn đề, Bạn hãy kiểm tra lại đường dẫn....
                                </p>
                                <div class="error-form">                                        
                                        <div class="error-btn rounded-buttons">
                                            <a class="btn primary-btn rounded-full text-white" href="index.jsp">Trang chủ</a>
                                        </div>
                                </div>
                            </div>
                            <!-- error content -->
                        </div>
                    </div>
                    <!-- row -->
                </div>
                <!-- container -->
            </section>
            
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
        <jsp:include page="component/footer.jsp"></jsp:include>
    </body>
</html>
