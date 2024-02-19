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
                        <div class="col-md-6">
                            <div class="contact-form">
                                <div id="success"></div>
                                <form name="sentMessage" id="contactForm" novalidate="novalidate">
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
                        <div class="single-content">
                            <h3>Ước tính chi phí</h3>
                            <p><strong>Chi phí xây dựng phần thô nhà phố 3 tầng 4mx18m:</strong></p>
                            <p>Khách hàng có một miếng đất diện tích 4mx18m, xây dựng 1 trệt, 2 lầu, sân trước chừa 3m, ban công các lầu 1,2m, thi công móng cọc, mái đổ bê tông giả sử giá xây nhà phần thô tại thời điểm hiện tại nếu mặt bằng thi công thuận lợi là 3,200,000đ/m2 thì cách tính diện và chi phí là:</p>
                            <ul>
                                <li><strong>Phần cọc</strong>: tùy khu vực phải khảo sát mới có báo giá chính xác.</li>
                                <li><strong>Phần móng</strong>: 72m2 x 50% = 36m2 x 3,200,000đ/m2 = 115,200,000đ.</li>
                                <li><strong>Tầng trệt</strong>: 60m2 x 100% = 60m2 x 3,200,000đ/m2 = 192,000,000đ.</li>
                                <li><strong>Phần sân trước</strong>: 12m2 x 50% = 6m2 x 3,200,000đ/m2 = 19,200,000.</li>
                                <li><strong>Lầu 1</strong>: 64.8m2 x 100% = 64.8m2 x 3,200,000đ/m2 = 207,360,000đ.</li>
                                <li><strong>Lầu 2</strong>: 64.8m2 x 100% = 64.8m2 x 3,200,000đ/m2 = 207,360,000đ.</li>
                                <li><strong>Phần mái</strong>: 64.8m2 x 50% = 32.4m2 x 3,200,000đ/m2 = 103,680,000đ.</li>
                            </ul>
                            <p>Vậy <strong>chi phí ước lượng cho xây nhà phố phần thô nhân công hoàn thiện 3 tầng 4mx18m là: 844,800,000đ</strong> (Tám trăm bốn bốn triệu tám trăm ngàn đồng).</p>
                        </div>
                    </div>

                </div>
            </div>
