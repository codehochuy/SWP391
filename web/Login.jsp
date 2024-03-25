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
        <link rel="icon" href="img/logo.jpg" type="image/x-icon">
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
                        <a href="index"><img src="img/team_4.jpg" alt="IMG"></a>
                        
                    </div>
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
                            <div class="container-login100-form-btn">
                                <input type="submit" value="Đăng nhập" />
                            </div>
                            <a href="https://accounts.google.com/o/oauth2/auth?scope=email profile&redirect_uri=https://8dda-118-69-182-144.ngrok-free.app/SWP391/LoginGoogleHandler&response_type=code
                               &client_id=763130706443-1ag9h8eptq9s3m17v09t55ifiklh9fi7.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>
                            
                            <div class="text-right p-t-12">
                                <a class="txt2" href="register.jsp">
                                    Đăng ký tài khoản mới
                                </a>
                            </div>
                            <div class="text-right p-t-12">
                                <a class="txt2" href="forgot.jsp">
                                    Bạn quên mật khẩu?
                                </a>
                            </div>
                        </form>

                        <p style="color: red">${mess}</p>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
