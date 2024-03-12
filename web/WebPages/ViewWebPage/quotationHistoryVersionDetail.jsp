<%-- 
    Document   : Project
    Created on : Jan 24, 2024, 11:54:53 PM
    Author     : ACER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>TITAN - Lịch Sử Báo Giá</title>
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
            table {
                width: 100%;
                border-collapse: collapse;
                border-radius: 8px;
                overflow: hidden;
                margin: 20px 0;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            thead {
                background-color: #fdbe33;
                color: #fff;
                text-align: center;
            }
            th, td {
                padding: 15px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            tbody tr:nth-child(even) {
                background-color: #f9f9f9;
            }
            tbody tr:hover {
                background-color: #ecf0f1;
            }
            img {
                /*                display: block;
                                margin: 15px auto;
                                width: 80%;
                                height: auto;*/
            }
            /* styles.css */
            #table-of-contents {
                display: none; /* Mục lục mặc định ẩn đi */
                background-color: #f0f0f0;
                padding: 10px;
                border-radius: 5px;
                list-style: none;
            }

            #table-of-contents li {
                margin-bottom: 5px;
                list-style: none;
            }

            #table-of-contents a {
                text-decoration: none;
                color: #333;
            }

            #table-of-contents a:hover {
                color: #fdbe33;
            }

            #toggle-contents {
                margin-bottom: 10px;
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
                            <h2>Lịch Sử Báo Giá</h2>
                        </div>
                        <div class="col-12">
                            <a href="index">Trang Chủ</a>
                            <a href="">Lịch Sử Báo Giá</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->

            <div class="section-header text-center">
                <h2>Báo giá chi tiết</h2>
            </div>
            <!-- Portfolio Start -->
            
            <!--display quotation-->        
            
            <div class="portfolio">
                
                <div id="quotationContent" class="contact wow fadeInUp container contact-form">
                    
                </div>
                
                <div class="contact wow fadeInUp container contact-form">
                    <form action="LoadQuotationContent" method="post" name="sentMessage" id="formFill" novalidate="novalidate">
                        <input type="hidden" id="packagePrice" name="packagePrice" value="${packagePrice}"/>
                        <input type="hidden" id="foundation" name="foundation" value="${foundation}"/>
                        <input type="hidden" id="roof" name="roof" value="${roof}"/>
                        
                        <c:forEach items="${requestScope.listCustomerHouseComponent}" var="chc" varStatus="loop">
                            <input type="hidden" name="${loop.index + 1}" value="${chc.value}"/>
                        </c:forEach>
                        <input type="hidden" id="service" name="service" value="${selectedService}"/>    
                        <input type="hidden" id="houseType" name="houseType" value="${selectedHouseType}"/> 
                        <input type="hidden" id="style" name="style" value="${selectedStyle}"/>
                        <input type="hidden" id="cusQuoId" name="cusQuoId" value="${cusQuoId}"/>
                    </form>
                </div>
            </div>
            <!-- Portfolio End -->

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
        <jsp:include page="../../PluginChatMess.jsp"/>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                // Kích hoạt sự kiện submit của biểu mẫu khi trang được tải
                $('#formFill').submit(function (event) {
                    event.preventDefault(); // Ngăn chặn hành vi mặc định của form

                    var formData = {}; // Khởi tạo đối tượng chứa dữ liệu biểu mẫu
                    $("#formFill").find("input, select").each(function () {
                        formData[$(this).attr("name")] = $(this).val(); // Thu thập dữ liệu từ các trường input và select
                    });

                    // Gửi dữ liệu đến servlet bằng AJAX
                    $.ajax({
                        url: 'LoadQuotationContentVersionDetail',
                        type: 'get',
                        data: formData,
                        success: function (data) {
                            var quotationContent = document.getElementById("quotationContent");
                            quotationContent.innerHTML = data ;
                        },
                        error: function (xhr) {
                            console.log('Đã xảy ra lỗi khi gửi biểu mẫu.');
                        }
                    });
                });

                // Tự động kích hoạt sự kiện submit của biểu mẫu khi trang được tải
                $('#formFill').trigger('submit');
            });
        </script>
        <script>
            function loadFormQuotation() {
                var formData = {}; // Khởi tạo đối tượng chứa dữ liệu biểu mẫu
                    $("#formFill").find("input").each(function () {
                        formData[$(this).attr("name")] = $(this).val(); // Thu thập dữ liệu từ các trường input và select
                    });
                $.ajax({// Sửa thành $.ajax thay vì $ajax
                    url: "/SWP391/LoadFormChangeQuotationDetail",
                    type: "get",
                    data: formData,
                    success: function (data) {
                        var form = document.getElementById("formFill");
                        form.innerHTML = data;
                    },
                    error: function (xhr) {
                        // Xử lý lỗi nếu cần
                    }
                });
            }
        </script>
        
        <script>
            $(document).ready(function () {
                $('#formFill').submit(function (event) {
                    event.preventDefault();



                    var formData = {};
                    $("#formFill").find("input").each(function () {
                        formData[$(this).attr("name")] = $(this).val();
                    });

                    // Gửi dữ liệu đến servlet bằng AJAX
                    $.ajax({
                        url: '/SWP391/NewVersionQuotationContent',
                        type: 'get',
                        data: formData,
                        success: function (data) {
                            var quotationContent = document.getElementById("formFill");
                            quotationContent.innerHTML += data;
                        },
                        error: function (xhr) {
                            console.log('Đã xảy ra lỗi khi gửi biểu mẫu.');
                        }
                    });
                });
            });
        </script>

    </body>
</html>
