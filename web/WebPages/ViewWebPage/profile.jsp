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

                            <div class="col-md-12">
                                <h2 class="h3 mb-3 text-black">Hồ sơ của tôi</h2>
                                <div class="p-3 p-lg-5 border display">
                                    <c:choose>
                                        <c:when test="${empty sessionScope.USER.password}">
                                            <img src="${sessionScope.USER.avatar}" style="padding-bottom: 10px" alt="Image" class="img-fluid">
                                        </c:when>
                                        <c:otherwise>
                                            <img src="./img/${sessionScope.USER.avatar}" style="padding-bottom: 10px" alt="Image" class="img-fluid">
                                        </c:otherwise>
                                    </c:choose>
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
                                                                    <c:choose>
                                                                        <c:when test="${empty sessionScope.USER.password}">
                                                                            <img src="${sessionScope.USER.avatar}" class="avatar img-thumbnail" alt="avatar">
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <img src="./img/${sessionScope.USER.avatar}" class="avatar img-thumbnail" alt="avatar">
                                                                            <label class="control-label">Thay ảnh đại diện</label>
                                                                            <input type="file" name="avatar" class="form-control">
                                                                        </c:otherwise>
                                                                    </c:choose>
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
                                                                    <div>
                                                                        <select class="form-select form-select-sm mb-3" id="city" aria-label=".form-select-sm">
                                                                            <option value="" selected>Chọn tỉnh thành</option>           
                                                                        </select>

                                                                        <select class="form-select form-select-sm mb-3" id="district" aria-label=".form-select-sm">
                                                                            <option value="" selected>Chọn quận huyện</option>
                                                                        </select>

                                                                        <select class="form-select form-select-sm" id="ward" aria-label=".form-select-sm">
                                                                            <option value="" selected>Chọn phường xã</option>
                                                                        </select>
                                                                    </div>    

                                                                    <input class="form-control" id="result" name="address" type="text">
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
                                    <c:choose>
                                        <c:when test="${empty sessionScope.USER.password}">
                                            <!--                                            <a href="#" class="d-flex"style="display: none;">Đổi mật khẩu</a>-->
                                        </c:when>
                                        <c:otherwise>
                                            <a href="ChangePassword" class="d-flex">Đổi mật khẩu</a>
                                        </c:otherwise>
                                    </c:choose>
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

        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
        <script>
            var citis = document.getElementById("city");
            var districts = document.getElementById("district");
            var wards = document.getElementById("ward");
            var resultInput = document.getElementById("result");
            var data;

            var Parameter = {
                url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
                method: "GET",
                responseType: "application/json",
            };

            var promise = axios(Parameter);

            promise.then(function (response) {
                data = response.data;
                renderCity(data);
            });

            function renderCity(data) {
                for (const x of data) {
                    citis.options[citis.options.length] = new Option(x.Name, x.Id);
                }

                citis.onchange = function () {
                    if (this.value != "") {
                        resultInput.value = citis.options[citis.selectedIndex].text;
                        districts.length = 1;
                        wards.length = 1;
                        const selectedCity = data.find(city => city.Id === this.value);
                        for (const district of selectedCity.Districts) {
                            districts.options[districts.options.length] = new Option(district.Name, district.Id);
                        }
                    }
                };

                districts.onchange = function () {
                    if (this.value != "") {
                        const selectedCity = data.find(city => city.Id === citis.value);
                        const selectedDistrict = selectedCity.Districts.find(district => district.Id === this.value);
                        resultInput.value = selectedDistrict.Name + ", " + citis.options[citis.selectedIndex].text;
                        wards.length = 1;
                        for (const ward of selectedDistrict.Wards) {
                            wards.options[wards.options.length] = new Option(ward.Name, ward.Id);
                        }
                    }
                };

                wards.onchange = function () {
                    if (this.value != "") {
                        const selectedCity = citis.options[citis.selectedIndex].text;
                        const selectedDistrict = districts.options[districts.selectedIndex].text;
                        const selectedWard = wards.options[wards.selectedIndex].text;
                        resultInput.value = selectedWard + ", " + selectedDistrict + ", " + selectedCity;
                    }
                };
            }
        </script>
    </body>
</html>
