
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="https://cdn.tiny.cloud/1/n0rfd22a3z32jtupppuha019duk0huf5saykqwysdh0xkz3s/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
        <script>
            tinymce.init({
                selector: '#mytextarea'
            });
        </script>
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

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/css/lightbox.min.css">
        <!-- Lightbox JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/js/lightbox.min.js"></script>

    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <jsp:include page="../../Page/Header/headerAdmin.jsp"/>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item"><a href="ManagerBlog">Quản lý Blog</a></li>
                    <li class="breadcrumb-item"><a href=""> Xem chi tiết Blog</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h1 class="tile-title">Chỉnh sửa bài viết</h1>
                        <div class="tile-body">

                            <div id="blogDetail">
                                <%-- Hiển thị dữ liệu --%>
                                <c:set var="blog" value="${blog}" />

                                <!-- Thêm một trường ẩn để lưu ID của bài viết -->

                                <div class="form-group col-md-12">
                                    <label class="control-label">ID bài viết</label>
                                    <input class="form-control" type="text" id="blogId" name="blogId" readonly="true" required value="<c:out value='${blog.blogID}' />"><br>
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Ngày tạo</label>
                                    <input class="form-control" type="date" id="date" name="date" readonly="true" required value="<c:out value='${blog.dateCreate}' />"><br>
                                </div>

                                <div class="form-group col-md-12">
                                    <label class="control-label">Ngày sửa đổi</label>
                                    <input class="form-control" type="date" id="dateModified" name="date" readonly="true" required value=""><br>
                                </div>
                                <script>
                                    function setCurrentDate() {
                                        // Get the current date
                                        var currentDate = new Date();

                                        // Format the date as "YYYY-MM-DD" (required by the input type="date")
                                        var formattedDate = currentDate.toISOString().split('T')[0];

                                        // Set the formatted date to the input field
                                        document.getElementById("dateModified").value = formattedDate;
                                    }

                                    // Call the function to set the current date on page load
                                    setCurrentDate();
                                </script>




                                <div class="form-group col-md-12">
                                    <label class="control-label">Loại tin tức</label>
                                    <select class="form-control" id="categorySelect">
                                        <option value="" disabled selected>Lựa chọn loại tin tức</option>
                                        <c:forEach var="category" items="${categoryList}">
                                            <option value="${category}" <c:if test="${category eq blog.blogCategory.blogCategoryName}">selected</c:if>>${category}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group col-md-12">
                                    <label class="control-label">Tiêu đề</label>
                                    <input class="form-control" type="text" id="title" value="<c:out value='${blog.title}' />">
                                </div>

                                <div class="form-group col-md-12">
                                    <label class="control-label">Tags</label>
                                    <input class="form-control" type="text" id="tags" value="<c:out value='${blog.tags}' />">
                                </div>






                                <!-- Textarea for TinyMCE -->
                                <%-- <textarea id="mytextarea"><c:out value="${blog.content}" /></textarea>--%>
                                <textarea id="mytextarea">${blog.content}</textarea>

                                <!-- Button to update the blog post -->


                            </div>
                        </div>

                    </div>

                </div>
            </div>
            <button class="btn btn-save" onclick="updateBlog()">Cập nhật bài viết</button>
            <a class="btn btn-cancel" href="ManagerBlog">Hủy bỏ</a>
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
            function updateBlog() {
                var blogId = document.getElementById("blogId").value; // Lấy ID của bài viết
                var title = encodeURIComponent(document.getElementById("title").value); // Mã hóa tiêu đề
                var tags = encodeURIComponent(document.getElementById("tags").value); // Mã hóa tags
                var content = encodeURIComponent(tinymce.activeEditor.getContent());
                var categorySelect = document.getElementById("categorySelect");
                var selectedCategory = categorySelect.options[categorySelect.selectedIndex].value;
                var dateModified = document.getElementById("dateModified").value;

//check validate
                var decodedTitle = decodeURIComponent(title);
                var decodedTags = decodeURIComponent(tags);
                var decodedContent = decodeURIComponent(content);

                if (!title.trim() || !tags.trim() || !content.trim() || !selectedCategory.trim()) {
                    swal({
                        title: "Vui lòng điền đầy đủ thông tin",
                        icon: "error",
                        button: "OK",
                    });
                    return;
                }
                if (decodedTitle.length < 30 || !/^[0-9a-zA-Z][a-zA-Z0-9',: \p{L}]+$/u.test(decodedTitle) ) {
                    swal({
                        title: "Tiêu đề cần ít nhất 30 kí tự (0-9 a-z A-Z ',: )",
                        icon: "error",
                        button: "OK",
                    });
                    return;
                }


                if (!/^[a-zA-Z0-9 \p{L}]{2,}$/u.test(decodedTags)) {
                    swal({
                        title: "Tags chứa ít nhất 2 kí tự (0-9 a-z A-Z, dấu cách, tiếng việt có dấu)",
                        icon: "error",
                        button: "OK",
                    });
                    return;
                }
                if (!/^[\s\S]*(<img [^>]+>)[\s\S]{300,}$/u.test(decodedContent) && /\p{L}/u.test(decodedContent)) {
                    swal({
                        title: "Nội dung chứa ít nhất 300 kí tự và hình ảnh",
                        icon: "error",
                        button: "OK",
                    });
                    return;
                }


                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4) {
                        if (this.status == 200) {
                            // Sử dụng SweetAlert để hiển thị thông báo
                            swal({
                                title: "Cập nhật blog thành công",
//                text: "Blog created successfully!",
                                icon: "success",
                                button: "OK",
                            }).then((value) => {
                                // Tải lại trang sau khi người dùng nhấp vào nút OK
                                if (value) {
                                    window.location.reload();
                                }
                            });
                        } else {
                            // Xử lý trường hợp lỗi
                            swal({
                                title: "Cập nhật blog thất bại",
//                text: "Failed to create blog!",
                                icon: "error",
                                button: "OK",
                            });
                        }
                    }
                };

                xhttp.open("POST", "http://localhost:8084/SWP391/UpdateBlog", true);
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhttp.send("blogId=" + blogId + "&title=" + title + "&tags=" + tags + "&content=" + content + "&category=" + selectedCategory + "&dateModified=" + dateModified);
            }
        </script>

    </body>
</html>
