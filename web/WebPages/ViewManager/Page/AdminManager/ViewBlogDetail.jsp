
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
        <!--        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/css/lightbox.min.css">
        <!-- Lightbox JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/js/lightbox.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>


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
                                    <input class="form-control" type="text" id="title" value="<c:out value='${blog.title}' />" placeholder="Chấp nhận các kí tự đặc biệt , . % ' - : ">
                                </div>

                                <!--                             <script>
                                    function checkDuplicateTitle() {
                                         var blogId = document.getElementById('blogId').value;
                                       var title = document.getElementById('title').value.trim().replace(/\s{2,}/g, ' '); // Remove leading and trailing spaces and replace consecutive spaces
                                
                                        // Perform client-side validation
                                        // ...
                                
                                        // Send AJAX request to the server to check for duplicate title
                                        var xhttp = new XMLHttpRequest();
                                        xhttp.onreadystatechange = function () {
                                            if (this.readyState == 4) {
                                                if (this.status == 200) {
                                                    var response = this.responseText;
                                                    handleDuplicateTitleResponse(response);
                                                }
                                            }
                                        };
                                
                                        xhttp.open("POST", "http://localhost:8084/SWP391/UpdateBlog", true);
                                        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                                    xhttp.send("blogId=" + encodeURIComponent(blogId) + "&title=" + encodeURIComponent(title));
                                    }
                                
                                    function handleDuplicateTitleResponse(response) {
                                        if (response === "DUPLICATE_TITLE") {
                                            // Display SweetAlert for duplicate title
                                            Swal.fire({
                                                title: "Tiêu đề đã tồn tại",
                                                text: "Vui lòng chọn một tiêu đề khác",
                                                icon: "error",
                                                confirmButtonText: "OK",
                                            }).then(function () {
                                                // Clear the input field after displaying the alert
                                           document.getElementById('title').focus();
                                            });
                                        } 
                                    }
                                </script>-->
                                <script>
                                    //  All Special   `~!@#$%^&*()-_=+[{]}\|;:'",<.>/?
                                    //   title="Chấp nhận các kí tự đặc biệt , . % ' - : ">
                                    document.getElementById('title').addEventListener('blur', function () {
                                        trimInput('title');
                                    });

                                    function trimInput(inputId) {
                                        var inputElement = document.getElementById(inputId);
                                        if (inputElement) {
                                            var sanitizedValue = inputElement.value;
                                            //caplock
                                            sanitizedValue = sanitizedValue.charAt(0).toUpperCase() + sanitizedValue.slice(1);
                                            // Loại bỏ một số kí tự đặc biệt
                                            sanitizedValue = sanitizedValue.replace(/[~`!@#$^&*()\_=+{}\[\]\\|;"<>\/?]/g, '');

                                            // Loại bỏ các ký tự đặc biệt liên tiếp 
                                            sanitizedValue = sanitizedValue.replace(/([`~!@#$%^&*()-_=+\[{\]}\\|;:'",<.>/?])\1+/g, '');

                                            // Kiểm tra xem kí tự đầu tiên có phải là một trong các kí tự đặc biệt không
                                            if (/^[~`!@#$%^&*()\-_=+{}\[\]\\|;:'",<.>\/?]/.test(sanitizedValue)) {
                                                sanitizedValue = sanitizedValue.substring(1);
                                            }
                                            // Xoá khoảng trắng đầu và cuối và loại bỏ khoảng trắng liên tiếp
                                            sanitizedValue = sanitizedValue.replace(/^\s+|\s+$/g, '').replace(/\s{2,}/g, ' ');
                                            if (sanitizedValue.length < 20 || sanitizedValue.length > 70) {
                                                // Display a SweetAlert2 pop-up
                                                Swal.fire({
                                                    icon: 'warning',
                                                    title: 'Tiêu đề ít nhất 20 kí tự, nhiều nhất 70 kí tự',
                                                    //                    text: 'Please enter at least 20 characters.',
                                                    confirmButtonText: 'OK',
                                                    onClose: function () {
                                                        // Optionally, focus back on the input field or perform other actions
                                                        inputElement.focus();
                                                    }
                                                });
                                            }
                                            // Gán giá trị đã được xử lý lại cho inputElement
                                            inputElement.value = sanitizedValue;
                                        }
                                    }
                                </script>





                                <div class="form-group col-md-12">
                                    <label class="control-label">Tags</label>
                                    <input class="form-control" type="text" id="tags" placeholder = "Tối đa 20 tags" oninput="checkTags(this)" value="<c:out value='${blog.tags}' />">
                                </div>
                                <script>
                                    function checkTags(inputField) {
                                        // Get the current value of the input field
                                        var currentValue = inputField.value;

                                        // Remove all invalid characters
                                        currentValue = currentValue.replace(/[^0-9a-zA-Z\u00C0-\u024F ]/g, '');

                                        // Remove extra spaces between words
                                        var cleanedValue = currentValue.replace(/\s+/g, ' ');

                                        // Split the cleaned input into words
                                        let words = cleanedValue.split(' ');

                                        // Variable to count '#' signs
                                        let hashCount = 0;

                                        // Process each word to ensure it starts with '#' and only contains valid characters
                                        for (let i = 0; i < words.length; i++) {
                                            // Add '#' before each word, but limit to 20 '#' signs
                                            if (words[i].length > 0 && words[i][0] !== '#' && hashCount < 20) {
                                                words[i] = '#' + words[i];
                                                hashCount++;
                                            }

                                            // Remove invalid characters after '#' sign
                                            words[i] = words[i].replace(/#([^0-9a-zA-Z\u00C0-\u024F])/g, '#');

                                            // Check if the word starts with '#' and only contains valid characters after '#'
                                            if (words[i].startsWith('#') && !/^[0-9a-zA-Z\u00C0-\u024F]/.test(words[i].charAt(1))) {
                                                // Remove the invalid characters after '#'
                                                words[i] = '#' + words[i].slice(1).replace(/[^0-9a-zA-Z\u00C0-\u024F]/g, '');
                                            }
                                        }

                                        // Join the words back together with spaces
                                        inputField.value = words.join(' ');
                                    }
                                </script>


                                <script>
                                    function checkDuplicates() {
                                        // Get the current value of the input field
                                        let inputField = document.getElementById('tags');
                                        let currentValue = inputField.value;

                                        // Remove extra spaces between words and trim leading/trailing spaces
                                        let cleanedValue = currentValue.replace(/\s+/g, ' ').trim();

                                        // Split the cleaned input into words
                                        let words = cleanedValue.split(' ');

                                        // Check for duplicate words
                                        let uniqueWords = [...new Set(words)];

                                        // Remove '#' signs followed by an empty string
                                        let cleanedUniqueWords = uniqueWords.filter(word => word !== '#');

                                        // Remove all characters that don't have '#' signs before them
                                        let cleanedString = cleanedUniqueWords.map(word => {
                                            // Check if the word starts with '#' and only contains valid characters after '#'
                                            if (word.startsWith('#') && /^[0-9a-zA-Z\u00C0-\u024F]/.test(word.charAt(1))) {
                                                return word;
                                            } else {
                                                return '';
                                            }
                                        }).join(' ');

                                        // Set the cleaned string back to the input field
                                        inputField.value = cleanedString.trim();
                                    }

                                    // Add click event listener to the document body
                                    document.body.addEventListener('click', function (event) {
                                        // Check if the clicked element is not the Tags input
                                        if (event.target.id !== 'tags') {
                                            // Call the checkDuplicates function
                                            checkDuplicates();
                                        }
                                    });
                                </script>



                                <textarea id="mytextarea">${blog.content}</textarea>



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
                var titleInput = document.getElementById("title");
                var title = encodeURIComponent(titleInput.value); // Mã hóa tiêu đề
                var tags = encodeURIComponent(document.getElementById("tags").value); // Mã hóa tags
                var content = encodeURIComponent(tinymce.activeEditor.getContent());
                var categorySelect = document.getElementById("categorySelect");
                var selectedCategory = categorySelect.options[categorySelect.selectedIndex].value;
                var dateModified = document.getElementById("dateModified").value;

                // Check validate
                var decodedTitle = decodeURIComponent(title);
                var decodedTags = decodeURIComponent(tags);
                var decodedContent = decodeURIComponent(content);

                if (!title.trim() || !tags.trim() || !content.trim() || !selectedCategory.trim()) {
                    Swal.fire({
                        title: "Vui lòng điền đầy đủ thông tin",
                        icon: "error",
                        confirmButtonText: "OK",
                    });
                    return;
                }
                if (!/^[\s\S]*(<img [^>]+>)[\s\S]{300,}$/u.test(decodedContent) && /\p{L}/u.test(decodedContent)) {
                    Swal.fire({
                        title: "Nội dung chứa ít nhất 300 kí tự và hình ảnh",
                        icon: "error",
                        confirmButtonText: "OK",
                    });
                    return;
                }

                // Send AJAX request to check for duplicate title
                var duplicateCheckXhttp = new XMLHttpRequest();
                duplicateCheckXhttp.onreadystatechange = function () {
                    if (this.readyState == 4) {
                        if (this.status == 200) {
                            var response = this.responseText;
                            if (response === "DUPLICATE_TITLE") {
                                // Display SweetAlert for duplicate title
                                Swal.fire({
                                    title: "Tiêu đề đã tồn tại",
                                    text: "Vui lòng chọn một tiêu đề khác",
                                    icon: "error",
                                    confirmButtonText: "OK",
                                }).then(function () {
                                    titleInput.focus();
                                });
                            } else {
                                // No duplicate title, proceed with updating the blog
                                performBlogUpdate(blogId, title, tags, content, selectedCategory, dateModified);
                            }
                        }
                    }
                };

                duplicateCheckXhttp.open("POST", "http://localhost:8084/SWP391/UpdateBlog", true);
                duplicateCheckXhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                duplicateCheckXhttp.send("blogId=" + blogId + "&title=" + title);
            }

            function performBlogUpdate(blogId, title, tags, content, selectedCategory, dateModified) {
                // Send AJAX request to update the blog
                var updateXhttp = new XMLHttpRequest();
                updateXhttp.onreadystatechange = function () {
                    if (this.readyState == 4) {
                        if (this.status == 200) {
                            // Sử dụng SweetAlert2 để hiển thị thông báo
                            Swal.fire({
                                title: "Cập nhật blog thành công",
                                icon: "success",
                                confirmButtonText: "OK",
                            }).then((result) => {
                                // Tải lại trang sau khi người dùng nhấp vào nút OK
                                if (result.isConfirmed) {
                                    window.location.reload();
                                }
                            });
                        } else {
                            // Xử lý trường hợp lỗi
                            Swal.fire({
                                title: "Cập nhật blog thất bại",
                                icon: "error",
                                confirmButtonText: "OK",
                            });
                        }
                    }
                };

                updateXhttp.open("POST", "http://localhost:8084/SWP391/UpdateBlog", true);
                updateXhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                updateXhttp.send("blogId=" + blogId + "&title=" + title + "&tags=" + tags + "&content=" + content + "&category=" + selectedCategory + "&dateModified=" + dateModified);
            }
        </script>

    </body>
</html>
