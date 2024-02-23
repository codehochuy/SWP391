<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Blog Management</title>
        <link rel="stylesheet" type="text/css" href="css\admin.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/css/lightbox.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/js/lightbox.min.js"></script>
    </head>
    <body onload="time()" class="app sidebar-mini rtl">
        <jsp:include page="../../Page/Header/headerAdmin.jsp"/>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item"><a href="ManagerProject">Quản lý Blog</a></li>
                    <li class="breadcrumb-item"><a href="">Blog Detail</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h1 class="tile-title">Blog Detail</h1>
                        <div class="tile-body">
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label class="control-label">BlogID</label>
                                    <input class="form-control" id="blogIDInput" readonly>
                                </div>

                                <div class="form-group col-md-6">
                                    <label class="control-label">Date</label>
                                    <input class="form-control" id="dateInput" readonly>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="control-label">Title</label>
                                    <input class="form-control" id="titleInput" readonly>
                                </div></div>
                            <div class="form-group col-md-6" style="display: none;">
                                <label class="control-label">UserID</label>
                                <input class="form-control" id="userIDInput" readonly>
                            </div>

                            <div id="blogDetail">
                                <!-- Blog details will be displayed here -->
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <script>
                var blogJSON = <%= request.getAttribute("json")%>;

                // Lấy giá trị từ biến blogJSON
                var blogID = blogJSON.blogID;
                var title = blogJSON.title;
                var date = blogJSON.date;
                var usersID = blogJSON.usersID;

                // Gán giá trị vào các ô input tương ứng
                document.getElementById("blogIDInput").value = blogID;
                document.getElementById("titleInput").value = title;
                document.getElementById("dateInput").value = date;
                document.getElementById("userIDInput").value = usersID;

                var blogDetails = blogJSON.blogDetails;

                for (var i = 0; i < blogDetails.length; i++) {
                    var blogDetail = blogDetails[i];
                    var detailDiv = document.getElementById("blogDetail");
                    var div = document.createElement("div");

                    // Tạo và gán giá trị cho inputBlogDetailID
                    var inputBlogDetailID = document.createElement("input");
                    inputBlogDetailID.type = "hidden";
                    inputBlogDetailID.name = "blog_detail_id_parent[]";
                    inputBlogDetailID.value = blogDetail.blogDetailID;
                    inputBlogDetailID.readOnly = true;
                    inputBlogDetailID.className = "form-control col-md-12"; // Thêm class cho inputBlogDetailID
                    div.appendChild(inputBlogDetailID);

                    // Tạo và gán giá trị cho inputTitle
                    var inputTitle = document.createElement("input");
                    inputTitle.type = "text";
                    inputTitle.name = "title_detail[]";
                    inputTitle.className = "form-control col-md-12"; // Thêm class cho inputBlogDetailID
                    inputTitle.value = blogDetail.title;
                    div.appendChild(inputTitle);

                    // Tạo và gán giá trị cho textareaContent
                    var textareaContent = document.createElement("textarea");
                    textareaContent.name = "content_detail[]";
                    textareaContent.className = "form-control col-md-12"; // Thêm class cho inputBlogDetailID
                    textareaContent.textContent = blogDetail.content;
                    div.appendChild(textareaContent);

                    // Hiển thị BlogID
                    var inputBlogID_BlogDetailID = document.createElement("input");
                    inputBlogID_BlogDetailID.type = "hidden";
                    inputBlogID_BlogDetailID.name = "blog_id[]";
                    inputBlogID_BlogDetailID.className = "form-control col-md-12"; // Thêm class cho inputBlogDetailID
                    inputBlogID_BlogDetailID.value = blogDetail.blogID; // Giả sử giá trị blogID được lưu trong biến blogDetail.blogID
                    inputBlogID_BlogDetailID.readOnly = true;
                    div.appendChild(inputBlogID_BlogDetailID);


// Thêm một dòng trống
                    var lineBreak = document.createElement("br");
                    div.appendChild(lineBreak);
// Thêm một dòng trống
                    var lineBreak = document.createElement("br");
                    div.appendChild(lineBreak);




                    // Thêm chi tiết hình ảnh của blog (nếu có)
                    var blogImages = blogDetail.blogImages;
                    for (var j = 0; j < blogImages.length; j++) {
                        var blogImage = blogImages[j];

                        // Hiển thị hình ảnh
                        var img = document.createElement("img");
                        img.src = "img/" + blogImage.url; // Thiết lập đường dẫn tương đối đến hình ảnh
                        img.alt = blogImage.caption;
                        img.style.width = "500px"; // Đặt chiều rộng của hình ảnh là 500px
                        div.appendChild(img);

                        // Tạo và gán giá trị cho các input của blogImage
                        var inputBlogImageID = document.createElement("input");
                        inputBlogImageID.type = "hidden";
                        inputBlogImageID.name = "blog_image_id_child[]";
                        inputBlogImageID.className = "form-control col-md-12"; // Thêm class cho inputBlogDetailID
                        inputBlogImageID.value = blogImage.blogImageID;
                        inputBlogImageID.readOnly = true;
                        div.appendChild(inputBlogImageID);



                        // Tạo input cho url của hình ảnh
                        var inputImageUrl = document.createElement("input");
                        inputImageUrl.type = "hidden";
                        inputImageUrl.name = "image_url[]";
                        inputImageUrl.className = "form-control col-md-12"; // Thêm class cho inputBlogDetailID
                        inputImageUrl.value = blogImage.url;
                        div.appendChild(inputImageUrl);

                        // Tạo input cho caption của hình ảnh
                        var inputCaption = document.createElement("input");
                        inputCaption.type = "text";
                        inputCaption.name = "image_caption[]";
                        inputCaption.className = "form-control col-md-12"; // Thêm class cho inputBlogDetailID
                        inputCaption.value = blogImage.caption;
                        div.appendChild(inputCaption);

                        // Tạo input cho BlogDetailID của hình ảnh
                        var inputBlogDetailID_BlogImageID = document.createElement("input");
                        inputBlogDetailID_BlogImageID.type = "hidden";
                        inputBlogDetailID_BlogImageID.name = "blog_detail_id_child[]";
                        inputBlogDetailID_BlogImageID.className = "form-control col-md-12"; // Thêm class cho inputBlogDetailID
                        inputBlogDetailID_BlogImageID.value = blogDetail.blogDetailID; // Giả sử giá trị BlogDetailID lưu trong biến blogDetail.blogDetailID
                        inputBlogDetailID_BlogImageID.readOnly = true;
                        div.appendChild(inputBlogDetailID_BlogImageID);



// Tạo nút xóa cho mỗi hình ảnh
                        var deleteImageButton = document.createElement("button");
                        deleteImageButton.type = "button";
                        deleteImageButton.innerText = "Delete Image";
                        deleteImageButton.onclick = function () {
                            // Xác định ID của hình ảnh để xóa dựa trên giá trị của inputBlogImageID
                            var blogImageID = inputBlogImageID.value;

                            // Xác định div chứa hình ảnh (cha của nút xóa)
                            var imageDiv = this.parentElement;

                            // Xác định div chứa chi tiết blog (cha của div chứa hình ảnh)
                            var detailDiv = imageDiv.parentElement;

                            // Xác định vị trí của div chứa hình ảnh trong chi tiết blog
                            var imageIndex = Array.prototype.indexOf.call(detailDiv.children, imageDiv);

                            // Tìm và xóa hình ảnh có ID tương ứng
                            var imageElements = detailDiv.querySelectorAll('div');
                            var imageElement = imageElements[imageIndex];
                            if (imageElement) {
                                detailDiv.removeChild(imageElement);
                            }
                        };
                        deleteImageButton.style.display = "none"; // Ẩn nút xóa hình ảnh
                        div.appendChild(deleteImageButton);
                    }

// Thêm một dòng trống
                    var lineBreak = document.createElement("br");
                    div.appendChild(lineBreak);

// Thêm một dòng trống
                    var lineBreak = document.createElement("br");
                    div.appendChild(lineBreak);

// Tạo nút xóa cho BlogDetail
                    var deleteButton = document.createElement("button");
                    deleteButton.type = "button";
                    deleteButton.innerText = "Delete Detail";
                    deleteButton.onclick = function () {
                        // Xác định chi tiết blog để xóa dựa trên giá trị của inputBlogDetailID_BlogImageID
                        var blogDetailID = inputBlogDetailID_BlogImageID.value;
                        var detailDiv = document.getElementById("blogDetail");

                        // Tìm và xóa chi tiết blog có ID tương ứng
                        var detailElements = detailDiv.querySelectorAll('div');
                        for (var i = 0; i < detailElements.length; i++) {
                            var detailElement = detailElements[i];
                            var inputDetailID = detailElement.querySelector('input[name="blog_detail_id_parent[]"]');
                            if (inputDetailID && inputDetailID.value === blogDetailID) {
                                detailDiv.removeChild(detailElement);
                                break; // Kết thúc sau khi xóa
                            }
                        }

                        // Sau khi xóa, bạn cũng có thể cần cập nhật lại các ID
                        reorderBlogDetailIDs();
                    };
                    deleteButton.style.display = "none"; // Ẩn nút xóa hình ảnh
                    div.appendChild(deleteButton);

                    var br = document.createElement("br");
                    div.appendChild(br);

                    detailDiv.appendChild(div);

                }
            </script>

        </main>
        <!-- Essential javascripts for application to work-->
        <script src="./js/jquery-3.2.1.min.js"></script>
        <script src="./js/popper.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="src/jquery.table2excel.js"></script>
        <script src="./js/main.js"></script>
        <script src="js/plugins/pace.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
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
    </body>
</html>
