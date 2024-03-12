<%-- 
    Document   : rawContructionPrice
    Created on : Feb 2, 2024, 12:07:50 PM
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
        <title>TITAN - Bảng Giá Xây Nhà Phần Thô</title>
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
                            <h2>Bảng Giá Xây Nhà Phần Thô</h2>
                        </div>
                        <div class="col-12">
                            <a href="index">Trang Chủ</a>
                            <a href="">Bảng Giá Xây Nhà Phần Thô</a>
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
                            <div class="single-content wow fadeInUp">
                                <button class="dropdown-toggle" id="toggle-contents">Nội dung chính</button>
                            </div>

                            <ul id="table-of-contents">
                                <li><a href="#section-1">1. Vậy xây dựng phần thô là gì?</a></li>
                                <li><a href="#section-2">2. Ưu và nhược điểm của dịch vụ xây dựng phần thô</a></li>
                                <li><a href="#section-3">3. Một số hạng mục công việc kèm theo báo giá xây dựng phần thô 2024</a></li>
                                <li><a href="#section-4">4. Cách tính diện tích xây dựng phần thô 2024</a></li>
                                <li><a href="#section-5">5. Cách tính giá xây dựng phần thô 2024</a></li>
                                <li><a href="#section-6">6. Một số lưu ý về thi công, báo giá xây dựng nhà phần thô 2024</a></li>
                                <li><a href="#section-7">7. Quy trình thi công xây dựng phần thô TITAN</a></li>
                                <li><a href="#section-8">8. Cam Kết của TITAN khi thi công, báo giá xây dựng phần thô 2024</a></li>

                            </ul>

                            <section id="section-1">
                                <div class="single-content wow fadeInUp">
                                    <h3>1. Vậy xây dựng phần thô là gì?</h3>
                                    <div class="centered">
                                        <img src="WebPages/ViewWebPage/img/quotation-raw-1.jpg" alt="Quptation Image">
                                    </div>
                                    <p>Xây dựng phần thô được hiểu là việc thi công định hình phần khung sườn cho ngôi nhà bao gồm phần móng và bể ngầm; Các hệ thống kết cấu chịu lực (như cột, dầm, khung, sàn, bê tông,…); Phần cầu thang; Bản và bậc; Hệ thống tường bao che, ngăn phòng…vv.</p>
                                    <p>Đây là giai đoạn hết sức quan trọng bởi nó quyết định đến độ an toàn, chắc chắn của công trình. Phần thô càng tốt, càng chuẩn, chính xác thì những phần thi công sau này càng thuận lợi như tiết kiệm thời gian và chi phí, hạn chế tối đa những ảnh hưởng đến chất lượng công trình.</p>
                                    
                                    <p>Bảng giá xây dựng phần thô được TITAN cung cấp dưới đây sẽ giúp quý khách hàng có thể ước lượng được chi phí xây dựng phần thô, xây tổ ấm của mình một cách dễ dàng, nhanh chóng. Bảng giá được chia làm 3 hạng mục công trình cơ bản:</p>
                                    <ul>
                                        <c:forEach items="${requestScope.list}" var="i">
                                            <c:if test="${i.service.id eq 1}"><li><strong>Công trình ${i.houseType.name} ${i.style.name}</strong>: Giá thi công phần thô giao động từ <strong><fmt:formatNumber value="${i.price1}" pattern="###,###,###" /></strong> đến <strong><fmt:formatNumber value="${i.price2}" pattern="###,###,###" /> đ/m²</strong>.</li></th></c:if>
                                            </c:forEach>

                                    </ul>
                                    <h4>Bảng giá xây nhà phần thô</h4>
                                    <table border="1">
                                        <thead>
                                            <tr>
                                                <c:forEach items="${requestScope.list}" var="i">
                                                    <c:if test="${i.service.id eq 1}"><th>${i.houseType.name} ${i.style.name}</th></c:if>
                                                    </c:forEach>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <c:forEach items="${requestScope.list}" var="i">
                                                    <c:if test="${i.service.id eq 1}"><td>Từ <fmt:formatNumber value="${i.price1}" pattern="###,###,###" /> đến <fmt:formatNumber value="${i.price2}" pattern="###,###,###" /> đ/m²</td></c:if>
                                                </c:forEach>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <table class="table" border="1">
                                        <thead>
                                            <tr>
                                                <th>Vật tư phần thô</th>
                                                <th>Nhà phố hiện đại</th>
                                                <th>Biệt thự hiện đại</th>
                                                <th>Biệt thự cổ điển</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Cát đổ bê tông</td>
                                                <td>Cát hạt lớn</td>
                                                <td>Cát hạt lớn</td>
                                                <td>Cát hạt lớn</td>
                                            </tr>
                                            <tr>
                                                <td>Gạch ống, gạch đinh</td>
                                                <td>Tuynel Đồng Nai, Bình Dương</td>
                                                <td>Tuynel Đồng Nai, Bình Dương</td>
                                                <td>Tuynel Đồng Nai, Bình Dương</td>
                                            </tr>
                                            <tr>
                                                <td>Cát xây tường, tô tường, cán nền</td>
                                                <td>Cát hạt trung</td>
                                                <td>Cát hạt trung</td>
                                                <td>Cát hạt trung</td>
                                            </tr>
                                            <tr>
                                                <td>Đá 1x2 đổ bê tông</td>
                                                <td>Đá Đồng Nai</td>
                                                <td>Đá Đồng Nai</td>
                                                <td>Đá Đồng Nai</td>
                                            </tr>
                                            <tr>
                                                <td>Xi măng xây tường, tô tường cán nền</td>
                                                <td>Hà Tiên</td>
                                                <td>Hà Tiên</td>
                                                <td>Hà Tiên</td>
                                            </tr>
                                            <tr>
                                                <td>Xi măng đổ bê tông</td>
                                                <td>Holcim</td>
                                                <td>Holcim</td>
                                                <td>Holcim</td>
                                            </tr>
                                            <tr>
                                                <td>Sắt thép</td>
                                                <td>Việt Nhật - Pomina</td>
                                                <td>Việt Nhật - Pomina</td>
                                                <td>Việt Nhật - Pomina</td>
                                            </tr>
                                            <tr>
                                                <td>Dây điện</td>
                                                <td>Cadivi</td>
                                                <td>Cadivi</td>
                                                <td>Cadivi</td>
                                            </tr>
                                            <tr>
                                                <td>Dây cáp internet</td>
                                                <td>Nano</td>
                                                <td>Nano</td>
                                                <td>Nano</td>
                                            </tr>
                                            <tr>
                                                <td>Dây cáp tivi</td>
                                                <td>Sino</td>
                                                <td>Sino</td>
                                                <td>Sino</td>
                                            </tr>
                                            <tr>
                                                <td>Đế âm tường, ống luồn dây điện</td>
                                                <td>Sino</td>
                                                <td>Sino</td>
                                                <td>Sino</td>
                                            </tr>
                                            <tr>
                                                <td>Đường nước cấp nước, thoát nước (nước lạnh)</td>
                                                <td>Bình Minh</td>
                                                <td>Bình Minh</td>
                                                <td>Bình Minh</td>
                                            </tr>
                                            <tr>
                                                <td>Đường nước cấp nước, thoát nước (nước nóng)</td>
                                                <td>Bình Minh</td>
                                                <td>Bình Minh</td>
                                                <td>Vesbo</td>
                                            </tr>
                                            <tr>
                                                <td>Chống thấm WC, ban công, sân thượng, mái bê tông</td>
                                                <td>CT11A</td>
                                                <td>CT11A</td>
                                                <td>CT11A</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <ul>
                                        <li><a href="fullContructionPrice.html"><strong>Xem thêm bảng giá trọn gói tại đây</strong></a> </li>
                                    </ul>
                                </div>
                            </section>

                            <section id="section-2">
                                <div class="single-content wow fadeInUp">
                                    <h3>2. Ưu và nhược điểm của dịch vụ xây dựng phần thô</h3>
                                    <div class="centered">
                                        <img src="WebPages/ViewWebPage/img/thi-cong-cot-pha.jpg" alt="Quotation Image">
                                    </div>
                                    <p><strong>Ưu điểm: </strong></p>
                                    <ul>
                                        <li>Chủ đầu tư có thể chủ động lựa chọn loại vật liệu hoàn thiện cũng như nguồn cung cấp mà mình mong muốn mà không phụ thuộc vào nhà thầu. Việc này đòi hỏi chủ đầu tư phải biết cách lựa chọn thương hiệu, cân nhắc giá, chất lượng vật liệu và cung cấp kịp thời cho công trình (Tiêu chí này nếu không phải bạn có làm công việc liên quan về vật tư hoàn thiện thì rất khó để bạn có kinh nghiệm và nắm bắt được giá cả cũng như chất lượng vật tư).</li>
                                    </ul>
                                    <p><strong>Nhược điểm: </strong></p>
                                    <ul>
                                        <li>Việc tự lựa chọn vật liệu hoàn thiện sẽ tiêu tốn rất nhiều thời gian và công sức của chủ đầu tư, làm ảnh hưởng tới sinh hoạt cuộc sống cũng như chất lượng công việc.</li>
                                        <li>Nếu chủ đầu tư không có hiểu biết sâu về nguyên vật liệu xây dựng và giá cả thị trường thì có thể gây lãng phí, thậm chí chi phí còn cao hơn cả dịch vụ xây dựng trọn gói.</li>
                                    </ul>
                                    <p>Vì vậy, nếu bạn là người am hiểu về xây dựng và tự tin trong việc lựa chọn vật liệu hoàn thiện thì có thể chọn xây nhà phần thô. Còn ngược lại nên chọn hình thức xây nhà trọn gói để tránh những rủi ro có thể xảy ra.</p>
                                </div>
                            </section>

                            <section id="section-3">
                                <div class="single-content wow fadeInUp">
                                    <h3>3. Một số hạng mục công việc kèm theo báo giá xây dựng phần thô 2024</h3>
                                    <div class="centered">
                                        <img src="WebPages/ViewWebPage/img/thi-cong-phan-tho-nha-pho.jpg" alt="Quotation Image">
                                    </div>
                                    <p><strong>Phần xây dựng phần thô (TITAN cung cấp vật liệu và nhân công)</strong></p>
                                    <ul>
                                        <li>Tổ chức dọn dẹp mặt bằng công trường, làm lán trại cho công nhân (nếu mặt bằng thi công cho phép).</li>
                                        <li>Bắn tọa độ xác định ranh mốc đất và vị trí xây dựng, định vị tim móng, cột.</li>
                                        <li>Đào đất móng, dầm móng, đà kiềng, hầm phân, bể nước và vận chuyển đất đã đào đi đổ.</li>
                                        <li>Đập đầu cọc BTCT (nếu có).</li>
                                        <li>Đổ bê tông đá 4×6 mác 100 dày 100mm đáy móng, dầm móng, đà kiềng.</li>
                                        <li>Xây đài móng, dầm móng nếu là móng cọc.</li>
                                        <li>Sản xuất lắp dựng cốt thép, coffa và đổ bê tông móng, dầm móng, đà kiềng.</li>
                                        <li>Sản xuất lắp dựng cốt thép, coffa và đổ bê tông đáy, nắp hầm phân, hố ga.</li>
                                        <li>Sản xuất lắp dựng cốt thép, coffa và đổ bê tông cột, dầm, sàn các tầng lầu, sân thượng mái.</li>
                                        <li>Sản xuất, lắp dựng cốt thép, coffa và đổ bê tông cầu thang và xây bậc bằng gạch thẻ.</li>
                                        <li>Xây toàn bộ tường bao, tường ngăn chia phòng, vệ sinh toàn bộ công trình.</li>
                                        <li>Tô vách toàn bộ công trình và hoàn thiện thi công mặt tiền.</li>
                                        <li>Cán nền các tầng lầu, sân thượng, mái, ban công, nhà vệ sinh.</li>
                                        <li>Chống thấm sàn sân thượng, vệ sinh, mái, ban công.</li>
                                        <li>Lắp đặt hệ thống đường ống cấp và thoát nước nóng lạnh.</li>
                                        <li>Lắp đặt hệ thống đường dây điện chiếu sáng, đế âm, hộp nối.</li>
                                        <li>Lắp đặt hệ thống đường dây truyền hình cáp, internet.</li>                        
                                    </ul>
                                </div>  
                            </section>

                            <section id="section-4">
                                <div class="single-content wow fadeInUp">
                                    <h3>4. Cách tính diện tích xây dựng phần thô 2024</h3>
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
                                        <li>Phần tính móng chưa bao gồm đổ bê tông cốt thép nền tầng trệt. Nếu chủ đầu tư yêu cầu tính bù giá 350.000 đ/m2 (sắt phi 8@200, 1 lớp, bê tông đá 1×2 M250 dày 6 – 8cm).</li>
                                        <li>Đơn giá thi công phần thô chưa tính chi phí ép cọc.</li>
                                    </ul>
                                </div>
                            </section>

                            <section id="section-5">
                                <div class="single-content wow fadeInUp">
                                    <h3>5. Cách tính giá xây dựng phần thô 2024</h3>
                                    <p>Để giúp quý khách hiểu rõ hơn cũng như dễ dàng dự trù chi phí xây dựng nhà hơn, hãy cùng tham khảo ví dụ mà xây dựng TITAN đưa ra dưới đây.</p>
                                    <p><strong>Chi phí xây dựng phần thô nhà phố 3 tầng 4mx18m:</strong></p>
                                    <p>Khách hàng có một miếng đất diện tích 4mx18m, xây dựng 1 trệt, 2 lầu, sân trước chừa 3m, ban công các lầu 1,2m, thi công móng cọc, mái đổ bê tông giả sử giá xây nhà phần thô tại thời điểm hiện tại nếu mặt bằng thi công thuận lợi là 3,200,000đ/m2 thì cách tính diện và chi phí là:</p>
                                    <ul>
                                        <li><strong>Phần cọc</strong>: tùy khu vực phải khảo sát mới có báo giá chính xác.</li>
                                        <li><strong>Phần móng</strong>: 72m2 x 50% = 36m2 x 3,200,000đ/m2 = 115,200,000đ.</li>
                                        <li><strong>Tầng trệt</strong>: 60m2 x 100% = 60m2 x 3,200,000đ/m2 = 192,000,000đ.</li>
                                        <li><strong>Phần sân trước</strong>: 12m2 x 50% = 6m2 x 3,200,000đ/m2 = 19,200,000.</li>
                                        <li><strong>Lầu 1</strong>: 64.8m2 x 100% = 64.8m2 x 3,200,000đ/m2 = 207,360,000đ.</li>
                                        <li><strong>Lầu 2</strong>: 64.8m2 x 100% = 64.8m2 x 3,200,000đ/m2 = 207,360,000đ.</li>
                                        <li><strong>Phần mái</strong>: 64.8m2 x 50% = 32.4m2 x 3,200,000đ/m2 = 103,680,000đ.</li>
                                    </ul>
                                    <p>Vậy <strong>chi phí ước lượng cho xây nhà phố phần thô nhân công hoàn thiện 3 tầng 4mx18m là: 844,800,000đ</strong> (Tám trăm bốn bốn triệu tám trăm ngàn đồng).</p>
                                </div>
                            </section>

                            <section id="section-6">
                                <div class="single-content wow fadeInUp">
                                    <h3>6. Một số lưu ý về thi công, báo giá xây dựng nhà phần thô 2024</h3>
                                    <div class="centered">
                                        <img src="WebPages/ViewWebPage/img/quotation-raw-2.png" alt="Quotation Image">
                                    </div>
                                    
                                    <p><strong>Xây nhà phần thô</strong> quyết định trực tiếp đến chất lượng công trình, cho nên việc lựa chọn một công ty xây dựng uy tín, chuyên nghiệp để <strong>đảm bảo xây dựng ngôi nhà</strong> chắc chắn và đẹp đồng thời lên dự toán chính xác chi phí xây dựng, cũng như hạn chế tối đa phát sinh chi phí, là những vấn đề quý khách hàng cần lưu ý ngoài ra những vấn đề ảnh hưởng trực tiếp đến đơn giá thi công.</p>
                                    <p><strong>Quy mô công trình nào được áp dụng đơn giá trên theo m2?</strong></p>
                                    <ul>
                                        <li>Công trình có diện tích xây dựng từ 50m2 trở lên.</li>
                                        <li>Công trình có tổng diện tích từ 200m2 trở lên (Tổng diện tích sàn xây dựng).</li>
                                        <li>Công trình có đường hẻm từ 5m (xe tải 5m3 ra vào được).</li>
                                        <li>Mặt bằng tập kết vật tư thuận lợi.</li>
                                    </ul>
                                    <p><strong>Khi nào nên liên hệ trực tiếp nhà thầu để lên dự toán chi tiết?</strong></p>
                                    <ul>
                                        <li>Công trình diện tích xây dựng một sàn nhỏ hơn 50m2. </li>
                                        <li>Có tổng diện tích xây dựng nhỏ hơn 200m2 (Tổng diện tích sàn xây dựng).</li>
                                        <li>Có đường hẻm nhỏ hơn 5m (xe 5m3 không ra vào được).</li>
                                        <li>Mặt bằng tập kết vật tư không thuận lợi.</li>
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
                                    <h3>7. Quy trình thi công xây dựng phần thô TITAN</h3>
                                    <div class="centered">
                                        <img src="WebPages/ViewWebPage/img/quotation-raw-3.jpg" alt="Quotation Image">
                                    </div>
                                    
                                    <p><strong>Là một trong những đơn vị thi công các công trình biệt thự, nhà phố,… TITAN xin gửi lời cảm ơn sâu sắc tới quý khách hàng đã tin tưởng hợp tác cũng như đồng hành cùng công ty trong thời gian qua. Chúng tôi luôn tuân thủ quy trình rõ ràng, chuẩn mực khi làm việc với khách hàng, cụ thể:</strong></p>
                                    <ul>
                                        <li>Tiếp nhận thông tin của khách hàng về nhu cầu xây dựng, vị trí, diện tích, chi phí đầu tư tương ứng,…</li>
                                        <li>Lên lịch hẹn gặp và tiến hành khảo sát tư vấn trực tiếp cho khách hàng.</li>
                                        <li>Nắm bắt, phân tích nhu cầu và lập phương án thiết kế, thi công.</li>
                                        <li>Đưa ra thiết kế kiến trúc sơ bộ.</li>
                                        <li>Lập bảng báo giá chính thức đến khách hàng.</li>
                                        <li>Ký kết hợp đồng thoả thuận xây dựng nhà.</li>
                                        <li>Thiết kế bản vẽ thi công chi tiết và tiến hành xin phép xây dựng.</li>
                                        <li>Thực hiện thi công và giám sát công trình.</li>
                                        <li>Kiểm tra, nghiệm thu chất lượng công trình các giai đoạn thi công.</li>
                                        <li>Nghiệm thu đợt cuối và bàn giao nhà cho khách hàng.</li>
                                        <li>Bảo hành và chăm sóc khách hàng sau thi công.</li>
                                    </ul>
                                </div>
                            </section>

                            <section id="section-8">
                                <div class="single-content wow fadeInUp">
                                    <h3>8. Cam Kết của TITAN khi thi công, báo giá xây dựng phần thô 2024</h3>
                                    <p><strong>Dù là xây nhà phần thô, hay xây nhà trọn gói thì TITAN đều đảm bảo những tiêu chí về chất lượng, thẩm mỹ, cam kết uy tín cùng mức giá phù hợp, mong muốn làm hài lòng quý khách hàng. Sau đây là 10 điều cam kết khi khách hàng lựa chọn TITAN làm đơn vị thi công, báo giá xây dựng phần thô.</strong></p>
                                    <ul>
                                        <li>Tư vấn, khảo sát, báo giá,.. chi tiết, tận tâm.</li>
                                        <li>Không bán thầu, trực tiếp thi công.</li>
                                        <li>Minh bạch trong vật liệu xây dựng, đảm bảo giá cả và chất lượng tốt nhất.</li>
                                        <li>Cam kết đội ngũ thi công giàu kinh nghiệm, trình độ năng lực chuyên môn cao nhằm đem đến cho khách hàng những công trình đẹp, chắc chắn với thời gian.</li>
                                        <li>Giám sát thi công chặt chẽ, nghiệm thu theo từng giai đoạn.</li>
                                        <li>Cam kết hỗ trợ pháp lý đầy đủ, hạn chế phát sinh chi phí tối đa cho chủ đầu tư.</li>
                                        <li>Cam kết bảo hành nhanh chóng, có mặt kịp thời khi khách có yêu cầu về sự cố.</li>
                                        <li>CAM KẾT VỀ THỜI GIAN: Đúng tiến độ, đảm bảo chất lượng công trình tốt nhất, đúng theo thiết kế và phong cách, nhu cầu của khách hàng.</li>
                                        <li>Thái độ làm việc chuyên nghiệp, tôn trọng, lắng nghe ý kiến và hỗ trợ  khách hàng tận tâm.</li>
                                        <li>Đảm bảo thương hiệu uy tín, giá cả hợp lý, dịch vụ chuyên nghiệp.</li>
                                    </ul>
                                </div>
                            </section>
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