

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

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/css/lightbox.min.css">
        <!-- Lightbox JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/js/lightbox.min.js"></script>


    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <jsp:include page="../../Page/Header/headerAdmin.jsp"/>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item"><a href="ManagerProject">Dự án đã hoàn thành</a></li>
                    <li class="breadcrumb-item"><a href="">Thêm dự án</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h1 class="tile-title">Thông tin chi tiết</h1>
                        <div class="tile-body">
                            <form class="row" action="CreateProject" method="post" enctype="multipart/form-data" id="createPro">
                                <div class="form-group col-md-4">
                                    <label class="control-label">Tên dự án</label>
                                    <input class="form-control" type="text" name="projectname" >
                                    <div class="error-message" id="tensp-error"></div>
                                </div>
                                <div class="form-group col-md-4">
                                    <label class="control-label">Ngày hoàn thành</label>
                                    <input class="form-control" type="date" name="date" >
                                    <div class="error-message" id="price-error"></div>
                                </div>
                                <div class="form-group col-md-4">
                                    <label class="control-label">Thời gian hoàn thành/ngày</label>
                                    <input class="form-control" type="number" min="0" name="time" >
                                    <div class="error-message" id="quantity-error"></div>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="exampleSelect1" class="control-label">Dịch vụ</label>
                                    <select class="form-control" id="exampleSelect1" name="service">
                                        <option disabled>-- Chọn dịch vụ --</option>
                                        <c:forEach items="${requestScope.services}" var="i">
                                            <option value="${i.id}">${i.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="exampleSelect2" class="control-label">Kiểu nhà</label>
                                    <select class="form-control" id="exampleSelect2" name="houseTypes">
                                        <option disabled>-- Chọn kiểu nhà --</option>
                                        <c:forEach items="${requestScope.houseTypes}" var="i">
                                            <option value="${i.id}">${i.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group col-md-4">
                                    <label for="exampleSelect3" class="control-label">Phong cách</label>
                                    <select class="form-control" id="exampleSelect3" name="styles">
                                        <option disabled>-- Chọn phong cách --</option>
                                        <c:forEach items="${requestScope.styles}" var="i">
                                            <option value="${i.id}">${i.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Description</label>
                                    <textarea class="form-control" name="description" id="description" rows="5"></textarea>
                                    <div class="error-message" id="description-error"></div>
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Ảnh dự án</label>
                                    <div id="myfileupload">
                                        <input type="file" id="uploadfile" name="ImageUpload" onchange="readURL(this);" multiple>
                                    </div>
                                    <div id="thumbbox">
                                        <!-- Hiển thị các ảnh đã chọn -->
                                        <div id="thumbimages"></div>
                                        <a class="removeimg" href="javascript:"></a>
                                    </div>
                                    <!--                                    <div id="boxchoice">
                                                                            <a href="javascript:" class="Choicefile"><i class="fas fa-cloud-upload-alt"></i> Chọn ảnh</a>
                                                                            <p style="clear:both"></p>
                                                                        </div>-->
                                    <span id="imageError" class="error"></span>
                                </div>
                                <button class="btn btn-save" type="submit" >Lưu lại</button>
                                <a class="btn btn-cancel" href="ManagerProject">Hủy bỏ</a>

                            </form>
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
            function readURL(input) {
                if (input.files && input.files.length > 0) {
                    var thumbimages = document.getElementById("thumbimages");
                    thumbimages.innerHTML = ""; // Xóa bất kỳ ảnh hiện tại

                    for (var i = 0; i < input.files.length; i++) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            var img = document.createElement("img");
                            img.src = e.target.result;
                            img.width = 100; // Đặt kích thước ảnh theo ý muốn
                            img.height = 100;
                            thumbimages.appendChild(img);
                        };

                        reader.readAsDataURL(input.files[i]);
                    }
                }
            }

        </script>

    </body>

</html>
