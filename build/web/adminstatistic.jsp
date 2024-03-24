<%-- 
    Document   : adminstatistic
    Created on : Mar 16, 2024, 12:54:18 AM
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
            <h3 class="text-center text-danger mt-3">THỐNG KÊ</h3>
            <div class="container pt-4">
                <!--Section: Statistics with subtitles-->
                <section>
                    <div class="row" id="total">
                        
                        <div class="col-xl-6 col-md-12 mb-4">
                            <div class="card shadow">
                                <div style="padding: 10px 15px">
                                    <div class="d-flex justify-content-between p-md-1">
                                        <div class="d-flex flex-row">
                                            <div class="align-self-center">
                                                
                                            </div>
                                        </div>
                                        <div style="text-align: end">
                                            <h4 style="color: #1B813A">Số lượng sản phẩm</h4>
                                            <p class="mb-0"></p>
                                            <h2 class="h1 mb-0">${requestScope.countProduct}</h2>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                                    
                    <div class="col-xl-6 col-md-12 mb-4">
                        <div class="card shadow">
                            <div style="padding: 10px 15px">
                                <div class="d-flex justify-content-between p-md-1">
                                    <div class="d-flex flex-row">
                                        <div class="align-self-center">
                                            
                                        </div>
                                    </div>
                                    <div style="text-align: end"> 
                                        <h4 style="color: darkviolet">Số lượng đơn đặt hàng</h4>
                                        <p class="mb-0"></p>
                                        <h2 class="h1 mb-0">${requestScope.countOrder}</h2> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                                    
                    <div class="col-xl-6 col-md-12 mb-4">
                        <div class="card shadow">
                            <div style="padding: 10px 15px">
                                <div class="d-flex justify-content-between p-md-1">
                                    <div class="d-flex flex-row">
                                        <div class="align-self-center">
                                            
                                        </div>
                                    </div>
                                    <div style="text-align: end"> 
                                        <h4 style="color: #06439F;">Số lượng Khách hàng</h4>
                                        <p class="mb-0"></p>
                                        <h2 class="h1 mb-0">${requestScope.countCustomer}</h2> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                                    
                    <div class="col-xl-6 col-md-12 mb-4">
                        <div class="card shadow">
                            <div style="padding: 10px 15px">
                                <div class="d-flex justify-content-between p-md-1">
                                    <div class="d-flex flex-row">
                                        <div class="align-self-center">
                                            
                                        </div>
                                    </div>
                                    <div style="text-align: end"> 
                                        <h4 style="color: chocolate">Số Tiền Thu Được</h4>
                                        <p class="mb-0"></p>
                                        <h2 class="h1 mb-0"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${requestScope.countTotalMoney}"/> VND</h2> 

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                                        
                    <div class="col-xl-6 col-md-12 mb-4">
                        <div class="card shadow">
                            <div style="padding: 10px 15px">
                                <div class="d-flex justify-content-between p-md-1">
                                    <div class="d-flex flex-row">
                                        <div class="align-self-center">
                                            
                                        </div>
                                    </div>
                                    <div style="text-align: end"> 
                                        <h4 style="color: gray;">Số đơn đang chuẩn bị</h4>
                                        <p class="mb-0"></p>
                                        <h2 class="h1 mb-0">${requestScope.countDeliveringOrders}</h2> 

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                                        
                    <div class="col-xl-6 col-md-12 mb-4">
                        <div class="card shadow">
                            <div style="padding: 10px 15px">
                                <div class="d-flex justify-content-between p-md-1">
                                    <div class="d-flex flex-row">
                                        <div class="align-self-center">
                                            
                                        </div>
                                    </div>
                                    <div style="text-align: end"> 
                                        <h4 style="color: darkgreen">Số đơn đã giao</h4>
                                        <p class="mb-0"></p>
                                        <h2 class="h1 mb-0">${requestScope.countDeliveredOrders}</h2> 

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                                        
                    <div class="col-xl-6 col-md-12 mb-4">
                        <div class="card shadow">
                            <div style="padding: 10px 15px">
                                <div class="d-flex justify-content-between p-md-1">
                                    <div class="d-flex flex-row">
                                        <div class="align-self-center">
                                        </div>
                                    </div>
                                    <div style="text-align: end"> 
                                        <h4 style="color: red;">Số đơn đã hủy</h4>
                                        <p class="mb-0"></p>
                                        <h2 class="h1 mb-0">${requestScope.countCanceledOrders}</h2> 

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                                        
                </div>
        </div>
    </section>
    <!--Section: Statistics with subtitles-->
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
<br>
<br>
<br>
<br>
<br>
<br>


<jsp:include page="component/adminfooter.jsp"></jsp:include>
</html>
