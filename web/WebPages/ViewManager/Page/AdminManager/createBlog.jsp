<!DOCTYPE html>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


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

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/css/lightbox.min.css">
        <!-- Lightbox JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/js/lightbox.min.js"></script>


    </head>
    <body onload="time()" class="app sidebar-mini rtl">
        <jsp:include page="../../Page/Header/headerAdmin.jsp"/>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item"><a href="ManagerProject">Quản lý Blog</a></li>
                    <li class="breadcrumb-item"><a href="">Create Blog</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h1 class="tile-title">Create Blog</h1>
                        <div class="tile-body">


                            <div class="form-group col-md-12" style="display: none;">
                                <label class="control-label">blogID</label>
                                <input class="form-control" type="text" id="blogID" value ="1"  readonly="true" required ><br>

                            </div>


                            <div class="form-group col-md-12">
                                <label class="control-label">Main Title</label>
                                <input class="form-control" type="text" id="title" name="title" required >

                            </div>

                            <div class="form-group col-md-12">
                                <label class="control-label">Date</label>
                                <input class="form-control" type="date" id="date" name="date" readonly="true" required><br>

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

                            <div class="form-group col-md-12" style="display: none;">
                                <label class="control-label">User ID</label>
                                <input class="form-control" type="text" id="userID" name="userID" value="<%= request.getAttribute("USERID")%>" required><br>
                            </div>




                            <div id="blogDetail">
                                <a class="btn btn-add btn-sm"  title="Add Detail" onclick="addBlogDetail()">
                                    <i class="fas fa-plus"></i> Add Detail
                                </a>

                            </div><br>
                            <input class="btn btn-save" type="button" value="Create Blog" onclick="createBlog()">

                            <a class="btn btn-cancel" href="ManagerBlog">Hủy bỏ</a>
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
            // Khai báo biến toàn cục để lưu trữ giá trị BlogDetailID
            var blogDetailID_parent = 0;
            var blogImageID_child = 0;

            function addBlogDetail() {
                var detailDiv = document.getElementById("blogDetail");
                var div = document.createElement("div");

                var inputElements = detailDiv.querySelectorAll('input[name="blog_detail_id_parent[]"]');
                var numberOfInputs = inputElements.length;

                // Tăng giá trị của blogDetailID_parent bằng số lượng input hiện có
                blogDetailID_parent = numberOfInputs;

                // Tạo phần tử input cho BlogDetailID và tăng giá trị
                var inputBlogDetailID = document.createElement("input");
                inputBlogDetailID.type = "text";
                inputBlogDetailID.type = "hidden";
                inputBlogDetailID.name = "blog_detail_id_parent[]";
                inputBlogDetailID.value = ++blogDetailID_parent;
                inputBlogDetailID.readOnly = true; // Ngăn người dùng chỉnh sửa giá trị
                div.appendChild(inputBlogDetailID);

                var inputTitle = document.createElement("input");
                inputTitle.type = "text";
                inputTitle.name = "title_detail[]";
                inputTitle.className = "form-control col-md-12"; // Thêm class cho inputBlogDetailID
                inputTitle.placeholder = "Title";
                div.appendChild(inputTitle);

                var textareaContent = document.createElement("textarea");
                textareaContent.type = "text";
                textareaContent.name = "content_detail[]";
                textareaContent.className = "form-control col-md-12"; // Thêm class cho inputBlogDetailID
                textareaContent.placeholder = "Content";
                div.appendChild(textareaContent);


                var inputBlogID = document.createElement("input"); // Khung chứa BlogID
                inputBlogID.type = "text";
                inputBlogID.type = "hidden";
                inputBlogID.name = "blog_id[]";
                inputBlogID.value = "1"; // Giá trị cố định là "1"
                inputBlogID.readOnly = true; // Ngăn người dùng chỉnh sửa giá trị
                div.appendChild(inputBlogID);


                var addButton = document.createElement("button");
                addButton.type = "button";
                addButton.innerHTML = '<i class="fas fa-file-upload"></i> Add Image'; // Đặt nội dung HTML của button
                addButton.className = "btn btn-delete btn-sm nhap-tu-file"; // Đặt lớp CSS của button   
                addButton.onclick = function () {
                    addBlogImage(div);
                };
                div.appendChild(addButton);

                var deleteButton = document.createElement("button"); // Nút xóa chi tiết
                deleteButton.type = "button";
                deleteButton.innerText = "Delete Detail";
//                    deleteButton.className = "btn btn-cancel"; // Đặt lớp CSS của button   
                deleteButton.onclick = function () {
                    detailDiv.removeChild(div); // Xóa chi tiết khi nút được nhấn
                    reorderBlogDetailIDs(); // Sắp xếp lại thứ tự BlogDetailID
                };
                div.appendChild(deleteButton);

                var br = document.createElement("br");
                div.appendChild(br);

                detailDiv.appendChild(div);
            }

            function reorderBlogDetailIDs() {
                var detailDiv = document.getElementById("blogDetail");
                var inputElements = detailDiv.querySelectorAll('input[name="blog_detail_id_parent[]"]');

                // Cập nhật lại giá trị của từng inputBlogDetailID
                inputElements.forEach(function (input, index) {
                    input.value = index + 1;
                });
            }

            function addBlogImage(parentDiv) {
                var divContainer = document.createElement("div");

                // Kiểm tra các inputBlogImageID đã tồn tại
                var existingIDs = new Set();
                var inputElements = parentDiv.querySelectorAll('input[name="blog_image_id_child[]"]');
                inputElements.forEach(function (input) {
                    existingIDs.add(parseInt(input.value)); // Thêm ID hiện có vào Set
                });

                // Tìm ID thấp nhất mà chưa được sử dụng
                var newID = 1;
                while (existingIDs.has(newID)) {
                    newID++;
                }

                var inputBlogImageID = document.createElement("input");
                inputBlogImageID.type = "text";
                inputBlogImageID.type = "hidden";
                inputBlogImageID.name = "blog_image_id_child[]";
                inputBlogImageID.value = newID;
                inputBlogImageID.readOnly = true;
                divContainer.appendChild(inputBlogImageID);

                var input = document.createElement("input");
                input.type = "file";
                input.name = "image_url[]";
                input.accept = "image/jpeg";
                divContainer.appendChild(input);

                var Base64Input = document.createElement("input");
                Base64Input.type = "text";
                Base64Input.name = "base64_image[]";
                Base64Input.value = "";
                Base64Input.style.display = "none"; // Ẩn trường input
                divContainer.appendChild(Base64Input);


                var imgPreview = document.createElement("img");
                imgPreview.style.maxWidth = "200px";
                divContainer.appendChild(imgPreview);

                parentDiv.appendChild(divContainer);

                input.addEventListener('change', function () {
                    var file = this.files[0];
                    if (file) {
                        var reader = new FileReader();
                        reader.onload = function (event) {
                            imgPreview.src = event.target.result;
                            // Xử lý hình ảnh thành chuỗi base64
                            var base64Image = event.target.result;
                            Base64Input.value = base64Image;

                        };
                        reader.readAsDataURL(file);
                    }
                });

                var inputCaption = document.createElement("input");
                inputCaption.type = "text";
                inputCaption.name = "image_caption[]";
                inputCaption.className = "form-control col-md-12"; // Thêm class cho inputBlogDetailID
                inputCaption.placeholder = "Caption";
                divContainer.appendChild(inputCaption);
                var inputDetailID = document.createElement("input");
                inputDetailID.type = "text";
                inputDetailID.type = "hidden";
                inputDetailID.name = "blog_detail_id_child[]";
                inputDetailID.value = parentDiv.querySelector('input[name="blog_detail_id_parent[]"]').value;
                inputDetailID.readOnly = true;
                divContainer.appendChild(inputDetailID);
                var deleteImageButton = document.createElement("button");
                deleteImageButton.type = "button";
                deleteImageButton.innerText = "Delete Image";
//                    deleteImageButton.className = "btn btn-delete btn-sm nhap-tu-file"; // Đặt lớp CSS của button   
                deleteImageButton.onclick = function () {
                    parentDiv.removeChild(divContainer);
                    reorderBlogImageIDs(parentDiv);
                };
                divContainer.appendChild(deleteImageButton);
            }

            function reorderBlogImageIDs(parentDiv) {
                var inputElements = parentDiv.querySelectorAll('input[name="blog_image_id_child[]"]');

                var newID = 1;
                inputElements.forEach(function (input) {
                    input.value = newID++;
                });
            }

        </script>

        <script>
            function createBlog() {
                // Blog
                var blogID = document.getElementById("blogID").value;
                var title = document.getElementById("title").value;
                var date = document.getElementById("date").value;
                var userID = document.getElementById("userID").value;

                // BlogDetail
                var blogDetailIDParentInputs = document.getElementsByName("blog_detail_id_parent[]");
                var titleDetailInputs = document.getElementsByName("title_detail[]");
                var contentDetailInputs = document.getElementsByName("content_detail[]");

                // Khởi tạo mảng để lưu trữ các giá trị từ các trường input
                var blogDetailIDParents = [];
                var titleDetails = [];
                var contentDetails = [];

                // Lặp qua tất cả các trường input để lấy giá trị từ chúng và thêm vào mảng
                for (var i = 0; i < blogDetailIDParentInputs.length; i++) {
                    blogDetailIDParents.push(blogDetailIDParentInputs[i].value);
                    titleDetails.push(titleDetailInputs[i].value);
                    contentDetails.push(contentDetailInputs[i].value);
                }

                //  ImageDetail
                var blogImageIDChildInputs = document.getElementsByName("blog_image_id_child[]");
                var base64ImageInputs = document.getElementsByName("base64_image[]");
                var imageCaptionInputs = document.getElementsByName("image_caption[]");
                var blogDetailIDChildInputs = document.getElementsByName("blog_detail_id_child[]");

                // Khởi tạo mảng để lưu trữ các giá trị từ các trường input
                var blog_image_id_child = [];
                var base64_image = [];
                var image_caption = [];
                var blog_detail_id_child = [];

                // Lặp qua tất cả các trường input để lấy giá trị từ chúng và thêm vào mảng
                for (var i = 0; i < blogImageIDChildInputs.length; i++) {
                    blog_image_id_child.push(blogImageIDChildInputs[i].value);
                    base64_image.push(base64ImageInputs[i].value);
                    image_caption.push(imageCaptionInputs[i].value);
                    blog_detail_id_child.push(blogDetailIDChildInputs[i].value);
                }


                // Tạo một đối tượng XMLHttpRequest
                var xhttp = new XMLHttpRequest();

                // Xác định phương thức HTTP và URL của servlet
                xhttp.open("POST", "http://localhost:8084/SWP391/CreateBlog", true);

                // Thiết lập header của yêu cầu
                xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");


                // Xử lý sự kiện khi nhận được phản hồi từ servlet
//                xhttp.onreadystatechange = function () {
//                    if (this.readyState == 4 && this.status == 200) {
//                        // Xử lý phản hồi từ servlet nếu cần
//                        console.log(this.responseText);
//                    }
//                };

                // Gửi yêu cầu AJAX với các dữ liệu đã lấy được
                var data = "blogID=" + blogID + "&title=" + title + "&date=" + date + "&userID=" + userID;
                // Thêm các giá trị từ các mảng vào chuỗi dữ liệu
                for (var i = 0; i < blogDetailIDParents.length; i++) {
                    data += "&blog_detail_id_parent[]=" + blogDetailIDParents[i];
                    data += "&title_detail[]=" + titleDetails[i];
                    data += "&content_detail[]=" + contentDetails[i];
                }

                // Thêm các giá trị từ các mảng vào chuỗi dữ liệu
                for (var i = 0; i < blog_image_id_child.length; i++) {
                    data += "&blog_image_id_child[]=" + blog_image_id_child[i];
                    data += "&base64_image[]=" + base64ImageInputs[i].value;
                    data += "&image_caption[]=" + image_caption[i];
                    data += "&blog_detail_id_child[]=" + blog_detail_id_child[i];
                }

                // Gửi yêu cầu AJAX với các dữ liệu đã lấy được
                xhttp.send(data);
                // Xử lý sự kiện khi nhận được phản hồi từ servlet
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4) {
                        if (this.status == 200) {
                            // Xử lý phản hồi từ servlet nếu cần
                            console.log(this.responseText);
                            // Hiển thị thông báo create thành công
                            swal("Success!", "Create Blog success", "success")
                                    // Sau khi thông báo hiển thị, tải lại trang
                                    .then(() => {
                                        window.location.reload(); // Tải lại trang
                                    });
                        } else {
                            // Xử lý khi có lỗi trong quá trình gửi yêu cầu AJAX
                            // Hiển thị thông báo lỗi nếu cần
                            swal("Error!", "Create Blog fail", "error");
                        }
                    }
                };

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
