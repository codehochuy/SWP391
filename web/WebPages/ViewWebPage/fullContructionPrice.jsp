<%-- 
    Document   : fullContructionPrice
    Created on : Feb 2, 2024, 12:00:50 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>TITAN - Bảng Giá Xây Nhà Trọn Gói</title>
        <link rel="icon" href="img/logo.jpg" type="image/x-icon">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Construction Company Website Template" name="keywords">
        <meta content="Construction Company Website Template" name="description">

        <!-- Favicon -->
        <link href="WebPages/ViewWebPage/img/favicon.ico" rel="icon">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">

        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/flaticon/font/flaticon.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/animate/animate.min.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/slick/slick.css" rel="stylesheet">
        <link href="WebPages/ViewWebPage/lib/slick/slick-theme.css" rel="stylesheet">
        <!-- Template Stylesheet -->
        <link href="WebPages/ViewWebPage/css/style.css" rel="stylesheet">
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
                border-radius: 8px;
                overflow: hidden;
                margin: 20px 0;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            thead {
                background-color: #fdbe33;
                color: #fff;
                text-align: center;
            }
            th, td {
                padding: 15px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            tbody tr:nth-child(even) {
                background-color: #f9f9f9;
            }
            tbody tr:hover {
                background-color: #ecf0f1;
            }
            img {
                /*                display: block;
                                margin: 15px auto;
                                width: 80%;
                                height: auto;*/
            }
            /* styles.css */
            #table-of-contents {
                display: none; /* Mục lục mặc định ẩn đi */
                background-color: #f0f0f0;
                padding: 10px;
                border-radius: 5px;
                list-style: none;
            }

            #table-of-contents li {
                margin-bottom: 5px;
                list-style: none;
            }

            #table-of-contents a {
                text-decoration: none;
                color: #333;
            }

            #table-of-contents a:hover {
                color: #fdbe33;
            }

            #toggle-contents {
                margin-bottom: 10px;
            }
            .centered {
                display: flex;
                justify-content: center; /* căn giữa theo chiều ngang */
                align-items: center; /* căn giữa theo chiều dọc */
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="../../WebPages/ViewWebPage/HeaderPage.jsp"/>


            <!-- Page Header Start -->
            <div class="page-header">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h2>Bảng Giá Xây Nhà Trọn Gói</h2>
                        </div>
                        <div class="col-12">
                            <a href="index">Trang Chủ</a>
                            <a href="">Bảng Giá Xây Nhà Trọn Gói</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->


            <!-- Portfolio Start -->
            <div class="portfolio">
                <div class="container">
                    <main>
                        <article>
                            <div class="single-content wow fadeInUp" >
                                <button class="dropdown-toggle" id="toggle-contents">Nội dung chính</button>
                            </div>
                            <ul id="table-of-contents">
                                <li><a href="#section-1">1. Bảng báo giá xây nhà trọn gói tại TITAN [Mới Nhất 2024]</a></li>
                                <li><a href="#section-2">2. Vậy dịch vụ xây nhà trọn gói là gì?</a></li>
                                <li><a href="#section-3">3. Ưu điểm của dịch vụ xây nhà trọn gói</a></li>
                                <li><a href="#section-4">4. Cách tính diện tích xây dựng trọn gói 2024</a></li>
                                <li><a href="#section-5">5. Tiêu chí khi chọn đơn vị báo giá xây nhà trọn gói năm 2024</a></li>
                                <li><a href="#section-6">6. Một số hạng mục thi công xây nhà trọn gói 2024</a></li>
                                <li><a href="#section-7">7. Quy trình báo giá xây nhà trọn gói của TITAN [Mới nhất 2024]</a></li>
                                <li><a href="#section-8">8. TITAN cam kết dịch vụ xây nhà trọn gói 2024</a></li>
                            </ul>

                            <section id="section-1">
                                <div class="single-content wow fadeInUp">
                                    <h3>1. Bảng báo giá xây nhà trọn gói tại TITAN [Mới Nhất 2024] </h3>
                                    <div class="centered">
                                        <img src="WebPages/ViewWebPage/img/quotation-full-3.jpg" alt="Quotation Image">
                                    </div>

                                    <p><strong>Tùy thuộc vào từng loại nhà thi công mà gia chủ lựa chọn, đơn giá xây nhà trọn gói tại TITAN được chia thành 3 nhóm chính như sau (chưa bao gồm vật tư hoàn thiện):</strong></p>
                                    <ul>
                                        <c:forEach items="${requestScope.list}" var="i">
                                            <c:if test="${i.service.id eq 2}"><li><strong>Công trình ${i.houseType.name} ${i.style.name}</strong>: Giá thi công trọn gói giao động từ <strong><fmt:formatNumber value="${i.price1}" pattern="###,###,###" /></strong> đến <strong><fmt:formatNumber value="${i.price2}" pattern="###,###,###" /> đ/m²</strong>.</li></th></c:if>
                                            </c:forEach>
                                    </ul>
                                    <h4>Bảng giá xây nhà trọn gói</h4>
                                    <table border="1">
                                        <thead>
                                            <tr>
                                                <c:forEach items="${requestScope.list}" var="i">
                                                    <c:if test="${i.service.id eq 2}"><th>${i.houseType.name} ${i.style.name}</th></c:if>
                                                    </c:forEach>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <c:forEach items="${requestScope.list}" var="i">
                                                    <c:if test="${i.service.id eq 2}"><td>Từ <fmt:formatNumber value="${i.price1}" pattern="###,###,###" /> đến <fmt:formatNumber value="${i.price2}" pattern="###,###,###" /> đ/m²</td></c:if>
                                                </c:forEach>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <p><strong>Một số loại vật tư báo giá xây dựng nhà trọn gói phần thô mà TITAN sử dụng như</strong>: Gạch, cát, xi măng, đá, sắt thép, dây diện, ống nước, chống thấm … vv.</p>
                                    <h4>Vật tư trọn gói</h4>
                                    <table class="table" border="1" id="materialtable">
                                        <thead>
                                            <tr>
                                                <th>Vật tư phần thô</th>
                                                <th>Giá</th>
                                                <th>Loại</th>
                                                <th>Hình ảnh</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requestScope.mat}" var="i">
                                                <tr>
                                                    <td>${i.name}</td>
                                                    <td><fmt:formatNumber value="${i.price}" pattern="###,###,###"/>đ</td>
                                                    <td>${i.category}</td>
                                                    <td><img src="img/${i.link}" alt="${i.name}" width="100" height="100"></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <!--<p><strong>Một số loại vật tư hoàn thiện nhà trọn gói mới mà TITAN sử dụng bao gồm</strong>: Gạch men, cửa các loại, thạch cao, đá hoa cương, lan can, tủ bếp, sơn nước, thiết bị chiếu sáng, thiết bị wc và nhà bếp … vv.</p>-->
                                    <table border="1">
                                        <thead>
                                            <tr>
                                                <th>Hình ảnh</th>
                                                <th>Vật tư hoàn thiện</th>
                                                <th>Nhóm vật tư phổ biến</th>
                                                <th>Nhóm vật tư tốt</th>
                                                <th>Nhóm vật tư cao cấp</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Gạch lát nền nhà</td>
                                                <td>150,000 đ/m2 - 180,000 đ/m2</td>
                                                <td>200,000 đ/m2 - 250,000 đ/m2</td>
                                                <td>250,000 đ/m2 - 350,000 đ/m2</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <p><strong>Lưu ý:</strong></p>
                                    <ul>
                                        <li><strong>Giá xây nhà trọn gói</strong> trên đây mới áp dụng cho công trình nhà phố có tổng diện tích từ 200m2 đường hẻm vận chuyển vật tư từ 5m trở lên.</li>
                                        <li>Để có thể nhận được một báo giá cụ thể, chi tiết và chính xác hơn, TITAN khuyến khích chủ đầu tư nên liên hệ trực tiếp công ty để được tư vấn kỹ hơn về pháp lý, thiết kế, thi công, để đảm bảo đầy đủ công năng sử dụng, cũng như mang lại một công trình có tính thẩm mỹ cao hơn, phù hợp hơn.</li>
                                        <li>Những vật tư mà chúng tôi sử dụng để xây dựng nên một ngôi nhà đều là những vật tư chất lượng và có thương hiệu uy tín ổn định trên thị trường.</li>
                                    </ul>
                                </div>
                            </section>

                            <section id="section-2">
                                <div class="single-content wow fadeInUp">
                                    <h3>2. Vậy dịch vụ xây nhà trọn gói là gì?</h3>
                                    <div class="centered">
                                        <img src="WebPages/ViewWebPage/img/quotation-full-1.jpg" alt="Quotation Image">
                                    </div>

                                    <p><strong>Xây nhà trọn gói </strong>(hay còn gọi là chìa khóa trao tay) là một loại dịch vụ xây dựng nhà mà chủ đầu tư sẽ giao toàn bộ công việc cho nhà thầu. Từ việc lên ý tưởng sơ bộ, thiết kế hồ sơ chi tiết thi công, xin giấy phép xây dựng, thi công phần thô, thi công phần hoàn thiện, bàn giao cho khách hàng, bảo hành sau thi công.</p>

                                    <p>Chính vì tiện ích của <strong>dịch vụ xây nhà trọn gói</strong> này, mà chủ đầu tư không phải quá khó khăn trong công việc tìm kiếm ý tưởng thiết kế dành cho ngôi nhà của mình, hay mất nhiều thời gian cho các tờ giấy, thủ tục liên quan, cũng như giám sát đội ngũ thi công và không thiếu hụt nguyên vật liệu … vv.</p>
                                </div>
                            </section>

                            <section id="section-3">
                                <div class="single-content wow fadeInUp">
                                    <h3>3. Ưu điểm của dịch vụ xây nhà trọn gói</h3>
                                    <div class="centered">
                                        <img src="WebPages/ViewWebPage/img/Xay-nha-tron-goi-tai-My-Loc.jpeg" alt="Quotation Image">
                                    </div>

                                    <p>Đây là một loại hình xây dựng được hầu hết mọi người đang áp dụng hiện nay. Dịch vụ này có rất nhiều ưu điểm, cũng như phù hợp với nhịp sống nhanh, hiện đại ngày nay như thời gian xây dựng nhà nhanh, tiết kiệm công sức hiệu quả, đảm bảo kỹ thuật và tính thẩm mỹ cao, hạn chế được các chi phí phát sinh trong quá trình xây nhà trọn gói, vật tư đúng chất lượng cam kết từ nhà thầu, và cụ thể chi tiết từng ưu điểm của dịch vụ xây nhà trọn gói xem ngay bên dưới:</p>
                                    <ul>
                                        <li><strong>Rút ngắn thời gian xây dựng công trình: </strong>Đây là một trong những lợi ích dễ có thể nhận thấy nhất. Bởi khi chúng ta đã giao cho công ty xây dựng nhà trọn gói uy tín thì tất cả các hạng mục đều được triển khai nhịp nhàng, theo tuần tự hợp lý, từ việc thiết kế bản vẽ thi công, xin phép xây dựng, cho đến khi ngôi nhà hoàn thiện. Dĩ nhiên, điều này có được là nhờ vào những kinh nghiệm thi công từ nhiều công trình đúc kết được của đơn vị xây dựng. Vì thế, thời gian xây dựng sẽ được rút ngắn.</li>
                                        <li><strong>Tiết kiệm công sức hiệu quả:</strong> Trong quá trình thi công, công ty xây dựng nhà trọn gói cũng là người cam kết quản lý tất cả các vấn đề như: Giám sát quá trình thi công công trình, quản lý vật tư xây dựng, quản lý nhân công,… Nếu quý khách không chọn dịch vụ xây dựng nhà trọn gói thì khi đó quý khách phải bỏ thời gian ra làm hết những công việc trên, như vậy mất thời gian, công sức của quý khách mà đặc biệt không tối ưu đồng bộ tất cả các khâu trong quá trình xây dựng.</li>
                                        <li><strong>Đảm bảo yêu cầu kỹ thuật, chất lượng công trình và tính thẩm mỹ cao:</strong> Hiện nay, cũng có một số ít chủ đầu tư tự lên ý tưởng thiết kế, thuê nhân công xây dựng và mua vật tư cũng như lo các pháp lý liên quan để thi công ngôi nhà cho mình. Tuy nhiên, khi bắt tay vào xây dựng, thì phát sinh rất nhiều vấn đề không lường trước được. Ví dụ như công việc phân bổ không gian sống không hợp lý, không kiểm soát được chất lượng thi công, hay không biết giải quyết các vấn đề về kỹ thuật như thế nào, pháp lý rắc rối từ thủ tục cấp phép xây dựng, chuẩn bị hồ sơ nộp cho các cơ quan chức năng khi thi công xây dựng. Nhưng tất cả các vấn đề trên khi giao cho nhà thầu xây nhà trọn gói uy tín thì mọi thứ được xử lý một cách gọn gàng, nhanh chóng.</li>
                                        <li><strong>Hạn chế các chi phí phát sinh:</strong> Trong quá trình xây dựng, chủ đầu tư sẽ vô cùng bối rối khi nhận thấy nhiều khoản chi phí phát sinh ngoài dự kiến. Quản lý vật tư, quản lý nhân công không chặt chẽ gây lãng phí…vv, nhưng khi sử dụng dịch vụ trọn gói, đơn vị thi công sẽ báo giá xây nhà trọn gói một cách chi tiết nhất dành cho khách hàng, hạn chế tối đa tình trạng phát sinh (khoản chi phí tăng không nằm trong kế hoạch ban đầu). Chính vì vậy việc lựa chọn dịch vụ này có thể là một phương án hiệu quả dành cho chủ đầu tư.</li>
                                        <li><strong>Vật tư Đảm bảo đúng chất lượng: </strong>Ngoài những ưu điểm về thời gian, chi phí, công sức đồng thời nhận được sự tư vấn và hỗ trợ từ phía công ty, thì dịch vụ còn đảm bảo về vật liệu xây dựng đạt chất lượng. Do đó, nếu như đã tìm cho mình được một công ty xây nhà trọn gói uy tín, bạn hoàn toàn có thể yên tâm về ngôi nhà trong tương lai của mình, đảm bảo chất lượng như đã cam kết.</li>
                                    </ul>
                                </div>
                            </section>

                            <section id="section-4">
                                <div class="single-content wow fadeInUp">
                                    <h3>4. Cách tính diện tích xây dựng trọn gói 2024</h3>
                                    <ul>
                                        <li>Phần móng đơn: Tính 30% diện tích đất.</li>
                                        <li>Phần móng ép cọc: Tính 50% diện tích đất.</li>
                                        <li>Phần móng băng: Tính 70% diện tích đất.</li>
                                        <li>Tầng trệt: Tính 100% diện tích xây dựng tầng trệt.</li>
                                        <li>Tầng, lầu 1, 2, 3…: Tính 100% diện tích tầng, lầu 1, 2, 3,…</li>
                                        <li>Tầng mái bê tông cốt thép, sân thượng: Tính 50% diện tích xây dựng diện tích mái, sân thượng.</li>
                                        <li>Mái bằng, đúc : tính 30% diện tích xây dựng mái (Bao gồm tôn + xà gồ).</li>
                                        <li>Mái kèo thép lợp ngói: tính 60% diện tích xây dựng tầng trệt</li>
                                        <li>Mái thái: tính 80% diện tích xây dựng tầng trệt</li>
                                    </ul>
                                    <p><strong>Lưu ý:</strong></p>
                                    <ul>
                                        <li>Chưa tính chi phí vật tư hoàn thiện</li>
                                        <li>Phần tính móng chưa bao gồm đổ bê tông cốt thép nền tầng trệt. Nếu chủ đầu tư yêu cầu tính bù giá 350.000 đ/m2 (sắt phi 8@200, 1 lớp, bê tông đá 1×2 M250 dày 6 – 8cm).</li>
                                        <li>Đơn giá thi công phần thô chưa tính chi phí ép cọc.</li>
                                    </ul>
                                </div>
                            </section>

                            <section id="section-5">
                                <div class="single-content wow fadeInUp">
                                    <h3>5. Tiêu chí khi chọn đơn vị báo giá xây nhà trọn gói năm 2024</h3>
                                    <div class="centered">
                                        <img src="WebPages/ViewWebPage/img/cach-tinh-chi-phi-xay-biet-thu-tron-goi.jpg" alt="Quotation Image">
                                    </div>

                                    <p><strong>Làm cách nào để có thể lựa chọn được một công ty xây nhà uy tín? Hay có những tiêu chí nào trong việc lựa chọn cho mình một đơn vị có dịch vụ xây nhà chuyên nghiệp? Bạn có thể tham khảo một số tiêu chí dưới đây:</strong></p>
                                    <ul>
                                        <li><strong>Chọn công ty có kinh nghiệm lâu năm:</strong> Việc xây dựng nhà là một quá trình chuẩn bị khoản đầu tư không hề nhỏ. Ngôi nhà sẽ theo ta đi đến hết cuộc đời. Chính vì thế mà trong việc lựa chọn một đơn vị đồng hành kiến tạo nên ngôi nhà, chủ đầu tư cần lựa chọn nhà thầu uy tín, có nhiều kinh nghiệm.</li>
                                        <li><strong>Công ty có phản hồi tốt của các khách hàng cũ: </strong> Có thể nói những đánh giá của các khách hàng cũ chính là một trong những “bằng chứng” hữu ích nhất đối với chúng ta, trong việc đánh giá những sản phẩm mà đơn vị  xây dựng có chất lượng hay không.</li>
                                        <li><strong>Công ty cung cấp Đa dạng dịch vụ:</strong> Thông thường, các công ty xây dựng chuyên nghiệp sẽ cung cấp đa dạng, đầy đủ tất cả các dịch vụ từ thiết kế, xin phép, thi công, pháp lý liên quan, khách hàng không cần phải bận tâm bất cứ vấn đề gì.</li>
                                        <li><strong>Kiến trúc sư, kỹ sư chuyên môn cao: </strong>Những công trình mà công ty đã thiết kế, thi công dành cho khách hàng trước sẽ là một trong nhiều yếu tố để khách hàng có thể tin tưởng và lựa chọn đồng hành cùng mình.</li>
                                        <li><strong>Chi phí xây dựng phù hợp: </strong>Hiện nay, hầu hết các công ty xây dựng đều cung cấp dịch vụ báo giá xây nhà trọn gói tại tphcm. Tuy nhiên, chủ đầu tư không nên chỉ cân nhắc mình yếu tố giá mà phải song song cả vấn đề chất lượng (Thiết kế chuyên nghiệp, vật tư chất lượng, thi công đảm bảo kỹ thuật). Bởi trong quá trình “thiết kế” và “xây dựng” sẽ phát sinh nhiều vấn đề có thể không lường trước được nên cần có một đơn vị xây dựng chuyên nghiệp để hỗ trợ và xử lý các vấn đề phát sinh khi đó.</li>
                                        <li><strong>Điều khoản xây dựng minh bạch, rõ ràng: </strong>Cam kết của công ty đối với khách hàng cũng vô cùng quan trọng. Điều này cần ghi rõ trong các điều khoản trong hợp đồng thiết kế hay thi công, minh bạch và rõ ràng trong khâu vật tư sử dụng, chịu trách nhiệm về các vấn đề liên quan hay phát sinh trong quá trình thi công công trình.</li>
                                    </ul>
                                </div>
                            </section>

                            <section id="section-6">
                                <div class="single-content wow fadeInUp">
                                    <h3>6. Một số hạng mục thi công xây nhà trọn gói 2024</h3>
                                    <div class="centered">
                                        <img src="WebPages/ViewWebPage/img/quotation-full-2.jpg" alt="Quotation Image">
                                    </div>

                                    <p><strong>Phần xây dựng Phần thô</strong></p>
                                    <ul>
                                        <li>Tổ chức dọn dẹp mặt bằng công trường, làm lán trại cho công nhân (nếu mặt bằng thi công cho phép).</li>
                                        <li>Bắn tọa độ xác định ranh mốc đất và vị trí xây dựng, định vị tim ép cọc (nếu có), tim móng, cột.</li>
                                        <li>Triển khai thi công ép cọc (nếu có). </li>
                                        <li>Đào đất móng, dầm móng, đà kiềng, hầm phân, bể nước và vận chuyển đất đã đào đi đổ.</li>
                                        <li>Đập đầu cọc BTCT (nếu có).</li>
                                        <li>Đổ bê tông đá 4×6 mác 100 dày 100mm đáy móng, dầm móng, đà kiềng.</li>
                                        <li>Xây đài móng, dầm móng nếu là móng cọc.</li>
                                        <li>Sản xuất lắp dựng cốt thép, coffa và đổ bê tông móng, dầm móng, đà kiềng.</li>
                                        <li>Sản xuất lắp dựng cốt thép, coffa và đổ bê tông đáy, nắp hầm phân, hố ga.</li>
                                        <li>Sản xuất lắp dựng cốt thép, coffa và đổ bê tông cột, dầm, sàn các tầng lầu, sân thượng mái.</li>
                                        <li>Sản xuất, lắp dựng cốt thép, coffa và đổ bê tông cầu thang và xây bậc bằng gạch thẻ.</li>
                                        <li>Xây toàn bộ tường bao, tường ngăn chia phòng, vệ sinh toàn bộ công trình.</li>
                                        <li>Tô vách toàn bộ công trình và hoàn thiện thi công mặt tiền (Không bao gồm tô trần, đà, bậc thang và các vị trí ốp lát đá hoa cương).</li>
                                        <li>Cán nền các tầng lầu, sân thượng, mái, ban công, nhà vệ sinh.</li>
                                        <li>Chống thấm sàn sân thượng, vệ sinh, mái, ban công.</li>
                                        <li>Lắp đặt hệ thống đường ống cấp và thoát nước nóng lạnh.</li>
                                        <li>Lắp đặt hệ thống đường dây điện chiếu sáng, đế âm, hộp nối.</li>
                                        <li>Lắp đặt hệ thống đường dây truyền hình cáp, internet.</li>
                                    </ul>
                                    <p><strong>Phần xây dựng hoàn thiện</strong></p>
                                    <ul>
                                        <li>Ốp lát gạch toàn bộ nền nhà, len chân tường, gạch nền, gạch tường vệ sinh theo bản vẽ thiết kế.</li>
                                        <li>Lát đá cầu thang, đá bếp, ngạch cửa, tam cấp, mặt tiền (Nếu có).</li>
                                        <li>Lắp toàn bộ cửa chính, cửa phòng, cửa sổ, cửa ban công, cửa sân thượng, cửa cổng, cửa vệ sinh.</li>
                                        <li>Lắp dựng lan can cầu thang, lan can mặt tiền, lan can tầng lửng (Nếu có).</li>
                                        <li>Đóng trần thạch cao các phòng, hành lang, ban công.</li>
                                        <li>Sơn nước toàn bộ ngôi nhà.</li>
                                        <li>Lắp đặt bồn nước, thiết bị vệ sinh (lắp đặt lavabo, bồn cầu, van khóa, vòi sen, vòi nóng lạnh, gương soi và các phụ kiện wc).</li>
                                        <li>Lắp đặt hệ thống điện và đèn chiếu sáng (lắp đặt công tắc, ổ cắm, tủ điện, CB, quạt hút, đèn trang trí, đèn chiếu sáng, đèn lon, đèn LED dây).</li>
                                        <li>Lợp mái ngói, mái tole (nếu có).</li>
                                        <li>Vệ sinh công nghiệp công trình trước khi bàn giao.</li>
                                    </ul>
                                    <p><strong>Khi nào thì đơn giá xây nhà phần thô thay đổi?</strong></p>
                                    <ul>
                                        <li>Diện tích xây dựng nhỏ.</li>
                                        <li>Tổng diện tích nhỏ.</li>
                                        <li>Đường vào công trình nhỏ hơn 5m.</li>
                                        <li>Điều kiện thi công khó khăn.</li>
                                        <li>Dạng công trình (Nhà phố, biệt thự hiện đại, biệt thự cổ điển).</li>
                                    </ul>
                                </div>
                            </section>

                            <section id="section-7">
                                <div class="single-content wow fadeInUp">
                                    <h3>7. Quy trình báo giá xây nhà trọn gói của TITAN [Mới nhất 2024]</h3>
                                    <p><strong>TITAN cung cấp các dịch vụ liên quan đến thiết kế và thi công xây dựng, cam kết hướng đến chất lượng tốt nhất dành cho khách hàng, với quy trình làm việc như sau:</strong></p>
                                    <ul>
                                        <li>Bước 1: Tiếp nhận thông tin</li>
                                        <li>Bước 2: Tư vấn sơ bộ về dịch vụ xây nhà trọn gói TITAN</li>
                                        <li>Bước 3: Thiết kế mặt bằng sơ bộ</li>
                                        <li>Bước 4: Gửi bảng báo giá xây nhà trọn gói</li>
                                        <li>Bước 5: Trao đổi bổ sung</li>
                                        <li>Bước 6: Ký hợp đồng</li>
                                        <li>Bước 7: Xin phép xây dựng</li>
                                        <li>Bước 8: Thiết kế bản vẽ</li>
                                        <li>Bước 9: Tiến hành thi công</li>
                                        <li>Bước 10: Nghiệm thu các giai đoạn</li>
                                        <li>Bước 11: Bàn giao nhà</li>
                                        <li>Bước 12: Bảo hành sau thi công</li>
                                    </ul>
                                    <p><strong>Quy trình làm việc ở dịch vụ xây nhà trọn gói hay bất kì các dịch vụ khác của chúng tôi đều thể hiện sự chuyên nghiệp trong cách làm việc, tạo cảm giác tin tưởng dành cho khách hàng đồng hành cùng công ty.</strong></p>
                                </div>
                            </section>

                            <section id="section-8">
                                <div class="single-content wow fadeInUp">
                                    <h3>8. TITAN cam kết dịch vụ xây nhà trọn gói 2024</h3>
                                    <p><strong>Để có thể nhận được niềm tin của khách hàng, TITAN luôn thực hiện đúng những cam kết khi xây dựng nhà trọn gói mà chúng tôi đề ra:</strong></p>
                                    <ul>
                                        <li>Quá trình tư vấn, khảo sát cũng như báo giá thật chi tiết.</li>
                                        <li>Tư vấn tận tâm, nhiệt tình, trách nhiệm các công việc phát sinh.</li>
                                        <li>Hỗ trợ pháp lý đầy đủ: Xử lý và cung cấp tất cả các giấy tờ, thủ tục, vấn đề liên quan đến quá trình thiết kế, xin phép, thi công.</li>
                                        <li>Đội ngũ thiết kế chuyên nghiệp.</li>
                                        <li>Trực tiếp thi công công trình: Đội ngũ nhân công tay nghề cao.</li>
                                        <li>Giám sát nhiều kinh nghiệm: giám sát chặt chẽ tất cả các khâu trong quá trình thi công.</li>
                                        <li>Vật tư đúng chất lượng: Đảm bảo chất lượng công trình.</li>
                                        <li>Thi công đúng tiến độ: Đảm bảo thời gian thi công theo cam kết.</li>
                                        <li>Chính sách hậu mãi tốt, bảo hành uy tín.</li>
                                    </ul>
                                </div>
                            </section>

                            <!-- Add more sections as needed -->
                        </article>
                    </main>








                </div>
            </div>
            <!-- Portfolio End -->


            <jsp:include page="../../WebPages/ViewWebPage/Footer.jsp"/>

            <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        </div>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/easing/easing.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/wow/wow.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/isotope/isotope.pkgd.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/lightbox/js/lightbox.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/waypoints/waypoints.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/counterup/counterup.min.js"></script>
        <script src="WebPages/ViewWebPage/lib/slick/slick.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
        <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function() {
                $('#materialtable').DataTable();
            });
        </script>
        <!-- Template Javascript -->
        <script src="WebPages/ViewWebPage/js/main.js"></script>
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var toggleButton = document.getElementById('toggle-contents');
                var tableOfContents = document.getElementById('table-of-contents');

                // Ẩn mục lục khi trang được tải lần đầu
                tableOfContents.style.display = 'none';

                toggleButton.addEventListener('click', function () {
                    if (tableOfContents.style.display === 'none' || tableOfContents.style.display === '') {
                        tableOfContents.style.display = 'block';
                    } else {
                        tableOfContents.style.display = 'none';
                    }
                });
            });
        </script>
    </body>
</html>