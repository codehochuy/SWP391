

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TITAN - Quản lý báo giá</title>
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css\admin.css">
        <link rel="icon" href="img/logo.jpg" type="image/x-icon">


        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
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

    <body onload="time()" class="app sidebar-mini rtl">
        <jsp:include page="../../Page/Header/headerAdmin.jsp"/>
        <main class="app-content">
            <div class="app-title"> 
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="AdminQuotation"><b>Quản lý báo giá người dùng</b></a></li>
                    <li class="breadcrumb-item active"><a href="AdminQuotation"><b>Yêu cầu báo giá của người dùng</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <!--huycute-->
                        <div class="tile-body">
                            <div class="row element-button">
                                <h2>Báo giá chi tiết</h2>
                            </div>
                            <div class="section-header">                             
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="control-label">Tên khách hàng</label>
                                            <input readonly="" class="form-control" type="text" name="projectname" value="${customer}">
                                            <div class="error-message" id="tensp-error"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="control-label">Số điện thoại</label>
                                            <input readonly="" class="form-control" type="text" name="date" value="${phoneNumber}" max="">
                                            <div class="error-message" id="price-error"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="control-label">Tên báo giá</label>
                                            <input readonly="" class="form-control" type="text" name="date" value="${quotationname}" max="">
                                            <div class="error-message" id="price-error"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="contact wow fadeInUp">
                                    <div class="container">
                                        <div class="row">
                                            <div id="quotationContent" class="col-md-6">
                                            </div>
                                            <!--Raw contruction-->
                                            <div class="col-md-6 rawContruction">
                                                <div class="contact-form">
                                                    <div class="contact wow fadeInUp container contact-form">
                                                        <form action="LoadQuotationContent" method="post" name="sentMessage" id="formFill" novalidate="novalidate">
                                                            <input type="hidden" id="packagePrice" name="packagePrice" value="${packagePrice}"/>
                                                            <input type="hidden" id="foundation" name="foundation" value="${foundation}"/>
                                                            <input type="hidden" id="roof" name="roof" value="${roof}"/>
                                                            <input type="hidden" id="price" name="price" value="${price}"/>    
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


                        </div>
                    </div>
                </div>
            </div>
        </main>



        <!-- Essential javascripts for application to work-->
        <script src="./js/jquery-3.2.1.min.js"></script>
        <script src="./js/popper.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="src/jquery.table2excel.js"></script>
        <script src="./js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="./js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="./js/plugins/dataTables.bootstrap.min.js"></script>


        <script type="text/javascript">
        $('#sampleTable').DataTable();
        //Thời Gian
        function time() {
            var today = new Date();
            var weekday = new Array(7);
            weekday[0] = "Chủ Nhật";
            weekday[1] = "Thứ Hai";
            weekday[2] = "Thứ Ba";
            weekday[3] = "Thứ Tư";
            weekday[4] = "Thứ Năm";
            weekday[5] = "Thứ Sáu";
            weekday[6] = "Thứ Bảy";
            var day = weekday[today.getDay()];
            var dd = today.getDate();
            var mm = today.getMonth() + 1;
            var yyyy = today.getFullYear();
            var h = today.getHours();
            var m = today.getMinutes();
            var s = today.getSeconds();
            m = checkTime(m);
            s = checkTime(s);
            nowTime = h + " giờ " + m + " phút " + s + " giây";
            if (dd < 10) {
                dd = '0' + dd
            }
            if (mm < 10) {
                mm = '0' + mm
            }
            today = day + ', ' + dd + '/' + mm + '/' + yyyy;
            tmp = '<span class="date"> ' + today + ' - ' + nowTime +
                    '</span>';
            document.getElementById("clock").innerHTML = tmp;
            clocktime = setTimeout("time()", "1000", "Javascript");

            function checkTime(i) {
                if (i < 10) {
                    i = "0" + i;
                }
                return i;
            }
        }
        </script>
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
                        url: 'LoadAdminQuotaionDetail',
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
        <script>
            function loadFormChangeQuotationDetail() {
                var formData = {}; // Khởi tạo đối tượng chứa dữ liệu biểu mẫu
                $("#formFill").find("input").each(function () {
                    formData[$(this).attr("name")] = $(this).val(); // Thu thập dữ liệu từ các trường input và select
                });
                $.ajax({// Sửa thành $.ajax thay vì $ajax
                    url: "/SWP391/LoadFormChangeAdminQuotationDetail",
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
            $(document).ready(function () {
                $('#formFill2').submit(function (event) {
                    event.preventDefault();



                    var formData = {};
                    $("#formFill2").find("input, select, textarea").each(function () {
                        formData[$(this).attr("name")] = $(this).val();
                    });

                    // Gửi dữ liệu đến servlet bằng AJAX
                    $.ajax({
                        url: 'LoadQuotationAdminContentVersionDetail2',
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

        <script>
            $(document).ready(function () {
                $('#quotationContent2').submit(function (event) {
                    event.preventDefault();



                    var formData = {};
                    $("#quotationContent2").find("input").each(function () {
                        formData[$(this).attr("name")] = $(this).val();
                    });

                    // Gửi dữ liệu đến servlet bằng AJAX
                    $.ajax({
                        url: '/SWP391/saveadminquotation',
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
        </script>   
        <style>
            .contact {
                position: relative;
                width: 100%;
                padding: 45px 0;

            }

            .contact .col-md-6 {
                padding-top: 30px;
                padding-bottom: 30px;
            }

            .contact .col-md-6:first-child {
                background: rgb(0, 28, 64);
                color: white;
            }

            .contact .col-md-6:last-child {
                background: #fdbe33;
            }

            .contact .contact-info {
                position: relative;
                width: 100%;
                padding: 0 15px;
            }

            .contact .contact-item {
                position: relative;
                margin-bottom: 30px;
                padding: 30px;
                display: flex;
                align-items: flex-start;
                flex-direction: row;
                border: 1px solid rgba(256, 256, 256, .2);
            }

            .contact .contact-item [class^="flaticon-"]::before {
                margin: 0;
                color: #fdbe33;
                font-size: 40px;
            }

            .contact .contact-text {
                position: relative;
                width: auto;
                padding-left: 20px;
            }

            .contact .contact-text h2 {
                color: #fdbe33;
                font-size: 20px;
                font-weight: 600;
            }

            .contact .contact-text p {
                margin: 0;
                color: #ffffff;
                font-size: 16px;
            }

            .contact .contact-item:last-child {
                margin-bottom: 0;
            }

            .contact .contact-form {
                position: relative;
                padding: 0 15px;
            }

            .contact .contact-form input {
                color: #ffffff;
                height: 40px;
                border-radius: 0;
                border-width: 1px;
                border-color: rgba(256, 256, 256, .4);
                background: transparent;
            }

            .contact .contact-form textarea {
                color: #ffffff;
                height: 185px;
                border-radius: 0;
                border-width: 1px;
                border-color: rgba(256, 256, 256, .4);
                background: transparent;
            }

            .contact .contact-form input:focus,
            .contact .contact-form textarea {
                box-shadow: none;
            }

            .contact .contact-form .form-control::placeholder {
                color: #ffffff;
                opacity: 1;
            }

            .contact .contact-form .form-control::-ms-input-placeholder {
                color: #ffffff;
            }

            .contact .contact-form .form-control::-ms-input-placeholder {
                color: #ffffff;
            }

            .contact .contact-form .btn {
                padding: 16px 30px;
                font-size: 16px;
                font-weight: 600;
                color: #fdbe33;
                background: #030f27;
                border: none;
                border-radius: 0;
                transition: .3s;
            }

            .contact .contact-form .btn:hover {
                color: #030f27;
                background: #ffffff;
            }

            .contact .help-block ul {
                margin: 0;
                padding: 0;
                list-style-type: none;
            }

        </style>
    </body>

</html>
