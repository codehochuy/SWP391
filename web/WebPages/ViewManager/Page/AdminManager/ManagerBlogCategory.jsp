

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
        <link rel="icon" href="img/logo.jpg" type="image/x-icon">


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
                    <li class="breadcrumb-item active"><a href="ManagerBlog"><b>Bài viết</b></a></li>
                         <li class="breadcrumb-item active"><a href="ManagerBlog"><b>Danh mục bài viết</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <!--khong phai huycute-->
                        <div class="tile-body">
                            <div class="row element-button">




                                <div class="col-md-12">
                                    <div class="col-sm-2">
                                        <a class="btn btn-add btn-sm" href="#" title="Thêm" onclick="toggleNewCategoryInput()">
                                            <i class="fas fa-plus"></i> Tạo danh mục bài viết
                                        </a>
                                    </div>

                                    <div id="newCategoryInput" style="display: none;">
                                        <label class="control-label">Nhập danh mục bài viết mới</label>
                                        <input class="form-control" type="text" id="newCategoryValue" name="newCategoryValue" placeholder = "Tối thiểu 2 kí tự, tối đa 50, không chấp nhận kí tự đặc biệt" onblur="checkAndConfirm()">
                                    </div>
                                </div>
                                <script>
                                    function toggleNewCategoryInput() {
                                        var newCategoryInput = document.getElementById('newCategoryInput');
                                        newCategoryInput.style.display = (newCategoryInput.style.display === 'none' || newCategoryInput.style.display === '') ? 'block' : 'none';
                                    }

                                    function checkAndConfirm() {
                                        var newCategoryValue = document.getElementById('newCategoryValue').value;

                                    var pattern = /^[0-9a-zA-Z\p{L}][0-9a-zA-Z\p{L}\s]*[0-9a-zA-Z\p{L}]$/u;
                                        if (pattern.test(newCategoryValue) && newCategoryValue.length >= 2 && newCategoryValue.length <= 50) {
                                            swal({
                                                title: "Xác nhận",
                                                text: "Bạn có muốn tạo danh mục bài viết mới này?",
                                                icon: "info",
                                                buttons: ["Hủy bỏ", "Đồng ý"],
                                            }).then((willCreate) => {
                                                if (willCreate) {
                                                    // Add your AJAX code to send the newCategoryValue to the server for creation
                                                    // For example:
                                                    var xhttp = new XMLHttpRequest();
                                                    xhttp.onreadystatechange = function () {
                                                        if (this.readyState == 4) {
                                                            if (this.responseText.trim() === "DUPLICATE") {
                                                                // Handle duplicate category error
                                                                swal({
                                                                    title: "Lỗi",
                                                                    text: "Danh mục bài viết đã tồn tại.",
                                                                    icon: "error",
                                                                    button: "OK",
                                                                });
                                                            } else if (this.responseText.trim() === "SUCCESS") {
                                                                // Handle success
                                                                swal({
                                                                    title: "Tạo danh mục bài viết thành công",
                                                                    icon: "success",
                                                                    button: "OK",
                                                                }).then((value) => {
                                                                    if (value) {
                                                                        window.location.href = 'ManagerBlogCategory';
                                                                    }
                                                                });
                                                            } else {
                                                                // Handle other errors
                                                                swal({
                                                                    title: "Lỗi",
                                                                    text: "Đã xảy ra lỗi khi tạo danh mục bài viết.",
                                                                    icon: "error",
                                                                    button: "OK",
                                                                });
                                                            }
                                                        }
                                                    }

                                                    xhttp.open("POST", "http://localhost:8084/SWP391/CreateBlogCategory", true);
                                                    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                                                    xhttp.send("newCategoryValue=" + encodeURIComponent(newCategoryValue));

                                                    // Hide the input field after successful creation
                                                    toggleNewCategoryInput();
                                                }
                                            });
                                        }
                                    }
                                </script>


                            </div>





                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Danh mục bài viết</th>
                                        <th>Chức năng</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="category" items="${blogCategories}">
                                        <tr>
                                            <td> ${category.blogCategoryID}</td>
                                            <td> ${category.blogCategoryName}</td>
                                            <td style="display: flex; justify-content: space-left">

                                                <form action="DeleteBlogCategory" method="Post">
                                                    <button class="btn btn-primary btn-sm trash" type="button" title="Delete" onclick="confirmDelete(this)"
                                                            data-blogCategoryID="${category.blogCategoryID}">
                                                        <i class="fas fa-trash-alt"></i>
                                                    </button>
                                                </form>

                                                <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" id="show-emp" data-toggle="modal"
                                                        data-target="#ModalUP" onclick="getData('${category.blogCategoryID}')"><i class="fas fa-edit"></i></button>

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


        <div class="modal fade" id="ModalUP" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"
             data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                    <div class="modal-body">
                        <div class="row">
                            <div class="form-group  col-md-12">
                                <span class="thong-tin-thanh-toan">
                                    <h5>Chỉnh sửa tên loại bài viết</h5>
                                </span>
                            </div>
                        </div>
                        <form action="UpdateBlogCategory" method="POST" id="updateblogcate">


                        </form>
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <script>
            function getData(i) {
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath}/loadbyID',
                    data: {
                        id: i
                    },
                    success: function (data, textStatus, jqXHR) {
                        $('#updateblogcate').html(data);
                    }
                })
            }
        </script>

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
                var blogCategoryID = button.getAttribute("data-blogCategoryID");

                swal({
                    title: "Cảnh báo",
                    text: "Bạn có muốn xóa danh mục bài viết này?",
                    buttons: ["Hủy bỏ", "Đồng ý"],
                }).then((willDelete) => {
                    if (willDelete) {
                        var form = button.closest("form");
                        form.action = "DeleteBlogCategory?id=" + blogCategoryID;
                        form.submit();
                    }

                });
            }
        </script>


        <script>
            <% if (request.getAttribute("messtrue") != null) {%>
            swal("<%= request.getAttribute("messtrue")%>", "", "success");
            <% request.removeAttribute("messtrue"); %>
            <% } %>
        </script>
        <script>
            <% if (request.getAttribute("messefalse") != null) {%>
            swal("<%= request.getAttribute("messefalse")%>", "", "error");
            <% request.removeAttribute("messefalse"); %>
            <% }%>
        </script>




    </body>

</html>
