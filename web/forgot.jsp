<%-- 
    Document   : login
    Created on : May 23, 2023, 9:34:31 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Đăng nhập quản trị</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Khôi phục mật khẩu</title>
        <link rel="icon" href="img/logo.jpg" type="image/x-icon">
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>


    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-pic js-tilt" data-tilt>
                        <img src="img/fg-img.png" alt="IMG">
                    </div>
                    <div class="login100-form validate-form">
                        <span class="login100-form-title">
                            <b>KHÔI PHỤC MẬT KHẨU</b>
                        </span>
                        <form id="forgotForm" action="sendmail" method="post">
                            <div class="wrap-input100 validate-input">
                                <input class="input100" type="text" placeholder="Nhập email" name="emailInput" id="emailInput" value="" required="" />
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class='bx bx-mail-send'></i>
                                </span>
                            </div>
                            <div class="message" id="emailValidationMessage"></div> 
                            <div class="container-login100-form-btn">
                                <input type="button" value="Lấy mật khẩu" onclick="validateEmail()" />
                            </div>
                        </form>


                        <div class="text-center p-t-12">
                            <a class="txt2" href="Login.jsp">
                                Trở về đăng nhập
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
    <script>
        function validateEmail() {
            var email = document.getElementById("emailInput").value;
            var emailRegex = /^[^\s@]+@(gmail\.com|fpt\.edu\.vn)$/;

            if (email === "") {
                // Email is empty, display an error message
                document.getElementById("emailValidationMessage").innerHTML = "<span style='color: red;'>Vui lòng nhập email.</span>";
            } else if (emailRegex.test(email)) {
                document.getElementById("forgotForm").submit(); // Submit the form
            } else {
                // Invalid email, display an error message
                document.getElementById("emailValidationMessage").innerHTML = "<span style='color: red;'>Vui lòng nhập email hợp lệ.</span>";
            }
        }

    </script>
    <script>
        <% if (request.getAttribute("messtrue") != null) {%>
        swal("<%= request.getAttribute("messtrue")%>", "", "success");
        <% request.removeAttribute("messtrue"); %>
        <% }%>
    </script>
    <script>
        <% if (request.getAttribute("mess") != null) {%>
        swal("<%= request.getAttribute("mess")%>", "", "error");
        <% request.removeAttribute("mess"); %>
        <% }%>
    </script>
    <script>
        <% if (request.getAttribute("messfalse") != null) {%>
        swal("<%= request.getAttribute("messfalse")%>", "", "error");
        <% request.removeAttribute("messfalse"); %>
        <% }%>
    </script>
</html>
