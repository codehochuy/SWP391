<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" type="text/css" href="css\admin.css">
        <link rel="icon" href="img/logo.jpg" type="image/x-icon">

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
                    <li class="breadcrumb-item"><a href="ManageMaterial">Quản lý vật liệu</a></li>
                    <li class="breadcrumb-item"><a href="">Chi tiết vật liệu</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h1 class="tile-title">Thông tin chi tiết</h1>
                        <div class="tile-body">
                            <form class="row" action="UpdateMaterial" method="post" enctype="multipart/form-data" id="createPro">

                                <div class="form-group col-md-4">
                                    <label class="control-label">Tên vật liệu</label>
                                    <input class="form-control" type="text" name="" value="${list.name}">
                                    <div class="error-message" id="tensp-error"></div>
                                </div>

                                <div class="form-group col-md-4">
                                    <label class="control-label">Giá</label>
                                    <input class="form-control" type="text" name="" value="${list.price}">
                                    <div class="error-message" id="tensp-error"></div>
                                </div>

                                <div class="form-group col-md-4">
                                    <label for="exampleSelect2" class="control-label">Loại</label>
                                    <select class="form-control" id="exampleSelect2" name="material">
                                        <option disabled>-- Chọn loại vật liệu --</option>
                                        <c:forEach items="${requestScope.list1}" var="i">
                                            <option value="${i.id}" 
                                                    ${i.name eq list.category ? 'selected' : ''}>
                                                ${i.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group col-md-12">
                                    <label class="control-label">Ảnh</label>
                                    <div class="image-gallery">
                                        <a href="img/${list.link}" data-lightbox="project-gallery">
                                            <img src="img/${list.link}" class="thumbnail"/>
                                        </a>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <button class="btn btn-save" type="button" onclick="validateForm()">Lưu lại</button>
                        <a class="btn btn-cancel" href="ManageMaterial">Hủy bỏ</a>
                    </div>
                </div>
            </div>
        </main>

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