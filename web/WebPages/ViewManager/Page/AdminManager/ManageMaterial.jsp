<%-- 
    Document   : ManageMaterial
    Created on : Feb 21, 2024, 1:18:41 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý vật liệu</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="img/logo.jpg" type="image/x-icon">

        <link rel="stylesheet" type="text/css" href="css\admin.css">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">

        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <jsp:include page="../../Page/Header/headerAdmin.jsp"/>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Quản lý vật liệu</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <div class="row element-button">
                                <div class="col-sm-2">
                                    <a class="btn btn-add btn-sm" href="CreateMaterial" title="Thêm">
                                        <i class="fas fa-plus"></i> Thêm vật liệu
                                    </a>
                                </div>
                                <div class="col-sm-2">
                                    <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#createCategory"><i
                                            class="fas fa-folder-plus"></i> Thêm loại vật liệu</a>
                                </div>
                            </div>
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th width="10"><input type="checkbox" id="all"></th>
                                        <th>Tên vật liệu</th>
                                        <th>Giá vật liệu</th>
                                        <th>Loại vật liệu</th>
                                        <th>Kiểu thi công</th>
                                        <th>Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="list">                                        
                                        <tr>
                                            <td width="10"><input type="checkbox" name="check1" value="1"></td>
                                            <td>${list.name}</td>
                                            <td>
                                                <c:set var="multipliedPrice" value="${list.price}" />
                                                <fmt:formatNumber value="${multipliedPrice}" pattern="###,###,###" />đ/${list.unit}
                                            </td>
                                            <td>${list.category}</td>
        <!--                                            <td>${list.link}</td>-->
                                            <td>
                                                <c:if test="${list.type eq 0}">
                                                    Thi công phần thô
                                                </c:if>
                                                <c:if test="${list.type eq 1}">
                                                    Thi công trọn gói
                                                </c:if>
                                            </td>
                                            <td style="display: flex; justify-content: space-left">
                                                <form action="" method="post">
                                                    <button class="btn btn-primary btn-sm trash" type="button" title="Xóa" onclick="confirmDelete(this)"
                                                            data-userID="${list.id}">
                                                        <i class="fas fa-trash-alt"></i>
                                                    </button>
                                                </form>

                                                <form action="ShowMaterialDetail" method="post">
                                                    <input type="hidden" name="materialID" value="${list.id}">
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
        <div class="modal fade" id="createCategory" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <form action="CreateMaterialCategory" method="post" >
                            <div class="row">
                                <div class="form-group  col-md-12">
                                    <span class="thong-tin-thanh-toan">
                                        <h5>Thêm loại vật liệu mới</h5>
                                    </span>
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Nhập tên:</label>
                                    <input class="form-control" type="text" required name="categoryname">
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Danh sách các loại vật liệu hiện có:</label>
                                    <ul class="compact-list">
                                        <c:forEach items="${requestScope.cat}" var="i" varStatus="status">
                                            <div>- ${i.name}</div>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                            <button class="btn btn-save" type="submit">Lưu lại</button>
                            <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
                        </form>
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>

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

        <script>
            function confirmDelete(button) {
                var materialid = button.getAttribute("data-userID");

                swal({
                    title: "Cảnh báo",
                    text: "Bạn có muốn xóa vật liệu này?",
                    buttons: ["Hủy bỏ", "Đồng ý"],
                }).then((willDelete) => {
                    if (willDelete) {
                        var form = button.closest("form");
                        form.action = "DeleteMaterial?id=" + materialid;
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