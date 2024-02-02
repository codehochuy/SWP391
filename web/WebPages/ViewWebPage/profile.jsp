<%-- 
    Document   : profile
    Created on : Feb 2, 2024, 1:12:18 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>TITAN - Hồ Sơ</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Construction Company Website Template" name="keywords">
        <meta content="Construction Company Website Template" name="description">

        <!-- Favicon -->
        <link href="WebPages/ViewWebPage/img/favicon.ico" rel="icon">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">

        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/flaticon/font/flaticon.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/animate/animate.min.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/slick/slick.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/slick/slick-theme.css" rel="stylesheet">
        <!-- Template Stylesheet -->
        <link href="WebPages/ViewWebPage/css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="../../WebPages/ViewWebPage/HeaderPage.jsp"/>
            <!-- Page Header Start -->
            <div class="page-header">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h2>Hồ Sơ</h2>
                        </div>
                        <div class="col-12">
                            <a href="index.jsp">Trang Chủ</a>
                            <a href="">Hồ Sơ</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="site-section">
                <div class="container">

                    <div class="row mb-5">
                        <div class="col-md-9 order-2">

                            <div class="col-md-12">
                                <h2 class="h3 mb-3 text-black">Hồ sơ của tôi</h2>
                                <div class="p-3 p-lg-5 border display">
                                    <img src="./img/${sessionScope.USER.avatar}" style="padding-bottom: 10px" alt="Image" class="img-fluid">
                                    <h3 for="c_code" class="text-black mb-3">Tên: ${user.name}</h3>
                                    <p for="c_code" class="text-black mb-3">Số điện thoại: ${user.phone}</p>
                                    <p for="c_code" class="text-black mb-3">Địa chỉ: ${user.address}</p>
                                    <div class="input-group w-75">
                                        <div class="input-group-append">
                                            <!--                                            <form action="#">
                                                                                            <button class="btn btn-primary btn-sm" type="button" data-toggle="modal"
                                                                                                            data-target="#ModalUP" onclick="getData()" id="button-addon2">Thay đổi thông tin</button>
                                                                                        </form>-->
                                            <div class="deleteBtn">
                                                <!-- Button HTML (to Trigger Modal) -->
                                                <a href="#myModal" class="trigger-btn btn btn-primary btn-sm" data-toggle="modal">Thay đổi thông tin</a>
                                            </div>

                                            <!-- Modal HTML -->
                                            <div id="myModal" class="modal fade">
                                                <div class="modal-dialog modal-confirm">
                                                    <div class="modal-content">
                                                        <div class="modal-header flex-column">
                                                            <div class="icon-box">
                                                                <h4>Thay đổi thông tin</h4>
                                                            </div>						

                                                            <form action="UpdateProfile" method="post" class="form-horizontal">
                                                                <div class="change">

                                                                    <div><img src="./img/${sessionScope.USER.avatar}" class="avatar img-thumbnail" alt="avatar"></div>
                                                                    <label class="control-label">Thay ảnh đại diện</label>
                                                                    <input type="file" name="avatar" class="form-control">
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="control-label">Tên người dùng:</label>

                                                                    <input class="form-control" name="name" type="text" value="${user.name}">

                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="control-label">Số điện thoại:</label>

                                                                    <input class="form-control" name="phone" type="text" value="${user.phone}">

                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="control-label">Địa chỉ:</label>
                                                                    <%--<c:import url="demoAddress.html"/>--%>

                                                                </div>
                                                                <div class="modal-footer justify-content-center">

                                                                    <button type="submit" class="btn btn-primary" id="">Cập nhật</button>
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>

                                                                </div>
                                                            </form>    
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div class="col-md-3 order-1 mb-5 mb-md-0">
                            <div class="border p-4 rounded mb-4">
                                <h3 class="mb-3 h6 text-uppercase text-black d-block">Tài khoản của tôi</h3>
                                <div class="mb-0" style="padding-left: 15px;"> 
                                    <a href="Profile" class="d-flex">Hồ sơ</a>
                                    <a href="ChangePassword" class="d-flex">Đổi mật khẩu</a>
                                    <a href="BoughtOrder" class="d-flex">Đơn hàng đã mua</a>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>





            <jsp:include page="../../WebPages/ViewWebPage/Footer.jsp"/>

            <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        </div>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/easing/easing.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/wow/wow.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/isotope/isotope.pkgd.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/lightbox/js/lightbox.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/waypoints/waypoints.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/counterup/counterup.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/slick/slick.min.js"></script>

        <!-- Template Javascript -->
        <script src="WebPages/ViewWebPage/js/main.js"></script>
    </body>
</html>
