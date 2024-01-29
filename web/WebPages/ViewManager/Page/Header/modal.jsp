<%-- 
    Document   : modal
    Created on : Jan 30, 2024, 1:15:11 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="modal fade" id="addhousestyle" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                    <div class="modal-body">
                        <form action="CreateHouseStyle" method="post">
                            <div class="row">
                                <div class="form-group  col-md-12">
                                    <span class="thong-tin-thanh-toan">
                                        <h5>Thêm mới kiểu nhà mới </h5>
                                    </span>
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Nhập tên kiểu nhà mới</label>
                                    <input class="form-control" type="text" required name="housestyle">
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Danh sách các kiểu nhà nhà hiện có</label>
                                    <ul class="compact-list">
                                        <c:forEach items="${requestScope.houseTypes}" var="i" varStatus="status">
                                            <div>${status.index + 1}. ${i.name}</div>
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
        <div class="modal fade" id="addstyle" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                    <div class="modal-body">
                        <form action="CreateStyle" method="post">
                            <div class="row">
                                <div class="form-group  col-md-12">
                                    <span class="thong-tin-thanh-toan">
                                        <h5>Thêm mới phong cách mới </h5>
                                    </span>
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Nhập tên phong cách nhà mới</label>
                                    <input class="form-control" type="text" required name="style">
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Danh sách các phong cách nhà hiện có</label>
                                    <ul class="compact-list">
                                        <c:forEach items="${requestScope.styles}" var="i" varStatus="status">
                                            <div>${status.index + 1}. ${i.name}</div>
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
    </body>
</html>
