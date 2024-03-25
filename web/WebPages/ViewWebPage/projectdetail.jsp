<%-- 
    Document   : blog
    Created on : Feb 2, 2024, 11:39:25 AM
    Author     : PC
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>TITAN - Chi tiết dự án</title>
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
            .blog-content img {
                max-width: 970px;
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
                            <h2>Dự án</h2>
                        </div>
                        <div class="col-12">
                            <a href="">Trang Chủ</a>
                            <a href="">Dự án</a>
                        </div>
                    </div>
                </div>
            </div>
            <div style="margin-left: 200px; margin-right: 200px;">
                <div>
                    <div style="text-align: center;">
                        <h2><strong>Tên dự án: ${project.name}</strong></h2>
                    </div>
                    <p>Ngày hoàn thành: ${project.date}</p>
                    <p>Thời gian hoàn thành/ngày: ${project.time}</p>
                    <p>Tên dịch vụ: ${project.service.name}</p>
                    <p>Kiểu nhà: ${project.houseType.name}</p>
                    <p>Phong cách: ${project.style.name}</p>
                    <p>Miêu tả: ${project.description}</p>
                    <p>Ảnh dự án</p>
                    <div class="image-gallery">
                        <c:forEach var="image" items="${images}">
                            <a href="img/${image.link}" data-lightbox="project-gallery" data-title="${image.caption}">
                                <img src="img/${image.link}" alt="${image.caption}" class="thumbnail" />
                            </a>
                        </c:forEach>
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
    </body>
</html>
