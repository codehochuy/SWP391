<%-- 
    Document   : login
    Created on : May 23, 2023, 9:34:31 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập quản trị</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        
        
        
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-pic js-tilt" data-tilt>
                        <img src="img/team.jpg" alt="IMG">
                    </div>
                    <!--=====TIÊU ĐỀ======-->
                    <div class="login100-form validate-form">
                        <span class="login100-form-title">
                            <b>ĐĂNG NHẬP </b>
                        </span>
                        <form action="LoginServlet" method="post">
                            <div class="wrap-input100">
                                <input class="input100" type="text" placeholder="Tài khoản quản trị" name="username">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class='bx bx-user'></i>
                                </span> 
                            </div>
                            <div class="wrap-input100">
                                <input autocomplete="off" class="input100" type="password" placeholder="Mật khẩu"
                                       name="password" >
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class='bx bx-key'></i>
                                </span> 
                            </div>

                            <!--=====ĐĂNG NHẬP======-->
                            <div class="container-login100-form-btn">
                                <input type="submit" value="Đăng nhập" />
                            </div>
                            <!--=====LINK TÌM MẬT KHẨU======-->
                            <div class="text-right p-t-12">
                                <a class="txt2" href="forgot.jsp">
                                    Bạn quên mật khẩu?
                                </a>
                            </div>
                        </form>

                        <p style="color: red">${mess}</p>
                        <!--=====FOOTER======-->
                        <!--                        <div class="text-center p-t-70 txt2">
                                                    Phần mềm quản lý bán hàng <i class="far fa-copyright" aria-hidden="true"></i>
                                                    <script type="text/javascript">document.write(new Date().getFullYear());</script> <a-->

                    </div>
                </div>
            </div>
        </div>


</body>
</html>
