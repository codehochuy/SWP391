<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/logo.jpg" type="image/x-icon">
        <title>JSP Page</title>
        <style>
            html{
                font-family: Arial !important;
            }
        </style>
    </head>
    <body>
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="Logout"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="img/admin.jpg" width="50px"
                                                alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b></b></p>
                    <p class="app-sidebar__user-designation">Admin</p>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item haha" href="AdminQuotation"><i class='app-menu__icon bx bx-cart-alt'></i>
                        <span class="app-menu__label">Quản lý báo giá</span></a></li>
                <li><a class="app-menu__item " href="ManagerUser"><i class='app-menu__icon bx bx-user-voice'></i><span
                            class="app-menu__label">Quản Lý Khách Hàng</span></a></li>
                <li><a class="app-menu__item " href="ManagerRoof"><i class='app-menu__icon bx bx-tachometer'></i>
                        <span class="app-menu__label">Quản Lý Mái Và Móng</span></a></li>
<!--                <li><a class="app-menu__item " href="ManagerHouseStyle"><i class='app-menu__icon bx bx-home'></i>
                        <span class="app-menu__label">Quản Lý Kiểu Nhà</span></a></li>
                <li><a class="app-menu__item " href="ManagerStyle"><i class='app-menu__icon bx bx-home'></i>
                        <span class="app-menu__label">Quản Lý Phong Cách</span></a></li>-->
                <li><a class="app-menu__item " href="ManagerQuotation"><i class='app-menu__icon bx bx-id-card'></i>
                        <span class="app-menu__label">Giá Thi Công Thô</span></a></li>
                <li><a class="app-menu__item " href="ManagerQuotation2"><i class='app-menu__icon bx bx-id-card'></i>
                        <span class="app-menu__label">Giá Thi Công Trọn Gói</span></a></li>
                <!--                <li><a class="app-menu__item active" href="ManagerProject"><i class='app-menu__icon bx bx-purchase-tag-alt'></i>
                                            <span class="app-menu__label">Quản Lý Người Dùng</span></a>-->
                </li><a class="app-menu__item" href="ManagerProject"><i class='app-menu__icon bx bx-task'></i>
                    <span class="app-menu__label">Dự Án Đã Hoàn Thành</span></a><li>

                <li><a class="app-menu__item" href="ManageMaterial"><i class='app-menu__icon bx bx-run'></i><span
                            class="app-menu__label">Quản Lý Vật Liệu
                        </span></a></li>
  <li><a class="app-menu__item" href="ManagerBlog"><i class='app-menu__icon bx bx-pie-chart-alt-2'></i><span
                            class="app-menu__label">Quản Lý Bài Viết
                        </span></a></li>
<!--
                                    <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-dollar'></i><span
                                                class="app-menu__label">Bảng kê lương</span></a></li>
                                    <li><a class="app-menu__item" href="#"><i
                                                class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
                                    </li>
                                    <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-calendar-check'></i><span
                                                class="app-menu__label">Lịch công tác </span></a></li>
                                    <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-cog'></i><span class="app-menu__label">Cài
                                                đặt hệ thống</span></a></li>-->
            </ul>
        </aside>
    </body>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var currentUrl = window.location.href;

            // Tìm phần tử li có href tương ứng với URL hiện tại và thêm lớp active
            var navItems = document.querySelectorAll(".app-menu__item");
            navItems.forEach(function (item) {
                if (item.href === currentUrl) {
                    item.classList.add("active");
                }
            });
        });
    </script>
</html>
