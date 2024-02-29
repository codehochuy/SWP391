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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>TITAN - Báo Giá</title>
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
                            <a href="index.jsp">Trang Chủ</a>
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
                                                <option>${service.name}</option>
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
                                                <option>${ht.name}</option>
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
                                                <option>${style.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <!--Raw contruction-->
                        <div class="col-md-6 rawContruction">
                            <div class="contact-form">
                                <div id="success"></div>
                                <form name="sentMessage" id="contactForm" novalidate="novalidate">
                                    <div class="control-group">
                                        <h5>Chọn gói xây dựng</h5>
                                        <select id="packagePrice">
                                            <option value="1">Gói tiết kiệm</option>
                                            <option value="2">Gói VIP</option>
                                        </select>
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="control-group">
                                        <h5>Chiều dài xây dựng (m)</h5>
                                        <input type="number" class="form-control" name="length" id="length" placeholder="Nhập chiều dài xây dựng"
                                               required="required"
                                               data-validation-required-message="Vui lòng nhập chiều dài xây dựng" />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="control-group">
                                        <h5>Chiều rộng xây dựng (m)</h5>
                                        <input type="number" class="form-control" name="width" id="width" placeholder="Nhập chiều rộng xây dựng"
                                               required="required" data-validation-required-message="Vui lòng nhập chiều rộng xây dựng" />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="control-group">
                                        <h5>Số tầng xây dựng (bao gồm cả tầng trệt)</h5>
                                        <input type="number" class="form-control" name="floor" id="floor" placeholder="Nhập số tầng xây dựng"
                                               required="required" data-validation-required-message="Vui lòng nhập số tầng xây dựng" />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="control-group">
                                        <h5>Kích thước sân trước (m)</h5>
                                        <input type="number" class="form-control" name="FrontYard" id="FrontYard" placeholder="Nhập kích thước sân trước"
                                               required="required" data-validation-required-message="Vui lòng nhập kích thước sân trước" />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="control-group">
                                        <h5>Kích thước sân sau (m)</h5>
                                        <input type="number" class="form-control" name="BackYard" id="BackYard" placeholder="Nhập kích thước sân sau"
                                               required="required" data-validation-required-message="Vui lòng nhập kích thước sân sau" />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="control-group">
                                        <h5>Kích thước ban công (m)</h5>
                                        <input type="number" class="form-control" name="Balcony" id="Balcony" placeholder="Nhập kích thước ban công"
                                               required="required" data-validation-required-message="Vui lòng nhập kích thước ban công" />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div>
                                        <button class="btn" type="submit" id="sendMessageButton">Nhận Báo Giá</button>
                                    </div>
                                </form>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
            <!-- Quotation End -->
            <div class="contact wow fadeInUp">
                <div class="container">
                    <div id="quotationContent" style="display: none;">

                    </div>

                </div>
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


        <!--raw contruction -->
        <script>
            $(document).ready(function () {
                // Biến để lưu trữ giá của quotation phù hợp
                var quotationPrice = 0;

                // Bắt sự kiện khi nút "Nhận báo giá" được click
                $("#sendMessageButton").click(function (event) {
                    // Ngăn chặn hành vi mặc định của form (nếu có)
                    event.preventDefault();
                    // Đặt lại giá trị của các trường nhập liệu

                    // Lấy giá trị đã chọn từ select box
                    var selectedService = $("#serviceSelect").val();
                    var selectedHouseType = $("#houseTypeSelect").val();
                    var selectedStyle = $("#styleSelect").val();
                    var selectedPackagePrice = $("#packagePrice").val();
                    var floor = $("#floor").val();
                    var floorMinus = floor - 1;
                    var length = $("#length").val();
                    var width = $("#width").val();
                    var FrontYard = $("#FrontYard").val();
                    var BackYard = $("#BackYard").val();
                    var Balcony = $("#Balcony").val();

            <c:forEach items="${listQuotation}" var="quotation">
                    var quotationService = "${quotation.service.name}";
                    var quotationHouseType = "${quotation.houseType.name}";
                    var quotationStyle = "${quotation.style.name}";
                    var price1 = parseFloat("${quotation.price1}"); // Sử dụng parseFloat để chuyển đổi sang số thực
                    var price2 = parseFloat("${quotation.price2}");
                    console.log("Quotation Price: " + price1);

                    // Kiểm tra xem các giá trị đã chọn từ dropdown có trùng khớp với các giá trị của đối tượng quotation không
                    if (selectedService === quotationService && selectedHouseType === quotationHouseType && selectedStyle === quotationStyle) {
                        if (length * width >= 200) {
                            quotationPrice = price1;
                        } else {
                            quotationPrice = price2;
                        }
//                        console.log("Quotation Service: " + quotationService);
//                        console.log("Quotation House Type: " + quotationHouseType);
//                        console.log("Quotation Style: " + quotationStyle);
//                        console.log("Quotation Price: " + quotationPrice);
//                        console.log("Quotation Price: " + price1);

                    }
            </c:forEach>







                    // Thay thế nội dung trong câu
                    var quotationText = "<h3>Ước tính chi phí</h3>\n\
        <p><strong>Chi phí " + selectedService + " " + selectedHouseType + " " + selectedStyle + " " + floor + " tầng " + width + "m x " + length + "m:</strong></p>\n\
        <p>Khách hàng có một miếng đất diện tích " + width + "m x " + length + "m, xây dựng 1 trệt, " + floorMinus + " lầu, sân trước chừa " + FrontYard + "m, sân sau chừa " + BackYard + "m, ban công các lầu " + Balcony + "m, thi công móng cọc, mái đổ bê tông giả sử giá " + selectedService + " " + selectedHouseType + " " + selectedStyle + " tại thời điểm hiện tại nếu mặt bằng thi công thuận lợi là " + quotationPrice + "đ/m2 thì cách tính diện và chi phí là:</p>\n\
        <ul>\n\
            <li><strong>Phần cọc</strong>: tùy khu vực phải khảo sát mới có báo giá chính xác.</li>\n\
            <li><strong>Phần móng</strong>: " + (width * length) + "m2 x 50% = " + (width * length * 0.5) + "m2 x " + quotationPrice + "đ/m2 = " + (width * length * 0.5 * quotationPrice) + "đ.</li>\n\
            <li><strong>Tầng trệt</strong>: " + (width * (length - FrontYard - BackYard)) + "m2 x 100% = " + (width * (length - FrontYard - BackYard)) + "m2 x " + quotationPrice + "đ/m2 = " + (width * (length - FrontYard - BackYard) * quotationPrice) + "đ.</li>\n\
            <li><strong>Phần sân trước</strong>: " + (width * FrontYard) + "m2 x 50% = " + (width * FrontYard * 0.5) + "m2 x " + quotationPrice + "đ/m2 = " + (width * FrontYard * 0.5 * quotationPrice) + "đ.</li>\n\
            <li><strong>Phần sân sau</strong>: " + (width * BackYard) + "m2 x 50% = " + (width * BackYard * 0.5) + "m2 x " + quotationPrice + "đ/m2 = " + (width * BackYard * 0.5 * quotationPrice) + "đ.</li>\n\
            <li><strong>Lầu 1</strong>: " + (width * (length - FrontYard - BackYard) + width * Balcony) + "m2 x 100% = " + (width * (length - FrontYard - BackYard) + width * Balcony) + "m2 x " + quotationPrice + "đ/m2 = " + ((width * (length - FrontYard - BackYard) + width * Balcony) * quotationPrice) + "đ. (Tương tự các lầu còn lại)</li>\n\
            <li><strong>Phần mái</strong>: " + (width * (length - FrontYard - BackYard) + width * Balcony) + "m2 x 50% = " + ((width * (length - FrontYard - BackYard) + width * Balcony) * 0.5) + "m2 x " + quotationPrice + "đ/m2 = " + ((width * (length - FrontYard - BackYard) + width * Balcony) * 0.5 * quotationPrice) + "đ.</li>\n\
        </ul>\n\
        <p>Vậy <strong>chi phí ước lượng cho " + selectedService + " " + selectedHouseType + " " + selectedStyle + " " + floor + " tầng (bao gồm cả tầng trệt) " + width + "m x " + length + "m là: " + ((width * length * 0.5 * quotationPrice) + (width * (length - FrontYard - BackYard) * quotationPrice) + (width * FrontYard * 0.5 * quotationPrice) + (width * BackYard * 0.5 * quotationPrice) + (((width * (length - FrontYard - BackYard) + width * Balcony) * quotationPrice) * floorMinus) + ((width * (length - FrontYard - BackYard) + width * Balcony) * 0.5 * quotationPrice)) + " đồng.</p>";

                    // Thay thế nội dung trong div
                    $("#quotationContent").html(quotationText);

                    // Hiển thị nội dung khi nút được click
                    $("#quotationContent").show();
                });
            });

            // Đặt lại giá trị của các trường nhập liệu
            $("#floor").val('');
            $("#length").val('');
            $("#width").val('');
            $("#FrontYard").val('');
            $("#BackYard").val('');
            $("#Balcony").val('');

        </script>
        <!--end raw contruction-->

        <!--select service and house type-->
        <script>
            $(document).ready(function () {
                // Ẩn ban đầu các trường khi trang được tải
                $("#packagePrice").closest(".control-group").hide();

                // Bắt sự kiện khi thay đổi giá trị của kiểu nhà
                $("#houseTypeSelect").change(function () {
                    var selectedHouseType = $(this).val();

                    // Kiểm tra nếu kiểu nhà được chọn là "Nhà cấp 4"
                    if (selectedHouseType === "Nhà cấp 4") {
                        // Ẩn trường "Số tầng xây dựng (bao gồm cả tầng trệt)" và "Kích thước ban công (m)"
                        $("#floor, #Balcony").closest(".control-group").hide();
                    } else {
                        // Hiển thị lại các trường khi không phải là kiểu nhà "Nhà cấp 4"
                        $("#floor, #Balcony").closest(".control-group").show();
                    }
                });

                // Bắt sự kiện khi thay đổi giá trị của dịch vụ
                $("#serviceSelect").change(function () {
                    var selectedService = $(this).val();
                    if (selectedService === "Thi công trọn gói") {
                        $("#packagePrice").closest(".control-group").show();
                    } else {
                        $("#packagePrice").closest(".control-group").hide();
                    }
                });
            });


        </script>
        <!-- END select service and house type-->
    </body>
</html>
