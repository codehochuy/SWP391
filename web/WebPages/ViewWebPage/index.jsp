<%-- 
    Document   : index
    Created on : Feb 2, 2024, 12:02:55 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>TITAN - Trang Chủ</title>
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
    </head>
    <body>
    <div class="wrapper">
        <jsp:include page="../../WebPages/ViewWebPage/HeaderPage.jsp"/>


        <!-- Carousel Start -->
        <div id="carousel" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carousel" data-slide-to="0" class="active"></li>
                <li data-target="#carousel" data-slide-to="1"></li>
                <li data-target="#carousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="WebPages/ViewWebPage/img/carousel-1.jpg" alt="Carousel Image">
                    <div class="carousel-caption">
                        <p class="animated fadeInRight">Thiết Kế Xây Nhà Chắc</p>
                        <h1 class="animated fadeInLeft">Vững Bước Thành Công</h1>
                        <a class="btn animated fadeInUp" href="#">Nhận Báo Giá</a>
                    </div>
                </div>

                <div class="carousel-item">
                    <img src="WebPages/ViewWebPage/img/carousel-2.jpg" alt="Carousel Image">
                    <div class="carousel-caption">
                        <p class="animated fadeInRight">Xây Vững Niềm Tin</p>
                        <h1 class="animated fadeInLeft">Dựng Uy Tín Vàng</h1>
                        <a class="btn animated fadeInUp" href="#">Nhận Báo Giá</a>
                    </div>
                </div>

                <div class="carousel-item">
                    <img src="WebPages/ViewWebPage/img/carousel-3.jpg" alt="Carousel Image">
                    <div class="carousel-caption">
                        <p class="animated fadeInRight">Thiết Kế Nhà Chất Lượng Là Sứ Mệnh</p>
                        <h1 class="animated fadeInLeft">Thành Công Là Điểm Đến</h1>
                        <a class="btn animated fadeInUp" href="#">Nhận Báo Giá</a>
                    </div>
                </div>
            </div>

            <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- Carousel End -->


        <!-- Feature Start-->
        <div class="feature wow fadeInUp" data-wow-delay="0.1s">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-lg-4 col-md-12">
                        <div class="feature-item">
                            <div class="feature-icon">
                                <i class="flaticon-worker"></i>
                            </div>
                            <div class="feature-text">
                                <h3>Đội Ngũ</h3>
                                <p>
                                    Có kiến thức sâu rộng và kinh nghiệm đa dạng trong lĩnh vực xây dựng
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="feature-item">
                            <div class="feature-icon">
                                <i class="flaticon-building"></i>
                            </div>
                            <div class="feature-text">
                                <h3>Chất Lượng</h3>
                                <p>Dự án hoàn thiện với chất lượng đỉnh cao, đáp ứng và vượt qua kỳ vọng của khách hàng
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="feature-item">
                            <div class="feature-icon">
                                <i class="flaticon-call"></i>
                            </div>
                            <div class="feature-text">
                                <h3>Hỗ Trợ 24/7</h3>
                                <p>Luôn sẵn sàng hỗ trợ 24/7 để đảm bảo rằng mọi khía cạnh của dự án đều được quản lý
                                    một cách linh hoạt và hiệu quả</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Feature End-->


        <!-- About Start -->
        <div class="about wow fadeInUp" data-wow-delay="0.1s">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-5 col-md-6">
                        <div class="about-img">
                            <img src="WebPages/ViewWebPage/img/about.jpg" alt="Image">
                        </div>
                    </div>
                    <div class="col-lg-7 col-md-6">
                        <div class="section-header text-left">
                            <p> Chào mừng đến với TITAN</p>
                            <h2>25 năm kinh nghiệm</h2>
                        </div>
                        <div class="about-text">
                            <p>
                                Chúng tôi tự hào là đối tác đáng tin cậy, đem đến giải pháp xây dựng và dịch vụ chất
                                lượng cao, kết hợp sự hiểu biết sâu rộng và tầm nhìn đổi mới để đáp ứng mọi yêu cầu của
                                khách hàng. Cùng TITAN, chúng ta sẽ xây dựng tương lai bền vững và thịnh vượng.
                            </p>
                            <a class="btn" href="">Nhận Báo Giá</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- About End -->


        <!-- Fact Start -->
        <div class="fact">
            <div class="container-fluid">
                <div class="row counters">
                    <div class="col-md-6 fact-left wow slideInLeft">
                        <div class="row">
                            <div class="col-6">
                                <div class="fact-icon">
                                    <i class="flaticon-worker"></i>
                                </div>
                                <div class="fact-text">
                                    <h2 data-toggle="counter-up">109</h2>
                                    <p>Kỹ Sư Chuyên Nghiệp</p>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="fact-icon">
                                    <i class="flaticon-building"></i>
                                </div>
                                <div class="fact-text">
                                    <h2 data-toggle="counter-up">485</h2>
                                    <p>Khách Hàng Tin Chọn</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 fact-right wow slideInRight">
                        <div class="row">
                            <div class="col-6">
                                <div class="fact-icon">
                                    <i class="flaticon-address"></i>
                                </div>
                                <div class="fact-text">
                                    <h2 data-toggle="counter-up">789</h2>
                                    <p>Dự Án Đã Hoàn Thành</p>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="fact-icon">
                                    <i class="flaticon-crane"></i>
                                </div>
                                <div class="fact-text">
                                    <h2 data-toggle="counter-up">890</h2>
                                    <p>Dự Án Đang Thi Công</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fact End -->


        <!-- Service Start -->
        <div class="service">
            <div class="container">
                <div class="section-header text-center">
                    <p>Dịch Vụ</p>
                    <h2>TITAN mang đến một loạt các dịch vụ xây dựng đa dạng</h2>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                        <div class="service-item">
                            <div class="service-img">
                                <img src="WebPages/ViewWebPage/img/service-1.jpg" alt="Image">
                                <div class="service-overlay">
                                    <p>
                                        Với đội ngũ chuyên gia giàu kinh nghiệm, chúng tôi cung cấp dịch vụ xây nhà trọn
                                        gói, bao gồm từ thiết kế, thi công, đến hoàn thiện. Khách hàng của chúng tôi sẽ
                                        trải qua quá trình thuận tiện và không lo lắng, với cam kết về chất lượng và
                                        tiến độ. TITAN là đối tác đồng hành lý tưởng cho những người đang tìm kiếm sự
                                        thuận tiện và chất lượng trong quá trình xây dựng tổ ấm của mình.
                                    </p>
                                </div>
                            </div>
                            <div class="service-text">
                                <h3>xây Nhà Trọn Gói</h3>
                                <a class="btn" href="WebPages/ViewWebPage/img/service-1.jpg" data-lightbox="service">+</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
                        <div class="service-item">
                            <div class="service-img">
                                <img src="WebPages/ViewWebPage/img/service-2.jpg" alt="Image">
                                <div class="service-overlay">
                                    <p>
                                        Chúng tôi chuyên sâu trong việc cung cấp dịch vụ xây dựng nhà ở chất lượng cao,
                                        từ giai đoạn thiết kế đến hoàn thiện. Với đội ngũ kỹ sư và nhân viên chuyên
                                        nghiệp, chúng tôi cam kết đem lại không gian sống hoàn hảo, đáp ứng đầy đủ tiêu
                                        chí về thiết kế, an toàn và tiện nghi. Hãy để TITAN biến ước mơ về một tổ ấm
                                        hoàn hảo của bạn thành hiện thực.
                                    </p>
                                </div>
                            </div>
                            <div class="service-text">
                                <h3>Xây Nhà Hoàn Thiện</h3>
                                <a class="btn" href="WebPages/ViewWebPage/img/service-2.jpg" data-lightbox="service">+</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                        <div class="service-item">
                            <div class="service-img">
                                <img src="WebPages/ViewWebPage/img/service-3.jpg" alt="Image">
                                <div class="service-overlay">
                                    <p>
                                        Với sự chú tâm đặc biệt đến chi tiết và tiến độ, chúng tôi cam kết mang đến cho
                                        khách hàng không gian sống chưa hoàn thiện nhưng vững chắc, sẵn sàng để tận dụng
                                        sự sáng tạo và tùy chỉnh theo ý muốn cá nhân sau này. Hãy để TITAN giúp bạn xây
                                        dựng nền móng cho tổ ấm của mình.
                                    </p>
                                </div>
                            </div>
                            <div class="service-text">
                                <h3>Xây Nhà Phần Thô</h3>
                                <a class="btn" href="WebPages/ViewWebPage/img/service-3.jpg" data-lightbox="service">+</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.4s">
                        <div class="service-item">
                            <div class="service-img">
                                <img src="WebPages/ViewWebPage/img/service-4.jpg" alt="Image">
                                <div class="service-overlay">
                                    <p>
                                        Đội ngũ kiến trúc sư và kỹ sư của chúng tôi không chỉ có kinh nghiệm mà còn sáng
                                        tạo, đảm bảo rằng mỗi dự án đều phản ánh đặc điểm cá nhân của khách hàng. Với
                                        TITAN, chúng tôi cam kết mang lại những ngôi nhà phố hiện đại, thời thượng và
                                        đẳng cấp cho cộng đồng của bạn.
                                    </p>
                                </div>
                            </div>
                            <div class="service-text">
                                <h3>Xây Nhà Phố Hiện Đại</h3>
                                <a class="btn" href="WebPages/ViewWebPage/img/service-4.jpg" data-lightbox="service">+</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                        <div class="service-item">
                            <div class="service-img">
                                <img src="WebPages/ViewWebPage/img/service-5.jpg" alt="Image">
                                <div class="service-overlay">
                                    <p>
                                        Với đội ngũ kiến trúc sư và kỹ sư có tay nghề cao, chúng tôi đưa ra các giải
                                        pháp thiết kế sáng tạo và tiên tiến, kết hợp với chất lượng xây dựng hàng đầu.
                                        Hãy để TITAN biến ước mơ về một biệt thự hiện đại thành hiện thực, tạo nên không
                                        gian sống đẳng cấp và đẹp mắt cho gia đình bạn.
                                    </p>
                                </div>
                            </div>
                            <div class="service-text">
                                <h3>Xây Biệt Thự Hiện Đại</h3>
                                <a class="btn" href="WebPages/ViewWebPage/img/service-5.jpg" data-lightbox="service">+</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.6s">
                        <div class="service-item">
                            <div class="service-img">
                                <img src="WebPages/ViewWebPage/img/service-6.jpg" alt="Image">
                                <div class="service-overlay">
                                    <p>
                                        Với sự tận tâm đến chi tiết và chất lượng vật liệu, chúng tôi cam kết tái tạo
                                        không gian sống cổ điển với sự sang trọng và quyến rũ. TITAN không chỉ xây dựng
                                        biệt thự, mà còn tạo ra kiệt tác kiến trúc, làm nổi bật vẻ đẹp của thời kỳ cổ
                                        điển trong mỗi công trình.
                                    </p>
                                </div>
                            </div>
                            <div class="service-text">
                                <h3>Xây Biệt Thự Cổ Điển</h3>
                                <a class="btn" href="WebPages/ViewWebPage/img/service-6.jpg" data-lightbox="service">+</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Service End -->


        <!-- Video Start -->
        <div class="video wow fadeIn" data-wow-delay="0.1s">
            <div class="container">
                <button type="button" class="btn-play" data-toggle="modal"
                    data-src="https://www.youtube.com/embed/4BzjUq921Y4?si=gPKHLfxzSVs4O3k4" data-target="#videoModal">
                    <span></span>
                </button>
            </div>
        </div>

        <div class="modal fade" id="videoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <!-- 16:9 aspect ratio -->
                        <div class="embed-responsive embed-responsive-16by9">
                            <iframe class="embed-responsive-item" width="560" height="315" src="" id="video"
                                allowscriptaccess="always"
                                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                                allowfullscreen></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Video End -->


        <!-- Team Start -->
        <div class="team">
            <div class="container">
                <div class="section-header text-center">
                    <p>Đội Ngũ</p>
                    <h2>Gặp kỹ sư của chúng tôi</h2>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                        <div class="team-item">
                            <div class="team-img">
                                <img src="WebPages/ViewWebPage/img/team-1.jpg" alt="Team Image">
                            </div>
                            <div class="team-text">
                                <h2>Đỗ Hiếu</h2>
                                <p>CEO & Founder</p>
                            </div>
                            <div class="team-social">
                                <a class="social-tw" href=""><i class="fab fa-twitter"></i></a>
                                <a class="social-fb" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="social-li" href=""><i class="fab fa-linkedin-in"></i></a>
                                <a class="social-in" href=""><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
                        <div class="team-item">
                            <div class="team-img">
                                <img src="WebPages/ViewWebPage/img/team-2.jpg" alt="Team Image">
                            </div>
                            <div class="team-text">
                                <h2>Huy Phạm</h2>
                                <p>Kỹ sư xây dựng</p>
                            </div>
                            <div class="team-social">
                                <a class="social-tw" href=""><i class="fab fa-twitter"></i></a>
                                <a class="social-fb" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="social-li" href=""><i class="fab fa-linkedin-in"></i></a>
                                <a class="social-in" href=""><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                        <div class="team-item">
                            <div class="team-img">
                                <img src="WebPages/ViewWebPage/img/team-3.jpg" alt="Team Image">
                            </div>
                            <div class="team-text">
                                <h2>Nhật Hào</h2>
                                <p>Nhà thiết kế</p>
                            </div>
                            <div class="team-social">
                                <a class="social-tw" href=""><i class="fab fa-twitter"></i></a>
                                <a class="social-fb" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="social-li" href=""><i class="fab fa-linkedin-in"></i></a>
                                <a class="social-in" href=""><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.4s">
                        <div class="team-item">
                            <div class="team-img">
                                <img src="WebPages/ViewWebPage/img/team-4.jpg" alt="Team Image">
                            </div>
                            <div class="team-text">
                                <h2>Trọng Vương</h2>
                                <p>Kỹ sư xây dựng</p>
                            </div>
                            <div class="team-social">
                                <a class="social-tw" href=""><i class="fab fa-twitter"></i></a>
                                <a class="social-fb" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="social-li" href=""><i class="fab fa-linkedin-in"></i></a>
                                <a class="social-in" href=""><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Team End -->


        <!-- FAQs Start -->
        <div class="faqs">
            <div class="container">
                <div class="section-header text-center">
                    <p>Câu Hỏi Thường Gặp</p>
                    <h2>Bạn Có Thể Thắc Mắc</h2>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div id="accordion-1">
                            <div class="card wow fadeInLeft" data-wow-delay="0.1s">
                                <div class="card-header">
                                    <a class="card-link collapsed" data-toggle="collapse" href="#collapseOne">
                                        Bao gồm những gì trong báo giá xây dựng?
                                    </a>
                                </div>
                                <div id="collapseOne" class="collapse" data-parent="#accordion-1">
                                    <div class="card-body">
                                        Báo giá thường bao gồm chi phí vật liệu, nhân công và các dịch vụ khác liên quan
                                        đến công trình.
                                    </div>
                                </div>
                            </div>
                            <div class="card wow fadeInLeft" data-wow-delay="0.2s">
                                <div class="card-header">
                                    <a class="card-link collapsed" data-toggle="collapse" href="#collapseTwo">
                                        Làm thế nào để bạn đảm bảo an toàn công trình?
                                    </a>
                                </div>
                                <div id="collapseTwo" class="collapse" data-parent="#accordion-1">
                                    <div class="card-body">
                                        Chúng tôi thực hiện các biện pháp an toàn như đào tạo lao động, tuân thủ các
                                        tiêu chuẩn an toàn và thường xuyên kiểm tra an toàn tại công trường.
                                    </div>
                                </div>
                            </div>
                            <div class="card wow fadeInLeft" data-wow-delay="0.3s">
                                <div class="card-header">
                                    <a class="card-link collapsed" data-toggle="collapse" href="#collapseThree">
                                        Bạn có thể giải thích các chi phí phụ trợ không?
                                    </a>
                                </div>
                                <div id="collapseThree" class="collapse" data-parent="#accordion-1">
                                    <div class="card-body">
                                        Chi phí phụ trợ có thể bao gồm các chi phí như phí thiết kế, chi phí giấy phép
                                        xây dựng, và các chi phí pháp lý khác liên quan đến dự án.
                                    </div>
                                </div>
                            </div>
                            <div class="card wow fadeInLeft" data-wow-delay="0.4s">
                                <div class="card-header">
                                    <a class="card-link collapsed" data-toggle="collapse" href="#collapseFour">
                                        Bạn có hỗ trợ đăng ký giấy phép xây dựng không?
                                    </a>
                                </div>
                                <div id="collapseFour" class="collapse" data-parent="#accordion-1">
                                    <div class="card-body">
                                        Chúng tôi có thể hỗ trợ bạn trong việc chuẩn bị và nộp đơn đăng ký giấy phép xây
                                        dựng.
                                    </div>
                                </div>
                            </div>
                            <div class="card wow fadeInLeft" data-wow-delay="0.5s">
                                <div class="card-header">
                                    <a class="card-link collapsed" data-toggle="collapse" href="#collapseFive">
                                        Bạn có thể điều chỉnh nếu có thay đổi trong dự án không?
                                    </a>
                                </div>
                                <div id="collapseFive" class="collapse" data-parent="#accordion-1">
                                    <div class="card-body">
                                        Chúng tôi có thể xem xét và điều chỉnh báo giá nếu có thay đổi lớn trong yêu cầu
                                        hoặc quy mô của dự án.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div id="accordion-2">
                            <div class="card wow fadeInRight" data-wow-delay="0.1s">
                                <div class="card-header">
                                    <a class="card-link collapsed" data-toggle="collapse" href="#collapseSix">
                                        Làm thế nào để thanh toán chi phí xây dựng?
                                    </a>
                                </div>
                                <div id="collapseSix" class="collapse" data-parent="#accordion-2">
                                    <div class="card-body">
                                        Chúng tôi thường áp dụng các đợt thanh toán theo tiến độ công trình. Chi tiết sẽ
                                        được thảo luận trong hợp đồng.
                                    </div>
                                </div>
                            </div>
                            <div class="card wow fadeInRight" data-wow-delay="0.2s">
                                <div class="card-header">
                                    <a class="card-link collapsed" data-toggle="collapse" href="#collapseSeven">
                                        Bạn làm việc với các nhà thầu phụ không?
                                    </a>
                                </div>
                                <div id="collapseSeven" class="collapse" data-parent="#accordion-2">
                                    <div class="card-body">
                                        Chúng tôi thường làm việc với các nhà thầu phụ chuyên nghiệp và đảm bảo họ tuân
                                        thủ các tiêu chuẩn chất lượng.
                                    </div>
                                </div>
                            </div>
                            <div class="card wow fadeInRight" data-wow-delay="0.3s">
                                <div class="card-header">
                                    <a class="card-link collapsed" data-toggle="collapse" href="#collapseEight">
                                        Bạn có bảo hiểm và giấy phép đầy đủ không?
                                    </a>
                                </div>
                                <div id="collapseEight" class="collapse" data-parent="#accordion-2">
                                    <div class="card-body">
                                        Chúng tôi có bảo hiểm và giấy phép cần thiết để thực hiện công việc xây dựng.
                                    </div>
                                </div>
                            </div>
                            <div class="card wow fadeInRight" data-wow-delay="0.4s">
                                <div class="card-header">
                                    <a class="card-link collapsed" data-toggle="collapse" href="#collapseNine">
                                        Bạn sẽ cung cấp bảng báo giá hay là báo giá chi tiết?
                                    </a>
                                </div>
                                <div id="collapseNine" class="collapse" data-parent="#accordion-2">
                                    <div class="card-body">
                                        Chúng tôi có thể cung cấp cả hai, tùy thuộc vào yêu cầu của bạn. Bảng báo giá
                                        thường ngắn gọn, trong khi báo giá chi tiết sẽ cung cấp thông tin chi tiết hơn.
                                    </div>
                                </div>
                            </div>
                            <div class="card wow fadeInRight" data-wow-delay="0.5s">
                                <div class="card-header">
                                    <a class="card-link collapsed" data-toggle="collapse" href="#collapseTen">
                                        Bạn cung cấp bảo hành cho công trình không?
                                    </a>
                                </div>
                                <div id="collapseTen" class="collapse" data-parent="#accordion-2">
                                    <div class="card-body">
                                        Chúng tôi thường cung cấp bảo hành cho công trình để đảm bảo chất lượng và sự
                                        hài lòng của khách hàng. Thời gian bảo hành có thể khác nhau tùy theo loại công
                                        trình.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- FAQs End -->


        <!-- Testimonial Start -->
        <div class="testimonial wow fadeIn" data-wow-delay="0.1s">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="testimonial-slider-nav">
                            <div class="slider-nav"><img src="WebPages/ViewWebPage/img/testimonial-1.jpg" alt="Testimonial"></div>
                            <div class="slider-nav"><img src="WebPages/ViewWebPage/img/testimonial-2.jpg" alt="Testimonial"></div>
                            <div class="slider-nav"><img src="WebPages/ViewWebPage/img/testimonial-3.jpg" alt="Testimonial"></div>
                            <div class="slider-nav"><img src="WebPages/ViewWebPage/img/testimonial-4.jpg" alt="Testimonial"></div>
                            <div class="slider-nav"><img src="WebPages/ViewWebPage/img/testimonial-1.jpg" alt="Testimonial"></div>
                            <div class="slider-nav"><img src="WebPages/ViewWebPage/img/testimonial-2.jpg" alt="Testimonial"></div>
                            <div class="slider-nav"><img src="WebPages/ViewWebPage/img/testimonial-3.jpg" alt="Testimonial"></div>
                            <div class="slider-nav"><img src="WebPages/ViewWebPage/img/testimonial-4.jpg" alt="Testimonial"></div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="testimonial-slider">
                            <div class="slider-item">
                                <h3>Trần Văn An</h3>
                                <h4>Chuyên Nghiệp</h4>
                                <p>"Tôi rất vui vẻ và hài lòng với dịch vụ xây dựng của công ty. Nhóm làm việc chuyên
                                    nghiệp, linh hoạt và thân thiện. Dự án của tôi đã được hoàn thành đúng tiến độ và
                                    chất lượng tốt."</p>
                            </div>
                            <div class="slider-item">
                                <h3>Nguyễn Thị Linh</h3>
                                <h4>Nhiệt Tình</h4>
                                <p>"Tôi đánh giá cao tinh thần nhiệt tình và chuyên nghiệp của đội ngũ xây dựng. Họ luôn
                                    lắng nghe ý kiến của tôi và giải quyết mọi vấn đề một cách nhanh chóng. Dự án của
                                    tôi được thực hiện một cách xuất sắc."</p>
                            </div>
                            <div class="slider-item">
                                <h3>Lê Minh Tuấn </h3>
                                <h4>Tận Tâm</h4>
                                <p>"Cảm ơn công ty TITAN vì sự tận tâm và chăm sóc đặc biệt trong suốt quá trình xây
                                    dựng. Họ luôn giữ liên lạc chặt chẽ và đảm bảo rằng mọi yêu cầu của tôi đều được đáp
                                    ứng."</p>
                            </div>
                            <div class="slider-item">
                                <h3>Phạm Thị Hương</h3>
                                <h4>Chuyên Nghiệp</h4>
                                <p>"Đội ngũ xây dựng chuyên nghiệp và có kiến thức sâu rộng. Dự án của tôi được quản lý
                                    một cách hiệu quả, từ thiết kế cho đến hoàn thiện. Tôi tin tưởng vào chất lượng của
                                    công ty."</p>
                            </div>
                            <div class="slider-item">
                                <h3>Hoàng Văn Thắng</h3>
                                <h4>Uy Tín</h4>
                                <p>"Công ty TITAN này đúng là đáng tin cậy. Họ giữ lời hứa, không có chi phí ẩn, và công
                                    việc được thực hiện theo đúng tiến độ. Tôi rất hài lòng và sẽ giới thiệu cho bạn
                                    bè."</p>
                            </div>
                            <div class="slider-item">
                                <h3>Ngọc Thị Mai</h3>
                                <h4>Chất Lượng</h4>
                                <p>"Chất lượng là điều mà tôi ấn tượng nhất về công ty xây dựng này. Vật liệu và công
                                    việc thi công đều rất chất lượng. Dự án của tôi trở nên hoàn hảo hơn nhờ sự chăm sóc
                                    tỉ mỉ."</p>
                            </div>
                            <div class="slider-item">
                                <h3>Nguyễn Đức Anh</h3>
                                <h4>Linh Hoạt</h4>
                                <p>"Tôi thực sự đánh giá cao tính linh hoạt của công ty. Họ linh hoạt thích ứng với các
                                    thay đổi trong dự án và giúp tôi thực hiện những điều tôi muốn một cách hiệu quả."
                                </p>
                            </div>
                            <div class="slider-item">
                                <h3>Đỗ Thị Ngọc Linh</h3>
                                <h4>Hiệu Quả</h4>
                                <p>"Công ty xây dựng này hoạt động rất hiệu quả. Tôi ấn tượng với sự tổ chức và quản lý
                                    dự án, giúp tiết kiệm thời gian và chi phí. Dịch vụ chất lượng cao với giá trị đáng
                                    kinh ngạc."</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Testimonial End -->


        <!-- Blog Start -->
        <div class="blog">
            <div class="container">
                <div class="section-header text-center">
                    <p>Tin tức</p>
                    <h2>Mới Cập Nhật</h2>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
                        <div class="blog-item">
                            <div class="blog-img">
                                <img src="WebPages/ViewWebPage/img/blog-1.jpg" alt="Image">
                            </div>
                            <div class="blog-title">
                                <h3>Kiến Trúc Xây Dựng</h3>
                                <a class="btn" href="">+</a>
                            </div>
                            <div class="blog-meta">
                                <p>By<a href="">Admin</a></p>
                                <p>In<a href="">Construction</a></p>
                            </div>
                            <div class="blog-text">
                                <p>
                                    27+ Mẫu Thiết Kế Biệt Thự Hiện Đại Có Bể Bơi Độc Đáo Và Ấn Tượng 2023
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow fadeInUp">
                        <div class="blog-item">
                            <div class="blog-img">
                                <img src="WebPages/ViewWebPage/img/blog-2.jpg" alt="Image">
                            </div>
                            <div class="blog-title">
                                <h3>Kiến Trúc Xây Dựng</h3>
                                <a class="btn" href="">+</a>
                            </div>
                            <div class="blog-meta">
                                <p>By<a href="">Admin</a></p>
                                <p>In<a href="">Construction</a></p>
                            </div>
                            <div class="blog-text">
                                <p>
                                    Công ty thiết kế xây dựng biệt thự chuyên nghiệp TITAN
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
                        <div class="blog-item">
                            <div class="blog-img">
                                <img src="WebPages/ViewWebPage/img/blog-3.jpg" alt="Image">
                            </div>
                            <div class="blog-title">
                                <h3>Kiến Trúc Xây Dựng</h3>
                                <a class="btn" href="">+</a>
                            </div>
                            <div class="blog-meta">
                                <p>By<a href="">Admin</a></p>
                                <p>In<a href="">Construction</a></p>
                            </div>
                            <div class="blog-text">
                                <p>
                                    Mãn nhãn với TOP 10 nội thất biệt thự đẹp nhất thế giới
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Blog End -->


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
</body>
</html>
