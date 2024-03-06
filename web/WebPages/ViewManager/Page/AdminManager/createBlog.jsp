<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
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
                    <li class="breadcrumb-item"><a href="">Tạo Blog</a></li>
                </ul>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h1 class="tile-title">Tạo Blog</h1>
                        <div class="tile-body">


                            <div class="form-group col-md-12" style="display: none;">
                                <label class="control-label">Ngày tạo</label>
                                <input class="form-control" type="date" id="date" name="date" readonly="true" required><br>
                            </div>


                            <div class="form-group col-md-12">
                                <label class="control-label">Loại tin tức</label>
                                <select class="form-control" id="blogCategory" name="blogCategory" required>
                                    <option value="" disabled selected>Lựa chọn loại tin tức</option>
                                    <c:forEach var="category" items="${categoryList}">
                                        <option value="${category}">${category}</option>
                                    </c:forEach>
                                </select>
                                <div id="newCategoryInput" style="display: none;">
                                    <label class="control-label">Nhập loại tin tức mới</label>
                                    <input class="form-control" type="text" id="newCategoryValue" name="newCategoryValue">
                                </div>
                            </div>

                            <!-- Your HTML code -->
                            <script>
                                document.getElementById('blogCategory').addEventListener('change', function () {
                                    var selectedValue = this.value;
                                    var newCategoryInput = document.getElementById('newCategoryInput');

                                    if (selectedValue === 'newCategory') {
                                        newCategoryInput.style.display = 'block';

                                        // Add event listener to newCategoryValue input field
                                        document.getElementById('newCategoryValue').addEventListener('blur', confirmCreateNewCategory);
                                    } else {
                                        newCategoryInput.style.display = 'none';
                                    }
                                });

                                function confirmCreateNewCategory() {
                                    var newCategoryValue = document.getElementById('newCategoryValue').value;

                                    Swal.fire({
                                        title: 'Bạn có muốn tạo loại tin tức mới này?',
                                        icon: 'question',
                                        showCancelButton: true,
                                        confirmButtonColor: '#3085d6',
                                        cancelButtonColor: '#d33',
                                        confirmButtonText: 'OK',
                                        cancelButtonText: 'Huỷ bỏ'
                                    }).then((result) => {
                                        if (result.isConfirmed) {
                                            // User clicked OK, send the data to the servlet using AJAX
                                            var xhttp = new XMLHttpRequest();
                                            xhttp.onreadystatechange = function () {
                                                if (this.readyState == 4) {
                                                    if (this.status == 200) {
                                                        // Handle the response from the servlet if needed
                                                        // For example, you can display a success message
                                                        Swal.fire('Tạo loại tin tức mới thành công!', '', 'success');

                                                        // Update the select element with the new category
                                                        var categoryList = JSON.parse(this.responseText);
                                                        updateCategorySelect(categoryList);

                                                        // Hide the newCategoryInput div
                                                        document.getElementById('newCategoryInput').style.display = 'none';

                                                        // Reset the value in the input field
                                                        document.getElementById('newCategoryValue').value = '';
                                                        // Reset the selected option
                                                        document.getElementById('blogCategory').value = '';
                                                    } else {
                                                        // Handle errors if the request was not successful
                                                        Swal.fire('Lỗi khi tạo loại tin tức mới!', '', 'error');
                                                    }
                                                }
                                            };

                                            xhttp.open("POST", "http://localhost:8084/SWP391/CreateBlogCategory", true);
                                            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                                            xhttp.send("blogCategory=" + encodeURIComponent(newCategoryValue));
                                        } else {
                                            // User clicked "Huỷ bỏ," hide the input field
                                            document.getElementById('newCategoryInput').style.display = 'none';
                                            // Reset the value in the input field
                                            document.getElementById('newCategoryValue').value = '';
                                            // Reset the selected option
                                            document.getElementById('blogCategory').value = '';
                                        }
                                    });
                                }


                                function updateCategorySelect(categoryList) {
                                    var selectElement = document.getElementById('blogCategory');

                                    // Clear existing options
                                    selectElement.innerHTML = '';

                                    // Add default option
                                    var defaultOption = document.createElement('option');
                                    defaultOption.value = '';
                                    defaultOption.disabled = true;
                                    defaultOption.selected = true;
                                    defaultOption.textContent = 'Lựa chọn loại tin tức';
                                    selectElement.appendChild(defaultOption);

                                    // Add new category option
                                    var newCategoryOption = document.createElement('option');
                                    newCategoryOption.value = newCategoryValue;
                                    newCategoryOption.textContent = newCategoryValue;
                                    selectElement.appendChild(newCategoryOption);

                                    // Add existing categories from the response
                                    categoryList.forEach(function (category) {
                                        var option = document.createElement('option');
                                        option.value = category;
                                        option.textContent = category;
                                        selectElement.appendChild(option);
                                    });
                                }
                            </script>
                        </div>

                        <div class="form-group col-md-12">
                            <label class="control-label">Tiêu đề</label>
                            <input class="form-control" type="text" id="title" name="title" required><br>
                        </div>

                        <div class="form-group col-md-12">
                            <label class="control-label">Tags</label>
                            <input class="form-control" type="text" id="tags" name="tags" required><br>
                        </div>

                        <script>
                            // Lấy ngày hiện tại
                            var today = new Date();

                            // Định dạng ngày thành yyyy-mm-dd
                            var dd = String(today.getDate()).padStart(2, '0');
                            var mm = String(today.getMonth() + 1).padStart(2, '0'); // Tháng bắt đầu từ 0
                            var yyyy = today.getFullYear();

                            today = yyyy + '-' + mm + '-' + dd;

                            // Đặt giá trị của trường ngày thành ngày hôm nay
                            document.getElementById('date').value = today;
                        </script>
                        <textarea id="mytextarea"></textarea>
                    </div>
                </div>
            </div>
        </div>
        <button class="btn btn-save" onclick="createBlog()">Tạo Blog</button>
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
        function createBlog() {
            var title = encodeURIComponent(document.getElementById("title").value); // Mã hóa tiêu đề
            var tags = encodeURIComponent(document.getElementById("tags").value); // Mã hóa tiêu đề
            var content = encodeURIComponent(tinymce.activeEditor.getContent()); // Mã hóa nội dung
            var date = document.getElementById("date").value;
            var selectedCategory = document.getElementById("blogCategory").value;
            if (selectedCategory === 'newCategory') {
                // If a new category is selected, use the value from the additional input field
                var newCategory = encodeURIComponent(document.getElementById("newCategoryValue").value);
                selectedCategory = newCategory;
            }

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
                                title: "Tạo blog thành công",
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
                                title: "Tạo blog thất bại",
//                text: "Failed to create blog!",
                                icon: "error",
                                button: "OK",
                            });
                        }
                    }
                };

                xhttp.open("POST", "http://localhost:8084/SWP391/CreateBlog", true);
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhttp.send("content=" + content + "&title=" + title + "&tags=" + tags + "&date=" + date + "&category=" + selectedCategory);
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
            }
            );
        <% }%>
    </script>

</body>
</html>
