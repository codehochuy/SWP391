<%-- 
    Document   : functionBar
    Created on : Jan 30, 2024, 12:55:05 AM
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
        <div class="row element-button">
            <div class="col-sm-2">
                <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#addhousquotation">
                    <i class="fas fa-plus"></i> Báo giá
                </a>

            </div>
            <div class="col-sm-2">
                <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#addhousestyle"><i
                        class="fas fa-folder-plus"></i> Thêm kiểu nhà</a>
            </div>
            <div class="col-sm-2">
                <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#addstyle"><i
                        class="fas fa-folder-plus"></i> Thêm phong cách</a>
            </div>
        </div>
    </body>
</html>
