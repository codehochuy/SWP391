<%-- 
    Document   : blog
    Created on : Feb 2, 2024, 11:39:25 AM
    Author     : PC
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <title>TITAN - Project Page</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Construction Company Website Template" name="keywords">
        <meta content="Construction Company Website Template" name="description">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

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
                            <h2>Dự án</h2>
                        </div>
                        <div class="col-12">
                            <a href="">Trang Chủ</a>
                            <a href="">Dự án</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->


            <!-- Blog Start -->
            <div class="blog">
                <div class="container">
                    <div class="section-header text-center">
                        <p>Dự Án Hoàn Thiện</p>
                        <h2>Tham Khảo Các Dự Án Do TITAN Xây Dựng</h2>
                    </div>



                    <div class="row blog-page">
                        <c:forEach var="project" items="${project}">
                            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
                                <div class="blog-item">
                                    <div class="image-gallery">
                                            <a href="img/${project.imageLink}" data-lightbox="project-gallery" >
                                                <img src="img/${project.imageLink}"  class="thumbnail" style="width: 350px; height: 200px;"/>
                                            </a>
                                    </div>  
                                    <div class="blog-title">
                                        <h3><c:out value="${project.name}" /></h3>
                                        <a class="btn" href="ProjectDetail?id=${project.id}">+</a>
                                    </div>
                                       <div class="blog-meta">

                                           <p>Tên dịch vụ: ${project.service.name}</p><br>
                 <p>Kiểu nhà: ${project.houseType.name}</p><br>
                 <p>Phong cách: ${project.style.name}</p><br>
               
                                        </div>

                               
                                </div>
                            </div>
                        </c:forEach>
                    </div>


                    <div class="row" style="margin-left: 800px;">
                        <div class="row">
                            <div class="col-12">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item "><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>

                                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>





                </div>
            </div>



            <!-- Blog End -->


            <jsp:include page="../../WebPages/ViewWebPage/Footer.jsp"/>

            <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        </div>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script>

                                            $(document).ready(function () {
                                                // Set the number of blogs to display per page
                                                var blogsPerPage = 6;

                                                // Get the total number of blogs
                                                var totalBlogs = $(".blog-item").length;

                                                // Calculate the total number of pages
                                                var totalPages = Math.ceil(totalBlogs / blogsPerPage);

                                                // Hide all blogs initially
                                                $(".blog-item").hide();

                                                // Show the first set of blogs (1 to blogsPerPage)
                                                $(".blog-item:lt(" + blogsPerPage + ")").show();

                                                // Handle pagination clicks
                                                $(".page-link").on("click", function (e) {
                                                    e.preventDefault();

                                                    // Get the target page from the link
                                                    var targetPage = parseInt($(this).text());

                                                    // Calculate the range of blogs to display for the target page
                                                    var startIndex = (targetPage - 1) * blogsPerPage;
                                                    var endIndex = startIndex + blogsPerPage;

                                                    // Hide all blogs
                                                    $(".blog-item").hide();

                                                    // Show the blogs in the calculated range
                                                    $(".blog-item").slice(startIndex, endIndex).show();

                                                    // Update active class for pagination links
                                                    $(".page-item").removeClass("active");
                                                    $(this).parent().addClass("active");
                                                });
                                            });

        </script>
        <script>
            function selectCategory(categoryName) {
                document.getElementById("selectedCategory").value = categoryName;

                if (categoryName) {
                    $.ajax({
                        type: 'POST',
                        url: '${pageContext.request.contextPath}/Blog',
                        data: {category: categoryName},
                        success: function (data) {
                            $('#blogList').html(data);

                            // Execute the script directly in the success callback
                            var blogTextElements = document.querySelectorAll('.blog-text');
                            blogTextElements.forEach(function (blogTextElement) {
                                var blogContent = blogTextElement.textContent;

                                var regex = /(data:image\/[^"]+)/g;
                                var matches = blogContent.matchAll(regex);

                                for (var match of matches) {
                                    var imageData = match[1];
                                    var imgElement = blogTextElement.closest('.blog-item').querySelector('.blog-img img');

                                    if (imgElement) {
                                        imgElement.src = imageData;
                                    }
                                }
                            });
                        },
                        error: function (error) {
                            // Handle error
                        }
                    });
                } else {
                    // Clear blog list if no category is selected
                    $('#blogList').empty();
                }
            }
        </script>

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
