<%-- 
    Document   : blog
    Created on : Feb 2, 2024, 11:39:25 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>TITAN - Blog Page</title>
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
                            <h2>Tin tức</h2>
                        </div>
                        <div class="col-12">
                            <a href="">Trang Chủ</a>
                            <a href="">Tin tức</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->






            <!-- Blog Start -->
            <div class="blog">
                <div class="container">
                    <div class="section-header text-center">
                        <p>Tin tức mới nhất</p>
                        <h2>Tin tức mới nhất từ chúng tôi</h2>
                    </div>


                    <div id="blogList" class="row mt-4">
                        <div class="col-md-6 offset-md-3">
                            <div class="form-group">
                                <label for="blogCategory">Chọn loại tin tức:</label>
                                <select class="form-control" id="blogCategory" name="blogCategory" required>
                                    <option value="" disabled selected>Lựa chọn loại tin tức</option>
                                    <c:forEach var="category" items="${blogCategories}">
                                        <option value="${category.blogCategoryName}">${category.blogCategoryName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>



                    <div class="row blog-page">
                        <c:forEach var="blog" items="${blogs}">
                            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
                                <div class="blog-item">

                                    <div class="blog-img">
                                        <img src="" alt="Image" style="width: 350px; height: 200px;">
                                    </div>
                                    <script>
                                        document.addEventListener("DOMContentLoaded", function () {
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
                                        });
                                    </script>

                                    <div class="blog-title">
                                        <h3><c:out value="${blog.title}" /></h3>
                                        <a class="btn" href="BlogDetail?blogid=${blog.blogID}">+</a>
                                    </div>

                                  <div class="blog-meta">
    <p>Tạo bởi <span style="color: blue;">${blog.user.name}</span></p>
</div>


                                    <div class="blog-text" style="display: none;">
                                        <p>
                                            <c:out value="${blog.content}" />
                                        </p>
                                    </div> 
                                </div>
                            </div>
                        </c:forEach>
                    </div>


                    
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
            $(document).ready(function () {
                $('#blogCategory').change(function () {
                    var selectedCategory = $(this).val();
                    if (selectedCategory) {
                        $.ajax({
                            type: 'POST', // Fix: Change 'Post' to 'POST'
                            url: '${pageContext.request.contextPath}/Blog',
                            data: {category: selectedCategory},
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
                            }
                        });
                    } else {
                        // Clear blog list if no category is selected
                        $('#blogList').empty();
                    }
                });
            });
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
