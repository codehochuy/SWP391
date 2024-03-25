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
        <title>TITAN - Đổi mật khẩu</title>
        <link rel="icon" href="img/logo.jpg" type="image/x-icon">
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
        <style>
            .display img{
                width: 200px; 
                height: 250px; 
                object-fit: cover
            }
            .change img{
                width: 150px; 
                height: 200px; 
                object-fit: cover
            }
        </style>
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
                            <a href="index">Trang Chủ</a>
                            <a href="">Hồ Sơ</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="site-section">
                <div class="container">
                    <div class="row mb-5">
                        <div class="col-md-9 order-2">
                            <h1>Thay đổi mật khẩu</h1>
                            <!-- Form -->
                            <form id="form" action="ChangePassword" method="post">
                                <!-- Email Address -->
                                <div class="form-group">
                                    <label for="email">Tài khoản</label>
                                    <input type="email" readonly="" id="email" class="form-control"  name="name" required value="${user.username}"/>
                                </div>
                                <!-- Old Password -->
                                <div class="form-group">
                                    <label for="password1">Mật khẩu cũ</label>
                                    <input type="password" class="form-control" id="password0" placeholder="Nhập mật khẩu cũ." required/>
                                </div>
                                <!-- Password -->
                                <div class="form-group">
                                    <label for="password1">Mật khẩu mới</label>
                                    <input type="password" class="form-control" name="password" id="password1" placeholder="Mật khẩu ít nhất 8 ký tự." required
                                           pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"
                                           title="Mật khẩu bao gồm ít nhất 1 chữ cái in hoa, 1 chữ cái in thường và 1 chữ số." />
                                </div>
                                <!-- Confirm Password -->
                                <div class="form-group">
                                    <label for="password2">Nhập lại mật khẩu mới</label>
                                    <input type="password" id="password2" name="password" class="form-control" placeholder="Nhập lại mật khẩu mới." name="password" required
                                           pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$" />
                                </div>
                                <button class="btn btn-primary" onclick="processFormData()" type="submit">Thay đổi mật khẩu</button>
                            </form>
                            <!-- Error/Success Message -->
                            <div class="message-container">
                                <h3 id="message"></h3>
                            </div>
                        </div>
                        <div class="col-md-3 order-1 mb-5 mb-md-0">
                            <div class="border p-4 rounded mb-4">
                                <h3 class="mb-3 h6 text-uppercase text-black d-block">Tài khoản của tôi</h3>
                                <div class="mb-0" style="padding-left: 15px;"> 
                                    <a href="Profile" class="d-flex">Hồ sơ</a>
                                    <a href="ChangePassword" class="d-flex">Đổi mật khẩu</a>
                                    <a href="QuotationHistory" class="d-flex">Lịch sử báo giá</a>
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
        <script>
                                    document.querySelector('input[type=file]').addEventListener('change', function (e) {
                                        var reader = new FileReader();

                                        reader.onload = function (event) {
                                            document.querySelector('img.avatar').src = event.target.result;
                                        }

                                        reader.readAsDataURL(e.target.files[0]);
                                    });
        </script>
        <script>
            const form = document.getElementById("form");
            const password0E0 = document.getElementById("password0");
            const password1El = document.getElementById("password1");
            const password2El = document.getElementById("password2");
            const message = document.getElementById("message");
            const messageContainer = document.querySelector(".message-container");

            let isValid = false;
            let passwordsMatch = false;
            let checkOldPassword = false;

            function validateForm() {
                isValid = form.checkValidity();
                if (!isValid) {
                    message.textContent = "Vui lòng điền hết tất cả các trường.";
                    message.style.color = "red";
                    messageContainer.style.borderColor = "red";
                    return;
                }
                if (password0E0.value === '${user.password}') {
                    checkOldPassword = true;
                    password0E0.style.borderColor = "green";
                } else {
                    checkOldPassword = false;
                    message.textContent = "Mật khẩu cũ không chính xác.";
                    message.style.color = "red";
                    password0E0.style.borderColor = "red";
                    return;
                }
                if (password1El.value === password2El.value) {
                    passwordsMatch = true;
                    password1El.style.borderColor = "green";
                    password2El.style.borderColor = "green";
                } else {
                    passwordsMatch = false;
                    message.textContent = "Mật khẩu nhập lại không chính xác.";
                    message.style.color = "red";
                    messageContainer.style.borderColor = "red";
                    password1El.style.borderColor = "red";
                    password2El.style.borderColor = "red";
                    return;
                }
                if (isValid && passwordsMatch && checkOldPassword) {
                    message.textContent = "Thay đổi thành công.";
                    message.style.color = "green";
                    messageContainer.style.borderColor = "green";
                }
            }
            function processFormData(e) {
                validateForm();
                if (isValid && passwordsMatch && checkOldPassword) {
                    return true;
                } else {
                    e.preventDefault();
                    return false;
                }
            }
            document.getElementById("form").addEventListener("submit", processFormData);
        </script>
    </body>
</html>
