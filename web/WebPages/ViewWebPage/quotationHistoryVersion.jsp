<%-- 
    Document   : Project
    Created on : Jan 24, 2024, 11:54:53 PM
    Author     : ACER
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.text.DecimalFormat" %>
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
                            <a href="index.html">Trang Chủ</a>
                            <a href="Project.jsp">Lịch Sử Báo Giá</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->

            <div class="section-header text-center">
                <h2>Các phiên bản báo giá cho </h2>
                <p>${requestScope.cusQuoName}</p>
            </div>
            <!-- Portfolio Start -->
            <div class="portfolio">
                <div class="container single-content wow fadeInUp">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Phiên bản</th>
                                <th>Ngày</th>
                                <th>Giá</th>
                                <th>Chức năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.listQuotationVersion}" var="qv">
                                <c:choose>
                                    <c:when test="${qv.quotationVersionStatus}">
                                        <tr>
                                            <td>${qv.versionId}</td>
                                            <td>${qv.date}</td>
                                            <td><fmt:formatNumber type="number" value="${qv.price}" pattern="#,###.##" /> VNĐ/m2</td>
                                            <td style="display: flex; justify-content: space-left">
                                                <form action="" method="post">
                                                    <button class="btn btn-primary btn-sm trash" style="margin-right: 5px;" type="button" title="Xóa" onclick="confirmDelete(this)"
                                                            data-versionId="${qv.versionId}"
                                                            data-cusQuoName="${requestScope.cusQuoName}"
                                                            data-cusQuoId="${requestScope.cusQuoId}"
                                                            data-quotationId="${requestScope.quotationId}">
                                                        <i class="fas fa-trash-alt"></i>
                                                    </button>
                                                </form>

                                                <form action="ShowQuotationVersionDetail" method="post">
                                                    <input type="hidden"  name="versionId" value="${qv.versionId}">
                                                    <input type="hidden"  name="cusQuoId" value="${requestScope.cusQuoId}">
                                                    <input type="hidden"  name="quotationId" value="${requestScope.quotationId}">
                                                    <button class="btn btn-primary btn-sm trash" type="submit" title="Xem chi tiết">
                                                        <i class="fas fa-eye"></i>
                                                    </button>
                                                </form>
                                            </td>
                                        </tr> 
                                    </c:when>
                                </c:choose>
                            </c:forEach>

                        </tbody>
                    </table>

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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
                                                        function confirmDelete(button) {
                                                            var versionId = button.getAttribute("data-versionId");
                                                            var cusQuoName = button.getAttribute("data-cusQuoName");
                                                            var cusQuoId = button.getAttribute("data-cusQuoId");
                                                            var quotationId = button.getAttribute("data-quotationId");
                                                            swal({
                                                                title: "Cảnh báo",
                                                                text: "Bạn có muốn xóa báo giá này?",
                                                                buttons: ["Hủy bỏ", "Đồng ý"],
                                                            }).then((willDelete) => {
                                                                if (willDelete) {
                                                                    var form = button.closest("form");
                                                                    form.action = "BanCustomerQuotationVersion?versionId=" + versionId + "&cusQuoName=" + cusQuoName + "&cusQuoId=" + cusQuoId + "&quotationId=" + quotationId;
                                                                    form.submit();
                                                                }

                                                            });
                                                        }
        </script>
    </body>
</html>
