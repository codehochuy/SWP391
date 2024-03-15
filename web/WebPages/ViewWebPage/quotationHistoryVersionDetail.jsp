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
            .note textarea{
                padding: 10px;
                margin: 10px 0;

            }
            .text-note {
                font-style: italic; 
                opacity: 0.6;
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

            <div class="section-header">

                <div class="section-header text-center">
                    <h2>Báo giá chi tiết</h2>
                </div>
                <div class="contact wow">
                    <div class="container">
                        <div class="row">
                            <form id="quotationContent" class="col-md-6">

                            </form>
                            <!--Raw contruction-->
                            <div class="col-md-6 rawContruction">
                                <div class="contact-form">
                                    <div class="contact wow fadeInUp container contact-form">
                                        <form action="LoadQuotationContent" method="post" name="sentMessage" id="formFill" novalidate="novalidate">
                                            <input type="hidden" id="packagePrice" name="packagePrice" value="${packagePrice}"/>
                                            <input type="hidden" id="foundation" name="foundation" value="${foundation}"/>
                                            <input type="hidden" id="roof" name="roof" value="${roof}"/>

                                            <c:forEach items="${requestScope.listCustomerHouseComponent}" var="chc" varStatus="loop">
                                                <input type="hidden" name="${chc.componentId}" value="${chc.value}"/>
                                            </c:forEach>
                                            <input type="hidden" id="versionId" name="versionId" value="${versionId}"/>     
                                            <input type="hidden" id="service" name="service" value="${selectedService}"/>    
                                            <input type="hidden" id="houseType" name="houseType" value="${selectedHouseType}"/> 
                                            <input type="hidden" id="style" name="style" value="${selectedStyle}"/>
                                            <input type="hidden" id="cusQuoId" name="cusQuoId" value="${cusQuoId}"/>
                                            <input type="hidden" id="note" name="note" value="${note}"/>
                                        </form>
                                        <form action="LoadQuotationContent" method="post" name="sentMessage" id="formFill2" novalidate="novalidate">

                                        </form>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
            <div class="contact wow fadeInUp container">
                <form action="SaveQuotationContent" id="quotationContent2" method="post" name="sentMessage" novalidate="novalidate">

                </form>
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
        <jsp:include page="../../PluginChatMess.jsp"/>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <!--1-->
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
                            quotationContent.innerHTML = data;
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
        <!--2-->
        <script>
            function loadFormChangeQuotationDetail() {
                var formData = {}; // Khởi tạo đối tượng chứa dữ liệu biểu mẫu
                $("#formFill").find("input").each(function () {
                    formData[$(this).attr("name")] = $(this).val(); // Thu thập dữ liệu từ các trường input và select
                });
                $.ajax({// Sửa thành $.ajax thay vì $ajax
                    url: "/SWP391/LoadFormChangeQuotationDetail",
                    type: "get",
                    data: formData,
                    success: function (data) {
                        var formFill = document.getElementById("formFill2");
                        formFill.innerHTML = data;
                    },
                    error: function (xhr) {
                        // Xử lý lỗi nếu cần
                    }
                });
            }
        </script>

        <script>
            document.getElementById("quotationContent").addEventListener("submit", function (event) {
                event.preventDefault(); // Ngăn chặn việc gửi form mặc định

                // Lấy ra giá trị của nút được nhấn
                var action = event.submitter.value;
                var formData = {}; // Khởi tạo đối tượng chứa dữ liệu biểu mẫu
                $("#formFill").find("input").each(function () {
                    formData[$(this).attr("name")] = $(this).val(); // Thu thập dữ liệu từ các trường input và select
                });

                // Xác định hành động dựa trên giá trị của nút được nhấn
                switch (action) {
                    case "changeQuotationContent":
                        // Xử lý chức năng 1
                        $.ajax({// Sửa thành $.ajax thay vì $ajax
                            url: "/SWP391/LoadFormChangeQuotationDetail",
                            type: "get",
                            data: formData,
                            success: function (data) {
                                var formFill = document.getElementById("formFill2");
                                formFill.innerHTML = data;
                            },
                            error: function (xhr) {
                                // Xử lý lỗi nếu cần
                            }
                        });
                        break;
                    case "sendRequestQuotation":
                        $.ajax({
                            url: 'SendRequestQuotation',
                            type: 'get',
                            data: formData,
                            success: function (data) {
                                var quotationContent = document.getElementById("quotationContent");
                                quotationContent.innerHTML += data;
                            },
                            error: function (xhr) {
                                console.log('Đã xảy ra lỗi khi gửi biểu mẫu.');
                            }
                        });
                        break;
                    default:
                        // Xử lý mặc định nếu cần
                        console.log("Không xác định hành động");
                }
            });
        </script>

        <!--3-->
        <script>
            $(document).ready(function () {
                $('#formFill2').submit(function (event) {
                    event.preventDefault();



                    var formData = {};
                    $("#formFill2").find("input, select, textarea").each(function () {
                        formData[$(this).attr("name")] = $(this).val();
                    });

                    // Gửi dữ liệu đến servlet bằng AJAX
                    $.ajax({
                        url: 'LoadQuotationContentVersionDetail2',
                        type: 'get',
                        data: formData,
                        success: function (data) {
                            var quotationContent = document.getElementById("quotationContent2");
                            quotationContent.innerHTML = data;
                        },
                        error: function (xhr) {
                            console.log('Đã xảy ra lỗi khi gửi biểu mẫu.');
                        }
                    });
                });
            });
        </script>

<!--        <script>
            $(document).ready(function () {
                $('#quotationContent2').submit(function (event) {
                    event.preventDefault();



                    var formData = {};
                    $("#quotationContent2").find("input").each(function () {
                        formData[$(this).attr("name")] = $(this).val();
                    });

                    // Gửi dữ liệu đến servlet bằng AJAX
                    $.ajax({
                        url: '/SWP391/NewVersionQuotationContent',
                        type: 'get',
                        data: formData,
                        success: function (data) {
                            var quotationContent = document.getElementById("quotationContent2");
                            quotationContent.innerHTML += data;
                        },
                        error: function (xhr) {
                            console.log('Đã xảy ra lỗi khi gửi biểu mẫu.');
                        }
                    });
                });
            });
        </script>-->

        <script>
            document.getElementById("quotationContent2").addEventListener("submit", function (event) {
                event.preventDefault(); // Ngăn chặn việc gửi form mặc định

                // Lấy ra giá trị của nút được nhấn
                var action = event.submitter.value;

                var formData = {};
                $("#quotationContent2").find("input").each(function () {
                    formData[$(this).attr("name")] = $(this).val();
                });

                // Xác định hành động dựa trên giá trị của nút được nhấn
                switch (action) {
                    case "saveQuotationContent":
                        // Xử lý chức năng 1
                        $.ajax({
                            url: '/SWP391/NewVersionQuotationContent',
                            type: 'get',
                            data: formData,
                            success: function (data) {
                                var quotationContent = document.getElementById("quotationContent2");
                                quotationContent.innerHTML += data;
                            },
                            error: function (xhr) {
                                console.log('Đã xảy ra lỗi khi gửi biểu mẫu.');
                            }
                        });
                        break;
                    case "saveAndSendRequestQuotation":
                        $.ajax({
                            url: 'NewVersionQuotationContent',
                            type: 'post',
                            data: formData,
                            success: function (data) {
                                var quotationContent = document.getElementById("quotationContent2");
                                quotationContent.innerHTML += data;
                            },
                            error: function (xhr) {
                                console.log('Đã xảy ra lỗi khi gửi biểu mẫu.');
                            }
                        });
                        break;
                    default:
                        // Xử lý mặc định nếu cần
                        console.log("Không xác định hành động");
                }
            });
        </script>

        <script>
            // JavaScript code for form validation
            const form = document.getElementById('formFill2');

            form.addEventListener('click', function (event) {
                let i = 0;
                let isValid = true;

                const _1 = document.getElementById('1');
                const _2 = document.getElementById('2');
                const _3 = document.getElementById('3');
                const _4 = document.getElementById('4');
                const _5 = document.getElementById('5');
                const _6 = document.getElementById('6');

                const error_1 = document.getElementById('error_1');
                const error_2 = document.getElementById('error_2');
                const error_3 = document.getElementById('error_3');
                const error_4 = document.getElementById('error_4');
                const error_5 = document.getElementById('error_5');
                const error_6 = document.getElementById('error_6');

                // Reset error messages
                error_1.textContent = '';
                error_2.textContent = '';
                error_3.textContent = '';
                error_4.textContent = '';
                if (error_5)
                    error_5.textContent = '';
                if (error_6)
                    error_6.textContent = '';

//           

                if (parseDouble(_1.value) > 10000 || parseDouble(_1.value) <= 0) {
                    isValid = false;
                    error_1.textContent = 'Chiều dài không được nhỏ hơn 1 và lớn hơn 10,000.';
                }

                if (parseDouble(_2.value) > 10000 || parseDouble(_2.value) <= 0) {
                    isValid = false;
                    error_2.textContent = 'Chiều rộng không được nhỏ hơn 1 và lớn hơn 10,000.';
                }

                if ((parseDouble(_3.value) >= parseDouble(_1.value)) || parseDouble(_3.value) < 0) {
                    isValid = false;
                    error_3.textContent = 'Sân trước phải nhỏ hơn chiều dài tổng thể và lớn hơn hoặc bằng 0.';
                }
                if ((parseDouble(_4.value) >= (parseDouble(_1.value) - parseDouble(_3.value))) || parseDouble(_4.value) < 0) {
                    isValid = false;
                    error_4.textContent = 'Sân sau phải nhỏ hơn chiều dài còn lại sau khi trừ đi sân trước và lớn hơn hoặc bằng 0.';
                }

                if (_5.value !== '') {
                    if (parseDouble(_5.value) > 24 || parseDouble(_5.value) < 0) {
                        isValid = false;
                        error_5.textContent = 'Số lầu phải nằm trong đoạn từ 0 đến 24.';
                    }
                }

                if (_6.value !== '') {
                    if (parseDouble(_6.value) < 0 || parseDouble(_6.value) > 2) {
                        isValid = false;
                        error_6.textContent = 'Chiều dài rộng ban công từ 0-2m.';
                    }
                }

                if (!isValid) {
                    event.preventDefault();
                }
            });
        </script>
    </body>
</html>
