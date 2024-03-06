

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css\admin.css">


        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <jsp:include page="../../Page/Header/headerAdmin.jsp"/>
        <main class="app-content">
            <div class="app-title"> 
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Quản lý Blog</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <!--khong phai huycute-->
                        <div class="tile-body">
                            <div class="row element-button">

                                <div class="col-sm-2">
                                    <a class="btn btn-add btn-sm" href="CreateBlog" title="Thêm">
                                        <i class="fas fa-plus"></i> Tạo Blog
                                    </a>
                                </div>
                                
                                   <div class="col-sm-2">
                                    <a class="btn btn-add btn-sm" href="ManagerBlogCategory" title="Các loại tin tức">
                                        <i class="fas fa-plus"></i> Quản lý các loại tin tức
                                    </a>
                                </div>
                                 



                            </div>
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>ID bài viết</th>
                                        <th>Tiêu đề</th>
                                        <th>Ngày tạo</th>
                                        <th>Ngày sửa đổi</th>
                                        <th>Loại tin tức</th>
                                        <th>Tags</th>
                                        <th>Người tạo</th>
                                        <th>Chức năng</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="blog" items="${blogs}">
                                        <tr>
                                            <td>${blog.blogID}</td>
                                            <td>${blog.title}</td>
                                            <td>${blog.dateCreate}</td>
                                            <td>${blog.dateModified}</td>
                                          
                                              <td>${blog.blogCategory.blogCategoryName}</td>
                                              <td>${blog.tags}</td>
                                                <td>${blog.user.name}</td>
                                            <td style="display: flex; justify-content: space-left">

                                                <form action="DeleteBlog" method="Post">
                                                    <button class="btn btn-primary btn-sm trash" type="button" title="Delete" onclick="confirmDelete(this)"
                                                            data-blogID="${blog.blogID}">
                                                        <i class="fas fa-trash-alt"></i>
                                                    </button>
                                                </form>
                                                <form action="ViewBlogDetail" method="post">
                                                    <input type="hidden" name="blogid" value="${blog.blogID}">
                                                    <button class="btn btn-primary btn-sm trash" type="submit" title="Xem chi tiết">
                                                        <i class="fas fa-eye"></i>
                                                    </button>
                                                </form>

                                            </td>


                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

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
            function confirmDelete(button) {
                var blogid = button.getAttribute("data-blogID");

                swal({
                    title: "Cảnh báo",
                    text: "Bạn có muốn xóa blog này?",
                    buttons: ["Hủy bỏ", "Đồng ý"],
                }).then((willDelete) => {
                    if (willDelete) {
                        var form = button.closest("form");
                        form.action = "DeleteBlog?id=" + blogid;
                        form.submit();
                    }

                });
            }
        </script>


      <script>
    <% if (request.getAttribute("messtrue") != null) {%>
        swal({
            title: "<%= request.getAttribute("messtrue")%>",
            icon: "success",
        }).then((value) => {
            <% request.removeAttribute("messtrue"); %>
        });
    <% } %>
</script>
      <script>
    <% if (request.getAttribute("messefalse") != null) {%>
        swal({
            title: "<%= request.getAttribute("messefalse")%>",
            icon: "error",
        }).then((value) => {
            <% request.removeAttribute("messefalse"); %>
        });
    <% } %>
</script>

    </body>

</html>