<!--
            <c:forEach items="${listQuotation}" var="quotation">
                <p>${quotation.service.name}</p>
                <p>${quotation.style.name}</p>
                <p>${quotation.houseType.name}</p>
                <p>${quotation.price1}</p>
                <p>${quotation.price2}</p>

            </c:forEach>
    -->
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
        <!--        <script>
                    $(document).ready(function () {
                        // Bắt sự kiện khi nút "Nhận báo giá" được click
                        $("#sendMessageButton").click(function (event) {
                            // Ngăn chặn hành vi mặc định của form (nếu có)
                            event.preventDefault();
        
                            // Lấy giá trị đã chọn từ select box
                            var selectedService = $("#serviceSelect").val();
                            var selectedHouseType = $("#houseTypeSelect").val();
                            var selectedStyle = $("#styleSelect").val();
                            var floor = $("#floor").val();
                            var length = $("#length").val();
                            var width = $("#width").val();
                            var FrontYard = $("#FrontYard").val();
                            var BackYard = $("#BackYard").val();
                            var Balcony = $("#Balcony").val();
                            
                            // Thay thế nội dung trong câu
                            var quotationText = "<h3>Ước tính chi phí</h3>\n\
                    <p><strong>Chi phí " + selectedService + " " + selectedHouseType + " " + selectedStyle + " " + floor + " tầng " + width + "m x " + length + "m:</strong></p>\n\
                    <p>Khách hàng có một miếng đất diện tích " + width + "m x " + length + "m, xây dựng 1 trệt, " + floor + " lầu, sân trước chừa " + FrontYard + "m, sân sau chừa " + BackYard + "m, ban công các lầu " + Balcony + "m, thi công móng cọc, mái đổ bê tông giả sử giá " + selectedService + " " + selectedHouseType + " " + selectedStyle + " tại thời điểm hiện tại nếu mặt bằng thi công thuận lợi là 3,200,000đ/m2 thì cách tính diện và chi phí là:</p>\n\
        <ul>\n\
                                        <li><strong>Phần cọc</strong>: tùy khu vực phải khảo sát mới có báo giá chính xác.</li>\n\
                                        <li><strong>Phần móng</strong>: 72m2 x 50% = 36m2 x 3,200,000đ/m2 = 115,200,000đ.</li>\n\
                                        <li><strong>Tầng trệt</strong>: 60m2 x 100% = 60m2 x 3,200,000đ/m2 = 192,000,000đ.</li>\n\
                                        <li><strong>Phần sân trước</strong>: 12m2 x 50% = 6m2 x 3,200,000đ/m2 = 19,200,000.</li>\n\
                                        <li><strong>Lầu 1</strong>: 64.8m2 x 100% = 64.8m2 x 3,200,000đ/m2 = 207,360,000đ.</li>\n\
                                        <li><strong>Lầu 2</strong>: 64.8m2 x 100% = 64.8m2 x 3,200,000đ/m2 = 207,360,000đ.</li>\n\
                                        <li><strong>Phần mái</strong>: 64.8m2 x 50% = 32.4m2 x 3,200,000đ/m2 = 103,680,000đ.</li>\n\
                                    </ul>\n\
                                    <p>Vậy <strong>chi phí ước lượng cho " + selectedService + " " + selectedHouseType + " " + selectedStyle + " " + floor + " tầng " + width + "m x " + length + "m là: 844,800,000đ</strong> (Tám trăm bốn bốn triệu tám trăm ngàn đồng).</p>";
        
                            // Thay thế nội dung trong div
                            $("#quotationContent").html(quotationText);
        
                            // Hiển thị nội dung khi nút được click
                            $("#quotationContent").show();
                        });
                    });
                </script>-->
        <!--test-->
        <script>
            $(document).ready(function () {
                // Biến để lưu trữ giá của quotation phù hợp
                var quotationPrice = 0;

                // Bắt sự kiện khi nút "Nhận báo giá" được click
                $("#sendMessageButton").click(function (event) {
                    // Ngăn chặn hành vi mặc định của form (nếu có)
                    event.preventDefault();

                    // Lấy giá trị đã chọn từ select box
                    var selectedService = $("#serviceSelect").val();
                    var selectedHouseType = $("#houseTypeSelect").val();
                    var selectedStyle = $("#styleSelect").val();
                    var floor = $("#floor").val();
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
                        quotationPrice = price1;
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
        <p>Khách hàng có một miếng đất diện tích " + width + "m x " + length + "m, xây dựng 1 trệt, " + floor + " lầu, sân trước chừa " + FrontYard + "m, sân sau chừa " + BackYard + "m, ban công các lầu " + Balcony + "m, thi công móng cọc, mái đổ bê tông giả sử giá " + selectedService + " " + selectedHouseType + " " + selectedStyle + " tại thời điểm hiện tại nếu mặt bằng thi công thuận lợi là " + quotationPrice + "đ/m2 thì cách tính diện và chi phí là:</p>\n\
        <ul>\n\
            <li><strong>Phần cọc</strong>: tùy khu vực phải khảo sát mới có báo giá chính xác.</li>\n\
            <li><strong>Phần móng</strong>: 72m2 x 50% = 36m2 x " + quotationPrice + "đ/m2 = " + (72 * 0.5 * quotationPrice) + "đ.</li>\n\
            <li><strong>Tầng trệt</strong>: 60m2 x 100% = 60m2 x " + quotationPrice + "đ/m2 = " + (60 * quotationPrice) + "đ.</li>\n\
            <li><strong>Phần sân trước</strong>: 12m2 x 50% = 6m2 x " + quotationPrice + "đ/m2 = " + (12 * 0.5 * quotationPrice) + "đ.</li>\n\
            <li><strong>Lầu 1</strong>: 64.8m2 x 100% = 64.8m2 x " + quotationPrice + "đ/m2 = " + (64.8 * quotationPrice) + "đ.</li>\n\
            <li><strong>Lầu 2</strong>: 64.8m2 x 100% = 64.8m2 x " + quotationPrice + "đ/m2 = " + (64.8 * quotationPrice) + "đ.</li>\n\
            <li><strong>Phần mái</strong>: 64.8m2 x 50% = 32.4m2 x " + quotationPrice + "đ/m2 = " + (64.8 * 0.5 * quotationPrice) + "đ.</li>\n\
        </ul>\n\
        <p>Vậy <strong>chi phí ước lượng cho " + selectedService + " " + selectedHouseType + " " + selectedStyle + " " + floor + " tầng " + width + "m x " + length + "m là: " + ((72 * 0.5 * quotationPrice) + (60 * quotationPrice) + (12 * 0.5 * quotationPrice) + (64.8 * quotationPrice) + (64.8 * quotationPrice) + (64.8 * 0.5 * quotationPrice)) + "đ</strong> (" + ((72 * 0.5 * quotationPrice) + (60 * quotationPrice) + (12 * 0.5 * quotationPrice) + (64.8 * quotationPrice) + (64.8 * quotationPrice) + (64.8 * 0.5 * quotationPrice)) + "đồng).</p>";

                    // Thay thế nội dung trong div
                    $("#quotationContent").html(quotationText);

                    // Hiển thị nội dung khi nút được click
                    $("#quotationContent").show();
                });
            });

<!--end test-->

        </script>
    </body>
</html>
