<%-- 
    Document   : userdetail
    Created on : Mar 2, 2024, 3:59:38 PM
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
            <section class="breadcrumb-option">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="breadcrumb__text">
                                <h4>Khách Hàng</h4>
                                <div class="breadcrumb__links">
                                    <!--                                    <a href="index">Thông Tin</a>-->
                                    <span>Thông Tin</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section style="background-color: #eee;">
                <div class="container py-5">
                <c:set value="${sessionScope.customer}" var="c"/>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="card mb-4 shadow">
                            <div class="card-body text-center">
                                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJgAAACUCAMAAABY3hBoAAAAY1BMVEX///8AAAD6+vq8vLzPz8/w8PARERHz8/NERESlpaXCwsLe3t7k5OQzMzOCgoJjY2MiIiJJSUkbGxvq6urV1dWxsbF4eHgWFhbIyMhdXV2ampqNjY1vb29TU1M4ODhOTk4pKSnYfbu9AAAG8klEQVR4nO1c15LqOhDEOSecDQb+/ysv7C7gMJJassypukW/W7QlzUxPwIfDF1988b+C6TmlHaRZkeSte0ebJ0WWBnbpeOa/YxV39Wk8GiSO46nu4n/BKhqawqVJPeEWzRB9lJRZppeWT+qJ9pKWnzrUKCgwUk+M9Sf2LUwvcrQeuKThvqzM7iq4Vyy4Y7ffiXqh5BnOUYTePry68xZaD5y7HWg5GWiHPLRnRzMtL9jO6heB1vOsMl28DCOr9PGqb/p4Gcat1kSrHHXSeqAvdfCyfd28DMO3t/Oqc/28DCPfepzmaQ9aD5w2BQKn2YuXYaRb/IZGL7FGpkzLQ0Nj7t/ldNhVnRU0mQ9fykJxz8oeWr5tAnt6X8wuOIMSRM1tmNg5DtX6FnsVaDOZigUg+3Vj2paTQjG/l6ZlpsCyKU8y25BKSmX3DFATbsBfAlMkgkWWCMUrFmKV0CHBXyobiMXrXRHJF10BZhJpsSO++D22XMlI1GdL4apWbOwF+poV4G4HlJclXKrFM1gbYGZhS5ni7ZcRLYBtHjGfIfZgcs4HEJopso4lDHS+XHkpEkdOFzhMwCIlfSJgS4hl1uLXk40iVSJmJry1nngN2Q2DtswQaTPxGq58lh8BxE6CJcS73ihoKOAsE75FAZuuUoJDdAZ3y4ANu6iUHgBRYFx4Wwa8WaaSQXiI/uEYlQkkEYJLylgYUbMcNySO3hJSYIYBWJkTy5H8Q63ogLwyOzOxAVXnqpVRAal+z5tZdoU46FatgAQRY10TB8lwj2qFyg4iltFBxUYS+113zKUXh9LAPe8Yw5WZWKkV1OcLQFZ5t0vKlQGC54Ed/ZhBix/wpSB5vgTk+R+gFAJY1TwrxUpA9zBfG6yaK6mLEuRl+OtnHbRCqXL74U5UvvZkHdohla5oHeDTIL0R/FKu/CVDNP8f1p4M7zTIOwykOvmHtdzDWw032bOMJNr7zfJhKIL/QTaxRL3rA6s4Hkn02C5yYxQSN+zuL5ZrVzK9UjnDlGp33pZusgPU6xsyvkyum35c+gtMyb2AF6JCqTc2jCUxUDA9gddgZQdulmEc1BYv9Jib9aQHgZa3RJaYkSAGIGPruogZvlhmhAqDU9uJGYnI0QYqQzcaiN1FI68RGj1jidwYwhZil+FZS3ADlnVGrzg0OjWqXzcSG6ND/Kpy+OR4ZHV63a7HrkK9LgYx3I81jzDrvJXMra/ngdcJxvfpDT/G6+CjZ0s/Bnv+5423pudzOw+dXVW2HZ6yqacvnn7cRBXGSsIilZ4pr/v5iOXfMDEOkNlxWSVAmgTGXL2aAvfZz28fxixZescYup9Lz2U3rPe5NCujgJhdl2buIQqWSEftIFunV+65JsICNJiwrj0Dmt8nA7cXh7N9S9IupiM8ko+vND+QJXF7F2bUWVZo80U30EZYZ0nCrpurYbRQ3Npb/4gtirjqU1UTiOriVMFSlI1oGZUWFeFuxDMCfyHfpSQhSE2uxCN8Yx61TIgeDiX//amGkM19QtdQreD+U6qY2+EatU1Ie7wtI/tc3Dqpphv2AC8ynUkL42lFfbwOB87P0Bk+p3yxDhQbwA5+K2nxC85Zapx051kZfZKc0/c1+YpflEwZx7rJJSvGKrWb2WDphYT5/qyzVOsfMcFyZWfmE4zTTzRM389+hnEynJ+hT5/siW2AR2uMgvMIvcnsLVYEfWV4FyYmt0zz3WfoBX4tkFQl2gL4E+TB8KOeQ22Z9j+GUWm/L5j+orZM+z9eqcq/UCYQRUDt/z8kBPZF+BBR9tHNixIY4qk0b23LHyCGjPGtyyv7E0ug7tTq/u9PDBTIy/u/OzGiRU8iOn6WWA63GeuPEpMoiixE9s7EZAZrzeRzxBKpJ2eVrF2JYZ7iDev4GWK59CBy8BliCin+O5epNUdx8231StNoL2butr+1rni9X1lNG0/K3/J/6uPgPe6gMr/0g/er6cvgJrnbhlzizSxXm01cYch18JrZZqZBYceT/svGkls4aRwHG78J4UyqNrfNGY49KU32W76MYoaTIZ9RQ2Fr+g+qNlP+nkw0/ZAHY6haFsN0DuBM/MtZCHP2wQxdhnQ/zlkVpJH9aIsXzmRUr7F45MxqbW4/SFDzhn5WqD/p/axKtSgdjZYDHKnpWIuxtl5rOfcHwaKs0Ta1za3Nlna9/O9/obFf8Ea8Kh7nYzNYpN+NraEZV7MzzLmWrXBSohXQ/ny7wbKjuCzjyLaCtPdzovl5S3V/s2eKeFD8wkoxaC3JU9RqhY/S9PSBa4YZUSfKRpJGn/venZX20NRa26eamwRCOF3dCDbu1tTdnheeCdOJraYgp5WORRqWiAveE15VB6e0+UWangJLJc5/8cUXf/gPXTFZmzr97+QAAAAASUVORK5CYII=" alt="avatar"
                                     class="rounded-circle img-fluid" style="width: 150px;">
                                <h5 class="my-3">${c.fullname}</h5>
                                <!--                                    <p class="text-muted mb-1">Full Stack Developer</p>
                                                                    <p class="text-muted mb-4">Bay Area, San Francisco, CA</p>-->
                                <div class="d-flex justify-content-center mb-2">
                                    <form action="customer" method="GET">
                                        <input type="hidden" name="action" value="change-info">
                                        <button type="submit" class="site-btn">Cập Nhập Thông Tin</button>
                                    </form>
                                </div>
                                <div class="d-flex justify-content-center mb-2">
                                    <form action="customer" method="GET">
                                        <input type="hidden" name="action" value="change-password">
                                        <button type="submit" class="site-btn">Đổi Mật Khẩu</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="card mb-4">
                            <div class="card-body shadow">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Tên</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">${c.fullname}</p>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Email</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">${c.email}</p>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Số Điện Thoại</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">${c.phoneNumber}</p>
                                    </div>
                                </div>
                                <hr>
                                <!--                                    <div class="row">
                                                                        <div class="col-sm-3">
                                                                            <p class="mb-0">Mobile</p>
                                                                        </div>
                                                                        <div class="col-sm-9">
                                                                            <p class="text-muted mb-0">(098) 765-4321</p>
                                                                        </div>
                                                                    </div>
                                                                    <hr>-->
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Địa Chỉ</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">${c.address}</p>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Giới Tính</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">${c.gender}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="component/footer.jsp"></jsp:include>
        <jsp:include page="component/jsplugins.jsp"></jsp:include>
    </body>
</html>
