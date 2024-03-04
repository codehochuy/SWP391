<%-- Document : HeaderPage Created on : Jan 25, 2024, 12:04:45 AM Author : ACER --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <style>
            .avatar img {
                border-radius: 50%;
                width: 40px;
                height: 40px;
                object-fit: cover;
            }
        </style>
    </head>

    <body>
        <!-- Top Bar Start -->
        <div class="top-bar">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-lg-4 col-md-12">
                        <div class="logo">
                            <a href="index">
                                <h1>TITAN</h1>
                                <!--<img src="img/Product1.jpg" alt="Logo">--> 
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-7 d-none d-lg-block">
                        <div class="row">
                            <div class="col-4">
                                <div class="top-bar-item">
                                    <div class="top-bar-icon">
                                        <i class="flaticon-calendar"></i>
                                    </div>
                                    <div class="top-bar-text">
                                        <h3>MỞ CỬA</h3>
                                        <p>THỨ 2 - THỨ 6, 8:00 - 21:00</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="top-bar-item">
                                    <div class="top-bar-icon">
                                        <i class="flaticon-call"></i>
                                    </div>
                                    <div class="top-bar-text">
                                        <h3>LIÊN HỆ</h3>
                                        <p>+84 123 456 789</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="top-bar-item">
                                    <div class="top-bar-icon">
                                        <i class="flaticon-send-mail"></i>
                                    </div>
                                    <div class="top-bar-text">
                                        <h3>Email</h3>
                                        <p>titan@gmail.com</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Top Bar End -->

        <!-- Nav Bar Start -->
        <div class="nav-bar">
            <div class="container-fluid">
                <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
                    <a href="#" class="navbar-brand">MENU</a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse"
                            data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto">
                            <a href="<%=request.getContextPath()%>/index" class="nav-item nav-link">Trang
                                chủ</a>
                            <a href="About" class="nav-item nav-link">Giới thiệu</a>
                            <a href="Service" class="nav-item nav-link">Dịch vụ</a>
                            <a href="Team" class="nav-item nav-link">Đội ngũ nhân sự</a>
                            <a href="Project" class="nav-item nav-link">Dự án</a>
                            <a href="Blog" class="nav-link nav-link">Tin tức</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Bảng giá</a>
                                <div class="dropdown-menu">
                                    <a href="FullContructionPrice" class="dropdown-item">Bảng Giá Xây Nhà Trọn
                                        Gói</a>
                                    <a href="RawContructionPrice" class="dropdown-item">Bảng Giá Xây Nhà Phần
                                        Thô</a>
                                </div>
                            </div>
                            <a href="Contact" class="nav-item nav-link">Liên Hệ</a>
                            <a href="Quotation" class="nav-item nav-link">Báo Giá</a>
                        </div>
                        <c:if test="${empty sessionScope.USER}">
                            <div class="ml-auto">
                                <a class="btn" href="../../Login.jsp">Đăng nhập</a>
                            </div>
                        </c:if>
                        <c:if test="${not empty sessionScope.USER}">
                            <div class="nav-item dropdown avatar">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><img
                                        alt="avatar" src="./img/${sessionScope.USER.avatar}" width="50px"></a>
                                <div class="dropdown-menu">
                                    <a href="Profile" class="dropdown-item">Hồ sơ</a>
                                    <a href="QuotationHistory" class="dropdown-item">Lịch sử báo giá</a>
                                    <a href="Logout" class="dropdown-item">Đăng xuất</a>
                                </div>
                            </div>
                        </c:if>


                    </div>
                </nav>
            </div>
        </div>
        <!-- Nav Bar End -->
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var currentUrl = window.location.href;

                // Tìm phần tử a có href tương ứng với URL hiện tại và thêm lớp active
                var navLinks = document.querySelectorAll(".nav-link");
                navLinks.forEach(function (link) {
                    if (link.href === currentUrl) {
                        link.classList.add("active");
                    }
                });
            });
        </script>

        <script src="https://tudongchat.com/js/chatbox.js"></script>
        <script>
            const tudong_chatbox = new TuDongChat('78jWmMQUwETtYhrcgI9h5')
            tudong_chatbox.initial()
        </script>
    </body>

</html>