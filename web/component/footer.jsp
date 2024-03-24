<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Footer Section Begin -->
<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="footer__about">
                    <div class="footer__logo">
                        <a href="#"><img src="img/footer-logo.png" alt=""></a>
                    </div>
                    <p>KHÁCH HÀNG LÀ THƯỢNG ĐẾ.</p>
                </div>
            </div>
            <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
                <div class="footer__widget">
                    <h6>Mua Sắm</h6>
                    <ul>
                        <li><a href="#">Cửa Hàng Thời Trang Nam</a></li>
                        <li><a href="#" class="text-secondary">Từ Từ đang cập nhật</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-sm-6">
                <div class="footer__widget">
                    <h6>Mua Sắm Đê</h6>
                    <ul>
                        <li><a href="#">Liên Hệ</a></li>
                        <li><a href="#">Vận Chuyển</a></li>
                        <li><a href="#">Đổi Trả Hàng</a></li>
                        <li><a href="#" class="text-secondary">Cũng Từ Từ đang cập nhật</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-sm-6">
                <p style="margin-top: 20px">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.60994153052!2d106.80730807586922!3d10.841132857995166!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752731176b07b1%3A0xb752b24b379bae5e!2sFPT%20University%20HCMC!5e0!3m2!1sen!2s!4v1703229023591!5m2!1sen!2s" width="330" height="200" style="border:1px; border-radius: 5%;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade">

                    </iframe>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="footer__copyright__text">
                    <p>Copyright ©
                        <script>
                            document.write(new Date().getFullYear());
                        </script>
                        All rights reserved | Đây là sản phẩm bài Assignment môn PRJ301 <i class="fa fa-heart-o"
                                                                                           aria-hidden="true"></i> thực hiện bởi <a href="https://colorlib.com" target="_blank">Nhóm 9</a>
                    </p>
                </div>
            </div>
        </div>
    </div>

</footer>
<!-- Footer Section End -->

<!-- Search Begin -->
<div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch">+</div>
        <form class="search-model-form" action="get-products" method="GET">
            <input type="text" placeholder="Tìm Kiếm..." name="keyword" value="${param.keyword}">
        </form>
    </div>
</div>
<!-- Search End -->
