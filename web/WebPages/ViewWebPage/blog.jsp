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
        <title>TITAN - Blog Page</title>
        <link rel="icon" href="img/logo.jpg" type="image/x-icon">
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
        <!-- Other blog content -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <style>
            .menu-list {
                list-style: none;
                padding: 0;
                margin: 0;
                display: flex;
                flex-wrap: wrap;  Cho phép các phần tử con xuống dòng khi cần thiết 
            }
            .menu-item {
                flex: 0 0 0; /* Set each item to take up one-third of the container width */
                box-sizing: border-box;
                padding: 10px; /* Add padding to each item */
            }
            .menu-btn {
                background-color: #6c757d;
                color: #fff;
                border: 1px solid #6c757d;
                box-sizing: border-box; /* Ensure padding and border are included in the width */
                padding: 10px 15px;
                cursor: pointer;
                transition: background-color 0.3s ease, color 0.3s ease, border-color 0.3s ease;
                width: auto; /* Set width to auto to fit content */
                margin-bottom: 10px; /* Khoảng cách giữa các dòng */
                display: flex;
                white-space: nowrap; /* Prevent text from wrapping to the next line */
            }
            .menu-btn:hover {
                background-color: #495057;
                border-color: #495057;
                color: #fff;
            }
            .show-all-btn {
                width: 45px; /* Set a fixed width for a square shape */
                height: 45px; /* Set the same height as width for a square shape */
                display: flex;
                margin-left: 10px;
                align-items: center;
                justify-content: center;
                background-color: #6c757d;
                color: #fff;
                border: 1px solid #6c757d;
                box-sizing: border-box;
                padding: 0; /* Remove padding */
                margin-top: 10px; /* Add margin-bottom of 10px */
                cursor: pointer;
                transition: background-color 0.3s ease, color 0.3s ease, border-color 0.3s ease;
            }
            @media (max-width: 768px) {
                .menu-item {
                    flex: 0 0 100%; /* On smaller screens, each item takes the full width */
                }
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
                            <h2>Bài viết</h2>
                        </div>
                        <div class="col-12">
                            <a href="index">Trang Chủ</a>
                            <a href="Blog">Bài viết</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->
            <!-- Blog Start -->
            <div class="blog">
                <div class="container">
                    <div class="section-header text-center">
                        <p>Bài viết mới nhất</p>
                        <h2>Bài viết mới nhất từ chúng tôi</h2>
                    </div>
                    <div class="row" style="margin-left: 660px;">
                        <form action="searchbyTags" method="POST">
                            <label for="tagSearch">Tìm kiếm tag</label>
                            <input type="text" name="tagSearch" value="">
                            <button type="subtmit" >Tìm kiếm</button>
                        </form>
                    </div>
                    <ul id="categories" class="menu-list">
                        <c:forEach var="category" items="${blogCategories}" varStatus="loop">
                            <li class="menu-item ${loop.index > 2 ? 'category-hidden' : ''}">
                                <form action="Blog" method="POST">
                                    <input type="hidden" name="category" value="${category.blogCategoryName}">
                                    <button type="submit" class="menu-btn">
                                        ${category.blogCategoryName}
                                    </button>
                                </form>
                            </li>
                        </c:forEach>
                        <button class="menu-btn show-all-btn" >
                            <i class="fas fa-ellipsis-v fa-sm"></i> <!-- Font Awesome icon for three dots with smaller size -->
                        </button>
                    </ul>
                    <script>
                        document.addEventListener('DOMContentLoaded', function () {
                            var categoryLinks = document.querySelectorAll('.menu-item');
                            var showAllBtn = document.querySelector('.show-all-btn');
                            var isExpanded = false;
                            function hideCategories() {
                                for (var i = 6; i < categoryLinks.length; i++) {
                                    categoryLinks[i].style.display = 'none';
                                }
                            }
                            function showAllCategories() {
                                categoryLinks.forEach(function (link, index) {
                                    link.style.display = 'flex';
                                });
                            }
                            hideCategories();
                            if (showAllBtn) {
                                showAllBtn.addEventListener('click', function () {
                                    if (isExpanded) {
                                        hideCategories();
                                    } else {
                                        showAllCategories();
                                    }
                                    isExpanded = !isExpanded;
                                });
                            }
                        });
                    </script>
                    <div class="row blog-page">
                        <c:forEach var="blog" items="${blogs}">
                            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
                                <div class="blog-item">
                                    <div class="blog-img">
                                        <img src="" alt="" data-src = "" style="width: 350px; height: 200px;">
                                        <div class="hidden-blog-content" style="display: none;">
                                            ${blog.content}
                                        </div>
                                    </div>
                                    <script>
                                        document.addEventListener("DOMContentLoaded", function () {
                                            // Get all elements with the class 'hidden-blog-content'
                                            var hiddenBlogContents = document.querySelectorAll('.hidden-blog-content');
                                            // Regular expression to match img tags and extract src attribute
                                            var imgRegex = /<img[^>]*\ssrc="([^"]*)"[^>]*>/g;
                                            // Regular expression to match URLs starting with "https://"
                                            var fallbackRegex = /"https:\/\/[^'"\s]+/;
                                            // Loop through each hidden-blog-content element
                                            hiddenBlogContents.forEach(function (hiddenBlogContent) {
                                                // Get the content of the hidden-blog-content
                                                var content = hiddenBlogContent.innerHTML;
                                                // Use the imgRegex to find the first image src in the content
                                                var imgMatch = imgRegex.exec(content);
                                                var imageUrl = imgMatch ? imgMatch[1] : '';
                                                // If imgRegex didn't find a match, use the fallbackRegex
                                                if (!imageUrl) {
                                                    var fallbackMatch = fallbackRegex.exec(content);
                                                    imageUrl = fallbackMatch ? fallbackMatch[0].replace('"', '') : '';
                                                }
                                                // Find the corresponding blog-img element in the same parent container
                                                var blogImg = hiddenBlogContent.closest('.blog-item').querySelector('.blog-img img');
                                                // Set the src attribute of the blog-img's img tag with the image URL
                                                if (blogImg) {
                                                    blogImg.src = imageUrl;
                                                }
                                                // Reset the regex lastIndex for the next iteration
                                                imgRegex.lastIndex = 0;
                                                fallbackRegex.lastIndex = 0;
                                            });
                                        });
                                    </script>
                                    <div class="blog-title">
                                        <h3><c:out value="${blog.title}" /></h3>
                                        <a class="btn" href="BlogDetail?blogid=${blog.blogID}">+</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="row" style="margin-left: 800px;">
                        <div class="row">
                            <div class="col-12">
                                <ul class="pagination justify-content-center" id="pagination">
                                    <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                                        <c:forEach var="page" begin="1" end="${(blogSize + 5) / 6}" step="1">
                                        <li class="page-item ${page == 1 ? 'active' : ''}">
                                            <a class="page-link" href="#" onclick="showBlogs(${page})">${page}</a>
                                        </li>
                                    </c:forEach>
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
                                                        // Store the selected page in a data attribute
                                                        $("#pagination").data("selectedPage", targetPage);
                                                    });
                                                    // Handle Next button click
                                                    $("#nextPage").on("click", function (e) {
                                                        e.preventDefault();
                                                        var activePage = $(".page-item.active .page-link").text();
                                                        activePage = parseInt(activePage);
                                                        if (activePage < totalPages) {
                                                            $(".page-link:contains('" + (activePage + 1) + "')").trigger("click");
                                                        }
                                                    });
                                                    // Handle Previous button click
                                                    $("#previousPage").on("click", function (e) {
                                                        e.preventDefault();
                                                        var activePage = $(".page-item.active .page-link").text();
                                                        activePage = parseInt(activePage);
                                                        if (activePage > 1) {
                                                            $(".page-link:contains('" + (activePage - 1) + "')").trigger("click");
                                                        }
                                                    });
                                                    // Restore the selected page if it was saved
                                                    var selectedPage = $("#pagination").data("selectedPage");
                                                    if (selectedPage) {
                                                        $(".page-link:contains('" + selectedPage + "')").trigger("click");
                                                    }
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
