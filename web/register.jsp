<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng ký tài khoản</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
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
                    <b>ĐĂNG KÝ TÀI KHOẢN</b>
                </span>
                <form action="Register" method="post" onsubmit="return validateForm()">
                    <div class="wrap-input100">
                        <input class="input100" type="text" placeholder="Tên đăng nhập" name="username" id="username"
                               required pattern="[A-Za-z0-9]{3,7}" title="Tài khoản phải từ 3-7 kí tự và chỉ chấp nhận chữ cái và số">
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
                            <i class='bx bx-user'></i>
                        </span>
                    </div>
                    <!-- Display error message if exists -->
                    <% if (request.getAttribute("errorMessage") != null) {%>
                    <p style="color: red;"><%= request.getAttribute("errorMessage")%></p>
                    <% } %>
                    <div class="wrap-input100">
                        <input class="input100" type="text" placeholder="Tên" name="name" id="name" required>
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
                            <i class='bx bx-user'></i>
                        </span>
                    </div>
                    <div class="wrap-input100">
                        <input class="input100" type="email" placeholder="Email" name="email" id="email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
                            <i class='bx bx-envelope'></i>
                        </span>
                    </div>
                    <div class="wrap-input100">
                        <input autocomplete="off" class="input100" type="password" placeholder="Mật khẩu" name="password" id="password" required minlength="6">
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
                            <i class='bx bx-key'></i>
                        </span>
                    </div>
                    <div class="wrap-input100">
                        <input autocomplete="off" class="input100" type="password" placeholder="Xác nhận mật khẩu" name="confirmPassword" id="confirmPassword" required minlength="6">
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
                            <i class='bx bx-key'></i>
                        </span>
                    </div>

                    <!--=====ĐĂNG KÝ======-->
                    <div class="container-login100-form-btn">
                        <input type="submit" value="Đăng ký">
                    </div>
                    <div class="text-right p-t-12">
                        <a class="txt2" href="index">Quay về trang chủ</a>
                    </div>
                </form>
                <p style="color: red">${mess}</p>
            </div>
        </div>
    </div>
</div>

<script>
    function validateForm() {
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirmPassword").value;

        // Check if passwords match
        if (password !== confirmPassword) {
            alert("Mật khẩu và Xác nhận mật khẩu không khớp!");
            return false; // Prevent form submission
        }
        return true; // Allow form submission
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
