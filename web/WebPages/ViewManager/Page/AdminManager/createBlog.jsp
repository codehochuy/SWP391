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
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="ManagerBlog"><b>Bài viết</b></a></li>
                         <li class="breadcrumb-item active"><a href="ManagerBlog"><b>Loại bài viết</b></a></li>
                </ul>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h1 class="tile-title">Tạo Bài Viết</h1>
                        <div class="tile-body">


                            <div class="form-group col-md-12" style="display: none;">
                                <label class="control-label">Ngày tạo</label>
                                <input class="form-control" type="date" id="date" name="date" readonly="true" required><br>
                            </div>


                            <div class="form-group col-md-12">
                                <label class="control-label">Loại bài viết</label>
                                <select class="form-control" id="blogCategory" name="blogCategory" required>
                                    <option value="" disabled selected>Chọn loại bài viết</option>
                                    <c:forEach var="category" items="${categoryList}">
                                        <option value="${category}">${category}</option>
                                    </c:forEach>
                                </select>
                                <div id="newCategoryInput" style="display: none;">
                                    <label class="control-label">Nhập loại tin tức mới</label>
                                    <input class="form-control" type="text" id="newCategoryValue" name="newCategoryValue">
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Tiêu đề</label>
                            <input class="form-control" type="text" id="title" name="title" required onblur="checkDuplicateTitle()" placeholder="Chấp nhận các kí tự đặc biệt , . % ' - : "><br>
                        </div>
                        <script>
                            function checkDuplicateTitle() {
                                var title = document.getElementById('title').value;

                                // Send AJAX request to the server to check for duplicate title
                                var xhttp = new XMLHttpRequest();
                                xhttp.onreadystatechange = function () {
                                    if (this.readyState == 4) {
                                        if (this.status == 200) {
                                            var response = this.responseText;
                                            if (response === "DUPLICATE_TITLE") {
                                                // Display SweetAlert for duplicate title
                                                swal({
                                                    title: "Tiêu đề đã tồn tại",
                                                    text: "Vui lòng chọn một tiêu đề khác",
                                                    icon: "error",
                                                    button: "OK",
                                                }).then(function () {
                                                    // Clear the input field after displaying the alert
                                                    document.getElementById('title').value = "";
                                                });
                                            } else {
                                                // Clear the error message if no duplicate title
                                                document.getElementById('titleErrorMessage').innerText = "";
                                            }
                                        }
                                    }
                                };

                                xhttp.open("POST", "http://localhost:8084/SWP391/CreateBlog", true);
                                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                                xhttp.send("title=" + encodeURIComponent(title));
                            }
                        </script>

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
                            <input class="form-control" type="text" id="tags" name="tags" placeholder = "Tối đa 20 tags" oninput="checkTags(this)" required><br>
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
                  <textarea id="mytextarea" placeholder="Nhập nội dung"></textarea>

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
