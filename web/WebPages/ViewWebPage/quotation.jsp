<%-- 
    Document   : quotation
    Created on : Feb 19, 2024, 7:16:24 AM
    Author     : PC
--%>
<%@ page import="java.util.List" %>
<%@ page import="DTO.Quotation" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            /* CSS styles */
            .error {
                color: red;
                font-style: italic;
            }
            .note textarea{
                padding: 10px;
                margin: 10px 0;
            }
            .text-note{
                font-style: italic; 
                opacity: 0.6;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>TITAN - Báo Giá</title>
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
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="../../WebPages/ViewWebPage/HeaderPage.jsp"/>
            <!-- Page Header Start -->
            <div class="page-header">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h2>Báo Giá</h2>
                        </div>
                        <div class="col-12">
                            <a href="index">Trang Chủ</a>
                            <a href="">Báo Giá</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Quotation Start -->
            <div class="contact wow fadeInUp">
                <div class="container">
                    <div class="section-header text-center">
                        <p>Thông Tin Báo Giá</p>
                        <h2>Nhập Thông Tin Để Nhận Báo Giá Sơ Bộ</h2>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="contact-info">
                                <div class="contact-item">
                                    <i class="flaticon-address"></i>
                                    <div class="contact-text">
                                        <h2>Chọn Loại Dịch Vụ</h2>
                                        <select id="serviceSelect">
                                            <c:forEach items="${requestScope.listService}" var="service">
                                                <option value=${service.id}>${service.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="contact-item">
                                    <i class="flaticon-call"></i>
                                    <div class="contact-text">
                                        <h2>Chọn Kiểu Nhà</h2>
                                        <select id="houseTypeSelect">
                                            <c:forEach items="${requestScope.listHouseType}" var="ht">
                                                <option value=${ht.id}>${ht.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="contact-item">
                                    <i class="flaticon-send-mail"></i>
                                    <div class="contact-text">
                                        <h2>Chọn Phong Cách</h2>
                                        <select id="styleSelect">
                                            <c:forEach items="${requestScope.listStyle}" var="style">
                                                <option value=${style.id}>${style.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="contact-form">
                                    <button class="btn" type="submit" style="border: 1px solid white;" onclick="loadFormQuotation()">Nhận Form</button>
                                </div>
                            </div>
                        </div>
                        <!--Raw contruction-->
                        <div class="col-md-6 rawContruction">
                            <div class="contact-form">
                                <form action="LoadQuotationContent" method="post" name="sentMessage" id="formFill">

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Quotation End -->
            <div class="contact wow fadeInUp container">
                <form action="SaveQuotationContent" id="quotationContent" method="post" name="sentMessage" novalidate="novalidate">

                </form>
            </div>
            <jsp:include page="../../WebPages/ViewWebPage/Footer.jsp"/>
            <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>

                                        function loadFormQuotation() {
                                            var selectedHouseType = $("#houseTypeSelect").val();
                                            var selectedService = $("#serviceSelect").val();
                                            var selectedStyle = $("#styleSelect").val();
                                            $.ajax({
                                                url: "/SWP391/LoadFormFill",
                                                type: "get",
                                                data: {houseType: selectedHouseType,
                                                    service: selectedService,
                                                    style: selectedStyle,
                                                },
                                                success: function (data) {
                                                    var form = document.getElementById("formFill");
                                                    form.innerHTML = data;
                                                },
                                                error: function (xhr) {
                                                    console.log('Đã xảy ra lỗi khi gửi biểu mẫu.');
                                                }
                                            });
                                        }





        </script>


        <script>
            $(document).ready(function () {
                $('#formFill').submit(function (event) {
                    let isValid = true;



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



                    const _1 = parseFloat(document.getElementById('1').value);
                    const _2 = parseFloat(document.getElementById('2').value);
                    const _3 = parseFloat(document.getElementById('3').value);
                    const _4 = parseFloat(document.getElementById('4').value);
                    const element5 = document.getElementById('5');
                    if (element5 !== null) {
                        const _5 = parseInt(element5.value);
                        if (_5 > 24 || _5 < 0) {
                            isValid = false;
                            error_5.textContent = 'Số lầu phải nằm trong đoạn từ 0 đến 24.';
                        }
                    }
                    const element6 = document.getElementById('6');
                    if (element6 !== null) {
                        const _6 = parseInt(element6.value);
                        if (!isNaN(_6) && (_6 < 0 || _6 > 2)) {
                            isValid = false;
                            error_6.textContent = 'Chiều dài rộng ban công từ 0-2m.';
                        }
                    }
                    if (_1 > 10000 || _1 <= 0) {
                        isValid = false;
                        error_1.textContent = 'Chiều dài không được nhỏ hơn 1 và lớn hơn 10,000.';
                    }

                    if (_2 > 10000 || _2 <= 0) {
                        isValid = false;
                        error_2.textContent = 'Chiều rộng không được nhỏ hơn 1 và lớn hơn 10,000.';
                    }

                    if (_3 >= _1 || _3 < 0) {
                        isValid = false;
                        error_3.textContent = 'Sân trước phải nhỏ hơn chiều dài tổng thể và lớn hơn hoặc bằng 0.';
                    }
                    if (_4 >= (_1 - _3) || _4 < 0) {
                        isValid = false;
                        error_4.textContent = 'Sân sau phải nhỏ hơn chiều dài còn lại sau khi trừ đi sân trước và lớn hơn hoặc bằng 0.';
                    }
                    var formData = {};
                    $("#formFill").find("input").each(function () {
                        formData[$(this).attr("name")] = $(this).val();
                    });
                    for (var key in formData) {
                        var errorIdcontent = '';
                        if (formData.hasOwnProperty(key)) {
                            var value = formData[key];
                            var intKey = parseInt(key);
                            if (intKey >= 7 && parseInt(value) >= 900) {
                                var errorId = "error_" + key;
                                errorIdcontent = document.getElementById(errorId);
                                errorIdcontent.textContent = "Diện tích không được nhỏ hơn 1 và lớn hơn 900.";
                                isValid = false;
                            }

                        }
                    }

                    if (!isValid) {
                        event.preventDefault();
                    } else {
                        event.preventDefault();
                        var formData = {};
                        $("#formFill").find("input, select, textarea").each(function () {
                            formData[$(this).attr("name")] = $(this).val();
                        });
                        $.ajax({
                            url: 'LoadQuotationContent',
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
                    }
                });
            });
        </script>


        <script>
            document.getElementById("quotationContent").addEventListener("submit", function (event) {
                event.preventDefault();
                var action = event.submitter.value;
                var formData = {};
                $("#quotationContent").find("input").each(function () {
                    formData[$(this).attr("name")] = $(this).val();
                });
                switch (action) {
                    case "saveQuotationContent":
                        $.ajax({
                            url: 'SaveQuotationContent',
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
                    case "saveAndSendRequestQuotation":
                        $.ajax({
                            url: 'SaveQuotationContent',
                            type: 'post',
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
                        console.log("Không xác định hành động");
                }
            });
        </script>






    </body>
</html>
